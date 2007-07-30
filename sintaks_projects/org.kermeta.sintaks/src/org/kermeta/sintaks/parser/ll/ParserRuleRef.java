/*
 * Created on 17 janv. 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package org.kermeta.sintaks.parser.ll;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.kermeta.sintaks.SintaksPlugin;
import org.kermeta.sintaks.lexer.ILexer;
import org.kermeta.sintaks.parser.IParser;
import org.kermeta.sintaks.parser.ParserSemanticException;
import org.kermeta.sintaks.sts.Rule;
import org.kermeta.sintaks.sts.RuleRef;
import org.kermeta.sintaks.subject.ModelSubject;
import org.kermeta.sintaks.subject.operation.OperationBuilder;


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
			EList<EStructuralFeature> features = rule.getFeatures();
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
