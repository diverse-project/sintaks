package org.kermeta.sintaks.tests;

import junit.framework.JUnit4TestAdapter;

import org.junit.Test;

public class TypeFlat {

	@Test
	public void test_Text2Model_NaturalOrder () {
		Helper helper = new Helper ("res/type/flat", "../type.ecore", "T2M-natural");

		int code = helper.checkText2Model();
		helper.reportSuccess (code);
	}

	@Test
	public void test_Text2Model_ReversedOrder () {
		Helper helper = new Helper ("res/type/flat", "../type.ecore", "T2M-reversed");

		int code = helper.checkText2Model();
		helper.reportSuccess (code);
	}

	@Test
	public void test_Model2Text_NaturalOrder () {
		Helper helper = new Helper ("res/type/flat", "../type.ecore", "M2T-natural");

		int code = helper.checkModel2Text();
		helper.reportSuccess (code);
	}

	@Test
	public void test_Model2Text_ReversedOrder () {
		Helper helper = new Helper ("res/type/flat", "../type.ecore", "M2T-reversed");

		int code = helper.checkModel2Text();
		helper.reportSuccess (code);
	}
	// used when run from a junit3 suite
	public static junit.framework.Test suite() {
		return new JUnit4TestAdapter(TypeFlat.class);
	}
}
