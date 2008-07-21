/*
 * Created on 17 janv. 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package org.kermeta.sintaks.printer;

import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.kermeta.sintaks.sts.Rule;
import org.kermeta.sintaks.sts.Sequence;
import org.kermeta.sintaks.subject.ModelSubject;

public class PrinterSequence implements IPrinter {

	public PrinterSequence(Rule sequence, ModelSubject subject) {
		super();
		this.sequence = (Sequence) sequence;
        this.subject = subject;
	}

	public void print (ISmartPrinter output) throws PrinterSemanticException {
		EList<Rule> list = sequence.getSubRules();
		Iterator<Rule> i = list.iterator();
    	PrinterRule.pushTrace (sequence, null, null);
		while (i.hasNext()) {
			//Rule rule = (Rule) i.next();
            //IPrinter printer = PrinterRule.findPrinter (rule, subject);
            IPrinter printer = PrinterRule.findPrinter (i.next(), subject);
			printer.print(output);
		}
    	PrinterRule.setStateValidOrCanceled(true);
        PrinterRule.popTrace();
	}

	private Sequence sequence;
    private ModelSubject subject;
}
