/*
 * Created on 17 janv. 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package org.kermeta.sintaks.printer;

import java.io.PrintWriter;
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

	public void print (PrintWriter output) throws PrinterSemanticException {
		EList list = sequence.getSubRules();
		Iterator i = list.iterator();
		while (i.hasNext()) {
			Rule rule = (Rule) i.next();
            IPrinter printer = PrinterRule.findPrinter (rule, subject);
			printer.print(output);
		}
	}

	private Sequence sequence;
    private ModelSubject subject;
}
