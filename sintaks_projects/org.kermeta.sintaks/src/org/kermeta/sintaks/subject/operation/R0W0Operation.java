package org.kermeta.sintaks.subject.operation;

import org.kermeta.sintaks.subject.ModelSubject;

public abstract class R0W0Operation implements IOperation {

	public void execute(ModelSubject model) {
		execWithParam (model);
	}

	abstract protected void execWithParam (ModelSubject model);

}
