/**
 * <copyright>
 * </copyright>
 *
 * $Id: Terminal.java,v 1.3 2008-02-04 09:24:09 hassen Exp $
 */
package org.kermeta.sintaks.sts;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Terminal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.kermeta.sintaks.sts.Terminal#getTerminal <em>Terminal</em>}</li>
 *   <li>{@link org.kermeta.sintaks.sts.Terminal#isLexicalSeparator <em>Lexical Separator</em>}</li>
 *   <li>{@link org.kermeta.sintaks.sts.Terminal#isCaseSensitive <em>Case Sensitive</em>}</li>
 *   <li>{@link org.kermeta.sintaks.sts.Terminal#isSurroundingSpaces <em>Surrounding Spaces</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.kermeta.sintaks.sts.StsPackage#getTerminal()
 * @model
 * @generated
 */
public interface Terminal extends Rule {
	/**
	 * Returns the value of the '<em><b>Terminal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Terminal</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Terminal</em>' attribute.
	 * @see #setTerminal(String)
	 * @see org.kermeta.sintaks.sts.StsPackage#getTerminal_Terminal()
	 * @model required="true"
	 * @generated
	 */
	String getTerminal();

	/**
	 * Sets the value of the '{@link org.kermeta.sintaks.sts.Terminal#getTerminal <em>Terminal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Terminal</em>' attribute.
	 * @see #getTerminal()
	 * @generated
	 */
	void setTerminal(String value);

	/**
	 * Returns the value of the '<em><b>Lexical Separator</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lexical Separator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lexical Separator</em>' attribute.
	 * @see #setLexicalSeparator(boolean)
	 * @see org.kermeta.sintaks.sts.StsPackage#getTerminal_LexicalSeparator()
	 * @model default="false"
	 * @generated
	 */
	boolean isLexicalSeparator();

	/**
	 * Sets the value of the '{@link org.kermeta.sintaks.sts.Terminal#isLexicalSeparator <em>Lexical Separator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lexical Separator</em>' attribute.
	 * @see #isLexicalSeparator()
	 * @generated
	 */
	void setLexicalSeparator(boolean value);

	/**
	 * Returns the value of the '<em><b>Case Sensitive</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Case Sensitive</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Case Sensitive</em>' attribute.
	 * @see #setCaseSensitive(boolean)
	 * @see org.kermeta.sintaks.sts.StsPackage#getTerminal_CaseSensitive()
	 * @model default="true"
	 * @generated
	 */
	boolean isCaseSensitive();

	/**
	 * Sets the value of the '{@link org.kermeta.sintaks.sts.Terminal#isCaseSensitive <em>Case Sensitive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Case Sensitive</em>' attribute.
	 * @see #isCaseSensitive()
	 * @generated
	 */
	void setCaseSensitive(boolean value);

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
	 * @see org.kermeta.sintaks.sts.StsPackage#getTerminal_SurroundingSpaces()
	 * @model default="true"
	 * @generated
	 */
	boolean isSurroundingSpaces();

	/**
	 * Sets the value of the '{@link org.kermeta.sintaks.sts.Terminal#isSurroundingSpaces <em>Surrounding Spaces</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Surrounding Spaces</em>' attribute.
	 * @see #isSurroundingSpaces()
	 * @generated
	 */
	void setSurroundingSpaces(boolean value);


} // Terminal