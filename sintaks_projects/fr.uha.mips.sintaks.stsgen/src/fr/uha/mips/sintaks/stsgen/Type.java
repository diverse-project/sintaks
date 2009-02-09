/**
 * <copyright>
 * </copyright>
 *
 * $Id: Type.java,v 1.1 2009-02-09 13:26:37 hassen Exp $
 */
package fr.uha.mips.sintaks.stsgen;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see fr.uha.mips.sintaks.stsgen.StsgenPackage#getType()
 * @model
 * @generated
 */
public enum Type implements Enumerator {
	/**
	 * The '<em><b>ID</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ID_VALUE
	 * @generated
	 * @ordered
	 */
	ID(1, "ID", "ID"),

	/**
	 * The '<em><b>ATTRIBUTE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ATTRIBUTE_VALUE
	 * @generated
	 * @ordered
	 */
	ATTRIBUTE(4, "ATTRIBUTE", "Attribute"), /**
	 * The '<em><b>CONTAINER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONTAINER_VALUE
	 * @generated
	 * @ordered
	 */
	CONTAINER(5, "CONTAINER", "Container"),

	/**
	 * The '<em><b>REFERENCE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REFERENCE_VALUE
	 * @generated
	 * @ordered
	 */
	REFERENCE(6, "REFERENCE", "Reference"), /**
	 * The '<em><b>ADJECTIVE BEFORE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ADJECTIVE_BEFORE_VALUE
	 * @generated
	 * @ordered
	 */
	ADJECTIVE_BEFORE(2, "ADJECTIVE_BEFORE", "Adjective before"), /**
	 * The '<em><b>ADJECTIVE AFTER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ADJECTIVE_AFTER_VALUE
	 * @generated
	 * @ordered
	 */
	ADJECTIVE_AFTER(3, "ADJECTIVE_AFTER", "Adjective after");

	/**
	 * The '<em><b>ID</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ID</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ID
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ID_VALUE = 1;

	/**
	 * The '<em><b>ATTRIBUTE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ATTRIBUTE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ATTRIBUTE
	 * @model literal="Attribute"
	 * @generated
	 * @ordered
	 */
	public static final int ATTRIBUTE_VALUE = 4;

	/**
	 * The '<em><b>CONTAINER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CONTAINER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONTAINER
	 * @model literal="Container"
	 * @generated
	 * @ordered
	 */
	public static final int CONTAINER_VALUE = 5;

	/**
	 * The '<em><b>REFERENCE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>REFERENCE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REFERENCE
	 * @model literal="Reference"
	 * @generated
	 * @ordered
	 */
	public static final int REFERENCE_VALUE = 6;

	/**
	 * The '<em><b>ADJECTIVE BEFORE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ADJECTIVE BEFORE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ADJECTIVE_BEFORE
	 * @model literal="Adjective before"
	 * @generated
	 * @ordered
	 */
	public static final int ADJECTIVE_BEFORE_VALUE = 2;

	/**
	 * The '<em><b>ADJECTIVE AFTER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ADJECTIVE AFTER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ADJECTIVE_AFTER
	 * @model literal="Adjective after"
	 * @generated
	 * @ordered
	 */
	public static final int ADJECTIVE_AFTER_VALUE = 3;

	/**
	 * An array of all the '<em><b>Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final Type[] VALUES_ARRAY =
		new Type[] {
			ID,
			ATTRIBUTE,
			CONTAINER,
			REFERENCE,
			ADJECTIVE_BEFORE,
			ADJECTIVE_AFTER,
		};

	/**
	 * A public read-only list of all the '<em><b>Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<Type> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Type get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Type result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Type getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Type result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Type get(int value) {
		switch (value) {
			case ID_VALUE: return ID;
			case ATTRIBUTE_VALUE: return ATTRIBUTE;
			case CONTAINER_VALUE: return CONTAINER;
			case REFERENCE_VALUE: return REFERENCE;
			case ADJECTIVE_BEFORE_VALUE: return ADJECTIVE_BEFORE;
			case ADJECTIVE_AFTER_VALUE: return ADJECTIVE_AFTER;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private Type(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //Type
