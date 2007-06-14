package org.kermeta.sintaks.subject.operation;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.kermetal.sintaks.subject.ModelSubject;


public class ConvertFromFeatureOperation extends R1W1Operation {

	private EStructuralFeature feature;

	public ConvertFromFeatureOperation(EStructuralFeature feature) {
		super();
		this.feature = feature;
	}

	@Override
	protected Object execWithParam (ModelSubject model, Object param) {
		Object value = param;

		return CommonOperation.convertFromType(feature, value);
	}

	@Override
	public String toString() {
		StringBuffer tmp = new StringBuffer ();
		tmp.append("ConvertFromFeatureOperation : ");
		tmp.append(feature.getName());
		return tmp.toString();
	}

}
