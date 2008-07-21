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
import org.kermeta.sintaks.sts.Condition;
import org.kermeta.sintaks.subject.ModelSubject;


public class ParserCondition implements IParser {

	public ParserCondition(Condition condition, ModelSubject subject) {
		super();
		this.condition = condition;
        this.subject = subject;
	}

	public boolean parse(ILexer input) throws ParserSemanticException {
    	ParserRule.pushTrace (condition, null, null);
		boolean ok=true;
		if (condition.getSubRule() != null) {
			IParser parser = ParserRule.findParser (condition.getSubRule(), subject);
			ok = parser.parse(input);
		}
        ParserRule.setStateValidOrCanceled(ok);
		ParserRule.popTrace();
		return ok;
	}
	
	private Condition condition;
    private ModelSubject subject;
}
