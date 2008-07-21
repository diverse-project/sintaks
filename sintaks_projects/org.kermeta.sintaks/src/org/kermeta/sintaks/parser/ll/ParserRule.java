/*
 * Created on 17 janv. 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package org.kermeta.sintaks.parser.ll;


import org.eclipse.emf.ecore.EObject;
import org.kermeta.sintaks.SintaksPlugin;
import org.kermeta.sintaks.lexer.ILexer;
import org.kermeta.sintaks.parser.IParser;
import org.kermeta.sintaks.parser.ParserSemanticException;
import org.kermeta.sintaks.sts.Rule;
import org.kermeta.sintaks.sts.StsPackage;
import org.kermeta.sintaks.subject.ModelSubject;
import org.kermeta.sintaks.trace.State;
import org.kermeta.sintaks.trace.Trace;

public class ParserRule implements IParser {

	public ParserRule (Rule rule, ModelSubject subject) {
		this.rule = rule;
		this.subject = subject;
    }

	/* (non-Javadoc)
	 * @see compiler.IParser#parse(java.io.Reader)
	 */
	public boolean parse (ILexer input) throws ParserSemanticException
	{
		IParser parser = findParser (rule, subject);
		boolean ok = parser.parse (input);
		return ok;
	}

	static IParser findParser (Rule rule, ModelSubject subject) throws ParserSemanticException {
		if (rule == null) {
			throw new ParserSemanticException ("rule is null");
		}
		int mmClassID = rule.eClass().getClassifierID();
		IParser parser = null;
		switch (mmClassID) {
		case StsPackage.SEQUENCE			:	parser = new ParserSequence (rule, subject); break;
		case StsPackage.ALTERNATIVE			:	parser = new ParserAlternative (rule, subject); break;
		case StsPackage.ONCE				:	parser = new ParserOnce (rule, subject); break;
		case StsPackage.ITERATION			:	parser = new ParserIteration (rule, subject); break;
		case StsPackage.TEMPLATE			:	parser = new ParserTemplate (rule, subject); break;
		case StsPackage.TERMINAL			:	parser = new ParserTerminal (rule, subject); break;
		case StsPackage.ADORNMENT			:	parser = new ParserAdornment (rule, subject); break;
		case StsPackage.OBJECT_REFERENCE	:	parser = new ParserReferenceValue (rule, subject); break;
		case StsPackage.RULE_REF			:	parser = new ParserRuleRef (rule, subject); break;
		case StsPackage.CONSTANT			:	parser = new ParserConstant (rule, subject); break;
		case StsPackage.PRIMITIVE_VALUE		:	parser = new ParserPrimitiveValue (rule, subject); break;
		case StsPackage.URI_VALUE			:	parser = new ParserURIValue (rule, subject); break;
		default 							:
			throw new ParserSemanticException ("unknown (and unimplemented) ClassID");
		}
		return parser;
	}
	
	static protected void pushTrace (EObject rule, String textRead, String comment) {
		if (SintaksPlugin.getDefault().getOptionManager().isDebugParser()) {
			Trace trace = SintaksPlugin.getDefault().getTracer().newText2ModelTrace(rule, textRead, comment);
        	SintaksPlugin.getDefault().getTracer().push(trace);
    	}
	}
	
	static protected void popTrace () {
		if (SintaksPlugin.getDefault().getOptionManager().isDebugParser()) {
	    	SintaksPlugin.getDefault().getTracer().pop();
		}
	}
	
	protected static void setStateValidOrFailed (boolean ok) {
		if (SintaksPlugin.getDefault().getOptionManager().isDebugParser()) {
			Trace trace = SintaksPlugin.getDefault().getTracer().top();
			if (trace != null) {
				trace.setState(ok ? State.OK : State.FAILURE);
			}
		}
	}

	protected static void setStateValidOrCanceled (boolean ok) {
		if (SintaksPlugin.getDefault().getOptionManager().isDebugParser()) {
			Trace trace = SintaksPlugin.getDefault().getTracer().top();
			if (trace != null) {
				trace.setState(ok ? State.OK : State.CANCELED);
			}
		}
	}

	private Rule rule;
    private ModelSubject subject;
}
