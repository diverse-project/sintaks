/**
 * 
 */
package fr.uha.mips.sintaks.ecore2hutn.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.internal.ide.misc.ResourceAndContainerGroup;

import fr.uha.mips.sintaks.ecore2hutn.Ecore2HUTNPlugin;

/**
 * @author dtouzet
 * @author Michel Hassenforder (customization)
 *
 */
public class SintaksDestFileWizardPage extends DestFileWizardPage {

	/**
	 * @param pageName
	 * @param selection
	 */
	public SintaksDestFileWizardPage(String pageName, IStructuredSelection selection) {
		super(pageName, selection);
		setPageComplete(false);
		this.currentSelection = selection;
	}
	
	/* (non-Javadoc)
	 * @see fr.irisa.triskell.kermeta.tools.wizards.DestFileWizardPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
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
	
	protected Button sMdlAllows;
	protected Button sMdlSelectBtn;
	protected Combo sMdlStartClass;
	protected List<String> concreteClasses;
	protected Button [] protectButtons;
	
	protected void createControls(Composite parent) {
		Font font = parent.getFont();

		Group sMdlSelectGrp = new Group(parent, SWT.NONE);
		sMdlSelectGrp.setLayout(new GridLayout(4, false));
		sMdlSelectGrp.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		sMdlSelectGrp.setFont(font);
		sMdlSelectGrp.setText("Parameters :");
		
		new Label(sMdlSelectGrp, SWT.LEFT).setText("Adjectives Allowed");
		sMdlAllows = new Button (sMdlSelectGrp, SWT.CHECK);

		new Label(sMdlSelectGrp, SWT.LEFT).setText("Start with");
		sMdlStartClass = new Combo (sMdlSelectGrp, SWT.DROP_DOWN);
		extractConcreteClasses ();
		for (String text : concreteClasses) {
			sMdlStartClass.add(text);
		}
		
		new Label(sMdlSelectGrp, SWT.LEFT).setText("Protections");
		new Label(sMdlSelectGrp, SWT.NONE).setText("");
		new Label(sMdlSelectGrp, SWT.NONE).setText("");
		new Label(sMdlSelectGrp, SWT.NONE).setText("");
		protectButtons = new Button [6];
		new Label(sMdlSelectGrp, SWT.LEFT).setText("Single Attribute");
		protectButtons [0] = new Button (sMdlSelectGrp, SWT.CHECK);
		new Label(sMdlSelectGrp, SWT.LEFT).setText("Multiple Attribute");
		protectButtons [1] = new Button (sMdlSelectGrp, SWT.CHECK);
		new Label(sMdlSelectGrp, SWT.LEFT).setText("Single Reference");
		protectButtons [2] = new Button (sMdlSelectGrp, SWT.CHECK);
		new Label(sMdlSelectGrp, SWT.LEFT).setText("Multiple Reference");
		protectButtons [3] = new Button (sMdlSelectGrp, SWT.CHECK);
		protectButtons [3].setSelection(true);
		new Label(sMdlSelectGrp, SWT.LEFT).setText("Single Container");
		protectButtons [4] = new Button (sMdlSelectGrp, SWT.CHECK);
		new Label(sMdlSelectGrp, SWT.LEFT).setText("Multiple Container");
		protectButtons [5] = new Button (sMdlSelectGrp, SWT.CHECK);
		protectButtons [5].setSelection(true);
	}
	
	private void extractConcreteClasses () {
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("ecore", new XMIResourceFactoryImpl());
		String workspacePath = ResourcesPlugin.getWorkspace().getRoot().getLocation().toString();
		ResourceSet resSet = new ResourceSetImpl();
		Resource inputResource = resSet.getResource(URI.createFileURI(workspacePath + '/' + inputFileName), true);
		EObject inputRoot = inputResource.getContents().get(0);
		concreteClasses = new ArrayList<String> ();
		TreeIterator<EObject> i = inputRoot.eAllContents();
		while (i.hasNext()) {
			EObject object = i.next();
			if (object instanceof EClass) {
				EClass aClass = ((EClass) object);
				if (! aClass.isInterface() && ! aClass.isAbstract()) {
					concreteClasses.add(aClass.getName());
				}
			}
		}
	}

	public boolean isAdjectivesAllowed () {
		return sMdlAllows.getSelection();
	}

	public String getStartClassName () {
		if (sMdlStartClass.getSelectionIndex() != -1)
			return concreteClasses.get(sMdlStartClass.getSelectionIndex());
		else return null;
	}
	
	public boolean [] getProtections () {
		boolean protects [] = new boolean [protectButtons.length];
		for (int i=0; i < protectButtons.length; ++i) {
			protects[i] = protectButtons[i].getSelection();
		}
		return protects;
	}
}
