package com.hemebiotech.analytics;

import java.util.List;
import java.util.TreeMap;

public class AnalyticsCounter {
	
	private ISymptomReader symptomReader;
	private ISymptomWriter symptomWriter;
	/** 
	 * @param symptomReader et symptomWriter sont des variables de type
	 * Interface qui vont permettre de r�cup�rer les chemins pour
	 *  le fichier � lire et celui � �crire
	 */

	public AnalyticsCounter (ISymptomReader symptomReader,
							 ISymptomWriter symptomWriter) {
		this.symptomReader = symptomReader;
		this.symptomWriter = symptomWriter;
	}
	// M�thode pour lire le fichier et l'ajouter � une liste
	public List<String> getSymptoms() {
		return symptomReader.GetSymptoms();
	}
	// M�thode pour �crire dans le ficher
	public void saveSymptoms (TreeMap<String, Integer> symptomsMap) {
		symptomWriter.SaveSymptoms(symptomsMap);
	}
	// M�thode pour trier, quantifier et ordonner les sympt�mes
	public TreeMap<String, Integer> mapSymptoms(List<String> symptomList) {
		TreeMap<String, Integer> mapSymptoms = new TreeMap<>();		
		for (String element : symptomList) {
			if (!mapSymptoms.containsKey(element)) {
				mapSymptoms.put(element, 1);
			} else {
				mapSymptoms.put(element, mapSymptoms.get(element) + 1);
			}
		}
		return mapSymptoms;
	}
}