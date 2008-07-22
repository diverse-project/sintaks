/*
 * Created on 17 janv. 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package org.kermeta.sintaks.parser.ll;


import org.eclipse.emf.ecore.EClass;
import org.kermeta.sintaks.lexer.ILexer;
import org.kermeta.sintaks.parser.IParser;
import org.kermeta.sintaks.parser.ParserSemanticException;
import org.kermeta.sintaks.sts.Rule;
import org.kermeta.sintaks.sts.Template;
import org.kermeta.sintaks.subject.ModelSubject;
import org.kermeta.sintaks.subject.OperationExecutor;


public class ParserTemplate implements IParser {

	public ParserTemplate(Rule rule, ModelSubject subject) {
		this.template = (Template) rule;
        this.subject = subject;
	}

	public boolean parse(ILexer input) throws ParserSemanticException {
		EClass metaClass = template.getMetaclass();
		if (metaClass == null)
			throw new ParserSemanticException ("Template : metaClass (null) unacceptable");
    	ParserRule.pushTrace (template, null, null);

		OperationExecutor.createClass (subject, metaClass);

    	if (template.getRule() == null) return true;
        boolean ok = true;
        IParser parser = ParserRule.findParser(template.getRule(), subject);
        ok = parser.parse(input);
		if (ok == false) {
			OperationExecutor.pop (subject);
		}
        ParserRule.setStateValidOrCanceled(ok);
		ParserRule.popTrace();
		return ok;
	}

	private Template template;
    private ModelSubject subject;
}
