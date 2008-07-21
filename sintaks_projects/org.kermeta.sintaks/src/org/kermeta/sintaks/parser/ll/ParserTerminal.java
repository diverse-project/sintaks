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
import org.kermeta.sintaks.sts.Terminal;
import org.kermeta.sintaks.subject.ModelSubject;

public class ParserTerminal implements IParser {

	public ParserTerminal(Rule terminal, ModelSubject subject) {
		super();
		this.terminal = (Terminal) terminal;
	}

	public boolean parse(ILexer input) throws ParserSemanticException {
		String textReference = terminal.getTerminal();
        if (input.atEnd()) return false;
		String textRead = input.get();

    	ParserRule.pushTrace (terminal, textRead, null);

		boolean ok;

		if(terminal.isCaseSensitive()) {
			ok = textReference.equals(textRead);
		} else {
			ok = textReference.toUpperCase().equals(textRead.toUpperCase());
		}
		
		if(ok) {
			input.next();
		}
		
        ParserRule.setStateValidOrFailed (ok);
		ParserRule.popTrace();
		return ok;
	}

	private Terminal terminal;
}
