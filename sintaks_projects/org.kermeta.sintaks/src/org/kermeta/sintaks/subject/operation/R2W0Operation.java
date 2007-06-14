package org.kermeta.sintaks.subject.operation;

import org.kermetal.sintaks.subject.ModelSubject;

public abstract class R2W0Operation implements IOperation {

	public void execute(ModelSubject model) {
		Object param2 = model.pop();
		Object param1 = model.pop();
		execWithParam (model, param1, param2);
	}

	abstract protected void execWithParam(ModelSubject model, Object param1, Object param2);

}
