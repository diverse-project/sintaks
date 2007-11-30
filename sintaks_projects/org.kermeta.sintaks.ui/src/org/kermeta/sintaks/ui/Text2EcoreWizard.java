/*$Id: Text2EcoreWizard.java,v 1.2 2007-11-30 22:24:57 dvojtise Exp $
* Project : org.kermeta.sintaks
* File : 	Text2EcoreWizard.java
* License : EPL
* Copyright : IRISA / INRIA / Universite de Haute Alsace
* ----------------------------------------------------------------------------
* Creation date : 29 juin 07
* Authors : 
*/
/**
 * 
 */
package org.kermeta.sintaks.ui;


import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.kermeta.sintaks.main.Master;

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
		URI smURI;
		if(outputPage.getSMdlText().startsWith("platform:/plugin")){
			smURI = URI.createPlatformPluginURI(outputPage.getSMdlText().replace("platform:/plugin", ""),false);
		}
		else smURI = URI.createFileURI(workspacePath + outputPage.getSMdlFile().getFullPath().toString());
		m.getModelFromText(
			URI.createFileURI(workspacePath + inputFile.getFullPath().toString()),
			URI.createFileURI(workspacePath + targetFile.getFullPath().toString()),
			smURI
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
		
		// Eventually add new pages here
	}

}
