package org.kermeta.sintaks.subject.operation;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.kermeta.sintaks.SintaksPlugin;
import org.kermeta.sintaks.subject.ModelSubject;


public class FindTargetOperation extends R0W1Operation {

	private EStructuralFeature feature;
	private int valueDepth;
	
	public FindTargetOperation(EStructuralFeature feature, int valueDepth) {
		super();
		this.feature = feature;
		this.valueDepth = valueDepth;
	}

	public Object execWithParam (ModelSubject model) {
// Hm Have to skip the values located at the tops of stack
// according to the OperationBuilder builder it could be 0 1 or 2 elements
		List<Object> stack = model.getStack();
		int size = stack.size()-1 - valueDepth;
		for (int i=size; i>=0; --i) {
			Object crt = stack.get(i);
			try {
				EObject target = (EObject) crt;
				target.eGet(feature);
				if (SintaksPlugin.getDefault().getOptionManager().isDebugModel()) {
					SintaksPlugin.getDefault().debugln("Target usable : "+target);
				}
				return target;
			}
			catch (Exception e) {
				if (SintaksPlugin.getDefault().getOptionManager().isDebugModel()) {
					SintaksPlugin.getDefault().debugln("Target unusable : "+crt);
				}
			}
		}
		return null;
	}

	@Override
	public String toString() {
		StringBuffer tmp = new StringBuffer ();
		tmp.append("FindTargetOperation : ");
		tmp.append(feature.getName());
		tmp.append(" depth="); tmp.append(valueDepth);
		return tmp.toString();
	}

}
