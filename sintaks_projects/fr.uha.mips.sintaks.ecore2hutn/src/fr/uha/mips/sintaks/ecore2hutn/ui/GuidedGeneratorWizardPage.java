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

/**
 * @author dtouzet
 * @author Michel Hassenforder (customization)
 *
 */
public class GuidedGeneratorWizardPage extends SimpleGeneratorWizardPage {

	/**
	 * @param pageName
	 * @param selection
	 */
	public GuidedGeneratorWizardPage(String pageName, IStructuredSelection selection) {
		super(pageName, selection);
	}
	
	protected Button sMdlAllows;
	protected Button sMdlBefore;
	protected Button sMdlSelectBtn;
	protected Combo sMdlStartClass;
	protected List<String> concreteClasses;
	protected Button [] protectButtons;
	
	protected void createControls(Composite parent) {
		Font font = parent.getFont();
		
		Group startGroup = new Group(parent, SWT.NONE);
		startGroup.setLayout(new GridLayout(2, false));
		startGroup.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		startGroup.setFont(font);
		startGroup.setText("Start Symbol");
		new Label(startGroup, SWT.LEFT).setText("Start with");
		sMdlStartClass = new Combo (startGroup, SWT.DROP_DOWN);
		extractConcreteClasses ();
		for (String text : concreteClasses) {
			sMdlStartClass.add(text);
		}
		
		Group adjectiveGroup = new Group(parent, SWT.NONE);
		adjectiveGroup.setLayout(new GridLayout(6, false));
		adjectiveGroup.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		adjectiveGroup.setFont(font);
		adjectiveGroup.setText("Adjectives");
		new Label(adjectiveGroup, SWT.LEFT).setText("Allowed");
		sMdlAllows = new Button (adjectiveGroup, SWT.CHECK);
		new Label(adjectiveGroup, SWT.LEFT).setText("Before");
		sMdlBefore = new Button (adjectiveGroup, SWT.RADIO);
		new Label(adjectiveGroup, SWT.LEFT).setText("After");
		new Button (adjectiveGroup, SWT.RADIO);

		Group protectionsGroup = new Group(parent, SWT.NONE);
		protectionsGroup.setLayout(new GridLayout(4, false));
		protectionsGroup.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		protectionsGroup.setFont(font);
		protectionsGroup.setText("Protections");
		
		protectButtons = new Button [7];
		new Label(protectionsGroup, SWT.LEFT).setText("Single Attribute");
		protectButtons [0] = new Button (protectionsGroup, SWT.CHECK);
		new Label(protectionsGroup, SWT.LEFT).setText("Multiple Attribute");
		protectButtons [1] = new Button (protectionsGroup, SWT.CHECK);
		new Label(protectionsGroup, SWT.LEFT).setText("Single Reference");
		protectButtons [2] = new Button (protectionsGroup, SWT.CHECK);
		new Label(protectionsGroup, SWT.LEFT).setText("Multiple Reference");
		protectButtons [3] = new Button (protectionsGroup, SWT.CHECK);
		protectButtons [3].setSelection(true);
		new Label(protectionsGroup, SWT.LEFT).setText("Single Container");
		protectButtons [4] = new Button (protectionsGroup, SWT.CHECK);
		new Label(protectionsGroup, SWT.LEFT).setText("Multiple Container");
		protectButtons [5] = new Button (protectionsGroup, SWT.CHECK);
		protectButtons [5].setSelection(true);
		new Label(protectionsGroup, SWT.LEFT).setText("Adjective");
		protectButtons [6] = new Button (protectionsGroup, SWT.CHECK);
		protectButtons [6].setSelection(false);
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

	public boolean isBefore () {
		return sMdlBefore.getSelection();
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
