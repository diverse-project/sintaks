/**
 * <copyright>
 * </copyright>
 *
 * $Id: IterationImpl.java,v 1.4 2008-07-11 09:31:37 hassen Exp $
 */
package org.kermeta.sintaks.sts.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
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
 *   <li>{@link org.kermeta.sintaks.sts.impl.IterationImpl#getContainers <em>Containers</em>}</li>
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
	 * The cached value of the '{@link #getSeparator() <em>Separator</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeparator()
	 * @generated
	 * @ordered
	 */
	protected Rule separator;

	/**
	 * The cached value of the '{@link #getContainers() <em>Containers</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainers()
	 * @generated
	 * @ordered
	 */
	protected EList<EStructuralFeature> containers;

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
		EStructuralFeature container = basicGetContainer();
		return container != null && container.eIsProxy() ? (EStructuralFeature)eResolveProxy((InternalEObject)container) : container;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EStructuralFeature basicGetContainer() {
		if (getContainers().size() > 0) return getContainers().get(0);
		else return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setContainer(EStructuralFeature newContainer) {
		getContainers().add(0, newContainer);
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
	public EList<EStructuralFeature> getContainers() {
		if (containers == null) {
			containers = new EObjectResolvingEList<EStructuralFeature>(EStructuralFeature.class, this, StsPackage.ITERATION__CONTAINERS);
		}
		return containers;
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
				return getSubRule();
			case StsPackage.ITERATION__CONTAINER:
				if (resolve) return getContainer();
				return basicGetContainer();
			case StsPackage.ITERATION__SEPARATOR:
				if (resolve) return getSeparator();
				return basicGetSeparator();
			case StsPackage.ITERATION__CONTAINERS:
				return getContainers();
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
			case StsPackage.ITERATION__SUB_RULE:
				setSubRule((Rule)newValue);
				return;
			case StsPackage.ITERATION__CONTAINER:
				setContainer((EStructuralFeature)newValue);
				return;
			case StsPackage.ITERATION__SEPARATOR:
				setSeparator((Rule)newValue);
				return;
			case StsPackage.ITERATION__CONTAINERS:
				getContainers().clear();
				getContainers().addAll((Collection<? extends EStructuralFeature>)newValue);
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
			case StsPackage.ITERATION__CONTAINERS:
				getContainers().clear();
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
				return basicGetContainer() != null;
			case StsPackage.ITERATION__SEPARATOR:
				return separator != null;
			case StsPackage.ITERATION__CONTAINERS:
				return containers != null && !containers.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //IterationImpl