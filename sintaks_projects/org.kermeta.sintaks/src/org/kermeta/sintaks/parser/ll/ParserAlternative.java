/*
 * Created on 17 janv. 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package org.kermeta.sintaks.parser.ll;

import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.kermeta.sintaks.lexer.ILexer;
import org.kermeta.sintaks.parser.IParser;
import org.kermeta.sintaks.parser.ParserSemanticException;
import org.kermeta.sintaks.sts.Alternative;
import org.kermeta.sintaks.sts.Condition;
import org.kermeta.sintaks.sts.Rule;
import org.kermeta.sintaks.subject.ModelSubject;


public class ParserAlternative implements IParser {

	public ParserAlternative(Rule alternative, ModelSubject subject) {
		super();
		this.alternative = (Alternative) alternative;
        this.subject = subject;
	}

	public boolean parse(ILexer input) throws ParserSemanticException {
		EList<Condition> list = alternative.getConditions();
		if (list == null)
			throw new ParserSemanticException ("Alternative : conditions empty");

    	ParserRule.pushTrace (alternative, null, null);
		Iterator<Condition> i = list.iterator();
		boolean ok = false;
		long position = input.getPosition();
		boolean loop = true;
		while (loop) {
			if (i.hasNext()) {
				IParser parser = new ParserCondition (i.next(), subject);
				input.back(position);
				ok = parser.parse(input);
				if (ok) loop=false;
			} else {
				loop = false;
			}
		}
        ParserRule.setStateValidOrCanceled(ok);
		ParserRule.popTrace();
		return ok;
	}

	private Alternative alternative;
    private ModelSubject subject;
}
