/*
 * Created on 17 janv. 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package org.kermeta.sintaks.parser.ll;

import org.eclipse.emf.ecore.EStructuralFeature;


import org.kermeta.sintaks.SintaksPlugin;
import org.kermeta.sintaks.lexer.ILexer;
import org.kermeta.sintaks.parser.IParser;
import org.kermeta.sintaks.parser.ParserSemanticException;
import org.kermeta.sintaks.sts.Iteration;
import org.kermeta.sintaks.sts.Rule;
import org.kermeta.sintaks.subject.ModelSubject;
import org.kermeta.sintaks.subject.operation.OperationBuilder;

public class ParserIteration implements IParser {

	public ParserIteration(Rule iteration, ModelSubject subject) {
		super();
		this.iteration = (Iteration) iteration;
        this.subject = subject;
	}

	private void accept () {
		EStructuralFeature container = iteration.getContainer();
        if (SintaksPlugin.getDefault().getOptionManager().isDebugParser())
        	SintaksPlugin.getDefault().debugln ("Iteration : addFeature "+container);

    	OperationBuilder builder = new OperationBuilder();
       	builder.buildSetFeature (container);
    	subject.process (builder.getOperation());
	}

	private void reject (ILexer lexer, long position) {
        if (SintaksPlugin.getDefault().getOptionManager().isDebugParser())
        	SintaksPlugin.getDefault().debugln ("Iteration : backtracking ");
		lexer.back(position);
	}

	private boolean parseWithSeparator (ILexer lexer) throws ParserSemanticException {
		IParser ruleParser = ParserRule.findParser (iteration.getSubRule(), subject);
		if (ruleParser == null)
			throw new ParserSemanticException ("Iteration : ruleParser "+iteration.getSubRule()+" unacceptable");
			
		IParser separatorParser = ParserRule.findParser (iteration.getSeparator(), subject);

		boolean ok = true;
		long position = lexer.getPosition();
		if (ruleParser.parse(lexer)) {
			accept (); // first scan : ready to continue
			boolean loop = true;
			while (loop) {
				position = lexer.getPosition();
				if (separatorParser.parse(lexer)) {
					if (ruleParser.parse(lexer)) {
						// next scan : ready to continue
						accept ();
					} else {
						// separator but not good value
						// error, backtrace until last separator
						loop = false;
						ok = false;
		                reject (lexer, position);
					}
				} else {
					// separator required to continue
					loop = false;
	                reject (lexer, position);
				}
			}
		} else {
			// empty list : acceptable
            reject (lexer, position);
		}
		return ok;
	}

	private boolean parseWithoutSeparator (ILexer lexer) throws ParserSemanticException {
		IParser ruleParser = ParserRule.findParser (iteration.getSubRule(), subject);
		if (ruleParser == null)
			throw new ParserSemanticException ("Iteration : ruleParser "+iteration.getSubRule()+" inaceptable");
			
		boolean ok = true;
		boolean loop = true;
		while (loop) {
			long position = lexer.getPosition();
			if (ruleParser.parse(lexer)) {
				accept();
			} else {
				loop=false;
                reject(lexer, position);
			}
		}
		return ok;
	}

	public boolean parse(ILexer lexer) throws ParserSemanticException {
		EStructuralFeature container = iteration.getContainer();
		if (container == null)
            throw new ParserSemanticException ("ParserIteration : null container ");

		boolean ok;
		if (iteration.getSeparator() == null) {
			ok = parseWithoutSeparator (lexer);
		} else {
			ok = parseWithSeparator (lexer);
		}
		return ok;
	}

	private Iteration iteration;
    private ModelSubject subject;
}
