package org.kermeta.sintaks;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.kermeta.sintaks.SintaksPlugin;


public class PreferenceInitializer extends AbstractPreferenceInitializer {

	@Override
	public void initializeDefaultPreferences() {
		SintaksPlugin.getDefault().getOptionManager().initializeDefaults();
	}

}
