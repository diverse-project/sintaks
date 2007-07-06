/*
 * Created on 4 févr. 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package org.kermeta.sintaks.parser;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.eclipse.emf.common.util.URI;


import org.kermeta.sintaks.SintaksPlugin;
import org.kermeta.sintaks.printer.IPrinter;
import org.kermeta.sintaks.printer.PrinterAbstract;
import org.kermeta.sintaks.printer.PrinterSemanticException;
import org.kermeta.sintaks.sts.Rule;
import org.kermeta.sintaks.subject.ModelSubject;

public class ModelPrinter {

    private MetaModelParser mmParser;
    private ModelSubject subject;
    
    public ModelPrinter (MetaModelParser mmParser, ModelSubject subject) {
        this.mmParser = mmParser;
        this.subject = subject;
    }

    private PrintWriter getPrintStream (String outputFilename) {
        try {
        	if (outputFilename == null)
        		return null;
        	PrintWriter stream = new PrintWriter (new BufferedWriter(new FileWriter(outputFilename)));
            return stream;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
	        e.printStackTrace();
	        return null;
        }
    }

    public void print (URI ruleURI, String outputFilename) {
        Rule startSymbol = mmParser.getStartSymbol(ruleURI);
        if (SintaksPlugin.getDefault().getOptionManager().isDebugProcess()) {
        	SintaksPlugin.getDefault().debug ("startSymbol=");
        	SintaksPlugin.getDefault().debug (startSymbol.toString());
        	SintaksPlugin.getDefault().debugln ("");
        }
        
        IPrinter printer = new PrinterAbstract (startSymbol, subject);

        try {
        	PrintWriter stream = getPrintStream (outputFilename);
        	if (stream != null) {
                printer.print(stream);
                stream.flush();
                stream.close();
        	} else {
        		PrintWriter writer = new PrintWriter (SintaksPlugin.getDefault().getDebugStream());
        		printer.print(writer);
        		writer.flush();
        	}
        } catch (PrinterSemanticException e) {
            e.printStackTrace();
        }
    }
}
