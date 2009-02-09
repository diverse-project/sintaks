/**
 * <copyright>
 * </copyright>
 *
 * $Id: StsgenAdapterFactory.java,v 1.1 2009-02-09 13:26:37 hassen Exp $
 */
package fr.uha.mips.sintaks.stsgen.util;

import fr.uha.mips.sintaks.stsgen.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see fr.uha.mips.sintaks.stsgen.StsgenPackage
 * @generated
 */
public class StsgenAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static StsgenPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StsgenAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = StsgenPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch the delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StsgenSwitch<Adapter> modelSwitch =
		new StsgenSwitch<Adapter>() {
			@Override
			public Adapter caseStsGenRoot(StsGenRoot object) {
				return createStsGenRootAdapter();
			}
			@Override
			public Adapter caseStsGenClass(StsGenClass object) {
				return createStsGenClassAdapter();
			}
			@Override
			public Adapter caseStsGenFeature(StsGenFeature object) {
				return createStsGenFeatureAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link fr.uha.mips.sintaks.stsgen.StsGenRoot <em>Sts Gen Root</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.uha.mips.sintaks.stsgen.StsGenRoot
	 * @generated
	 */
	public Adapter createStsGenRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.uha.mips.sintaks.stsgen.StsGenClass <em>Sts Gen Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.uha.mips.sintaks.stsgen.StsGenClass
	 * @generated
	 */
	public Adapter createStsGenClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.uha.mips.sintaks.stsgen.StsGenFeature <em>Sts Gen Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.uha.mips.sintaks.stsgen.StsGenFeature
	 * @generated
	 */
	public Adapter createStsGenFeatureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //StsgenAdapterFactory
