package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.List;
import java.util.TreeMap;

public class Analytics {

	public static void main(String[] args) throws IOException {
		
		/** 
		 * @param read et writer vont permettre d'instancier notre objet analyticsCounter
		 * et lui precisez quel chemin prendre
		 */
		ISymptomReader read = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
		ISymptomWriter writer = new SaveSymptomDataToFile("Project02Eclipse/result.out.txt");
		/** 
		 * analyticsCounter va nous permettre d'appeler les methodes qui vont permettre de
		 * lire le fichier, le trier, le quantifier, l'ordonner et le sauvegarder.
		 */
		AnalyticsCounter analyticsCounter = new AnalyticsCounter(read, writer);
		List<String> maListe = analyticsCounter.getSymptoms();
		System.out.println(maListe);
		TreeMap<String, Integer> maMap = analyticsCounter.mapSymptoms(maListe);
		System.out.println(maMap);
		analyticsCounter.saveSymptoms(maMap);
	}
}