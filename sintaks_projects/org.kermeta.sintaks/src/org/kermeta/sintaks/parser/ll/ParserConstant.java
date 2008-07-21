/*
 * Created on 17 janv. 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package org.kermeta.sintaks.parser.ll;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.kermeta.sintaks.lexer.ILexer;
import org.kermeta.sintaks.parser.IParser;
import org.kermeta.sintaks.parser.ParserSemanticException;
import org.kermeta.sintaks.sts.Constant;
import org.kermeta.sintaks.sts.Rule;
import org.kermeta.sintaks.subject.ModelSubject;
import org.kermeta.sintaks.subject.OperationExecutor;


public class ParserConstant implements IParser {

	public ParserConstant(Rule value, ModelSubject subject) {
		super();
		this.value = (Constant) value;
        this.subject = subject;
	}

	public boolean parse(ILexer input) throws ParserSemanticException {
		EList<EStructuralFeature> features = value.getFeatures();
    	ParserRule.pushTrace (value, null, null);
        boolean ok;
        if (value.getValue() != null) {
// HM slowly remove OperationBuilder
//        	OperationBuilder builder = new OperationBuilder();
//        	builder.buildPush(value.getValue());
        	if(! features.isEmpty()) {
    			OperationExecutor.setFeatures(subject, features, value.getValue());
//	        	builder.buildSetFeatures(features);
	        } else {
	        	OperationExecutor.push(subject, value.getValue());	        	
	        }
//        	subject.process (builder.getOperation());
        	ok = true;
        } else {
        	ok = false;
        }
        ParserRule.setStateValidOrFailed(ok);
		ParserRule.popTrace();
		return ok;
	}

	private Constant value;
    private ModelSubject subject;
}
