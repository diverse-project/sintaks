package org.kermeta.sintaks.tests;

import junit.framework.JUnit4TestAdapter;

import org.junit.Test;

public class ExprInfixed {

	@Test
	public void test_Text2Model_MultAdd () {
		Helper helper = new Helper ("res/expr/infixed", "../expr.ecore", "T2M-MultAdd");

		int code = helper.checkText2Model();
		helper.reportSuccess (code);
	}

	@Test
	public void test_Text2Model_AddMult () {
		Helper helper = new Helper ("res/expr/infixed", "../expr.ecore", "T2M-AddMult");

		int code = helper.checkText2Model();
		helper.reportSuccess (code);
	}

	@Test
	public void test_Model2Text_MultAdd () {
		Helper helper = new Helper ("res/expr/infixed", "../expr.ecore", "M2T-MultAdd");

		int code = helper.checkModel2Text();
		helper.reportSuccess (code);
	}

	@Test
	public void test_Model2Text_AddMult () {
		Helper helper = new Helper ("res/expr/infixed", "../expr.ecore", "M2T-AddMult");

		int code = helper.checkModel2Text();
		helper.reportSuccess (code);
	}
	
	// used when run from a junit3 suite
	public static junit.framework.Test suite() {
		return new JUnit4TestAdapter(ExprInfixed.class);
	}
}
