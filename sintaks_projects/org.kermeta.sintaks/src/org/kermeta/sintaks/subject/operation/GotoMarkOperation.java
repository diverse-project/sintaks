package org.kermeta.sintaks.subject.operation;

import org.kermeta.sintaks.subject.ModelSubject;


public class GotoMarkOperation extends R1W0Operation {

	public GotoMarkOperation() {
		super();
	}

	protected void execWithParam (ModelSubject model, Object param) {
		int oldPosition = ((Integer) param).intValue();
		int crtPosition = model.size();
		for (int i=crtPosition; i < oldPosition; --i) {
			model.pop();
		}
	}


	@Override
	public String toString() {
		StringBuffer tmp = new StringBuffer ();
		tmp.append("GotoMarkOperation : ");
		return tmp.toString();
	}

}
