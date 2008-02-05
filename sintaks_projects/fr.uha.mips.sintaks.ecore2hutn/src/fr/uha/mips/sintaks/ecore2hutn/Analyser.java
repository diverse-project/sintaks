/* 
 * Project: sintaks
 * File: Analyser.java
 * License: EPL
 * Copyright: MIPS / Universite de Haute Alsace
 * ----------------------------------------------------------------------------
 * Creation date: Dec 24, 2007
 * Major update : Feb  5, 2008
 * Authors: 
 * 			Michel Hassenforder
 */
package fr.uha.mips.sintaks.ecore2hutn;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.kermeta.sintaks.sts.Alternative;
import org.kermeta.sintaks.sts.CustomCond;
import org.kermeta.sintaks.sts.Iteration;
import org.kermeta.sintaks.sts.ObjectReference;
import org.kermeta.sintaks.sts.PolymorphicCond;
import org.kermeta.sintaks.sts.Root;
import org.kermeta.sintaks.sts.Rule;
import org.kermeta.sintaks.sts.RuleRef;
import org.kermeta.sintaks.sts.Sequence;
import org.kermeta.sintaks.sts.StsFactory;
import org.kermeta.sintaks.sts.Template;
import org.kermeta.sintaks.sts.Terminal;
import org.kermeta.sintaks.sts.Value;

public class Analyser {

	private Root pattern;
	private Root currentModel;
	private EPackage rootPackage;
	private int uniqId;
	private String prefix;
	private ModelObserver observer;
	private List<Todo> todoList;
	private boolean allowAdjectives;
	private String startClassName;
	
	public Analyser(String startClassName, boolean allowAdjectives) {
		super();
		this.startClassName = startClassName;
		this.allowAdjectives = allowAdjectives;
		this.uniqId=0;
		this.prefix="separator";

		ResourceSet resSet = new ResourceSetImpl();
		Resource inputResource = resSet.getResource(URI.createPlatformPluginURI("/fr.uha.mips.sintaks.ecore2hutn/Templates.sts", false), true);
		pattern = (Root) inputResource.getContents().get(0);
	}

    /**
     * Entry point, it analyses the input model and create the hutn like output model written in sintaks.
     * The main task is done by method packageAnalyses()
     * 
     * @param inputRoot EObject
     * @return Root
     */
	public Root analyses(EObject inputRoot) {
		if ( ! (inputRoot instanceof EPackage)) return null;
		rootPackage = (EPackage) inputRoot;
		todoList = new ArrayList<Todo> (5);
		currentModel = StsFactory.eINSTANCE.createRoot();
		observer = new ModelObserver ();
    	observer.setTarget(currentModel);
    	currentModel.eAdapters().add(observer);
		packageAnalyses (rootPackage);
		currentModel.setStart(findRule(startClassName));
		return currentModel;
	} 

    /**
     * Internal method used to find a sintaks fragment given its id
     * Returns the rule or null
     * 
     * @param id String
     * @return Rule
     */
	private Rule findRule (String id) {
		if (id == null) return null;
		for (Rule rule : currentModel.getFragments()) {
			if (id.equals(rule.getId()))
				return rule;
		}
		return null;
	}

    /**
     * Iterates over a package to analyse classifiers of sub packages
     * 
     * @param aPackage EPackage
     */
	private void packageAnalyses(EPackage aPackage) {
		for (EClassifier classifier : aPackage.getEClassifiers()) { 
			classifierAnalyses (classifier);
		}
		for (EPackage subPackage : aPackage.getESubpackages()) {
			packageAnalyses (subPackage);
		}
	}

    /**
     * Analyses a classifier, process only EClasses which are not interfaces
     * In case of concrete class it calls method createConcreteClass() 
     * In case of abstract class it calls method createAbstractClass() 
     * 
     * 
     * @param classifier EClassifier
     */
	private void classifierAnalyses(EClassifier classifier) {
		if (classifier instanceof EClass) {
			EClass aClass = ((EClass) classifier);
			if (! aClass.isInterface()) {
				if (aClass.isAbstract()) {
					currentModel.getFragments().add(createAbstractClass (aClass));
				}else {
					currentModel.getFragments().add(createConcreteClass (aClass));
				}
			}
		}
		// nothing todo should be used by the converters
		if (classifier instanceof EDataType) ;
		// nothing todo should be used by the converters
		if (classifier instanceof EEnum) ;
	}
	
