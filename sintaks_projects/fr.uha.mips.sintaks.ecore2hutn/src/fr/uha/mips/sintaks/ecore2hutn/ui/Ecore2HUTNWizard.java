/* 
 * Project: sintaks
 * File: Ecore2HUTNWizard.java
 * License: EPL
 * Copyright: MIPS / Universite de Haute Alsace
 * ----------------------------------------------------------------------------
 * Creation date: Dec 24, 2007
 * Authors: 
 * 			Michel Hassenforder
 */
package fr.uha.mips.sintaks.ecore2hutn.ui;


import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;

import fr.uha.mips.sintaks.ecore2hutn.Ecore2HUTNPlugin;
import fr.uha.mips.sintaks.ecore2hutn.Master;


/**
 * @author Michel Hassenforder
 *
 */
public class Ecore2HUTNWizard extends SintaksWizard {

	/**
	 * 
	 */
	public Ecore2HUTNWizard() {
		super();
		defaultOutputExtension = "hutn.sts";
	}

	
	/* (non-Javadoc)
	 * @see fr.irisa.triskell.kermeta.tools.wizards.DavidWizard#writeUnit(org.eclipse.core.resources.IFile)
	 */
	@Override
	public void writeUnit(IFile targetFile) throws Exception {
		Master m = new Master();
		GuidedGeneratorWizardPage outputPage = (GuidedGeneratorWizardPage) this.getPage(OUTPUTFILE_PAGENAME);

		String workspacePath = ResourcesPlugin.getWorkspace().getRoot().getLocation().toString();
		boolean adjectivesAllowed = outputPage.isAdjectivesAllowed();
		boolean adjectivesBefore = outputPage.isBefore();
		boolean [] protections = outputPage.getProtections();
		Ecore2HUTNPlugin.getDefault().getOptionManager().setAdjectiveAllowed(adjectivesAllowed);
		Ecore2HUTNPlugin.getDefault().getOptionManager().setAdjectiveBefore(adjectivesBefore);
		Ecore2HUTNPlugin.getDefault().getOptionManager().setProtections(protections);
		m.getHUTNStsFromModel(
				URI.createFileURI(workspacePath + inputFile.getFullPath().toString()),
				URI.createFileURI(workspacePath + targetFile.getFullPath().toString()),
				outputPage.getStartClassName(),
				adjectivesAllowed, adjectivesBefore, protections
		);
	}
	
	
	/**
	 * Adding the pages to the wizard.
	 */
	public void addPages() {
		GuidedGeneratorWizardPage newfilepage = new GuidedGeneratorWizardPage(OUTPUTFILE_PAGENAME, selection);
		newfilepage.setTitle("Create a sintaks HUTN model:");
		newfilepage.setDescription("This wizard create a sintaks file.\nPlease specify the output file name.");
		
		// Use the input file name with the sts extension as default
		String outputFileName = inputFile.getFullPath().removeFileExtension().addFileExtension(defaultOutputExtension).lastSegment();
		newfilepage.setInputFileName(inputFile.getFullPath().toString());
		newfilepage.setOutputFileName(outputFileName);
		addPage(newfilepage);
	}

}
