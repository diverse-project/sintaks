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
import org.kermeta.sintaks.sts.PrimitiveValue;
import org.kermeta.sintaks.sts.Rule;
import org.kermeta.sintaks.subject.ModelSubject;
import org.kermeta.sintaks.subject.OperationExecutor;


public class ParserPrimitiveValue implements IParser {

	public ParserPrimitiveValue(Rule value, ModelSubject subject) {
		super();
		this.value = (PrimitiveValue) value;
        this.subject = subject;
	}

	public boolean parse(ILexer input) throws ParserSemanticException {
		EList<EStructuralFeature> features = value.getFeatures();
		if (input.atEnd()) return false;
        String textRead = input.get();
        
        if(input.isTerminal(textRead)) return false;
        
    	ParserRule.pushTrace (value, textRead, null);
        boolean ok;
        if (textRead != null) {
        	if(! features.isEmpty()) {
    			OperationExecutor.setFeatures(subject, features, textRead);
	        } else {
	        	OperationExecutor.push(subject, textRead);	        	
	        }
        	ok = true;
			input.next();
        } else {
        	ok = false;
        }
        ParserRule.setStateValidOrFailed (ok);
		ParserRule.popTrace();
		return ok;
	}

	private PrimitiveValue value;
    private ModelSubject subject;
}
