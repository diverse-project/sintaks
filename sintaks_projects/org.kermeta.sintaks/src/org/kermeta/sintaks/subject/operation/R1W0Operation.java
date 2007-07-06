package org.kermeta.sintaks.subject.operation;

import org.kermeta.sintaks.subject.ModelSubject;

public abstract class R1W0Operation implements IOperation {

	public void execute(ModelSubject model) {
		Object param = model.pop();
		execWithParam (model, param);
	}

	abstract protected void execWithParam(ModelSubject model, Object param);

}
