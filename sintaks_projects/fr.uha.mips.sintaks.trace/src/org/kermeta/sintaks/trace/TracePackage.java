/**
 * <copyright>
 * </copyright>
 *
 * $Id: TracePackage.java,v 1.1 2008-07-21 13:10:32 hassen Exp $
 */
package org.kermeta.sintaks.trace;

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
 * @see org.kermeta.sintaks.trace.TraceFactory
 * @model kind="package"
 * @generated
 */
public interface TracePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "trace";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.kermeta.org/SintaksTrace";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "trace";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TracePackage eINSTANCE = org.kermeta.sintaks.trace.impl.TracePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.kermeta.sintaks.trace.impl.TraceModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.kermeta.sintaks.trace.impl.TraceModelImpl
	 * @see org.kermeta.sintaks.trace.impl.TracePackageImpl#getTraceModel()
	 * @generated
	 */
	int TRACE_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_MODEL__TRACE = 0;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_MODEL_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.kermeta.sintaks.trace.impl.TraceImpl <em>Trace</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.kermeta.sintaks.trace.impl.TraceImpl
	 * @see org.kermeta.sintaks.trace.impl.TracePackageImpl#getTrace()
	 * @generated
	 */
	int TRACE = 1;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE__STATE = 0;

	/**
	 * The feature id for the '<em><b>Source Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE__SOURCE_REFERENCE = 1;

	/**
	 * The feature id for the '<em><b>Target Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE__TARGET_REFERENCE = 2;

	/**
	 * The feature id for the '<em><b>Rule Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE__RULE_REFERENCE = 3;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE__DESCRIPTION = 4;

	/**
	 * The feature id for the '<em><b>Sub Traces</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE__SUB_TRACES = 5;

	/**
	 * The number of structural features of the '<em>Trace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.kermeta.sintaks.trace.impl.MessageImpl <em>Message</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.kermeta.sintaks.trace.impl.MessageImpl
	 * @see org.kermeta.sintaks.trace.impl.TracePackageImpl#getMessage()
	 * @generated
	 */
	int MESSAGE = 2;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__TEXT = 0;

	/**
	 * The number of structural features of the '<em>Message</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.kermeta.sintaks.trace.impl.ReferenceImpl <em>Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.kermeta.sintaks.trace.impl.ReferenceImpl
	 * @see org.kermeta.sintaks.trace.impl.TracePackageImpl#getReference()
	 * @generated
	 */
	int REFERENCE = 3;

	/**
	 * The number of structural features of the '<em>Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.kermeta.sintaks.trace.impl.TextReferenceImpl <em>Text Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.kermeta.sintaks.trace.impl.TextReferenceImpl
	 * @see org.kermeta.sintaks.trace.impl.TracePackageImpl#getTextReference()
	 * @generated
	 */
	int TEXT_REFERENCE = 4;

	/**
	 * The feature id for the '<em><b>Line Begin At</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_REFERENCE__LINE_BEGIN_AT = REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Char Begin At</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_REFERENCE__CHAR_BEGIN_AT = REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Line End At</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_REFERENCE__LINE_END_AT = REFERENCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Char End At</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_REFERENCE__CHAR_END_AT = REFERENCE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_REFERENCE__TEXT = REFERENCE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Text Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_REFERENCE_FEATURE_COUNT = REFERENCE_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.kermeta.sintaks.trace.impl.ModelReferenceImpl <em>Model Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.kermeta.sintaks.trace.impl.ModelReferenceImpl
	 * @see org.kermeta.sintaks.trace.impl.TracePackageImpl#getModelReference()
	 * @generated
	 */
	int MODEL_REFERENCE = 5;

	/**
	 * The feature id for the '<em><b>Ref Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REFERENCE__REF_OBJECT = REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Model Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REFERENCE_FEATURE_COUNT = REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.kermeta.sintaks.trace.impl.FileReferenceImpl <em>File Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.kermeta.sintaks.trace.impl.FileReferenceImpl
	 * @see org.kermeta.sintaks.trace.impl.TracePackageImpl#getFileReference()
	 * @generated
	 */
	int FILE_REFERENCE = 6;

	/**
	 * The feature id for the '<em><b>Filename</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_REFERENCE__FILENAME = REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>File Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_REFERENCE_FEATURE_COUNT = REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.kermeta.sintaks.trace.State <em>State</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.kermeta.sintaks.trace.State
	 * @see org.kermeta.sintaks.trace.impl.TracePackageImpl#getState()
	 * @generated
	 */
	int STATE = 7;


	/**
	 * Returns the meta object for class '{@link org.kermeta.sintaks.trace.TraceModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see org.kermeta.sintaks.trace.TraceModel
	 * @generated
	 */
	EClass getTraceModel();

	/**
	 * Returns the meta object for the containment reference '{@link org.kermeta.sintaks.trace.TraceModel#getTrace <em>Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Trace</em>'.
	 * @see org.kermeta.sintaks.trace.TraceModel#getTrace()
	 * @see #getTraceModel()
	 * @generated
	 */
	EReference getTraceModel_Trace();

	/**
	 * Returns the meta object for class '{@link org.kermeta.sintaks.trace.Trace <em>Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trace</em>'.
	 * @see org.kermeta.sintaks.trace.Trace
	 * @generated
	 */
	EClass getTrace();

	/**
	 * Returns the meta object for the attribute '{@link org.kermeta.sintaks.trace.Trace#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State</em>'.
	 * @see org.kermeta.sintaks.trace.Trace#getState()
	 * @see #getTrace()
	 * @generated
	 */
	EAttribute getTrace_State();

	/**
	 * Returns the meta object for the containment reference '{@link org.kermeta.sintaks.trace.Trace#getSourceReference <em>Source Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Source Reference</em>'.
	 * @see org.kermeta.sintaks.trace.Trace#getSourceReference()
	 * @see #getTrace()
	 * @generated
	 */
	EReference getTrace_SourceReference();

	/**
	 * Returns the meta object for the containment reference '{@link org.kermeta.sintaks.trace.Trace#getTargetReference <em>Target Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target Reference</em>'.
	 * @see org.kermeta.sintaks.trace.Trace#getTargetReference()
	 * @see #getTrace()
	 * @generated
	 */
	EReference getTrace_TargetReference();

	/**
	 * Returns the meta object for the containment reference '{@link org.kermeta.sintaks.trace.Trace#getRuleReference <em>Rule Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Rule Reference</em>'.
	 * @see org.kermeta.sintaks.trace.Trace#getRuleReference()
	 * @see #getTrace()
	 * @generated
	 */
	EReference getTrace_RuleReference();

	/**
	 * Returns the meta object for the containment reference list '{@link org.kermeta.sintaks.trace.Trace#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Description</em>'.
	 * @see org.kermeta.sintaks.trace.Trace#getDescription()
	 * @see #getTrace()
	 * @generated
	 */
	EReference getTrace_Description();

	/**
	 * Returns the meta object for the containment reference list '{@link org.kermeta.sintaks.trace.Trace#getSubTraces <em>Sub Traces</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Traces</em>'.
	 * @see org.kermeta.sintaks.trace.Trace#getSubTraces()
	 * @see #getTrace()
	 * @generated
	 */
	EReference getTrace_SubTraces();

	/**
	 * Returns the meta object for class '{@link org.kermeta.sintaks.trace.Message <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Message</em>'.
	 * @see org.kermeta.sintaks.trace.Message
	 * @generated
	 */
	EClass getMessage();

	/**
	 * Returns the meta object for the attribute '{@link org.kermeta.sintaks.trace.Message#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.kermeta.sintaks.trace.Message#getText()
	 * @see #getMessage()
	 * @generated
	 */
	EAttribute getMessage_Text();

	/**
	 * Returns the meta object for class '{@link org.kermeta.sintaks.trace.Reference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference</em>'.
	 * @see org.kermeta.sintaks.trace.Reference
	 * @generated
	 */
	EClass getReference();

	/**
	 * Returns the meta object for class '{@link org.kermeta.sintaks.trace.TextReference <em>Text Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Text Reference</em>'.
	 * @see org.kermeta.sintaks.trace.TextReference
	 * @generated
	 */
	EClass getTextReference();

	/**
	 * Returns the meta object for the attribute '{@link org.kermeta.sintaks.trace.TextReference#getLineBeginAt <em>Line Begin At</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line Begin At</em>'.
	 * @see org.kermeta.sintaks.trace.TextReference#getLineBeginAt()
	 * @see #getTextReference()
	 * @generated
	 */
	EAttribute getTextReference_LineBeginAt();

	/**
	 * Returns the meta object for the attribute '{@link org.kermeta.sintaks.trace.TextReference#getCharBeginAt <em>Char Begin At</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Char Begin At</em>'.
	 * @see org.kermeta.sintaks.trace.TextReference#getCharBeginAt()
	 * @see #getTextReference()
	 * @generated
	 */
	EAttribute getTextReference_CharBeginAt();

	/**
	 * Returns the meta object for the attribute '{@link org.kermeta.sintaks.trace.TextReference#getLineEndAt <em>Line End At</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line End At</em>'.
	 * @see org.kermeta.sintaks.trace.TextReference#getLineEndAt()
	 * @see #getTextReference()
	 * @generated
	 */
	EAttribute getTextReference_LineEndAt();

	/**
	 * Returns the meta object for the attribute '{@link org.kermeta.sintaks.trace.TextReference#getCharEndAt <em>Char End At</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Char End At</em>'.
	 * @see org.kermeta.sintaks.trace.TextReference#getCharEndAt()
	 * @see #getTextReference()
	 * @generated
	 */
	EAttribute getTextReference_CharEndAt();

	/**
	 * Returns the meta object for the attribute '{@link org.kermeta.sintaks.trace.TextReference#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.kermeta.sintaks.trace.TextReference#getText()
	 * @see #getTextReference()
	 * @generated
	 */
	EAttribute getTextReference_Text();

	/**
	 * Returns the meta object for class '{@link org.kermeta.sintaks.trace.ModelReference <em>Model Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Reference</em>'.
	 * @see org.kermeta.sintaks.trace.ModelReference
	 * @generated
	 */
	EClass getModelReference();

	/**
	 * Returns the meta object for the reference '{@link org.kermeta.sintaks.trace.ModelReference#getRefObject <em>Ref Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ref Object</em>'.
	 * @see org.kermeta.sintaks.trace.ModelReference#getRefObject()
	 * @see #getModelReference()
	 * @generated
	 */
	EReference getModelReference_RefObject();

	/**
	 * Returns the meta object for class '{@link org.kermeta.sintaks.trace.FileReference <em>File Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File Reference</em>'.
	 * @see org.kermeta.sintaks.trace.FileReference
	 * @generated
	 */
	EClass getFileReference();

	/**
	 * Returns the meta object for the attribute '{@link org.kermeta.sintaks.trace.FileReference#getFilename <em>Filename</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Filename</em>'.
	 * @see org.kermeta.sintaks.trace.FileReference#getFilename()
	 * @see #getFileReference()
	 * @generated
	 */
	EAttribute getFileReference_Filename();

	/**
	 * Returns the meta object for enum '{@link org.kermeta.sintaks.trace.State <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>State</em>'.
	 * @see org.kermeta.sintaks.trace.State
	 * @generated
	 */
	EEnum getState();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TraceFactory getTraceFactory();

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
		 * The meta object literal for the '{@link org.kermeta.sintaks.trace.impl.TraceModelImpl <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.kermeta.sintaks.trace.impl.TraceModelImpl
		 * @see org.kermeta.sintaks.trace.impl.TracePackageImpl#getTraceModel()
		 * @generated
		 */
		EClass TRACE_MODEL = eINSTANCE.getTraceModel();

		/**
		 * The meta object literal for the '<em><b>Trace</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE_MODEL__TRACE = eINSTANCE.getTraceModel_Trace();

		/**
		 * The meta object literal for the '{@link org.kermeta.sintaks.trace.impl.TraceImpl <em>Trace</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.kermeta.sintaks.trace.impl.TraceImpl
		 * @see org.kermeta.sintaks.trace.impl.TracePackageImpl#getTrace()
		 * @generated
		 */
		EClass TRACE = eINSTANCE.getTrace();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACE__STATE = eINSTANCE.getTrace_State();

		/**
		 * The meta object literal for the '<em><b>Source Reference</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE__SOURCE_REFERENCE = eINSTANCE.getTrace_SourceReference();

		/**
		 * The meta object literal for the '<em><b>Target Reference</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE__TARGET_REFERENCE = eINSTANCE.getTrace_TargetReference();

		/**
		 * The meta object literal for the '<em><b>Rule Reference</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE__RULE_REFERENCE = eINSTANCE.getTrace_RuleReference();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE__DESCRIPTION = eINSTANCE.getTrace_Description();

		/**
		 * The meta object literal for the '<em><b>Sub Traces</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE__SUB_TRACES = eINSTANCE.getTrace_SubTraces();

		/**
		 * The meta object literal for the '{@link org.kermeta.sintaks.trace.impl.MessageImpl <em>Message</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.kermeta.sintaks.trace.impl.MessageImpl
		 * @see org.kermeta.sintaks.trace.impl.TracePackageImpl#getMessage()
		 * @generated
		 */
		EClass MESSAGE = eINSTANCE.getMessage();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MESSAGE__TEXT = eINSTANCE.getMessage_Text();

		/**
		 * The meta object literal for the '{@link org.kermeta.sintaks.trace.impl.ReferenceImpl <em>Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.kermeta.sintaks.trace.impl.ReferenceImpl
		 * @see org.kermeta.sintaks.trace.impl.TracePackageImpl#getReference()
		 * @generated
		 */
		EClass REFERENCE = eINSTANCE.getReference();

		/**
		 * The meta object literal for the '{@link org.kermeta.sintaks.trace.impl.TextReferenceImpl <em>Text Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.kermeta.sintaks.trace.impl.TextReferenceImpl
		 * @see org.kermeta.sintaks.trace.impl.TracePackageImpl#getTextReference()
		 * @generated
		 */
		EClass TEXT_REFERENCE = eINSTANCE.getTextReference();

		/**
		 * The meta object literal for the '<em><b>Line Begin At</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXT_REFERENCE__LINE_BEGIN_AT = eINSTANCE.getTextReference_LineBeginAt();

		/**
		 * The meta object literal for the '<em><b>Char Begin At</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXT_REFERENCE__CHAR_BEGIN_AT = eINSTANCE.getTextReference_CharBeginAt();

		/**
		 * The meta object literal for the '<em><b>Line End At</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXT_REFERENCE__LINE_END_AT = eINSTANCE.getTextReference_LineEndAt();

		/**
		 * The meta object literal for the '<em><b>Char End At</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXT_REFERENCE__CHAR_END_AT = eINSTANCE.getTextReference_CharEndAt();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXT_REFERENCE__TEXT = eINSTANCE.getTextReference_Text();

		/**
		 * The meta object literal for the '{@link org.kermeta.sintaks.trace.impl.ModelReferenceImpl <em>Model Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.kermeta.sintaks.trace.impl.ModelReferenceImpl
		 * @see org.kermeta.sintaks.trace.impl.TracePackageImpl#getModelReference()
		 * @generated
		 */
		EClass MODEL_REFERENCE = eINSTANCE.getModelReference();

		/**
		 * The meta object literal for the '<em><b>Ref Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_REFERENCE__REF_OBJECT = eINSTANCE.getModelReference_RefObject();

		/**
		 * The meta object literal for the '{@link org.kermeta.sintaks.trace.impl.FileReferenceImpl <em>File Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.kermeta.sintaks.trace.impl.FileReferenceImpl
		 * @see org.kermeta.sintaks.trace.impl.TracePackageImpl#getFileReference()
		 * @generated
		 */
		EClass FILE_REFERENCE = eINSTANCE.getFileReference();

		/**
		 * The meta object literal for the '<em><b>Filename</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_REFERENCE__FILENAME = eINSTANCE.getFileReference_Filename();

		/**
		 * The meta object literal for the '{@link org.kermeta.sintaks.trace.State <em>State</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.kermeta.sintaks.trace.State
		 * @see org.kermeta.sintaks.trace.impl.TracePackageImpl#getState()
		 * @generated
		 */
		EEnum STATE = eINSTANCE.getState();

	}

} //tracePackage
