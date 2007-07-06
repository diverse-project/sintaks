package org.kermeta.sintaks.printer;

import java.io.PrintWriter;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;


import org.kermeta.sintaks.sts.Rule;
import org.kermeta.sintaks.sts.URIValue;
import org.kermeta.sintaks.subject.ModelSubject;
import org.kermeta.sintaks.subject.operation.OperationBuilder;


public class PrinterURIValue implements IPrinter {


	public PrinterURIValue(Rule value, ModelSubject subject) {
		super();
		this.value = (URIValue) value;
        this.subject = subject;
	}

	public void print(PrintWriter output) throws PrinterSemanticException {

    	OperationBuilder builder = new OperationBuilder();
		if(! value.getFeatures().isEmpty()) {
			EStructuralFeature feature = (EStructuralFeature) value.getFeatures().get(0);
        	builder.buildGetFeature(feature);
        } else {
        	builder.buildDupp();
        }
		builder.buildSetAccumulator();
		Object object = subject.process (builder.getOperation());

        String text = getURIStringFromEObject((EObject) object);
        if (text != null && text.length()!=0) {
        	output.print(IPrinter.separator);
        	if (text.indexOf(' ') != -1) {
        		output.print('"');
        		output.print(text);
        		output.print('"');
        	} else {
        		output.print(text);
        	}
    		output.print(IPrinter.separator);
        }
	}
	
	
	/**
	 * Get the URI string from the provided EObject
	 * @param obj
	 * @return
	 */
	private String getURIStringFromEObject(EObject eObj) {
		String packageURI = "";
		if(eObj instanceof EStructuralFeature) {
			packageURI = ((EPackage) eObj.eContainer().eContainer()).getNsURI();
		}
		else {
			// eObj instanceof EClass
			packageURI = ((EPackage) eObj.eContainer()).getNsURI();
		}

		Resource res = eObj.eResource();
        String frag = "#" + res.getURIFragment(eObj);
		
        return packageURI + frag;
	}

	
	private URIValue value;
    private ModelSubject subject;
}
