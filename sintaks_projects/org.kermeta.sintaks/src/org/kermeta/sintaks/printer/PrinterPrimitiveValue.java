/*
 * Created on 17 janv. 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package org.kermeta.sintaks.printer;

import java.io.PrintWriter;

import org.eclipse.emf.ecore.EStructuralFeature;


import org.kermeta.sintaks.sts.PrimitiveValue;
import org.kermeta.sintaks.sts.Rule;
import org.kermeta.sintaks.subject.ModelSubject;
import org.kermeta.sintaks.subject.operation.OperationBuilder;

public class PrinterPrimitiveValue implements IPrinter {

	public PrinterPrimitiveValue(Rule value, ModelSubject subject) {
		super();
		this.value = (PrimitiveValue) value;
        this.subject = subject;
	}

	public void print (PrintWriter output) throws PrinterSemanticException {

    	OperationBuilder builder = new OperationBuilder();
		if(! value.getFeatures().isEmpty()) {
			EStructuralFeature feature = (EStructuralFeature) value.getFeatures().get(0);
        	builder.buildGetFeature(feature);
        } else {
        	builder.buildDupp();
        }
		builder.buildSetAccumulator();
		Object object = subject.process (builder.getOperation());

		String text = object.toString();
        if (text != null && text.length()!=0) {
        	if (value.isSurroundingSpaces()) output.print(IPrinter.separator);
        	if (text.indexOf(' ') != -1) {
        		output.print('"');
        		output.print(text);
        		output.print('"');
        	} else {
        		output.print(text);
        	}
        	if (value.isSurroundingSpaces()) output.print(IPrinter.separator);
        }
    }
	
	private PrimitiveValue value;
    private ModelSubject subject;
}
