/**
 * 
 */
package fr.uha.mips.sintaks.ecore2hutn.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
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
	
	protected Group sMdlSelectGrp;
	protected Label sAllowLbl, sStartLbl;
	protected Button sMdlAllows;
	protected Button sMdlSelectBtn;
	protected Combo sMdlStartClass;
	protected List<String> concreteClasses;
	
	protected void createControls(Composite parent) {
		Font font = parent.getFont();

		sMdlSelectGrp = new Group(parent, SWT.NONE);
		GridLayout sMdlLayout = new GridLayout(5, false);
		sMdlSelectGrp.setLayout(sMdlLayout);
		sMdlSelectGrp.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		sMdlSelectGrp.setFont(font);
		sMdlSelectGrp.setText("Parameters :");
		
		sAllowLbl = new Label(sMdlSelectGrp, SWT.LEFT);
		sAllowLbl.setText("Syntactic model: ");
		
		sMdlAllows = new Button (sMdlSelectGrp, SWT.CHECK);
		sMdlAllows.setText("Adjectives Allowed");
		sMdlAllows.setLayoutData( new GridData(GridData.FILL_HORIZONTAL));

		sStartLbl = new Label(sMdlSelectGrp, SWT.LEFT);
		sStartLbl.setText("Start : ");
		
		sMdlStartClass = new Combo (sMdlSelectGrp, SWT.DROP_DOWN);
		extractConcreteClasses ();
		
		for (String text : concreteClasses) {
			sMdlStartClass.add(text);
		}
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
		if (inputRoot instanceof EPackage) {
			for (EClassifier classifier : ((EPackage) inputRoot).getEClassifiers()) { 
				if (classifier instanceof EClass) {
					EClass aClass = ((EClass) classifier);
					if (! aClass.isInterface() && ! aClass.isAbstract()) {
						concreteClasses.add(aClass.getName());
					}
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
}
