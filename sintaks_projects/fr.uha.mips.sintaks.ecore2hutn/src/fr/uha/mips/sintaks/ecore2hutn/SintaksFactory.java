/* 
 * Project: sintaks
 * File: SintaksFactory.java
 * License: EPL
 * Copyright: MIPS / Universite de Haute Alsace
 * ----------------------------------------------------------------------------
 * Creation date: Dec 24, 2007
 * Authors: 
 * 			Michel Hassenforder
 * Note:
 * 
 *  This class is a helper for the creation of all sintaks concepts required by an analyser.
 *  
 */
package fr.uha.mips.sintaks.ecore2hutn;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.kermeta.sintaks.sts.Adornment;
import org.kermeta.sintaks.sts.Alternative;
import org.kermeta.sintaks.sts.CustomCond;
import org.kermeta.sintaks.sts.Iteration;
import org.kermeta.sintaks.sts.ObjectReference;
import org.kermeta.sintaks.sts.PolymorphicCond;
import org.kermeta.sintaks.sts.PrimitiveValue;
import org.kermeta.sintaks.sts.Root;
import org.kermeta.sintaks.sts.RuleRef;
import org.kermeta.sintaks.sts.Sequence;
import org.kermeta.sintaks.sts.StsFactory;
import org.kermeta.sintaks.sts.Template;
import org.kermeta.sintaks.sts.Terminal;

public class SintaksFactory {

	private StsFactory factory;

	public SintaksFactory() {
		super();
		factory = StsFactory.eINSTANCE;
	}

    /**
     * Creates a sintaks Root class
     * 
     * @return Root
     */
	public Root createRoot () {
		Root model = factory.createRoot();
		return model;
	}

    /**
     * Creates a sintaks Template class mapped to a given eClass
     * 
     * @param aClass EClass
     * @return Template
     */
	public Template createTemplate (EClass aClass) {
		Template template = factory.createTemplate();
		template.setMetaclass(aClass);
		template.setId(aClass.getName());
		return template;
	}

    /**
     * Creates an empty sintaks Sequence class
     * 
     * @return Sequence
     */
	public Sequence createSequence () {
		Sequence sequence = factory.createSequence();
		return sequence;
	}
	
    /**
     * Creates a sintaks Terminal class acting as a simple multicharacters keyword
     * 
     * @param value String
     * @return Terminal
     */
	public Terminal createTerminal (String value) {
		Terminal terminal = factory.createTerminal();
		terminal.setTerminal(value);
		return terminal;
	}

    /**
     * Creates a sintaks Terminal class acting as a one character separator
     * 
     * @param value String
     * @return Terminal
     */
	public Terminal createSeparator(String value) {
		Terminal terminal = factory.createTerminal();
		terminal.setLexicalSeparator(true);
		terminal.setTerminal(value);
		return terminal;
	}

    /**
     * Creates a sintaks Adornment class mapped to a newline
     * 
     * @return Adornment
     */
	public Adornment createNewLine() {
		Adornment adornment = factory.createAdornment();
		adornment.setTerminal("eoln");
		return adornment;
	}

    /**
     * Creates a sintaks PrimitiveValue class mapped to a given structuralFeature
     * If the structuralFeature is a null value the PrimitiveValue is not mapped
     * 
     * @param feature EStructuralFeature
     * @return PrimitiveValue
     */
	public PrimitiveValue createPrimitiveValue(EStructuralFeature feature) {
		PrimitiveValue pv = factory.createPrimitiveValue();
		if (feature != null) pv.getFeatures().add(feature);
		return pv;
	}

    /**
     * Creates a sintaks Iteration class mapped to a given structuralFeature (should be a container)
     * 
     * @param feature EStructuralFeature
     * @return Iteration
     */
	public Iteration createIteration(EStructuralFeature feature) {
		Iteration iteration = factory.createIteration();
		iteration.setContainer(feature);
		return iteration;
	}

    /**
     * Creates a sintaks RuleRef class mapped to a given structuralFeature (should be a container)
     * If the structuralFeature is a null value the RuleRef is not mapped
     * 
     * @param reference EStructuralFeature
     * @return RuleRef
     */
	public RuleRef createRuleRef(EStructuralFeature reference) {
		RuleRef ruleRef = factory.createRuleRef();
		if (reference != null) ruleRef.getFeatures().add(reference);
		return ruleRef;
	}

    /**
     * Creates a sintaks ObjectReference class mapped to a given structuralFeature
     * If the structuralFeature is a null value the ObjectReference is not mapped
     * 
     * @param reference EReference
     * @return ObjectReference
     */
	public ObjectReference createObjectReference(EReference reference) {
		ObjectReference ruleRef = factory.createObjectReference();
		if (reference != null) ruleRef.getFeatures().add(reference);
		return ruleRef;
	}

    /**
     * Creates an empty sintaks Alternative class
     * 
     * @return Alternative
     */
	public Alternative createAlternative() {
		Alternative alternative = factory.createAlternative();
		return alternative;
	}

    /**
     * Creates a sintaks PolymorphicCond class mapped to a given eClass
     * By default the polymorphic condition checks against equality 
     * 
     * @param aClass EClass
     * @return PolymorphicCond
     */
	public PolymorphicCond createPolymorphicCondition(EClass aClass) {
		PolymorphicCond pc = factory.createPolymorphicCond();
		pc.setMetaclass(aClass);
		pc.setValue("equals");
		return pc;
	}

    /**
     * Creates a sintaks CustomCond class mapped to a given structuralFeature and value
      * 
     * @param feature EStructuralFeature
     * @param value String
     * @return CustomCond
     */
	public CustomCond createCustomCondition(EStructuralFeature feature, String value) {
		CustomCond cc = factory.createCustomCond();
		cc.setFeature(feature);
		cc.setValue(value);
		return cc;
	}
}
