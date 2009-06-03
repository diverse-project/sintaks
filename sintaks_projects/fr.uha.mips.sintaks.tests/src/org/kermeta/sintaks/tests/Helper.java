package org.kermeta.sintaks.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.Assert;
import org.kermeta.sintaks.main.Master;
import org.kermeta.sintaks.trace.State;
import org.kermeta.sintaks.trace.Trace;
import org.kermeta.sintaks.trace.TraceModel;

public class Helper {

	private String relativePath;
	private String ecoreFile;
	private String prefix;

	public Helper(String relativePath, String ecoreFile, String prefix) {
		super();
		this.relativePath = relativePath;
		this.ecoreFile = ecoreFile;
		this.prefix = prefix;
	}

	private String absoluteFilename(String relativeFilename, boolean checkExistance) {
		File file = new File (relativePath + "/" + relativeFilename);
		String absolutePath = file.getAbsolutePath();
		if (checkExistance && ! file.exists()) throw new Error ("File doesn't exist "+absolutePath);
		return absolutePath;
	}

	private void registerPackages(EPackage pack) {
		if( pack.getNsURI() != null && !pack.getNsURI().equals("") ) {
			Registry.INSTANCE.put(pack.getNsURI(), pack);
			for(EPackage subPack : pack.getESubpackages()) {
				registerPackages(subPack);
			}
		}
	}

	private void register (String filename) {
		ResourceSet rs = new ResourceSetImpl();
		URI metaModelURI = URI.createFileURI (absoluteFilename (filename, false));
		Resource res = rs.getResource(metaModelURI, true);
		for(EObject eobj : res.getContents()) {
			if( eobj instanceof EPackage) {
				registerPackages((EPackage) eobj);
			}
		}
	}
	
	private URI createFileURI (String filename, boolean checkExistance ) {
		return URI.createFileURI (absoluteFilename (filename, false));
	}

	private boolean checkSuccess(String traceFilename) {
		URI traceURI = URI.createFileURI (absoluteFilename (traceFilename, false));
		ResourceSet rs = new ResourceSetImpl();
		Resource res = rs.getResource (traceURI, true);
		EObject object = res.getContents().get(0);
		if (object == null) return false;
		if (! (object instanceof TraceModel)) return false;
		TraceModel model = (TraceModel) object;
		Trace trace = model.getTrace();
		if (trace == null) return false;
		return trace.getState() == State.OK;
	}

	private int read (Reader reader) throws IOException {
		while (true) {
			int c = reader.read();
			if (c != 10 && c != 13) return c;
		}
	}

	private boolean checkEquality(URI outputURI, URI targetURI) {
        try {
        	File outputFile = new File(outputURI.toFileString());
            Reader outputReader = new BufferedReader(new FileReader(outputFile), (int) outputFile.length());
        	File targetFile = new File(targetURI.toFileString());
            Reader targetReader = new BufferedReader(new FileReader(targetFile), (int) targetFile.length());
            while (true) {
            	int c1 = read(targetReader);
            	int c2 = read(outputReader);
            	if (c1 != c2) return false;
            	if (c1 == -1 && c2 == -1) return true;
            	if (c1 == -1) return false;
            	if (c2 == -1) return false;
            }
        }
        catch (Exception e) {
            return false;
        }
	}

	public int checkText2Model() {
		register (ecoreFile);
		try {
			URI inputURI = createFileURI (prefix + "-input.txt", true);
			URI outputURI = createFileURI (prefix + "-output.xmi", false);
			URI targetURI = createFileURI (prefix + "-target.xmi", false);
			URI ruleURI = createFileURI ("model.sts", true);
			Master m = new Master();
			m.getModelFromText(inputURI, outputURI, ruleURI);
			if (! checkSuccess ("debug.trace")) return Helper.TRANSFORMATION;
			if (! checkEquality (outputURI, targetURI)) return Helper.EQUALITY;
			return Helper.SUCCESS;
		}
		catch (Exception exception) {
			exception.printStackTrace();
			return Helper.EXECUTION;
		}
		catch (Error error) {
			return Helper.EXECUTION;
		}
	}

	public int checkModel2Text () {
		register (ecoreFile);
		try {
			URI inputURI = createFileURI (prefix + "-input.xmi", true);
			URI outputURI = createFileURI (prefix + "-output.txt", false);
			URI targetURI = createFileURI (prefix + "-target.txt", false);
			URI ruleURI = createFileURI ("model.sts", true);
			Master m = new Master();
			m.getTextFromModel(inputURI, outputURI, ruleURI);
			if (! checkSuccess ("debug.trace")) return Helper.TRANSFORMATION;
			if (! checkEquality (outputURI, targetURI)) return Helper.EQUALITY;
			return Helper.SUCCESS;
		}
		catch (Exception exception) {
			return Helper.EXECUTION;
		}
		catch (Error error) {
			return Helper.EXECUTION;
		}
	}

	public void reportSuccess (int code) {
		switch (code) {
		case Helper.EXECUTION : Assert.fail ("Execution problem with " + prefix); break;
		case Helper.EQUALITY : Assert.fail ("Equality problem with " + prefix); break;
		case Helper.TRANSFORMATION : Assert.fail ("Transformation problem with " + prefix); break;
		default : break;
		}
	}

	public static final int SUCCESS = 0;
	public static final int EXECUTION = 1;
	public static final int TRANSFORMATION = 2;
	public static final int EQUALITY = 3;
}
