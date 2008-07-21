package org.kermeta.sintaks.tests;

import org.junit.Test;

public class ExprPrefixed {

	@Test
	public void test_Text2Model_MultAdd () {
		Helper helper = new Helper ("res/expr/prefixed", "../expr.ecore", "T2M-MultAdd");

		int code = helper.checkText2Model();
		helper.reportSuccess (code);
	}

	@Test
	public void test_Text2Model_AddMult () {
		Helper helper = new Helper ("res/expr/prefixed", "../expr.ecore", "T2M-AddMult");

		int code = helper.checkText2Model();
		helper.reportSuccess (code);
	}

	@Test
	public void test_Model2Text_MultAdd () {
		Helper helper = new Helper ("res/expr/prefixed", "../expr.ecore", "M2T-MultAdd");

		int code = helper.checkModel2Text();
		helper.reportSuccess (code);
	}

	@Test
	public void test_Model2Text_AddMult () {
		Helper helper = new Helper ("res/expr/prefixed", "../expr.ecore", "M2T-AddMult");

		int code = helper.checkModel2Text();
		helper.reportSuccess (code);
	}
}
