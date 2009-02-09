/**
 * <copyright>
 * </copyright>
 *
 * $Id: StsGenRoot.java,v 1.1 2009-02-09 13:26:37 hassen Exp $
 */
package fr.uha.mips.sintaks.stsgen;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sts Gen Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.uha.mips.sintaks.stsgen.StsGenRoot#getGenClasses <em>Gen Classes</em>}</li>
 *   <li>{@link fr.uha.mips.sintaks.stsgen.StsGenRoot#getStartClass <em>Start Class</em>}</li>
 *   <li>{@link fr.uha.mips.sintaks.stsgen.StsGenRoot#getRootPackage <em>Root Package</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.uha.mips.sintaks.stsgen.StsgenPackage#getStsGenRoot()
 * @model
 * @generated
 */
public interface StsGenRoot extends EObject {
	/**
	 * Returns the value of the '<em><b>Gen Classes</b></em>' containment reference list.
	 * The list contents are of type {@link fr.uha.mips.sintaks.stsgen.StsGenClass}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gen Classes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gen Classes</em>' containment reference list.
	 * @see fr.uha.mips.sintaks.stsgen.StsgenPackage#getStsGenRoot_GenClasses()
	 * @model containment="true"
	 * @generated
	 */
	EList<StsGenClass> getGenClasses();

	/**
	 * Returns the value of the '<em><b>Start Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Class</em>' reference.
	 * @see #setStartClass(EClass)
	 * @see fr.uha.mips.sintaks.stsgen.StsgenPackage#getStsGenRoot_StartClass()
	 * @model
	 * @generated
	 */
	EClass getStartClass();

	/**
	 * Sets the value of the '{@link fr.uha.mips.sintaks.stsgen.StsGenRoot#getStartClass <em>Start Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Class</em>' reference.
	 * @see #getStartClass()
	 * @generated
	 */
	void setStartClass(EClass value);

	/**
	 * Returns the value of the '<em><b>Root Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root Package</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root Package</em>' reference.
	 * @see #setRootPackage(EPackage)
	 * @see fr.uha.mips.sintaks.stsgen.StsgenPackage#getStsGenRoot_RootPackage()
	 * @model
	 * @generated
	 */
	EPackage getRootPackage();

	/**
	 * Sets the value of the '{@link fr.uha.mips.sintaks.stsgen.StsGenRoot#getRootPackage <em>Root Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Root Package</em>' reference.
	 * @see #getRootPackage()
	 * @generated
	 */
	void setRootPackage(EPackage value);

} // StsGenRoot
