/* 
 * Project: sintaks
 * File: Ecore2HUTNAction.java
 * License: EPL
 * Copyright: MIPS / Universite de Haute Alsace
 * ----------------------------------------------------------------------------
 * Creation date: Dec 24, 2007
 * Authors: 
 * 			Michel Hassenforder
 */
package fr.uha.mips.sintaks.ecore2hutn.ui;

import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

/**
 * @author Michel Hassenforder
 *
 */
public class Ecore2HUTNAction implements IObjectActionDelegate {
	
	protected StructuredSelection currentSelection;
    protected IFile mdlFile;

	/**
	 * 
	 */
	public Ecore2HUTNAction() {
		super();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IObjectActionDelegate#setActivePart(org.eclipse.jface.action.IAction, org.eclipse.ui.IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 */
	public void run(IAction action) {
		Shell shell = new Shell();
		Ecore2HUTNWizard wizard =  new Ecore2HUTNWizard();
    	wizard.init(PlatformUI.getWorkbench(), currentSelection);
    	WizardDialog wizDialog =  new org.eclipse.jface.wizard.WizardDialog(shell, wizard);
    	wizDialog.setTitle("Create a sintaks file using a HUTN syntax");
    	wizDialog.open();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction, org.eclipse.jface.viewers.ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		if (selection instanceof StructuredSelection) {
			// The selection should be a single  file
			currentSelection = (StructuredSelection) selection;
			Iterator it = currentSelection.iterator();

			while(it.hasNext()) {
				mdlFile = (IFile)it.next();
			}
		}
	}

}