    /**
     * return if the structuralFeature could have a concrete representation
     * derived, transient or volatile feature should not have concrete representation
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

    /**
     * Internal method to create an id for a rule fragment
     * 
     * @param prefixe String
     * @param suffixe String
     * @return String
     */
	private String createRuleId (String prefixe, String suffixe) {
		StringBuffer tmp = new StringBuffer ();
		tmp.append(prefixe);
		tmp.append("_");
		tmp.append(suffixe);
		return tmp.toString();
	}

    /**
     * Internal method to create a uniq id for a rule fragment
     * 
     * @return String
     */
	private String createUniqName () {
		StringBuffer tmp = new StringBuffer ();
		tmp.append(prefix);
		tmp.append(++uniqId);
		return tmp.toString();
	}

    /**
     * Lookup a class inthe inputModel to locate an Id attribute
     * If ecore locate one it is fine else I choose the first attribute if it exists
     * 
     * @param aClass EClass
     * @return EStructuralFeature
     */
	private EStructuralFeature findIdFeature (EClass aClass) {
		EAttribute id = aClass.getEIDAttribute();
		if (id != null) return id;
		EList<EAttribute> allAttributes = aClass.getEAllAttributes();
		if (! allAttributes.isEmpty()) return allAttributes.get(0);
		return null;
	}

	private EObject findPattern (String name) {
		for (Rule r : pattern.getFragments()) {
			if (name.equals(r.getId()))
				return r;
		}
		return null;
	}

	private void patchRules (EObject sequence, EStructuralFeature feature) {
		TreeIterator<EObject> i = sequence.eAllContents();
		while (i.hasNext()) {
			EObject object = i.next();
			if (object instanceof Rule) {
				Rule r = (Rule) object;
				if ("#".equals(r.getId())) r.setId(createUniqName());
				if ("R".equals(r.getId())) r.setId(createRuleId (feature.getEContainingClass().getName(), feature.getName()));
				if ("N".equals(r.getId())) {
					r.setId(null);
					if (r instanceof Terminal) ((Terminal) r).setTerminal(feature.getName());
				}
				if ("F".equals(r.getId())) {
					r.setId(null);
					if (r instanceof Iteration) ((Iteration) r).setContainer(feature);
					if (r instanceof Value) ((Value) r).getFeatures().add(feature);
					if (r instanceof ObjectReference) ((ObjectReference) r).setIdentifier(findIdFeature (((EReference)feature).getEReferenceType()));
					if (r instanceof RuleRef) todoList.add (new Todo ((RuleRef) r, ((EReference)feature).getEReferenceType().getName()));
				}
				if ("I".equals(r.getId())) {
					r.setId(null);
					if (r instanceof ObjectReference) ((ObjectReference) r).setIdentifier(findIdFeature (((EReference)feature).getEReferenceType()));
					if (r instanceof RuleRef) todoList.add (new Todo ((RuleRef) r, ((EReference)feature).getEReferenceType().getName()));
				}
				if ("S".equals(r.getId())) {
					r.setId(null);
					if (r instanceof RuleRef) todoList.add (new Todo ((RuleRef) r, createRuleId (feature.getEContainingClass().getName(), feature.getName())));
				}
			}
			if (object instanceof CustomCond) ((CustomCond) object).setFeature(feature);
		}
	}

	private void patchRules (EObject sequence, EClass aClass) {
		TreeIterator<EObject> i = sequence.eAllContents();
		while (i.hasNext()) {
			EObject object = i.next();
			if (object instanceof Rule) {
				Rule r = (Rule) object;
				if ("R".equals(r.getId())) r.setId(aClass.getName());
				if ("N".equals(r.getId())) {
					r.setId(null);
					if (r instanceof Terminal) ((Terminal) r).setTerminal(aClass.getName());
				}
				if ("F".equals(r.getId())) {
					r.setId(null);
					if (r instanceof RuleRef) todoList.add (new Todo ((RuleRef) r, aClass.getName()));
				}
			}
			if (object instanceof PolymorphicCond) ((PolymorphicCond) object).setMetaclass(aClass);
			if (object instanceof Template) ((Template) object).setMetaclass(aClass);
		}
	}

