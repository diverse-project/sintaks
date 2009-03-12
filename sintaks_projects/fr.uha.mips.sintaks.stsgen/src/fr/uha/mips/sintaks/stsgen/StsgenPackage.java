/**
 * <copyright>
 * </copyright>
 *
 * $Id: StsgenPackage.java,v 1.2 2009-03-12 07:57:15 hassen Exp $
 */
package fr.uha.mips.sintaks.stsgen;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see fr.uha.mips.sintaks.stsgen.StsgenFactory
 * @model kind="package"
 * @generated
 */
public interface StsgenPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "stsgen";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.kermeta.org/SintaksGenModel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "stsgen";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StsgenPackage eINSTANCE = fr.uha.mips.sintaks.stsgen.impl.StsgenPackageImpl.init();

	/**
	 * The meta object id for the '{@link fr.uha.mips.sintaks.stsgen.impl.StsGenRootImpl <em>Sts Gen Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.uha.mips.sintaks.stsgen.impl.StsGenRootImpl
	 * @see fr.uha.mips.sintaks.stsgen.impl.StsgenPackageImpl#getStsGenRoot()
	 * @generated
	 */
	int STS_GEN_ROOT = 0;

	/**
	 * The feature id for the '<em><b>Gen Classes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STS_GEN_ROOT__GEN_CLASSES = 0;

	/**
	 * The feature id for the '<em><b>Start Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STS_GEN_ROOT__START_CLASS = 1;

	/**
	 * The feature id for the '<em><b>Root Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STS_GEN_ROOT__ROOT_PACKAGE = 2;

	/**
	 * The number of structural features of the '<em>Sts Gen Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STS_GEN_ROOT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link fr.uha.mips.sintaks.stsgen.impl.StsGenClassImpl <em>Sts Gen Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.uha.mips.sintaks.stsgen.impl.StsGenClassImpl
	 * @see fr.uha.mips.sintaks.stsgen.impl.StsgenPackageImpl#getStsGenClass()
	 * @generated
	 */
	int STS_GEN_CLASS = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STS_GEN_CLASS__DESCRIPTION = 0;

	/**
	 * The feature id for the '<em><b>Not Used</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STS_GEN_CLASS__NOT_USED = 1;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STS_GEN_CLASS__ABSTRACT = 2;

	/**
	 * The feature id for the '<em><b>Target Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STS_GEN_CLASS__TARGET_CLASS = 3;

	/**
	 * The feature id for the '<em><b>Gen Features</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STS_GEN_CLASS__GEN_FEATURES = 4;

	/**
	 * The feature id for the '<em><b>Gen Sub Classes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STS_GEN_CLASS__GEN_SUB_CLASSES = 5;

	/**
	 * The number of structural features of the '<em>Sts Gen Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STS_GEN_CLASS_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link fr.uha.mips.sintaks.stsgen.impl.StsGenFeatureImpl <em>Sts Gen Feature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.uha.mips.sintaks.stsgen.impl.StsGenFeatureImpl
	 * @see fr.uha.mips.sintaks.stsgen.impl.StsgenPackageImpl#getStsGenFeature()
	 * @generated
	 */
	int STS_GEN_FEATURE = 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STS_GEN_FEATURE__DESCRIPTION = 0;

	/**
	 * The feature id for the '<em><b>Target Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STS_GEN_FEATURE__TARGET_FEATURE = 1;

	/**
	 * The feature id for the '<em><b>Not Used</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STS_GEN_FEATURE__NOT_USED = 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STS_GEN_FEATURE__TYPE = 3;

	/**
	 * The feature id for the '<em><b>Protected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STS_GEN_FEATURE__PROTECTED = 4;

	/**
	 * The feature id for the '<em><b>Shared</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STS_GEN_FEATURE__SHARED = 5;

	/**
	 * The feature id for the '<em><b>Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STS_GEN_FEATURE__MANY = 6;

	/**
	 * The feature id for the '<em><b>Key Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STS_GEN_FEATURE__KEY_FEATURE = 7;

	/**
	 * The number of structural features of the '<em>Sts Gen Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STS_GEN_FEATURE_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the '{@link fr.uha.mips.sintaks.stsgen.Type <em>Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.uha.mips.sintaks.stsgen.Type
	 * @see fr.uha.mips.sintaks.stsgen.impl.StsgenPackageImpl#getType()
	 * @generated
	 */
	int TYPE = 3;


	/**
	 * Returns the meta object for class '{@link fr.uha.mips.sintaks.stsgen.StsGenRoot <em>Sts Gen Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sts Gen Root</em>'.
	 * @see fr.uha.mips.sintaks.stsgen.StsGenRoot
	 * @generated
	 */
	EClass getStsGenRoot();

	/**
	 * Returns the meta object for the containment reference list '{@link fr.uha.mips.sintaks.stsgen.StsGenRoot#getGenClasses <em>Gen Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Gen Classes</em>'.
	 * @see fr.uha.mips.sintaks.stsgen.StsGenRoot#getGenClasses()
	 * @see #getStsGenRoot()
	 * @generated
	 */
	EReference getStsGenRoot_GenClasses();

	/**
	 * Returns the meta object for the reference '{@link fr.uha.mips.sintaks.stsgen.StsGenRoot#getStartClass <em>Start Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Start Class</em>'.
	 * @see fr.uha.mips.sintaks.stsgen.StsGenRoot#getStartClass()
	 * @see #getStsGenRoot()
	 * @generated
	 */
	EReference getStsGenRoot_StartClass();

	/**
	 * Returns the meta object for the reference '{@link fr.uha.mips.sintaks.stsgen.StsGenRoot#getRootPackage <em>Root Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Root Package</em>'.
	 * @see fr.uha.mips.sintaks.stsgen.StsGenRoot#getRootPackage()
	 * @see #getStsGenRoot()
	 * @generated
	 */
	EReference getStsGenRoot_RootPackage();

	/**
	 * Returns the meta object for class '{@link fr.uha.mips.sintaks.stsgen.StsGenClass <em>Sts Gen Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sts Gen Class</em>'.
	 * @see fr.uha.mips.sintaks.stsgen.StsGenClass
	 * @generated
	 */
	EClass getStsGenClass();

	/**
	 * Returns the meta object for the attribute '{@link fr.uha.mips.sintaks.stsgen.StsGenClass#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see fr.uha.mips.sintaks.stsgen.StsGenClass#getDescription()
	 * @see #getStsGenClass()
	 * @generated
	 */
	EAttribute getStsGenClass_Description();

	/**
	 * Returns the meta object for the containment reference list '{@link fr.uha.mips.sintaks.stsgen.StsGenClass#getGenFeatures <em>Gen Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Gen Features</em>'.
	 * @see fr.uha.mips.sintaks.stsgen.StsGenClass#getGenFeatures()
	 * @see #getStsGenClass()
	 * @generated
	 */
	EReference getStsGenClass_GenFeatures();

	/**
	 * Returns the meta object for the reference list '{@link fr.uha.mips.sintaks.stsgen.StsGenClass#getGenSubClasses <em>Gen Sub Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Gen Sub Classes</em>'.
	 * @see fr.uha.mips.sintaks.stsgen.StsGenClass#getGenSubClasses()
	 * @see #getStsGenClass()
	 * @generated
	 */
	EReference getStsGenClass_GenSubClasses();

	/**
	 * Returns the meta object for the attribute '{@link fr.uha.mips.sintaks.stsgen.StsGenClass#isNotUsed <em>Not Used</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Not Used</em>'.
	 * @see fr.uha.mips.sintaks.stsgen.StsGenClass#isNotUsed()
	 * @see #getStsGenClass()
	 * @generated
	 */
	EAttribute getStsGenClass_NotUsed();

	/**
	 * Returns the meta object for the attribute '{@link fr.uha.mips.sintaks.stsgen.StsGenClass#isAbstract <em>Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Abstract</em>'.
	 * @see fr.uha.mips.sintaks.stsgen.StsGenClass#isAbstract()
	 * @see #getStsGenClass()
	 * @generated
	 */
	EAttribute getStsGenClass_Abstract();

	/**
	 * Returns the meta object for the reference '{@link fr.uha.mips.sintaks.stsgen.StsGenClass#getTargetClass <em>Target Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Class</em>'.
	 * @see fr.uha.mips.sintaks.stsgen.StsGenClass#getTargetClass()
	 * @see #getStsGenClass()
	 * @generated
	 */
	EReference getStsGenClass_TargetClass();

	/**
	 * Returns the meta object for class '{@link fr.uha.mips.sintaks.stsgen.StsGenFeature <em>Sts Gen Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sts Gen Feature</em>'.
	 * @see fr.uha.mips.sintaks.stsgen.StsGenFeature
	 * @generated
	 */
	EClass getStsGenFeature();

	/**
	 * Returns the meta object for the attribute '{@link fr.uha.mips.sintaks.stsgen.StsGenFeature#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see fr.uha.mips.sintaks.stsgen.StsGenFeature#getDescription()
	 * @see #getStsGenFeature()
	 * @generated
	 */
	EAttribute getStsGenFeature_Description();

	/**
	 * Returns the meta object for the reference '{@link fr.uha.mips.sintaks.stsgen.StsGenFeature#getTargetFeature <em>Target Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Feature</em>'.
	 * @see fr.uha.mips.sintaks.stsgen.StsGenFeature#getTargetFeature()
	 * @see #getStsGenFeature()
	 * @generated
	 */
	EReference getStsGenFeature_TargetFeature();

	/**
	 * Returns the meta object for the attribute '{@link fr.uha.mips.sintaks.stsgen.StsGenFeature#isProtected <em>Protected</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Protected</em>'.
	 * @see fr.uha.mips.sintaks.stsgen.StsGenFeature#isProtected()
	 * @see #getStsGenFeature()
	 * @generated
	 */
	EAttribute getStsGenFeature_Protected();

	/**
	 * Returns the meta object for the attribute '{@link fr.uha.mips.sintaks.stsgen.StsGenFeature#isNotUsed <em>Not Used</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Not Used</em>'.
	 * @see fr.uha.mips.sintaks.stsgen.StsGenFeature#isNotUsed()
	 * @see #getStsGenFeature()
	 * @generated
	 */
	EAttribute getStsGenFeature_NotUsed();

	/**
	 * Returns the meta object for the attribute '{@link fr.uha.mips.sintaks.stsgen.StsGenFeature#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see fr.uha.mips.sintaks.stsgen.StsGenFeature#getType()
	 * @see #getStsGenFeature()
	 * @generated
	 */
	EAttribute getStsGenFeature_Type();

	/**
	 * Returns the meta object for the attribute '{@link fr.uha.mips.sintaks.stsgen.StsGenFeature#isShared <em>Shared</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Shared</em>'.
	 * @see fr.uha.mips.sintaks.stsgen.StsGenFeature#isShared()
	 * @see #getStsGenFeature()
	 * @generated
	 */
	EAttribute getStsGenFeature_Shared();

	/**
	 * Returns the meta object for the attribute '{@link fr.uha.mips.sintaks.stsgen.StsGenFeature#isMany <em>Many</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Many</em>'.
	 * @see fr.uha.mips.sintaks.stsgen.StsGenFeature#isMany()
	 * @see #getStsGenFeature()
	 * @generated
	 */
	EAttribute getStsGenFeature_Many();

	/**
	 * Returns the meta object for the reference '{@link fr.uha.mips.sintaks.stsgen.StsGenFeature#getKeyFeature <em>Key Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Key Feature</em>'.
	 * @see fr.uha.mips.sintaks.stsgen.StsGenFeature#getKeyFeature()
	 * @see #getStsGenFeature()
	 * @generated
	 */
	EReference getStsGenFeature_KeyFeature();

	/**
	 * Returns the meta object for enum '{@link fr.uha.mips.sintaks.stsgen.Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Type</em>'.
	 * @see fr.uha.mips.sintaks.stsgen.Type
	 * @generated
	 */
	EEnum getType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	StsgenFactory getStsgenFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link fr.uha.mips.sintaks.stsgen.impl.StsGenRootImpl <em>Sts Gen Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.uha.mips.sintaks.stsgen.impl.StsGenRootImpl
		 * @see fr.uha.mips.sintaks.stsgen.impl.StsgenPackageImpl#getStsGenRoot()
		 * @generated
		 */
		EClass STS_GEN_ROOT = eINSTANCE.getStsGenRoot();

		/**
		 * The meta object literal for the '<em><b>Gen Classes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STS_GEN_ROOT__GEN_CLASSES = eINSTANCE.getStsGenRoot_GenClasses();

		/**
		 * The meta object literal for the '<em><b>Start Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STS_GEN_ROOT__START_CLASS = eINSTANCE.getStsGenRoot_StartClass();

		/**
		 * The meta object literal for the '<em><b>Root Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STS_GEN_ROOT__ROOT_PACKAGE = eINSTANCE.getStsGenRoot_RootPackage();

		/**
		 * The meta object literal for the '{@link fr.uha.mips.sintaks.stsgen.impl.StsGenClassImpl <em>Sts Gen Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.uha.mips.sintaks.stsgen.impl.StsGenClassImpl
		 * @see fr.uha.mips.sintaks.stsgen.impl.StsgenPackageImpl#getStsGenClass()
		 * @generated
		 */
		EClass STS_GEN_CLASS = eINSTANCE.getStsGenClass();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STS_GEN_CLASS__DESCRIPTION = eINSTANCE.getStsGenClass_Description();

		/**
		 * The meta object literal for the '<em><b>Gen Features</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STS_GEN_CLASS__GEN_FEATURES = eINSTANCE.getStsGenClass_GenFeatures();

		/**
		 * The meta object literal for the '<em><b>Gen Sub Classes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STS_GEN_CLASS__GEN_SUB_CLASSES = eINSTANCE.getStsGenClass_GenSubClasses();

		/**
		 * The meta object literal for the '<em><b>Not Used</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STS_GEN_CLASS__NOT_USED = eINSTANCE.getStsGenClass_NotUsed();

		/**
		 * The meta object literal for the '<em><b>Abstract</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STS_GEN_CLASS__ABSTRACT = eINSTANCE.getStsGenClass_Abstract();

		/**
		 * The meta object literal for the '<em><b>Target Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STS_GEN_CLASS__TARGET_CLASS = eINSTANCE.getStsGenClass_TargetClass();

		/**
		 * The meta object literal for the '{@link fr.uha.mips.sintaks.stsgen.impl.StsGenFeatureImpl <em>Sts Gen Feature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.uha.mips.sintaks.stsgen.impl.StsGenFeatureImpl
		 * @see fr.uha.mips.sintaks.stsgen.impl.StsgenPackageImpl#getStsGenFeature()
		 * @generated
		 */
		EClass STS_GEN_FEATURE = eINSTANCE.getStsGenFeature();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STS_GEN_FEATURE__DESCRIPTION = eINSTANCE.getStsGenFeature_Description();

		/**
		 * The meta object literal for the '<em><b>Target Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STS_GEN_FEATURE__TARGET_FEATURE = eINSTANCE.getStsGenFeature_TargetFeature();

		/**
		 * The meta object literal for the '<em><b>Protected</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STS_GEN_FEATURE__PROTECTED = eINSTANCE.getStsGenFeature_Protected();

		/**
		 * The meta object literal for the '<em><b>Not Used</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STS_GEN_FEATURE__NOT_USED = eINSTANCE.getStsGenFeature_NotUsed();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STS_GEN_FEATURE__TYPE = eINSTANCE.getStsGenFeature_Type();

		/**
		 * The meta object literal for the '<em><b>Shared</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STS_GEN_FEATURE__SHARED = eINSTANCE.getStsGenFeature_Shared();

		/**
		 * The meta object literal for the '<em><b>Many</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STS_GEN_FEATURE__MANY = eINSTANCE.getStsGenFeature_Many();

		/**
		 * The meta object literal for the '<em><b>Key Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STS_GEN_FEATURE__KEY_FEATURE = eINSTANCE.getStsGenFeature_KeyFeature();

		/**
		 * The meta object literal for the '{@link fr.uha.mips.sintaks.stsgen.Type <em>Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.uha.mips.sintaks.stsgen.Type
		 * @see fr.uha.mips.sintaks.stsgen.impl.StsgenPackageImpl#getType()
		 * @generated
		 */
		EEnum TYPE = eINSTANCE.getType();

	}

} //StsgenPackage
