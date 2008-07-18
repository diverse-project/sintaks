/* $Id: Ecore2TextWizard.java,v 1.4 2008-07-18 13:33:15 hassen Exp $
 * Project : sintaks.ui
 * File : Ecore2TextWizard.java
 * License : EPL
 * Copyright : IRISA / INRIA/ Universite de Rennes 1
 * ----------------------------------------------------------------------------

 * Authors : 
 * 		David Touzet 
 *      Didier Vojtisek
 */
/**
 * 
 */
package org.kermeta.sintaks.ui;


import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.kermeta.sintaks.main.Master;
import org.kermeta.sintaks.registering.RegisteringHelper;


/**
 * @author dtouzet
 *
 */
public class Ecore2TextWizard extends SintaksWizard {

	/**
	 * 
	 */
	public Ecore2TextWizard() {
		super();
		defaultOutputExtension = "txt";
	}

	
	/* (non-Javadoc)
	 * @see fr.irisa.triskell.kermeta.tools.wizards.DavidWizard#writeUnit(org.eclipse.core.resources.IFile)
	 */
	@Override
	public void writeUnit(IFile targetFile) throws Exception {
		Master m = new Master();
		String workspacePath = ResourcesPlugin.getWorkspace().getRoot().getLocation().toString();
		m.getTextFromModel(
			URI.createFileURI(workspacePath + inputFile.getFullPath().toString()),
			URI.createFileURI(workspacePath + targetFile.getFullPath().toString()),
			getSyntaxModelURI ()
		);
	}
	
	
	/**
	 * Adding the pages to the wizard.
	 */
	public void addPages() {
		super.addPages();
		
		// Customize the already added pages
		outputPage = (SintaksDestFileWizardPage)this.getPage(OUTPUTFILE_PAGENAME);
		outputPage.setTitle("Export to text:");
		outputPage.setDescription("This wizard exports your model into a textual file.\nPlease specify the output file name.");
		
		if(inputFile.getFileExtension() != null){
			String OutputExtension = RegisteringHelper.getTextExtensionForModelExtension(inputFile.getFileExtension());
			String outputFileName = inputFile.getFullPath().removeFileExtension().addFileExtension(OutputExtension).lastSegment();
			outputPage.setFileName(outputFileName);
			URI stsURI = RegisteringHelper.getSTSforModelExtension(inputFile.getFileExtension());
			if(stsURI != null)
				outputPage.setSMdlText(stsURI.toString());
		}
		// Eventually add new pages here
	}

}
