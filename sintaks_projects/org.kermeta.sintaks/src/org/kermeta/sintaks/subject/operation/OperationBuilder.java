package org.kermeta.sintaks.subject.operation;

import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;


public class OperationBuilder {

	private CompositeOperation list;
	
	public IOperation getOperation () {
		return getList ();
	}

	private CompositeOperation getList () {
		if (list == null) list = new CompositeOperation ();
		return list;
	}

	public void buildCreateClass (EClass metaClass) {
		getList().add(new CreateClassOperation(metaClass));
	}

	public void buildCreateGhost(EStructuralFeature feature, EStructuralFeature to, String value) {
    	getList().add(new FindTargetOperation(feature, 0));
    	getList().add(new CreateGhostOperation(feature, to, value));
	}

	public void buildCreateGhosts (EList from, EStructuralFeature to, String value) {
		switch (from.size()) {
		case 0 : break;
		case 1 : buildCreateGhost ((EStructuralFeature) from.get(0), to, value);
				 break;
		default:
			Iterator it = from.iterator();
	        while(it.hasNext()) {
	        	EStructuralFeature feature = (EStructuralFeature) it.next();
	        	buildCreateGhost (feature, to, value);
	        }
	        break;
		}
	}

	public void buildSetAccumulator () {
		getList().add(new SetAccuOperation ());
	}

	public void buildMark () {
		getList().add(new MarkOperation ());
	}

	public void buildGotoMark () {
		getList().add(new GotoMarkOperation ());
	}

	public void buildPush (Object value) {
		getList().add(new PushOperation (value));
	}

	public void buildDupp () {
		getList().add(new DuppOperation ());
	}

	public void buildPop () {
		getList().add(new PopOperation ());
	}

	public void buildFindInstance (EStructuralFeature feature, String value) {
		getList().add(new FindInstanceOperation(feature, value));
	}

	public void buildSetFeature (EStructuralFeature feature) {
		getList().add(new ConvertToFeatureOperation(feature));
		getList().add(new FindTargetOperation(feature, 1));
		getList().add(new SetFeatureOperation(feature));
	}

	public void buildSetFeatures (EList features) {
		switch (features.size()) {
		case 0 : break;
		case 1 : buildSetFeature ((EStructuralFeature) features.get(0));
				 break;
		default:
			Iterator it = features.iterator();
	        while(it.hasNext()) {
	        	EStructuralFeature feature = (EStructuralFeature) it.next();
	        	getList().add(new DuppOperation ());
	    		getList().add(new ConvertToFeatureOperation(feature));
	    		getList().add(new FindTargetOperation(feature, 2));
	    		getList().add(new SetFeatureOperation(feature));
	        }
	        getList().add(new PopOperation ());
	        break;
		}
	}

	public void buildGetFeature (EStructuralFeature feature) {
		getList().add(new FindTargetOperation(feature, 0));
		getList().add(new GetFeatureOperation(feature));
		getList().add(new ConvertToFeatureOperation(feature));
	}

}
