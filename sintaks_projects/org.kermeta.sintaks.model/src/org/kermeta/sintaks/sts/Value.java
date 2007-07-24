/**
 * <copyright>
 * </copyright>
 *
 * $Id: Value.java,v 1.2 2007-07-24 12:12:18 cfaucher Exp $
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

} // Value