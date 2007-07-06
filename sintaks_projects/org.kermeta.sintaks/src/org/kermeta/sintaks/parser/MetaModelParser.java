package org.kermeta.sintaks.parser;

import java.io.PrintStream;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;


import org.kermeta.sintaks.main.IPrettyPrinter;
import org.kermeta.sintaks.main.MetaModel;
import org.kermeta.sintaks.sts.Root;
import org.kermeta.sintaks.sts.Rule;
import org.kermeta.sintaks.sts.impl.StsPackageImpl;

public class MetaModelParser extends MetaModel {
	
	public MetaModelParser (ResourceSet rs) {
		super(rs);
		StsPackageImpl.init();
		registers("sts");
	}

	public void load (URI uri) {
		super.load(uri);
	}
	
	public void store (URI uri) {
		super.store(uri);
	}
	
	public Rule getStartSymbol (URI ruleURI) {
		load(ruleURI);
		Root root = (Root) getRoot();
		Rule start = root.getStart();
		if (start != null) return start;
		EList fragments = root.getFragments();
		if (fragments == null) return null;
		if (fragments.size() == 0) return null;
		return (Rule) fragments.get(0);
	}

	public IPrettyPrinter getPrettyPrinter(PrintStream output) {
		return null;
	}
}
