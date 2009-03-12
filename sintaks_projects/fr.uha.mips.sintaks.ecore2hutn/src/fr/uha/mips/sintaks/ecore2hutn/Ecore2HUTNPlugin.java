/* 
 * Project: sintaks
 * File: Ecore2HUTNPlugin.java
 * License: EPL
 * Copyright: MIPS / Universite de Haute Alsace
 * ----------------------------------------------------------------------------
 * Creation date: Dec 24, 2007
 * Authors: 
 * 			Michel Hassenforder
 */
package fr.uha.mips.sintaks.ecore2hutn;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Ecore2HUTNPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "fr.uha.mips.sintaks.ecore2hutn";
	private static final int INTERNAL_ERROR = 10001;
	public static final String MESSAGES_BUNDLE = PLUGIN_ID+".messages";
	private ResourceBundle resourceBundle;
	private OptionManager optionManager;

	// The shared instance
	private static Ecore2HUTNPlugin plugin;
	
	/**
	 * The constructor
	 */
	public Ecore2HUTNPlugin() {
		plugin = this;
		try {
			resourceBundle = ResourceBundle.getBundle(MESSAGES_BUNDLE);
		} catch (MissingResourceException x) {
			resourceBundle = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Ecore2HUTNPlugin getDefault() {
		return plugin;
	}

    /**
	 * Returns the string from the plugin's resource bundle,
	 * or 'key' if not found.
	 */
	public static String getResourceString(String key) {
		ResourceBundle bundle = getDefault().getResourceBundle();
		try {
			return (bundle != null) ? bundle.getString(key) : key;
		} catch (MissingResourceException e) {
			return key;
		}
	}

	/**
	 * Returns the plugin's resource bundle,
	 */
	public ResourceBundle getResourceBundle() {
		return resourceBundle;
	}

    public OptionManager getOptionManager () {
        if (optionManager == null) {
        	optionManager = new OptionManager(getPreferenceStore());
        }
        return optionManager;
    }

	/**
	 * This method logs a Status
	 * 
	 * @param status IStatus
	 */
	public static void log(IStatus status) {
		getDefault().getLog().log(status);
	}
	
	/**
	 * This method logs an exception
	 * 
	 * @param e Throwable
	 */
	public static void log(Throwable e) {
		log(new Status(IStatus.ERROR, PLUGIN_ID, INTERNAL_ERROR, "Sintaks Internal Error", e));
	}

	/**
	 * Send a message to the user via the GUI
	 * @param message
	 */
	public void reportErrorToUser(String message){
		MessageBox mb = (new MessageBox(new Shell(), SWT.OK | SWT.ICON_WARNING));
    	mb.setMessage(message);
    	mb.open();
	}
}
