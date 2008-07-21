package org.kermeta.sintaks.subject.operation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.kermeta.sintaks.SintaksPlugin;
import org.kermeta.sintaks.subject.ModelSubject;


public class CompositeOperation implements IOperation {

	private List<IOperation> list;
	
	public void execute (ModelSubject model) {
		Iterator<IOperation> i = getList().iterator();
		while (i.hasNext()) {
			IOperation op = i.next();
//			SintaksPlugin.getDefault().debugln("Execution of : "+op.toString());
//	    	model.dumpStack ();
//			SintaksPlugin.getDefault().debugln("");
			op.execute(model);
		}
	}

	private List<IOperation> getList () {
		if (list == null) list = new ArrayList<IOperation> ();
		return list;
	}
	
	public void add (IOperation op) {
		if (op != null) { 
			getList().add(op);
		}
	}
}
