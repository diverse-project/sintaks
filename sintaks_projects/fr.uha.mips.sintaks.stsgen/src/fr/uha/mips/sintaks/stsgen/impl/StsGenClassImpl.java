/**
 * <copyright>
 * </copyright>
 *
 * $Id: StsGenClassImpl.java,v 1.2 2009-03-12 07:57:15 hassen Exp $
 */
package fr.uha.mips.sintaks.stsgen.impl;

import fr.uha.mips.sintaks.stsgen.StsGenClass;
import fr.uha.mips.sintaks.stsgen.StsGenFeature;
import fr.uha.mips.sintaks.stsgen.StsgenPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sts Gen Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.uha.mips.sintaks.stsgen.impl.StsGenClassImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link fr.uha.mips.sintaks.stsgen.impl.StsGenClassImpl#isNotUsed <em>Not Used</em>}</li>
 *   <li>{@link fr.uha.mips.sintaks.stsgen.impl.StsGenClassImpl#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link fr.uha.mips.sintaks.stsgen.impl.StsGenClassImpl#getTargetClass <em>Target Class</em>}</li>
 *   <li>{@link fr.uha.mips.sintaks.stsgen.impl.StsGenClassImpl#getGenFeatures <em>Gen Features</em>}</li>
 *   <li>{@link fr.uha.mips.sintaks.stsgen.impl.StsGenClassImpl#getGenSubClasses <em>Gen Sub Classes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StsGenClassImpl extends EObjectImpl implements StsGenClass {
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
	 * The default value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAbstract()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ABSTRACT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #getTargetClass() <em>Target Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetClass()
	 * @generated
	 * @ordered
	 */
	protected EClass targetClass;

	/**
	 * The cached value of the '{@link #getGenFeatures() <em>Gen Features</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<StsGenFeature> genFeatures;

	/**
	 * The cached value of the '{@link #getGenSubClasses() <em>Gen Sub Classes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenSubClasses()
	 * @generated
	 * @ordered
	 */
	protected EList<StsGenClass> genSubClasses;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StsGenClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StsgenPackage.Literals.STS_GEN_CLASS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	public String getDescription() {
		StringBuffer tmp = new StringBuffer ();
		EClass c = this.getTargetClass();
		if (c == null) return "";
		EPackage p = c.getEPackage();
		while (p != null) {
			tmp.append(p.getName());
			tmp.append(".");
			p=p.getESuperPackage();
		}
		tmp.append(c.getName());
		if (this.isNotUsed()) {
			tmp.append(" ---");
		}
		return tmp.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StsGenFeature> getGenFeatures() {
		if (genFeatures == null) {
			genFeatures = new EObjectContainmentEList<StsGenFeature>(StsGenFeature.class, this, StsgenPackage.STS_GEN_CLASS__GEN_FEATURES);
		}
		return genFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StsGenClass> getGenSubClasses() {
		if (genSubClasses == null) {
			genSubClasses = new EObjectResolvingEList<StsGenClass>(StsGenClass.class, this, StsgenPackage.STS_GEN_CLASS__GEN_SUB_CLASSES);
		}
		return genSubClasses;
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
			eNotify(new ENotificationImpl(this, Notification.SET, StsgenPackage.STS_GEN_CLASS__NOT_USED, oldNotUsed, notUsed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	public boolean isAbstract() {
		EClass c = getTargetClass();
		if (c == null) return false;
		return c.isAbstract();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTargetClass() {
		if (targetClass != null && targetClass.eIsProxy()) {
			InternalEObject oldTargetClass = (InternalEObject)targetClass;
			targetClass = (EClass)eResolveProxy(oldTargetClass);
			if (targetClass != oldTargetClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StsgenPackage.STS_GEN_CLASS__TARGET_CLASS, oldTargetClass, targetClass));
			}
		}
		return targetClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass basicGetTargetClass() {
		return targetClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetClass(EClass newTargetClass) {
		EClass oldTargetClass = targetClass;
		targetClass = newTargetClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StsgenPackage.STS_GEN_CLASS__TARGET_CLASS, oldTargetClass, targetClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StsgenPackage.STS_GEN_CLASS__GEN_FEATURES:
				return ((InternalEList<?>)getGenFeatures()).basicRemove(otherEnd, msgs);
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
			case StsgenPackage.STS_GEN_CLASS__DESCRIPTION:
				return getDescription();
			case StsgenPackage.STS_GEN_CLASS__NOT_USED:
				return isNotUsed() ? Boolean.TRUE : Boolean.FALSE;
			case StsgenPackage.STS_GEN_CLASS__ABSTRACT:
				return isAbstract() ? Boolean.TRUE : Boolean.FALSE;
			case StsgenPackage.STS_GEN_CLASS__TARGET_CLASS:
				if (resolve) return getTargetClass();
				return basicGetTargetClass();
			case StsgenPackage.STS_GEN_CLASS__GEN_FEATURES:
				return getGenFeatures();
			case StsgenPackage.STS_GEN_CLASS__GEN_SUB_CLASSES:
				return getGenSubClasses();
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
			case StsgenPackage.STS_GEN_CLASS__NOT_USED:
				setNotUsed(((Boolean)newValue).booleanValue());
				return;
			case StsgenPackage.STS_GEN_CLASS__TARGET_CLASS:
				setTargetClass((EClass)newValue);
				return;
			case StsgenPackage.STS_GEN_CLASS__GEN_FEATURES:
				getGenFeatures().clear();
				getGenFeatures().addAll((Collection<? extends StsGenFeature>)newValue);
				return;
			case StsgenPackage.STS_GEN_CLASS__GEN_SUB_CLASSES:
				getGenSubClasses().clear();
				getGenSubClasses().addAll((Collection<? extends StsGenClass>)newValue);
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
			case StsgenPackage.STS_GEN_CLASS__NOT_USED:
				setNotUsed(NOT_USED_EDEFAULT);
				return;
			case StsgenPackage.STS_GEN_CLASS__TARGET_CLASS:
				setTargetClass((EClass)null);
				return;
			case StsgenPackage.STS_GEN_CLASS__GEN_FEATURES:
				getGenFeatures().clear();
				return;
			case StsgenPackage.STS_GEN_CLASS__GEN_SUB_CLASSES:
				getGenSubClasses().clear();
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
			case StsgenPackage.STS_GEN_CLASS__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? getDescription() != null : !DESCRIPTION_EDEFAULT.equals(getDescription());
			case StsgenPackage.STS_GEN_CLASS__NOT_USED:
				return notUsed != NOT_USED_EDEFAULT;
			case StsgenPackage.STS_GEN_CLASS__ABSTRACT:
				return isAbstract() != ABSTRACT_EDEFAULT;
			case StsgenPackage.STS_GEN_CLASS__TARGET_CLASS:
				return targetClass != null;
			case StsgenPackage.STS_GEN_CLASS__GEN_FEATURES:
				return genFeatures != null && !genFeatures.isEmpty();
			case StsgenPackage.STS_GEN_CLASS__GEN_SUB_CLASSES:
				return genSubClasses != null && !genSubClasses.isEmpty();
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
		result.append(')');
		return result.toString();
	}

} //StsGenClassImpl
