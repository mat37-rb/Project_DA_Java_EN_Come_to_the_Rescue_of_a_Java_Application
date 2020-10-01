package com.hemebiotech.analytics;

import java.util.TreeMap;

public interface ISymptomWriter {
	/**

	 * @return an ordonned map of all Symptoms obtained from a listing
	 */
	 void SaveSymptoms (TreeMap<String, Integer> symptomsMap);
}
