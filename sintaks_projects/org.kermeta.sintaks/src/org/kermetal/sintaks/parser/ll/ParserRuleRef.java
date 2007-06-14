/*
 * Created on 17 janv. 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package org.kermetal.sintaks.parser.ll;

import org.eclipse.emf.common.util.EList;

import org.kermeta.sintaks.lexer.ILexer;
import org.kermeta.sintaks.sts.Rule;
import org.kermeta.sintaks.sts.RuleRef;
import org.kermeta.sintaks.subject.operation.OperationBuilder;
import org.kermetal.sintaks.SintaksPlugin;
import org.kermetal.sintaks.parser.IParser;
import org.kermetal.sintaks.parser.ParserSemanticException;
import org.kermetal.sintaks.subject.ModelSubject;


public class ParserRuleRef implements IParser {

	public ParserRuleRef(Rule rule, ModelSubject subject) {
		super();
		this.rule = (RuleRef) rule;
        this.subject = subject;
	}

	public boolean parse(ILexer input) throws ParserSemanticException {
		Rule referedRule = rule.getRef();
		IParser parser = ParserRule.findParser(referedRule, subject);
		boolean ok = parser.parse(input);

		if(ok) {
			EList features = rule.getFeatures();
        	OperationBuilder builder = new OperationBuilder();
        	if(! features.isEmpty()) {
	        	builder.buildSetFeatures(features);
	        }
        	subject.process (builder.getOperation());
        	ok = true;
            if (SintaksPlugin.getDefault().getOptionManager().isDebugParser())
            	SintaksPlugin.getDefault().debugln ("Accepted RuleRef : "+referedRule);
		} else {
            if (SintaksPlugin.getDefault().getOptionManager().isDebugParser())
            	SintaksPlugin.getDefault().debugln ("Refused RuleRef : "+referedRule);
		}
		return ok;
	}

	private RuleRef rule;
    private ModelSubject subject;
}
