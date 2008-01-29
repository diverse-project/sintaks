/* 
 * Project: sintaks
 * File: Analyser.java
 * License: EPL
 * Copyright: MIPS / Universite de Haute Alsace
 * ----------------------------------------------------------------------------
 * Creation date: Dec 24, 2007
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
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.kermeta.sintaks.sts.Alternative;
import org.kermeta.sintaks.sts.CustomCond;
import org.kermeta.sintaks.sts.Iteration;
import org.kermeta.sintaks.sts.ObjectReference;
import org.kermeta.sintaks.sts.PolymorphicCond;
import org.kermeta.sintaks.sts.Root;
import org.kermeta.sintaks.sts.Rule;
import org.kermeta.sintaks.sts.RuleRef;
import org.kermeta.sintaks.sts.Sequence;
import org.kermeta.sintaks.sts.Template;

public class Analyser {

	private SintaksFactory factory;
	private Root currentModel;
	private EPackage rootPackage;
	private int uniqId;
	private String separatorName;
	private ModelObserver observer;
	private List<Todo> todoList;
	private boolean allowAdjectives;
	private String startClassName;
	
	public Analyser(String startClassName, boolean allowAdjectives) {
		super();
		this.startClassName = startClassName;
		this.allowAdjectives = allowAdjectives;
		this.uniqId=0;
		this.separatorName="separator";
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
		factory = new SintaksFactory ();
		rootPackage = (EPackage) inputRoot;
		todoList = new ArrayList<Todo> (5);
		currentModel = factory.createRoot();
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
		tmp.append(separatorName);
		tmp.append(++uniqId);
		return tmp.toString();
	}

    /**
     * Internal method to create a RuleRef to a fragment identified by its id
     * Due to the fact that the target fragment could not be created yet, the
     * attachment is delayed in a todoList. Usually, an observer of the model
     * try to attached all RuleRef as soon as the target is append in the fragment List
     * 
     * @param feature EStructuralFeature
     * @param id String
     * @return Rule
     */
	private Rule createRuleRef (EStructuralFeature feature, String id) {
		RuleRef ruleRef = factory.createRuleRef (feature);
		todoList.add (new Todo (ruleRef, id));
		return ruleRef;
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

    /**
     * InternalMethod used to create the sintaks pattern associated to an attribute used as an adjective 
     * it is just a PrimitiveValue
     * 
     * @param attribute EAttribute
     * @return Rule
     */
	private Rule adjectiveAttributePattern (EAttribute attribute) {
		return factory.createPrimitiveValue(attribute);
	}
	
    /**
     * InternalMethod used to create the sintaks pattern associated to a shared attribute used as an adjective 
     * In this case, shared attribute means that the pattern (the whole sequence) will be a fragment
     * In the sequence there is only a PrimitiveValue
     * 
     * @param attribute EAttribute
     * @return Rule
     */
	private Rule fragmentAttributePattern (EAttribute attribute) {
		Sequence sequence = factory.createSequence();
		sequence.setId(createRuleId (attribute.getEContainingClass().getName(), attribute.getName()));
		sequence.getSubRules().add(factory.createPrimitiveValue(attribute));
		return sequence;
	}
	
    /**
     * InternalMethod used to create the sintaks pattern associated to a single value attribute 
     * The pattern is a sequence of : attribute.name '=' value ';'
     * 
     * @param attribute EAttribute
     * @return Rule
     */
	private Rule singleAttributePattern (EAttribute attribute) {
		Sequence sequence = factory.createSequence();
		sequence.setId(createRuleId (attribute.getEContainingClass().getName(), attribute.getName()));
		sequence.getSubRules().add(factory.createTerminal(attribute.getName()));
		sequence.getSubRules().add(factory.createSeparator("="));

		sequence.getSubRules().add(factory.createPrimitiveValue(attribute));

		sequence.getSubRules().add(factory.createSeparator(";"));
		return sequence;
	}

    /**
     * InternalMethod used to create the sintaks pattern associated to a multiple value attribute 
     * The pattern is a sequence of : attribute.name '=' '[' ( value ( ',' value) * )? '];'
     * 
     * @param attribute EAttribute
     * @return Rule
     */
	private Rule multipleAttributePattern (EAttribute attribute) {
		Sequence sequence = factory.createSequence();
		sequence.setId(createRuleId (attribute.getEContainingClass().getName(), attribute.getName()));
		sequence.getSubRules().add(factory.createTerminal(attribute.getName()));
		sequence.getSubRules().add(factory.createSeparator("="));

		sequence.getSubRules().add(factory.createSeparator("["));
		Rule separator = factory.createSeparator(",");
		separator.setId(createUniqName());
		currentModel.getFragments().add(separator);

		Iteration iteration = factory.createIteration (attribute);
		iteration.setSeparator(separator);
		iteration.setSubRule(factory.createPrimitiveValue(null));
		sequence.getSubRules().add(iteration);

		sequence.getSubRules().add(factory.createSeparator("]"));
		sequence.getSubRules().add(factory.createSeparator(";"));
		return sequence;
	}
	
    /**
     * InternalMethod used to create the sintaks pattern associated to a single value reference 
     * The pattern is an alternative composed by two CustomConditions
     * (1) : reference is filled 
     * (2) : reference is empty
     * 
     * In case of a filled reference, the sequence  is : reference.name '=' key ';'
     * Here key represents the key attribute of the target object
     * In case of an empty reference, nothing is done
     * 
     * @param reference EReference
     * @return Rule
     */
	private Rule singleReferencePattern (EReference reference) {
		Alternative alternative = factory.createAlternative ();
		alternative.setId(createRuleId (reference.getEContainingClass().getName(), reference.getName()));
		CustomCond filledCondition = factory.createCustomCondition(reference, "filled");
		alternative.getConditions().add(filledCondition);
		CustomCond emptyCondition = factory.createCustomCondition(reference, "empty");
		alternative.getConditions().add(emptyCondition);

		Sequence sequence = factory.createSequence();
		sequence.getSubRules().add(factory.createTerminal(reference.getName()));
		sequence.getSubRules().add(factory.createSeparator("="));

		ObjectReference or = factory.createObjectReference (reference);
		or.setIdentifier(findIdFeature (reference.getEReferenceType()));
		sequence.getSubRules().add(or);

		sequence.getSubRules().add(factory.createSeparator(";"));
		filledCondition.setSubRule(sequence);
		return alternative;
	}

    /**
     * InternalMethod used to create the sintaks pattern associated to a multi value reference 
     * The pattern is a sequence of : reference.name '=' '[' ( key ( ',' key) * )? '];'
     * Here key represents the key attribute of the target object
     * 
     * @param reference EReference
     * @return Rule
     */
	private Rule multipleReferencePattern (EReference reference) {
		Sequence sequence = factory.createSequence();
		sequence.setId(createRuleId (reference.getEContainingClass().getName(), reference.getName()));
		sequence.getSubRules().add(factory.createTerminal(reference.getName()));
		sequence.getSubRules().add(factory.createSeparator("="));

		Rule separator = factory.createSeparator(",");
		separator.setId(createUniqName());
		currentModel.getFragments().add(separator);

		ObjectReference or = factory.createObjectReference (reference);
		or.setIdentifier(findIdFeature (reference.getEReferenceType()));

		Iteration iteration = factory.createIteration (reference);
		iteration.setSeparator(separator);
		iteration.setSubRule(or);
		sequence.getSubRules().add(iteration);

		sequence.getSubRules().add(factory.createSeparator(";"));
		return sequence;
	}

    /**
     * InternalMethod used to create the sintaks pattern associated to a single value containment 
     * The pattern is a sequence of : reference.name ':' <RuleRef to the fragment>
     * 
     * @param reference EReference
     * @return Rule
     */
	private Rule singleContainmentPattern (EReference reference) {
		Sequence sequence = factory.createSequence();
		sequence.setId(createRuleId (reference.getEContainingClass().getName(), reference.getName()));
		sequence.getSubRules().add(factory.createTerminal(reference.getName()));
		sequence.getSubRules().add(factory.createSeparator(":"));

		sequence.getSubRules().add(createRuleRef (reference, reference.getEReferenceType().getName()));
		return sequence;
	}

    /**
     * InternalMethod used to create the sintaks pattern associated to a multi value containment 
     * The pattern is an alternative composed by two CustomConditions
     * (1) : reference is filled 
     * (2) : reference is empty
     * 
     * In case of a filled reference, the sequence  is : reference.name '[' ( <RuleRef to the fragment> ( ',' <RuleRef to the fragment>) * )? 'eoln' ']'
     * In case of an empty reference, nothing is done
     * 
     * @param reference EReference
     * @return Rule
     */
	private Rule multipleContainmentPattern (EReference reference) {
		Alternative alternative = factory.createAlternative ();
		alternative.setId(createRuleId (reference.getEContainingClass().getName(), reference.getName()));
		CustomCond filledCondition = factory.createCustomCondition(reference, "filled");
		alternative.getConditions().add(filledCondition);
		CustomCond emptyCondition = factory.createCustomCondition(reference, "empty");
		alternative.getConditions().add(emptyCondition);
		
		Sequence sequence = factory.createSequence();
		sequence.getSubRules().add(factory.createTerminal(reference.getName()));
		sequence.getSubRules().add(factory.createSeparator("["));
		sequence.getSubRules().add(factory.createNewLine());

		Iteration iteration = factory.createIteration (reference);
		iteration.setSubRule(createRuleRef(null, reference.getEReferenceType().getName()));
		Sequence subSequence = factory.createSequence();
		subSequence.getSubRules().add(iteration);
		subSequence.getSubRules().add(factory.createNewLine());
		sequence.getSubRules().add(subSequence);

		sequence.getSubRules().add(factory.createSeparator("]"));
		filledCondition.setSubRule(sequence);
		return alternative;
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
			return adjectiveAttributePattern(attribute);
		} else {
			return createRuleRef (null, createRuleId (container.getName(), attribute.getName()));
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
			return fragmentAttributePattern (attribute);
		} else {
			return createRuleRef (null, createRuleId (container.getName(), attribute.getName()));
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
			if (feature instanceof EAttribute) {
				EAttribute attribute = (EAttribute) feature;
				if (feature.isMany()) return multipleAttributePattern (attribute);
				else if (! allowAdjectives) return  singleAttributePattern (attribute);
				else return null;
			}
			if (feature instanceof EReference) {
				EReference reference = (EReference) feature;
				if (reference.isContainment()) {
					if (reference.isMany()) return multipleContainmentPattern (reference);
					else return singleContainmentPattern (reference);
				} else {
					if (reference.isContainer()) return null;
					if (reference.isMany()) return multipleReferencePattern (reference);
					else return singleReferencePattern (reference);
				}
			}
			return null;
		} else {
			return createRuleRef (null, createRuleId (container.getName(), feature.getName()));
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
		Template template = factory.createTemplate(aClass);
		Sequence sequence = factory.createSequence();
		template.setRule(sequence);
		sequence.getSubRules().add(factory.createTerminal (aClass.getName()));
		EStructuralFeature featureId = findIdFeature (aClass);
		if (featureId != null)
			sequence.getSubRules().add(factory.createPrimitiveValue(featureId));
		if (allowAdjectives) {
			List<EAttribute> adjectives = extractAdjectives (aClass);
			if ( ! adjectives.isEmpty()) {
				sequence.getSubRules().add(factory.createSeparator ("("));
				for (EAttribute attribute : adjectives) {
					Rule rule = adjectiveAttributeAnalyses (attribute, aClass);
					if (rule != null) {
						sequence.getSubRules().add(rule);
					}
				}
				sequence.getSubRules().add(factory.createSeparator (")"));
			}
		}
		List<EStructuralFeature> content = extractContent (aClass);
		if (! content.isEmpty()) {
			sequence.getSubRules().add(factory.createSeparator ("{"));
			sequence.getSubRules().add(factory.createNewLine());
			for (EStructuralFeature feature : content) { 
				Rule rule = contentFeatureAnalyses (feature, aClass);
				if (rule != null) {
					sequence.getSubRules().add(rule);
					sequence.getSubRules().add(factory.createNewLine());
				}
			}
			sequence.getSubRules().add(factory.createSeparator ("}"));
		} else {
			sequence.getSubRules().add(factory.createSeparator (";"));
			sequence.getSubRules().add(factory.createNewLine());
		}
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
		Alternative alternative = factory.createAlternative ();
		alternative.setId(aClass.getName());
		List<EClass> concreteClasses = getDescendantConcreteClasses (rootPackage, aClass);
		for (EClass concreteClass : concreteClasses) {
			PolymorphicCond condition = factory.createPolymorphicCondition (concreteClass);
			RuleRef ruleRef = factory.createRuleRef (null);
			todoList.add (new Todo (ruleRef, concreteClass.getName()));
			condition.setSubRule(ruleRef);
			alternative.getConditions().add(condition);
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
