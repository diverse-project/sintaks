package org.kermeta.sintaks.tests;

import junit.framework.JUnit4TestAdapter;

import org.junit.Test;

public class Ghosts {

	@Test
	public void test_Text2Model_ContainerFirst () {
		Helper helper = new Helper ("res/ghosts/first", "../ghost.ecore", "T2M-ghost-first");

		int code = helper.checkText2Model();
		helper.reportSuccess (code);
	}

	@Test
	public void test_Text2Model_ContainerLast () {
		Helper helper = new Helper ("res/ghosts/last", "../ghost.ecore", "T2M-ghost-last");

		int code = helper.checkText2Model();
		helper.reportSuccess (code);
	}

	@Test
	public void test_Model2Text_ContainerFirst () {
		Helper helper = new Helper ("res/ghosts/first", "../ghost.ecore", "M2T-ghost-first");

		int code = helper.checkModel2Text();
		helper.reportSuccess (code);
	}

	@Test
	public void test_Model2Text_ContainerLast () {
		Helper helper = new Helper ("res/ghosts/last", "../ghost.ecore", "M2T-ghost-last");

		int code = helper.checkModel2Text();
		helper.reportSuccess (code);
	}
	
	// used when run from a junit3 suite
	public static junit.framework.Test suite() {
		return new JUnit4TestAdapter(Ghosts.class);
	}
}
