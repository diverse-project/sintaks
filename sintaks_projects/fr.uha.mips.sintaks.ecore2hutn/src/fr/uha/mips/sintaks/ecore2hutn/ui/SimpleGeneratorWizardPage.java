/**
 * 
 */
package fr.uha.mips.sintaks.ecore2hutn.ui;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.internal.ide.misc.ResourceAndContainerGroup;

import fr.uha.mips.sintaks.ecore2hutn.Ecore2HUTNPlugin;

/**
 * @author dtouzet
 * @author Michel Hassenforder (customization)
 *
 */
public class SimpleGeneratorWizardPage extends DestFileWizardPage {

	/**
	 * @param pageName
	 * @param selection
	 */
	public SimpleGeneratorWizardPage(String pageName, IStructuredSelection selection) {
		super(pageName, selection);
		setPageComplete(false);
	}
	
	/* (non-Javadoc)
	 * @see fr.irisa.triskell.kermeta.tools.wizards.DestFileWizardPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	@SuppressWarnings("restriction")
	public void createControl(Composite parent) {
		initializeDialogUnits(parent);
		// top level group
		topLevel = new Composite(parent,SWT.NONE);
		topLevel.setLayout(new GridLayout());
		topLevel.setLayoutData(new GridData(
			GridData.VERTICAL_ALIGN_FILL | GridData.HORIZONTAL_ALIGN_FILL));
		topLevel.setFont(parent.getFont());
		//WorkbenchHelp.setHelp(topLevel, IHelpContextIds.NEW_FILE_WIZARD_PAGE);
		
		createPreControls(topLevel);
		
		// Resource and container group
		resourceGroup = new ResourceAndContainerGroup(topLevel, this, getNewFileLabel(), 
				Ecore2HUTNPlugin.getResourceString("Sintaks.NEWFILE"), false, SIZING_CONTAINER_GROUP_HEIGHT); //$NON-NLS-1$
		resourceGroup.setAllowExistingResources(false);
		initialPopulateContainerNameField();
		createFileExistsBehaviorControls(topLevel);
		createAdvancedControls(topLevel);
		
		createControls(topLevel);
		
		if (initialFileName != null)
			resourceGroup.setResource(initialFileName);
		
		// Show description on opening
		setErrorMessage(null);
		setMessage(null);
		setControl(topLevel);
		validatePage();
	}

	protected void createControls(Composite topLevel) {
		
	}

}
