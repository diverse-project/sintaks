/**
 * <copyright>
 * </copyright>
 *
 * $Id: ReferenceImpl.java,v 1.1 2008-07-21 13:10:31 hassen Exp $
 */
package org.kermeta.sintaks.trace.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.kermeta.sintaks.trace.Reference;
import org.kermeta.sintaks.trace.TracePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class ReferenceImpl extends EObjectImpl implements Reference {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TracePackage.Literals.REFERENCE;
	}

} //ReferenceImpl
