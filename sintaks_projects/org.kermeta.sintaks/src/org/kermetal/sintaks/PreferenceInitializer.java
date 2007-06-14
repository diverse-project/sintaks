package org.kermetal.sintaks;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.kermetal.sintaks.SintaksPlugin;


public class PreferenceInitializer extends AbstractPreferenceInitializer {

	@Override
	public void initializeDefaultPreferences() {
		SintaksPlugin.getDefault().getOptionManager().initializeDefaults();
	}

}
