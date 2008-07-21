/* $Id: OperationExecutor.java,v 1.2 2008-07-21 15:14:21 hassen Exp $
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

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.kermeta.sintaks.SintaksPlugin;
import org.kermeta.sintaks.errors.UserError;
import org.kermeta.sintaks.subject.operation.CommonOperation;

public class OperationExecutor {

	/**
	 * Internal Method to friendly print an EClassifier
	 *
	 * @param aClassifier EClassifier the EClassifier to print 
	 *
	 */
	static private String classifierToString (EClassifier aClassifier) {
		if (aClassifier == null) return "(null)";
		StringBuffer tmp = new StringBuffer ();
		EPackage p = aClassifier.getEPackage();
		while (p != null) {
			tmp.append(p.getName());
			tmp.append(".");
			p = p.getESuperPackage();
		}
		tmp.append(aClassifier.getName());
		return tmp.toString();
	}
	
	/**
	 * Internal Method to friendly print anEObject
	 *
	 * @param object EObject the EObject to print 
	 *
	 */
	static private String eObjectToString (EObject object) {
		if (object == null) return "(null)";
		StringBuffer tmp = new StringBuffer ();
		tmp.append(classifierToString(object.eClass()));
		tmp.append("@");
		tmp.append(Integer.toHexString(object.hashCode()));
		return tmp.toString();
	}
	
	/**
	 * Internal Method to friendly print an Object
	 *
	 * @param object Object the Object to print 
	 *
	 */
	static private String objectToString (Object object) {
		if (object == null) return "(null)";
		if (object instanceof EObject) return eObjectToString ((EObject) object);
		StringBuffer tmp = new StringBuffer ();
		tmp.append(object.getClass().toString());
		tmp.append("@");
		tmp.append(Integer.toHexString(object.hashCode()));
		if (	   object instanceof Boolean
				|| object instanceof Byte
				|| object instanceof Character
				|| object instanceof Double
				|| object instanceof Float
				|| object instanceof Integer
				|| object instanceof Long
				|| object instanceof Short
				|| object instanceof String) {
			tmp.append("=");
			tmp.append(object.toString());
		}
		return tmp.toString();
	}
	
	/**
	 * Internal Method to friendly print a Feature
	 *
	 * @param feature EStructuralFeature the EStructuralFeature to print 
	 *
	 */
	static private String featureToString (EStructuralFeature feature) {
		if (feature == null) return "(null)";
		StringBuffer tmp = new StringBuffer ();
		tmp.append(classifierToString(feature.getEContainingClass()));
		tmp.append('.');
		tmp.append(feature.getName());
		tmp.append('[');
		tmp.append(feature.getLowerBound());
		tmp.append("..");
		tmp.append(feature.getUpperBound());
		tmp.append(']');
		tmp.append(':');
		tmp.append(classifierToString (feature.getEType()));
		return tmp.toString();
	}
	
	/**
	 * Internal Method to friendly print a Ghost
	 *
	 * @param ghost Ghost the Ghost to print 
	 *
	 */
	static private String ghostToString (Ghost ghost) {
		if (ghost == null) return "(null)";
		StringBuffer tmp = new StringBuffer ();
		tmp.append("target ");
		tmp.append(eObjectToString(ghost.getFromObject()));
		tmp.append("from ");
		tmp.append(featureToString(ghost.getFrom()));
		tmp.append("to ");
		tmp.append(featureToString(ghost.getTo()));
		tmp.append("value ");
		tmp.append(ghost.getValue());
		return tmp.toString();
	}
	
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
		if (SintaksPlugin.getDefault().getOptionManager().isDebugModel()) {
			SintaksPlugin.getDefault().getTracer().add("createClass " + classifierToString (metaClass));
		}
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
						SintaksPlugin.getDefault().getTracer().add("findTarget founded " + eObjectToString(target));
					}
					return target;
				}
			}
			catch (Exception e) {
			}
		}
		if (SintaksPlugin.getDefault().getOptionManager().isDebugModel()) {
			SintaksPlugin.getDefault().getTracer().add("findTarget founded nothing");
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
    	Ghost ghost = new Ghost (from, to, value, target);
		if (SintaksPlugin.getDefault().getOptionManager().isDebugModel()) {
			SintaksPlugin.getDefault().getTracer().add("createGhost " + ghostToString(ghost));
		}
		model.getGhosts().add(ghost);
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
		if (SintaksPlugin.getDefault().getOptionManager().isDebugModel()) {
			SintaksPlugin.getDefault().getTracer().add("createGhosts #" + from.size());
		}
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
		EObject o = CommonOperation.findInstance(model.getModel (), feature, value);
		if (SintaksPlugin.getDefault().getOptionManager().isDebugModel()) {
			SintaksPlugin.getDefault().getTracer().add("findInstance " + eObjectToString (o));
		}
		return o;
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
	        SintaksPlugin.getDefault().getTracer().add("setFeature  : " + featureToString(feature));
	        SintaksPlugin.getDefault().getTracer().add(" on target  : " + eObjectToString (target));
	        SintaksPlugin.getDefault().getTracer().add(" with value : " + objectToString (value));
        }
    	if (feature.isMany()) {
	   		EList<Object> list = (EList<Object>) target.eGet(feature);
			list.add(value);
		} else {
			target.eSet(feature, value);
		}
	}
	
	/**
	 * Replace a feature to a new value on an object
	 * 
	 * @param feature EStructuralFeature the feature to set
	 * @param value EObject the new value of the feature 
	 * @param target EObject the object to set
	 *
	 */
	@SuppressWarnings("unchecked")
	static private void replaceFeature (EStructuralFeature feature, EObject value, EObject target) {
		if (SintaksPlugin.getDefault().getOptionManager().isDebugModel()) {
	        SintaksPlugin.getDefault().getTracer().add("replaceFeature  : " + featureToString(feature));
	        SintaksPlugin.getDefault().getTracer().add("     on target  : " + eObjectToString (target));
	        SintaksPlugin.getDefault().getTracer().add("     with value : " + objectToString (value));
        }
        EcoreUtil.replace(target, feature, null, value);
	}
	
	/**
	 * Try to relink a Ghost
	 * 
	 * @param model ModelSubject the model to search for 
	 * @param ghost Ghost the ghost to relink
	 * @return the success of the operation
	 *
	 */
	static public boolean relinkGhost (ModelSubject model, Ghost ghost) {
        EObject instance = findInstance (model, ghost.getTo(), ghost.getValue());
        if (instance == null) return false;
        EStructuralFeature feature = ghost.getFrom();
        if (feature == null) return false;
        EObject target = ghost.getFromObject();
        replaceFeature (feature, instance, target);
        return true;
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
    	Object value = target.eGet(feature);
		if (SintaksPlugin.getDefault().getOptionManager().isDebugModel()) {
	        SintaksPlugin.getDefault().getTracer().add("getFeature : " + featureToString(feature));
	        SintaksPlugin.getDefault().getTracer().add(" on target : " + eObjectToString (target));
	        SintaksPlugin.getDefault().getTracer().add(" has value : " + objectToString (value));
        }
    	return value;
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
		if (SintaksPlugin.getDefault().getOptionManager().isDebugModel()) {
	        SintaksPlugin.getDefault().getTracer().add("convertToFeature : "+featureToString(feature));
	        SintaksPlugin.getDefault().getTracer().add("      with value : " + objectToString (value));
        }
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
		if (SintaksPlugin.getDefault().getOptionManager().isDebugModel()) {
			SintaksPlugin.getDefault().getTracer().add("setFeatures #" + features.size());
		}
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
		if (SintaksPlugin.getDefault().getOptionManager().isDebugModel()) {
			SintaksPlugin.getDefault().getTracer().add("getFeatures #" + features.size());
		}
		switch (features.size()) {
		case 0 :
			return null;
		default:
			return getFeature (model, features.get(0));
		}
	}

}
