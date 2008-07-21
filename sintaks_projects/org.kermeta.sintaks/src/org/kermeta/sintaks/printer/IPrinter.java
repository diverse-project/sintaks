/*
 * Created on 8 févr. 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package org.kermeta.sintaks.printer;



public interface IPrinter {

    public void print (ISmartPrinter output) throws PrinterSemanticException;

    public final static char separator = ' ';
}
