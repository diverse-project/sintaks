package org.kermeta.sintaks.printer;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.kermeta.sintaks.sts.Rule;
import org.kermeta.sintaks.sts.URIValue;
import org.kermeta.sintaks.subject.ModelSubject;
import org.kermeta.sintaks.subject.OperationExecutor;


public class PrinterURIValue implements IPrinter {


	public PrinterURIValue(Rule value, ModelSubject subject) {
		super();
		this.value = (URIValue) value;
        this.subject = subject;
	}

	public void print(ISmartPrinter output) throws PrinterSemanticException {

    	PrinterRule.pushTrace (value, null, null);
		Object object;
		if(! value.getFeatures().isEmpty()) {
			object = OperationExecutor.getFeatures(subject, value.getFeatures());
        } else {
			object = OperationExecutor.pop(subject);
        }
        String text = getURIStringFromEObject((EObject) object);
		PrinterRule.printText(output, text, value.isSurroundingSpaces());
    	PrinterRule.setStateValidOrFailed(true);
        PrinterRule.popTrace();
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
