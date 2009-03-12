/**
 * <copyright>
 * </copyright>
 *
 * $Id: StsGenFeature.java,v 1.2 2009-03-12 07:57:15 hassen Exp $
 */
package fr.uha.mips.sintaks.stsgen;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sts Gen Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.uha.mips.sintaks.stsgen.StsGenFeature#getDescription <em>Description</em>}</li>
 *   <li>{@link fr.uha.mips.sintaks.stsgen.StsGenFeature#getTargetFeature <em>Target Feature</em>}</li>
 *   <li>{@link fr.uha.mips.sintaks.stsgen.StsGenFeature#isNotUsed <em>Not Used</em>}</li>
 *   <li>{@link fr.uha.mips.sintaks.stsgen.StsGenFeature#getType <em>Type</em>}</li>
 *   <li>{@link fr.uha.mips.sintaks.stsgen.StsGenFeature#isProtected <em>Protected</em>}</li>
 *   <li>{@link fr.uha.mips.sintaks.stsgen.StsGenFeature#isShared <em>Shared</em>}</li>
 *   <li>{@link fr.uha.mips.sintaks.stsgen.StsGenFeature#isMany <em>Many</em>}</li>
 *   <li>{@link fr.uha.mips.sintaks.stsgen.StsGenFeature#getKeyFeature <em>Key Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.uha.mips.sintaks.stsgen.StsgenPackage#getStsGenFeature()
 * @model
 * @generated
 */
public interface StsGenFeature extends EObject {
	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see fr.uha.mips.sintaks.stsgen.StsgenPackage#getStsGenFeature_Description()
	 * @model unique="false" required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	String getDescription();

	/**
	 * Returns the value of the '<em><b>Target Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Feature</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Feature</em>' reference.
	 * @see #setTargetFeature(EStructuralFeature)
	 * @see fr.uha.mips.sintaks.stsgen.StsgenPackage#getStsGenFeature_TargetFeature()
	 * @model
	 * @generated
	 */
	EStructuralFeature getTargetFeature();

	/**
	 * Sets the value of the '{@link fr.uha.mips.sintaks.stsgen.StsGenFeature#getTargetFeature <em>Target Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Feature</em>' reference.
	 * @see #getTargetFeature()
	 * @generated
	 */
	void setTargetFeature(EStructuralFeature value);

	/**
	 * Returns the value of the '<em><b>Protected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Protected</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Protected</em>' attribute.
	 * @see #setProtected(boolean)
	 * @see fr.uha.mips.sintaks.stsgen.StsgenPackage#getStsGenFeature_Protected()
	 * @model
	 * @generated
	 */
	boolean isProtected();

	/**
	 * Sets the value of the '{@link fr.uha.mips.sintaks.stsgen.StsGenFeature#isProtected <em>Protected</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Protected</em>' attribute.
	 * @see #isProtected()
	 * @generated
	 */
	void setProtected(boolean value);

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
	 * @see fr.uha.mips.sintaks.stsgen.StsgenPackage#getStsGenFeature_NotUsed()
	 * @model
	 * @generated
	 */
	boolean isNotUsed();

	/**
	 * Sets the value of the '{@link fr.uha.mips.sintaks.stsgen.StsGenFeature#isNotUsed <em>Not Used</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Not Used</em>' attribute.
	 * @see #isNotUsed()
	 * @generated
	 */
	void setNotUsed(boolean value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link fr.uha.mips.sintaks.stsgen.Type}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see fr.uha.mips.sintaks.stsgen.Type
	 * @see #setType(Type)
	 * @see fr.uha.mips.sintaks.stsgen.StsgenPackage#getStsGenFeature_Type()
	 * @model
	 * @generated
	 */
	Type getType();

	/**
	 * Sets the value of the '{@link fr.uha.mips.sintaks.stsgen.StsGenFeature#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see fr.uha.mips.sintaks.stsgen.Type
	 * @see #getType()
	 * @generated
	 */
	void setType(Type value);

	/**
	 * Returns the value of the '<em><b>Shared</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shared</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shared</em>' attribute.
	 * @see #setShared(boolean)
	 * @see fr.uha.mips.sintaks.stsgen.StsgenPackage#getStsGenFeature_Shared()
	 * @model
	 * @generated
	 */
	boolean isShared();

	/**
	 * Sets the value of the '{@link fr.uha.mips.sintaks.stsgen.StsGenFeature#isShared <em>Shared</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shared</em>' attribute.
	 * @see #isShared()
	 * @generated
	 */
	void setShared(boolean value);

	/**
	 * Returns the value of the '<em><b>Many</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Many</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Many</em>' attribute.
	 * @see fr.uha.mips.sintaks.stsgen.StsgenPackage#getStsGenFeature_Many()
	 * @model default="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isMany();

	/**
	 * Returns the value of the '<em><b>Key Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Key Feature</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Key Feature</em>' reference.
	 * @see #setKeyFeature(StsGenFeature)
	 * @see fr.uha.mips.sintaks.stsgen.StsgenPackage#getStsGenFeature_KeyFeature()
	 * @model
	 * @generated
	 */
	StsGenFeature getKeyFeature();

	/**
	 * Sets the value of the '{@link fr.uha.mips.sintaks.stsgen.StsGenFeature#getKeyFeature <em>Key Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Key Feature</em>' reference.
	 * @see #getKeyFeature()
	 * @generated
	 */
	void setKeyFeature(StsGenFeature value);

} // StsGenFeature
