/*
 * Created on 17 janv. 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package org.kermeta.sintaks.printer;

import java.util.Iterator;

import org.eclipse.emf.common.util.EList;


import org.kermeta.sintaks.sts.Alternative;
import org.kermeta.sintaks.sts.Condition;
import org.kermeta.sintaks.sts.Rule;
import org.kermeta.sintaks.subject.ModelSubject;

public class PrinterAlternative implements IPrinter {

	public PrinterAlternative(Rule alternative, ModelSubject subject) {
		super();
		this.alternative = (Alternative) alternative;
        this.subject = subject;
	}

	public void print(ISmartPrinter output) throws PrinterSemanticException {
		EList<Condition> list = alternative.getConditions();
		if (list == null)
			throw new PrinterSemanticException ("Alternative : alternatives "+alternative.getConditions()+" unacceptable");

    	PrinterRule.pushTrace (alternative, null, null);

    	Iterator<Condition> i = list.iterator();
		while (i.hasNext()) {
			Condition c = i.next();
			if (c != null) {
				IPrinter printer = new PrinterCondition (c, subject);
				printer.print(output);
			}
		}
    	PrinterRule.setStateValidOrCanceled (true);
    	PrinterRule.popTrace();
	}

	private Alternative alternative;
    private ModelSubject subject;
}
