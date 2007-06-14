package org.kermeta.sintaks.subject.operation;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.kermetal.sintaks.subject.ModelSubject;


public class FindInstanceOperation extends R0W1Operation {

	private EStructuralFeature feature;
	private String text;
	
	public FindInstanceOperation(EStructuralFeature feature, String text) {
		super();
		this.feature = feature;
		this.text = text;
	}

	public Object execWithParam (ModelSubject model) {
		return CommonOperation.findInstance(model.getModel (), feature, text);
	}

	@Override
	public String toString() {
		StringBuffer tmp = new StringBuffer ();
		tmp.append("FindInstanceOperation : ");
		tmp.append(feature.getName());
		tmp.append("text="); tmp.append(text);
		return tmp.toString();
	}
}
