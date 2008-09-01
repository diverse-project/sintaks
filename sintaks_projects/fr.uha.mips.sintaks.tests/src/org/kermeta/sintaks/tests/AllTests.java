/*$Id: AllTests.java,v 1.2 2008-09-01 11:46:59 hassen Exp $
* Project : fr.uha.mips.sintaks.tests
* File : 	AllTests.java
* License : EPL
* Copyright : IRISA / INRIA 
* ----------------------------------------------------------------------------
* Creation date : 12 août 08
* Authors : 
*      Didier Vojtisek <dvojtise@irisa.fr>
*/

package org.kermeta.sintaks.tests;

import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses( { 
	Container.class, 
	ExprInfixed.class,
	ExprPrefixed.class,
	Fsm.class,
	Ghosts.class,
	Logo.class,
	TinyJava.class,
	TypeEmbedded.class,
	TypeFlat.class
	})

public class AllTests {

  public static Test suite() {
    return new JUnit4TestAdapter(AllTests.class);
  }

}

