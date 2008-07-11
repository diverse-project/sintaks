/*
 * Created on 17 janv. 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package org.kermeta.sintaks.parser.ll;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EPackage.Registry;

import org.kermeta.sintaks.SintaksPlugin;
import org.kermeta.sintaks.lexer.ILexer;
import org.kermeta.sintaks.parser.IParser;
import org.kermeta.sintaks.parser.ParserSemanticException;
import org.kermeta.sintaks.sts.Rule;
import org.kermeta.sintaks.sts.URIValue;
import org.kermeta.sintaks.subject.ModelSubject;
import org.kermeta.sintaks.subject.OperationExecutor;
import org.kermeta.sintaks.subject.operation.OperationBuilder;



public class ParserURIValue implements IParser {

	public ParserURIValue(Rule value, ModelSubject subject) {
		super();
		this.value = (URIValue) value;
        this.subject = subject;
	}

	/* (non-Javadoc)
	 * @see fr.irisa.triskell.kermeta.textloader.parser.IParser#parse(fr.irisa.triskell.kermeta.textloader.lexer.ILexer)
	 */
	public boolean parse(ILexer input) throws ParserSemanticException {
		EList<EStructuralFeature> features = value.getFeatures();
		if (input.atEnd()) return false;
        String textRead = input.get();
        EObject uri = getEObjectFromStringURI (textRead);
        boolean ok;
        if (uri != null) {
// HM slowly remove OperationBuilder
//        	OperationBuilder builder = new OperationBuilder();
//        	builder.buildPush(uri);
        	if(! features.isEmpty()) {
//	        	builder.buildSetFeatures(features);
        		OperationExecutor.setFeatures(subject, features, uri);
	        } else {
    			OperationExecutor.push(subject, uri);
	        }
//        	subject.process (builder.getOperation());
        	ok = true;
	        if (SintaksPlugin.getDefault().getOptionManager().isDebugParser())
	        	SintaksPlugin.getDefault().debugln ("Accepted URI : "+uri);
			input.next();
        } else {
        	ok = false;
	        if (SintaksPlugin.getDefault().getOptionManager().isDebugParser())
	        	SintaksPlugin.getDefault().debugln ("Refused null URI");
        }
        return ok;
	}
	

	/**
	 * Get an EObject (ie an element of an ecore resource) from its URI, null if the URI cannot
	 * be resolved.
	 * @param text
	 * @return
	 */
	private EObject getEObjectFromStringURI(String text) {
       	URI objURI = URI.createURI(text);
       	String URIfrag = objURI.fragment();
       	if(URIfrag == null) return null;
       	
       	URIfrag = URIfrag.substring(2);
       	
       	String str = text.replace(objURI.fragment(), "").replace("#", "");
       	EPackage ePack = (EPackage) Registry.INSTANCE.get(str);
       	
       	EObject res = null;
       	if(URIfrag.contains("/")) {
       		String[] v = URIfrag.split("/");
       		String className = v[0]; 
       		String featName = v[1];
       		res = ((EClass) ePack.getEClassifier(className)).getEStructuralFeature(featName);
       	}
       	else {
       		res = ePack.getEClassifier( URIfrag );
       	}
       	
       	return res;
	}
	

	private URIValue value;
    private ModelSubject subject;
}
