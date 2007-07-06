/*
 * Created on 7 févr. 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package org.kermeta.sintaks.main;

import java.io.PrintStream;

import org.eclipse.emf.common.util.URI;


public interface IMetaModel {

	public void registers (String ext);

	public void load (URI uri);

	public void store (URI uri);

	public Object getRoot ();

	public void setRoot (Object root);

    public IPrettyPrinter getPrettyPrinter (PrintStream output);
}