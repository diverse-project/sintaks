/*
 * Created on 17 janv. 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package org.kermetal.sintaks.printer;

import java.io.PrintWriter;


import org.kermeta.sintaks.sts.Constant;
import org.kermeta.sintaks.sts.Rule;
import org.kermetal.sintaks.subject.ModelSubject;


public class PrinterConstant implements IPrinter {

	public PrinterConstant(Rule value, ModelSubject subject) {
		super();
		this.value = (Constant) value;
        this.subject = subject;
	}

	// it is a do nothing method
	// a constant do not leave information in the output stream
	public void print (PrintWriter output) throws PrinterSemanticException {
    }
	
	@SuppressWarnings("unused")
	private Constant value;
	@SuppressWarnings("unused")
    private ModelSubject subject;
}
