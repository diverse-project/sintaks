/**
 * Created on 26 April 2007
 *
 * @author Michel Hassenforder
 *
 */
package org.kermeta.sintaks.printer;

import java.io.PrintWriter;
import java.util.Iterator;

import org.kermeta.sintaks.sts.Condition;
import org.kermeta.sintaks.sts.Once;
import org.kermeta.sintaks.sts.Rule;
import org.kermeta.sintaks.subject.ModelSubject;


public class PrinterOnce implements IPrinter {

	public PrinterOnce(Rule once, ModelSubject subject) {
		super();
		this.once = (Once) once;
        this.subject = subject;
	}

	private void printOne (PrintWriter output, Object o) throws PrinterSemanticException {
		if (!(o instanceof Condition))
			throw new PrinterSemanticException ("Once : condition "+o+" unacceptable");
		IPrinter rulePrinter = new PrinterCondition ((Condition) o, subject);
        rulePrinter.print(output);
	}
	
	private void printWithSeparator (PrintWriter output) throws PrinterSemanticException {

		if (once.getConditions() == null)
            throw new PrinterSemanticException ("Once : null subRules");

		IPrinter separatorPrinter = PrinterRule.findPrinter (once.getSeparator(), subject);
		Iterator i = once.getConditions().iterator();
    	if(i.hasNext()) {
    		printOne (output, i.next());
    	}
    	while (i.hasNext()) {
    		separatorPrinter.print(output);
    		printOne (output, i.next());
	    }
    }

    private void printWithoutSeparator (PrintWriter output) throws PrinterSemanticException {
		if (once.getConditions() == null)
            throw new PrinterSemanticException ("Once : null subRules");

        Iterator i = once.getConditions().iterator();
    	while (i.hasNext()) {
    		printOne (output, i.next());
	    }
    }

    public void print (PrintWriter output) throws PrinterSemanticException {

        if (once.getSeparator() == null) {
            printWithoutSeparator (output);
        } else {
            printWithSeparator (output);
        }
    }

	private Once once;
    private ModelSubject subject;
}
