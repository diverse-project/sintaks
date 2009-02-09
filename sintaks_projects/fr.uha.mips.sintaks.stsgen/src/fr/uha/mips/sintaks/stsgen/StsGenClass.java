/**
 * <copyright>
 * </copyright>
 *
 * $Id: StsGenClass.java,v 1.1 2009-02-09 13:26:37 hassen Exp $
 */
package fr.uha.mips.sintaks.stsgen;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sts Gen Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.uha.mips.sintaks.stsgen.StsGenClass#getDescription <em>Description</em>}</li>
 *   <li>{@link fr.uha.mips.sintaks.stsgen.StsGenClass#isNotUsed <em>Not Used</em>}</li>
 *   <li>{@link fr.uha.mips.sintaks.stsgen.StsGenClass#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link fr.uha.mips.sintaks.stsgen.StsGenClass#getClassTarget <em>Class Target</em>}</li>
 *   <li>{@link fr.uha.mips.sintaks.stsgen.StsGenClass#getGenFeatures <em>Gen Features</em>}</li>
 *   <li>{@link fr.uha.mips.sintaks.stsgen.StsGenClass#getGenSubClasses <em>Gen Sub Classes</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.uha.mips.sintaks.stsgen.StsgenPackage#getStsGenClass()
 * @model
 * @generated
 */
public interface StsGenClass extends EObject {
	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see fr.uha.mips.sintaks.stsgen.StsgenPackage#getStsGenClass_Description()
	 * @model unique="false" required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	String getDescription();

	/**
	 * Returns the value of the '<em><b>Class Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class Target</em>' reference.
	 * @see #setClassTarget(EClass)
	 * @see fr.uha.mips.sintaks.stsgen.StsgenPackage#getStsGenClass_ClassTarget()
	 * @model
	 * @generated
	 */
	EClass getClassTarget();

	/**
	 * Sets the value of the '{@link fr.uha.mips.sintaks.stsgen.StsGenClass#getClassTarget <em>Class Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class Target</em>' reference.
	 * @see #getClassTarget()
	 * @generated
	 */
	void setClassTarget(EClass value);

	/**
	 * Returns the value of the '<em><b>Gen Features</b></em>' containment reference list.
	 * The list contents are of type {@link fr.uha.mips.sintaks.stsgen.StsGenFeature}.
	 * It is bidirectional and its opposite is '{@link fr.uha.mips.sintaks.stsgen.StsGenFeature#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gen Features</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gen Features</em>' containment reference list.
	 * @see fr.uha.mips.sintaks.stsgen.StsgenPackage#getStsGenClass_GenFeatures()
	 * @see fr.uha.mips.sintaks.stsgen.StsGenFeature#getContainer
	 * @model opposite="container" containment="true"
	 * @generated
	 */
	EList<StsGenFeature> getGenFeatures();

	/**
	 * Returns the value of the '<em><b>Gen Sub Classes</b></em>' reference list.
	 * The list contents are of type {@link fr.uha.mips.sintaks.stsgen.StsGenClass}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gen Sub Classes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gen Sub Classes</em>' reference list.
	 * @see fr.uha.mips.sintaks.stsgen.StsgenPackage#getStsGenClass_GenSubClasses()
	 * @model
	 * @generated
	 */
	EList<StsGenClass> getGenSubClasses();

	/**
	 * Returns the value of the '<em><b>Not Used</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Not Used</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Not Used</em>' attribute.
	 * @see #setNotUsed(boolean)
	 * @see fr.uha.mips.sintaks.stsgen.StsgenPackage#getStsGenClass_NotUsed()
	 * @model
	 * @generated
	 */
	boolean isNotUsed();

	/**
	 * Sets the value of the '{@link fr.uha.mips.sintaks.stsgen.StsGenClass#isNotUsed <em>Not Used</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Not Used</em>' attribute.
	 * @see #isNotUsed()
	 * @generated
	 */
	void setNotUsed(boolean value);

	/**
	 * Returns the value of the '<em><b>Abstract</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abstract</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Abstract</em>' attribute.
	 * @see fr.uha.mips.sintaks.stsgen.StsgenPackage#getStsGenClass_Abstract()
	 * @model default="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isAbstract();

} // StsGenClass
