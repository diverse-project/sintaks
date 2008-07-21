package org.kermeta.sintaks.tests;

import org.junit.Test;

public class TypeEmbedded {

	@Test
	public void test_Text2Model_NaturalOrder () {
		Helper helper = new Helper ("res/type/embedded", "../type.ecore", "T2M-natural");

		int code = helper.checkText2Model();
		helper.reportSuccess (code);
	}

	@Test
	public void test_Text2Model_ReversedOrder () {
		Helper helper = new Helper ("res/type/embedded", "../type.ecore", "T2M-reversed");

		int code = helper.checkText2Model();
		helper.reportSuccess (code);
	}

	@Test
	public void test_Model2Text_NaturalOrder () {
		Helper helper = new Helper ("res/type/embedded", "../type.ecore", "M2T-natural");

		int code = helper.checkModel2Text();
		helper.reportSuccess (code);
	}

	@Test
	public void test_Model2Text_ReversedOrder () {
		Helper helper = new Helper ("res/type/embedded", "../type.ecore", "M2T-reversed");

		int code = helper.checkModel2Text();
		helper.reportSuccess (code);
	}
}
