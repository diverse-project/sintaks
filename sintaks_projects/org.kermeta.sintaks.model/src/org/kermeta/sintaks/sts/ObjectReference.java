/**
 * <copyright>
 * </copyright>
 *
 * $Id: ObjectReference.java,v 1.1 2007-06-14 08:57:30 dtouzet Exp $
 */
package org.kermeta.sintaks.sts;

import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.kermeta.sintaks.sts.ObjectReference#getIdentifier <em>Identifier</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.kermeta.sintaks.sts.StsPackage#getObjectReference()
 * @model
 * @generated
 */
public interface ObjectReference extends Value {
	/**
	 * Returns the value of the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identifier</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identifier</em>' reference.
	 * @see #setIdentifier(EStructuralFeature)
	 * @see org.kermeta.sintaks.sts.StsPackage#getObjectReference_Identifier()
	 * @model required="true"
	 * @generated
	 */
	EStructuralFeature getIdentifier();

	/**
	 * Sets the value of the '{@link org.kermeta.sintaks.sts.ObjectReference#getIdentifier <em>Identifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identifier</em>' reference.
	 * @see #getIdentifier()
	 * @generated
	 */
	void setIdentifier(EStructuralFeature value);

} // ObjectReference