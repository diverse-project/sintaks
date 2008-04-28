

/*$Id: SintaksReconcilingStrategy.java,v 1.2 2008-04-28 11:53:45 ftanguy Exp $
* Project : fr.irisa.triskell.sintaks.texteditor
* File : 	SintaksReconcilingStrategy.java
* License : EPL
* Copyright : IRISA / INRIA / Universite de Rennes 1
* ----------------------------------------------------------------------------
* Creation date : 22 mai 07
* Authors : paco
*/

package org.kermeta.sintaks.texteditor;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.reconciler.DirtyRegion;
import org.eclipse.jface.text.reconciler.IReconcilingStrategy;
import org.kermeta.sintaks.main.Master;

import fr.irisa.triskell.kermeta.resources.KermetaMarkersHelper;

public class SintaksReconcilingStrategy implements IReconcilingStrategy {

	//private String ruleFile = null;
	private URI ruleURI = null;
	
	private IDocument document = null;
	
	private IFile textFile = null;
	
	//public SintaksReconcilingStrategy(String ruleFile, IFile textFile) {
	public SintaksReconcilingStrategy(URI ruleURI, IFile textFile) {
		this.ruleURI = ruleURI;
		this.textFile = textFile;
	}
	
	public void reconcile(IRegion partition) {
		try {
			String text = document.get(partition.getOffset(), partition.getLength());
			Master m = new Master();
			EObject result = m.getModelFromText(text, ruleURI);
			if ( result == null )
				KermetaMarkersHelper.markError(textFile, "Error when parsing this file with the sintaks file " + ruleURI.toString());
			else
				KermetaMarkersHelper.clearMarkers(textFile);
		} catch (BadLocationException e) {
			e.printStackTrace();
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	public void reconcile(DirtyRegion dirtyRegion, IRegion subRegion) {
		System.out.println();
	}

	public void setDocument(IDocument document) {
		this.document = document;
	}
}


