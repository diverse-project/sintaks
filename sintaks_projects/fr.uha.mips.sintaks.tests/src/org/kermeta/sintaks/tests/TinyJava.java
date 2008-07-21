package org.kermeta.sintaks.tests;

import org.junit.Test;

public class TinyJava {

	@Test
	public void test_Text2Model () {
		Helper helper = new Helper ("res/tinyjava", "TinyJava.ecore", "T2M-tutorial");

		int code = helper.checkText2Model();
		helper.reportSuccess (code);
	}

	@Test
	public void test_Model2Text () {
		Helper helper = new Helper ("res/tinyjava", "TinyJava.ecore", "M2T-tutorial");

		int code = helper.checkModel2Text();
		helper.reportSuccess (code);
	}

}
