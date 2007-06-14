/*
 * Created on 17 janv. 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package org.kermetal.sintaks.printer;

import java.io.PrintWriter;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;


import org.kermeta.sintaks.sts.ObjectReference;
import org.kermeta.sintaks.sts.Rule;
import org.kermeta.sintaks.subject.operation.OperationBuilder;
import org.kermetal.sintaks.subject.ModelSubject;

public class PrinterReferenceValue implements IPrinter {

	public PrinterReferenceValue(Rule value, ModelSubject subject) {
		super();
		this.value = (ObjectReference) value;
        this.subject = subject;
	}

	public void print (PrintWriter output) throws PrinterSemanticException {
        EStructuralFeature id = value.getIdentifier();
        if (id == null) 
            throw new PrinterSemanticException ("ReferenceValue : id      "+((EClass) id.eContainer()).getName()+"."+id.getName()+" unacceptable");

    	OperationBuilder builder = new OperationBuilder();
		if(! value.getFeatures().isEmpty()) {
			EStructuralFeature feature = (EStructuralFeature) value.getFeatures().get(0);
        	builder.buildGetFeature(feature);
		} else {
	    	builder.buildDupp();
        }
    	builder.buildGetFeature(id);
		builder.buildSetAccumulator();
       	builder.buildPop();
		Object object = subject.process (builder.getOperation());

        String text = object.toString();
        if (text != null && text.length()!=0) {
        	output.print(IPrinter.separator);
        	if (text.indexOf(' ') != -1) {
        		output.print('"');
        		output.print(text);
        		output.print('"');
        	} else {
        		output.print(text);
        	}
    		output.print(IPrinter.separator);
        }
	}
	
	private ObjectReference value;
    private ModelSubject subject;
}