	private Rule dispatchRules (EObject rules) {
		Sequence sequence = (Sequence) rules;
		for (int j=1; j < sequence.getSubRules().size();++j) {
			currentModel.getFragments().add(sequence.getSubRules().get(j));
		}
		if (sequence.getSubRules().size() >= 1) return sequence.getSubRules().get(0);
		return null;
	}
	
	private Rule processPattern (String patternName) {
		if (patternName == null) return null;
		EObject localPattern = findPattern (patternName);
		EObject localCopy = org.eclipse.emf.ecore.util.EcoreUtil.copy(localPattern);
		return dispatchRules (localCopy);
	}
	
	private Rule processPattern (String patternName, EStructuralFeature feature) {
		if (patternName == null) return null;
		EObject localPattern = findPattern (patternName);
		EObject localCopy = org.eclipse.emf.ecore.util.EcoreUtil.copy(localPattern);
		patchRules (localCopy, feature);
		return dispatchRules (localCopy);
	}
	
	private Rule processPattern (String patternName, EClass aClass) {
		if (patternName == null) return null;
		EObject localPattern = findPattern (patternName);
		EObject localCopy = org.eclipse.emf.ecore.util.EcoreUtil.copy(localPattern);
		patchRules (localCopy, aClass);
		return dispatchRules (localCopy);
	}
	
    /**
     * InternalMethod used to choose the best way to represent an attribute
     * If the attribute belong to the current class we use the adjectiveAttributePattern
     * else we create a RuleRef to the fragment created by the mother class
     * 
     * @param attribute EAttribute
     * @param mother EClass 
     * @return Rule
     */
	private Rule adjectiveAttributeAnalyses (EAttribute attribute, EClass mother) {
		EClass container = attribute.getEContainingClass();
		if (container == mother) {
			return processPattern ("adjectiveAttribute", attribute);
		} else {
			return processPattern ("sharedFeature", attribute);
		}
	}
	
    /**
     * InternalMethod used to choose the best way to represent an attribute
     * If the attribute belong to the current class we use the fragmentAttributePattern
     * else we create a RuleRef to the fragment created by the mother class
     * 
     * @param attribute EAttribute
     * @param mother EClass 
     * @return Rule
     */
	private Rule fragmentAttributeAnalyses (EAttribute attribute, EClass mother) {
		EClass container = attribute.getEContainingClass();
		if (container == mother) {
			return processPattern ("fragmentAttribute", attribute);
		} else {
			return processPattern ("sharedFeature", attribute);
		}
	}
	
    /**
     * InternalMethod used to choose the best way to represent a structuralFeature
     * If the feature belong to the current class
     *    if it is a single value attribute and adjectives allowed use the singleAttributePattern
     *    if it is a single value attribute and adjectives not allowed do nothing
     *    if it is a multi value attribute use the multipleAttributePattern
     *    if it is a single value containment use the singleContainmentPattern
     *    if it is a multi value containment use the multipleContainmentPattern
     *    if it is a single value reference but opposite is a containment do nothing
     *    if it is a single value reference use singleReferencePattern
     *    if it is a multi value attribute use multipleReferencePattern
     * If the feature belong to a mother class
     *    create a RuleRef to the target fragment
     *  
     * @param attribute EAttribute
     * @param mother EClass 
     * @return Rule
     */
	private Rule contentFeatureAnalyses (EStructuralFeature feature, EClass mother) {
		EClass container = feature.getEContainingClass();
		if (container == mother) {
			String patternName = null;
			if (feature instanceof EAttribute) {
				if (feature.isMany()) patternName = "multipleAttribute";
				else if (! allowAdjectives) patternName="singleAttribute";
			}
			if (feature instanceof EReference) {
				EReference reference = (EReference) feature;
				if (reference.isContainment()) {
					if (reference.isMany()) patternName = "multipleContainment";
					else patternName = "singleContainment";
				} else {
					if (! reference.isContainer()) {
						if (reference.isMany()) patternName = "multipleReference";
						else patternName = "singleReference";
					}
				}
			}
			return processPattern (patternName, feature);
		} else {
			return processPattern ("sharedFeature", feature);
		}
	}
	
