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
import org.kermeta.sintaks.sts.Adornment;
import org.kermeta.sintaks.sts.Rule;
import org.kermeta.sintaks.subject.ModelSubject;


public class ParserAdornment implements IParser {

	public ParserAdornment(Rule adornment, ModelSubject subject) {
		super();
		this.adornment = (Adornment) adornment;
	}

	public boolean parse(ILexer input) throws ParserSemanticException {
		return true;
	}

	@SuppressWarnings("unused")
	private Adornment adornment;
}
