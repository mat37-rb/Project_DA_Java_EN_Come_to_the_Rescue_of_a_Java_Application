package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class SaveSymptomDataToFile implements ISymptomWriter {

	private String filepath;

	/**
	 * 
	 * @param filepath a full or partial path to file containing a set of symptom
	 *                 strings without duplicate and how many there are, one per
	 *                 line
	 */
	public SaveSymptomDataToFile(String filepath) {
		this.filepath = filepath;
	}

	@Override
	public void saveSymptoms(TreeMap<String, Integer> sortedMap) {
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filepath));) {
			for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
				String key = entry.getKey();
				Integer value = entry.getValue();
				bufferedWriter.write(key.toUpperCase() + " : " + value);
				bufferedWriter.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
