/*
 * Created on 17 janv. 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package org.kermeta.sintaks.parser.ll;

import org.eclipse.emf.common.util.EList;

import org.kermeta.sintaks.SintaksPlugin;
import org.kermeta.sintaks.lexer.ILexer;
import org.kermeta.sintaks.parser.IParser;
import org.kermeta.sintaks.parser.ParserSemanticException;
import org.kermeta.sintaks.sts.PrimitiveValue;
import org.kermeta.sintaks.sts.Rule;
import org.kermeta.sintaks.subject.ModelSubject;
import org.kermeta.sintaks.subject.operation.OperationBuilder;


public class ParserPrimitiveValue implements IParser {

	public ParserPrimitiveValue(Rule value, ModelSubject subject) {
		super();
		this.value = (PrimitiveValue) value;
        this.subject = subject;
	}

	public boolean parse(ILexer input) throws ParserSemanticException {
		EList features = value.getFeatures();
		if (input.atEnd()) return false;
        String textRead = input.get();
        
        if(input.isTerminal(textRead)) return false;
        
        boolean ok;
        if (textRead != null) {
        	OperationBuilder builder = new OperationBuilder();
        	builder.buildPush(textRead);
        	if(! features.isEmpty()) {
	        	builder.buildSetFeatures(features);
	        }
        	subject.process (builder.getOperation());
        	ok = true;
	        if (SintaksPlugin.getDefault().getOptionManager().isDebugParser())
	        	SintaksPlugin.getDefault().debugln ("Accepted Primitive Value : "+textRead);
			input.next();
        } else {
        	ok = false;
	        if (SintaksPlugin.getDefault().getOptionManager().isDebugParser())
	        	SintaksPlugin.getDefault().debugln ("Refused Primitive Value : "+textRead);
        }
        return ok;
	}

	private PrimitiveValue value;
    private ModelSubject subject;
}
