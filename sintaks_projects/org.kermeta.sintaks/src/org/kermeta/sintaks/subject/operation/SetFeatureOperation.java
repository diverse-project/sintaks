package org.kermeta.sintaks.subject.operation;

import java.io.PrintStream;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.kermetal.sintaks.SintaksPlugin;
import org.kermetal.sintaks.subject.ModelSubject;


public class SetFeatureOperation extends R2W0Operation {

	private EStructuralFeature feature;

	public SetFeatureOperation(EStructuralFeature feature) {
		super();
		this.feature = feature;
	}

	@SuppressWarnings("unchecked")
	public void execWithParam (ModelSubject model, Object param1, Object param2) {
		Object value   = param1;
		EObject target = (EObject) param2;

		if (SintaksPlugin.getDefault().getOptionManager().isDebugModel()) {
			PrintStream debugStream = SintaksPlugin.getDefault().getDebugStream();
			debugStream.println("SetAttribute : ");
			debugStream.println("   On        : "+target);
			debugStream.println("   Attribute : "+feature);
			debugStream.println("   Value     : "+value);
        }
    	if (feature.isMany()) {
	   		((EList) target.eGet(feature)).add(value);
		} else {
			target.eSet(feature, value);
		}
	}

	@Override
	public String toString() {
		StringBuffer tmp = new StringBuffer ();
		tmp.append("SetFeatureOperation : ");
		tmp.append(feature.getName());
		return tmp.toString();
	}

}
