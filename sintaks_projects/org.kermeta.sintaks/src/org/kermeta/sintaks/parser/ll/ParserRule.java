/*
 * Created on 17 janv. 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package org.kermeta.sintaks.parser.ll;


import org.kermeta.sintaks.lexer.ILexer;
import org.kermeta.sintaks.parser.IParser;
import org.kermeta.sintaks.parser.ParserSemanticException;
import org.kermeta.sintaks.sts.Rule;
import org.kermeta.sintaks.sts.StsPackage;
import org.kermeta.sintaks.subject.ModelSubject;

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
	
	private Rule rule;
    private ModelSubject subject;
}