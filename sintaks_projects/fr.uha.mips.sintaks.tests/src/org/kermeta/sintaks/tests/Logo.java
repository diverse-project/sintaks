package org.kermeta.sintaks.tests;

import junit.framework.JUnit4TestAdapter;

import org.junit.Test;

public class Logo {

	@Test
	public void test_Text2Model () {
		Helper helper = new Helper ("res/logo", "ASMLogo.ecore", "T2M-carre");

		int code = helper.checkText2Model();
		helper.reportSuccess (code);
	}

	@Test
	public void test_Model2Text () {
		Helper helper = new Helper ("res/logo", "ASMLogo.ecore", "M2T-carre");

		int code = helper.checkModel2Text();
		helper.reportSuccess (code);
	}

	// used when run from a junit3 suite
	public static junit.framework.Test suite() {
		return new JUnit4TestAdapter(Logo.class);
	}
}
