/**
 * <copyright>
 * </copyright>
 *
 * $Id: Choice.java,v 1.1 2007-06-14 08:57:30 dtouzet Exp $
 */
package org.kermeta.sintaks.sts;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Choice</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.kermeta.sintaks.sts.Choice#getConditions <em>Conditions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.kermeta.sintaks.sts.StsPackage#getChoice()
 * @model abstract="true"
 * @generated
 */
public interface Choice extends Rule {
	/**
	 * Returns the value of the '<em><b>Conditions</b></em>' containment reference list.
	 * The list contents are of type {@link org.kermeta.sintaks.sts.Condition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conditions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conditions</em>' containment reference list.
	 * @see org.kermeta.sintaks.sts.StsPackage#getChoice_Conditions()
	 * @model type="org.kermeta.sts.Condition" containment="true" required="true"
	 * @generated
	 */
	EList getConditions();

} // Choice