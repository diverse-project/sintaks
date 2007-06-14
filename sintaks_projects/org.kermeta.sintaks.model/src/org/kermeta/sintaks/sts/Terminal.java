/**
 * <copyright>
 * </copyright>
 *
 * $Id: Terminal.java,v 1.1 2007-06-14 08:57:30 dtouzet Exp $
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
	 * @model
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
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lexical Separator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lexical Separator</em>' attribute.
	 * @see #setLexicalSeparator(boolean)
	 * @see org.kermeta.sintaks.sts.StsPackage#getTerminal_LexicalSeparator()
	 * @model
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

} // Terminal