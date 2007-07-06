/*$Id: SintaksFile.java,v 1.1 2007-07-06 13:23:33 dtouzet Exp $
* Project : fr.irisa.triskell.sintaks
* File : 	SintkasFile.java
* License : EPL
* Copyright : IRISA / INRIA / Universite de Rennes 1
* ----------------------------------------------------------------------------
* Creation date : 16 mai 07
* Authors : paco
*/

package org.kermeta.sintaks.ui;

public class SintaksFile {

	private String filePath = "";
	
	private String documentation = "";
	
	public SintaksFile(String filePath, String documentation) {
		assert( filePath != null );
		assert( documentation != null );
		this.filePath = filePath;
		this.documentation = documentation;
	}
	
	public String getFilePath() {
		return filePath;
	}
	
	public String getDocumentation() {
		return documentation;
	}
	
}


