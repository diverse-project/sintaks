package org.kermeta.sintaks.ui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class SintaksExampleWizard
	extends AbstractExampleWizard {
	
	protected Collection getProjectDescriptors() {
		
		System.out.println("Debug - enter in the wizard");
		// We need the statements example to be unzipped along with the
		// EMF library example model, edit and editor examples
		List projects = new ArrayList(1);
		projects.add(new ProjectDescriptor("org.kermeta.sintaks.ui", "samples/org.kermeta.sintaks.samples.zip", "org.kermeta.sintaks.samples"));
		return projects;
	}
}