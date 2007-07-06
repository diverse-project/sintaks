package org.kermeta.sintaks.subject.operation;

import org.kermeta.sintaks.subject.ModelSubject;

public abstract class R1W1Operation implements IOperation {

	public void execute(ModelSubject model) {
		Object param = model.pop();
		Object result = execWithParam (model, param);
		model.push(result);
	}

	abstract protected Object execWithParam(ModelSubject model, Object param);

}
