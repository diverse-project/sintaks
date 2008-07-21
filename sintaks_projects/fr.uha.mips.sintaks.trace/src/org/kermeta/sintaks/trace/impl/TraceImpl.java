/**
 * <copyright>
 * </copyright>
 *
 * $Id: TraceImpl.java,v 1.1 2008-07-21 13:10:31 hassen Exp $
 */
package org.kermeta.sintaks.trace.impl;

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

import org.kermeta.sintaks.trace.Message;
import org.kermeta.sintaks.trace.Reference;
import org.kermeta.sintaks.trace.State;
import org.kermeta.sintaks.trace.Trace;
import org.kermeta.sintaks.trace.TracePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Trace</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.kermeta.sintaks.trace.impl.TraceImpl#getState <em>State</em>}</li>
 *   <li>{@link org.kermeta.sintaks.trace.impl.TraceImpl#getSourceReference <em>Source Reference</em>}</li>
 *   <li>{@link org.kermeta.sintaks.trace.impl.TraceImpl#getTargetReference <em>Target Reference</em>}</li>
 *   <li>{@link org.kermeta.sintaks.trace.impl.TraceImpl#getRuleReference <em>Rule Reference</em>}</li>
 *   <li>{@link org.kermeta.sintaks.trace.impl.TraceImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.kermeta.sintaks.trace.impl.TraceImpl#getSubTraces <em>Sub Traces</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TraceImpl extends EObjectImpl implements Trace {
	/**
	 * The default value of the '{@link #getState() <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected static final State STATE_EDEFAULT = State.IN_PROGRESS;

	/**
	 * The cached value of the '{@link #getState() <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected State state = STATE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSourceReference() <em>Source Reference</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceReference()
	 * @generated
	 * @ordered
	 */
	protected Reference sourceReference;

	/**
	 * The cached value of the '{@link #getTargetReference() <em>Target Reference</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetReference()
	 * @generated
	 * @ordered
	 */
	protected Reference targetReference;

	/**
	 * The cached value of the '{@link #getRuleReference() <em>Rule Reference</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRuleReference()
	 * @generated
	 * @ordered
	 */
	protected Reference ruleReference;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected EList<Message> description;

	/**
	 * The cached value of the '{@link #getSubTraces() <em>Sub Traces</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubTraces()
	 * @generated
	 * @ordered
	 */
	protected EList<Trace> subTraces;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TraceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TracePackage.Literals.TRACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State getState() {
		return state;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setState(State newState) {
		State oldState = state;
		state = newState == null ? STATE_EDEFAULT : newState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.TRACE__STATE, oldState, state));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Reference getSourceReference() {
		return sourceReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSourceReference(Reference newSourceReference, NotificationChain msgs) {
		Reference oldSourceReference = sourceReference;
		sourceReference = newSourceReference;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TracePackage.TRACE__SOURCE_REFERENCE, oldSourceReference, newSourceReference);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceReference(Reference newSourceReference) {
		if (newSourceReference != sourceReference) {
			NotificationChain msgs = null;
			if (sourceReference != null)
				msgs = ((InternalEObject)sourceReference).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TracePackage.TRACE__SOURCE_REFERENCE, null, msgs);
			if (newSourceReference != null)
				msgs = ((InternalEObject)newSourceReference).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TracePackage.TRACE__SOURCE_REFERENCE, null, msgs);
			msgs = basicSetSourceReference(newSourceReference, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.TRACE__SOURCE_REFERENCE, newSourceReference, newSourceReference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Reference getTargetReference() {
		return targetReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTargetReference(Reference newTargetReference, NotificationChain msgs) {
		Reference oldTargetReference = targetReference;
		targetReference = newTargetReference;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TracePackage.TRACE__TARGET_REFERENCE, oldTargetReference, newTargetReference);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetReference(Reference newTargetReference) {
		if (newTargetReference != targetReference) {
			NotificationChain msgs = null;
			if (targetReference != null)
				msgs = ((InternalEObject)targetReference).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TracePackage.TRACE__TARGET_REFERENCE, null, msgs);
			if (newTargetReference != null)
				msgs = ((InternalEObject)newTargetReference).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TracePackage.TRACE__TARGET_REFERENCE, null, msgs);
			msgs = basicSetTargetReference(newTargetReference, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.TRACE__TARGET_REFERENCE, newTargetReference, newTargetReference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Reference getRuleReference() {
		return ruleReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRuleReference(Reference newRuleReference, NotificationChain msgs) {
		Reference oldRuleReference = ruleReference;
		ruleReference = newRuleReference;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TracePackage.TRACE__RULE_REFERENCE, oldRuleReference, newRuleReference);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRuleReference(Reference newRuleReference) {
		if (newRuleReference != ruleReference) {
			NotificationChain msgs = null;
			if (ruleReference != null)
				msgs = ((InternalEObject)ruleReference).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TracePackage.TRACE__RULE_REFERENCE, null, msgs);
			if (newRuleReference != null)
				msgs = ((InternalEObject)newRuleReference).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TracePackage.TRACE__RULE_REFERENCE, null, msgs);
			msgs = basicSetRuleReference(newRuleReference, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.TRACE__RULE_REFERENCE, newRuleReference, newRuleReference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Message> getDescription() {
		if (description == null) {
			description = new EObjectContainmentEList<Message>(Message.class, this, TracePackage.TRACE__DESCRIPTION);
		}
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Trace> getSubTraces() {
		if (subTraces == null) {
			subTraces = new EObjectContainmentEList<Trace>(Trace.class, this, TracePackage.TRACE__SUB_TRACES);
		}
		return subTraces;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TracePackage.TRACE__SOURCE_REFERENCE:
				return basicSetSourceReference(null, msgs);
			case TracePackage.TRACE__TARGET_REFERENCE:
				return basicSetTargetReference(null, msgs);
			case TracePackage.TRACE__RULE_REFERENCE:
				return basicSetRuleReference(null, msgs);
			case TracePackage.TRACE__DESCRIPTION:
				return ((InternalEList<?>)getDescription()).basicRemove(otherEnd, msgs);
			case TracePackage.TRACE__SUB_TRACES:
				return ((InternalEList<?>)getSubTraces()).basicRemove(otherEnd, msgs);
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
			case TracePackage.TRACE__STATE:
				return getState();
			case TracePackage.TRACE__SOURCE_REFERENCE:
				return getSourceReference();
			case TracePackage.TRACE__TARGET_REFERENCE:
				return getTargetReference();
			case TracePackage.TRACE__RULE_REFERENCE:
				return getRuleReference();
			case TracePackage.TRACE__DESCRIPTION:
				return getDescription();
			case TracePackage.TRACE__SUB_TRACES:
				return getSubTraces();
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
			case TracePackage.TRACE__STATE:
				setState((State)newValue);
				return;
			case TracePackage.TRACE__SOURCE_REFERENCE:
				setSourceReference((Reference)newValue);
				return;
			case TracePackage.TRACE__TARGET_REFERENCE:
				setTargetReference((Reference)newValue);
				return;
			case TracePackage.TRACE__RULE_REFERENCE:
				setRuleReference((Reference)newValue);
				return;
			case TracePackage.TRACE__DESCRIPTION:
				getDescription().clear();
				getDescription().addAll((Collection<? extends Message>)newValue);
				return;
			case TracePackage.TRACE__SUB_TRACES:
				getSubTraces().clear();
				getSubTraces().addAll((Collection<? extends Trace>)newValue);
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
			case TracePackage.TRACE__STATE:
				setState(STATE_EDEFAULT);
				return;
			case TracePackage.TRACE__SOURCE_REFERENCE:
				setSourceReference((Reference)null);
				return;
			case TracePackage.TRACE__TARGET_REFERENCE:
				setTargetReference((Reference)null);
				return;
			case TracePackage.TRACE__RULE_REFERENCE:
				setRuleReference((Reference)null);
				return;
			case TracePackage.TRACE__DESCRIPTION:
				getDescription().clear();
				return;
			case TracePackage.TRACE__SUB_TRACES:
				getSubTraces().clear();
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
			case TracePackage.TRACE__STATE:
				return state != STATE_EDEFAULT;
			case TracePackage.TRACE__SOURCE_REFERENCE:
				return sourceReference != null;
			case TracePackage.TRACE__TARGET_REFERENCE:
				return targetReference != null;
			case TracePackage.TRACE__RULE_REFERENCE:
				return ruleReference != null;
			case TracePackage.TRACE__DESCRIPTION:
				return description != null && !description.isEmpty();
			case TracePackage.TRACE__SUB_TRACES:
				return subTraces != null && !subTraces.isEmpty();
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
		result.append(" (state: ");
		result.append(state);
		result.append(')');
		return result.toString();
	}

} //TraceImpl
