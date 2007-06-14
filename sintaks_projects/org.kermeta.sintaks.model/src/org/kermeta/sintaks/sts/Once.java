/**
 * <copyright>
 * </copyright>
 *
 * $Id: Once.java,v 1.1 2007-06-14 08:57:30 dtouzet Exp $
 */
package org.kermeta.sintaks.sts;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Once</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.kermeta.sintaks.sts.Once#getSeparator <em>Separator</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.kermeta.sintaks.sts.StsPackage#getOnce()
 * @model
 * @generated
 */
public interface Once extends Choice {
	/**
	 * Returns the value of the '<em><b>Separator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Separator</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Separator</em>' reference.
	 * @see #setSeparator(Rule)
	 * @see org.kermeta.sintaks.sts.StsPackage#getOnce_Separator()
	 * @model
	 * @generated
	 */
	Rule getSeparator();

	/**
	 * Sets the value of the '{@link org.kermeta.sintaks.sts.Once#getSeparator <em>Separator</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Separator</em>' reference.
	 * @see #getSeparator()
	 * @generated
	 */
	void setSeparator(Rule value);

} // Once