/*
 * Created on 17 janv. 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package org.kermeta.sintaks.parser.ll;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.kermeta.sintaks.lexer.ILexer;
import org.kermeta.sintaks.parser.IParser;
import org.kermeta.sintaks.parser.ParserSemanticException;
import org.kermeta.sintaks.sts.ObjectReference;
import org.kermeta.sintaks.sts.Rule;
import org.kermeta.sintaks.subject.ModelSubject;
import org.kermeta.sintaks.subject.OperationExecutor;


public class ParserReferenceValue implements IParser {

	public ParserReferenceValue(Rule value, ModelSubject subject) {
		super();
		this.value = (ObjectReference) value;
        this.subject = subject;
	}

	public boolean parse(ILexer input) throws ParserSemanticException {
		EList<EStructuralFeature> features = value.getFeatures();
        EStructuralFeature id = value.getIdentifier();
        if (id == null) 
            throw new ParserSemanticException ("ReferenceValue : id      "+((EClass) id.eContainer()).getName()+"."+id.getName()+" unacceptable");
		if (input.atEnd()) return false;
        String textRead = input.get();

    	ParserRule.pushTrace (value, textRead, null);

        EObject instance = OperationExecutor.findInstance (subject, id, textRead);
    	boolean ok;
    	if (instance != null) {
        	if(! features.isEmpty()) {
    			OperationExecutor.setFeatures(subject, features, instance);
        	} else {
    			OperationExecutor.push(subject, instance);
        	}
        	ok = true;
        } else {
       		OperationExecutor.createGhosts(subject, features, id, textRead);
        	ok = true;
        }
		input.next();
        ParserRule.setStateValidOrFailed (ok);
		ParserRule.popTrace();
		return ok;
	}
	
	private ObjectReference value;
    private ModelSubject subject;
}
