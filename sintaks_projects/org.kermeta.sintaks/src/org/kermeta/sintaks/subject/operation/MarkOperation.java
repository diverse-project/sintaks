package org.kermeta.sintaks.subject.operation;

import org.kermetal.sintaks.subject.ModelSubject;


public class MarkOperation extends R0W1Operation {

	public MarkOperation() {
		super();
	}

	protected Object execWithParam (ModelSubject model) {
		return new Integer (model.size());
	}


	@Override
	public String toString() {
		StringBuffer tmp = new StringBuffer ();
		tmp.append("MarkOperation : ");
		return tmp.toString();
	}

}
