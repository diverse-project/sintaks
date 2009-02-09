/* 
 * Project: sintaks
 * File: GuidedAnalyser.java
 * License: EPL
 * Copyright: MIPS / Universite de Haute Alsace
 * ----------------------------------------------------------------------------
 * Creation date: Feb  5, 2008
 * Authors: 
 * 			Michel Hassenforder
 * Note:
 * 
 *  This class reads a sintaks genmodel file and create a HUTNlike sintaks file.
 *  
 */
package fr.uha.mips.sintaks.ecore2hutn;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
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

import fr.uha.mips.sintaks.stsgen.StsGenClass;
import fr.uha.mips.sintaks.stsgen.StsGenFeature;
import fr.uha.mips.sintaks.stsgen.StsGenRoot;
import fr.uha.mips.sintaks.stsgen.Type;

public class GuidedAnalyser {

	private Root pattern;
	private Root currentModel;
	private StsGenRoot genRoot;
	private int uniqId;
	private String prefix;
	private ModelObserver observer;
	private List<Todo> todoList;
	private String patternToProtect;
	
	public GuidedAnalyser() {
		super();
		this.uniqId=0;
		this.prefix="separator";

		ResourceSet resSet = new ResourceSetImpl();
		Resource inputResource = resSet.getResource(URI.createPlatformPluginURI("/fr.uha.mips.sintaks.ecore2hutn/Templates.sts", false), true);
		pattern = (Root) inputResource.getContents().get(0);
	}

