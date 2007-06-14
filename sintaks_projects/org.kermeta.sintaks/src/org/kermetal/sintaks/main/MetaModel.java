/*
 * Created on 7 f�vr. 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package org.kermetal.sintaks.main;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.kermetal.sintaks.subject.PrettyPrinterSubject;



public class MetaModel implements IMetaModel {
	
    private Object root;
    private ResourceSet resSet;
	
    
	public MetaModel(ResourceSet rs) {
		this.resSet = rs;
	}

	@SuppressWarnings("unchecked")
	public void registers (String ext) {
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map m = reg.getExtensionToFactoryMap();
		m.put(ext, new XMIResourceFactoryImpl());
	}

	public void load(URI uri) {
		Resource resource = resSet.getResource(uri, true);
		root = resource.getContents().get(0);
	}

	@SuppressWarnings("unchecked")
	public void store(URI uri) {
		Resource resource = resSet.createResource(uri);
		resource.getContents().add(root);
		try {
			resource.save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Object getRoot() {
		return root;
	}

	public void setRoot(Object root) {
		this.root = root;
	}

    public IPrettyPrinter getPrettyPrinter (PrintStream output) {
    	return new PrettyPrinterSubject(output);
    }
}
