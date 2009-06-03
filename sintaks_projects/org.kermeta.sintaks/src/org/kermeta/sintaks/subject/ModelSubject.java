/*
 * Created on 24 janv. 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package org.kermeta.sintaks.subject;

import java.io.PrintStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.kermeta.sintaks.SintaksPlugin;
import org.kermeta.sintaks.main.IMetaModel;
import org.kermeta.sintaks.main.IPrettyPrinter;
import org.kermeta.sintaks.subject.operation.IOperation;

public class ModelSubject {

	private IMetaModel mmSubject;
    private List<Object> stack;
	private List<Ghost> ghosts;
	private Object accumulator;
	private ModelObserver observer;
	
    public ModelSubject(IMetaModel subject) {
	    this.mmSubject = subject;
    }
    
    public Object getAccumulator() {
		return accumulator;
	}

	public void setAccumulator(Object accumulator) {
		this.accumulator = accumulator;
	}

    public EObject getModel () {
        if (getStack().size()==0) return null;
        return (EObject) getStack().get(0);
    }

    public void setModel (EObject model) {
    	getStack().clear();
    	getStack().add(model);
    }

	public List<Ghost> getGhosts () {
    	if (ghosts == null)
    		ghosts = new LinkedList<Ghost> ();
    	return ghosts;
    }

	public List<Object> getStack () {
    	if (stack == null)
    	    stack = new LinkedList<Object> ();
    	return stack;
    }

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
				relink();
			}
		}

		public void setTarget(Notifier arg0) {
			this.target = arg0;
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public void push (Object o) {
    	if (getStack().isEmpty() && o instanceof EObject) {
    		EObject eo = (EObject) o;
    		observer = new ModelObserver ();
        	observer.setTarget(eo);
        	eo.eAdapters().add(observer);
    	}
    	getStack().add (o);
	}

	public Object pop () {
		Object o = getStack().remove(getStack().size()-1);
    	if (getStack().isEmpty() && o instanceof EObject) {
    		EObject eo = (EObject) o;
        	eo.eAdapters().remove(observer);
    	}
		return o;
	}

	public Object top () {
		if (getStack().size() != 0) {
			return getStack().get(getStack().size()-1);
		} else {
			return null;
		}
	}

	public int size () {
		return getStack().size();
	}

    public Object process (IOperation op) {
    	if (op == null) return null;
    	op.execute(this);
    	return getAccumulator ();
    }
    
    public void dumpStack () {
    	Iterator<Object> i = getStack().iterator();
    	int j=0;
    	while (i.hasNext()) {
    		Object o = i.next();
    		++j;
//Hm trace
//    		if (o != null) SintaksPlugin.getDefault().debugln("Stack ["+j+"]: "+o.toString());
//    		else SintaksPlugin.getDefault().debugln("Stack ["+j+"]: (null)");
    	}
    }
    
	private void relink () {
		if (getGhosts().isEmpty()) return;

		if (SintaksPlugin.getDefault().getOptionManager().isDebugModel()) {
	        SintaksPlugin.getDefault().getTracer().add("relinking required");
        }
		List<Ghost> fakes = getGhosts();
        ghosts = null;
        
        Iterator<Ghost> i = fakes.iterator();
        
        while (i.hasNext()) {
            Ghost fake = i.next();
            if (! OperationExecutor.relinkGhost(this, fake)) {
            	getGhosts().add(fake);
            }
        }
		if (SintaksPlugin.getDefault().getOptionManager().isDebugModel()) {
			if (getGhosts().isEmpty()) {
				SintaksPlugin.getDefault().getTracer().add("Ghosts now empty");
			} else {
				SintaksPlugin.getDefault().getTracer().add("Ghosts allways not empty");
			}
		}
    }

    public void load (URI uri) {
    	mmSubject.load(uri);
    	setModel ( (EObject) mmSubject.getRoot());
    }

    public void store (URI uri) {
    	mmSubject.setRoot(getModel());
    	mmSubject.store(uri);
    }

    public void print (PrintStream out) {
        IPrettyPrinter pp;
        pp = mmSubject.getPrettyPrinter(out);
        if (pp != null) {
            out.println();
            out.println("Model created : ");
            pp.print(getModel());
        }
        pp = mmSubject.getPrettyPrinter(out);
        if (pp != null) {
            out.println();
            out.println("Stack : ");
            pp.print(getStack());
        }
        pp = mmSubject.getPrettyPrinter(out);
        if (pp != null) {
            out.println();
            out.println("Ghosts : ");
            pp.print(getGhosts());
            out.println();
        } else {
            out.println();
            out.println("Warning no Pretty-Printer");
        }
        pp = null;
    }

	public boolean isReady() {
		return ghosts == null || ghosts.isEmpty();
	}
}
