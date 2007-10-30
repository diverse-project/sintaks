/*
 * Created on 17 janv. 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package org.kermeta.sintaks.printer;

import java.io.PrintWriter;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;


import org.kermeta.sintaks.sts.Condition;
import org.kermeta.sintaks.sts.CustomCond;
import org.kermeta.sintaks.sts.PolymorphicCond;
import org.kermeta.sintaks.subject.ModelSubject;
import org.kermeta.sintaks.subject.operation.OperationBuilder;

//TODO understand the purpose of the hack with the pop
public class PrinterCondition implements IPrinter {

	public PrinterCondition(Condition condition, ModelSubject subject) {
		super();
		this.condition = (Condition) condition;
        this.subject = subject;
	}
	
	private boolean valid (PolymorphicCond c) {

    	OperationBuilder builder = new OperationBuilder();
       	builder.buildDupp ();
       	builder.buildSetAccumulator();
       	Object object = subject.process (builder.getOperation());
		
       	if (object == null) return false;
       	
		EObject top = (EObject) object;
		
		String value = c.getValue();
		String name = top.eClass().getName();
		
		if (value == null || value.length()==0) {
			EClass metaClass = c.getMetaclass();
			if (metaClass == null) return false;
			String metaClassName = metaClass.getName();
			return metaClassName.equals(name);
		} else {
			if ("null".equals(value)) {
				if (name == null) return true;
				if ("".equals(name)) return true;
				return false;
			}
			if ("any".equals(value)) {
				if (name == null) return false;
				if ("".equals(name)) return false;
				return true;
			}
			EClass metaClass = c.getMetaclass();
			if (metaClass == null) return false;
			String metaClassName = metaClass.getName();
			if ("equals".equals(value))
				return metaClassName.equals(name);
			if ("differs".equals(value))
				return ! metaClassName.equals(name);
			return false;
		}
	}

	private boolean valid (CustomCond c) {
        EStructuralFeature container = c.getFeature();
        OperationBuilder builder = new OperationBuilder();
        builder.buildGetFeature(container);
		builder.buildSetAccumulator();
		Object o = subject.process (builder.getOperation());

        String value = c.getValue();
		if (value == null || value.length()==0)
			return false;
		if ("null".equals(value))
			return (o == null);
		if ("any".equals(value))
			return (o != null);
		if ("empty".equals(value)) {
			if (o == null) return true;
            if (o instanceof String) {
                String s = (String) o;
                if (s.length()==0) return true;
                return false;
            }
			if (o instanceof List) {
				List<EObject> list = (List<EObject>) o;
				if (list.size()==0) return true;
				return false;
			}
		}
		if ("filled".equals(value)) {
			if (o == null) return false;
            if (o instanceof String) {
                String s = (String) o;
                if (s.length()==0) return false;
                return true;
            }
			if (o instanceof List) {
				List<EObject> list = (List<EObject>) o;
				if (list.size()==0) return false;
				return true;
			}
		}
		if (value.length() > 1 && value.charAt(0) == '=') {
			if (o == null) return false;
			String v = o.toString();
            if (v.equals(value.substring(1).trim()))
            	return true;
    		return false;
		}
		if (value.length() > 2 && value.charAt(0) == '!' && value.charAt(1) == '=' ) {
			if (o == null) return false;
			String v = o.toString();
            if (! v.equals(value.substring(2).trim()))
            	return true;
    		return false;
		}
		return false;
	}

	public void print(PrintWriter output) throws PrinterSemanticException {
		if (condition.getSubRule() != null) {
			IPrinter printer = PrinterRule.findPrinter (condition.getSubRule(), subject);
			if (condition instanceof PolymorphicCond) {
				if (valid ((PolymorphicCond) condition))  
					printer.print(output);
			}
			if (condition instanceof CustomCond) {
				if (valid ((CustomCond) condition))  
					printer.print(output);
			}
		}
	}

	private Condition condition;
    private ModelSubject subject;
}
