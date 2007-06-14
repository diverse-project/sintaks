package org.kermeta.sintaks.subject.operation;

import org.kermetal.sintaks.subject.ModelSubject;


public class PopOperation extends R1W0Operation {

	public PopOperation() {
		super();
	}

	public void execWithParam(ModelSubject model, Object param) {
	}

	@Override
	public String toString() {
		StringBuffer tmp = new StringBuffer ();
		tmp.append("PopOperation : ");
		return tmp.toString();
	}

}
