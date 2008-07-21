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

		EList<Condition> list = once.getConditions();
		Iterator<Condition> i = list.iterator();
		long position = lexer.getPosition();
		boolean ok = false;
		boolean loop = true;
		int count = 0;
		while (loop) {
			if (i.hasNext()) {
		    	ParserRule.pushTrace (once, null, "once "+count);
				IParser parser = new ParserCondition (i.next(), subject);
				if (parser.parse(lexer)) {
					loop = false;
					ok = true;
			        ParserRule.setStateValidOrCanceled(true);
				} else {
					lexer.back(position);
			        ParserRule.setStateValidOrCanceled(false);
				}
				++count;
				ParserRule.popTrace();
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
		EList<Condition> list = once.getConditions();
		if (list == null)
			throw new ParserSemanticException ("Once : conditions empty");

    	ParserRule.pushTrace (once, null, null);
		boolean ok;
		if (once.getSeparator() == null) {
			ok = parseWithoutSeparator (lexer);
		} else {
			ok = parseWithSeparator (lexer);
		}
        ParserRule.setStateValidOrCanceled(ok);
		ParserRule.popTrace();
		return ok;
	}
}
