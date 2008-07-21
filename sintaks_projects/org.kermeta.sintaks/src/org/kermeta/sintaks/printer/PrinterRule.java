/*
 * Created on 17 janv. 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package org.kermeta.sintaks.printer;

import org.eclipse.emf.ecore.EObject;
import org.kermeta.sintaks.SintaksPlugin;
import org.kermeta.sintaks.sts.Rule;
import org.kermeta.sintaks.sts.StsPackage;
import org.kermeta.sintaks.subject.ModelSubject;
import org.kermeta.sintaks.trace.State;
import org.kermeta.sintaks.trace.Trace;

public class PrinterRule implements IPrinter {

	public PrinterRule (Rule rule, ModelSubject subject) {
		this.rule = rule;
		this.subject = subject;
    }

	/* (non-Javadoc)
	 * @see compiler.IParser#parse(java.io.Reader)
	 */
	public void print (ISmartPrinter output) throws PrinterSemanticException {
        IPrinter printer = findPrinter (rule, subject);
        EObject o = subject.getModel();
        subject.setModel(o);
        printer.print (output);
	}

	static IPrinter findPrinter (Rule rule, ModelSubject subject) throws PrinterSemanticException {
		if (rule == null) {
			throw new PrinterSemanticException ("rule is null");
		}
		int mmClassID = rule.eClass().getClassifierID();
		IPrinter printer = null;
		switch (mmClassID) {
		case StsPackage.SEQUENCE			:	printer = new PrinterSequence (rule, subject); break;
		case StsPackage.ALTERNATIVE			:	printer = new PrinterAlternative (rule, subject); break;
		case StsPackage.ONCE				:	printer = new PrinterOnce (rule, subject); break;
		case StsPackage.ITERATION			:	printer = new PrinterIteration (rule, subject); break;
		case StsPackage.TERMINAL			:	printer = new PrinterTerminal (rule, subject); break;
		case StsPackage.ADORNMENT			:	printer = new PrinterAdornment (rule, subject); break;
		case StsPackage.TEMPLATE			:	printer = new PrinterTemplate (rule, subject); break;
		case StsPackage.PRIMITIVE_VALUE		:	printer = new PrinterPrimitiveValue (rule, subject); break;
		case StsPackage.OBJECT_REFERENCE	:	printer = new PrinterReferenceValue (rule, subject); break;
		case StsPackage.RULE_REF			:	printer = new PrinterRuleRef (rule, subject); break;
		case StsPackage.CONSTANT			:	printer = new PrinterConstant (rule, subject); break;
		case StsPackage.URI_VALUE			:	printer = new PrinterURIValue (rule, subject); break;
		default 							:
			throw new PrinterSemanticException ("unknown (and unimplemented ClassID");
		}
		return printer;
	}
	
	static public void printText (ISmartPrinter output, String text, boolean surroundingSpaces) {
        if (text != null && text.length()!=0) {
    		if (SintaksPlugin.getDefault().getOptionManager().isDebugModel()) {
    			SintaksPlugin.getDefault().getTracer().add("printText " + text);
    		}
        	if (surroundingSpaces) output.print(IPrinter.separator);
        	if (text.indexOf(' ') != -1) {
        		output.print('"');
        		output.print(text);
        		output.print('"');
        	} else {
        		output.print(text);
        	}
        	if (surroundingSpaces) output.print(IPrinter.separator);
        } else {
    		if (SintaksPlugin.getDefault().getOptionManager().isDebugModel()) {
    			SintaksPlugin.getDefault().getTracer().add("printText (null) or empty");
    		}
        }
	}

	static protected void pushTrace (EObject rule, EObject source, String comment) {
		if (SintaksPlugin.getDefault().getOptionManager().isDebugPrinter()) {
        	Trace trace = SintaksPlugin.getDefault().getTracer().newModel2TextTrace(rule, source, comment);
        	SintaksPlugin.getDefault().getTracer().push(trace);
    	}
	}
	
	static protected void popTrace () {
		if (SintaksPlugin.getDefault().getOptionManager().isDebugPrinter()) {
	    	SintaksPlugin.getDefault().getTracer().pop();
		}
	}
	
	protected static void setStateValidOrFailed (boolean ok) {
		if (SintaksPlugin.getDefault().getOptionManager().isDebugPrinter()) {
			Trace trace = SintaksPlugin.getDefault().getTracer().top();
			if (trace != null) {
				trace.setState(ok ? State.OK : State.FAILURE);
			}
		}
	}

	protected static void setStateValidOrCanceled (boolean ok) {
		if (SintaksPlugin.getDefault().getOptionManager().isDebugPrinter()) {
			Trace trace = SintaksPlugin.getDefault().getTracer().top();
			if (trace != null) {
				trace.setState(ok ? State.OK : State.CANCELED);
			}
		}
	}

	private Rule rule;
    private ModelSubject subject;
}
