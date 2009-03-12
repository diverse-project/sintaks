/*
 * Created on 1 march 2009
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package fr.uha.mips.sintaks.ecore2hutn;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

public class Link {

    private EObject from;
    private EClass to;

    public Link (EObject from, EClass to) {
        this.from  = from;
        this.to = to;
    }
    
    public EObject getFrom () {
        return from;
    }
    
    public EClass getTo () {
        return to;
    }
    
}
