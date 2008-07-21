/**
 * <copyright>
 * </copyright>
 *
 * $Id: FileReference.java,v 1.1 2008-07-21 13:10:32 hassen Exp $
 */
package org.kermeta.sintaks.trace;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>File Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.kermeta.sintaks.trace.FileReference#getFilename <em>Filename</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.kermeta.sintaks.trace.TracePackage#getFileReference()
 * @model
 * @generated
 */
public interface FileReference extends Reference {
	/**
	 * Returns the value of the '<em><b>Filename</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Filename</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Filename</em>' attribute.
	 * @see #setFilename(String)
	 * @see org.kermeta.sintaks.trace.TracePackage#getFileReference_Filename()
	 * @model
	 * @generated
	 */
	String getFilename();

	/**
	 * Sets the value of the '{@link org.kermeta.sintaks.trace.FileReference#getFilename <em>Filename</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Filename</em>' attribute.
	 * @see #getFilename()
	 * @generated
	 */
	void setFilename(String value);

} // FileReference
