package org.kermeta.sintaks.subject.operation;

import org.kermetal.sintaks.subject.ModelSubject;

public abstract class R0W1Operation implements IOperation {

	public void execute(ModelSubject model) {
		Object result = execWithParam (model);
		model.push(result);
	}

	abstract protected Object execWithParam (ModelSubject model);

}
