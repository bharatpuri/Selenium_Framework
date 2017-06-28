package com.autoiq.common.utility;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import org.testng.annotations.DataProvider;

import au.com.bytecode.opencsv.CSVReader;

/**
 * The Class ReadCSVFile.
 * @author Dhanashree
 */
public class CSVDataProvider {
	
	/**
	 * Gets the data from csv file.
	 *
	 * @param testMethod the test method
	 * @return the data from csv file
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@DataProvider(name="CSVData")
	public static Object[][] getDataFromCsvFile(final Method testMethod) throws IOException {
		DataProviderArguments parameters = testMethod.getAnnotation(DataProviderArguments.class);

	    if (parameters != null) {
	        String path = parameters.path();
	        return loadDataFromCsvFile(path);			
	    } else {
	        throw new RuntimeException("Couldn't find the annotation");
	    }
	}
	
	/**
	 * Load data from csv file.
	 *
	 * @param CSVpath the CS vpath
	 * @return the object[][]
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static Object[][] loadDataFromCsvFile(String CSVpath) throws IOException {
		
		 CSVReader reader = new CSVReader(new FileReader(CSVpath), ',', '"', 1);
	       
	      //Read all rows at once
	      List<String[]> allRows = reader.readAll();
	      Object[][] matrix=new String[allRows.size()][];
	        matrix=allRows.toArray(matrix);
	        return matrix;
	

	        
//		int rows = 0;
//		try {
//			CSVReader csvReader = new CSVReader(new FileReader(CSVpath));
//			rows = csvReader.readAll().size();
//			csvReader.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//				
//		FileReader fr = new FileReader(CSVpath);
//		BufferedReader br = new BufferedReader(fr);	
//		int numOfColumns = br.readLine().split(",").length;
//		
//		Object[][] finalArray = new Object[rows-1][numOfColumns];
//		String lines;
//		String[] myArray;		
//		
//		try {
//			int i = 0;
//			while((lines=br.readLine()) != null) {				
//				myArray = lines.split(",");
//				for (int j = 0; j < numOfColumns; j++) {					
//					finalArray[i][j] = myArray[j];
//				}
//				i++;
//			}			
//			br.close();
//		} catch (FileNotFoundException fnf) {
//			fnf.printStackTrace();
//		} catch (IOException io) {
//			io.printStackTrace();
//		}
//		return finalArray;
	}
	
	
}
