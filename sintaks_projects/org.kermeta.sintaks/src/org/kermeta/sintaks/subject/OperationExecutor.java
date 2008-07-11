/* $Id: OperationExecutor.java,v 1.1 2008-07-11 07:33:27 hassen Exp $
 * Project    : Sintaks
 * File       : OperationExecutor.java
 * License    : EPL
 * Copyright  : IRISA / INRIA / Universite de Haute Alsace
 * -------------------------------------------------------------------
 * Creation date : 9 juillet 2008
 * Authors : 
 * 			Michel Hassenforder <michel.hassenforder@uha.fr>
 */
package org.kermeta.sintaks.subject;

import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.kermeta.sintaks.SintaksPlugin;
import org.kermeta.sintaks.errors.UserError;
import org.kermeta.sintaks.subject.operation.CommonOperation;

public class OperationExecutor {

	/**
	 * Creates a class using the metaClass and pushes it on the stack maintained by the given model
	 *
	 * @param metaClass EClass the EClass to create 
	 * @param model ModelSubject the model to update 
	 *
	 * @state look like the CreateClassOperation
	 */
	static public void createClass (ModelSubject model, EClass metaClass) {
		EPackage metaClassPackage = (EPackage) metaClass.eContainer();
		if(metaClassPackage == null && metaClass.eIsProxy()){
			// pb MM is not registered
			throw new UserError("Cannot build model because the metamodel is not correctly registered.");
		}
		EFactory fact = metaClassPackage.getEFactoryInstance();
		model.push (fact.create(metaClass));
	}

	/**
	 * Look up the stack of the model under construction to find a target suitable for the feature
	 *
	 * @param feature EStructuralFeature the feature to find 
	 * @param model ModelSubject the model to search for 
	 * @param depth a depth to skip some items in the stack 
	 *
	 * @state look like the FindTargetOperation
	 * @state but depth is set to 0, seems now to be removed as the stack do not store trash values
	 */
	static private EObject findTarget (ModelSubject model, EStructuralFeature feature, int depth) {
		List<Object> stack = model.getStack();
		depth=0;
		int size = stack.size()-1 - depth;
		for (int i=size; i>=0; --i) {
			Object crt = stack.get(i);
			try {
				EObject target = (EObject) crt;
				if (target.eClass().getFeatureID(feature) != -1) {
					if (SintaksPlugin.getDefault().getOptionManager().isDebugModel()) {
						SintaksPlugin.getDefault().debugln("Target usable : "+target);
					}
					return target;
				} else {
					if (SintaksPlugin.getDefault().getOptionManager().isDebugModel()) {
						SintaksPlugin.getDefault().debugln("Target unusable : "+crt);
					}
				}
			}
			catch (Exception e) {
				if (SintaksPlugin.getDefault().getOptionManager().isDebugModel()) {
					SintaksPlugin.getDefault().debugln("Target unusable : "+crt);
				}
			}
		}
		return null;
	}

	/**
	 * Create a Ghost and refers all information required to update the Ghost as the real object arrives
	 *
	 * @param from EStructuralFeature the feature used to find a source object
	 * @param to EStructuralFeature the feature used as a key to find a target object
	 * @param model ModelSubject the model to search for 
	 * @param value String the value of the to feature 
	 *
	 * @state look like the CreateGhostOperation and the buildCreateGhost in the OperationBuilder
	 */
	static private void createGhost(ModelSubject model, EStructuralFeature from, EStructuralFeature to, String value) {
    	EObject target = findTarget (model, from, 0);
    	model.getGhosts().add(new Ghost (from, to, value, target));
	}

	/**
	 * Create a list of Ghosts
	 * 
	 * @param from EList the feature used to find a source object
	 * @param to EStructuralFeature the feature used as a key to find a target object
	 * @param model ModelSubject the model to search for 
	 * @param value String the value of the to feature 
	 *
	 * @state look like the buildCreateGhosts in the OperationBuilder
	 */
	static public void createGhosts (ModelSubject model, EList<EStructuralFeature> from, EStructuralFeature to, String value) {
		switch (from.size()) {
		case 0 : break;
		case 1 : createGhost (model, (EStructuralFeature) from.get(0), to, value);
				 break;
		default:
			Iterator<EStructuralFeature> it = from.iterator();
	        while(it.hasNext()) {
	        	EStructuralFeature feature = (EStructuralFeature) it.next();
	        	createGhost (model, feature, to, value);
	        }
	        break;
		}
	}

	/**
	 * Mark the model stack position
	 * 
	 * @param model ModelSubject the model to use 
	 * @return int the current position
	 *
	 * @state look like the MarkOperation
	 */
	static public int mark (ModelSubject model) {
		return model.size();
	}

	/**
	 * GotoMark set model stack at a given position
	 * 
	 * @param model ModelSubject the model to use 
	 * @param position int the position to reach
	 *
	 * @state look like the GotoMarkOperation
	 */
	static public void gotoMark (ModelSubject model, int position) {
		int crtPosition = model.size();
		for (int index=crtPosition; index < position; --index) {
			model.pop();
		}
	}

	/**
	 * Push something onto the model stack 
	 * 
	 * @param model ModelSubject the model to use 
	 * @param value Object the value to push 
	 *
	 * @state look like the PushOperation
	 */
	static public void push (ModelSubject model, Object value) {
		model.push(value);
	}

	/**
	 * Pop something from the model stack 
	 * 
	 * @param model ModelSubject the model to use 
	 * @return value the popped Object
	 * 
	 * @state look like the PopOperation
	 */
	static public Object pop (ModelSubject model) {
		return model.pop();
	}

