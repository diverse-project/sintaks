/**
 * <copyright>
 * </copyright>
 *
 * $Id: RuleRef.java,v 1.1 2007-06-14 08:57:30 dtouzet Exp $
 */
package org.kermeta.sintaks.sts;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.kermeta.sintaks.sts.RuleRef#getRef <em>Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.kermeta.sintaks.sts.StsPackage#getRuleRef()
 * @model
 * @generated
 */
public interface RuleRef extends Value {
	/**
	 * Returns the value of the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ref</em>' reference.
	 * @see #setRef(Rule)
	 * @see org.kermeta.sintaks.sts.StsPackage#getRuleRef_Ref()
	 * @model required="true"
	 * @generated
	 */
	Rule getRef();

	/**
	 * Sets the value of the '{@link org.kermeta.sintaks.sts.RuleRef#getRef <em>Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref</em>' reference.
	 * @see #getRef()
	 * @generated
	 */
	void setRef(Rule value);

} // RuleRef