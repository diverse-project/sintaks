/**
 * <copyright>
 * </copyright>
 *
 * $Id: StsGenRootImpl.java,v 1.1 2009-02-09 13:26:37 hassen Exp $
 */
package fr.uha.mips.sintaks.stsgen.impl;

import fr.uha.mips.sintaks.stsgen.StsGenClass;
import fr.uha.mips.sintaks.stsgen.StsGenRoot;
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
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sts Gen Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.uha.mips.sintaks.stsgen.impl.StsGenRootImpl#getGenClasses <em>Gen Classes</em>}</li>
 *   <li>{@link fr.uha.mips.sintaks.stsgen.impl.StsGenRootImpl#getStartClass <em>Start Class</em>}</li>
 *   <li>{@link fr.uha.mips.sintaks.stsgen.impl.StsGenRootImpl#getRootPackage <em>Root Package</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StsGenRootImpl extends EObjectImpl implements StsGenRoot {
	/**
	 * The cached value of the '{@link #getGenClasses() <em>Gen Classes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenClasses()
	 * @generated
	 * @ordered
	 */
	protected EList<StsGenClass> genClasses;

	/**
	 * The cached value of the '{@link #getStartClass() <em>Start Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartClass()
	 * @generated
	 * @ordered
	 */
	protected EClass startClass;

	/**
	 * The cached value of the '{@link #getRootPackage() <em>Root Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRootPackage()
	 * @generated
	 * @ordered
	 */
	protected EPackage rootPackage;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StsGenRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StsgenPackage.Literals.STS_GEN_ROOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StsGenClass> getGenClasses() {
		if (genClasses == null) {
			genClasses = new EObjectContainmentEList<StsGenClass>(StsGenClass.class, this, StsgenPackage.STS_GEN_ROOT__GEN_CLASSES);
		}
		return genClasses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStartClass() {
		if (startClass != null && startClass.eIsProxy()) {
			InternalEObject oldStartClass = (InternalEObject)startClass;
			startClass = (EClass)eResolveProxy(oldStartClass);
			if (startClass != oldStartClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StsgenPackage.STS_GEN_ROOT__START_CLASS, oldStartClass, startClass));
			}
		}
		return startClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass basicGetStartClass() {
		return startClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartClass(EClass newStartClass) {
		EClass oldStartClass = startClass;
		startClass = newStartClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StsgenPackage.STS_GEN_ROOT__START_CLASS, oldStartClass, startClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPackage getRootPackage() {
		if (rootPackage != null && rootPackage.eIsProxy()) {
			InternalEObject oldRootPackage = (InternalEObject)rootPackage;
			rootPackage = (EPackage)eResolveProxy(oldRootPackage);
			if (rootPackage != oldRootPackage) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StsgenPackage.STS_GEN_ROOT__ROOT_PACKAGE, oldRootPackage, rootPackage));
			}
		}
		return rootPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPackage basicGetRootPackage() {
		return rootPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRootPackage(EPackage newRootPackage) {
		EPackage oldRootPackage = rootPackage;
		rootPackage = newRootPackage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StsgenPackage.STS_GEN_ROOT__ROOT_PACKAGE, oldRootPackage, rootPackage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StsgenPackage.STS_GEN_ROOT__GEN_CLASSES:
				return ((InternalEList<?>)getGenClasses()).basicRemove(otherEnd, msgs);
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
			case StsgenPackage.STS_GEN_ROOT__GEN_CLASSES:
				return getGenClasses();
			case StsgenPackage.STS_GEN_ROOT__START_CLASS:
				if (resolve) return getStartClass();
				return basicGetStartClass();
			case StsgenPackage.STS_GEN_ROOT__ROOT_PACKAGE:
				if (resolve) return getRootPackage();
				return basicGetRootPackage();
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
			case StsgenPackage.STS_GEN_ROOT__GEN_CLASSES:
				getGenClasses().clear();
				getGenClasses().addAll((Collection<? extends StsGenClass>)newValue);
				return;
			case StsgenPackage.STS_GEN_ROOT__START_CLASS:
				setStartClass((EClass)newValue);
				return;
			case StsgenPackage.STS_GEN_ROOT__ROOT_PACKAGE:
				setRootPackage((EPackage)newValue);
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
			case StsgenPackage.STS_GEN_ROOT__GEN_CLASSES:
				getGenClasses().clear();
				return;
			case StsgenPackage.STS_GEN_ROOT__START_CLASS:
				setStartClass((EClass)null);
				return;
			case StsgenPackage.STS_GEN_ROOT__ROOT_PACKAGE:
				setRootPackage((EPackage)null);
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
			case StsgenPackage.STS_GEN_ROOT__GEN_CLASSES:
				return genClasses != null && !genClasses.isEmpty();
			case StsgenPackage.STS_GEN_ROOT__START_CLASS:
				return startClass != null;
			case StsgenPackage.STS_GEN_ROOT__ROOT_PACKAGE:
				return rootPackage != null;
		}
		return super.eIsSet(featureID);
	}

} //StsGenRootImpl
