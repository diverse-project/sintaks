/*$Id: RegisteringHelper.java,v 1.2 2007-12-03 21:21:21 dvojtise Exp $
* Project : fr.irisa.triskell.sintaks
* File : 	RegisteringHelper.java
* License : EPL
* Copyright : IRISA / INRIA / Universite de Rennes 1
* ----------------------------------------------------------------------------
* Creation date : 23 mai 07
* Authors : 
* 		François Tanguy
* 		Didier Vojtisek
*/

package org.kermeta.sintaks.registering;


import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.RegistryFactory;
import org.eclipse.emf.common.util.URI;
import org.kermeta.sintaks.SintaksPlugin;

public class RegisteringHelper {
	
	
	
	//static public String getRuleFile(String fileExtension) {
	/**
	 * Return the URI of the STS for the given text extension
	 * Return null if none found
	 * can return an error to the user
	 * @param textExtension
	 * @return
	 */
	static public URI getRuleFile(String fileExtension) {
		
		IExtensionRegistry registry = RegistryFactory.getRegistry();
		
		/* Get all extensions of sintaks files registration.*/
		IExtensionPoint extensionPoint = registry.getExtensionPoint(SintaksPlugin.EXTENSION_POINT_REGISTRATION);
		IExtension[] extensions;
		if(extensionPoint ==  null){
			SintaksPlugin.getDefault().reportErrorToUser("Extension point not found : " + SintaksPlugin.EXTENSION_POINT_REGISTRATION);
			return null;
		}
		else	
			extensions = extensionPoint.getExtensions();
		
		/* For all extensions, generate an editor for all ConfigurationElement.
		 * An extension can have one or more registration (one registration corresponds to one ConfigurationElement).
		 */
		for ( int i = 0; i < extensions.length; i++ ) {
			
			IConfigurationElement[] elements = extensions[i].getConfigurationElements();
			for ( int j = 0; j < elements.length; j++ ) {
				
				if ( elements[j].getAttribute("Extension").equals(fileExtension) ) {
					URI uri = URI.createURI("platform:/plugin/" + extensions[i].getContributor().getName() + "/" + elements[j].getAttribute("File"));
					return uri;
				}
			
			}
			
		}
		
		return null;
	}
	
	/**
	 * Return the URI of the STS for the given text extension
	 * Return null if none found
	 * @param textExtension
	 * @return
	 */
	static public URI getSTSforTextExtension(String textExtension){

		return getSTSforGenericExtension("Extension", textExtension);
	}
	/**
	 * Return the ModelExtension for the given text extension
	 * Return "xmi" if none found
	 * @param textExtension
	 * @return
	 */
	static public String getModelExtensionForTextExtension(String textExtension){

		return getExtensionForExtension("Extension", "ModelExtension",textExtension, "xmi");
	}
	/**
	 * Return the ModelExtension for the given text extension
	 * Return "txt" if none found
	 * @param modelExtension
	 * @return
	 */
	static public String getTextExtensionForModelExtension(String modelExtension){
		return getExtensionForExtension("ModelExtension", "Extension",modelExtension, "txt");
	}
	
	/**
	 * Return the URI of the STS for the given model extension
	 * Return null if none found
	 * @param textExtension
	 * @return
	 */
	static public URI getSTSforModelExtension(String modelExtension){
		return getSTSforGenericExtension("ModelExtension", modelExtension);
	}
	
	static protected URI getSTSforGenericExtension(String extentionName, String extension){
		IExtensionRegistry registry = RegistryFactory.getRegistry();
		
		/* Get all extensions of sintaks files registration.	 */
		IExtensionPoint extensionPoint = registry.getExtensionPoint(SintaksPlugin.EXTENSION_POINT_REGISTRATION);
		IExtension[] extensions;
		if(extensionPoint ==  null){
			return null;
		}
		else	
			extensions = extensionPoint.getExtensions();
		
		/* For all extensions, .
		 */
		for ( int i = 0; i < extensions.length; i++ ) {
			IConfigurationElement[] elements = extensions[i].getConfigurationElements();
			for ( int j = 0; j < elements.length; j++ ) {
				
				if ( elements[j].getAttribute(extentionName).equals(extension) ) {
					URI uri = URI.createURI("platform:/plugin/" + extensions[i].getContributor().getName() + "/" + elements[j].getAttribute("File"));
					return uri;
				}
			}
		}
		return null;
	}
	static public String getExtensionForExtension(String sourceExtension, String targetExtension, String searchedFileExtension, String defaultValue){
		String result  = defaultValue;
		IExtensionRegistry registry = RegistryFactory.getRegistry();
		
		/* Get all extensions of sintaks files registration.	 */
		IExtensionPoint extensionPoint = registry.getExtensionPoint(SintaksPlugin.EXTENSION_POINT_REGISTRATION);
		IExtension[] extensions;
		if(extensionPoint ==  null){
			return null;
		}
		else	
			extensions = extensionPoint.getExtensions();
		
		/* For all extensions, .
		 */
		for ( int i = 0; i < extensions.length; i++ ) {
			IConfigurationElement[] elements = extensions[i].getConfigurationElements();
			for ( int j = 0; j < elements.length; j++ ) {
				
				if ( elements[j].getAttribute(sourceExtension).equals(searchedFileExtension) ) {
					return elements[j].getAttribute(targetExtension);
				}
			}
		}
		return result;
	}
}


