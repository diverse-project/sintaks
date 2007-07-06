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

	public void print(PrintWriter output) throws PrinterSemanticException {
		EList list = alternative.getConditions();
		if (list == null)
			throw new PrinterSemanticException ("Alternative : alternatives "+alternative.getConditions()+" unacceptable");

		Iterator i = list.iterator();
		while (i.hasNext()) {
			Object o = i.next();
			
			if (!(o instanceof Condition))
				throw new PrinterSemanticException ("Alternative : condition "+o+" unacceptable");
			
			if (o != null) {
				IPrinter printer = new PrinterCondition ((Condition) o, subject);
				printer.print(output);
			}
		}
	}

	private Alternative alternative;
    private ModelSubject subject;
}
