/*
 * Created on 17 janv. 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package org.kermeta.sintaks.printer;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.kermeta.sintaks.errors.UserError;
import org.kermeta.sintaks.sts.Condition;
import org.kermeta.sintaks.sts.CustomCond;
import org.kermeta.sintaks.sts.PolymorphicCond;
import org.kermeta.sintaks.subject.ModelSubject;
import org.kermeta.sintaks.subject.OperationExecutor;

public class PrinterCondition implements IPrinter {

	public PrinterCondition(Condition condition, ModelSubject subject) {
		super();
		this.condition = (Condition) condition;
        this.subject = subject;
	}
	
	private boolean valid (PolymorphicCond c) {

		Object object = OperationExecutor.top(subject);       	
		EObject top = (EObject) object;
		if(top == null){
			throw new UserError("Not able to process the subject while validating a PolymorphicCond on " + c.getMetaclass().getName() +
					"\nmaybe your model is invalid (ex: missing a mandatory element (ie. multiplicity 1 in the metamodel))");
		}
		
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
		Object o = OperationExecutor.getFeature (subject, c.getFeature());
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
				@SuppressWarnings("unchecked") List<EObject> list = (List<EObject>) o;
				if (list.size()==0) return true;
				return false;
			}
			return false;
		}
		if ("filled".equals(value)) {
			if (o == null) return false;
            if (o instanceof String) {
                String s = (String) o;
                if (s.length()==0) return false;
                return true;
            }
			if (o instanceof List) {
				@SuppressWarnings("unchecked") List<EObject> list = (List<EObject>) o;
				if (list.size()==0) return false;
				return true;
			}
			return true;
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

	public void print(ISmartPrinter output) throws PrinterSemanticException {
    	PrinterRule.pushTrace (condition, null, null);
		boolean ok = false;
		if (condition.getSubRule() != null) {
			IPrinter printer = PrinterRule.findPrinter (condition.getSubRule(), subject);
			if (condition instanceof PolymorphicCond) {
				ok = valid ((PolymorphicCond) condition);
			}
			if (condition instanceof CustomCond) {
				ok = valid ((CustomCond) condition);
			}
			if (ok) printer.print(output);
		}
		PrinterRule.setStateValidOrCanceled (ok);
    	PrinterRule.popTrace();
	}

	private Condition condition;
    private ModelSubject subject;
}
