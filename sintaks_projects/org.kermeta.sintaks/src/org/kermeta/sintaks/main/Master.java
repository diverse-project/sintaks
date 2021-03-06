/* $Id: Master.java,v 1.7 2008-07-22 13:21:35 hassen Exp $
 * Project    : Sintaks
 * File       : Master.java
 * License    : EPL
 * Copyright  : IRISA / INRIA / Universite de Haute Alsace
 * -------------------------------------------------------------------
 * Creation date : 21 juil. 2005
 * Authors : 
 * 			Michel Hassenforder <michel.hassenforder@uha.fr>
 * 			David Touzet <dtouzet@irisa.fr>
 *        	dvojtise <dvojtise@irisa.fr>
 */
package org.kermeta.sintaks.main;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.PackageNotFoundException;
import org.kermeta.sintaks.SintaksPlugin;
import org.kermeta.sintaks.errors.UserError;
import org.kermeta.sintaks.parser.MetaModelParser;
import org.kermeta.sintaks.parser.ModelParser;
import org.kermeta.sintaks.printer.ModelPrinter;
import org.kermeta.sintaks.sts.Template;
import org.kermeta.sintaks.subject.ModelSubject;
import org.kermeta.sintaks.trace.State;
import org.kermeta.sintaks.trace.Trace;
import org.kermeta.sintaks.trace.util.Tracer;



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
        boolean ok = parser.parse(ruleURI, inputURI);
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
        printer.print(ruleURI, realName);
	}

	
	/**
	 * @param inputURI
	 */
	private void load (URI inputURI) {
        subject.load(inputURI);
	}

	
	/**
	 * @param outputURI
	 */
	private void store (URI outputURI) {
        subject.store(outputURI);
	}

    
	/**
     * @param inputURI
     * @param outputURI
     * @param ruleURI
     */
    public void getModelFromText(URI inputURI, URI outputURI, URI ruleURI) {
    	this.subject = new ModelSubject (new MetaModel(resSet));
		this.parser  = new ModelParser (new MetaModelParser(resSet), subject);

		SintaksPlugin.getDefault().setTracer(new Tracer (resSet));
		Trace trace = SintaksPlugin.getDefault().getTracer().newRootTrace(
				ruleURI.toString(),
				inputURI.toString(),
				outputURI.toString(),
				"Files used");
		SintaksPlugin.getDefault().getTracer().push(trace);

		try {
			if (this.parse(ruleURI, inputURI)) {
				if (subject.isReady()) {
					if(subject.getModel() != null) {
						this.store(outputURI);
						trace.setState(State.OK);
					} else {
						SintaksPlugin.getDefault().reportErrorToUser("Cannot produce output, there is nothing recognized to put in the model");
						trace.setState(State.FAILURE);
					}
				} else {
					SintaksPlugin.getDefault().reportErrorToUser("Cannot produce output, there are still some \"ghosts\" which haven't been correctly recognized");
					trace.setState(State.FAILURE);
				}
			} else {
				SintaksPlugin.getDefault().reportErrorToUser("Cannot produce output, the parser failed to read the file");
				trace.setState(State.CANCELED);
			}
		}
		catch(UserError ue){
			trace.setState(State.CANCELED);
			SintaksPlugin.getDefault().reportErrorToUser(ue.getMessage());
			SintaksPlugin.logErrorMessage(ue.getMessage(), ue);
		}
		catch (Exception e) {
			trace.setState(State.CANCELED);
			e.printStackTrace();
			SintaksPlugin.log(e);
		}
    	URI traceURI = outputURI.appendSegments(new String [] { "..", SintaksPlugin.getDefault().getOptionManager().getDebugOutputFile() } );
		SintaksPlugin.getDefault().getTracer().save(traceURI);
		SintaksPlugin.getDefault().setTracer(null);
    }

    
    /**
     * @param text
     * @param ruleURI
     * @return
     */
    public EObject getModelFromText(String text, URI ruleURI) {
      	this.subject = new ModelSubject (new MetaModel(resSet));
		this.parser  = new ModelParser (new MetaModelParser(resSet), subject);
		
		SintaksPlugin.getDefault().setTracer(new Tracer (resSet));
		try {
			boolean ok = this.parse(ruleURI, text);
            if(! ok ) return null;
 
            return subject.getModel();
 		}
		catch(UserError ue){
			SintaksPlugin.logErrorMessage(ue.getMessage(), ue);
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

		SintaksPlugin.getDefault().setTracer(new Tracer (resSet));
		Trace trace = SintaksPlugin.getDefault().getTracer().newRootTrace(
				ruleURI.toString(),
				inputURI.toString(),
				outputURI.toString(),
				"Files used");
		SintaksPlugin.getDefault().getTracer().push(trace);

		try {
    		boolean ok = checkMetamodelUnicity(inputURI, ruleURI);
    		if(ok) {
    			this.load (inputURI);
                this.print(ruleURI, outputURI);
				trace.setState(State.OK);
    		} else {
    			SintaksPlugin.getDefault().reportErrorToUser("Source and syntactic models point to different instances of target metamodel.\n");
    		}
 		}
		catch(UserError ue){
			SintaksPlugin.getDefault().reportErrorToUser(ue.getMessage());
			SintaksPlugin.logErrorMessage(ue.getMessage(), ue);
			trace.setState(State.FAILURE);
		}
		catch (Exception e) {
			if(e.getCause() instanceof PackageNotFoundException){
				SintaksPlugin.getDefault().reportErrorToUser("Cannot load model because the metamodel is not correctly registered.\n"+e.getMessage());
				SintaksPlugin.logErrorMessage("Cannot load model because the metamodel is not correctly registered.\n"+e.getMessage(), e);
			} else{
				e.printStackTrace();
				SintaksPlugin.log(e);
			}
			trace.setState(State.FAILURE);
		}
    	URI traceURI = outputURI.appendSegments(new String [] { "..", SintaksPlugin.getDefault().getOptionManager().getDebugOutputFile() } );
		SintaksPlugin.getDefault().getTracer().save(traceURI);
		SintaksPlugin.getDefault().setTracer(null);
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
    	TreeIterator<EObject> i = ruleRes.getAllContents();
    	boolean loop = true;
    	EClass c = null;
    	while(i.hasNext() && loop) {
    		EObject obj = i.next();
    		if(obj instanceof Template) {
    			c = ((Template) obj).getMetaclass();
    			loop = false;
    		}
    	}
    	p = (EPackage) c.eContainer();
    	if(p == null){
			throw new UserError("Not able to retreive the container EPackage of the user metamodel from the sts file. \nPlease check that your registered URI conforms to the one used in the STS file.");
    	}
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
