/* 
 * Project: sintaks
 * File: StsgenCreator.java
 * License: EPL
 * Copyright: MIPS / Universite de Haute Alsace
 * ----------------------------------------------------------------------------
 * Creation date: Feb  5, 2008
 * Authors: 
 * 			Michel Hassenforder
 * Note:
 * 
 *  This class reads an ecore file and create the a sintaks genmodel file.
 *  The idea is to create ASAP an editable sintaks genmodel file.
 *  
 */
package fr.uha.mips.sintaks.ecore2hutn;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import fr.uha.mips.sintaks.stsgen.StsGenClass;
import fr.uha.mips.sintaks.stsgen.StsGenFeature;
import fr.uha.mips.sintaks.stsgen.StsGenRoot;
import fr.uha.mips.sintaks.stsgen.StsgenFactory;
import fr.uha.mips.sintaks.stsgen.Type;

public class StsgenCreator {

	private EPackage rootPackage;
	private StsGenRoot currentModel;
	private boolean allowAdjectives;
	private boolean before;
	private boolean protectionRules [];
	private String startClassName;
	private List<Link> links;
	
    /**
     * The provider gives some hints to customize the generation of the sintaks genmodel file:
     *    - the startClassName, the enclosing concept of all the stuff in the file
     *    - allowing of adjectives and their position (before or after the name/id of a class)
     *    - request or not the protection pattern for the different concept
     * The hints are globals and should be the best choice
     * 
     * @param input URI
     * @param output URI
     * @param startClassName String
     * @param allowAdjectives boolean
     * @param before boolean
     * @param protections boolean[7]
     */
	public StsgenCreator (String startClassName, boolean allowAdjectives, boolean before, boolean protectionRules []) {
		super();
		this.startClassName = startClassName;
		this.allowAdjectives = allowAdjectives;
		this.before = before;
		if (protectionRules == null || protectionRules.length != 7) {
			this.protectionRules = new boolean [] { false, false, false, true, false, true, false };
		} else {
			this.protectionRules = protectionRules;
		}
		links = new ArrayList<Link> (10);
	}

    /**
     * Entry point, it analyses the input model and create the sintaks generator model
     * The main task is done by method packageAnalyses()
     * 
     * @param inputRoot EObject
     * @return StsGenRoot
     */
	public StsGenRoot analyses(EObject inputRoot) {
		if ( ! (inputRoot instanceof EPackage)) return null;
		rootPackage = (EPackage) inputRoot;
		currentModel = StsgenFactory.eINSTANCE.createStsGenRoot();
		currentModel.setRootPackage(rootPackage);
		packageAnalyses (rootPackage);
		currentModel.setStartClass(findStsGenClass(findClass(startClassName)));
		this.linkReferences();
		return currentModel;
	} 

    /**
     * Internal method used to find a StsGenClass targeting a given EClass
	 * The package is not relevant ... It is bad idea.
     * Returns the StsGenClass or null
     * 
     * @param targetClass EClass
     * @return StsGenClass
     */
	private StsGenClass findStsGenClass (EClass targetClass) {
		if (targetClass == null) return null;
		for (StsGenClass aClass : currentModel.getGenClasses()) {
			if (aClass.getTargetClass() == targetClass)
				return aClass;
		}
		return null;
	}

    /**
     * Internal method used to find a EClass of a given name
	 * The package is not relevant ... It is bad idea.
     * Returns the EClass or null
     * 
     * @param id String
     * @return Rule
     */
	private EClass findClass (String startClassName) {
		if (startClassName == null) return null;
		TreeIterator<EObject> i = rootPackage.eAllContents();
        while (i.hasNext()) {
        	EObject eo = i.next();
        	if (eo instanceof EClass) {
        		EClass ec = (EClass) eo;
        		if (startClassName.equals(ec.getName()))
        			return ec;
        	}
        }
		return null;
	}

    /**
     * Lookup a StsGenClass about an ID attribute
     * 
     * @param stsGenClass EClass
     * @return StsGenFeature
     */
	private StsGenFeature findIdFeature (StsGenClass subject) {
		if (subject == null) return null;
		for (StsGenFeature feature : subject.getGenFeatures()) {
			if (feature.isNotUsed()) continue;
			if (feature.getType().getValue() == Type.ID_VALUE)
				return feature;
		}
		return null;
	}

	private void linkReferences () {
		for (Link link : links) {
			if (link.getFrom() instanceof StsGenClass) {
				StsGenClass from = (StsGenClass) link.getFrom();
				from.getGenSubClasses().add(findStsGenClass(link.getTo()));
			}
			if (link.getFrom() instanceof StsGenFeature) {
				StsGenFeature from = (StsGenFeature) link.getFrom();
				StsGenClass toClass = findStsGenClass(link.getTo());
				from.setKeyFeature(findIdFeature(toClass));
			}
		}
	}

