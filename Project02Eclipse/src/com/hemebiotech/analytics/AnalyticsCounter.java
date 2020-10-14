package com.hemebiotech.analytics;

import java.util.List;
import java.util.TreeMap;

public class AnalyticsCounter {
	
	private ISymptomReader symptomReader;
	private ISymptomWriter symptomWriter;
	/** 
	 * @param symptomReader et symptomWriter sont des variables de type
	 * Interface qui vont permettre de recuperer les chemins pour
	 *  le fichier a lire et celui à ecrire
	 */

	public AnalyticsCounter (ISymptomReader symptomReader,
							 ISymptomWriter symptomWriter) {
		this.symptomReader = symptomReader;
		this.symptomWriter = symptomWriter;
	}
	/**
	 *  Methode pour lire le fichier et l'ajouter à une liste
	 * @return Liste des symptômes et ces doublons
	 */
	public List<String> getSymptoms() {
		return symptomReader.GetSymptoms();
	}
	/**
	 *  Methode pour ecrire dans le ficher
	 * @param symptomsMap
	 */
	public void saveSymptoms (TreeMap<String, Integer> symptomsMap) {
		symptomWriter.SaveSymptoms(symptomsMap);
	}
	/**
	 *  Methode pour trier, quantifier et ordonner les symptomes
	 * @param mapSymptoms
	 */
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