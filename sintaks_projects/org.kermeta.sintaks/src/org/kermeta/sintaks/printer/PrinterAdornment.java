/*
 * Created on 17 janv. 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package org.kermeta.sintaks.printer;


import org.kermeta.sintaks.sts.Adornment;
import org.kermeta.sintaks.sts.Rule;
import org.kermeta.sintaks.subject.ModelSubject;

public class PrinterAdornment implements IPrinter {

	public PrinterAdornment(Rule adornment, ModelSubject subject) {
		super();
		this.adornment = (Adornment) adornment;
	}

	// The final else is forbidden as the parser will not recognize it
    public void print (ISmartPrinter output) throws PrinterSemanticException {
    	PrinterRule.pushTrace (adornment, null, null);
    	String text = adornment.getTerminal();
        if ("eoln".equals(text)) output.println();
        else if ("tab".equals(text)) output.tab();
        else if ("inc".equals(text)) output.increase();
        else if ("dec".equals(text)) output.decrease();
        else PrinterRule.printText (output, "[[<<" + text + ">>]]", true);
    	PrinterRule.setStateValidOrFailed (true);
    	PrinterRule.popTrace();
    }
    
	private Adornment adornment;
}
