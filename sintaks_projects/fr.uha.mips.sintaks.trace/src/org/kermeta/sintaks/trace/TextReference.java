/**
 * <copyright>
 * </copyright>
 *
 * $Id: TextReference.java,v 1.1 2008-07-21 13:10:32 hassen Exp $
 */
package org.kermeta.sintaks.trace;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Text Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.kermeta.sintaks.trace.TextReference#getLineBeginAt <em>Line Begin At</em>}</li>
 *   <li>{@link org.kermeta.sintaks.trace.TextReference#getCharBeginAt <em>Char Begin At</em>}</li>
 *   <li>{@link org.kermeta.sintaks.trace.TextReference#getLineEndAt <em>Line End At</em>}</li>
 *   <li>{@link org.kermeta.sintaks.trace.TextReference#getCharEndAt <em>Char End At</em>}</li>
 *   <li>{@link org.kermeta.sintaks.trace.TextReference#getText <em>Text</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.kermeta.sintaks.trace.TracePackage#getTextReference()
 * @model
 * @generated
 */
public interface TextReference extends Reference {
	/**
	 * Returns the value of the '<em><b>Line Begin At</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Line Begin At</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Line Begin At</em>' attribute.
	 * @see #setLineBeginAt(int)
	 * @see org.kermeta.sintaks.trace.TracePackage#getTextReference_LineBeginAt()
	 * @model default="-1"
	 * @generated
	 */
	int getLineBeginAt();

	/**
	 * Sets the value of the '{@link org.kermeta.sintaks.trace.TextReference#getLineBeginAt <em>Line Begin At</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Line Begin At</em>' attribute.
	 * @see #getLineBeginAt()
	 * @generated
	 */
	void setLineBeginAt(int value);

	/**
	 * Returns the value of the '<em><b>Char Begin At</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Char Begin At</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Char Begin At</em>' attribute.
	 * @see #setCharBeginAt(int)
	 * @see org.kermeta.sintaks.trace.TracePackage#getTextReference_CharBeginAt()
	 * @model default="-1"
	 * @generated
	 */
	int getCharBeginAt();

	/**
	 * Sets the value of the '{@link org.kermeta.sintaks.trace.TextReference#getCharBeginAt <em>Char Begin At</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Char Begin At</em>' attribute.
	 * @see #getCharBeginAt()
	 * @generated
	 */
	void setCharBeginAt(int value);

	/**
	 * Returns the value of the '<em><b>Line End At</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Line End At</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Line End At</em>' attribute.
	 * @see #setLineEndAt(int)
	 * @see org.kermeta.sintaks.trace.TracePackage#getTextReference_LineEndAt()
	 * @model default="-1"
	 * @generated
	 */
	int getLineEndAt();

	/**
	 * Sets the value of the '{@link org.kermeta.sintaks.trace.TextReference#getLineEndAt <em>Line End At</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Line End At</em>' attribute.
	 * @see #getLineEndAt()
	 * @generated
	 */
	void setLineEndAt(int value);

	/**
	 * Returns the value of the '<em><b>Char End At</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Char End At</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Char End At</em>' attribute.
	 * @see #setCharEndAt(int)
	 * @see org.kermeta.sintaks.trace.TracePackage#getTextReference_CharEndAt()
	 * @model default="-1"
	 * @generated
	 */
	int getCharEndAt();

	/**
	 * Sets the value of the '{@link org.kermeta.sintaks.trace.TextReference#getCharEndAt <em>Char End At</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Char End At</em>' attribute.
	 * @see #getCharEndAt()
	 * @generated
	 */
	void setCharEndAt(int value);

	/**
	 * Returns the value of the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text</em>' attribute.
	 * @see #setText(String)
	 * @see org.kermeta.sintaks.trace.TracePackage#getTextReference_Text()
	 * @model required="true"
	 * @generated
	 */
	String getText();

	/**
	 * Sets the value of the '{@link org.kermeta.sintaks.trace.TextReference#getText <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text</em>' attribute.
	 * @see #getText()
	 * @generated
	 */
	void setText(String value);

} // TextReference
