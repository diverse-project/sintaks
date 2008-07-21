package org.kermeta.sintaks.tests;

import org.junit.Test;

public class Container {

	@Test
	public void test_Text2Model () {
		Helper helper = new Helper ("res/container", "container.ecore", "T2M-container");

		int code = helper.checkText2Model();
		helper.reportSuccess (code);
	}

	@Test
	public void test_Model2Text () {
		Helper helper = new Helper ("res/container", "container.ecore", "M2T-container");

		int code = helper.checkModel2Text();
		helper.reportSuccess (code);
	}

}
