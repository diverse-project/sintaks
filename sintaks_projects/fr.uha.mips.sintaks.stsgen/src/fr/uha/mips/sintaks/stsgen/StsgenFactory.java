/**
 * <copyright>
 * </copyright>
 *
 * $Id: StsgenFactory.java,v 1.1 2009-02-09 13:26:37 hassen Exp $
 */
package fr.uha.mips.sintaks.stsgen;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see fr.uha.mips.sintaks.stsgen.StsgenPackage
 * @generated
 */
public interface StsgenFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StsgenFactory eINSTANCE = fr.uha.mips.sintaks.stsgen.impl.StsgenFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Sts Gen Root</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sts Gen Root</em>'.
	 * @generated
	 */
	StsGenRoot createStsGenRoot();

	/**
	 * Returns a new object of class '<em>Sts Gen Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sts Gen Class</em>'.
	 * @generated
	 */
	StsGenClass createStsGenClass();

	/**
	 * Returns a new object of class '<em>Sts Gen Feature</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sts Gen Feature</em>'.
	 * @generated
	 */
	StsGenFeature createStsGenFeature();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	StsgenPackage getStsgenPackage();

} //StsgenFactory
