/*
 * Created on 17 janv. 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package org.kermetal.sintaks.printer;

import java.io.PrintWriter;

import org.eclipse.emf.ecore.EClass;


import org.kermeta.sintaks.sts.Rule;
import org.kermeta.sintaks.sts.Template;
import org.kermetal.sintaks.subject.ModelSubject;

public class PrinterTemplate implements IPrinter {

	public PrinterTemplate(Rule rule, ModelSubject subject) {
		this.template = (Template) rule;
        this.subject = subject;
	}

    public void print (PrintWriter output) throws PrinterSemanticException  {
        EClass metaClass = template.getMetaclass();
        if (metaClass == null)
            throw new PrinterSemanticException ("Template : metaClass (null) unacceptable");
        if (template.getRule() != null) {
        	IPrinter printer = PrinterRule.findPrinter (template.getRule(), subject);
        	printer.print(output);
        }
    }
    
	private Template template;
    private ModelSubject subject;
}
