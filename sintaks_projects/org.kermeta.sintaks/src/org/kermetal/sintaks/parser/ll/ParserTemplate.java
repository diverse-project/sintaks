/*
 * Created on 17 janv. 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package org.kermetal.sintaks.parser.ll;


import org.eclipse.emf.ecore.EClass;

import org.kermeta.sintaks.lexer.ILexer;
import org.kermeta.sintaks.sts.Rule;
import org.kermeta.sintaks.sts.Template;
import org.kermeta.sintaks.subject.operation.OperationBuilder;
import org.kermetal.sintaks.parser.IParser;
import org.kermetal.sintaks.parser.ParserSemanticException;
import org.kermetal.sintaks.subject.ModelSubject;


public class ParserTemplate implements IParser {

	public ParserTemplate(Rule rule, ModelSubject subject) {
		this.template = (Template) rule;
        this.subject = subject;
	}

	public boolean parse(ILexer input) throws ParserSemanticException {
		EClass metaClass = template.getMetaclass();
		if (metaClass == null)
			throw new ParserSemanticException ("Template : metaClass (null) unacceptable");

    	OperationBuilder builder1 = new OperationBuilder();
       	builder1.buildCreateClass(metaClass);
    	subject.process (builder1.getOperation());

    	if (template.getRule() == null) return true;
        boolean ok = true;
        IParser parser = ParserRule.findParser(template.getRule(), subject);
        ok = parser.parse(input);
		if (ok == false) {
	    	OperationBuilder builder2 = new OperationBuilder();
	       	builder2.buildPop();
	    	subject.process (builder2.getOperation());
		}
        return ok;
	}

	private Template template;
    private ModelSubject subject;
}
