/*
 * Created on 17 janv. 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package org.kermetal.sintaks.parser.ll;

import java.util.Iterator;

import org.eclipse.emf.common.util.EList;


import org.kermeta.sintaks.lexer.ILexer;
import org.kermeta.sintaks.sts.Alternative;
import org.kermeta.sintaks.sts.Condition;
import org.kermeta.sintaks.sts.Rule;
import org.kermetal.sintaks.parser.IParser;
import org.kermetal.sintaks.parser.ParserSemanticException;
import org.kermetal.sintaks.subject.ModelSubject;


public class ParserAlternative implements IParser {

	public ParserAlternative(Rule alternative, ModelSubject subject) {
		super();
		this.alternative = (Alternative) alternative;
        this.subject = subject;
	}

	public boolean parse(ILexer input) throws ParserSemanticException {
		EList list = alternative.getConditions();
		if (list == null)
			throw new ParserSemanticException ("Alternative : conditions empty");

		Iterator i = list.iterator();
		boolean ok = false;
		long position = input.getPosition();
		boolean loop = true;
		while (loop) {
			if (i.hasNext()) {
				Object o = i.next();
				if (!(o instanceof Condition))
					throw new ParserSemanticException ("Alternative : condition "+o+" unacceptable");
				IParser parser = new ParserCondition ((Condition) o, subject);
				input.back(position);
				ok = parser.parse(input);
				if (ok) loop=false;
			} else {
				loop = false;
			}
		}
		return ok;
	}

	private Alternative alternative;
    private ModelSubject subject;
}
