/*
 * Created on 17 janv. 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package org.kermeta.sintaks.printer;

import java.io.PrintWriter;


import org.kermeta.sintaks.sts.Rule;
import org.kermeta.sintaks.sts.Terminal;
import org.kermeta.sintaks.subject.ModelSubject;

public class PrinterTerminal implements IPrinter {

	public PrinterTerminal(Rule terminal, ModelSubject subject) {
		super();
		this.terminal = (Terminal) terminal;
	}

    public void print (PrintWriter output) throws PrinterSemanticException {
        output.print(IPrinter.separator);
        output.print(terminal.getTerminal());
        output.print(IPrinter.separator);
    }
    
	private Terminal terminal;
}
