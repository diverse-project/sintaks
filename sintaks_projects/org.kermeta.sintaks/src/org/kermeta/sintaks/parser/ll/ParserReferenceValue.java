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

import org.kermeta.sintaks.SintaksPlugin;
import org.kermeta.sintaks.lexer.ILexer;
import org.kermeta.sintaks.parser.IParser;
import org.kermeta.sintaks.parser.ParserSemanticException;
import org.kermeta.sintaks.sts.ObjectReference;
import org.kermeta.sintaks.sts.Rule;
import org.kermeta.sintaks.subject.ModelSubject;
import org.kermeta.sintaks.subject.OperationExecutor;
import org.kermeta.sintaks.subject.operation.OperationBuilder;


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

// HM slowly remove OperationBuilder
//        OperationBuilder builder1 = new OperationBuilder();
//    	builder1.buildFindInstance(id, textRead);
//    	builder1.buildSetAccumulator();
//        Object instance = subject.process (builder1.getOperation());

        EObject instance = OperationExecutor.findInstance (subject, id, textRead);
        
    	boolean ok;
    	if (instance != null) {
//       	OperationBuilder builder2 = new OperationBuilder();
//        	builder2.buildPush(instance);
        	if(! features.isEmpty()) {
//        		builder2.buildSetFeatures(features);
    			OperationExecutor.setFeatures(subject, features, instance);
        	} else {
    			OperationExecutor.push(subject, instance);
        	}
//        	subject.process (builder2.getOperation());
        	ok = true;
        	if (SintaksPlugin.getDefault().getOptionManager().isDebugParser())
	        	SintaksPlugin.getDefault().debugln ("Accepted Reference to : "+id);
        } else {
//        	OperationBuilder builder2 = new OperationBuilder();
//        	builder2.buildCreateGhosts(features, id, textRead);
//        	subject.process (builder2.getOperation());
        	OperationExecutor.createGhosts(subject, features, id, textRead);
        	if (SintaksPlugin.getDefault().getOptionManager().isDebugParser())
	        	SintaksPlugin.getDefault().debugln ("Created Ghost to : "+id);
        	ok = true;
        }
		input.next();
        return ok;
	}
	
	private ObjectReference value;
    private ModelSubject subject;
}
