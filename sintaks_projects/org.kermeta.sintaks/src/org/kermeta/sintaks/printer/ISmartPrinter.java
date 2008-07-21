/*
 * Created on 18 juillet 2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package org.kermeta.sintaks.printer;


public interface ISmartPrinter {

	public abstract void print (char text);
	public abstract void print (String text);

	public abstract void flush ();
	public abstract void close ();

	public abstract void println ();
	public abstract void tab ();
	public abstract void increase ();
    public abstract void decrease ();
	public abstract void reset ();

	public final static char tabulation = '\t';
	public final static char indenter = ' ';
	public final static String lineSeparator = (String) java.security.AccessController.doPrivileged(
            new sun.security.action.GetPropertyAction("line.separator"));
}