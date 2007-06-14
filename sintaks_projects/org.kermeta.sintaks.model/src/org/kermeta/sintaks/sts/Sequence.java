/**
 * <copyright>
 * </copyright>
 *
 * $Id: Sequence.java,v 1.1 2007-06-14 08:57:30 dtouzet Exp $
 */
package org.kermeta.sintaks.sts;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sequence</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.kermeta.sintaks.sts.Sequence#getSubRules <em>Sub Rules</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.kermeta.sintaks.sts.StsPackage#getSequence()
 * @model
 * @generated
 */
public interface Sequence extends Rule {
	/**
	 * Returns the value of the '<em><b>Sub Rules</b></em>' containment reference list.
	 * The list contents are of type {@link org.kermeta.sintaks.sts.Rule}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Rules</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Rules</em>' containment reference list.
	 * @see org.kermeta.sintaks.sts.StsPackage#getSequence_SubRules()
	 * @model type="org.kermeta.sts.Rule" containment="true" required="true"
	 * @generated
	 */
	EList getSubRules();

} // Sequence