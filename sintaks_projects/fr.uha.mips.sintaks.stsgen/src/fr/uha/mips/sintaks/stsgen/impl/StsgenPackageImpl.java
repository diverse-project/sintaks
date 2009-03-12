/**
 * <copyright>
 * </copyright>
 *
 * $Id: StsgenPackageImpl.java,v 1.2 2009-03-12 07:57:15 hassen Exp $
 */
package fr.uha.mips.sintaks.stsgen.impl;

import fr.uha.mips.sintaks.stsgen.StsGenClass;
import fr.uha.mips.sintaks.stsgen.StsGenFeature;
import fr.uha.mips.sintaks.stsgen.StsGenRoot;
import fr.uha.mips.sintaks.stsgen.StsgenFactory;
import fr.uha.mips.sintaks.stsgen.StsgenPackage;

import fr.uha.mips.sintaks.stsgen.Type;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StsgenPackageImpl extends EPackageImpl implements StsgenPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stsGenRootEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stsGenClassEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stsGenFeatureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum typeEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see fr.uha.mips.sintaks.stsgen.StsgenPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private StsgenPackageImpl() {
		super(eNS_URI, StsgenFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static StsgenPackage init() {
		if (isInited) return (StsgenPackage)EPackage.Registry.INSTANCE.getEPackage(StsgenPackage.eNS_URI);

		// Obtain or create and register package
		StsgenPackageImpl theStsgenPackage = (StsgenPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof StsgenPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new StsgenPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theStsgenPackage.createPackageContents();

		// Initialize created meta-data
		theStsgenPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theStsgenPackage.freeze();

		return theStsgenPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStsGenRoot() {
		return stsGenRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStsGenRoot_GenClasses() {
		return (EReference)stsGenRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStsGenRoot_StartClass() {
		return (EReference)stsGenRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStsGenRoot_RootPackage() {
		return (EReference)stsGenRootEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStsGenClass() {
		return stsGenClassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStsGenClass_Description() {
		return (EAttribute)stsGenClassEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStsGenClass_GenFeatures() {
		return (EReference)stsGenClassEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStsGenClass_GenSubClasses() {
		return (EReference)stsGenClassEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStsGenClass_NotUsed() {
		return (EAttribute)stsGenClassEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStsGenClass_Abstract() {
		return (EAttribute)stsGenClassEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStsGenClass_TargetClass() {
		return (EReference)stsGenClassEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStsGenFeature() {
		return stsGenFeatureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStsGenFeature_Description() {
		return (EAttribute)stsGenFeatureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStsGenFeature_TargetFeature() {
		return (EReference)stsGenFeatureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStsGenFeature_Protected() {
		return (EAttribute)stsGenFeatureEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStsGenFeature_NotUsed() {
		return (EAttribute)stsGenFeatureEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStsGenFeature_Type() {
		return (EAttribute)stsGenFeatureEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStsGenFeature_Shared() {
		return (EAttribute)stsGenFeatureEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStsGenFeature_Many() {
		return (EAttribute)stsGenFeatureEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStsGenFeature_KeyFeature() {
		return (EReference)stsGenFeatureEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getType() {
		return typeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StsgenFactory getStsgenFactory() {
		return (StsgenFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		stsGenRootEClass = createEClass(STS_GEN_ROOT);
		createEReference(stsGenRootEClass, STS_GEN_ROOT__GEN_CLASSES);
		createEReference(stsGenRootEClass, STS_GEN_ROOT__START_CLASS);
		createEReference(stsGenRootEClass, STS_GEN_ROOT__ROOT_PACKAGE);

		stsGenClassEClass = createEClass(STS_GEN_CLASS);
		createEAttribute(stsGenClassEClass, STS_GEN_CLASS__DESCRIPTION);
		createEAttribute(stsGenClassEClass, STS_GEN_CLASS__NOT_USED);
		createEAttribute(stsGenClassEClass, STS_GEN_CLASS__ABSTRACT);
		createEReference(stsGenClassEClass, STS_GEN_CLASS__TARGET_CLASS);
		createEReference(stsGenClassEClass, STS_GEN_CLASS__GEN_FEATURES);
		createEReference(stsGenClassEClass, STS_GEN_CLASS__GEN_SUB_CLASSES);

		stsGenFeatureEClass = createEClass(STS_GEN_FEATURE);
		createEAttribute(stsGenFeatureEClass, STS_GEN_FEATURE__DESCRIPTION);
		createEReference(stsGenFeatureEClass, STS_GEN_FEATURE__TARGET_FEATURE);
		createEAttribute(stsGenFeatureEClass, STS_GEN_FEATURE__NOT_USED);
		createEAttribute(stsGenFeatureEClass, STS_GEN_FEATURE__TYPE);
		createEAttribute(stsGenFeatureEClass, STS_GEN_FEATURE__PROTECTED);
		createEAttribute(stsGenFeatureEClass, STS_GEN_FEATURE__SHARED);
		createEAttribute(stsGenFeatureEClass, STS_GEN_FEATURE__MANY);
		createEReference(stsGenFeatureEClass, STS_GEN_FEATURE__KEY_FEATURE);

		// Create enums
		typeEEnum = createEEnum(TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(stsGenRootEClass, StsGenRoot.class, "StsGenRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStsGenRoot_GenClasses(), this.getStsGenClass(), null, "genClasses", null, 0, -1, StsGenRoot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStsGenRoot_StartClass(), this.getStsGenClass(), null, "startClass", null, 0, 1, StsGenRoot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStsGenRoot_RootPackage(), ecorePackage.getEPackage(), null, "rootPackage", null, 0, 1, StsGenRoot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stsGenClassEClass, StsGenClass.class, "StsGenClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStsGenClass_Description(), ecorePackage.getEString(), "description", null, 1, 1, StsGenClass.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getStsGenClass_NotUsed(), ecorePackage.getEBoolean(), "notUsed", null, 0, 1, StsGenClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStsGenClass_Abstract(), ecorePackage.getEBoolean(), "abstract", "false", 0, 1, StsGenClass.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getStsGenClass_TargetClass(), ecorePackage.getEClass(), null, "targetClass", null, 0, 1, StsGenClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStsGenClass_GenFeatures(), this.getStsGenFeature(), null, "genFeatures", null, 0, -1, StsGenClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStsGenClass_GenSubClasses(), this.getStsGenClass(), null, "genSubClasses", null, 0, -1, StsGenClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stsGenFeatureEClass, StsGenFeature.class, "StsGenFeature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStsGenFeature_Description(), ecorePackage.getEString(), "description", null, 1, 1, StsGenFeature.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getStsGenFeature_TargetFeature(), ecorePackage.getEStructuralFeature(), null, "targetFeature", null, 0, 1, StsGenFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStsGenFeature_NotUsed(), ecorePackage.getEBoolean(), "notUsed", null, 0, 1, StsGenFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStsGenFeature_Type(), this.getType(), "type", null, 0, 1, StsGenFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStsGenFeature_Protected(), ecorePackage.getEBoolean(), "protected", null, 0, 1, StsGenFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStsGenFeature_Shared(), ecorePackage.getEBoolean(), "shared", null, 0, 1, StsGenFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStsGenFeature_Many(), ecorePackage.getEBoolean(), "many", "false", 0, 1, StsGenFeature.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getStsGenFeature_KeyFeature(), this.getStsGenFeature(), null, "keyFeature", null, 0, 1, StsGenFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(typeEEnum, Type.class, "Type");
		addEEnumLiteral(typeEEnum, Type.ID);
		addEEnumLiteral(typeEEnum, Type.ATTRIBUTE);
		addEEnumLiteral(typeEEnum, Type.CONTAINER);
		addEEnumLiteral(typeEEnum, Type.REFERENCE);
		addEEnumLiteral(typeEEnum, Type.ADJECTIVE_BEFORE);
		addEEnumLiteral(typeEEnum, Type.ADJECTIVE_AFTER);

		// Create resource
		createResource(eNS_URI);
	}

} //StsgenPackageImpl
