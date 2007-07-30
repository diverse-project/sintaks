/*
 * Created on 26 janv. 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package org.kermeta.sintaks.subject;

import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.kermeta.sintaks.main.PrettyPrinterAbstract;



public class PrettyPrinterSubject extends PrettyPrinterAbstract {

	public PrettyPrinterSubject(PrintStream output) {
		super(output);
	}

    public void print (EObject eObject) {
        increase ();
        if (eObject == null) {
            println ("EObject : null");
        }
        else {
            EClass itsClass = eObject.eClass();
            print(itsClass.getName() + " - Object @" + Integer.toHexString(eObject.hashCode()));
            
            if(itsClass.getEAllStructuralFeatures().size() > 0) {
            	println(" {");
                increase();
                
                // Attributes
                List<EAttribute> attributes = itsClass.getEAllAttributes();
                Iterator<EAttribute> ia = attributes.iterator();
                while(ia.hasNext()) {
                	EAttribute a = ia.next();
                	println(a.getName() + " = " + eObject.eGet(a));
                }
                
                // References
                List<EReference> references = itsClass.getEAllReferences();
                Iterator<EReference> ir = references.iterator();
                while(ir.hasNext()) {
                	EReference r = ir.next();
                	println(r.getName() + " = ");
                	print(eObject.eGet(r));
                }
                decrease();
                print("}");
            }

            println(";");
        }
        decrease ();
    }

    public void print (Ghost ref) {
        increase ();
        if (ref == null) {
            println ("Ghost : null");
        } else {
            println ("Ghost @"+Integer.toHexString(ref.hashCode())+" {");
            increase ();
            print ("From   ");  print (ref.getFrom());
            print ("To     ");  print (ref.getTo());
            print ("Value : ");println (ref.getValue());
            print ("Target ");  print (ref.getFromObject());
            decrease ();
            println ("}");
        }
        decrease ();
    }

	/* (non-Javadoc)
	 * @see subject.IPrettyPrinter#print(java.lang.Object)
	 */
	public void print (Object o) {
		if (recurse(o))					{ printRecursion(o); }
		else if (cycle(o))				{ printCycle(o); }
        else if (o instanceof Ghost)	{ enterObject(o); print ((Ghost) o); leaveObject(); }
        else if (o instanceof EObject)	{ enterObject(o); print ((EObject) o); leaveObject(); }
        else if (o instanceof String)	{ enterObject(o); print ((String) o); leaveObject(); }
        else super.print(o);
	}
	
}
