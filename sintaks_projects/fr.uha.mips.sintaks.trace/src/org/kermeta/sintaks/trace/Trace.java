/**
 * <copyright>
 * </copyright>
 *
 * $Id: Trace.java,v 1.1 2008-07-21 13:10:32 hassen Exp $
 */
package org.kermeta.sintaks.trace;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Trace</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.kermeta.sintaks.trace.Trace#getState <em>State</em>}</li>
 *   <li>{@link org.kermeta.sintaks.trace.Trace#getSourceReference <em>Source Reference</em>}</li>
 *   <li>{@link org.kermeta.sintaks.trace.Trace#getTargetReference <em>Target Reference</em>}</li>
 *   <li>{@link org.kermeta.sintaks.trace.Trace#getRuleReference <em>Rule Reference</em>}</li>
 *   <li>{@link org.kermeta.sintaks.trace.Trace#getDescription <em>Description</em>}</li>
 *   <li>{@link org.kermeta.sintaks.trace.Trace#getSubTraces <em>Sub Traces</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.kermeta.sintaks.trace.TracePackage#getTrace()
 * @model
 * @generated
 */
public interface Trace extends EObject {
	/**
	 * Returns the value of the '<em><b>State</b></em>' attribute.
	 * The literals are from the enumeration {@link org.kermeta.sintaks.trace.State}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' attribute.
	 * @see org.kermeta.sintaks.trace.State
	 * @see #setState(State)
	 * @see org.kermeta.sintaks.trace.TracePackage#getTrace_State()
	 * @model
	 * @generated
	 */
	State getState();

	/**
	 * Sets the value of the '{@link org.kermeta.sintaks.trace.Trace#getState <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' attribute.
	 * @see org.kermeta.sintaks.trace.State
	 * @see #getState()
	 * @generated
	 */
	void setState(State value);

	/**
	 * Returns the value of the '<em><b>Source Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Reference</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Reference</em>' containment reference.
	 * @see #setSourceReference(Reference)
	 * @see org.kermeta.sintaks.trace.TracePackage#getTrace_SourceReference()
	 * @model containment="true"
	 * @generated
	 */
	Reference getSourceReference();

	/**
	 * Sets the value of the '{@link org.kermeta.sintaks.trace.Trace#getSourceReference <em>Source Reference</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Reference</em>' containment reference.
	 * @see #getSourceReference()
	 * @generated
	 */
	void setSourceReference(Reference value);

	/**
	 * Returns the value of the '<em><b>Target Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Reference</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Reference</em>' containment reference.
	 * @see #setTargetReference(Reference)
	 * @see org.kermeta.sintaks.trace.TracePackage#getTrace_TargetReference()
	 * @model containment="true"
	 * @generated
	 */
	Reference getTargetReference();

	/**
	 * Sets the value of the '{@link org.kermeta.sintaks.trace.Trace#getTargetReference <em>Target Reference</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Reference</em>' containment reference.
	 * @see #getTargetReference()
	 * @generated
	 */
	void setTargetReference(Reference value);

	/**
	 * Returns the value of the '<em><b>Rule Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rule Reference</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rule Reference</em>' containment reference.
	 * @see #setRuleReference(Reference)
	 * @see org.kermeta.sintaks.trace.TracePackage#getTrace_RuleReference()
	 * @model containment="true"
	 * @generated
	 */
	Reference getRuleReference();

	/**
	 * Sets the value of the '{@link org.kermeta.sintaks.trace.Trace#getRuleReference <em>Rule Reference</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rule Reference</em>' containment reference.
	 * @see #getRuleReference()
	 * @generated
	 */
	void setRuleReference(Reference value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' containment reference list.
	 * The list contents are of type {@link org.kermeta.sintaks.trace.Message}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' containment reference list.
	 * @see org.kermeta.sintaks.trace.TracePackage#getTrace_Description()
	 * @model containment="true"
	 * @generated
	 */
	EList<Message> getDescription();

	/**
	 * Returns the value of the '<em><b>Sub Traces</b></em>' containment reference list.
	 * The list contents are of type {@link org.kermeta.sintaks.trace.Trace}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Traces</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Traces</em>' containment reference list.
	 * @see org.kermeta.sintaks.trace.TracePackage#getTrace_SubTraces()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Trace> getSubTraces();

} // Trace
