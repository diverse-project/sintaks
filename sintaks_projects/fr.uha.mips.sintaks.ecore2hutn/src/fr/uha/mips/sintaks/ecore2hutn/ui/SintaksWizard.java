/**
 * 
 */
package fr.uha.mips.sintaks.ecore2hutn.ui;

import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;

import fr.uha.mips.sintaks.ecore2hutn.Ecore2HUTNPlugin;



/**
 * @author dtouzet
 * @author Michel Hassenforder (customization)
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
		
		try {
			IFile outputFile = outputPage.createNewFile();				
			writeUnit(outputFile);
			outputFile.refreshLocal(1, null);
			outputFile.getParent().refreshLocal(1, null);
		}
		catch (Throwable e)	{
				Shell theShell = this.getContainer().getShell();
	        	MessageDialog.openError(theShell,"Error writing file", "errors: "+ e.getMessage());
				e.printStackTrace();
				Ecore2HUTNPlugin.log(e);
		}

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
		
		SintaksDestFileWizardPage newfilepage = new SintaksDestFileWizardPage(OUTPUTFILE_PAGENAME, selection);
		newfilepage.setTitle("Create a sintaks file using HUTN syntax");
		newfilepage.setDescription("This wizard creates a sts file using a HUTN syntax.\nPlease specify the output file name.");
		
		// Use the input file name with the sts extension as default
		String outputFileName = inputFile.getFullPath().removeFileExtension().addFileExtension(defaultOutputExtension).lastSegment();
		newfilepage.setInputFileName(inputFile.getFullPath().toString());
		newfilepage.setOutputFileName(outputFileName);
		outputPage = newfilepage;
		
		addPage(newfilepage);
	}
	
	

	/**
	 * @param ifile
	 * @throws Exception
	 */
	public abstract void writeUnit(IFile ifile) throws Exception;

}