    /**
     * InternalMethod used to extract from a class all features usable as adjectives
     * the clue is : attribute, single value, real, modifiable and not the id attribute of the class
     * 
     * @param aClass EClass
     * @return List<EAttribute>
     */
	private List<EAttribute> extractAdjectives (EClass aClass) {
		List<EAttribute> adjectives = new ArrayList<EAttribute> ();
		EStructuralFeature featureId = findIdFeature (aClass);
		for (EAttribute attribute : aClass.getEAllAttributes()) { 
			if ( ! shouldBeProcessed(attribute)) continue;
			if ( featureId == attribute) continue;
			if ( ! attribute.isMany()) adjectives.add(attribute);
		}
		return adjectives;
	}
	
    /**
     * InternalMethod used to extract from a class all features usable as content
     * the clue is :
     *    for single value attribute : if adjective not allowed, real, modifiable and not the id attribute of the class
     *    for multi value adjective : real and modifiable
     *    all real and modifiable eReferences
     * 
     * @param aClass EClass
     * @return List<EAttribute>
     */
	private List<EStructuralFeature> extractContent (EClass aClass) {
		List<EStructuralFeature> content = new ArrayList <EStructuralFeature> ();
		for (EReference reference : aClass.getEAllReferences()) { 
			if ( ! shouldBeProcessed(reference)) continue;
			if (reference.isContainment() || ! reference.isContainer()) content.add(reference);
		}
		if (allowAdjectives) {
			for (EAttribute attribute : aClass.getEAllAttributes()) { 
				if ( ! shouldBeProcessed(attribute)) continue;
				if (attribute.isMany()) content.add(attribute);
			}
		} else {
			EStructuralFeature featureId = findIdFeature (aClass);
			for (EAttribute attribute : aClass.getEAllAttributes()) { 
				if ( ! shouldBeProcessed(attribute)) continue;
				if ( featureId == attribute) continue;
				content.add(attribute);
			}
		}
		return content;
	}

    /**
     * InternalMethod used to create the template associated to a concrete Class
     * The Template is the following :
     *    class.name idAttribute '(' <rulesforAdjective_if_allowed> ')' contentRule 'eoln'
     * contentRule is ';' is there is no content
     * contentRule is '{' rulesforContent 'eoln' '}' is there is content
     * 
     * @param aClass EClass
     * @return List<EAttribute>
     */
	private Rule createConcreteClass (EClass aClass) {
		Template template = (Template) processPattern ("concretClass", aClass);
		Sequence sequence = (Sequence) template.getRule();
		Rule beginClassRule = processPattern ("beginClass", aClass);
		if (beginClassRule != null) sequence.getSubRules().add(beginClassRule);
		EStructuralFeature featureId = findIdFeature (aClass);
		if (featureId != null) {
			Rule rule = processPattern ("classID", featureId);
			if (rule != null) sequence.getSubRules().add(rule);
		}
		if (allowAdjectives) {
			List<EAttribute> adjectives = extractAdjectives (aClass);
			if ( ! adjectives.isEmpty()) {
				Rule beginRule = processPattern ("beginAdjectives");
				if (beginRule != null) sequence.getSubRules().add(beginRule);
				Rule beforeRule = processPattern ("beforeAdjective");
				Rule afterRule = processPattern ("afterAdjective");
				for (EAttribute attribute : adjectives) {
					Rule rule = adjectiveAttributeAnalyses (attribute, aClass);
					if (rule != null) {
						if (beforeRule != null) sequence.getSubRules().add(beforeRule);
						sequence.getSubRules().add(rule);
						if (afterRule != null) sequence.getSubRules().add(afterRule);
					}
				}
				Rule endRule = processPattern ("endAdjectives");
				if (endRule != null) sequence.getSubRules().add(endRule);
			}
		}
		List<EStructuralFeature> content = extractContent (aClass);
		if (! content.isEmpty()) {
			Rule beginRule = processPattern ("beginContent");
			if (beginRule != null) sequence.getSubRules().add(beginRule);
			Rule beforeRule = processPattern ("beforeContent");
			Rule afterRule = processPattern ("afterContent");
			for (EStructuralFeature feature : content) { 
				Rule rule = contentFeatureAnalyses (feature, aClass);
				if (rule != null) {
					if (beforeRule != null) sequence.getSubRules().add(beforeRule);
					sequence.getSubRules().add(rule);
					if (afterRule != null) sequence.getSubRules().add(afterRule);
				}
			}
			Rule endRule = processPattern ("endContent");
			if (endRule != null) sequence.getSubRules().add(endRule);
		} else {
			Rule rule = processPattern ("emptyContent");
			if (rule != null) sequence.getSubRules().add(rule);
		}
		Rule endClassRule = processPattern ("endClass", aClass);
		if (endClassRule != null) sequence.getSubRules().add(endClassRule);
		return template;
	}

