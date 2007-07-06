/**
 * Created on 26 april 2007
 *
 * @author : michel Hassenforder
 * 
 */
package org.kermeta.sintaks.parser.ll;

import java.util.Iterator;

import org.eclipse.emf.common.util.EList;

import org.kermeta.sintaks.lexer.ILexer;
import org.kermeta.sintaks.parser.IParser;
import org.kermeta.sintaks.parser.ParserSemanticException;
import org.kermeta.sintaks.sts.Condition;
import org.kermeta.sintaks.sts.Once;
import org.kermeta.sintaks.sts.Rule;
import org.kermeta.sintaks.subject.ModelSubject;


public class ParserOnce implements IParser {

	private Once once;
    private ModelSubject subject;

    public ParserOnce(Rule once, ModelSubject subject) {
		super();
		this.once = (Once) once;
        this.subject = subject;
	}

	private boolean parseOne (ILexer lexer) throws ParserSemanticException {

		EList list = once.getConditions();
		Iterator i = list.iterator();
		long position = lexer.getPosition();
		boolean ok = false;
		boolean loop = true;
		while (loop) {
			if (i.hasNext()) {
				Object o = i.next();
				if (!(o instanceof Condition))
					throw new ParserSemanticException ("Once : condition "+o+" unacceptable");
				IParser parser = new ParserCondition ((Condition) o, subject);
				if (parser.parse(lexer)) {
					loop = false;
					ok = true;
				} else {
					lexer.back(position);
				}
			} else {
				loop = false;
			}
		}
		return ok;
	}
	
	private boolean parseWithSeparator (ILexer lexer) throws ParserSemanticException {
		IParser separatorParser = ParserRule.findParser (once.getSeparator(), subject);

		boolean ok = true;
		boolean loop = true;
		do {
			long position = lexer.getPosition();
			if (parseOne (lexer)) {
				if ( ! separatorParser.parse(lexer)) {
					loop = false;
					lexer.back(position);
					ok = false;
				}
			} else {
				loop = false;
			}
		} while (loop);
		return ok;
	}

	private boolean parseWithoutSeparator (ILexer lexer) throws ParserSemanticException {

		boolean ok = true;
		boolean loop = true;
		while (loop) {
			if (! parseOne (lexer)) {
				loop = false;
			}
		}
		return ok;
	}
	
	public boolean parse(ILexer lexer) throws ParserSemanticException {
		EList list = once.getConditions();
		if (list == null)
			throw new ParserSemanticException ("Once : conditions empty");

		boolean ok;
		if (once.getSeparator() == null) {
			ok = parseWithoutSeparator (lexer);
		} else {
			ok = parseWithSeparator (lexer);
		}
		return ok;
	}
}
