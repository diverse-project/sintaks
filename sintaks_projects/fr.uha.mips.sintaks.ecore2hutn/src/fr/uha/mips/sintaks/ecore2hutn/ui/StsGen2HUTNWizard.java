/* 
 * Project: sintaks
 * File: StsGen2HUTNWizard.java
 * License: EPL
 * Copyright: MIPS / Universite de Haute Alsace
 * ----------------------------------------------------------------------------
 * Creation date: Feb 4, 2009
 * Authors: 
 * 			Michel Hassenforder
 */
package fr.uha.mips.sintaks.ecore2hutn.ui;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;

import fr.uha.mips.sintaks.ecore2hutn.Master;

/**
 * @author Michel Hassenforder
 *
 */
public class StsGen2HUTNWizard extends SintaksWizard {

	/**
	 * 
	 */
	public StsGen2HUTNWizard() {
		super();
		defaultOutputExtension = "hutn.sts";
	}

	
	/* (non-Javadoc)
	 * @see fr.irisa.triskell.kermeta.tools.wizards.DavidWizard#writeUnit(org.eclipse.core.resources.IFile)
	 */
	@Override
	public void writeUnit(IFile targetFile) throws Exception {
		Master m = new Master();
		
		String workspacePath = ResourcesPlugin.getWorkspace().getRoot().getLocation().toString();

		m.getHUTNStsFromModel(
				URI.createFileURI(workspacePath + inputFile.getFullPath().toString()),
				URI.createFileURI(workspacePath + targetFile.getFullPath().toString())
		);

	}
	
	/**
	 * Adding the pages to the wizard.
	 */
	public void addPages() {
		SimpleGeneratorWizardPage newfilepage = new SimpleGeneratorWizardPage(OUTPUTFILE_PAGENAME, selection);
		newfilepage.setTitle("Create a sintaks genmodel:");
		newfilepage.setDescription("This wizard create a sintaks gen model file.\nPlease specify the output file name.");
		
		// Use the input file name with the sts extension as default
		String outputFileName = inputFile.getFullPath().removeFileExtension().addFileExtension(defaultOutputExtension).lastSegment();
		newfilepage.setInputFileName(inputFile.getFullPath().toString());
		newfilepage.setOutputFileName(outputFileName);
		addPage(newfilepage);
	}

}
