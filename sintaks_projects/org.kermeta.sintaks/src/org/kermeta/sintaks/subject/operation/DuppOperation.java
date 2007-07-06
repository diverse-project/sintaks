package org.kermeta.sintaks.subject.operation;

import org.kermeta.sintaks.subject.ModelSubject;


public class DuppOperation extends R1W0Operation {

	public DuppOperation() {
		super();
	}

	protected void execWithParam (ModelSubject model, Object param) {
		model.push(param);
		model.push(param);
	}

	@Override
	public String toString() {
		StringBuffer tmp = new StringBuffer ();
		tmp.append("DuppOperation : ");
		return tmp.toString();
	}
}
