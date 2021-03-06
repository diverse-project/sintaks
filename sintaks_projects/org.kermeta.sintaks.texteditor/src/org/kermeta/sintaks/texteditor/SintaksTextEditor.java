

/*$Id: SintaksTextEditor.java,v 1.1 2007-07-06 09:56:12 dtouzet Exp $
* Project : fr.irisa.triskell.kermeta.sintaks.editor
* File : 	SintaksTextEditor.java
* License : EPL
* Copyright : IRISA / INRIA / Universite de Rennes 1
* ----------------------------------------------------------------------------
* Creation date : 21 mai 07
* Authors : paco
*/

package org.kermeta.sintaks.texteditor;

import java.util.ResourceBundle;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.action.Action;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.ContentAssistAction;
import org.eclipse.ui.texteditor.ITextEditorActionDefinitionIds;
import org.kermeta.sintaks.registering.RegisteringHelper;



public class SintaksTextEditor extends TextEditor {

	
	private static final String RESOURCE_BUNDLE= "org.eclipse.ui.editors.text.TextEditorMessages";
	
	private static ResourceBundle fgResourceBundle= ResourceBundle.getBundle(RESOURCE_BUNDLE);

	@Override
	protected void createActions() {
		super.createActions();
		
		Action action = new ContentAssistAction(fgResourceBundle, "ContentAssistProposal.",
				this);
		String id = ITextEditorActionDefinitionIds.CONTENT_ASSIST_PROPOSALS;
		action.setActionDefinitionId(id);
		setAction("ContentAssistProposal", action);
		markAsStateDependentAction("ContentAssistProposal", true);
	}
	
	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		super.init(site, input);
		
		IFile file = ((FileEditorInput) input).getFile();
		//String ruleFile = RegisteringHelper.getRuleFile( file.getFileExtension() );
		URI ruleURI = RegisteringHelper.getRuleFile( file.getFileExtension() );
		
		if(ruleURI == null)
			SintaksTextEditorPlugin.getDefault().getLog().log(new Status(Status.ERROR, SintaksTextEditorPlugin.PLUGIN_ID, Status.ERROR, "No Sintaks Text Editor exists for extension " + file.getFileExtension() + ".", null));
		else {
			//String workspacePath = ResourcesPlugin.getWorkspace().getRoot().getLocation().toString();
			//File rFile = new File(workspacePath + file.getFullPath().toString());
			//File rFile = new File(ruleFile);
			setSourceViewerConfiguration( new SintaksTextEditorConfiguration(ruleURI, ((FileEditorInput) input).getFile()) );
			
			//setSourceViewerConfiguration( new SintaksTextEditorConfiguration(ruleFile, ((FileEditorInput) input).getFile()) );
		}
	}
	
}


