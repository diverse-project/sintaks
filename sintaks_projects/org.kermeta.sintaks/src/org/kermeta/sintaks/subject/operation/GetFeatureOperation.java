package org.kermeta.sintaks.subject.operation;

import java.io.PrintStream;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.kermeta.sintaks.SintaksPlugin;
import org.kermeta.sintaks.subject.ModelSubject;


public class GetFeatureOperation extends R1W1Operation {

	private EStructuralFeature feature;

	public GetFeatureOperation(EStructuralFeature feature) {
		super();
		this.feature = feature;
	}

	public Object execWithParam (ModelSubject model, Object param1) {
		EObject target = (EObject) param1;

		if (SintaksPlugin.getDefault().getOptionManager().isDebugModel()) {
			PrintStream debugStream = SintaksPlugin.getDefault().getDebugStream();
			debugStream.println("GetAttribute : ");
			debugStream.println("   On        : "+target);
			debugStream.println("   Attribute : "+feature);
        }
    	return target.eGet(feature);
	}


	@Override
	public String toString() {
		StringBuffer tmp = new StringBuffer ();
		tmp.append("GetFeatureOperation : ");
		tmp.append(feature.getName());
		return tmp.toString();
	}

}
