/**
 * 
 */
package org.kermeta.sintaks.ui;

import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;
import org.kermeta.sintaks.SintaksPlugin;



/**
 * @author dtouzet
 *
 */
public abstract class SintaksWizard extends Wizard {

	protected IStructuredSelection selection;
    protected IWorkbench workbench;
    protected IFile inputFile;

    //public DestFileWizardPage outputPage;
    public SintaksDestFileWizardPage outputPage;
    
    public String defaultOutputExtension = "toBeDefined";
    
    // Constants
    /** pagenames */
    public static final String OUTPUTFILE_PAGENAME = "OutputFile";
    
	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		
		SintaksPlugin.getDefault().getOptionManager().setSyntacticModel(outputPage.getSMdlText());
		IFile outputFile = outputPage.createNewFile();
		try {
			writeUnit(outputFile);
		}
		catch (Throwable e)	{
			Shell theShell = this.getContainer().getShell();
        	MessageDialog.openError(theShell,"Error writing file", "errors: "+ e.getMessage());
			e.printStackTrace();
			SintaksUIPlugin.log(e);
		}
		try { outputFile.getParent().refreshLocal(1, null); } catch (CoreException e) { }
		return true;
	}

	
	/**
	 * We will accept the selection in the workbench to see if
	 * we can initialize from it.
	 * @see IWorkbenchWizard#init(IWorkbench, IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
		this.workbench = workbench;
		if (selection instanceof StructuredSelection)
		{
			// the selection should be a single file
			Iterator it = selection.iterator();

			while(it.hasNext()) {
				inputFile = (IFile)it.next();
			}
		}
	}
	
	
	/**
	 * Adding the pages to the wizard.
	 */
	public void addPages() {
		
		//DestFileWizardPage newfilepage = new DestFileWizardPage(OUTPUTFILE_PAGENAME, selection);
		SintaksDestFileWizardPage newfilepage = new SintaksDestFileWizardPage(OUTPUTFILE_PAGENAME, selection);
		newfilepage.setTitle("Export to XMI / Destination file selection");
		newfilepage.setDescription("This wizard exports your file into a XMI file.\nPlease specify the output file name.");
		newfilepage.setSMdlText (SintaksPlugin.getDefault().getOptionManager().getSyntacticModel());
		
		// Use the input file name with the xmi extension as default
		String outputFileName = inputFile.getFullPath().removeFileExtension().addFileExtension(defaultOutputExtension).lastSegment();
		newfilepage.setFileName(outputFileName);
		outputPage = newfilepage;
		
		addPage(newfilepage);
	}
	
	protected URI getSyntaxModelURI () {
		URI smURI;
		String workspacePath = ResourcesPlugin.getWorkspace().getRoot().getLocation().toString();
		if(outputPage.getSMdlText().startsWith("platform:/plugin")){
			smURI = URI.createPlatformPluginURI(outputPage.getSMdlText().replace("platform:/plugin", ""),false);
		}
		else smURI = URI.createFileURI(workspacePath + outputPage.getSMdlFile().getFullPath().toString());
		return smURI;
	}

	/**
	 * @param ifile
	 * @throws Exception
	 */
	public abstract void writeUnit(IFile ifile) throws Exception;

}
