/* 
 * Project: sintaks
 * File: Master.java
 * License: EPL
 * Copyright: MIPS / Universite de Haute Alsace
 * ----------------------------------------------------------------------------
 * Creation date: Dec 24, 2007
 * Authors: 
 * 			Michel Hassenforder
 * Note:
 * 
 *  This class is the java entry point of the project. It registers the ecore and sts extension as
 *  XMI files.
 */

package fr.uha.mips.sintaks.ecore2hutn;

import java.io.IOException;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.kermeta.sintaks.sts.Root;

public class Master {

	public Master() {
		super();
		register ();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	}

	private void register () {
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("ecore", new XMIResourceFactoryImpl());
		m.put("sts", new XMIResourceFactoryImpl());
	}

    /**
     * Given the input URI (an ecore file) a hutn like sintaks file is create and stored under the output URI.
     * The provider gives the startClassName, as the enclosing concept of all the stuff in the file and
     * it can choose (or not) to allow single attributes used as adjectives.
     * 
     * @param input URI
     * @param output URI
     * @param startClassName String
     * @param allowAdjectives boolean
     */
	public void getHUTNStsFromModel(URI input, URI output, String startClassName, boolean allowAdjectives) {

		ResourceSet resSet = new ResourceSetImpl();

		Resource inputResource = resSet.getResource(input, true);
		EObject inputRoot = inputResource.getContents().get(0);

		Analyser analyser = new Analyser (startClassName, allowAdjectives);
		Root stsModel = analyser.analyses (inputRoot);

		Resource outputResource = resSet.createResource(output);
		outputResource.getContents().add(stsModel);
		try {
			outputResource.save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    

}
