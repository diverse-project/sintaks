/**
 * <copyright>
 * </copyright>
 *
 * $Id: ValueImpl.java,v 1.3 2008-02-04 08:22:15 hassen Exp $
 */
package org.kermeta.sintaks.sts.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.kermeta.sintaks.sts.StsPackage;
import org.kermeta.sintaks.sts.Value;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.kermeta.sintaks.sts.impl.ValueImpl#getFeatures <em>Features</em>}</li>
 *   <li>{@link org.kermeta.sintaks.sts.impl.ValueImpl#isSurroundingSpaces <em>Surrounding Spaces</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ValueImpl extends RuleImpl implements Value {
	/**
	 * The cached value of the '{@link #getFeatures() <em>Features</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<EStructuralFeature> features;

	/**
	 * The default value of the '{@link #isSurroundingSpaces() <em>Surrounding Spaces</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSurroundingSpaces()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SURROUNDING_SPACES_EDEFAULT = true;
	/**
	 * The cached value of the '{@link #isSurroundingSpaces() <em>Surrounding Spaces</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSurroundingSpaces()
	 * @generated
	 * @ordered
	 */
	protected boolean surroundingSpaces = SURROUNDING_SPACES_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StsPackage.Literals.VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EStructuralFeature> getFeatures() {
		if (features == null) {
			features = new EObjectResolvingEList<EStructuralFeature>(EStructuralFeature.class, this, StsPackage.VALUE__FEATURES);
		}
		return features;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSurroundingSpaces() {
		return surroundingSpaces;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSurroundingSpaces(boolean newSurroundingSpaces) {
		boolean oldSurroundingSpaces = surroundingSpaces;
		surroundingSpaces = newSurroundingSpaces;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StsPackage.VALUE__SURROUNDING_SPACES, oldSurroundingSpaces, surroundingSpaces));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StsPackage.VALUE__FEATURES:
				return getFeatures();
			case StsPackage.VALUE__SURROUNDING_SPACES:
				return isSurroundingSpaces() ? Boolean.TRUE : Boolean.FALSE;
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
			case StsPackage.VALUE__FEATURES:
				getFeatures().clear();
				getFeatures().addAll((Collection<? extends EStructuralFeature>)newValue);
				return;
			case StsPackage.VALUE__SURROUNDING_SPACES:
				setSurroundingSpaces(((Boolean)newValue).booleanValue());
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
			case StsPackage.VALUE__FEATURES:
				getFeatures().clear();
				return;
			case StsPackage.VALUE__SURROUNDING_SPACES:
				setSurroundingSpaces(SURROUNDING_SPACES_EDEFAULT);
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
			case StsPackage.VALUE__FEATURES:
				return features != null && !features.isEmpty();
			case StsPackage.VALUE__SURROUNDING_SPACES:
				return surroundingSpaces != SURROUNDING_SPACES_EDEFAULT;
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
		result.append(" (surroundingSpaces: ");
		result.append(surroundingSpaces);
		result.append(')');
		return result.toString();
	}

} //ValueImpl