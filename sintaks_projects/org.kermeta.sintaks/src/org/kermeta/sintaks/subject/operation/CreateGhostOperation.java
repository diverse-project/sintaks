package org.kermeta.sintaks.subject.operation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.kermeta.sintaks.subject.Ghost;
import org.kermeta.sintaks.subject.ModelSubject;


public class CreateGhostOperation extends R1W0Operation {

	private EStructuralFeature from;
	private EStructuralFeature to;
	private String value;

	public CreateGhostOperation(EStructuralFeature from, EStructuralFeature to, String value) {
		super();
		this.from  = from;
		this.to    = to;
		this.value = value;
	}

	public void execWithParam(ModelSubject model, Object param) {
		EObject target = (EObject) param;
		model.getGhosts().add(new Ghost (from, to, value, target));
	}

	@Override
	public String toString() {
		StringBuffer tmp = new StringBuffer ();
		tmp.append("CreateGhostOperation : ");
		tmp.append("from="); tmp.append(from.getName());
		tmp.append("to=");   tmp.append(to.getName());
		tmp.append("value=");tmp.append(value);
		return tmp.toString();
	}
}
