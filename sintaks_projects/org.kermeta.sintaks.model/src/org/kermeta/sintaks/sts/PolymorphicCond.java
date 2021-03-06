/**
 * <copyright>
 * </copyright>
 *
 * $Id: PolymorphicCond.java,v 1.1 2007-06-14 08:57:30 dtouzet Exp $
 */
package org.kermeta.sintaks.sts;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Polymorphic Cond</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.kermeta.sintaks.sts.PolymorphicCond#getMetaclass <em>Metaclass</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.kermeta.sintaks.sts.StsPackage#getPolymorphicCond()
 * @model
 * @generated
 */
public interface PolymorphicCond extends Condition {
	/**
	 * Returns the value of the '<em><b>Metaclass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metaclass</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metaclass</em>' reference.
	 * @see #setMetaclass(EClass)
	 * @see org.kermeta.sintaks.sts.StsPackage#getPolymorphicCond_Metaclass()
	 * @model required="true"
	 * @generated
	 */
	EClass getMetaclass();

	/**
	 * Sets the value of the '{@link org.kermeta.sintaks.sts.PolymorphicCond#getMetaclass <em>Metaclass</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metaclass</em>' reference.
	 * @see #getMetaclass()
	 * @generated
	 */
	void setMetaclass(EClass value);

} // PolymorphicCond