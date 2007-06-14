package org.kermeta.sintaks.subject.operation;

import org.kermetal.sintaks.subject.ModelSubject;

public abstract class R2W1Operation implements IOperation {

	public void execute(ModelSubject model) {
		Object param2 = model.pop();
		Object param1 = model.pop();
		Object result = execWithParam (model, param1, param2);
		model.push(result);
	}

	abstract protected Object execWithParam (ModelSubject model, Object param1, Object param2);

}
