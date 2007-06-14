package org.kermeta.sintaks.subject.operation;

import org.kermetal.sintaks.subject.ModelSubject;


public class SetAccuOperation extends R1W0Operation {

	public SetAccuOperation() {
		super();
	}

	protected void execWithParam (ModelSubject model, Object param) {
		model.setAccumulator(param);
	}


	@Override
	public String toString() {
		StringBuffer tmp = new StringBuffer ();
		tmp.append("SetAccuOperation : ");
		return tmp.toString();
	}

}
