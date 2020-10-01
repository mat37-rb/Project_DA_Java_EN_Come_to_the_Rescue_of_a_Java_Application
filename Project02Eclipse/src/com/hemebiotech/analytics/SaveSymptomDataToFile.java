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
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public SaveSymptomDataToFile (String filepath) {
		this.filepath = filepath;
	}

	@Override
	public void SaveSymptoms (TreeMap<String, Integer> sortedMap) {
			try {
				BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filepath));
					for (Map.Entry<String, Integer> entry: sortedMap.entrySet() ) {
						String key = entry.getKey();
						Integer value = entry.getValue();
//					System.out.print("Le sympt�me " + key.toUpperCase());
//					System.out.println(" appara�t " + value + " fois");
						bufferedWriter.write("Le sympt�me " + key.toUpperCase());
						bufferedWriter.write(" appara�t " + value + " fois");
						bufferedWriter.newLine();
					}
						bufferedWriter.newLine();
						bufferedWriter.write("Ce fichier contient " + sortedMap.size() + " sympt�mes diff�rents");
						bufferedWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}	
}
