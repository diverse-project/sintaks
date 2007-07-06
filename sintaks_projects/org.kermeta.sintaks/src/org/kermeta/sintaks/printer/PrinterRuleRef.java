/*
 * Created on 17 janv. 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package org.kermeta.sintaks.printer;

import java.io.PrintWriter;

import org.eclipse.emf.ecore.EStructuralFeature;


import org.kermeta.sintaks.sts.Rule;
import org.kermeta.sintaks.sts.RuleRef;
import org.kermeta.sintaks.subject.ModelSubject;
import org.kermeta.sintaks.subject.operation.OperationBuilder;

public class PrinterRuleRef implements IPrinter {

	public PrinterRuleRef(Rule rule, ModelSubject subject) {
		super();
		this.rule = (RuleRef) rule;
        this.subject = subject;
	}

	public void print(PrintWriter output) throws PrinterSemanticException {
		Rule referedRule = rule.getRef();
		IPrinter printer = PrinterRule.findPrinter(referedRule, subject);
		
		if(! rule.getFeatures().isEmpty()) {
			EStructuralFeature feature = (EStructuralFeature) rule.getFeatures().get(0);
	    	OperationBuilder builder1 = new OperationBuilder();
        	builder1.buildGetFeature(feature);
    		subject.process (builder1.getOperation());

    		printer.print(output);
    		
    		OperationBuilder builder2 = new OperationBuilder();
           	builder2.buildPop();
    		subject.process (builder2.getOperation());
        } else {
    		printer.print(output);
        }

	}

	private RuleRef rule;
    private ModelSubject subject;
}
