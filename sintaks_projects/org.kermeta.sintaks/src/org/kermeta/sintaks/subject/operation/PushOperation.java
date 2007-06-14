package org.kermeta.sintaks.subject.operation;

import org.kermetal.sintaks.subject.ModelSubject;


public class PushOperation extends R0W0Operation {

	private Object value;
	
	public PushOperation(Object value) {
		super();
		this.value = value;
	}

	protected void execWithParam (ModelSubject model) {
		model.push(value);
	}


	@Override
	public String toString() {
		StringBuffer tmp = new StringBuffer ();
		tmp.append("PushOperation : ");
		return tmp.toString();
	}

}
