/*
 * Created on 4 févr. 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package org.kermetal.sintaks.parser;


import org.kermeta.sintaks.lexer.ILexer;
import org.kermeta.sintaks.sts.Rule;
import org.kermetal.sintaks.parser.ll.ParserRule;
import org.kermetal.sintaks.subject.ModelSubject;

public class ParserAbstract implements IParser {

    public ParserAbstract (Rule rule, ModelSubject subject) {
        this.rule = rule;
        this.subject = subject;
    }

    public boolean parse (ILexer input) throws ParserSemanticException {
        IParser parser = new ParserRule (rule, subject);
        return parser.parse(input);
    }

    private Rule rule;
    private ModelSubject subject;
}
