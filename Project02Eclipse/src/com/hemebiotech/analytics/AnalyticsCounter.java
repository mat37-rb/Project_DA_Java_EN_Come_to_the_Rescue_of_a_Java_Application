package com.hemebiotech.analytics;

import java.util.List;
import java.util.TreeMap;

public class AnalyticsCounter {
	
	private ISymptomReader symptomReader;
	private ISymptomWriter symptomWriter;
	/** 
	 * @param symptomReader et symptomWriter sont des variables de type
	 * Interface qui vont permettre de récupérer les chemins pour
	 *  le fichier à lire et celui à écrire
	 */

	public AnalyticsCounter (ISymptomReader symptomReader,
							 ISymptomWriter symptomWriter) {
		this.symptomReader = symptomReader;
		this.symptomWriter = symptomWriter;
	}
	// Méthode pour lire le fichier et l'ajouter à une liste
	public List<String> getSymptoms() {
		return symptomReader.GetSymptoms();
	}
	// Méthode pour écrire dans le ficher
	public void saveSymptoms (TreeMap<String, Integer> symptomsMap) {
		symptomWriter.SaveSymptoms(symptomsMap);
	}
	// Méthode pour trier, quantifier et ordonner les symptômes
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