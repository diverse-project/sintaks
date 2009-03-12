/*
 * Created on 2 Mars 2009
 *
 * Contributor : michel Hassenforder
 * 
 */
package fr.uha.mips.sintaks.ecore2hutn;

import org.eclipse.jface.preference.IPreferenceStore;


/**
 * Option Manager for the java_cup syntax editor
 * 
 * @author michel Hassenforder
 * 
 */
public class OptionManager {

	private static final String PREFIX = Ecore2HUTNPlugin.PLUGIN_ID + ".";

	public static final String ADJECTIVE_ALLOWED = PREFIX + "adjectiveAllowed";
	public static final String ADJECTIVE_BEFORE  = PREFIX + "adjectiveBefore";
	public static final String PROTECT_ATT_1     = PREFIX + "protect.attribute.single";
	public static final String PROTECT_ATT_N	 = PREFIX + "protect.attribute.many";
	public static final String PROTECT_CONT_1    = PREFIX + "protect.container.single";
	public static final String PROTECT_CONT_N	 = PREFIX + "protect.container.many";
	public static final String PROTECT_REF_1	 = PREFIX + "protect.reference.single";
	public static final String PROTECT_REF_N	 = PREFIX + "protect.reference.many";
	public static final String PROTECT_ADJ   	 = PREFIX + "protect.adjective";

	private IPreferenceStore store;

	public OptionManager (IPreferenceStore store) {
		this.store = store;
	}

	/**
	 * Set default in preference store.
	 */
	public void initializeDefaults() {
		store.setDefault(ADJECTIVE_ALLOWED, false);
		store.setDefault(ADJECTIVE_BEFORE, false);
		store.setDefault(PROTECT_ATT_1, false);
		store.setDefault(PROTECT_ATT_N, false);
		store.setDefault(PROTECT_CONT_1, false);
		store.setDefault(PROTECT_CONT_N, false);
		store.setDefault(PROTECT_REF_1, true);
		store.setDefault(PROTECT_REF_N, true);
		store.setDefault(PROTECT_ADJ, false);
	}

	public boolean isAdjectiveAllowed () {
		return store.getBoolean (ADJECTIVE_ALLOWED);
	}

	public void setAdjectiveAllowed (boolean  adjectiveAllowed) {
		store.setValue(ADJECTIVE_ALLOWED, adjectiveAllowed);
	}

	public boolean isAdjectiveBefore () {
		return store.getBoolean (ADJECTIVE_BEFORE);
	}

	public void setAdjectiveBefore (boolean adjectiveBefore) {
		store.setValue(ADJECTIVE_BEFORE, adjectiveBefore);
	}

	public boolean [] getProtections () {
		boolean [] protections = new boolean [7];
		protections[0] = store.getBoolean (PROTECT_ATT_1);
		protections[1] = store.getBoolean (PROTECT_ATT_N);
		protections[2] = store.getBoolean (PROTECT_CONT_1);
		protections[3] = store.getBoolean (PROTECT_CONT_N);
		protections[4] = store.getBoolean (PROTECT_REF_1);
		protections[5] = store.getBoolean (PROTECT_REF_N);
		protections[6] = store.getBoolean (PROTECT_ADJ);
		return protections;
	}

	public void setProtections (boolean [] protections) {
		store.setValue (PROTECT_ATT_1, protections[0]);
		store.setValue (PROTECT_ATT_N, protections[1]);
		store.setValue (PROTECT_CONT_1, protections[2]);
		store.setValue (PROTECT_CONT_N, protections[3]);
		store.setValue (PROTECT_REF_1, protections[4]);
		store.setValue (PROTECT_REF_N, protections[5]);
		store.setValue (PROTECT_ADJ, protections[6]);
	}
}
