/* $Id: UserError.java,v 1.1 2007-10-24 07:13:54 dvojtise Exp $
 * Project    : Sintaks
 * File       : UserError.java
 * License    : EPL
 * Copyright  : IRISA / INRIA / Universite de Haute Alsace
 * -------------------------------------------------------------------
 * Creation date : 21 juil. 2005
 * Authors : 
 * 			Michel Hassenforder <michel.hassenforder@uha.fr>
 *        	dvojtise <dvojtise@irisa.fr>
 */
package org.kermeta.sintaks.errors;

/**
 * Used to trap User error and then display them in the GUI
 *
 */
@SuppressWarnings("serial")
public class UserError extends Error {

	public UserError(String message) {
		super(message);
	}
	
}
