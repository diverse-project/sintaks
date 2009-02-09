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
 *  This class is the java entry point of the hutn project.
 *  It registers the ecore and sts extension as XMI files.
 *  Three methods allow to create HUTNlike sintaks file.
 *  The first one read an ecore file and create the sintaks file
 *  The second one read an ecore file and create the a sintaks genmodel file
 *  The third one read a sintaks genmodel file and create the sintaks file
 *  
 *  Of course :
 *     The first one is a standalone version nice to use in case of a nice Metamodel
 *     The two last work together in order to edit and customize the generated sintaks genmodel
 *     
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

    /**
     * Registers some known extension, if needed ?
     */
	private void register () {
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("ecore", new XMIResourceFactoryImpl());
		m.put("sts", new XMIResourceFactoryImpl());
		m.put("stsgen", new XMIResourceFactoryImpl());
	}

    /**
     * Given the input URI (an ecore file) a HUTNlike sintaks file is created and stored under the output URI.
     * The provider gives some hints to customize the generation :
     *    - the startClassName, the enclosing concept of all the stuff in the file
     *    - allowing of adjectives and their position (before or after the name/id of a class)
     *    - request or not the protection pattern for the different concept
     * The hints are globals and should be the best choice
     * 
     * @param input URI
     * @param output URI
     * @param startClassName String
     * @param allowAdjectives boolean
     * @param before boolean
     * @param protections boolean[7]
     */
	public void getHUTNStsFromModel(URI input, URI output,
			String startClassName, boolean allowAdjectives, boolean before, boolean protections [])
	{
		ResourceSet resSet = new ResourceSetImpl();

		Resource inputResource = resSet.getResource(input, true);
		EObject inputRoot = inputResource.getContents().get(0);

		SimplerAnalyser analyser = new SimplerAnalyser (startClassName, allowAdjectives, before, protections);
		Root stsModel = analyser.analyses (inputRoot);

		Resource outputResource = resSet.createResource(output);
		outputResource.getContents().add(stsModel);
		try {
			outputResource.save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    /**
     * Given the input URI (an ecore file) a sintaks genmodel file is created and stored under the output URI.
     * The provider gives some hints to customize the generation :
     *    - the startClassName, the enclosing concept of all the stuff in the file
     *    - allowing of adjectives and their position (before or after the name/id of a class)
     *    - request or not the protection pattern for the different concept
     * The hints are globals and should be the best choice
     * 
     * @param input URI
     * @param output URI
     * @param startClassName String
     * @param allowAdjectives boolean
     * @param before boolean
     * @param protections boolean[7]
     */
	public void createSTSgenFromModel(URI input, URI output,
			String startClassName, boolean allowAdjectives, boolean before, boolean protections [])
	{
		ResourceSet resSet = new ResourceSetImpl();

		Resource inputResource = resSet.getResource(input, true);
		EObject inputRoot = inputResource.getContents().get(0);

		StsgenCreator creator = new StsgenCreator (startClassName, allowAdjectives, before, protections);
		EObject stsgenModel = creator.analyses (inputRoot);

		Resource outputResource = resSet.createResource(output);
		outputResource.getContents().add(stsgenModel);
		try {
			outputResource.save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    /**
     * Given the input URI (a sintaks genmodel file) a HUTNlike sintaks file is created and stored under the output URI.
     * 
     * @param input URI
     * @param output URI
     */
	public void getHUTNStsFromModel(URI input, URI output) {
		ResourceSet resSet = new ResourceSetImpl();

		Resource inputResource = resSet.getResource(input, true);
		EObject inputRoot = inputResource.getContents().get(0);

		GuidedAnalyser analyser = new GuidedAnalyser ();
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
