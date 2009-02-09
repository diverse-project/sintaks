/* 
 * Project: sintaks
 * File: SimplerAnalyser.java
 * License: EPL
 * Copyright: MIPS / Universite de Haute Alsace
 * ----------------------------------------------------------------------------
 * Creation date: Dec 24, 2007
 * Major update : Feb  5, 2008 // the class was just renamed
 * Authors: 
 * 			Michel Hassenforder
 * Note:
 * 
 *  This class reads an ecore file and create the a HUTNlike sintaks file.
 *  Some hints help to customize the generated sintaks file
 *  
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
import org.eclipse.emf.ecore.ENamedElement;
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

public class SimplerAnalyser {

	private Root pattern;
	private Root currentModel;
	private EPackage rootPackage;
	private int uniqId;
	private String prefix;
	private ModelObserver observer;
	private List<Todo> todoList;
	private boolean allowAdjectives;
	private boolean before;
	private boolean protectionRules [];
	private String startClassName;
	private String patternToProtect;
	
	public SimplerAnalyser(String startClassName, boolean allowAdjectives, boolean before, boolean protectionRules []) {
		super();
		this.startClassName = startClassName;
		this.allowAdjectives = allowAdjectives;
		this.before = before;
		this.uniqId=0;
		this.prefix="separator";

		ResourceSet resSet = new ResourceSetImpl();
		Resource inputResource = resSet.getResource(URI.createPlatformPluginURI("/fr.uha.mips.sintaks.ecore2hutn/Templates.sts", false), true);
		pattern = (Root) inputResource.getContents().get(0);
		if (protectionRules == null || protectionRules.length != 7) {
			this.protectionRules = new boolean [] { false, false, false, true, false, true, false };
		} else {
			this.protectionRules = protectionRules;
		}
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
     * Internal method to get the name of an EObject
     * 
     * @return String
     */
	private String getSubjectName (EObject subject) {
		String name = "unnamed";
		if (subject instanceof ENamedElement) {
			name = ((ENamedElement) subject).getName();
		}
		if (subject instanceof EStructuralFeature) {
			String containerName = ((EStructuralFeature) subject).getEContainingClass().getName();
			name = createRuleId (containerName, name);
		}
		return name;
	}

    /**
     * Lookup a class in the inputModel to locate an Id attribute
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
     * Lookup the template file to locate a pattern by its name
     * 
     * @param name String
     * @return EObject
     */
	private EObject findPattern (String name) {
		for (Rule r : pattern.getFragments()) {
			if (name.equals(r.getId()))
				return r;
		}
		return null;
	}

    /**
     * Internal class to model an EObject to remove in a container
     * 
     */
	private class ToRemove {
		private EObject source;

		public ToRemove (EObject source) {
			this.source = source;
		}

		public EObject getSource() {
			return source;
		}

	}

    /**
     * Internal class to model an EObject to move in a container at a given position
     * 
     */
	class ToMove {
		private EObject before;
		private EObject source;

		public ToMove (EObject before, EObject source) {
			this.before = before;
			this.source = source;
		}

		public EObject getSource() {
			return source;
		}

		public EObject getBefore() {
			return before;
		}
		
	}

	private void Parameter_Sharp (Rule rule, EObject subject) {
		rule.setId(createUniqName());
	}

	private void Parameter_R (Rule rule, EObject subject) {
		if (subject == null) return;
		rule.setId(getSubjectName(subject));
	}

	private void Parameter_N (Rule rule, EObject subject) {
		if (subject == null) return;
		rule.setId(null);
		if (subject instanceof ENamedElement && rule instanceof Terminal) {
			ENamedElement anElement = (ENamedElement) subject;
			((Terminal) rule).setTerminal(anElement.getName());
		}
	}

	private void Parameter_F (Rule rule, EObject subject) {
		if (subject == null) return;
		rule.setId(null);
		if (subject instanceof EClass && rule instanceof RuleRef) {
			EClass aClass = (EClass) subject;
			todoList.add (new Todo ((RuleRef) rule, aClass.getName()));
		}
		if (subject instanceof EStructuralFeature) {
			EStructuralFeature feature = (EStructuralFeature) subject;
			if (rule instanceof Iteration) ((Iteration) rule).setContainer(feature);
			if (rule instanceof Value) ((Value) rule).getFeatures().add(feature);
			if (rule instanceof ObjectReference) ((ObjectReference) rule).setIdentifier(findIdFeature (((EReference)feature).getEReferenceType()));
			if (rule instanceof RuleRef) todoList.add (new Todo ((RuleRef) rule, ((EReference)feature).getEReferenceType().getName()));
		}
	}

	private void Parameter_I (Rule rule, EObject subject) {
		if (subject == null) return;
		rule.setId(null);
		if (subject instanceof EStructuralFeature) {
			EStructuralFeature feature = (EStructuralFeature) subject;
			if (rule instanceof ObjectReference) ((ObjectReference) rule).setIdentifier(findIdFeature (((EReference)feature).getEReferenceType()));
			if (rule instanceof RuleRef) todoList.add (new Todo ((RuleRef) rule, ((EReference)feature).getEReferenceType().getName()));
		}
	}

	private void Parameter_S (Rule rule, EObject subject) {
		if (subject == null) return;
		rule.setId(null);
		if (rule instanceof RuleRef) todoList.add (new Todo ((RuleRef) rule, getSubjectName(subject)));
	}

    /**
     * Terrific method witch patches an EObject according to some confusing homemade rules
     * The idea is the following : given a template in a sts file, the id feature of a Rule carry semantics
	 *
	 * #  : means the id should be replaced by an uniq id
	 * R  : means the id should be replace by something related to the concept processed
	 * N  : means the Terminal value should be replace by the name of the feature or the class
	 * F  : means the feature referenced by the value or the iteration should be associated to the current feature/class
	 * I  : same as F but stranger
	 * S  : special for share RuleRef referencing
	 * P  : call to insert the rule under the current protection pattern
	 * ID : 
	 * T* : special entry to be processed heavily. It is an alternative with two conditions. We evaluate something and
	 *      if true we process only the first condition, if false it is the else. Later the processed condition replace
	 *      the current alternative. This part is here to express design time conditional part of the template
	 * TI : the condition is about an attribute id of a class
	 * TAA: the condition is about the existence of the adjective after section
	 * TAB: the condition is about the existence of the adjective before section
	 * TC : the condition is about the existence of the content section
	 * AA : place holder for class adjectives placed after the name/ID
	 * AB : place holder for class adjectives placed before the name/ID
	 * C  : place holder for class content
	 * 
	 * Some other rules do not have an ID feature, always we patch them :
	 *    PolymorphicCondition : we attach the class under study
	 *    CustomCondition : we attach the feature under study
	 *    Template :  we attach the feature under study
	 * 
	 * I guess it is my greatest idea to confused my template engine ;)
	 * 
	 * @param sequence EObject
     * @param feature EStructuralFeature 
     * @param aClass EClass 
     * @return void
     */
	
	private void patchRules (EObject sequence, EObject subject) {
/*
		System.out.print(" Patch :");
		System.out.print(" Class = "+((aClass  != null) ? aClass.getName() : "null"));
		System.out.print(" Feature = "+((feature != null) ? feature.getName() : "null"));
		if (sequence != null) {
			if (sequence instanceof Rule) {
				System.out.print(" Sequence = "+((Rule) sequence).getId());
			} else if (sequence instanceof Condition) {
				System.out.print(" Sequence = "+((Condition) sequence).getValue());
			} else {
				System.out.print(" Sequence = "+sequence.toString());
			}
		} else {
			System.out.print(" Sequence = null");
		}
		System.out.println ();
*/
		if  (sequence == null) return;
		List<ToRemove> toRemove = new ArrayList<ToRemove> ();
		List<ToMove>   toMove = new ArrayList<ToMove> ();
		TreeIterator<EObject> i = sequence.eAllContents();
		while (i.hasNext()) {
			EObject object = i.next();
			if (object instanceof Rule) {
				Rule r = (Rule) object;
				String id = r.getId(); if (id == null) id = "";
				if ("#".equals(id)) Parameter_Sharp (r, subject);
				if ("R".equals(id)) Parameter_R (r, subject);
				if ("N".equals(id)) Parameter_N (r, subject);
				if ("F".equals(id)) Parameter_F (r, subject);
				if ("I".equals(id)) Parameter_I (r, subject);
				if ("S".equals(id)) Parameter_S (r, subject);
				if ("ID".equals(id)) {
					if (subject instanceof EClass) {
						EStructuralFeature idFeature = findIdFeature (((EClass) subject));
						Parameter_F (r, idFeature);
					}
				}
				if ("AA".equals(id)) {
					if (subject instanceof EClass && ! before) {
						for (EAttribute attribute : extractAdjectives ((EClass) subject)) {
							toMove.add(new ToMove(object, adjectiveAttributeAnalyses (attribute, (EClass) subject)));
						}
					}
					toRemove.add(new ToRemove(object));
				}
				if ("AB".equals(id)) {
					if (subject instanceof EClass && before) {
						for (EAttribute attribute : extractAdjectives ((EClass) subject)) {
							toMove.add(new ToMove(object, adjectiveAttributeAnalyses (attribute, (EClass) subject)));
						}
					}
					toRemove.add(new ToRemove(object));
				}
				if ("C".equals(id)) {
					if (subject instanceof EClass) {
						List<EStructuralFeature> content = extractContent ((EClass) subject);
						switch (content.size()) {
						case  0 : break;
						case  1 :
							toMove.add(new ToMove(object, contentFeatureAnalyses (content.get(0), (EClass) subject, true)));
							break;
						default : 
							for (EStructuralFeature localFeature : content) {
								toMove.add(new ToMove(object, contentFeatureAnalyses (localFeature, (EClass) subject, false)));
							}
							break;
						}
					}
					toRemove.add(new ToRemove(object));
				}
				if (id.startsWith("T") && subject instanceof EClass) {
					int validCondition = -1;
					if ("TI".equals(id)) {
						validCondition = (findIdFeature (((EClass) subject)) != null) ? 0 : 1;
					}
					if ("TAA".equals(id)) {
						if (allowAdjectives && ! before) {
							validCondition = (extractAdjectives (((EClass) subject)).isEmpty() == false) ? 0 : 1;
						}
					}
					if ("TAB".equals(id) && before) {
						if (allowAdjectives) {
							validCondition = (extractAdjectives (((EClass) subject)).isEmpty() == false) ? 0 : 1;
						}
					}
					if ("TC".equals(id)) {
						validCondition = (extractContent (((EClass) subject)).isEmpty() == false) ? 0 : 1;
					}
					if (validCondition != -1) {
						Rule targetCondition = ((Alternative) object).getConditions().get(validCondition).getSubRule();
						if (targetCondition != null) {
//							System.out.print("directive:");
							patchRules (targetCondition, subject);
							toMove.add(new ToMove(object, targetCondition));
						}
					}
					toRemove.add(new ToRemove(object));
					i.prune();
				}
				if ("P".equals(id)) {
					toMove.add(new ToMove(object, processPattern (this.patternToProtect, subject)));
					toRemove.add(new ToRemove(object));
				}
			}
			if (object instanceof CustomCond && subject instanceof EStructuralFeature) ((CustomCond) object).setFeature((EStructuralFeature) subject);
			if (object instanceof PolymorphicCond && subject instanceof EClass) ((PolymorphicCond) object).setMetaclass((EClass) subject);
			if (object instanceof Template && subject instanceof EClass) ((Template) object).setMetaclass((EClass) subject);
		}
		for (ToMove crt : toMove) {
			if (crt == null) continue;
			if (crt.getBefore() == null) continue;
			if (crt.getSource() == null) continue;
			EObject c = crt.getBefore().eContainer();
			if (c instanceof Sequence) {
				Sequence container = (Sequence) crt.getBefore().eContainer();
				int position = container.getSubRules().indexOf(crt.getBefore());
				container.getSubRules().add(position, (Rule) crt.getSource());
			}
		}
		for (ToRemove crt : toRemove) {
			if (crt == null) continue;
			if (crt.getSource() == null) continue;
			Sequence container = (Sequence) crt.getSource().eContainer();
			int position = container.getSubRules().indexOf(crt.getSource());
			container.getSubRules().remove(position);
		}
	}

    /**
     * Dispatch a Sequence of rules :
     *    the first one is returned to be inserted by the caller
     *    all others are inserted in as individual fragments
     * 
     * @param rules EObject
     * @return Rule
     */
	private Rule dispatchRules (EObject rules) {
		Sequence sequence = (Sequence) rules;
		Rule toReturn = null;
		if (sequence.getSubRules().size() >= 1) {
			toReturn = sequence.getSubRules().remove(0);
			currentModel.getFragments().addAll (sequence.getSubRules());
		}
		return toReturn;
	}

    /**
     * Main entry to process a pattern
     * 
     * @param patternName String
     * @param subject EObject
     * @return Rule
     */
	private Rule processPattern (String patternName, EObject subject) {
//		System.out.println ("Pattern : "+patternName);
		if (patternName == null) return null;
		EObject localPattern = findPattern (patternName);
		EObject localCopy = org.eclipse.emf.ecore.util.EcoreUtil.copy(localPattern);
		patchRules (localCopy, subject);
		return dispatchRules (localCopy);
	}

    /**
     * InternalMethod used to choose the best way to represent an attribute
     * If the attribute belong to the current class we use the adjectiveAttributePattern
     * else we create a RuleRef to the fragment created by the mother class
     * 
     * @param attribute EAttribute
     * @param current EClass 
     * @return Rule
     */
	private Rule adjectiveAttributeAnalyses (EAttribute attribute, EClass current) {
		EClass container = attribute.getEContainingClass();
		String patternName;
		boolean toProtect = false;
		if (container == current) {
			if ("EBoolean".equals(attribute.getEType().getName()) || "EBooleanObject".equals(attribute.getEType().getName())) {
				patternName = "booleanAdjective";
			} else {
				patternName = "adjective";
			}
			toProtect = protectionRules [6];
		} else {
			patternName = "sharedFeature";
		}
		String patternFullName = null;
		if (patternName != null) {
			if (toProtect) {
				this.patternToProtect = patternName;
				patternFullName = "protection";
			} else {
				patternFullName = patternName;
			}
		}
		return processPattern (patternFullName, attribute);
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
     * @param alone boolean
     * @return Rule
     */
	private Rule contentFeatureAnalyses (EStructuralFeature feature, EClass mother, boolean alone) {
		String patternFullName = null;
		EClass container = feature.getEContainingClass();
		if (container == mother) {
			String patternName = null;
			boolean toProtect = false;
			if (feature instanceof EAttribute) {
				if (feature.isMany()) {
					patternName = "MultipleAttribute";
					toProtect = protectionRules [1];
				} else if (! allowAdjectives) {
					patternName = "SingleAttribute";
					toProtect = protectionRules [0];
				}
			}
			if (feature instanceof EReference) {
				EReference reference = (EReference) feature;
				if (reference.isContainment()) {
					if (reference.isMany()) {
						patternName = "MultipleContainment";
						toProtect = protectionRules [5];
					} else {
						patternName = "SingleContainment";
						toProtect = protectionRules [4];
					}
				} else {
					if (! reference.isContainer()) {
						if (reference.isMany()) {
							patternName = "MultipleReference";
							toProtect = protectionRules [3];
						} else {
							patternName = "SingleReference";
							toProtect = protectionRules [2];
						}
					}
				}
			}
			String patternPrefix = (alone) ? "short" : "long";
			if (patternName != null) {
				if (toProtect) {
					this.patternToProtect = patternPrefix + patternName;
					patternFullName = "protection";
				} else {
					patternFullName = patternPrefix + patternName;
				}
			}
		} else {
			patternFullName = "sharedFeature";
		}
		if (patternFullName != null) return processPattern (patternFullName, feature);
		else return null;
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
     * 
     * @param aClass EClass
     * @return Rule
     */
	private Rule createConcreteClass (EClass aClass) {
		return processPattern ("concretClass", aClass);
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
