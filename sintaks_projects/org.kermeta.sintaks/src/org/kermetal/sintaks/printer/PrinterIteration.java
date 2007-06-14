/*
 * Created on 17 janv. 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package org.kermetal.sintaks.printer;

import java.io.PrintWriter;
import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;


import org.kermeta.sintaks.sts.Iteration;
import org.kermeta.sintaks.sts.Rule;
import org.kermeta.sintaks.subject.operation.OperationBuilder;
import org.kermetal.sintaks.subject.ModelSubject;

public class PrinterIteration implements IPrinter {

	public PrinterIteration(Rule iteration, ModelSubject subject) {
		super();
		this.iteration = (Iteration) iteration;
        this.subject = subject;
	}

	private void printOne (PrintWriter output, IPrinter rulePrinter, Object object) throws PrinterSemanticException {
    	OperationBuilder builder1 = new OperationBuilder();
       	builder1.buildPush(object);
		subject.process (builder1.getOperation());

		rulePrinter.print(output);

		OperationBuilder builder2 = new OperationBuilder();
       	builder2.buildPop();
		subject.process (builder2.getOperation());
	}

	private Iterator iterator () {
        EStructuralFeature container = iteration.getContainer();
        OperationBuilder builder = new OperationBuilder();
        builder.buildGetFeature(container);
		builder.buildSetAccumulator();
		Object object = subject.process (builder.getOperation());

        if (object == null) return null;
        if (object instanceof EList) {
	        EList list = (EList) object;
	        if (list != null)
	            return list.iterator();
        }
        return null;
	}

	private void printWithSeparator (PrintWriter output) throws PrinterSemanticException {
        EStructuralFeature container = iteration.getContainer();
        if (container == null)
            throw new PrinterSemanticException ("Iteration : null container");

		IPrinter rulePrinter = PrinterRule.findPrinter (iteration.getSubRule(), subject);
        if (rulePrinter == null)
            throw new PrinterSemanticException ("Iteration : rulePrinter "+iteration.getSubRule()+" unacceptable");
            
        IPrinter separatorPrinter = PrinterRule.findPrinter (iteration.getSeparator(), subject);

        Iterator i = iterator();
        if (i != null) {
        	if(i.hasNext()) {
        		printOne (output, rulePrinter, i.next());
        	}
	    	while (i.hasNext()) {
	    		separatorPrinter.print(output);
	        	printOne (output, rulePrinter, i.next());
		    }
        }
    }

    private void printWithoutSeparator (PrintWriter output) throws PrinterSemanticException {
        EStructuralFeature container = iteration.getContainer();
        if (container == null)
            throw new PrinterSemanticException ("Iteration : null container");

        IPrinter rulePrinter = PrinterRule.findPrinter (iteration.getSubRule(), subject);
        if (rulePrinter == null)
            throw new PrinterSemanticException ("Iteration : rulePrinter "+iteration.getSubRule()+" unacceptable");

        Iterator i = iterator();
        if (i != null) {
            while (i.hasNext()) {
            	printOne (output, rulePrinter, i.next());
            }
        }
    }

    public void print (PrintWriter output) throws PrinterSemanticException {
        if (iteration.getSeparator() == null) {
            printWithoutSeparator (output);
        } else {
            printWithSeparator (output);
        }
    }

	private Iteration iteration;
    private ModelSubject subject;
}
