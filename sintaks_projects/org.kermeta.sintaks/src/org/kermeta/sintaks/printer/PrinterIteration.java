/*
 * Created on 17 janv. 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package org.kermeta.sintaks.printer;

import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.kermeta.sintaks.sts.Iteration;
import org.kermeta.sintaks.sts.Rule;
import org.kermeta.sintaks.subject.ModelSubject;
import org.kermeta.sintaks.subject.OperationExecutor;

public class PrinterIteration implements IPrinter {

	public PrinterIteration(Rule iteration, ModelSubject subject) {
		super();
		this.iteration = (Iteration) iteration;
        this.subject = subject;
	}

	private void printOne (ISmartPrinter output, IPrinter rulePrinter, Object object) throws PrinterSemanticException {
//    	OperationBuilder builder1 = new OperationBuilder();
//       	builder1.buildPush(object);
//		subject.process (builder1.getOperation());

		OperationExecutor.push(subject, object);

		rulePrinter.print(output);

		OperationExecutor.pop(subject);
//		OperationBuilder builder2 = new OperationBuilder();
//       	builder2.buildPop();
//		subject.process (builder2.getOperation());
	}

	@SuppressWarnings("unchecked")
	private Iterator<EObject> iterator () {
//        EList<EStructuralFeature> containers = iteration.getContainers();
//        OperationBuilder builder = new OperationBuilder();
//        builder.buildGetFeature(containers.get(0));
//		builder.buildSetAccumulator();
//		Object object = subject.process (builder.getOperation());

		Object object = OperationExecutor.getFeatures (subject, iteration.getContainers());
        if (object == null) return null;
        if (object instanceof EList) {
	        EList<EObject> list = (EList<EObject>) object;
	        if (list != null)
	            return list.iterator();
        }
        return null;
	}

	private void printWithSeparator (ISmartPrinter output) throws PrinterSemanticException {
        EList<EStructuralFeature> containers = iteration.getContainers();
        if (containers.isEmpty())
            throw new PrinterSemanticException ("Iteration : null container");

		IPrinter rulePrinter = PrinterRule.findPrinter (iteration.getSubRule(), subject);
        if (rulePrinter == null)
            throw new PrinterSemanticException ("Iteration : rulePrinter "+iteration.getSubRule()+" unacceptable");
            
        IPrinter separatorPrinter = PrinterRule.findPrinter (iteration.getSeparator(), subject);

        Iterator<EObject> i = iterator();
		int count=0;
        if (i != null) {
        	if(i.hasNext()) {
    	    	PrinterRule.pushTrace (iteration, null, "step "+count);
        		printOne (output, rulePrinter, i.next());
            	++count;
            	PrinterRule.setStateValidOrCanceled(true);
                PrinterRule.popTrace();
        	}
	    	while (i.hasNext()) {
	    		separatorPrinter.print(output);
    	    	PrinterRule.pushTrace (iteration, null, "step "+count);
        		printOne (output, rulePrinter, i.next());
            	++count;
            	PrinterRule.setStateValidOrCanceled(true);
                PrinterRule.popTrace();
		    }
        }
    }

    private void printWithoutSeparator (ISmartPrinter output) throws PrinterSemanticException {
        EList<EStructuralFeature> containers = iteration.getContainers();
        if (containers.isEmpty())
            throw new PrinterSemanticException ("Iteration : null container");

        IPrinter rulePrinter = PrinterRule.findPrinter (iteration.getSubRule(), subject);
        if (rulePrinter == null)
            throw new PrinterSemanticException ("Iteration : rulePrinter "+iteration.getSubRule()+" unacceptable");

        Iterator<EObject> i = iterator();
        int count=0;
        if (i != null) {
            while (i.hasNext()) {
    	    	PrinterRule.pushTrace (iteration, null, "step "+count);
            	printOne (output, rulePrinter, i.next());
            	++count;
            	PrinterRule.setStateValidOrCanceled(true);
                PrinterRule.popTrace();
            }
        }
    }

    public void print (ISmartPrinter output) throws PrinterSemanticException {
    	PrinterRule.pushTrace (iteration, null, null);
        if (iteration.getSeparator() == null) {
            printWithoutSeparator (output);
        } else {
            printWithSeparator (output);
        }
        PrinterRule.setStateValidOrCanceled(true);
        PrinterRule.popTrace();
    }

	private Iteration iteration;
    private ModelSubject subject;
}
