/**
 * 
 */
package fr.uha.mips.sintaks.ecore2hutn.ui;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
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

    protected IWorkbench workbench;
    protected IStructuredSelection selection;
    protected IFile inputFile;

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
			SimpleGeneratorWizardPage outputPage = (SimpleGeneratorWizardPage) this.getPage(OUTPUTFILE_PAGENAME);
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
		this.workbench = workbench;
		this.selection = selection;
		inputFile = (IFile) selection.getFirstElement();
	}
	
	/**
	 * @param ifile
	 * @throws Exception
	 */
	public abstract void writeUnit(IFile ifile) throws Exception;

}
