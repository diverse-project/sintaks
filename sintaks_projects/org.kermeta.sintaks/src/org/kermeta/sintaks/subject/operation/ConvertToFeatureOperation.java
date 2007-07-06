package org.kermeta.sintaks.subject.operation;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.kermeta.sintaks.subject.ModelSubject;


public class ConvertToFeatureOperation extends R1W1Operation {

	private EStructuralFeature feature;

	public ConvertToFeatureOperation(EStructuralFeature feature) {
		super();
		this.feature = feature;
	}

	@Override
	protected Object execWithParam(ModelSubject model, Object param) {
		Object value = param;

		return CommonOperation.convertToType(feature, value);
	}

	@Override
	public String toString() {
		StringBuffer tmp = new StringBuffer ();
		tmp.append("ConvertToFeatureOperation : ");
		tmp.append(feature.getName());
		return tmp.toString();
	}

}
