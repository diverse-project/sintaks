/*
 * Created on 17 janv. 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package org.kermeta.sintaks.printer;

import org.kermeta.sintaks.sts.PrimitiveValue;
import org.kermeta.sintaks.sts.Rule;
import org.kermeta.sintaks.subject.ModelSubject;
import org.kermeta.sintaks.subject.OperationExecutor;

public class PrinterPrimitiveValue implements IPrinter {

	public PrinterPrimitiveValue(Rule value, ModelSubject subject) {
		super();
		this.value = (PrimitiveValue) value;
        this.subject = subject;
	}

	public void print (ISmartPrinter output) throws PrinterSemanticException {
    	PrinterRule.pushTrace (value, null, null);
		Object object;
		if(! value.getFeatures().isEmpty()) {
			object = OperationExecutor.getFeatures(subject, value.getFeatures());
		} else {
			object = OperationExecutor.pop(subject);
        }
		if (object != null) {
			PrinterRule.printText(output, object.toString(), value.isSurroundingSpaces());
		} else {
			PrinterRule.printText(output, "#EMPTY#", value.isSurroundingSpaces());
		}
		PrinterRule.setStateValidOrFailed (true);
    	PrinterRule.popTrace();
	}
	
	private PrimitiveValue value;
    private ModelSubject subject;
}
