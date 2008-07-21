/*
 * Created on 18 Juillet 2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package org.kermeta.sintaks.printer;

import java.io.IOException;
import java.io.Writer;

public class SmartPrinter implements ISmartPrinter {

	private int level;
	private boolean nl;
	private Writer output;

	public SmartPrinter(Writer output) {
		super();
		this.output = output;
		this.level = 0;
		this.nl=true;
	}

	public void close() {
		if (output == null) return;
		try {
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		output = null;
	}

	public void flush() {
		if (output == null) return;
		try {
			output.flush();
		} catch (IOException e) {
			e.printStackTrace();
			output = null;
		}
	}

	public void increase () { ++level; }
    public void decrease () { --level; }
	public void reset () { level=0; }

	public void println () {
		if (output == null) return;
		try {
			output.write(lineSeparator);
			output.flush();
			nl=true;
		} catch (IOException e) {
			e.printStackTrace();
			output = null;
		}
	}

	public void print (char text) {
		if (output == null) return;
		if (nl) {
			insertIndent();
		}
		try {
			output.write(text);
		} catch (IOException e) {
			e.printStackTrace();
			output = null;
		}
	}
	
	public void print (String text) {
		if (output == null) return;
		if (nl) {
			insertIndent();
		}
		try {
			output.write(text);
		} catch (IOException e) {
			e.printStackTrace();
			output = null;
		}
	}

	public void tab () {
		print (ISmartPrinter.tabulation);
	}

	private void insertIndent () {
		try {
			for (int i=0; i< level*3; ++i) {
				output.write (ISmartPrinter.indenter);
			}
			nl=false;
		} catch (IOException e) {
			e.printStackTrace();
			output = null;
		}
	}

}
