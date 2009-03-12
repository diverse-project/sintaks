/**
 * <copyright>
 * </copyright>
 *
 * $Id: StsGenFeatureImpl.java,v 1.2 2009-03-12 07:57:15 hassen Exp $
 */
package fr.uha.mips.sintaks.stsgen.impl;

import fr.uha.mips.sintaks.stsgen.StsGenClass;
import fr.uha.mips.sintaks.stsgen.StsGenFeature;
import fr.uha.mips.sintaks.stsgen.StsgenPackage;

import fr.uha.mips.sintaks.stsgen.Type;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sts Gen Feature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.uha.mips.sintaks.stsgen.impl.StsGenFeatureImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link fr.uha.mips.sintaks.stsgen.impl.StsGenFeatureImpl#getTargetFeature <em>Target Feature</em>}</li>
 *   <li>{@link fr.uha.mips.sintaks.stsgen.impl.StsGenFeatureImpl#isNotUsed <em>Not Used</em>}</li>
 *   <li>{@link fr.uha.mips.sintaks.stsgen.impl.StsGenFeatureImpl#getType <em>Type</em>}</li>
 *   <li>{@link fr.uha.mips.sintaks.stsgen.impl.StsGenFeatureImpl#isProtected <em>Protected</em>}</li>
 *   <li>{@link fr.uha.mips.sintaks.stsgen.impl.StsGenFeatureImpl#isShared <em>Shared</em>}</li>
 *   <li>{@link fr.uha.mips.sintaks.stsgen.impl.StsGenFeatureImpl#isMany <em>Many</em>}</li>
 *   <li>{@link fr.uha.mips.sintaks.stsgen.impl.StsGenFeatureImpl#getKeyFeature <em>Key Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StsGenFeatureImpl extends EObjectImpl implements StsGenFeature {
	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTargetFeature() <em>Target Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetFeature()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature targetFeature;

	/**
	 * The default value of the '{@link #isNotUsed() <em>Not Used</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNotUsed()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NOT_USED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isNotUsed() <em>Not Used</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNotUsed()
	 * @generated
	 * @ordered
	 */
	protected boolean notUsed = NOT_USED_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final Type TYPE_EDEFAULT = Type.ID;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected Type type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #isProtected() <em>Protected</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isProtected()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PROTECTED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isProtected() <em>Protected</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isProtected()
	 * @generated
	 * @ordered
	 */
	protected boolean protected_ = PROTECTED_EDEFAULT;

	/**
	 * The default value of the '{@link #isShared() <em>Shared</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isShared()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SHARED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isShared() <em>Shared</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isShared()
	 * @generated
	 * @ordered
	 */
	protected boolean shared = SHARED_EDEFAULT;

	/**
	 * The default value of the '{@link #isMany() <em>Many</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMany()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MANY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #getKeyFeature() <em>Key Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeyFeature()
	 * @generated
	 * @ordered
	 */
	protected StsGenFeature keyFeature;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StsGenFeatureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StsgenPackage.Literals.STS_GEN_FEATURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	public String getDescription() {
		StringBuffer tmp = new StringBuffer ();
		EStructuralFeature f = this.getTargetFeature();
		if (f == null) return "";
		EPackage p = f.getEContainingClass().getEPackage();
		while (p != null) {
			tmp.append(p.getName());
			tmp.append(".");
			p=p.getESuperPackage();
		}
		tmp.append(f.getEContainingClass().getName());
		tmp.append(".");
		tmp.append(f.getName());
		if (this.isNotUsed()) {
			tmp.append(" ---");
		} else {
			tmp.append(" ");
			tmp.append(getType().getLiteral());
			if (this.isProtected()) {
				tmp.append(" protected");
			}
		}
		return tmp.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EStructuralFeature getTargetFeature() {
		if (targetFeature != null && targetFeature.eIsProxy()) {
			InternalEObject oldTargetFeature = (InternalEObject)targetFeature;
			targetFeature = (EStructuralFeature)eResolveProxy(oldTargetFeature);
			if (targetFeature != oldTargetFeature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StsgenPackage.STS_GEN_FEATURE__TARGET_FEATURE, oldTargetFeature, targetFeature));
			}
		}
		return targetFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EStructuralFeature basicGetTargetFeature() {
		return targetFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetFeature(EStructuralFeature newTargetFeature) {
		EStructuralFeature oldTargetFeature = targetFeature;
		targetFeature = newTargetFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StsgenPackage.STS_GEN_FEATURE__TARGET_FEATURE, oldTargetFeature, targetFeature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isProtected() {
		return protected_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProtected(boolean newProtected) {
		boolean oldProtected = protected_;
		protected_ = newProtected;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StsgenPackage.STS_GEN_FEATURE__PROTECTED, oldProtected, protected_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNotUsed() {
		return notUsed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNotUsed(boolean newNotUsed) {
		boolean oldNotUsed = notUsed;
		notUsed = newNotUsed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StsgenPackage.STS_GEN_FEATURE__NOT_USED, oldNotUsed, notUsed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(Type newType) {
		Type oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StsgenPackage.STS_GEN_FEATURE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isShared() {
		return shared;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShared(boolean newShared) {
		boolean oldShared = shared;
		shared = newShared;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StsgenPackage.STS_GEN_FEATURE__SHARED, oldShared, shared));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	public boolean isMany() {
		EStructuralFeature feature = getTargetFeature ();
		if (feature == null) return false;
		return feature.isMany();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StsGenFeature getKeyFeature() {
		if (keyFeature != null && keyFeature.eIsProxy()) {
			InternalEObject oldKeyFeature = (InternalEObject)keyFeature;
			keyFeature = (StsGenFeature)eResolveProxy(oldKeyFeature);
			if (keyFeature != oldKeyFeature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StsgenPackage.STS_GEN_FEATURE__KEY_FEATURE, oldKeyFeature, keyFeature));
			}
		}
		return keyFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StsGenFeature basicGetKeyFeature() {
		return keyFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKeyFeature(StsGenFeature newKeyFeature) {
		StsGenFeature oldKeyFeature = keyFeature;
		keyFeature = newKeyFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StsgenPackage.STS_GEN_FEATURE__KEY_FEATURE, oldKeyFeature, keyFeature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StsgenPackage.STS_GEN_FEATURE__DESCRIPTION:
				return getDescription();
			case StsgenPackage.STS_GEN_FEATURE__TARGET_FEATURE:
				if (resolve) return getTargetFeature();
				return basicGetTargetFeature();
			case StsgenPackage.STS_GEN_FEATURE__NOT_USED:
				return isNotUsed() ? Boolean.TRUE : Boolean.FALSE;
			case StsgenPackage.STS_GEN_FEATURE__TYPE:
				return getType();
			case StsgenPackage.STS_GEN_FEATURE__PROTECTED:
				return isProtected() ? Boolean.TRUE : Boolean.FALSE;
			case StsgenPackage.STS_GEN_FEATURE__SHARED:
				return isShared() ? Boolean.TRUE : Boolean.FALSE;
			case StsgenPackage.STS_GEN_FEATURE__MANY:
				return isMany() ? Boolean.TRUE : Boolean.FALSE;
			case StsgenPackage.STS_GEN_FEATURE__KEY_FEATURE:
				if (resolve) return getKeyFeature();
				return basicGetKeyFeature();
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
			case StsgenPackage.STS_GEN_FEATURE__TARGET_FEATURE:
				setTargetFeature((EStructuralFeature)newValue);
				return;
			case StsgenPackage.STS_GEN_FEATURE__NOT_USED:
				setNotUsed(((Boolean)newValue).booleanValue());
				return;
			case StsgenPackage.STS_GEN_FEATURE__TYPE:
				setType((Type)newValue);
				return;
			case StsgenPackage.STS_GEN_FEATURE__PROTECTED:
				setProtected(((Boolean)newValue).booleanValue());
				return;
			case StsgenPackage.STS_GEN_FEATURE__SHARED:
				setShared(((Boolean)newValue).booleanValue());
				return;
			case StsgenPackage.STS_GEN_FEATURE__KEY_FEATURE:
				setKeyFeature((StsGenFeature)newValue);
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
			case StsgenPackage.STS_GEN_FEATURE__TARGET_FEATURE:
				setTargetFeature((EStructuralFeature)null);
				return;
			case StsgenPackage.STS_GEN_FEATURE__NOT_USED:
				setNotUsed(NOT_USED_EDEFAULT);
				return;
			case StsgenPackage.STS_GEN_FEATURE__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case StsgenPackage.STS_GEN_FEATURE__PROTECTED:
				setProtected(PROTECTED_EDEFAULT);
				return;
			case StsgenPackage.STS_GEN_FEATURE__SHARED:
				setShared(SHARED_EDEFAULT);
				return;
			case StsgenPackage.STS_GEN_FEATURE__KEY_FEATURE:
				setKeyFeature((StsGenFeature)null);
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
			case StsgenPackage.STS_GEN_FEATURE__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? getDescription() != null : !DESCRIPTION_EDEFAULT.equals(getDescription());
			case StsgenPackage.STS_GEN_FEATURE__TARGET_FEATURE:
				return targetFeature != null;
			case StsgenPackage.STS_GEN_FEATURE__NOT_USED:
				return notUsed != NOT_USED_EDEFAULT;
			case StsgenPackage.STS_GEN_FEATURE__TYPE:
				return type != TYPE_EDEFAULT;
			case StsgenPackage.STS_GEN_FEATURE__PROTECTED:
				return protected_ != PROTECTED_EDEFAULT;
			case StsgenPackage.STS_GEN_FEATURE__SHARED:
				return shared != SHARED_EDEFAULT;
			case StsgenPackage.STS_GEN_FEATURE__MANY:
				return isMany() != MANY_EDEFAULT;
			case StsgenPackage.STS_GEN_FEATURE__KEY_FEATURE:
				return keyFeature != null;
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
		result.append(" (notUsed: ");
		result.append(notUsed);
		result.append(", type: ");
		result.append(type);
		result.append(", protected: ");
		result.append(protected_);
		result.append(", shared: ");
		result.append(shared);
		result.append(')');
		return result.toString();
	}

} //StsGenFeatureImpl
