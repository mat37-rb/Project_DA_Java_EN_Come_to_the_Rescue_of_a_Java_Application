package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.List;
import java.util.TreeMap;

public class Analytics {

	public static void main(String[] args) throws IOException {
		
		ISymptomReader read = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
		ISymptomWriter writer = new SaveSymptomDataToFile("Project02Eclipse/result.out.txt");
		AnalyticsCounter analyticsCounter = new AnalyticsCounter(read, writer);
		List<String> maListe = analyticsCounter.getSymptoms();
		System.out.println(maListe);
		TreeMap<String, Integer> maMap = analyticsCounter.mapSymptoms(maListe);
		System.out.println(maMap);
		analyticsCounter.saveSymptoms(maMap);
	}
}