/*$Id: AllTests.java,v 1.1 2008-08-13 09:09:54 dvojtise Exp $
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
	TinyJava.class,
	TypeEmbedded.class,
	TypeFlat.class
	})

public class AllTests {

  public static Test suite() {
    return new JUnit4TestAdapter(AllTests.class);
  }

}

