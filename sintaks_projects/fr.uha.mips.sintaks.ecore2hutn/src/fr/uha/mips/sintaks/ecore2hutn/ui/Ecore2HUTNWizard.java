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
		
		String workspacePath = ResourcesPlugin.getWorkspace().getRoot().getLocation().toString();
		m.getHUTNStsFromModel(
				URI.createFileURI(workspacePath + inputFile.getFullPath().toString()),
				URI.createFileURI(workspacePath + targetFile.getFullPath().toString()),
				outputPage.getStartClassName(),
				outputPage.isAdjectivesAllowed(),
				outputPage.getProtections()
		);
	}
	
	
	/**
	 * Adding the pages to the wizard.
	 */
	public void addPages() {
		super.addPages();
		
		// Customize the already added pages
		outputPage = (SintaksDestFileWizardPage) this.getPage(OUTPUTFILE_PAGENAME);
		outputPage.setTitle("Export to text:");
		outputPage.setDescription("This wizard exports your model into a textual file.\nPlease specify the output file name.");
		
		// Eventually add new pages here
	}

}
