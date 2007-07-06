/*
 * Created on 17 janv. 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package org.kermeta.sintaks.parser.ll;


import org.kermeta.sintaks.SintaksPlugin;
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
