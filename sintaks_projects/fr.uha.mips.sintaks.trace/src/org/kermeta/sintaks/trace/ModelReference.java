/**
 * <copyright>
 * </copyright>
 *
 * $Id: ModelReference.java,v 1.1 2008-07-21 13:10:32 hassen Exp $
 */
package org.kermeta.sintaks.trace;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.kermeta.sintaks.trace.ModelReference#getRefObject <em>Ref Object</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.kermeta.sintaks.trace.TracePackage#getModelReference()
 * @model
 * @generated
 */
public interface ModelReference extends Reference {
	/**
	 * Returns the value of the '<em><b>Ref Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ref Object</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ref Object</em>' reference.
	 * @see #setRefObject(EObject)
	 * @see org.kermeta.sintaks.trace.TracePackage#getModelReference_RefObject()
	 * @model required="true"
	 * @generated
	 */
	EObject getRefObject();

	/**
	 * Sets the value of the '{@link org.kermeta.sintaks.trace.ModelReference#getRefObject <em>Ref Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref Object</em>' reference.
	 * @see #getRefObject()
	 * @generated
	 */
	void setRefObject(EObject value);

} // ModelReference
