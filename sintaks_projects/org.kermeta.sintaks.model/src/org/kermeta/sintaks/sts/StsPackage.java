/**
 * <copyright>
 * </copyright>
 *
 * $Id: StsPackage.java,v 1.4 2008-07-11 09:31:37 hassen Exp $
 */
package org.kermeta.sintaks.sts;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see org.kermeta.sintaks.sts.StsFactory
 * @model kind="package"
 * @generated
 */
public interface StsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "sts";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.kermeta.org/Sts";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "sts";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StsPackage eINSTANCE = org.kermeta.sintaks.sts.impl.StsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.kermeta.sintaks.sts.impl.RootImpl <em>Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.kermeta.sintaks.sts.impl.RootImpl
	 * @see org.kermeta.sintaks.sts.impl.StsPackageImpl#getRoot()
	 * @generated
	 */
	int ROOT = 0;

	/**
	 * The feature id for the '<em><b>Fragments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__FRAGMENTS = 0;

	/**
	 * The feature id for the '<em><b>Start</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__START = 1;

	/**
	 * The feature id for the '<em><b>String Delimliter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__STRING_DELIMLITER = 2;

	/**
	 * The feature id for the '<em><b>Escape Character</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__ESCAPE_CHARACTER = 3;

	/**
	 * The feature id for the '<em><b>Eol Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__EOL_COMMENT = 4;

	/**
	 * The feature id for the '<em><b>Block Comment Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__BLOCK_COMMENT_START = 5;

	/**
	 * The feature id for the '<em><b>Block Comment End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__BLOCK_COMMENT_END = 6;

	/**
	 * The number of structural features of the '<em>Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link org.kermeta.sintaks.sts.impl.RuleImpl <em>Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.kermeta.sintaks.sts.impl.RuleImpl
	 * @see org.kermeta.sintaks.sts.impl.StsPackageImpl#getRule()
	 * @generated
	 */
	int RULE = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__ID = 0;

	/**
	 * The number of structural features of the '<em>Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.kermeta.sintaks.sts.impl.SequenceImpl <em>Sequence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.kermeta.sintaks.sts.impl.SequenceImpl
	 * @see org.kermeta.sintaks.sts.impl.StsPackageImpl#getSequence()
	 * @generated
	 */
	int SEQUENCE = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE__ID = RULE__ID;

	/**
	 * The feature id for the '<em><b>Sub Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE__SUB_RULES = RULE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sequence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_FEATURE_COUNT = RULE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.kermeta.sintaks.sts.impl.IterationImpl <em>Iteration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.kermeta.sintaks.sts.impl.IterationImpl
	 * @see org.kermeta.sintaks.sts.impl.StsPackageImpl#getIteration()
	 * @generated
	 */
	int ITERATION = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__ID = RULE__ID;

	/**
	 * The feature id for the '<em><b>Sub Rule</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__SUB_RULE = RULE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__CONTAINER = RULE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Separator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__SEPARATOR = RULE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Containers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__CONTAINERS = RULE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Iteration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION_FEATURE_COUNT = RULE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.kermeta.sintaks.sts.impl.ChoiceImpl <em>Choice</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.kermeta.sintaks.sts.impl.ChoiceImpl
	 * @see org.kermeta.sintaks.sts.impl.StsPackageImpl#getChoice()
	 * @generated
	 */
	int CHOICE = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE__ID = RULE__ID;

	/**
	 * The feature id for the '<em><b>Conditions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE__CONDITIONS = RULE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Choice</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_FEATURE_COUNT = RULE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.kermeta.sintaks.sts.impl.AlternativeImpl <em>Alternative</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.kermeta.sintaks.sts.impl.AlternativeImpl
	 * @see org.kermeta.sintaks.sts.impl.StsPackageImpl#getAlternative()
	 * @generated
	 */
	int ALTERNATIVE = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTERNATIVE__ID = CHOICE__ID;

	/**
	 * The feature id for the '<em><b>Conditions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTERNATIVE__CONDITIONS = CHOICE__CONDITIONS;

	/**
	 * The number of structural features of the '<em>Alternative</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTERNATIVE_FEATURE_COUNT = CHOICE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.kermeta.sintaks.sts.impl.OnceImpl <em>Once</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.kermeta.sintaks.sts.impl.OnceImpl
	 * @see org.kermeta.sintaks.sts.impl.StsPackageImpl#getOnce()
	 * @generated
	 */
	int ONCE = 6;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ONCE__ID = CHOICE__ID;

	/**
	 * The feature id for the '<em><b>Conditions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ONCE__CONDITIONS = CHOICE__CONDITIONS;

	/**
	 * The feature id for the '<em><b>Separator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ONCE__SEPARATOR = CHOICE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Once</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ONCE_FEATURE_COUNT = CHOICE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.kermeta.sintaks.sts.impl.ConditionImpl <em>Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.kermeta.sintaks.sts.impl.ConditionImpl
	 * @see org.kermeta.sintaks.sts.impl.StsPackageImpl#getCondition()
	 * @generated
	 */
	int CONDITION = 7;

	/**
	 * The feature id for the '<em><b>Sub Rule</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION__SUB_RULE = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.kermeta.sintaks.sts.impl.PolymorphicCondImpl <em>Polymorphic Cond</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.kermeta.sintaks.sts.impl.PolymorphicCondImpl
	 * @see org.kermeta.sintaks.sts.impl.StsPackageImpl#getPolymorphicCond()
	 * @generated
	 */
	int POLYMORPHIC_COND = 8;

	/**
	 * The feature id for the '<em><b>Sub Rule</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYMORPHIC_COND__SUB_RULE = CONDITION__SUB_RULE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYMORPHIC_COND__VALUE = CONDITION__VALUE;

	/**
	 * The feature id for the '<em><b>Metaclass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYMORPHIC_COND__METACLASS = CONDITION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Polymorphic Cond</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYMORPHIC_COND_FEATURE_COUNT = CONDITION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.kermeta.sintaks.sts.impl.CustomCondImpl <em>Custom Cond</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.kermeta.sintaks.sts.impl.CustomCondImpl
	 * @see org.kermeta.sintaks.sts.impl.StsPackageImpl#getCustomCond()
	 * @generated
	 */
	int CUSTOM_COND = 9;

	/**
	 * The feature id for the '<em><b>Sub Rule</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_COND__SUB_RULE = CONDITION__SUB_RULE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_COND__VALUE = CONDITION__VALUE;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_COND__FEATURE = CONDITION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Custom Cond</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_COND_FEATURE_COUNT = CONDITION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.kermeta.sintaks.sts.impl.TerminalImpl <em>Terminal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.kermeta.sintaks.sts.impl.TerminalImpl
	 * @see org.kermeta.sintaks.sts.impl.StsPackageImpl#getTerminal()
	 * @generated
	 */
	int TERMINAL = 10;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINAL__ID = RULE__ID;

	/**
	 * The feature id for the '<em><b>Terminal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINAL__TERMINAL = RULE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Lexical Separator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINAL__LEXICAL_SEPARATOR = RULE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Case Sensitive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINAL__CASE_SENSITIVE = RULE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Surrounding Spaces</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINAL__SURROUNDING_SPACES = RULE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Terminal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINAL_FEATURE_COUNT = RULE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.kermeta.sintaks.sts.impl.AdornmentImpl <em>Adornment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.kermeta.sintaks.sts.impl.AdornmentImpl
	 * @see org.kermeta.sintaks.sts.impl.StsPackageImpl#getAdornment()
	 * @generated
	 */
	int ADORNMENT = 11;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADORNMENT__ID = TERMINAL__ID;

	/**
	 * The feature id for the '<em><b>Terminal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADORNMENT__TERMINAL = TERMINAL__TERMINAL;

	/**
	 * The feature id for the '<em><b>Lexical Separator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADORNMENT__LEXICAL_SEPARATOR = TERMINAL__LEXICAL_SEPARATOR;

	/**
	 * The feature id for the '<em><b>Case Sensitive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADORNMENT__CASE_SENSITIVE = TERMINAL__CASE_SENSITIVE;

	/**
	 * The feature id for the '<em><b>Surrounding Spaces</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADORNMENT__SURROUNDING_SPACES = TERMINAL__SURROUNDING_SPACES;

	/**
	 * The number of structural features of the '<em>Adornment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADORNMENT_FEATURE_COUNT = TERMINAL_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.kermeta.sintaks.sts.impl.TemplateImpl <em>Template</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.kermeta.sintaks.sts.impl.TemplateImpl
	 * @see org.kermeta.sintaks.sts.impl.StsPackageImpl#getTemplate()
	 * @generated
	 */
	int TEMPLATE = 12;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE__ID = RULE__ID;

	/**
	 * The feature id for the '<em><b>Metaclass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE__METACLASS = RULE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Rule</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE__RULE = RULE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Template</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_FEATURE_COUNT = RULE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.kermeta.sintaks.sts.impl.ValueImpl <em>Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.kermeta.sintaks.sts.impl.ValueImpl
	 * @see org.kermeta.sintaks.sts.impl.StsPackageImpl#getValue()
	 * @generated
	 */
	int VALUE = 13;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE__ID = RULE__ID;

	/**
	 * The feature id for the '<em><b>Features</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE__FEATURES = RULE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Surrounding Spaces</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE__SURROUNDING_SPACES = RULE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_FEATURE_COUNT = RULE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.kermeta.sintaks.sts.impl.PrimitiveValueImpl <em>Primitive Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.kermeta.sintaks.sts.impl.PrimitiveValueImpl
	 * @see org.kermeta.sintaks.sts.impl.StsPackageImpl#getPrimitiveValue()
	 * @generated
	 */
	int PRIMITIVE_VALUE = 14;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_VALUE__ID = VALUE__ID;

	/**
	 * The feature id for the '<em><b>Features</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_VALUE__FEATURES = VALUE__FEATURES;

	/**
	 * The feature id for the '<em><b>Surrounding Spaces</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_VALUE__SURROUNDING_SPACES = VALUE__SURROUNDING_SPACES;

	/**
	 * The number of structural features of the '<em>Primitive Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_VALUE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.kermeta.sintaks.sts.impl.ObjectReferenceImpl <em>Object Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.kermeta.sintaks.sts.impl.ObjectReferenceImpl
	 * @see org.kermeta.sintaks.sts.impl.StsPackageImpl#getObjectReference()
	 * @generated
	 */
	int OBJECT_REFERENCE = 15;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_REFERENCE__ID = VALUE__ID;

	/**
	 * The feature id for the '<em><b>Features</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_REFERENCE__FEATURES = VALUE__FEATURES;

	/**
	 * The feature id for the '<em><b>Surrounding Spaces</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_REFERENCE__SURROUNDING_SPACES = VALUE__SURROUNDING_SPACES;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_REFERENCE__IDENTIFIER = VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Object Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_REFERENCE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.kermeta.sintaks.sts.impl.RuleRefImpl <em>Rule Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.kermeta.sintaks.sts.impl.RuleRefImpl
	 * @see org.kermeta.sintaks.sts.impl.StsPackageImpl#getRuleRef()
	 * @generated
	 */
	int RULE_REF = 16;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_REF__ID = VALUE__ID;

	/**
	 * The feature id for the '<em><b>Features</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_REF__FEATURES = VALUE__FEATURES;

	/**
	 * The feature id for the '<em><b>Surrounding Spaces</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_REF__SURROUNDING_SPACES = VALUE__SURROUNDING_SPACES;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_REF__REF = VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Rule Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_REF_FEATURE_COUNT = VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.kermeta.sintaks.sts.impl.ConstantImpl <em>Constant</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.kermeta.sintaks.sts.impl.ConstantImpl
	 * @see org.kermeta.sintaks.sts.impl.StsPackageImpl#getConstant()
	 * @generated
	 */
	int CONSTANT = 17;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT__ID = VALUE__ID;

	/**
	 * The feature id for the '<em><b>Features</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT__FEATURES = VALUE__FEATURES;

	/**
	 * The feature id for the '<em><b>Surrounding Spaces</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT__SURROUNDING_SPACES = VALUE__SURROUNDING_SPACES;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT__VALUE = VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Constant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_FEATURE_COUNT = VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.kermeta.sintaks.sts.impl.URIValueImpl <em>URI Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.kermeta.sintaks.sts.impl.URIValueImpl
	 * @see org.kermeta.sintaks.sts.impl.StsPackageImpl#getURIValue()
	 * @generated
	 */
	int URI_VALUE = 18;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URI_VALUE__ID = VALUE__ID;

	/**
	 * The feature id for the '<em><b>Features</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URI_VALUE__FEATURES = VALUE__FEATURES;

	/**
	 * The feature id for the '<em><b>Surrounding Spaces</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URI_VALUE__SURROUNDING_SPACES = VALUE__SURROUNDING_SPACES;

	/**
	 * The number of structural features of the '<em>URI Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URI_VALUE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.kermeta.sintaks.sts.Root <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Root</em>'.
	 * @see org.kermeta.sintaks.sts.Root
	 * @generated
	 */
	EClass getRoot();

	/**
	 * Returns the meta object for the containment reference list '{@link org.kermeta.sintaks.sts.Root#getFragments <em>Fragments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Fragments</em>'.
	 * @see org.kermeta.sintaks.sts.Root#getFragments()
	 * @see #getRoot()
	 * @generated
	 */
	EReference getRoot_Fragments();

	/**
	 * Returns the meta object for the reference '{@link org.kermeta.sintaks.sts.Root#getStart <em>Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Start</em>'.
	 * @see org.kermeta.sintaks.sts.Root#getStart()
	 * @see #getRoot()
	 * @generated
	 */
	EReference getRoot_Start();

	/**
	 * Returns the meta object for the attribute '{@link org.kermeta.sintaks.sts.Root#getStringDelimliter <em>String Delimliter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>String Delimliter</em>'.
	 * @see org.kermeta.sintaks.sts.Root#getStringDelimliter()
	 * @see #getRoot()
	 * @generated
	 */
	EAttribute getRoot_StringDelimliter();

	/**
	 * Returns the meta object for the attribute '{@link org.kermeta.sintaks.sts.Root#getEscapeCharacter <em>Escape Character</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Escape Character</em>'.
	 * @see org.kermeta.sintaks.sts.Root#getEscapeCharacter()
	 * @see #getRoot()
	 * @generated
	 */
	EAttribute getRoot_EscapeCharacter();

	/**
	 * Returns the meta object for the attribute '{@link org.kermeta.sintaks.sts.Root#getEolComment <em>Eol Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Eol Comment</em>'.
	 * @see org.kermeta.sintaks.sts.Root#getEolComment()
	 * @see #getRoot()
	 * @generated
	 */
	EAttribute getRoot_EolComment();

	/**
	 * Returns the meta object for the attribute '{@link org.kermeta.sintaks.sts.Root#getBlockCommentStart <em>Block Comment Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Block Comment Start</em>'.
	 * @see org.kermeta.sintaks.sts.Root#getBlockCommentStart()
	 * @see #getRoot()
	 * @generated
	 */
	EAttribute getRoot_BlockCommentStart();

	/**
	 * Returns the meta object for the attribute '{@link org.kermeta.sintaks.sts.Root#getBlockCommentEnd <em>Block Comment End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Block Comment End</em>'.
	 * @see org.kermeta.sintaks.sts.Root#getBlockCommentEnd()
	 * @see #getRoot()
	 * @generated
	 */
	EAttribute getRoot_BlockCommentEnd();

	/**
	 * Returns the meta object for class '{@link org.kermeta.sintaks.sts.Rule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rule</em>'.
	 * @see org.kermeta.sintaks.sts.Rule
	 * @generated
	 */
	EClass getRule();

	/**
	 * Returns the meta object for the attribute '{@link org.kermeta.sintaks.sts.Rule#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.kermeta.sintaks.sts.Rule#getId()
	 * @see #getRule()
	 * @generated
	 */
	EAttribute getRule_Id();

	/**
	 * Returns the meta object for class '{@link org.kermeta.sintaks.sts.Sequence <em>Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sequence</em>'.
	 * @see org.kermeta.sintaks.sts.Sequence
	 * @generated
	 */
	EClass getSequence();

	/**
	 * Returns the meta object for the containment reference list '{@link org.kermeta.sintaks.sts.Sequence#getSubRules <em>Sub Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Rules</em>'.
	 * @see org.kermeta.sintaks.sts.Sequence#getSubRules()
	 * @see #getSequence()
	 * @generated
	 */
	EReference getSequence_SubRules();

	/**
	 * Returns the meta object for class '{@link org.kermeta.sintaks.sts.Iteration <em>Iteration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Iteration</em>'.
	 * @see org.kermeta.sintaks.sts.Iteration
	 * @generated
	 */
	EClass getIteration();

	/**
	 * Returns the meta object for the containment reference '{@link org.kermeta.sintaks.sts.Iteration#getSubRule <em>Sub Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sub Rule</em>'.
	 * @see org.kermeta.sintaks.sts.Iteration#getSubRule()
	 * @see #getIteration()
	 * @generated
	 */
	EReference getIteration_SubRule();

	/**
	 * Returns the meta object for the reference '{@link org.kermeta.sintaks.sts.Iteration#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Container</em>'.
	 * @see org.kermeta.sintaks.sts.Iteration#getContainer()
	 * @see #getIteration()
	 * @generated
	 */
	EReference getIteration_Container();

	/**
	 * Returns the meta object for the reference '{@link org.kermeta.sintaks.sts.Iteration#getSeparator <em>Separator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Separator</em>'.
	 * @see org.kermeta.sintaks.sts.Iteration#getSeparator()
	 * @see #getIteration()
	 * @generated
	 */
	EReference getIteration_Separator();

	/**
	 * Returns the meta object for the reference list '{@link org.kermeta.sintaks.sts.Iteration#getContainers <em>Containers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Containers</em>'.
	 * @see org.kermeta.sintaks.sts.Iteration#getContainers()
	 * @see #getIteration()
	 * @generated
	 */
	EReference getIteration_Containers();

	/**
	 * Returns the meta object for class '{@link org.kermeta.sintaks.sts.Choice <em>Choice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Choice</em>'.
	 * @see org.kermeta.sintaks.sts.Choice
	 * @generated
	 */
	EClass getChoice();

	/**
	 * Returns the meta object for the containment reference list '{@link org.kermeta.sintaks.sts.Choice#getConditions <em>Conditions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Conditions</em>'.
	 * @see org.kermeta.sintaks.sts.Choice#getConditions()
	 * @see #getChoice()
	 * @generated
	 */
	EReference getChoice_Conditions();

	/**
	 * Returns the meta object for class '{@link org.kermeta.sintaks.sts.Alternative <em>Alternative</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Alternative</em>'.
	 * @see org.kermeta.sintaks.sts.Alternative
	 * @generated
	 */
	EClass getAlternative();

	/**
	 * Returns the meta object for class '{@link org.kermeta.sintaks.sts.Once <em>Once</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Once</em>'.
	 * @see org.kermeta.sintaks.sts.Once
	 * @generated
	 */
	EClass getOnce();

	/**
	 * Returns the meta object for the reference '{@link org.kermeta.sintaks.sts.Once#getSeparator <em>Separator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Separator</em>'.
	 * @see org.kermeta.sintaks.sts.Once#getSeparator()
	 * @see #getOnce()
	 * @generated
	 */
	EReference getOnce_Separator();

	/**
	 * Returns the meta object for class '{@link org.kermeta.sintaks.sts.Condition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Condition</em>'.
	 * @see org.kermeta.sintaks.sts.Condition
	 * @generated
	 */
	EClass getCondition();

	/**
	 * Returns the meta object for the containment reference '{@link org.kermeta.sintaks.sts.Condition#getSubRule <em>Sub Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sub Rule</em>'.
	 * @see org.kermeta.sintaks.sts.Condition#getSubRule()
	 * @see #getCondition()
	 * @generated
	 */
	EReference getCondition_SubRule();

	/**
	 * Returns the meta object for the attribute '{@link org.kermeta.sintaks.sts.Condition#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.kermeta.sintaks.sts.Condition#getValue()
	 * @see #getCondition()
	 * @generated
	 */
	EAttribute getCondition_Value();

	/**
	 * Returns the meta object for class '{@link org.kermeta.sintaks.sts.PolymorphicCond <em>Polymorphic Cond</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Polymorphic Cond</em>'.
	 * @see org.kermeta.sintaks.sts.PolymorphicCond
	 * @generated
	 */
	EClass getPolymorphicCond();

	/**
	 * Returns the meta object for the reference '{@link org.kermeta.sintaks.sts.PolymorphicCond#getMetaclass <em>Metaclass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Metaclass</em>'.
	 * @see org.kermeta.sintaks.sts.PolymorphicCond#getMetaclass()
	 * @see #getPolymorphicCond()
	 * @generated
	 */
	EReference getPolymorphicCond_Metaclass();

	/**
	 * Returns the meta object for class '{@link org.kermeta.sintaks.sts.CustomCond <em>Custom Cond</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Custom Cond</em>'.
	 * @see org.kermeta.sintaks.sts.CustomCond
	 * @generated
	 */
	EClass getCustomCond();

	/**
	 * Returns the meta object for the reference '{@link org.kermeta.sintaks.sts.CustomCond#getFeature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Feature</em>'.
	 * @see org.kermeta.sintaks.sts.CustomCond#getFeature()
	 * @see #getCustomCond()
	 * @generated
	 */
	EReference getCustomCond_Feature();

	/**
	 * Returns the meta object for class '{@link org.kermeta.sintaks.sts.Terminal <em>Terminal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Terminal</em>'.
	 * @see org.kermeta.sintaks.sts.Terminal
	 * @generated
	 */
	EClass getTerminal();

	/**
	 * Returns the meta object for the attribute '{@link org.kermeta.sintaks.sts.Terminal#getTerminal <em>Terminal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Terminal</em>'.
	 * @see org.kermeta.sintaks.sts.Terminal#getTerminal()
	 * @see #getTerminal()
	 * @generated
	 */
	EAttribute getTerminal_Terminal();

	/**
	 * Returns the meta object for the attribute '{@link org.kermeta.sintaks.sts.Terminal#isLexicalSeparator <em>Lexical Separator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lexical Separator</em>'.
	 * @see org.kermeta.sintaks.sts.Terminal#isLexicalSeparator()
	 * @see #getTerminal()
	 * @generated
	 */
	EAttribute getTerminal_LexicalSeparator();

	/**
	 * Returns the meta object for the attribute '{@link org.kermeta.sintaks.sts.Terminal#isCaseSensitive <em>Case Sensitive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Case Sensitive</em>'.
	 * @see org.kermeta.sintaks.sts.Terminal#isCaseSensitive()
	 * @see #getTerminal()
	 * @generated
	 */
	EAttribute getTerminal_CaseSensitive();

	/**
	 * Returns the meta object for the attribute '{@link org.kermeta.sintaks.sts.Terminal#isSurroundingSpaces <em>Surrounding Spaces</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Surrounding Spaces</em>'.
	 * @see org.kermeta.sintaks.sts.Terminal#isSurroundingSpaces()
	 * @see #getTerminal()
	 * @generated
	 */
	EAttribute getTerminal_SurroundingSpaces();

	/**
	 * Returns the meta object for class '{@link org.kermeta.sintaks.sts.Adornment <em>Adornment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Adornment</em>'.
	 * @see org.kermeta.sintaks.sts.Adornment
	 * @generated
	 */
	EClass getAdornment();

	/**
	 * Returns the meta object for class '{@link org.kermeta.sintaks.sts.Template <em>Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template</em>'.
	 * @see org.kermeta.sintaks.sts.Template
	 * @generated
	 */
	EClass getTemplate();

	/**
	 * Returns the meta object for the reference '{@link org.kermeta.sintaks.sts.Template#getMetaclass <em>Metaclass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Metaclass</em>'.
	 * @see org.kermeta.sintaks.sts.Template#getMetaclass()
	 * @see #getTemplate()
	 * @generated
	 */
	EReference getTemplate_Metaclass();

	/**
	 * Returns the meta object for the containment reference '{@link org.kermeta.sintaks.sts.Template#getRule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Rule</em>'.
	 * @see org.kermeta.sintaks.sts.Template#getRule()
	 * @see #getTemplate()
	 * @generated
	 */
	EReference getTemplate_Rule();

	/**
	 * Returns the meta object for class '{@link org.kermeta.sintaks.sts.Value <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value</em>'.
	 * @see org.kermeta.sintaks.sts.Value
	 * @generated
	 */
	EClass getValue();

	/**
	 * Returns the meta object for the reference list '{@link org.kermeta.sintaks.sts.Value#getFeatures <em>Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Features</em>'.
	 * @see org.kermeta.sintaks.sts.Value#getFeatures()
	 * @see #getValue()
	 * @generated
	 */
	EReference getValue_Features();

	/**
	 * Returns the meta object for the attribute '{@link org.kermeta.sintaks.sts.Value#isSurroundingSpaces <em>Surrounding Spaces</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Surrounding Spaces</em>'.
	 * @see org.kermeta.sintaks.sts.Value#isSurroundingSpaces()
	 * @see #getValue()
	 * @generated
	 */
	EAttribute getValue_SurroundingSpaces();

	/**
	 * Returns the meta object for class '{@link org.kermeta.sintaks.sts.PrimitiveValue <em>Primitive Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Value</em>'.
	 * @see org.kermeta.sintaks.sts.PrimitiveValue
	 * @generated
	 */
	EClass getPrimitiveValue();

	/**
	 * Returns the meta object for class '{@link org.kermeta.sintaks.sts.ObjectReference <em>Object Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Reference</em>'.
	 * @see org.kermeta.sintaks.sts.ObjectReference
	 * @generated
	 */
	EClass getObjectReference();

	/**
	 * Returns the meta object for the reference '{@link org.kermeta.sintaks.sts.ObjectReference#getIdentifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Identifier</em>'.
	 * @see org.kermeta.sintaks.sts.ObjectReference#getIdentifier()
	 * @see #getObjectReference()
	 * @generated
	 */
	EReference getObjectReference_Identifier();

	/**
	 * Returns the meta object for class '{@link org.kermeta.sintaks.sts.RuleRef <em>Rule Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rule Ref</em>'.
	 * @see org.kermeta.sintaks.sts.RuleRef
	 * @generated
	 */
	EClass getRuleRef();

	/**
	 * Returns the meta object for the reference '{@link org.kermeta.sintaks.sts.RuleRef#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ref</em>'.
	 * @see org.kermeta.sintaks.sts.RuleRef#getRef()
	 * @see #getRuleRef()
	 * @generated
	 */
	EReference getRuleRef_Ref();

	/**
	 * Returns the meta object for class '{@link org.kermeta.sintaks.sts.Constant <em>Constant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constant</em>'.
	 * @see org.kermeta.sintaks.sts.Constant
	 * @generated
	 */
	EClass getConstant();

	/**
	 * Returns the meta object for the attribute '{@link org.kermeta.sintaks.sts.Constant#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.kermeta.sintaks.sts.Constant#getValue()
	 * @see #getConstant()
	 * @generated
	 */
	EAttribute getConstant_Value();

	/**
	 * Returns the meta object for class '{@link org.kermeta.sintaks.sts.URIValue <em>URI Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>URI Value</em>'.
	 * @see org.kermeta.sintaks.sts.URIValue
	 * @generated
	 */
	EClass getURIValue();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	StsFactory getStsFactory();

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
		 * The meta object literal for the '{@link org.kermeta.sintaks.sts.impl.RootImpl <em>Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.kermeta.sintaks.sts.impl.RootImpl
		 * @see org.kermeta.sintaks.sts.impl.StsPackageImpl#getRoot()
		 * @generated
		 */
		EClass ROOT = eINSTANCE.getRoot();

		/**
		 * The meta object literal for the '<em><b>Fragments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT__FRAGMENTS = eINSTANCE.getRoot_Fragments();

		/**
		 * The meta object literal for the '<em><b>Start</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT__START = eINSTANCE.getRoot_Start();

		/**
		 * The meta object literal for the '<em><b>String Delimliter</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROOT__STRING_DELIMLITER = eINSTANCE.getRoot_StringDelimliter();

		/**
		 * The meta object literal for the '<em><b>Escape Character</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROOT__ESCAPE_CHARACTER = eINSTANCE.getRoot_EscapeCharacter();

		/**
		 * The meta object literal for the '<em><b>Eol Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROOT__EOL_COMMENT = eINSTANCE.getRoot_EolComment();

		/**
		 * The meta object literal for the '<em><b>Block Comment Start</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROOT__BLOCK_COMMENT_START = eINSTANCE.getRoot_BlockCommentStart();

		/**
		 * The meta object literal for the '<em><b>Block Comment End</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROOT__BLOCK_COMMENT_END = eINSTANCE.getRoot_BlockCommentEnd();

		/**
		 * The meta object literal for the '{@link org.kermeta.sintaks.sts.impl.RuleImpl <em>Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.kermeta.sintaks.sts.impl.RuleImpl
		 * @see org.kermeta.sintaks.sts.impl.StsPackageImpl#getRule()
		 * @generated
		 */
		EClass RULE = eINSTANCE.getRule();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RULE__ID = eINSTANCE.getRule_Id();

		/**
		 * The meta object literal for the '{@link org.kermeta.sintaks.sts.impl.SequenceImpl <em>Sequence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.kermeta.sintaks.sts.impl.SequenceImpl
		 * @see org.kermeta.sintaks.sts.impl.StsPackageImpl#getSequence()
		 * @generated
		 */
		EClass SEQUENCE = eINSTANCE.getSequence();

		/**
		 * The meta object literal for the '<em><b>Sub Rules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEQUENCE__SUB_RULES = eINSTANCE.getSequence_SubRules();

		/**
		 * The meta object literal for the '{@link org.kermeta.sintaks.sts.impl.IterationImpl <em>Iteration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.kermeta.sintaks.sts.impl.IterationImpl
		 * @see org.kermeta.sintaks.sts.impl.StsPackageImpl#getIteration()
		 * @generated
		 */
		EClass ITERATION = eINSTANCE.getIteration();

		/**
		 * The meta object literal for the '<em><b>Sub Rule</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITERATION__SUB_RULE = eINSTANCE.getIteration_SubRule();

		/**
		 * The meta object literal for the '<em><b>Container</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITERATION__CONTAINER = eINSTANCE.getIteration_Container();

		/**
		 * The meta object literal for the '<em><b>Separator</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITERATION__SEPARATOR = eINSTANCE.getIteration_Separator();

		/**
		 * The meta object literal for the '<em><b>Containers</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITERATION__CONTAINERS = eINSTANCE.getIteration_Containers();

		/**
		 * The meta object literal for the '{@link org.kermeta.sintaks.sts.impl.ChoiceImpl <em>Choice</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.kermeta.sintaks.sts.impl.ChoiceImpl
		 * @see org.kermeta.sintaks.sts.impl.StsPackageImpl#getChoice()
		 * @generated
		 */
		EClass CHOICE = eINSTANCE.getChoice();

		/**
		 * The meta object literal for the '<em><b>Conditions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHOICE__CONDITIONS = eINSTANCE.getChoice_Conditions();

		/**
		 * The meta object literal for the '{@link org.kermeta.sintaks.sts.impl.AlternativeImpl <em>Alternative</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.kermeta.sintaks.sts.impl.AlternativeImpl
		 * @see org.kermeta.sintaks.sts.impl.StsPackageImpl#getAlternative()
		 * @generated
		 */
		EClass ALTERNATIVE = eINSTANCE.getAlternative();

		/**
		 * The meta object literal for the '{@link org.kermeta.sintaks.sts.impl.OnceImpl <em>Once</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.kermeta.sintaks.sts.impl.OnceImpl
		 * @see org.kermeta.sintaks.sts.impl.StsPackageImpl#getOnce()
		 * @generated
		 */
		EClass ONCE = eINSTANCE.getOnce();

		/**
		 * The meta object literal for the '<em><b>Separator</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ONCE__SEPARATOR = eINSTANCE.getOnce_Separator();

		/**
		 * The meta object literal for the '{@link org.kermeta.sintaks.sts.impl.ConditionImpl <em>Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.kermeta.sintaks.sts.impl.ConditionImpl
		 * @see org.kermeta.sintaks.sts.impl.StsPackageImpl#getCondition()
		 * @generated
		 */
		EClass CONDITION = eINSTANCE.getCondition();

		/**
		 * The meta object literal for the '<em><b>Sub Rule</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITION__SUB_RULE = eINSTANCE.getCondition_SubRule();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONDITION__VALUE = eINSTANCE.getCondition_Value();

		/**
		 * The meta object literal for the '{@link org.kermeta.sintaks.sts.impl.PolymorphicCondImpl <em>Polymorphic Cond</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.kermeta.sintaks.sts.impl.PolymorphicCondImpl
		 * @see org.kermeta.sintaks.sts.impl.StsPackageImpl#getPolymorphicCond()
		 * @generated
		 */
		EClass POLYMORPHIC_COND = eINSTANCE.getPolymorphicCond();

		/**
		 * The meta object literal for the '<em><b>Metaclass</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POLYMORPHIC_COND__METACLASS = eINSTANCE.getPolymorphicCond_Metaclass();

		/**
		 * The meta object literal for the '{@link org.kermeta.sintaks.sts.impl.CustomCondImpl <em>Custom Cond</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.kermeta.sintaks.sts.impl.CustomCondImpl
		 * @see org.kermeta.sintaks.sts.impl.StsPackageImpl#getCustomCond()
		 * @generated
		 */
		EClass CUSTOM_COND = eINSTANCE.getCustomCond();

		/**
		 * The meta object literal for the '<em><b>Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CUSTOM_COND__FEATURE = eINSTANCE.getCustomCond_Feature();

		/**
		 * The meta object literal for the '{@link org.kermeta.sintaks.sts.impl.TerminalImpl <em>Terminal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.kermeta.sintaks.sts.impl.TerminalImpl
		 * @see org.kermeta.sintaks.sts.impl.StsPackageImpl#getTerminal()
		 * @generated
		 */
		EClass TERMINAL = eINSTANCE.getTerminal();

		/**
		 * The meta object literal for the '<em><b>Terminal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TERMINAL__TERMINAL = eINSTANCE.getTerminal_Terminal();

		/**
		 * The meta object literal for the '<em><b>Lexical Separator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TERMINAL__LEXICAL_SEPARATOR = eINSTANCE.getTerminal_LexicalSeparator();

		/**
		 * The meta object literal for the '<em><b>Case Sensitive</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TERMINAL__CASE_SENSITIVE = eINSTANCE.getTerminal_CaseSensitive();

		/**
		 * The meta object literal for the '<em><b>Surrounding Spaces</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TERMINAL__SURROUNDING_SPACES = eINSTANCE.getTerminal_SurroundingSpaces();

		/**
		 * The meta object literal for the '{@link org.kermeta.sintaks.sts.impl.AdornmentImpl <em>Adornment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.kermeta.sintaks.sts.impl.AdornmentImpl
		 * @see org.kermeta.sintaks.sts.impl.StsPackageImpl#getAdornment()
		 * @generated
		 */
		EClass ADORNMENT = eINSTANCE.getAdornment();

		/**
		 * The meta object literal for the '{@link org.kermeta.sintaks.sts.impl.TemplateImpl <em>Template</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.kermeta.sintaks.sts.impl.TemplateImpl
		 * @see org.kermeta.sintaks.sts.impl.StsPackageImpl#getTemplate()
		 * @generated
		 */
		EClass TEMPLATE = eINSTANCE.getTemplate();

		/**
		 * The meta object literal for the '<em><b>Metaclass</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE__METACLASS = eINSTANCE.getTemplate_Metaclass();

		/**
		 * The meta object literal for the '<em><b>Rule</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE__RULE = eINSTANCE.getTemplate_Rule();

		/**
		 * The meta object literal for the '{@link org.kermeta.sintaks.sts.impl.ValueImpl <em>Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.kermeta.sintaks.sts.impl.ValueImpl
		 * @see org.kermeta.sintaks.sts.impl.StsPackageImpl#getValue()
		 * @generated
		 */
		EClass VALUE = eINSTANCE.getValue();

		/**
		 * The meta object literal for the '<em><b>Features</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALUE__FEATURES = eINSTANCE.getValue_Features();

		/**
		 * The meta object literal for the '<em><b>Surrounding Spaces</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALUE__SURROUNDING_SPACES = eINSTANCE.getValue_SurroundingSpaces();

		/**
		 * The meta object literal for the '{@link org.kermeta.sintaks.sts.impl.PrimitiveValueImpl <em>Primitive Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.kermeta.sintaks.sts.impl.PrimitiveValueImpl
		 * @see org.kermeta.sintaks.sts.impl.StsPackageImpl#getPrimitiveValue()
		 * @generated
		 */
		EClass PRIMITIVE_VALUE = eINSTANCE.getPrimitiveValue();

		/**
		 * The meta object literal for the '{@link org.kermeta.sintaks.sts.impl.ObjectReferenceImpl <em>Object Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.kermeta.sintaks.sts.impl.ObjectReferenceImpl
		 * @see org.kermeta.sintaks.sts.impl.StsPackageImpl#getObjectReference()
		 * @generated
		 */
		EClass OBJECT_REFERENCE = eINSTANCE.getObjectReference();

		/**
		 * The meta object literal for the '<em><b>Identifier</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_REFERENCE__IDENTIFIER = eINSTANCE.getObjectReference_Identifier();

		/**
		 * The meta object literal for the '{@link org.kermeta.sintaks.sts.impl.RuleRefImpl <em>Rule Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.kermeta.sintaks.sts.impl.RuleRefImpl
		 * @see org.kermeta.sintaks.sts.impl.StsPackageImpl#getRuleRef()
		 * @generated
		 */
		EClass RULE_REF = eINSTANCE.getRuleRef();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE_REF__REF = eINSTANCE.getRuleRef_Ref();

		/**
		 * The meta object literal for the '{@link org.kermeta.sintaks.sts.impl.ConstantImpl <em>Constant</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.kermeta.sintaks.sts.impl.ConstantImpl
		 * @see org.kermeta.sintaks.sts.impl.StsPackageImpl#getConstant()
		 * @generated
		 */
		EClass CONSTANT = eINSTANCE.getConstant();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTANT__VALUE = eINSTANCE.getConstant_Value();

		/**
		 * The meta object literal for the '{@link org.kermeta.sintaks.sts.impl.URIValueImpl <em>URI Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.kermeta.sintaks.sts.impl.URIValueImpl
		 * @see org.kermeta.sintaks.sts.impl.StsPackageImpl#getURIValue()
		 * @generated
		 */
		EClass URI_VALUE = eINSTANCE.getURIValue();

	}

} //StsPackage
