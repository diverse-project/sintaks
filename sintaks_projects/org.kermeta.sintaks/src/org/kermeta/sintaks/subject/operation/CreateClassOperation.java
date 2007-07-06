package org.kermeta.sintaks.subject.operation;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EPackage;
import org.kermeta.sintaks.subject.ModelSubject;


public class CreateClassOperation extends R0W1Operation {

	private EClass metaClass;

	public CreateClassOperation(EClass metaClass) {
		super();
		this.metaClass = metaClass;
	}

	public Object execWithParam (ModelSubject model) {
//TODO est-ce possible d'avoir des classes dans des classes -> eContainer n'est pas un package...
		EPackage metaClassPackage = (EPackage) metaClass.eContainer();
		EFactory fact = metaClassPackage.getEFactoryInstance();
		return fact.create(metaClass);
	}

	@Override
	public String toString() {
		StringBuffer tmp = new StringBuffer ();
		tmp.append("CreateClassOperation : ");
		tmp.append(metaClass.getName());
		return tmp.toString();
	}
}
