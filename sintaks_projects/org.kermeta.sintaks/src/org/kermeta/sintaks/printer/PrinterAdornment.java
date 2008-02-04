/*
 * Created on 17 janv. 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package org.kermeta.sintaks.printer;

import java.io.PrintWriter;


import org.kermeta.sintaks.sts.Adornment;
import org.kermeta.sintaks.sts.Rule;
import org.kermeta.sintaks.subject.ModelSubject;

public class PrinterAdornment implements IPrinter {

	public PrinterAdornment(Rule adornment, ModelSubject subject) {
		super();
		this.adornment = (Adornment) adornment;
	}
// The final else is forbidden as the parser will not recognize it
    public void print (PrintWriter output) throws PrinterSemanticException {
    	if (adornment.isSurroundingSpaces()) output.print(IPrinter.separator);
        String text = adornment.getTerminal();
        if ("eoln".equals(text))
        	output.println();
        else if ("tab".equals(text))
        	output.print("\t");
        else output.print(text);
    	if (adornment.isSurroundingSpaces()) output.print(IPrinter.separator);
    }
    
	private Adornment adornment;
}
