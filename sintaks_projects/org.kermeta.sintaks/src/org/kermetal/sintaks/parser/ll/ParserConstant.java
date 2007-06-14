/*
 * Created on 17 janv. 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package org.kermetal.sintaks.parser.ll;

import org.eclipse.emf.common.util.EList;

import org.kermeta.sintaks.lexer.ILexer;
import org.kermeta.sintaks.sts.Constant;
import org.kermeta.sintaks.sts.Rule;
import org.kermeta.sintaks.subject.operation.OperationBuilder;
import org.kermetal.sintaks.SintaksPlugin;
import org.kermetal.sintaks.parser.IParser;
import org.kermetal.sintaks.parser.ParserSemanticException;
import org.kermetal.sintaks.subject.ModelSubject;


public class ParserConstant implements IParser {

	public ParserConstant(Rule value, ModelSubject subject) {
		super();
		this.value = (Constant) value;
        this.subject = subject;
	}

	public boolean parse(ILexer input) throws ParserSemanticException {
		EList features = value.getFeatures();
        boolean ok;
        if (value.getValue() != null) {
        	OperationBuilder builder = new OperationBuilder();
        	builder.buildPush(value.getValue());
        	if(! features.isEmpty()) {
	        	builder.buildSetFeatures(features);
	        }
        	subject.process (builder.getOperation());
        	ok = true;
        	if (SintaksPlugin.getDefault().getOptionManager().isDebugParser())
	        	SintaksPlugin.getDefault().debugln ("Accepted Constant : "+value);
        } else {
        	ok = false;
	        if (SintaksPlugin.getDefault().getOptionManager().isDebugParser())
	        	SintaksPlugin.getDefault().debugln ("Refused Constant : "+value);
        }
		return ok;
	}

	private Constant value;
    private ModelSubject subject;
}
