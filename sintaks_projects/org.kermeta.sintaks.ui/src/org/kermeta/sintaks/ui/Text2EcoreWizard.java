/*$Id: Text2EcoreWizard.java,v 1.4 2008-07-18 13:33:15 hassen Exp $
* Project : org.kermeta.sintaks
* File : 	Text2EcoreWizard.java
* License : EPL
* Copyright : IRISA / INRIA / Universite de Haute Alsace
* ----------------------------------------------------------------------------
* Creation date : 29 juin 07
* Authors : 
*   David Touzet
*   Didier Vojtisek
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
public class Text2EcoreWizard extends SintaksWizard {

	/**
	 * 
	 */
	public Text2EcoreWizard() {
		super();
		defaultOutputExtension = "xmi";
	}

	/* (non-Javadoc)
	 * @see fr.irisa.triskell.kermeta.tools.wizards.DavidWizard#writeUnit(org.eclipse.core.resources.IFile)
	 */
	@Override
	public void writeUnit(IFile targetFile) throws Exception {
		Master m = new Master();
		String workspacePath = ResourcesPlugin.getWorkspace().getRoot().getLocation().toString();
		m.getModelFromText(
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
		outputPage.setTitle("Import to Ecore:");
		outputPage.setDescription("This wizard imports your file into an Ecore model.\nPlease specify the output file name.");
		
		if(inputFile.getFileExtension() != null){
			String OutputExtension = RegisteringHelper.getModelExtensionForTextExtension(inputFile.getFileExtension());
			String outputFileName = inputFile.getFullPath().removeFileExtension().addFileExtension(OutputExtension).lastSegment();
			outputPage.setFileName(outputFileName);
			URI stsURI = RegisteringHelper.getSTSforTextExtension(inputFile.getFileExtension());
			if(stsURI != null)
				outputPage.setSMdlText(stsURI.toString());
		}
		// Eventually add new pages here
	}

}
