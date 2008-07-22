/*
 * Created on 4 févr. 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package org.kermeta.sintaks.printer;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import org.eclipse.emf.common.util.URI;
import org.kermeta.sintaks.SintaksPlugin;
import org.kermeta.sintaks.parser.MetaModelParser;
import org.kermeta.sintaks.sts.Rule;
import org.kermeta.sintaks.subject.ModelSubject;

public class ModelPrinter {

    private MetaModelParser mmParser;
    private ModelSubject subject;
    
    public ModelPrinter (MetaModelParser mmParser, ModelSubject subject) {
        this.mmParser = mmParser;
        this.subject = subject;
    }

    private ISmartPrinter getPrintStream (String outputFilename) {
        try {
        	if (outputFilename == null)
        		return null;
        	ISmartPrinter stream = new SmartPrinter (new BufferedWriter(new FileWriter(outputFilename)));
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
        IPrinter printer = new PrinterAbstract (startSymbol, subject);

        try {
        	ISmartPrinter stream = getPrintStream (outputFilename);
        	if (stream != null) {
                printer.print(stream);
                stream.flush();
                stream.close();
                SintaksPlugin.getDefault().getTracer().add("Transformation is " + "acceptable");
        	}
        } catch (PrinterSemanticException e) {
            e.printStackTrace();
            SintaksPlugin.getDefault().getTracer().add("Transformation seems " + "wrong");
        }
    }
}
