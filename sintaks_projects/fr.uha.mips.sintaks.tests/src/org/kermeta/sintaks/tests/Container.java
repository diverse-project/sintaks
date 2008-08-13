package org.kermeta.sintaks.tests;

//import org.eclipse.emf.ecore.resource.Resource;
//import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
//import org.junit.BeforeClass;
import junit.framework.JUnit4TestAdapter;

import org.junit.Test;

public class Container  {

/*	@BeforeClass
	public static void initialization(){
		// add ecore extension to the ExtensionToFactoryMap
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"ecore", new XMIResourceFactoryImpl());
	}*/
	
	@Test
	public void ftest_Text2Model () {
		System.out.println("test_Text2Model");
		Helper helper = new Helper ("res/container", "container.ecore", "T2M-container");

		int code = helper.checkText2Model();
		helper.reportSuccess (code);
	}

	@Test
	public void ftest_Model2Text () {
		Helper helper = new Helper ("res/container", "container.ecore", "M2T-container");

		int code = helper.checkModel2Text();
		helper.reportSuccess (code);
	}

	public static junit.framework.Test suite() {
		return new JUnit4TestAdapter(Container.class);
	}
}
