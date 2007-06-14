/*
 * Created on 17 janv. 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package org.kermetal.sintaks.parser.ll;


import org.kermeta.sintaks.lexer.ILexer;
import org.kermeta.sintaks.sts.Rule;
import org.kermeta.sintaks.sts.Terminal;
import org.kermetal.sintaks.SintaksPlugin;
import org.kermetal.sintaks.parser.IParser;
import org.kermetal.sintaks.parser.ParserSemanticException;
import org.kermetal.sintaks.subject.ModelSubject;

public class ParserTerminal implements IParser {

	public ParserTerminal(Rule terminal, ModelSubject subject) {
		super();
		this.terminal = (Terminal) terminal;
	}

	public boolean parse(ILexer input) throws ParserSemanticException {
		String textReference = terminal.getTerminal();
        if (input.atEnd()) return false;
		String textRead = input.get();
		if (textReference.equals(textRead)) {
            if (SintaksPlugin.getDefault().getOptionManager().isDebugParser())
            	SintaksPlugin.getDefault().debugln ("Accepted Terminal : "+textRead);
			input.next();
			return true;
		} else {
            if (SintaksPlugin.getDefault().getOptionManager().isDebugParser())
            	SintaksPlugin.getDefault().debugln ("Refused Terminal : "+textRead);
			return false;
		}
	}

	private Terminal terminal;
}
