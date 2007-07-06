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
		m.getModelFromText(
			URI.createFileURI(workspacePath + inputFile.getFullPath().toString()),
			URI.createFileURI(workspacePath + targetFile.getFullPath().toString()),
			URI.createFileURI(workspacePath + outputPage.getSMdlFile().getFullPath().toString())
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
