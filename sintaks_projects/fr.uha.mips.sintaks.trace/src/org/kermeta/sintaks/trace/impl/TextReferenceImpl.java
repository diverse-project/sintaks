/**
 * <copyright>
 * </copyright>
 *
 * $Id: TextReferenceImpl.java,v 1.1 2008-07-21 13:10:30 hassen Exp $
 */
package org.kermeta.sintaks.trace.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.kermeta.sintaks.trace.TextReference;
import org.kermeta.sintaks.trace.TracePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Text Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.kermeta.sintaks.trace.impl.TextReferenceImpl#getLineBeginAt <em>Line Begin At</em>}</li>
 *   <li>{@link org.kermeta.sintaks.trace.impl.TextReferenceImpl#getCharBeginAt <em>Char Begin At</em>}</li>
 *   <li>{@link org.kermeta.sintaks.trace.impl.TextReferenceImpl#getLineEndAt <em>Line End At</em>}</li>
 *   <li>{@link org.kermeta.sintaks.trace.impl.TextReferenceImpl#getCharEndAt <em>Char End At</em>}</li>
 *   <li>{@link org.kermeta.sintaks.trace.impl.TextReferenceImpl#getText <em>Text</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TextReferenceImpl extends ReferenceImpl implements TextReference {
	/**
	 * The default value of the '{@link #getLineBeginAt() <em>Line Begin At</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLineBeginAt()
	 * @generated
	 * @ordered
	 */
	protected static final int LINE_BEGIN_AT_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getLineBeginAt() <em>Line Begin At</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLineBeginAt()
	 * @generated
	 * @ordered
	 */
	protected int lineBeginAt = LINE_BEGIN_AT_EDEFAULT;

	/**
	 * The default value of the '{@link #getCharBeginAt() <em>Char Begin At</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCharBeginAt()
	 * @generated
	 * @ordered
	 */
	protected static final int CHAR_BEGIN_AT_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getCharBeginAt() <em>Char Begin At</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCharBeginAt()
	 * @generated
	 * @ordered
	 */
	protected int charBeginAt = CHAR_BEGIN_AT_EDEFAULT;

	/**
	 * The default value of the '{@link #getLineEndAt() <em>Line End At</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLineEndAt()
	 * @generated
	 * @ordered
	 */
	protected static final int LINE_END_AT_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getLineEndAt() <em>Line End At</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLineEndAt()
	 * @generated
	 * @ordered
	 */
	protected int lineEndAt = LINE_END_AT_EDEFAULT;

	/**
	 * The default value of the '{@link #getCharEndAt() <em>Char End At</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCharEndAt()
	 * @generated
	 * @ordered
	 */
	protected static final int CHAR_END_AT_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getCharEndAt() <em>Char End At</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCharEndAt()
	 * @generated
	 * @ordered
	 */
	protected int charEndAt = CHAR_END_AT_EDEFAULT;

	/**
	 * The default value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected static final String TEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected String text = TEXT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TextReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TracePackage.Literals.TEXT_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLineBeginAt() {
		return lineBeginAt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLineBeginAt(int newLineBeginAt) {
		int oldLineBeginAt = lineBeginAt;
		lineBeginAt = newLineBeginAt;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.TEXT_REFERENCE__LINE_BEGIN_AT, oldLineBeginAt, lineBeginAt));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCharBeginAt() {
		return charBeginAt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCharBeginAt(int newCharBeginAt) {
		int oldCharBeginAt = charBeginAt;
		charBeginAt = newCharBeginAt;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.TEXT_REFERENCE__CHAR_BEGIN_AT, oldCharBeginAt, charBeginAt));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLineEndAt() {
		return lineEndAt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLineEndAt(int newLineEndAt) {
		int oldLineEndAt = lineEndAt;
		lineEndAt = newLineEndAt;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.TEXT_REFERENCE__LINE_END_AT, oldLineEndAt, lineEndAt));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCharEndAt() {
		return charEndAt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCharEndAt(int newCharEndAt) {
		int oldCharEndAt = charEndAt;
		charEndAt = newCharEndAt;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.TEXT_REFERENCE__CHAR_END_AT, oldCharEndAt, charEndAt));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText() {
		return text;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setText(String newText) {
		String oldText = text;
		text = newText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.TEXT_REFERENCE__TEXT, oldText, text));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TracePackage.TEXT_REFERENCE__LINE_BEGIN_AT:
				return new Integer(getLineBeginAt());
			case TracePackage.TEXT_REFERENCE__CHAR_BEGIN_AT:
				return new Integer(getCharBeginAt());
			case TracePackage.TEXT_REFERENCE__LINE_END_AT:
				return new Integer(getLineEndAt());
			case TracePackage.TEXT_REFERENCE__CHAR_END_AT:
				return new Integer(getCharEndAt());
			case TracePackage.TEXT_REFERENCE__TEXT:
				return getText();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TracePackage.TEXT_REFERENCE__LINE_BEGIN_AT:
				setLineBeginAt(((Integer)newValue).intValue());
				return;
			case TracePackage.TEXT_REFERENCE__CHAR_BEGIN_AT:
				setCharBeginAt(((Integer)newValue).intValue());
				return;
			case TracePackage.TEXT_REFERENCE__LINE_END_AT:
				setLineEndAt(((Integer)newValue).intValue());
				return;
			case TracePackage.TEXT_REFERENCE__CHAR_END_AT:
				setCharEndAt(((Integer)newValue).intValue());
				return;
			case TracePackage.TEXT_REFERENCE__TEXT:
				setText((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TracePackage.TEXT_REFERENCE__LINE_BEGIN_AT:
				setLineBeginAt(LINE_BEGIN_AT_EDEFAULT);
				return;
			case TracePackage.TEXT_REFERENCE__CHAR_BEGIN_AT:
				setCharBeginAt(CHAR_BEGIN_AT_EDEFAULT);
				return;
			case TracePackage.TEXT_REFERENCE__LINE_END_AT:
				setLineEndAt(LINE_END_AT_EDEFAULT);
				return;
			case TracePackage.TEXT_REFERENCE__CHAR_END_AT:
				setCharEndAt(CHAR_END_AT_EDEFAULT);
				return;
			case TracePackage.TEXT_REFERENCE__TEXT:
				setText(TEXT_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TracePackage.TEXT_REFERENCE__LINE_BEGIN_AT:
				return lineBeginAt != LINE_BEGIN_AT_EDEFAULT;
			case TracePackage.TEXT_REFERENCE__CHAR_BEGIN_AT:
				return charBeginAt != CHAR_BEGIN_AT_EDEFAULT;
			case TracePackage.TEXT_REFERENCE__LINE_END_AT:
				return lineEndAt != LINE_END_AT_EDEFAULT;
			case TracePackage.TEXT_REFERENCE__CHAR_END_AT:
				return charEndAt != CHAR_END_AT_EDEFAULT;
			case TracePackage.TEXT_REFERENCE__TEXT:
				return TEXT_EDEFAULT == null ? text != null : !TEXT_EDEFAULT.equals(text);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (lineBeginAt: ");
		result.append(lineBeginAt);
		result.append(", charBeginAt: ");
		result.append(charBeginAt);
		result.append(", lineEndAt: ");
		result.append(lineEndAt);
		result.append(", charEndAt: ");
		result.append(charEndAt);
		result.append(", text: ");
		result.append(text);
		result.append(')');
		return result.toString();
	}

} //TextReferenceImpl
