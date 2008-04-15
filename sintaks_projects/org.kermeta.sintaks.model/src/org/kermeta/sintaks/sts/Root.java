/**
 * <copyright>
 * </copyright>
 *
 * $Id: Root.java,v 1.4 2008-04-15 14:22:07 hassen Exp $
 */
package org.kermeta.sintaks.sts;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.kermeta.sintaks.sts.Root#getFragments <em>Fragments</em>}</li>
 *   <li>{@link org.kermeta.sintaks.sts.Root#getStart <em>Start</em>}</li>
 *   <li>{@link org.kermeta.sintaks.sts.Root#getStringDelimliter <em>String Delimliter</em>}</li>
 *   <li>{@link org.kermeta.sintaks.sts.Root#getEscapeCharacter <em>Escape Character</em>}</li>
 *   <li>{@link org.kermeta.sintaks.sts.Root#getEolComment <em>Eol Comment</em>}</li>
 *   <li>{@link org.kermeta.sintaks.sts.Root#getBlockCommentStart <em>Block Comment Start</em>}</li>
 *   <li>{@link org.kermeta.sintaks.sts.Root#getBlockCommentEnd <em>Block Comment End</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.kermeta.sintaks.sts.StsPackage#getRoot()
 * @model
 * @generated
 */
public interface Root extends EObject {
	/**
	 * Returns the value of the '<em><b>Fragments</b></em>' containment reference list.
	 * The list contents are of type {@link org.kermeta.sintaks.sts.Rule}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fragments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fragments</em>' containment reference list.
	 * @see org.kermeta.sintaks.sts.StsPackage#getRoot_Fragments()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Rule> getFragments();

	/**
	 * Returns the value of the '<em><b>Start</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start</em>' reference.
	 * @see #setStart(Rule)
	 * @see org.kermeta.sintaks.sts.StsPackage#getRoot_Start()
	 * @model
	 * @generated
	 */
	Rule getStart();

	/**
	 * Sets the value of the '{@link org.kermeta.sintaks.sts.Root#getStart <em>Start</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start</em>' reference.
	 * @see #getStart()
	 * @generated
	 */
	void setStart(Rule value);

	/**
	 * Returns the value of the '<em><b>String Delimliter</b></em>' attribute.
	 * The default value is <code>"\""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>String Delimliter</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>String Delimliter</em>' attribute.
	 * @see #setStringDelimliter(char)
	 * @see org.kermeta.sintaks.sts.StsPackage#getRoot_StringDelimliter()
	 * @model default="\""
	 * @generated
	 */
	char getStringDelimliter();

	/**
	 * Sets the value of the '{@link org.kermeta.sintaks.sts.Root#getStringDelimliter <em>String Delimliter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>String Delimliter</em>' attribute.
	 * @see #getStringDelimliter()
	 * @generated
	 */
	void setStringDelimliter(char value);

	/**
	 * Returns the value of the '<em><b>Escape Character</b></em>' attribute.
	 * The default value is <code>"\\"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Escape Character</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Escape Character</em>' attribute.
	 * @see #setEscapeCharacter(char)
	 * @see org.kermeta.sintaks.sts.StsPackage#getRoot_EscapeCharacter()
	 * @model default="\\"
	 * @generated
	 */
	char getEscapeCharacter();

	/**
	 * Sets the value of the '{@link org.kermeta.sintaks.sts.Root#getEscapeCharacter <em>Escape Character</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Escape Character</em>' attribute.
	 * @see #getEscapeCharacter()
	 * @generated
	 */
	void setEscapeCharacter(char value);

	/**
	 * Returns the value of the '<em><b>Eol Comment</b></em>' attribute.
	 * The default value is <code>"--"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Eol Comment</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Eol Comment</em>' attribute.
	 * @see #setEolComment(String)
	 * @see org.kermeta.sintaks.sts.StsPackage#getRoot_EolComment()
	 * @model default="--"
	 * @generated
	 */
	String getEolComment();

	/**
	 * Sets the value of the '{@link org.kermeta.sintaks.sts.Root#getEolComment <em>Eol Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Eol Comment</em>' attribute.
	 * @see #getEolComment()
	 * @generated
	 */
	void setEolComment(String value);

	/**
	 * Returns the value of the '<em><b>Block Comment Start</b></em>' attribute.
	 * The default value is <code>"\\/*"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Block Comment Start</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Block Comment Start</em>' attribute.
	 * @see #setBlockCommentStart(String)
	 * @see org.kermeta.sintaks.sts.StsPackage#getRoot_BlockCommentStart()
	 * @model default="\\/*"
	 * @generated
	 */
	String getBlockCommentStart();

	/**
	 * Sets the value of the '{@link org.kermeta.sintaks.sts.Root#getBlockCommentStart <em>Block Comment Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Block Comment Start</em>' attribute.
	 * @see #getBlockCommentStart()
	 * @generated
	 */
	void setBlockCommentStart(String value);

	/**
	 * Returns the value of the '<em><b>Block Comment End</b></em>' attribute.
	 * The default value is <code>"*\\/"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Block Comment End</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Block Comment End</em>' attribute.
	 * @see #setBlockCommentEnd(String)
	 * @see org.kermeta.sintaks.sts.StsPackage#getRoot_BlockCommentEnd()
	 * @model default="*\\/"
	 * @generated
	 */
	String getBlockCommentEnd();

	/**
	 * Sets the value of the '{@link org.kermeta.sintaks.sts.Root#getBlockCommentEnd <em>Block Comment End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Block Comment End</em>' attribute.
	 * @see #getBlockCommentEnd()
	 * @generated
	 */
	void setBlockCommentEnd(String value);

} // Root