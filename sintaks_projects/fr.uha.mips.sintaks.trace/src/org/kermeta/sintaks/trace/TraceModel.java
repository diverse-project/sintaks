/**
 * <copyright>
 * </copyright>
 *
 * $Id: TraceModel.java,v 1.1 2008-07-21 13:10:32 hassen Exp $
 */
package org.kermeta.sintaks.trace;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Trace Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.kermeta.sintaks.trace.TraceModel#getTrace <em>Trace</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.kermeta.sintaks.trace.TracePackage#getTraceModel()
 * @model
 * @generated
 */
public interface TraceModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Trace</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trace</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trace</em>' containment reference.
	 * @see #setTrace(Trace)
	 * @see org.kermeta.sintaks.trace.TracePackage#getTraceModel_Trace()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	Trace getTrace();

	/**
	 * Sets the value of the '{@link org.kermeta.sintaks.trace.TraceModel#getTrace <em>Trace</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trace</em>' containment reference.
	 * @see #getTrace()
	 * @generated
	 */
	void setTrace(Trace value);

} // TraceModel
