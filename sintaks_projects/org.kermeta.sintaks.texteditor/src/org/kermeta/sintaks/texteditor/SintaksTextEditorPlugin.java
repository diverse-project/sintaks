/* $Id: SintaksTextEditorPlugin.java,v 1.6 2008-05-28 14:05:29 dvojtise Exp $
 * Project : org.kermeta.sintaks.texteditor
 * File : SintaksTexteditorPlugin.java
 * License : EPL
 * Copyright : IRISA / INRIA
 * ----------------------------------------------------------------------------
 * Authors : 
 * 		dtouzet <dtouzet@irisa.fr
 *     	dvojtise <dvojtise@irisa.fr>
 */
package org.kermeta.sintaks.texteditor;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.logging.Log;
import org.eclipse.core.internal.registry.ExtensionRegistry;
import org.eclipse.core.runtime.ContributorFactoryOSGi;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IContributor;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.RegistryFactory;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import org.kermeta.log4j.util.LogConfigurationHelper;

/**
 * The activator class controls the plug-in life cycle
 */
public class SintaksTextEditorPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.kermeta.sintaks.textualeditor";
	
	public static final String stsFilesRegistration_ExtensionPoint_NAME ="org.kermeta.sintaks.stsFilesRegistration";

	//static final public URL pluginURL = getDefault().getBundle().getEntry("/");
	
	// The shared instance
	private static SintaksTextEditorPlugin plugin;
	
	final static private Log internalLog = LogConfigurationHelper.getLogger("SintakstextEditor");
	
	/**
	 * The constructor
	 */
	public SintaksTextEditorPlugin() {
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		
		IExtensionRegistry registry = RegistryFactory.getRegistry();
		Object key = ((ExtensionRegistry) registry).getTemporaryUserToken();
		IContributor contributor = ContributorFactoryOSGi.createContributor( getBundle() );
		
		/*
		 * 
		 * Getting all extensions of sintaks files registration.
		 * 
		 */
		IExtensionPoint extensionPoint = registry.getExtensionPoint(stsFilesRegistration_ExtensionPoint_NAME);
		IExtension[] extensions = extensionPoint.getExtensions();
		
		/*
		 * 
		 * For all extensions, generate an editor for all ConfigurationElement.
		 * An extension can have one or more registration (one registration corresponds to one ConfigurationElement).
		 * 
		 */
		for ( int i = 0; i < extensions.length; i++ ) {
			
			IConfigurationElement[] elements = extensions[i].getConfigurationElements();
			for ( int j = 0; j < elements.length; j++ ) {
				
				String extensionAsString = createExtension( elements[j] );
			
				ByteArrayInputStream is = new ByteArrayInputStream( extensionAsString.getBytes() );
				
				try {

					boolean result = Platform.getExtensionRegistry().addContribution(is, contributor, false, null, null, key);
					if ( ! result ) {
						String message = "Sintaks Text Editor for " + elements[i].getAttribute("Extension") + " files could not be set up.";
						getLog().log(new Status(Status.WARNING, PLUGIN_ID, Status.WARNING, message, null));
						error(message);
					}
						
				} finally {

					try {
						is.close();
					} catch (IOException e) {}
				}				
				
			}
			
		}
		
		info("Sintaks Editor have been set up.");
		
	}
	
	/**
	 * operation used to dynamically declare a plugin extension in eclipse.
	 * Used to add editor, and popups for extensions associated with the STS
	 * @param element
	 * @return
	 */
	private String createExtension(IConfigurationElement element) {
		String t2m_label = element.getAttribute("text2model_popup_label") == null ? "Text 2 model" : element.getAttribute("text2model_popup_label");
		String m2t_label = element.getAttribute("model2text_popup_label") == null ? "Model 2 text" : element.getAttribute("model2text_popup_label");
		String modelExtension = element.getAttribute("ModelExtension") == null ? "xmi" : element.getAttribute("ModelExtension");
 		
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<?eclipse version=\"3.2\"?>");
		sb.append("<plugin>");
		// part for the editor
		sb.append("<extension point=\"org.eclipse.ui.editors\"");
		sb.append("    id=\"" + getEditorId(element) + "\">");
		sb.append("		<editor class=\"org.kermeta.sintaks.texteditor.SintaksTextEditor\"");
		sb.append("			default=\"false\"");
		sb.append("			extensions=\"" + element.getAttribute("Extension") + "\"");
		sb.append("			icon=\"icons/kermeta_logo_32.gif\"");
		sb.append("			id=\"org.kermeta.sintaks.texteditor." + element.getAttribute("Extension") + "\"");
		sb.append("			name=\"Sintaks Text Editor for "+ element.getAttribute("Extension") +"\"/>");
		sb.append("</extension>");
		// part that adds the Text2Model popup for this file extension
		sb.append("<extension point=\"org.eclipse.ui.popupMenus\">");
		sb.append("    <objectContribution");
		sb.append("           adaptable=\"false\"");
		sb.append("           id=\"org.kermeta.sintaks.ui.objectContribution2\"");
		sb.append("           nameFilter=\"*." + element.getAttribute("Extension") + "\"");
		sb.append("           objectClass=\"org.eclipse.core.resources.IFile\">");
		sb.append("        <menu");
		sb.append("              id=\"org.kermeta.sintaks.subMenu\"");
		sb.append("              label=\"Sintaks\"");
		sb.append("              path=\"additions\">");
		sb.append("           <separator name=\"sintaksgroup1\"/>");
		sb.append("        </menu>");
		sb.append("        <action class=\"org.kermeta.sintaks.ui.Text2ModelAction\"");
		sb.append("              enablesFor=\"1\"");
		sb.append("              icon=\"icons/Sintaks.gif\"");
		sb.append("              id=\"org.kermeta.sintaks.ui.textloader.Text2Model\"");
		sb.append("              label=\""+ t2m_label +"\"");
		sb.append("              menubarPath=\"org.kermeta.sintaks.subMenu/sintaksgroup1\"/>");
		sb.append("     </objectContribution>");
		sb.append("     </extension>");
		// part that adds the Model2Text popup for this file extension
		sb.append("<extension point=\"org.eclipse.ui.popupMenus\">");
		sb.append("    <objectContribution");
		sb.append("           adaptable=\"false\"");
		sb.append("           id=\"org.kermeta.sintaks.ui.objectContribution1\"");
		sb.append("           nameFilter=\"*." + modelExtension + "\"");
		sb.append("           objectClass=\"org.eclipse.core.resources.IFile\">");
		sb.append("        <menu");
		sb.append("              id=\"org.kermeta.sintaks.subMenu\"");
		sb.append("              label=\"Sintaks\"");
		sb.append("              path=\"additions\">");
		sb.append("           <separator name=\"sintaksgroup1\"/>");
		sb.append("        </menu>");
		sb.append("        <action class=\"org.kermeta.sintaks.ui.Model2TextAction\"");
		sb.append("              enablesFor=\"1\"");
		sb.append("              icon=\"icons/Sintaks.gif\"");
		sb.append("              id=\"org.kermeta.sintaks.ui.textloader.Model2Text\"");
		sb.append("              label=\""+ m2t_label +"\"");
		sb.append("              menubarPath=\"org.kermeta.sintaks.subMenu/sintaksgroup1\"/>");
		sb.append("     </objectContribution>");
		sb.append("     </extension>");
		sb.append("</plugin>");
		return sb.toString();
		
	}
	
	static public void initializeEditors() {}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	
		IExtensionRegistry registry = RegistryFactory.getRegistry();
		Object key = ((ExtensionRegistry) registry).getTemporaryUserToken();
		
		/*
		 * 
		 * Getting all extensions of sintaks files registration.
		 * 
		 */
		IExtensionPoint extensionPoint = registry.getExtensionPoint(stsFilesRegistration_ExtensionPoint_NAME);
		IExtension[] extensions = extensionPoint.getExtensions();
		
		/*
		 * 
		 * For all extensions, generate an editor for all ConfigurationElement.
		 * An extension can have one or more registration (one registration corresponds to one ConfigurationElement).
		 * 
		 */
		for ( int i = 0; i < extensions.length; i++ ) {
			
			IConfigurationElement[] elements = extensions[i].getConfigurationElements();
			for ( int j = 0; j < elements.length; j++ ) {
				
				IExtension extensionToRemove = registry.getExtension( getEditorId(elements[j]) );
				registry.removeExtension(extensionToRemove, key);
							
			}
			
		}
		
		info("Sintaks Editor have been set down.");
	}

	static public URL getPluginURL() {
		return getDefault().getBundle().getEntry("/");
	}
	
	private String getEditorId(IConfigurationElement element) {
		return "org.kermeta.sintaks.texteditor." + element.getAttribute("Extension");
	}
	
	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static SintaksTextEditorPlugin getDefault() {
		return plugin;
	}
	
	static public void warn(String message) {
		internalLog.warn( message );
	}
	
	static public void debug(String message) {
		internalLog.debug( message );
	}
	
	static public void error(String message) {
		internalLog.error( message );
	}

	static public void info(String message) {
		internalLog.info( message );
	}
}
