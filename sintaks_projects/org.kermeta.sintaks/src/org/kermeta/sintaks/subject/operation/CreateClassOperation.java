/* $Id: CreateClassOperation.java,v 1.3 2007-10-24 07:13:54 dvojtise Exp $
 * Project    : Sintaks
 * File       : CreateClassOperation.java
 * License    : EPL
 * Copyright  : IRISA / INRIA / Universite de Haute Alsace
 * -------------------------------------------------------------------
 * Creation date : 21 juil. 2005
 * Authors : 
 * 			Michel Hassenforder <michel.hassenforder@uha.fr>
 * 			David Touzet <dtouzet@irisa.fr>
 *        	dvojtise <dvojtise@irisa.fr>
 */
package org.kermeta.sintaks.subject.operation;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EPackage;
import org.kermeta.sintaks.errors.UserError;
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
		if(metaClassPackage == null && metaClass.eIsProxy()){
			// pb MM is not registered
			throw new UserError("Cannot build model because the metamodel is not correctly registered.");
		}
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
