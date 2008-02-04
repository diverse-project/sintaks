/**
 * <copyright>
 * </copyright>
 *
 * $Id: Value.java,v 1.3 2008-02-04 08:21:40 hassen Exp $
 */
package org.kermeta.sintaks.sts;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.kermeta.sintaks.sts.Value#getFeatures <em>Features</em>}</li>
 *   <li>{@link org.kermeta.sintaks.sts.Value#isSurroundingSpaces <em>Surrounding Spaces</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.kermeta.sintaks.sts.StsPackage#getValue()
 * @model abstract="true"
 * @generated
 */
public interface Value extends Rule {
	/**
	 * Returns the value of the '<em><b>Features</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EStructuralFeature}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Features</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Features</em>' reference list.
	 * @see org.kermeta.sintaks.sts.StsPackage#getValue_Features()
	 * @model
	 * @generated
	 */
	EList<EStructuralFeature> getFeatures();

	/**
	 * Returns the value of the '<em><b>Surrounding Spaces</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Surrounding Spaces</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Surrounding Spaces</em>' attribute.
	 * @see #setSurroundingSpaces(boolean)
	 * @see org.kermeta.sintaks.sts.StsPackage#getValue_SurroundingSpaces()
	 * @model default="true"
	 * @generated
	 */
	boolean isSurroundingSpaces();

	/**
	 * Sets the value of the '{@link org.kermeta.sintaks.sts.Value#isSurroundingSpaces <em>Surrounding Spaces</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Surrounding Spaces</em>' attribute.
	 * @see #isSurroundingSpaces()
	 * @generated
	 */
	void setSurroundingSpaces(boolean value);

} // Value