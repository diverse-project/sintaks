package org.kermeta.sintaks.trace.util;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.kermeta.sintaks.trace.FileReference;
import org.kermeta.sintaks.trace.Message;
import org.kermeta.sintaks.trace.ModelReference;
import org.kermeta.sintaks.trace.Reference;
import org.kermeta.sintaks.trace.TextReference;
import org.kermeta.sintaks.trace.Trace;
import org.kermeta.sintaks.trace.TraceFactory;
import org.kermeta.sintaks.trace.TraceModel;
import org.kermeta.sintaks.trace.impl.TraceFactoryImpl;

public class Tracer {

	private TraceModel model = null;
	private List <Trace> stack = null;
    private ResourceSet resSet;
	
	public Tracer(ResourceSet resSet) {
		super();
		this.resSet = resSet;
	}

	private List<Trace> createStack () {
		return new LinkedList <Trace> ();
	}

	private TraceFactory getTraceFactory () {
		return TraceFactoryImpl.eINSTANCE;
	}

	public void add (String text) {
		if (stack == null) push (newRootTrace("unknown", "noSource", "noTarget", text));
		else if (top() == null) push (newRootTrace("unknown", "noSource", "noTarget", text));
		else {
			top().getDescription().add(createMessage(text));
		}
	}

	public void push (Trace trace) {
		if (stack == null) {
			stack = createStack();
			model = createTraceModel();
			model.setTrace(trace);
		} else if(!stack.isEmpty()){
			top().getSubTraces().add(trace);
		}
		stack.add(0, trace);
	}

	public void pop () {
		if (stack == null) return;
		stack.remove(0);
	}

	public Trace top () {
		if (stack == null) return null;
		if (stack.isEmpty()) return null;
		return stack.get(0);
	}
	
	public void save (URI traceFile) {
		Resource resource = resSet.createResource(traceFile);
		resource.getContents().add(model);
		try {
			resource.save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private TraceModel createTraceModel() {
		TraceModel traceModel = getTraceFactory ().createTraceModel();
		return traceModel;
	}

	private Message createMessage(String comment) {
		Message message = getTraceFactory ().createMessage();
		message.setText(comment);
		return message;
	}

	private Reference newFileReference (String filename) {
		FileReference fileReference = getTraceFactory().createFileReference();
		fileReference.setFilename (filename);
		return fileReference;
	}

	public Reference newTextReference (String text) {
		TextReference textReference = getTraceFactory().createTextReference();
		textReference.setText(text);
		return textReference;
	}

	public Reference newModelReference (EObject object) {
		ModelReference modelReference = getTraceFactory().createModelReference();
		modelReference.setRefObject(object);
		return modelReference;
	}

	public Trace newRootTrace (String ruleFilename, String sourceFilename, String targetFilename, String comment) {
		Trace trace = getTraceFactory().createTrace();
		trace.setRuleReference(newFileReference (ruleFilename));
		trace.setSourceReference(newFileReference (sourceFilename));
		trace.setTargetReference(newFileReference (targetFilename));
		trace.getDescription().add(createMessage (comment));
		return trace;
	}

	public Trace newText2ModelTrace (EObject rule, String source, String comment) {
		Trace trace = getTraceFactory().createTrace();
		trace.setRuleReference(newModelReference (rule));
		if (source != null && ! "".equals(source))
			trace.setSourceReference(newTextReference (source));
		if (comment != null && ! "".equals(comment))
			trace.getDescription().add(createMessage (comment));
		return trace;
	}

	public Trace newModel2TextTrace (EObject rule, EObject source, String comment) {
		Trace trace = getTraceFactory().createTrace();
		trace.setRuleReference(newModelReference (rule));
		if (source != null)
			trace.setSourceReference(newModelReference (source));
		if (comment != null && ! "".equals(comment))
			trace.getDescription().add(createMessage (comment));
		return trace;
	}

}
