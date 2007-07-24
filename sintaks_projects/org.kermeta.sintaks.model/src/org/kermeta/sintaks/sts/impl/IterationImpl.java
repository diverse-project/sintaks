/**
 * <copyright>
 * </copyright>
 *
 * $Id: IterationImpl.java,v 1.2 2007-07-24 12:12:18 cfaucher Exp $
 */
package org.kermeta.sintaks.sts.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.kermeta.sintaks.sts.Iteration;
import org.kermeta.sintaks.sts.Rule;
import org.kermeta.sintaks.sts.StsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Iteration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.kermeta.sintaks.sts.impl.IterationImpl#getSubRule <em>Sub Rule</em>}</li>
 *   <li>{@link org.kermeta.sintaks.sts.impl.IterationImpl#getContainer <em>Container</em>}</li>
 *   <li>{@link org.kermeta.sintaks.sts.impl.IterationImpl#getSeparator <em>Separator</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IterationImpl extends RuleImpl implements Iteration {
	/**
	 * The cached value of the '{@link #getSubRule() <em>Sub Rule</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubRule()
	 * @generated
	 * @ordered
	 */
	protected Rule subRule;

	/**
	 * The cached value of the '{@link #getContainer() <em>Container</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainer()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature container;

	/**
	 * The cached value of the '{@link #getSeparator() <em>Separator</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeparator()
	 * @generated
	 * @ordered
	 */
	protected Rule separator;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IterationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StsPackage.Literals.ITERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Rule getSubRule() {
		if (subRule != null && subRule.eIsProxy()) {
			InternalEObject oldSubRule = (InternalEObject)subRule;
			subRule = (Rule)eResolveProxy(oldSubRule);
			if (subRule != oldSubRule) {
				InternalEObject newSubRule = (InternalEObject)subRule;
				NotificationChain msgs = oldSubRule.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StsPackage.ITERATION__SUB_RULE, null, null);
				if (newSubRule.eInternalContainer() == null) {
					msgs = newSubRule.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StsPackage.ITERATION__SUB_RULE, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StsPackage.ITERATION__SUB_RULE, oldSubRule, subRule));
			}
		}
		return subRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Rule basicGetSubRule() {
		return subRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSubRule(Rule newSubRule, NotificationChain msgs) {
		Rule oldSubRule = subRule;
		subRule = newSubRule;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StsPackage.ITERATION__SUB_RULE, oldSubRule, newSubRule);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubRule(Rule newSubRule) {
		if (newSubRule != subRule) {
			NotificationChain msgs = null;
			if (subRule != null)
				msgs = ((InternalEObject)subRule).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StsPackage.ITERATION__SUB_RULE, null, msgs);
			if (newSubRule != null)
				msgs = ((InternalEObject)newSubRule).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StsPackage.ITERATION__SUB_RULE, null, msgs);
			msgs = basicSetSubRule(newSubRule, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StsPackage.ITERATION__SUB_RULE, newSubRule, newSubRule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EStructuralFeature getContainer() {
		if (container != null && container.eIsProxy()) {
			InternalEObject oldContainer = (InternalEObject)container;
			container = (EStructuralFeature)eResolveProxy(oldContainer);
			if (container != oldContainer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StsPackage.ITERATION__CONTAINER, oldContainer, container));
			}
		}
		return container;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EStructuralFeature basicGetContainer() {
		return container;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainer(EStructuralFeature newContainer) {
		EStructuralFeature oldContainer = container;
		container = newContainer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StsPackage.ITERATION__CONTAINER, oldContainer, container));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Rule getSeparator() {
		if (separator != null && separator.eIsProxy()) {
			InternalEObject oldSeparator = (InternalEObject)separator;
			separator = (Rule)eResolveProxy(oldSeparator);
			if (separator != oldSeparator) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StsPackage.ITERATION__SEPARATOR, oldSeparator, separator));
			}
		}
		return separator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Rule basicGetSeparator() {
		return separator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSeparator(Rule newSeparator) {
		Rule oldSeparator = separator;
		separator = newSeparator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StsPackage.ITERATION__SEPARATOR, oldSeparator, separator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StsPackage.ITERATION__SUB_RULE:
				return basicSetSubRule(null, msgs);
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
			case StsPackage.ITERATION__SUB_RULE:
				if (resolve) return getSubRule();
				return basicGetSubRule();
			case StsPackage.ITERATION__CONTAINER:
				if (resolve) return getContainer();
				return basicGetContainer();
			case StsPackage.ITERATION__SEPARATOR:
				if (resolve) return getSeparator();
				return basicGetSeparator();
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
			case StsPackage.ITERATION__SUB_RULE:
				setSubRule((Rule)newValue);
				return;
			case StsPackage.ITERATION__CONTAINER:
				setContainer((EStructuralFeature)newValue);
				return;
			case StsPackage.ITERATION__SEPARATOR:
				setSeparator((Rule)newValue);
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
			case StsPackage.ITERATION__SUB_RULE:
				setSubRule((Rule)null);
				return;
			case StsPackage.ITERATION__CONTAINER:
				setContainer((EStructuralFeature)null);
				return;
			case StsPackage.ITERATION__SEPARATOR:
				setSeparator((Rule)null);
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
			case StsPackage.ITERATION__SUB_RULE:
				return subRule != null;
			case StsPackage.ITERATION__CONTAINER:
				return container != null;
			case StsPackage.ITERATION__SEPARATOR:
				return separator != null;
		}
		return super.eIsSet(featureID);
	}

} //IterationImpl