/*
 * Created on 17 janv. 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package org.kermeta.sintaks.printer;


import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.kermeta.sintaks.sts.ObjectReference;
import org.kermeta.sintaks.sts.Rule;
import org.kermeta.sintaks.subject.ModelSubject;
import org.kermeta.sintaks.subject.OperationExecutor;

public class PrinterReferenceValue implements IPrinter {

	public PrinterReferenceValue(Rule value, ModelSubject subject) {
		super();
		this.value = (ObjectReference) value;
        this.subject = subject;
	}

	public void print (ISmartPrinter output) throws PrinterSemanticException {
        EStructuralFeature id = value.getIdentifier();
        if (id == null) 
            throw new PrinterSemanticException ("ReferenceValue : id      "+((EClass) id.eContainer()).getName()+"."+id.getName()+" unacceptable");

    	PrinterRule.pushTrace (value, null, null);
        Object target;
        if(! value.getFeatures().isEmpty()) {
        	target = OperationExecutor.getFeatures(subject, value.getFeatures());
		} else {
			target = OperationExecutor.top(subject);
        }
		OperationExecutor.push(subject, target);
		Object object = OperationExecutor.getFeature (subject, id);
		OperationExecutor.pop(subject);
		PrinterRule.printText(output, object.toString(), value.isSurroundingSpaces());
    	PrinterRule.setStateValidOrFailed (true);
    	PrinterRule.popTrace();
	}
	
	private ObjectReference value;
    private ModelSubject subject;
}
