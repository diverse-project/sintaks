package org.kermeta.sintaks.subject.operation;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.kermeta.sintaks.SintaksPlugin;


public class CommonOperation {

	static public Object convertFromType (EStructuralFeature eFeature, Object value) {
		if (value instanceof EList) {
// no conversion should be required
			return value;
		}
		EClassifier type = eFeature.getEType();
		if (type instanceof EClass) {
// no conversion should be required
			return value;
		}
		if (type instanceof EDataType) {
// String to eType conversion required
			EDataType dataType = (EDataType) type;
			if (dataType.isSerializable()) {
				EFactory factory = type.getEPackage().getEFactoryInstance();
				return factory.convertToString(dataType, value);
			} else {
				SintaksPlugin.getDefault().debugln("    created  : noserialisable");
				return null;
			}
		}
		return null;
	}

	static public Object convertToType (EStructuralFeature eFeature, Object value) {
		if (value instanceof EList) {
// no conversion should be required
			return value;
		}
		EClassifier type = eFeature.getEType();
		if (type instanceof EClass) {
// no conversion should be required
			return value;
		}
		if (type instanceof EDataType) {
// String to eType conversion required
			EDataType dataType = (EDataType) type;
			if (dataType.isSerializable()) {
				EFactory factory = type.getEPackage().getEFactoryInstance();
				return factory.createFromString(dataType, (value == null) ? null : value.toString());
			} else {
				SintaksPlugin.getDefault().debugln("    created  : noserialisable");
				return null;
			}
		}
		return null;
	}

	static public EObject findInstance (EObject model, EStructuralFeature feature, String text) {
		TreeIterator<EObject> i = model.eAllContents();
        while (i.hasNext()) {
        	EObject eo = (EObject) i.next();
            EClass ec = (EClass) eo.eClass();
            //TODO a verifier si c'est dans le bon ordre ...
            // feature.getEContainingClass().isSuperTypeOf (ec)
            if (ec.isSuperTypeOf(feature.getEContainingClass())) {
            	EStructuralFeature sf = ec.getEStructuralFeature(feature.getName());
    			if (eo.eIsSet(sf)) {
    				Object value = eo.eGet(sf);
    				Object converted = CommonOperation.convertFromType(sf, value);
    				if (converted.equals(text)) {
    				    return eo;
                       }
                }
            }
        }
        return null;
	}

	
}
