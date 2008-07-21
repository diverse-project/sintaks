/*
 * Created on 04/02/2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package org.kermeta.sintaks.parser;

import java.io.BufferedReader;
import java.io.Reader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.File;
import java.io.StringReader;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import org.kermeta.sintaks.SintaksPlugin;
import org.kermeta.sintaks.lexer.ILexer;
import org.kermeta.sintaks.lexer.Lexer;
import org.kermeta.sintaks.sts.Root;
import org.kermeta.sintaks.sts.Rule;
import org.kermeta.sintaks.subject.ModelSubject;


public class ModelParser {

    private MetaModelParser mmParser;
    private ModelSubject subject;
    
    
    /**
     * @param mmParser
     * @param subject
     */
    public ModelParser (MetaModelParser mmParser, ModelSubject subject) {
        this.mmParser = mmParser;
        this.subject = subject;
    }
 

    /**
     * @param reader
     * @param ruleURI
     * @return
     */
    private ILexer getLexer(Reader reader, URI ruleURI) {
		ResourceSet rs = new ResourceSetImpl();
		Resource res = rs.getResource(ruleURI, true);
		
		Root stsRoot = (Root) res.getContents().get(0);
		ILexer lexer = new Lexer(reader, stsRoot);

		return lexer;
	}

    
	/**
	 * @param text
	 * @param ruleURI
	 * @return
	 */
	private ILexer getLexer(String text, URI ruleURI) {
		Reader r = new BufferedReader(new StringReader(text), text.length());
		return getLexer(r, ruleURI);
	}


    /**
     * @param inputURI
     * @param ruleURI
     * @return
     */
    private ILexer getLexer (URI inputURI, URI ruleURI) {
        try {
        	File inputFile = new File(inputURI.toFileString());
            Reader r = new BufferedReader(new FileReader(inputURI.toFileString()), (int) inputFile.length());
            return getLexer(r, ruleURI);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
   
    
    /**
     * @param ruleURI
     * @return
     */
    private IParser getParser(URI ruleURI) {
        Rule startSymbol = mmParser.getStartSymbol(ruleURI);
/*
        if (SintaksPlugin.getDefault().getOptionManager().isDebugProcess()) {
        	SintaksPlugin.getDefault().debug ("startSymbol=");
        	SintaksPlugin.getDefault().debug (startSymbol.toString());
        	SintaksPlugin.getDefault().debugln ("");
        }
*/
        return new ParserAbstract (startSymbol, subject);
    }
    
    
    /**
     * @param ruleURI
     * @param text
     * @return
     */
    public boolean parse(URI ruleURI, String text) {
        IParser parser = getParser(ruleURI);
        ILexer lexer = getLexer(text, ruleURI);
        return basicParse(parser, lexer);
    }

    
    /**
     * @param ruleURI
     * @param inputURI
     * @return
     */
    public boolean parse(URI ruleURI, URI inputURI) {
        IParser parser = getParser(ruleURI);
        ILexer lexer = getLexer(inputURI, ruleURI);
        return basicParse(parser, lexer);
    }


    /**
     * @param parser
     * @param lexer
     * @return
     */
    private boolean basicParse(IParser parser, ILexer lexer) {
        boolean r1 = false;
        boolean r2 = false;
        if (parser != null && lexer != null) {
            lexer.begin();
            try {
                r1 = parser.parse(lexer);
                SintaksPlugin.getDefault().getTracer().add("Parser " + (r1 ? "is at end" : "has failed"));
            }
            catch (ParserSemanticException e) {
                e.printStackTrace();
                SintaksPlugin.getDefault().getTracer().add("Parser " + "has failed with an exception");
            }
            r2 = lexer.atEnd();
            SintaksPlugin.getDefault().getTracer().add("Lexer " + (r2 ? "is at end" : "has pending character(s)"));
            SintaksPlugin.getDefault().getTracer().add("Transformation seems " + ((r1 & r2) ? "acceptable" : "wrong"));
        }
        lexer.close();
        
        return r1 & r2;
    }
}
