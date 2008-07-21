/*
 * Created on 17 janv. 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package org.kermeta.sintaks.printer;

import org.kermeta.sintaks.sts.Rule;
import org.kermeta.sintaks.sts.Terminal;
import org.kermeta.sintaks.subject.ModelSubject;

public class PrinterTerminal implements IPrinter {

	public PrinterTerminal(Rule terminal, ModelSubject subject) {
		super();
		this.terminal = (Terminal) terminal;
	}

    public void print (ISmartPrinter output) throws PrinterSemanticException {
    	PrinterRule.pushTrace (terminal, null, null);
    	PrinterRule.printText(
    			output,
    			terminal.getTerminal(),
    			! terminal.isLexicalSeparator() && terminal.isSurroundingSpaces()
    		);
    	PrinterRule.setStateValidOrFailed(true);
        PrinterRule.popTrace();
    }
    
	private Terminal terminal;
}