	/**
	 * Get the top of the model stack 
	 * 
	 * @param model ModelSubject the model to use 
	 * @return Object on the top
	 * 
	 */
	static public Object top (ModelSubject model) {
		return model.top();
	}

	/**
	 * Find an object in the model given a value for a given feature 
	 * 
	 * @param model ModelSubject the model to search for 
	 * @param feature EStructuralFeature the feature used as a key to find a target object
	 * @param value String the value of the feature 
	 * @return value EObject the founded object
	 *
	 * @state look like the FindInstanceOperation
	 */
	static public EObject findInstance (ModelSubject model, EStructuralFeature feature, String value) {
		return CommonOperation.findInstance(model.getModel (), feature, value);
	}

	/**
	 * Sets a feature to a value on an object
	 * 
	 * @param feature EStructuralFeature the feature to set
	 * @param value Object the value of the feature 
	 * @param target EObject the object to set
	 *
	 * @state look like the SetFeatureOperation
	 */
	@SuppressWarnings("unchecked")
	static private void setFeature (EStructuralFeature feature, Object value, EObject target) {
		if (SintaksPlugin.getDefault().getOptionManager().isDebugModel()) {
			PrintStream debugStream = SintaksPlugin.getDefault().getDebugStream();
			debugStream.println("SetAttribute : ");
			debugStream.println("   On        : "+target);
			debugStream.println("   Attribute : "+feature);
			debugStream.println("   Value     : "+value);
        }
    	if (feature.isMany()) {
	   		EList<Object> list = (EList<Object>) target.eGet(feature);
			list.add(value);
		} else {
			target.eSet(feature, value);
		}
	}
	
	/**
	 * Gets the value of a feature on an object
	 * 
	 * @param feature EStructuralFeature the feature to set
	 * @param target EObject the object to set
	 * @return value the value of the feature 
	 *
	 * @state look like the GetFeatureOperation
	 */
	static private Object getFeature (EStructuralFeature feature, EObject target) {
		if (SintaksPlugin.getDefault().getOptionManager().isDebugModel()) {
			PrintStream debugStream = SintaksPlugin.getDefault().getDebugStream();
			debugStream.println("GetAttribute : ");
			debugStream.println("   On        : "+target);
			debugStream.println("   Attribute : "+feature);
        }
    	return target.eGet(feature);
	}
	
	/**
	 * Convert a value to a type suitable to a feature
	 * 
	 * @param feature EStructuralFeature the feature to use
	 * @param value Object the value of the feature 
	 * @return value Object the converted value
	 *
	 * @state look like the ConvertToFeatureOperation
	 */
	static protected Object convertToFeature (EStructuralFeature feature, Object value) {
		return CommonOperation.convertToType(feature, value);
	}

	/**
	 * Set a feature with the given value
	 * First convert the value to a suitable one for the feature
	 * Second scan the stack about a target object able to use the feature
	 * Last sets the feature
	 * 
	 * @param model ModelSubject the model to search for 
	 * @param feature EStructuralFeature the feature to use
	 * @param value Object the value to use
	 *
	 */
	static public void setFeature (ModelSubject model, EStructuralFeature feature, Object value) {
		Object converted = convertToFeature (feature, value);
		EObject target = findTarget (model, feature, 1);
		setFeature (feature, converted, target);
	}
	
	/**
	 * Set a feature with the value at the top of stack
	 * 
	 * @param model ModelSubject the model to search for 
	 * @param feature EStructuralFeature the feature to use
	 *
	 * @state look like the buildSetFeature in the OperationBuilder

	 */
	static public void setFeature (ModelSubject model, EStructuralFeature feature) {
		setFeature (model, feature, pop(model));
	}
	
	/**
	 * Set a collection of features with the value at the top of stack
	 * 
	 * @param model ModelSubject the model to search for 
	 * @param feature EList<EStructuralFeature> the features to use
	 *
	 * @state look like the buildSetFeatures in the OperationBuilder
	 */
	static public void setFeatures (ModelSubject model, EList<EStructuralFeature> features) {
		setFeatures (model, features, pop(model));
	}
	
	/**
	 * Set a collection of features with a value
	 * 
	 * @param model ModelSubject the model to search for 
	 * @param feature EList<EStructuralFeature> the features to use
	 * @param value Object the value to use... after conversion
	 *
	 * @state look like the buildSetFeatures in the OperationBuilder
	 */
	static public void setFeatures (ModelSubject model, EList<EStructuralFeature> features, Object value) {
		switch (features.size()) {
		case 0 :
			break;
		case 1 :
			setFeature (model, features.get(0), value);
			break;
		default:
			Iterator<EStructuralFeature> it = features.iterator();
	        while(it.hasNext()) {
	        	EStructuralFeature feature = it.next();
				setFeature (model, feature, value);
	        }
	        break;
		}
	}

	/**
	 * Get a feature 
	 * 
	 * @param model ModelSubject the model to search for 
	 * @param feature EStructuralFeature the features to use
	 *
	 * @state look like the buildGetFeature in the OperationBuilder
	 */
	static public Object getFeature (ModelSubject model, EStructuralFeature feature) {
		EObject target = findTarget (model, feature, 0);
		Object value = getFeature (feature, target);
		return value;
	}

	/**
	 * Get the value of the first feature of a collection
	 * 
	 * @param model ModelSubject the model to search for 
	 * @param features EList<EStructuralFeature> the features to use
	 *
	 */
	static public Object getFeatures (ModelSubject model, EList<EStructuralFeature> features) {
		switch (features.size()) {
		case 0 :
			return null;
		default:
			return getFeature (model, features.get(0));
		}
	}

}
