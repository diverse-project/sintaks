/*
 * Created on 4 f�vr. 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package org.kermeta.sintaks.printer;



import org.kermeta.sintaks.sts.Rule;
import org.kermeta.sintaks.subject.ModelSubject;

public class PrinterAbstract implements IPrinter {

    public PrinterAbstract (Rule rule, ModelSubject subject) {
        this.rule = rule;
        this.subject = subject;
    }

    public void print(ISmartPrinter output) throws PrinterSemanticException {
        IPrinter printer = new PrinterRule (rule, subject);
        printer.print(output);
	}

    private Rule rule;
    private ModelSubject subject;
}