    /**
     * InternalMethod used to create the template associated to an abstract Class
     * The Template is just an alternative owning a list of Polymorphic condition over all subClasses
     * For each structural feature a fragment is created (called by child concrete classes)
     * 
     * @param aClass EClass
     * @return Rule
     */
	private Rule createAbstractClass (EClass aClass) {
		if (allowAdjectives) {
			List<EAttribute> adjectives = extractAdjectives (aClass);
			for (EAttribute attribute : adjectives) {
				Rule fragment = fragmentAttributeAnalyses (attribute, aClass);
				if (fragment != null) {
					if (fragment != null) currentModel.getFragments().add (fragment);
				}
			}
		}
		List<EStructuralFeature> content = extractContent (aClass);
		for (EStructuralFeature feature : content) { 
			Rule fragment = contentFeatureAnalyses (feature, aClass);
			if (fragment != null) currentModel.getFragments().add (fragment);
		}
		Alternative alternative = (Alternative) processPattern ("abstractClass", aClass);
		List<EClass> concreteClasses = getDescendantConcreteClasses (rootPackage, aClass);
		for (EClass concreteClass : concreteClasses) {
			Rule rule = processPattern ("inheritance", concreteClass);
			if (rule != null) alternative.getConditions().add(((Alternative) rule).getConditions().get(0));
		}
		return alternative;
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
			if (aClass.isAbstract()) continue;
			if (aClass.isInterface()) continue;
			if ( ! aClass.getEAllSuperTypes().contains(mother)) continue;
			concreteClasses.add(aClass);
		}
		for (EPackage subPackage : aPackage.getESubpackages()) {
			concreteClasses.addAll(getDescendantConcreteClasses (subPackage, mother));
		}
		return concreteClasses;
	}

    /**
     * ModelObserver observes the sintaks model and try each time the model change to resolve references in the todoList
     * 
     */
	public class ModelObserver implements Adapter {

		private Notifier target;
		
		public Notifier getTarget() {
			return target;
		}

		public boolean isAdapterForType(Object arg0) {
			return (arg0 instanceof Notifier);
		}

		public void notifyChanged(Notification arg0) {
			if (arg0.getEventType() == Notification.ADD || arg0.getEventType() == Notification.ADD_MANY || arg0.getEventType() == Notification.SET ) {
				List<Todo> oldTodoList = todoList;
				todoList = new ArrayList<Todo> (oldTodoList.size());
				for (Todo todo : oldTodoList) {
					Rule target = findRule (todo.getId());
					if (target != null) {
						todo.getRuleRef().setRef(target);
					} else {
						todoList.add(todo);
					}
				}
			}
		}

		public void setTarget(Notifier arg0) {
			this.target = arg0;
		}
		
	}
	
	public class Todo {

		private RuleRef ruleRef;
		private String id;
		
		public Todo(RuleRef ruleRef, String id) {
			super();
			this.ruleRef = ruleRef;
			this.id = id;
		}

		public RuleRef getRuleRef() {
			return ruleRef;
		}

		public String getId() {
			return id;
		}


	}
}