    /**
     * Entry point, it analyses the input sintaks genmodel and create the HUTNlike output model written in sintaks.
     * The main task is done by method packageAnalyses()
     * 
     * @param inputRoot EObject
     * @return Root
     */
	public Root analyses(EObject inputRoot) {
		if ( ! (inputRoot instanceof StsGenRoot)) return null;
		genRoot = (StsGenRoot) inputRoot;
		todoList = new ArrayList<Todo> (5);
		currentModel = StsFactory.eINSTANCE.createRoot();
		observer = new ModelObserver ();
    	observer.setTarget(currentModel);
    	currentModel.eAdapters().add(observer);
		rootAnalyses (genRoot);
		currentModel.setStart(findRule(genRoot.getStartClass().getName()));
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
     * Iterates over the classes container to analyse genClasses
     * 
     * @param genRoot StsGenRoot
     */
	private void rootAnalyses(StsGenRoot genRoot) {
		for (StsGenClass genClass : genRoot.getGenClasses()) { 
			classAnalyses (genClass);
		}
	}

    /**
     * Analyses a genClass
     * Process only used EClasses which are not interfaces
     * In case of concrete class it calls method createConcreteClass() 
     * In case of abstract class it calls method createAbstractClass() 
     * 
     * 
     * @param genClass StsGenClass
     */
	private void classAnalyses (StsGenClass genClass) {
		if (genClass.isNotUsed()) return;
		if (genClass.isAbstract()) {
			currentModel.getFragments().add(createAbstractClass (genClass));
		}else {
			currentModel.getFragments().add(createConcreteClass (genClass));
		}
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
		if (subject instanceof StsGenClass) {
			name = ((StsGenClass) subject).getClassTarget().getName();
		}
		if (subject instanceof StsGenFeature) {
			String containerName = ((StsGenFeature) subject).getTargetFeature().getEContainingClass().getName();
			String featureName = ((StsGenFeature) subject).getTargetFeature().getName();
			name = createRuleId (containerName, featureName);
		}
		return name;
	}

    /**
     * Lookup a StsGenClass about an ID attribute
     * 
     * @param stsGenClass EClass
     * @return StsGenFeature
     */
	private StsGenFeature findIdFeature (StsGenClass subject) {
		for (StsGenFeature feature : subject.getGenFeatures()) {
			if (feature.isNotUsed()) continue;
			if (feature.getType().getValue() == Type.ID_VALUE)
				return feature;
		}
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
		if (subject instanceof StsGenClass && rule instanceof Terminal) {
			((Terminal) rule).setTerminal(((StsGenClass) subject).getClassTarget().getName());
		}
		if (subject instanceof StsGenFeature && rule instanceof Terminal) {
			((Terminal) rule).setTerminal(((StsGenFeature) subject).getTargetFeature().getName());
		}
	}

	private void Parameter_F (Rule rule, EObject subject) {
		if (subject == null) return;
		rule.setId(null);
		if (subject instanceof StsGenClass && rule instanceof RuleRef) {
			todoList.add (new Todo ((RuleRef) rule, ((StsGenClass) subject).getClassTarget().getName()));
		}
		if (subject instanceof StsGenFeature) {
			StsGenFeature feature = (StsGenFeature) subject;
			EStructuralFeature target = feature.getTargetFeature();
			if (rule instanceof Iteration) ((Iteration) rule).setContainer(target);
			if (rule instanceof Value) ((Value) rule).getFeatures().add(target);
			if (rule instanceof ObjectReference) ((ObjectReference) rule).setIdentifier(findIdFeature (feature.getContainer()).getTargetFeature());
			if (rule instanceof RuleRef) todoList.add (new Todo ((RuleRef) rule, ((EReference)target).getEReferenceType().getName()));
		}
	}

	private void Parameter_I (Rule rule, EObject subject) {
		if (subject == null) return;
		rule.setId(null);
		if (subject instanceof StsGenFeature) {
			StsGenFeature feature = (StsGenFeature) subject;
			EStructuralFeature target = feature.getTargetFeature();
			if (rule instanceof ObjectReference) ((ObjectReference) rule).setIdentifier(findIdFeature (feature.getContainer()).getTargetFeature());
			if (rule instanceof RuleRef) todoList.add (new Todo ((RuleRef) rule, ((EReference)target).getEReferenceType().getName()));
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
					if (subject instanceof StsGenClass) {
						StsGenFeature idFeature = findIdFeature ((StsGenClass) subject);
						Parameter_F (r, idFeature);
					}
				}
				if ("AA".equals(id)) {
					if (subject instanceof StsGenClass) {
						for (StsGenFeature attribute : extractAfterAdjectives ((StsGenClass) subject)) {
							toMove.add(new ToMove(object, featureAnalyses (attribute, true)));
						}
					}
					toRemove.add(new ToRemove(object));
				}
				if ("AB".equals(id)) {
					if (subject instanceof StsGenClass) {
						for (StsGenFeature attribute : extractBeforeAdjectives ((StsGenClass) subject)) {
							toMove.add(new ToMove(object, featureAnalyses (attribute, true)));
						}
					}
					toRemove.add(new ToRemove(object));
				}
				if ("C".equals(id)) {
					if (subject instanceof StsGenClass) {
						List<StsGenFeature> content = extractContent ((StsGenClass) subject);
						switch (content.size()) {
						case  0 : break;
						case  1 :
							toMove.add(new ToMove(object, featureAnalyses (content.get(0), true)));
							break;
						default : 
							for (StsGenFeature localFeature : content) {
								toMove.add(new ToMove(object, featureAnalyses (localFeature, false)));
							}
							break;
						}
					}
					toRemove.add(new ToRemove(object));
				}
				if (id.startsWith("T") && subject instanceof StsGenClass) {
					StsGenClass genClass = (StsGenClass) subject;
					int validCondition = -1;
					if ("TI".equals(id)) {
						validCondition = (findIdFeature (genClass) != null) ? 0 : 1;
					}
					if ("TAA".equals(id)) {
						validCondition = (extractAfterAdjectives (genClass).isEmpty() == false) ? 0 : 1;
					}
					if ("TAB".equals(id)) {
						validCondition = (extractBeforeAdjectives (genClass).isEmpty() == false) ? 0 : 1;
					}
					if ("TC".equals(id)) {
						validCondition = (extractContent (genClass).isEmpty() == false) ? 0 : 1;
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
			if (object instanceof CustomCond && subject instanceof StsGenFeature) {
				CustomCond cc = (CustomCond) object;
				StsGenFeature feature = (StsGenFeature) subject;
				cc.setFeature(feature.getTargetFeature());
			}
			if (object instanceof PolymorphicCond && subject instanceof StsGenClass) {
				PolymorphicCond pc = (PolymorphicCond) object;
				StsGenClass genClass = (StsGenClass) subject;
				pc.setMetaclass(genClass.getClassTarget());
			}
			if (object instanceof Template && subject instanceof StsGenClass) {
				Template t = (Template) object;
				StsGenClass genClass = (StsGenClass) subject;
				t.setMetaclass(genClass.getClassTarget());
			}
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

	static private final String[] patternNames = new String [] {
		"SingleAttribute", "MultipleAttribute", 
		"SingleContainment", "MultipleContainment",
		"SingleReference", "MultipleReference",
		"adjective", "booleanAdjective",
		"sharedFeature"
	};

	/**
     * InternalMethod used to choose the best way to represent a structuralFeature
     * All information are stored in the associated GenFeature
     *    type       : type of the feature
     *    shared     : owned or not by the current class
     *    many       : derived from the many EStructuralFeature
     *    protection : to protect or not
     *  
     * @param attribute EAttribute
     * @param alone boolean
     * @return Rule
     */
	private Rule featureAnalyses (StsGenFeature feature, boolean alone) {
		if (feature.isNotUsed()) return null;
		String patternPrefix = (alone) ? "short" : "long";
		int patternID = -1;
		if (! feature.isShared()) {
			switch (feature.getType().getValue()) {
			case Type.ID_VALUE : 		break;
			case Type.ADJECTIVE_AFTER_VALUE :
			case Type.ADJECTIVE_BEFORE_VALUE :
				String typeName = feature.getTargetFeature().getEType().getName();
				if ("EBoolean".equals(typeName) || "EBooleanObject".equals(typeName)) {
					patternID = 7;
				} else {
					patternID = 6;
				}
				patternPrefix = "";
				break;
			case Type.ATTRIBUTE_VALUE : patternID = (feature.isMany()) ? 1 : 0; break;
			case Type.CONTAINER_VALUE : patternID = (feature.isMany()) ? 3 : 2; break;
			case Type.REFERENCE_VALUE : patternID = (feature.isMany()) ? 5 : 4; break;
			default : break;
			}
		} else {
			patternID = 8;
			patternPrefix = "";
		}
		if (patternID == -1) return null;
		String patternFullName = null;
		if (feature.isProtected()) {
			this.patternToProtect = patternPrefix + patternNames[patternID];
			patternFullName = "protection";
		} else {
			patternFullName = patternPrefix + patternNames[patternID];
		}
		return processPattern (patternFullName, feature);
	}
	
    /**
     * InternalMethod used to extract from a class all features usable as adjectives
     * placed after the name or ID of a class
     * 
     * @param stsGenClass EClass
     * @return List<StsGenFeature>
     */
	private List<StsGenFeature> extractAfterAdjectives (StsGenClass stsGenClass) {
		List<StsGenFeature> adjectives = new ArrayList<StsGenFeature> ();
		for (StsGenFeature feature : stsGenClass.getGenFeatures()) { 
			if (feature.isNotUsed()) continue;
			if (feature.getType().getValue() != Type.ADJECTIVE_AFTER_VALUE) continue;
			adjectives.add(feature);
		}
		return adjectives;
	}
	
    /**
     * InternalMethod used to extract from a class all features usable as adjectives
     * placed before the name or ID of a class
     * 
     * @param stsGenClass EClass
     * @return List<StsGenFeature>
     */
	private List<StsGenFeature> extractBeforeAdjectives (StsGenClass stsGenClass) {
		List<StsGenFeature> adjectives = new ArrayList<StsGenFeature> ();
		for (StsGenFeature feature : stsGenClass.getGenFeatures()) { 
			if (feature.isNotUsed()) continue;
			if (feature.getType().getValue() != Type.ADJECTIVE_BEFORE_VALUE) continue;
			adjectives.add(feature);
		}
		return adjectives;
	}
	
    /**
     * InternalMethod used to extract from a class all features usable as content
     * 
     * @param stsGenClass EClass
     * @return List<StsGenFeature>
     */
	private List<StsGenFeature> extractContent (StsGenClass stsGenClass) {
		List<StsGenFeature> content = new ArrayList <StsGenFeature> ();
		for (StsGenFeature feature : stsGenClass.getGenFeatures()) {
			if (feature.isNotUsed()) continue;
			switch (feature.getType().getValue()) {
			case Type.ID_VALUE : 		break;
			case Type.ADJECTIVE_AFTER_VALUE : break;
			case Type.ADJECTIVE_BEFORE_VALUE : break;
			case Type.ATTRIBUTE_VALUE : content.add(feature); break;
			case Type.CONTAINER_VALUE : content.add(feature); break;
			case Type.REFERENCE_VALUE : content.add(feature); break;
			default : break;
			}
		}
		return content;
	}

    /**
     * InternalMethod used to create the template associated to a concrete Class
     * 
     * @param genClass EClass
     * @return Rule
     */
	private Rule createConcreteClass (StsGenClass genClass) {
		return processPattern ("concretClass", genClass);
	}

    /**
     * InternalMethod used to create the template associated to an abstract Class
     * The Template is just an alternative owning a list of Polymorphic condition over all subClasses
     * For each structural feature a fragment is created (called by child concrete classes)
     * 
     * @param genClass EClass
     * @return Rule
     */
	private Rule createAbstractClass (StsGenClass genClass) {
		Alternative alternative = (Alternative) processPattern ("abstractClass", genClass);
		List<StsGenClass> concreteClasses = genClass.getGenSubClasses();
		for (StsGenClass concreteClass : concreteClasses) {
			if (concreteClass.isNotUsed()) continue;
			Rule rule = processPattern ("inheritance", concreteClass);
			if (rule != null) alternative.getConditions().add(((Alternative) rule).getConditions().get(0));
		}
		return alternative;
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
