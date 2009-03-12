package fr.uha.mips.sintaks.ecore2hutn;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;

public class PreferenceInitializer extends AbstractPreferenceInitializer {

	@Override
	public void initializeDefaultPreferences() {
		Ecore2HUTNPlugin.getDefault().getOptionManager().initializeDefaults();
	}

}
