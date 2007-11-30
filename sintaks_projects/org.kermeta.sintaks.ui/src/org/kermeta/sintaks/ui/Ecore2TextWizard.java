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
		URI smURI;
		if(outputPage.getSMdlText().startsWith("platform:/plugin")){
			smURI = URI.createPlatformPluginURI(outputPage.getSMdlText().replace("platform:/plugin", ""),false);
		}
		else smURI = URI.createFileURI(workspacePath + outputPage.getSMdlFile().getFullPath().toString());
		m.getTextFromModel(
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
		outputPage.setTitle("Export to text:");
		outputPage.setDescription("This wizard exports your model into a textual file.\nPlease specify the output file name.");
		
		// Eventually add new pages here
	}

}
