/**
 * Created on 26 April 2007
 *
 * @author Michel Hassenforder
 *
 */
package org.kermeta.sintaks.printer;

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

	private void printOne (ISmartPrinter output, Object o) throws PrinterSemanticException {
		if (!(o instanceof Condition))
			throw new PrinterSemanticException ("Once : condition "+o+" unacceptable");
		IPrinter rulePrinter = new PrinterCondition ((Condition) o, subject);
        rulePrinter.print(output);
	}
	
	private void printWithSeparator (ISmartPrinter output) throws PrinterSemanticException {

		if (once.getConditions() == null)
            throw new PrinterSemanticException ("Once : null subRules");

		IPrinter separatorPrinter = PrinterRule.findPrinter (once.getSeparator(), subject);
		Iterator<Condition> i = once.getConditions().iterator();
		int count=0;
		if(i.hasNext()) {
	    	PrinterRule.pushTrace (once, null, "once "+count);
    		printOne (output, i.next());
        	PrinterRule.setStateValidOrFailed (true);
        	PrinterRule.popTrace();
		}
    	while (i.hasNext()) {
    		separatorPrinter.print(output);
	    	PrinterRule.pushTrace (once, null, "once "+count);
    		printOne (output, i.next());
        	PrinterRule.setStateValidOrFailed (true);
        	PrinterRule.popTrace();
	    }
    }

    private void printWithoutSeparator (ISmartPrinter output) throws PrinterSemanticException {
		if (once.getConditions() == null)
            throw new PrinterSemanticException ("Once : null subRules");

        Iterator<Condition> i = once.getConditions().iterator();
        int count=0;
        while (i.hasNext()) {
	    	PrinterRule.pushTrace (once, null, "once "+count);
    		printOne (output, i.next());
        	PrinterRule.setStateValidOrFailed (true);
        	PrinterRule.popTrace();
	    }
    }

    public void print (ISmartPrinter output) throws PrinterSemanticException {

    	PrinterRule.pushTrace (once, null, null);
        if (once.getSeparator() == null) {
            printWithoutSeparator (output);
        } else {
            printWithSeparator (output);
        }
    	PrinterRule.setStateValidOrFailed (true);
    	PrinterRule.popTrace();
    }

	private Once once;
    private ModelSubject subject;
}
