package org.kermeta.sintaks.main;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

import org.kermeta.sintaks.SintaksPlugin;
import org.kermeta.sintaks.parser.MetaModelParser;
import org.kermeta.sintaks.parser.ModelParser;
import org.kermeta.sintaks.parser.ModelPrinter;
import org.kermeta.sintaks.sts.Template;
import org.kermeta.sintaks.subject.ModelSubject;



/**
 * @author dtouzet
 *
 */
public class Master {
	
    private ModelParser parser;
	private ModelSubject subject;
	private ModelPrinter printer;
	private ResourceSet resSet;
    
	/**
	 * @param mmFile
	 */
	public Master() {
		this.resSet  = new ResourceSetImpl();
		this.parser  = null;
		this.printer = null;
		this.subject = null;
	}
	
	
	/**
	 * @param ruleURI
	 * @param inputURI
	 * @return
	 */
	private boolean parse (URI ruleURI, URI inputURI) {
        if (SintaksPlugin.getDefault().getOptionManager().isDebugProcess())
        	SintaksPlugin.getDefault().debugln("Parsing file: " + inputURI.lastSegment());
        boolean ok = parser.parse(ruleURI, inputURI);
        if (SintaksPlugin.getDefault().getOptionManager().isDebugProcess())
        	SintaksPlugin.getDefault().debugln("Parse finished");
        return ok;
	}

	
	/**
	 * @param ruleURI
	 * @param inputURI
	 * @return
	 */
	private boolean parse (URI ruleURI, String text) {
        boolean ok = parser.parse(ruleURI, text);
        return ok;
	}

	
	/**
	 * @param ruleURI
	 * @param inputURI
	 */
	private void print (URI ruleURI, URI inputURI) {
        String realName = inputURI.toFileString();
        
        if (SintaksPlugin.getDefault().getOptionManager().isDebugProcess())
			SintaksPlugin.getDefault().debugln("Printing file: " + realName);
        printer.print(ruleURI, realName);
        if (SintaksPlugin.getDefault().getOptionManager().isDebugProcess())
        	SintaksPlugin.getDefault().debugln("Print finished");
	}

	
	/**
	 * @param inputURI
	 */
	private void load (URI inputURI) {
        if (SintaksPlugin.getDefault().getOptionManager().isDebugProcess())
        	SintaksPlugin.getDefault().debugln("Loading file: " + inputURI.lastSegment());
        subject.load(inputURI);
        if (SintaksPlugin.getDefault().getOptionManager().isDebugProcess())
        	SintaksPlugin.getDefault().debugln("Load finished");
	}

	
	/**
	 * @param outputURI
	 */
	private void store (URI outputURI) {
        if (SintaksPlugin.getDefault().getOptionManager().isDebugProcess())
        	SintaksPlugin.getDefault().debugln("Storing file: " + outputURI.lastSegment());
        subject.store(outputURI);
        if (SintaksPlugin.getDefault().getOptionManager().isDebugProcess())
        	SintaksPlugin.getDefault().debugln("Store finished");
	}

    
	/**
     * @param inputURI
     * @param outputURI
     * @param ruleURI
     */
    public void getModelFromText(URI inputURI, URI outputURI, URI ruleURI) {
    	this.subject = new ModelSubject (new MetaModel(resSet));
		this.parser  = new ModelParser (new MetaModelParser(resSet), subject);

		try {
			this.parse(ruleURI, inputURI);
			if (subject.isReady()) {
				this.store(outputURI);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			SintaksPlugin.log(e);
		}
    }

    
    /**
     * @param text
     * @param ruleURI
     * @return
     */
    public EObject getModelFromText(String text, URI ruleURI) {
      	this.subject = new ModelSubject (new MetaModel(resSet));
		this.parser  = new ModelParser (new MetaModelParser(resSet), subject);
		try {
			boolean ok = this.parse(ruleURI, text);
            if(! ok ) return null;
 
            return subject.getModel();
 		}
		catch (Exception e) {
			e.printStackTrace();
			SintaksPlugin.log(e);
		}
		return null;
    }
    

    /**
     * @param inputURI
     * @param outputURI
     * @param ruleURI
     */
    public void getTextFromModel(URI inputURI, URI outputURI, URI ruleURI) {
    	this.subject = new ModelSubject (new MetaModel(resSet));
        this.printer = new ModelPrinter (new MetaModelParser(resSet), subject);

    	try {
    		boolean ok = checkMetamodelUnicity(inputURI, ruleURI);
    		
    		if(ok) {
    			this.load (inputURI);
                this.print(ruleURI, outputURI);
    		} else {
    		    MessageDialog.openWarning(
    		    	new Shell(),
    				"Error",
    				"Source and syntactic models point to different instances of target metamodel.\n"
    			);
    			
    		}
 		}
		catch (Exception e) {
			e.printStackTrace();
			SintaksPlugin.log(e);
		}
    }
    
    
    /**
     * @param inputURI
     * @param ruleURI
     * @return
     */
    private boolean checkMetamodelUnicity(URI inputURI, URI ruleURI) {
    	EPackage p = null;
    	EPackage inputPack = null;
    	EPackage rulePack = null;
    	
    	// Step1:
    	Resource inputRes = resSet.getResource(inputURI, true);
		EObject e = (EObject) inputRes.getContents().get(0);
    	p = (EPackage) e.eClass().eContainer();
    	inputPack = getRootPackage(p);
    	
    	// Step2:
    	Resource ruleRes = resSet.getResource(ruleURI, true);
    	TreeIterator i = ruleRes.getAllContents();
    	boolean loop = true;
    	EClass c = null;
    	while(i.hasNext() && loop) {
    		EObject obj = (EObject) i.next();
    		if(obj instanceof Template) {
    			c = ((Template) obj).getMetaclass();
    			loop = false;
    		}
    	}
    	p = (EPackage) c.eContainer();
    	rulePack = getRootPackage(p);
    	
    	return (inputPack == rulePack);
    }
    
    
    /**
     * @param p
     * @return
     */
    private EPackage getRootPackage(EPackage p) {
    	EPackage crtPack = p;
    	EObject container = crtPack.eContainer();
    	
    	while(container instanceof EPackage) {
    		crtPack = (EPackage) container;
    		container = crtPack.eContainer();
    	}

    	return crtPack;
    }
}