	/**
     * Iterates over a package to analyse classifiers of sub packages
     * 
     * Two pass :
     *    1) look only about concrete or abstract EClasses
     *    2) look only about abstract EClasses to create the link to the concrete children
     *    
     * @param aPackage EPackage
     */
	private void packageAnalyses(EPackage aPackage) {
		for (EClassifier classifier : aPackage.getEClassifiers()) {
			if (classifier instanceof EClass) {
				EClass aClass = ((EClass) classifier);
				if (aClass.isInterface()) continue;
				StsGenClass genClass = createClass (aClass);
				currentModel.getGenClasses().add(genClass);
				if (aClass.isAbstract()) {
					List<EClass> concreteClasses = getDescendantConcreteClasses (rootPackage, aClass);
					for (EClass concreteClass : concreteClasses) {
						links.add(new Link (genClass, concreteClass));
					}
				}
			}
		}
		for (EPackage subPackage : aPackage.getESubpackages()) {
			packageAnalyses (subPackage);
		}
	}

    /**
     * InternalMethod used to lookup the inputModel and extract all concrete subClasses of a given class
     * 
     * @param aPackage EPackage
     * @param mother EClass
     * @return List<EClass>
     */
	private List<EClass> getDescendantConcreteClasses (EPackage aPackage, EClass mother) {
		List<EClass> concreteClasses = new ArrayList<EClass>();
		for (EClassifier classifier : aPackage.getEClassifiers()) {
			if ( ! (classifier instanceof EClass)) continue;
			EClass aClass = (EClass) classifier;
			if (aClass.isInterface()) continue;
			if (aClass.isAbstract()) continue;
			if ( ! aClass.getEAllSuperTypes().contains(mother)) continue;
			concreteClasses.add(aClass);
		}
		for (EPackage subPackage : aPackage.getESubpackages()) {
			concreteClasses.addAll(getDescendantConcreteClasses (subPackage, mother));
		}
		return concreteClasses;
	}

	/**
     * InternalMethod used to create the sintaks genmodel associated to a EClass
     *    All usable features will be genmodeled as StsGenFeatures
     *    we remove inherited feature if we are abstract
     *    the shared attribute model the fact that the feature belong directly or not to the class
     * 
     * @param aClass EClass
     * @return StsGenClass
     */
	private StsGenClass createClass (EClass aClass) {
		StsGenClass genClass = StsgenFactory.eINSTANCE.createStsGenClass();
		genClass.setTargetClass(aClass);
		for (EStructuralFeature f : aClass.getEAllStructuralFeatures()) {
			if ( ! shouldBeProcessed (f)) continue;
			if (aClass.isAbstract() && f.eContainer() != aClass) continue;
			StsGenFeature genFeature = createFeature (f);
			genFeature.setShared(f.getEContainingClass() != aClass);
			genClass.getGenFeatures().add(genFeature);
		}
		return genClass;
	}

    /**
     * InternalMethod used to create the sintaks gen model associated to a EStructuralFeature
     * 
	 * For all features 
     *   + we set the protection as requested by user
	 *
     * In case of an EAttribute :
     * 	 + we look if it is the ID of class
     *   + if its cardinality is 1 and adjectives is allowed
     * 	 	+ we set it as AdjectiveBefore if it should be before the name/ID (HUTN but not safe)
     * 	 	+ we set it as AdjectiveAfter if it should be after the name/ID (safer)
     *   + otherwise we set it as Attribute
     * 
     * 
     * In case of an EReference :
     *   + we look about containment, if true we set it has CONTAINER
     *   + we look about container, if true we set it has REFERENCE
     *   + otherwise we remove it
     *   
     * @param feature EStructuralFeature
     * @return StsGenFeature
     */
	private StsGenFeature createFeature (EStructuralFeature feature) {
		StsGenFeature genFeature = StsgenFactory.eINSTANCE.createStsGenFeature();
		genFeature.setTargetFeature(feature);
		int protectionRuleID=0;
		if (feature instanceof EAttribute) {
			EAttribute attribute = (EAttribute) feature;
			if (attribute.isID()) genFeature.setType(Type.ID);
			else if (allowAdjectives && ! attribute.isMany()){
				genFeature.setType(before ? Type.ADJECTIVE_BEFORE : Type.ADJECTIVE_AFTER);
				protectionRuleID=6;
			} else {
				genFeature.setType(Type.ATTRIBUTE);
				if (attribute.isMany()) protectionRuleID=1;
				else protectionRuleID=0;
			}
		}
		if (feature instanceof EReference) {
			EReference reference = (EReference) feature;
			if (reference.isContainment()) {
				genFeature.setType(Type.CONTAINER);
				if (reference.isMany()) protectionRuleID=5;
				else protectionRuleID=4;
			} else {
				if (! reference.isContainer()) {
					genFeature.setType(Type.REFERENCE);
					links.add(new Link (genFeature, reference.getEReferenceType()));
					if (reference.isMany()) protectionRuleID=3;
					else protectionRuleID=2;
				} else {
					genFeature.setNotUsed(true);					
				}
			}
		}
		genFeature.setProtected(protectionRules [protectionRuleID]);
		return genFeature;
	}
	
	
    /**
     * return if the given structuralFeature could have a representation
     * Derived, transient or volatile feature should not have concrete representation
     * even none changeable feature don't have concrete representation
     * 
     * @param feature EStructuralFeature
     * @return boolean
     */
	private boolean shouldBeProcessed (EStructuralFeature feature) {
		if (! feature.isChangeable()) return false;
		if (feature.isDerived()) return false;
		if (feature.isTransient()) return false;
		if (feature.isVolatile()) return false;
		return true;
	}

}
