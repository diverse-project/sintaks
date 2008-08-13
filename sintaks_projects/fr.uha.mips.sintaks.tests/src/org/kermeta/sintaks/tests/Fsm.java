package org.kermeta.sintaks.tests;

import junit.framework.JUnit4TestAdapter;

import org.junit.Test;

public class Fsm {

	@Test
	public void test_Text2Model () {
		Helper helper = new Helper ("res/fsm", "fsm.ecore", "T2M-HelloWorld");

		int code = helper.checkText2Model();
		helper.reportSuccess (code);
	}

	@Test
	public void test_Model2Text () {
		Helper helper = new Helper ("res/fsm", "fsm.ecore", "M2T-HelloWorld");

		int code = helper.checkModel2Text();
		helper.reportSuccess (code);
	}

	// used when run from a junit3 suite
	public static junit.framework.Test suite() {
		return new JUnit4TestAdapter(Fsm.class);
	}
}
