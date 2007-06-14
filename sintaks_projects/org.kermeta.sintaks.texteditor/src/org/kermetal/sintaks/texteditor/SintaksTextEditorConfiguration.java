

/*$Id: SintaksTextEditorConfiguration.java,v 1.1 2007-06-14 09:02:13 dtouzet Exp $
* Project : fr.irisa.triskell.kermeta.sintaks.editor
* File : 	SintaksTextualEditorConfiguration.java
* License : EPL
* Copyright : IRISA / INRIA / Universite de Rennes 1
* ----------------------------------------------------------------------------
* Creation date : 21 mai 07
* Authors : paco
*/

package org.kermetal.sintaks.texteditor;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.reconciler.IReconciler;
import org.eclipse.jface.text.reconciler.IReconcilingStrategy;
import org.eclipse.jface.text.reconciler.MonoReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;


import org.kermeta.sintaks.sts.Root;
import org.kermeta.sintaks.sts.Terminal;
import org.kermeta.sintaks.sts.util.StsSwitch;


public class SintaksTextEditorConfiguration extends
		SourceViewerConfiguration {

	//private String ruleFile = null;
	private URI ruleURI = null;
	
	private IFile sourceFile = null;
	
	private Root syntax;
	
	private Set<String> keywords = new HashSet<String> ();
	
	//public SintaksTextEditorConfiguration(String ruleFile, IFile sourceFile) {
	public SintaksTextEditorConfiguration(URI ruleURI, IFile sourceFile) {
		this.ruleURI = ruleURI;
		this.sourceFile = sourceFile;
		initializeKeywords();
	}
	
	private void initializeKeywords() {

		//URI uri = URI.createURI( ruleFile );
		//URI uri = URI.createFileURI( ruleFile.getAbsolutePath() );
		ResourceSet resSet = new ResourceSetImpl();
		//Resource resource = resSet.getResource(uri, true);
		Resource resource = resSet.getResource(ruleURI, true);
		syntax = (Root) resource.getContents().get(0);
		
		StsSwitch visitor = new StsSwitch() {
			
			@Override
			public Object caseTerminal(Terminal object) {
				keywords.add( object.getTerminal() );
				return super.caseTerminal(object);
			}
			
		};
		
		for ( Iterator i = EcoreUtil.getAllContents( Collections.singleton(syntax) ); i.hasNext(); ) {
			EObject current = (EObject) i.next();
			visitor.doSwitch( current );
		}
	}
	
	@Override
	public IPresentationReconciler getPresentationReconciler(ISourceViewer sourceViewer) {
		
		PresentationReconciler reconciler= new PresentationReconciler();
		reconciler.setDocumentPartitioning( getConfiguredDocumentPartitioning(sourceViewer) );

		DefaultDamagerRepairer dr = new DefaultDamagerRepairer( new SintaksRuleBasedScanner(keywords) );
		reconciler.setDamager(dr, IDocument.DEFAULT_CONTENT_TYPE);
		reconciler.setRepairer(dr, IDocument.DEFAULT_CONTENT_TYPE);
		
		return reconciler;
	}
	

	public IContentAssistant getContentAssistant(ISourceViewer sourceViewer) {
		ContentAssistant ca = new ContentAssistant();
		IContentAssistProcessor processor = new SintaksContentAssistProcessor(keywords);
		ca.setContentAssistProcessor(processor, IDocument.DEFAULT_CONTENT_TYPE);
		ca.setInformationControlCreator(getInformationControlCreator(sourceViewer));
		return ca;
	}
	
	public IReconciler getReconciler(ISourceViewer sourceViewer) {
		IReconcilingStrategy reconcilingStrategy = new SintaksReconcilingStrategy(ruleURI, sourceFile);
		MonoReconciler reconciler = new MonoReconciler(reconcilingStrategy, false);
		reconciler.setDelay(200);
		return reconciler;
	}
	
}


