/*
 * Created on 17 janv. 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package org.kermeta.sintaks.parser.ll;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.kermeta.sintaks.lexer.ILexer;
import org.kermeta.sintaks.parser.IParser;
import org.kermeta.sintaks.parser.ParserSemanticException;
import org.kermeta.sintaks.sts.Iteration;
import org.kermeta.sintaks.sts.Rule;
import org.kermeta.sintaks.subject.ModelSubject;
import org.kermeta.sintaks.subject.OperationExecutor;

public class ParserIteration implements IParser {

	public ParserIteration(Rule iteration, ModelSubject subject) {
		super();
		this.iteration = (Iteration) iteration;
        this.subject = subject;
	}

	private void accept () {
        EList<EStructuralFeature> containers = iteration.getContainers();
		OperationExecutor.setFeatures (subject, containers);
	}

	private void reject (ILexer lexer, long position) {
		lexer.back(position);
	}

	private boolean parseWithSeparator (ILexer lexer) throws ParserSemanticException {
		IParser ruleParser = ParserRule.findParser (iteration.getSubRule(), subject);
		if (ruleParser == null)
			throw new ParserSemanticException ("Iteration : ruleParser "+iteration.getSubRule()+" unacceptable");
			
		IParser separatorParser = ParserRule.findParser (iteration.getSeparator(), subject);

		boolean ok = true;
		long position = lexer.getPosition();
		int count=0;
		if (ruleParser.parse(lexer)) {
	    	ParserRule.pushTrace (iteration, "", "step "+count);
			accept (); // first scan : ready to continue
	        ParserRule.setStateValidOrCanceled(true);
			ParserRule.popTrace();
			boolean loop = true;
			while (loop) {
				++count;
				position = lexer.getPosition();
		    	ParserRule.pushTrace (iteration, "", "step "+count);
				if (separatorParser.parse(lexer)) {
					if (ruleParser.parse(lexer)) {
						// next scan : ready to continue
						accept ();
				        ParserRule.setStateValidOrCanceled(true);
					} else {
						// separator but not good value
						// error, backtrace until last separator
						loop = false;
						ok = false;
		                reject (lexer, position);
				        ParserRule.setStateValidOrCanceled(false);
					}
				} else {
					// separator required to continue
					loop = false;
	                reject (lexer, position);
			        ParserRule.setStateValidOrFailed(false);
				}
				ParserRule.popTrace();
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
		int count=0;
		while (loop) {
			long position = lexer.getPosition();
	    	ParserRule.pushTrace (iteration, null, "step "+count);
	    	if (ruleParser.parse(lexer)) {
				accept();
		        ParserRule.setStateValidOrCanceled(true);
			} else {
				loop=false;
                reject(lexer, position);
		        ParserRule.setStateValidOrCanceled(false);
			}
			++count;
			ParserRule.popTrace();
		}
		return ok;
	}

	public boolean parse(ILexer lexer) throws ParserSemanticException {
        EList<EStructuralFeature> containers = iteration.getContainers();
		if (containers.isEmpty())
            throw new ParserSemanticException ("ParserIteration : null container ");

    	ParserRule.pushTrace (iteration, null, null);
		boolean ok;
		if (iteration.getSeparator() == null) {
			ok = parseWithoutSeparator (lexer);
		} else {
			ok = parseWithSeparator (lexer);
		}
        ParserRule.setStateValidOrCanceled(ok);
		ParserRule.popTrace();
		return ok;
	}

	private Iteration iteration;
    private ModelSubject subject;
}
