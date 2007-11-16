/**
 * <copyright>
 * </copyright>
 *
 * $Id: SequenceImpl.java,v 1.3 2007-11-16 14:22:32 dvojtise Exp $
 */
package org.kermeta.sintaks.sts.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.kermeta.sintaks.sts.Rule;
import org.kermeta.sintaks.sts.Sequence;
import org.kermeta.sintaks.sts.StsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sequence</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.kermeta.sintaks.sts.impl.SequenceImpl#getSubRules <em>Sub Rules</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SequenceImpl extends RuleImpl implements Sequence {
	/**
	 * The cached value of the '{@link #getSubRules() <em>Sub Rules</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubRules()
	 * @generated
	 * @ordered
	 */
	protected EList<Rule> subRules;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SequenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StsPackage.Literals.SEQUENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Rule> getSubRules() {
		if (subRules == null) {
			subRules = new EObjectContainmentEList<Rule>(Rule.class, this, StsPackage.SEQUENCE__SUB_RULES);
		}
		return subRules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StsPackage.SEQUENCE__SUB_RULES:
				return ((InternalEList<?>)getSubRules()).basicRemove(otherEnd, msgs);
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
			case StsPackage.SEQUENCE__SUB_RULES:
				return getSubRules();
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
			case StsPackage.SEQUENCE__SUB_RULES:
				getSubRules().clear();
				getSubRules().addAll((Collection<? extends Rule>)newValue);
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
			case StsPackage.SEQUENCE__SUB_RULES:
				getSubRules().clear();
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
			case StsPackage.SEQUENCE__SUB_RULES:
				return subRules != null && !subRules.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SequenceImpl