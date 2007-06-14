/**
 * <copyright>
 * </copyright>
 *
 * $Id: Iteration.java,v 1.1 2007-06-14 08:57:30 dtouzet Exp $
 */
package org.kermeta.sintaks.sts;

import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Iteration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.kermeta.sintaks.sts.Iteration#getSubRule <em>Sub Rule</em>}</li>
 *   <li>{@link org.kermeta.sintaks.sts.Iteration#getContainer <em>Container</em>}</li>
 *   <li>{@link org.kermeta.sintaks.sts.Iteration#getSeparator <em>Separator</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.kermeta.sintaks.sts.StsPackage#getIteration()
 * @model
 * @generated
 */
public interface Iteration extends Rule {
	/**
	 * Returns the value of the '<em><b>Sub Rule</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Rule</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Rule</em>' containment reference.
	 * @see #setSubRule(Rule)
	 * @see org.kermeta.sintaks.sts.StsPackage#getIteration_SubRule()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Rule getSubRule();

	/**
	 * Sets the value of the '{@link org.kermeta.sintaks.sts.Iteration#getSubRule <em>Sub Rule</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sub Rule</em>' containment reference.
	 * @see #getSubRule()
	 * @generated
	 */
	void setSubRule(Rule value);

	/**
	 * Returns the value of the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container</em>' reference.
	 * @see #setContainer(EStructuralFeature)
	 * @see org.kermeta.sintaks.sts.StsPackage#getIteration_Container()
	 * @model required="true"
	 * @generated
	 */
	EStructuralFeature getContainer();

	/**
	 * Sets the value of the '{@link org.kermeta.sintaks.sts.Iteration#getContainer <em>Container</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container</em>' reference.
	 * @see #getContainer()
	 * @generated
	 */
	void setContainer(EStructuralFeature value);

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
	 * @see org.kermeta.sintaks.sts.StsPackage#getIteration_Separator()
	 * @model
	 * @generated
	 */
	Rule getSeparator();

	/**
	 * Sets the value of the '{@link org.kermeta.sintaks.sts.Iteration#getSeparator <em>Separator</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Separator</em>' reference.
	 * @see #getSeparator()
	 * @generated
	 */
	void setSeparator(Rule value);

} // Iteration