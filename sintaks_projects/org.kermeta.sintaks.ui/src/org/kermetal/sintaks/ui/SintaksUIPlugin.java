package org.kermetal.sintaks.ui;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The main plugin class to be used in the desktop.
 */
public class SintaksUIPlugin extends AbstractUIPlugin {

	//The shared instance.
	private static SintaksUIPlugin plugin;
	public static final String PLUGIN_ID = "org.kermeta.sintaks.ui";
	public static final String MESSAGES_BUNDLE = PLUGIN_ID+".messages";
	private ResourceBundle resourceBundle;
	private static final int INTERNAL_ERROR = 10001;

	/**
	 * The constructor.
	 */
	public SintaksUIPlugin() {
		plugin = this;
		try {
			resourceBundle = ResourceBundle.getBundle(MESSAGES_BUNDLE);
		} catch (MissingResourceException x) {
			resourceBundle = null;
		}
	}

	/**
	 * This method is called upon plug-in activation
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
	}

	/**
	 * This method is called when the plug-in is stopped
	 */
	public void stop(BundleContext context) throws Exception {
		super.stop(context);
		plugin = null;
	}

	/**
	 * Returns the shared instance.
	 */
	public static SintaksUIPlugin getDefault() {
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
	
}
