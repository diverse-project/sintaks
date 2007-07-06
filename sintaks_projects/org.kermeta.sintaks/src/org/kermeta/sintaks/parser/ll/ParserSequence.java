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
import org.kermeta.sintaks.sts.Rule;
import org.kermeta.sintaks.sts.Sequence;
import org.kermeta.sintaks.subject.ModelSubject;
import org.kermeta.sintaks.subject.operation.OperationBuilder;

public class ParserSequence implements IParser {

	public ParserSequence(Rule sequence, ModelSubject subject) {
		super();
		this.sequence = (Sequence) sequence;
        this.subject = subject;
	}

	public boolean parse(ILexer input) throws ParserSemanticException {
		EList list = sequence.getSubRules();
		Iterator i = list.iterator();
		boolean loop = true;
		boolean ok = true;

    	OperationBuilder builder1 = new OperationBuilder();
       	builder1.buildMark();
       	builder1.buildSetAccumulator();
       	Object mark = subject.process (builder1.getOperation());

		while (loop) {
			if (i.hasNext()) {
				Rule rule = (Rule) i.next();
				IParser parser = ParserRule.findParser (rule, subject);
				if (! parser.parse(input)) {
					loop = false;
					ok = false;
				}
			} else {
				loop = false;
			}
		}
		if (! ok) {
	    	OperationBuilder builder2 = new OperationBuilder();
        	builder2.buildPush(mark);
	       	builder2.buildGotoMark();
	    	subject.process (builder2.getOperation());
		}
		return ok;
	}

	private Sequence sequence;
    private ModelSubject subject;
}
