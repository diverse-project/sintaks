/**
 * <copyright>
 * </copyright>
 *
 * $Id: RootImpl.java,v 1.4 2008-04-15 14:22:07 hassen Exp $
 */
package org.kermeta.sintaks.sts.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.kermeta.sintaks.sts.Root;
import org.kermeta.sintaks.sts.Rule;
import org.kermeta.sintaks.sts.StsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.kermeta.sintaks.sts.impl.RootImpl#getFragments <em>Fragments</em>}</li>
 *   <li>{@link org.kermeta.sintaks.sts.impl.RootImpl#getStart <em>Start</em>}</li>
 *   <li>{@link org.kermeta.sintaks.sts.impl.RootImpl#getStringDelimliter <em>String Delimliter</em>}</li>
 *   <li>{@link org.kermeta.sintaks.sts.impl.RootImpl#getEscapeCharacter <em>Escape Character</em>}</li>
 *   <li>{@link org.kermeta.sintaks.sts.impl.RootImpl#getEolComment <em>Eol Comment</em>}</li>
 *   <li>{@link org.kermeta.sintaks.sts.impl.RootImpl#getBlockCommentStart <em>Block Comment Start</em>}</li>
 *   <li>{@link org.kermeta.sintaks.sts.impl.RootImpl#getBlockCommentEnd <em>Block Comment End</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RootImpl extends EObjectImpl implements Root {
	/**
	 * The cached value of the '{@link #getFragments() <em>Fragments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFragments()
	 * @generated
	 * @ordered
	 */
	protected EList<Rule> fragments;

	/**
	 * The cached value of the '{@link #getStart() <em>Start</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStart()
	 * @generated
	 * @ordered
	 */
	protected Rule start;

	/**
	 * The default value of the '{@link #getStringDelimliter() <em>String Delimliter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStringDelimliter()
	 * @generated
	 * @ordered
	 */
	protected static final char STRING_DELIMLITER_EDEFAULT = '\"';

	/**
	 * The cached value of the '{@link #getStringDelimliter() <em>String Delimliter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStringDelimliter()
	 * @generated
	 * @ordered
	 */
	protected char stringDelimliter = STRING_DELIMLITER_EDEFAULT;

	/**
	 * The default value of the '{@link #getEscapeCharacter() <em>Escape Character</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEscapeCharacter()
	 * @generated
	 * @ordered
	 */
	protected static final char ESCAPE_CHARACTER_EDEFAULT = '\\';

	/**
	 * The cached value of the '{@link #getEscapeCharacter() <em>Escape Character</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEscapeCharacter()
	 * @generated
	 * @ordered
	 */
	protected char escapeCharacter = ESCAPE_CHARACTER_EDEFAULT;

	/**
	 * The default value of the '{@link #getEolComment() <em>Eol Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEolComment()
	 * @generated
	 * @ordered
	 */
	protected static final String EOL_COMMENT_EDEFAULT = "--";

	/**
	 * The cached value of the '{@link #getEolComment() <em>Eol Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEolComment()
	 * @generated
	 * @ordered
	 */
	protected String eolComment = EOL_COMMENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getBlockCommentStart() <em>Block Comment Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBlockCommentStart()
	 * @generated
	 * @ordered
	 */
	protected static final String BLOCK_COMMENT_START_EDEFAULT = "\\/*";

	/**
	 * The cached value of the '{@link #getBlockCommentStart() <em>Block Comment Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBlockCommentStart()
	 * @generated
	 * @ordered
	 */
	protected String blockCommentStart = BLOCK_COMMENT_START_EDEFAULT;

	/**
	 * The default value of the '{@link #getBlockCommentEnd() <em>Block Comment End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBlockCommentEnd()
	 * @generated
	 * @ordered
	 */
	protected static final String BLOCK_COMMENT_END_EDEFAULT = "*\\/";

	/**
	 * The cached value of the '{@link #getBlockCommentEnd() <em>Block Comment End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBlockCommentEnd()
	 * @generated
	 * @ordered
	 */
	protected String blockCommentEnd = BLOCK_COMMENT_END_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StsPackage.Literals.ROOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Rule> getFragments() {
		if (fragments == null) {
			fragments = new EObjectContainmentEList<Rule>(Rule.class, this, StsPackage.ROOT__FRAGMENTS);
		}
		return fragments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Rule getStart() {
		if (start != null && start.eIsProxy()) {
			InternalEObject oldStart = (InternalEObject)start;
			start = (Rule)eResolveProxy(oldStart);
			if (start != oldStart) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StsPackage.ROOT__START, oldStart, start));
			}
		}
		return start;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Rule basicGetStart() {
		return start;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStart(Rule newStart) {
		Rule oldStart = start;
		start = newStart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StsPackage.ROOT__START, oldStart, start));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public char getStringDelimliter() {
		return stringDelimliter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStringDelimliter(char newStringDelimliter) {
		char oldStringDelimliter = stringDelimliter;
		stringDelimliter = newStringDelimliter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StsPackage.ROOT__STRING_DELIMLITER, oldStringDelimliter, stringDelimliter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public char getEscapeCharacter() {
		return escapeCharacter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEscapeCharacter(char newEscapeCharacter) {
		char oldEscapeCharacter = escapeCharacter;
		escapeCharacter = newEscapeCharacter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StsPackage.ROOT__ESCAPE_CHARACTER, oldEscapeCharacter, escapeCharacter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEolComment() {
		return eolComment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEolComment(String newEolComment) {
		String oldEolComment = eolComment;
		eolComment = newEolComment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StsPackage.ROOT__EOL_COMMENT, oldEolComment, eolComment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBlockCommentStart() {
		return blockCommentStart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBlockCommentStart(String newBlockCommentStart) {
		String oldBlockCommentStart = blockCommentStart;
		blockCommentStart = newBlockCommentStart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StsPackage.ROOT__BLOCK_COMMENT_START, oldBlockCommentStart, blockCommentStart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBlockCommentEnd() {
		return blockCommentEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBlockCommentEnd(String newBlockCommentEnd) {
		String oldBlockCommentEnd = blockCommentEnd;
		blockCommentEnd = newBlockCommentEnd;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StsPackage.ROOT__BLOCK_COMMENT_END, oldBlockCommentEnd, blockCommentEnd));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StsPackage.ROOT__FRAGMENTS:
				return ((InternalEList<?>)getFragments()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StsPackage.ROOT__FRAGMENTS:
				return getFragments();
			case StsPackage.ROOT__START:
				if (resolve) return getStart();
				return basicGetStart();
			case StsPackage.ROOT__STRING_DELIMLITER:
				return new Character(getStringDelimliter());
			case StsPackage.ROOT__ESCAPE_CHARACTER:
				return new Character(getEscapeCharacter());
			case StsPackage.ROOT__EOL_COMMENT:
				return getEolComment();
			case StsPackage.ROOT__BLOCK_COMMENT_START:
				return getBlockCommentStart();
			case StsPackage.ROOT__BLOCK_COMMENT_END:
				return getBlockCommentEnd();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
		@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case StsPackage.ROOT__FRAGMENTS:
				getFragments().clear();
				getFragments().addAll((Collection<? extends Rule>)newValue);
				return;
			case StsPackage.ROOT__START:
				setStart((Rule)newValue);
				return;
			case StsPackage.ROOT__STRING_DELIMLITER:
				setStringDelimliter(((Character)newValue).charValue());
				return;
			case StsPackage.ROOT__ESCAPE_CHARACTER:
				setEscapeCharacter(((Character)newValue).charValue());
				return;
			case StsPackage.ROOT__EOL_COMMENT:
				setEolComment((String)newValue);
				return;
			case StsPackage.ROOT__BLOCK_COMMENT_START:
				setBlockCommentStart((String)newValue);
				return;
			case StsPackage.ROOT__BLOCK_COMMENT_END:
				setBlockCommentEnd((String)newValue);
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
			case StsPackage.ROOT__FRAGMENTS:
				getFragments().clear();
				return;
			case StsPackage.ROOT__START:
				setStart((Rule)null);
				return;
			case StsPackage.ROOT__STRING_DELIMLITER:
				setStringDelimliter(STRING_DELIMLITER_EDEFAULT);
				return;
			case StsPackage.ROOT__ESCAPE_CHARACTER:
				setEscapeCharacter(ESCAPE_CHARACTER_EDEFAULT);
				return;
			case StsPackage.ROOT__EOL_COMMENT:
				setEolComment(EOL_COMMENT_EDEFAULT);
				return;
			case StsPackage.ROOT__BLOCK_COMMENT_START:
				setBlockCommentStart(BLOCK_COMMENT_START_EDEFAULT);
				return;
			case StsPackage.ROOT__BLOCK_COMMENT_END:
				setBlockCommentEnd(BLOCK_COMMENT_END_EDEFAULT);
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
			case StsPackage.ROOT__FRAGMENTS:
				return fragments != null && !fragments.isEmpty();
			case StsPackage.ROOT__START:
				return start != null;
			case StsPackage.ROOT__STRING_DELIMLITER:
				return stringDelimliter != STRING_DELIMLITER_EDEFAULT;
			case StsPackage.ROOT__ESCAPE_CHARACTER:
				return escapeCharacter != ESCAPE_CHARACTER_EDEFAULT;
			case StsPackage.ROOT__EOL_COMMENT:
				return EOL_COMMENT_EDEFAULT == null ? eolComment != null : !EOL_COMMENT_EDEFAULT.equals(eolComment);
			case StsPackage.ROOT__BLOCK_COMMENT_START:
				return BLOCK_COMMENT_START_EDEFAULT == null ? blockCommentStart != null : !BLOCK_COMMENT_START_EDEFAULT.equals(blockCommentStart);
			case StsPackage.ROOT__BLOCK_COMMENT_END:
				return BLOCK_COMMENT_END_EDEFAULT == null ? blockCommentEnd != null : !BLOCK_COMMENT_END_EDEFAULT.equals(blockCommentEnd);
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
		result.append(" (stringDelimliter: ");
		result.append(stringDelimliter);
		result.append(", escapeCharacter: ");
		result.append(escapeCharacter);
		result.append(", eolComment: ");
		result.append(eolComment);
		result.append(", blockCommentStart: ");
		result.append(blockCommentStart);
		result.append(", blockCommentEnd: ");
		result.append(blockCommentEnd);
		result.append(')');
		return result.toString();
	}

} //RootImpl