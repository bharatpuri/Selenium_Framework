package com.autoiq.common.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import com.autoiq.common.utility.HandleException;

/**
 * This class consist of method which are common to all framework
 * 
 * @author bharatp : 14/04/2017
 *
 */
public class CommonUtility {

	static DataStoreInObjects allLocators = null;
	static DataStoreInObjects allConfigData = null;
	static DataStoreInObjects allTestData = null;

	final static Logger logger = Logger.getLogger(CommonUtility.class.getName());

	/**
	 * This method will check the file is exist in selected directory or not
	 * 
	 * @param filePath
	 * @return true or false
	 */
	public static boolean isFileExit(String filePath) {
		File files = new File(filePath);
		return files.exists();
	}
	
	/** This method will load the data from selected property file
	 * @param folderName
	 * @param fileName
	 * @return mapData
	 * @throws HandleException
	 */
	public static DataStoreInObjects loadData(String folderName, String fileName) throws HandleException {
		Properties configData = new Properties();
		DataStoreInObjects mapData = new DataStoreInObjects();
		String filePath = "src/" + folderName + "/" + fileName + ".properties";
		
		if (isFileExit(filePath)) {
			InputStream fileData = null;
			try {
				fileData = new FileInputStream(filePath);
				try {
					if (fileData.read() != -1) {
						try {
							configData.load(new FileInputStream(filePath));
							logger.info("Property file is loaded successfully: " + filePath);
						} catch (IOException e) {
							e.printStackTrace();
						}
					} else {
						logger.debug("File is empty: " + filePath);
						throw new HandleException("File is empty: " + filePath);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			logger.error("Filed file not found: " + filePath);
			throw new HandleException("Filed file not found: " + filePath);
		}
		Set<String> propertyNames = configData.stringPropertyNames();
		for (String Property : propertyNames) {
			mapData.put(Property, configData.getProperty(Property));
		}
		return mapData;
	}

	/**
	 * This method will get the Locators from selected file and store in
	 * locators object
	 * 
	 * @param fileName
	 * @return locators
	 * @throws HandleException
	 */
	public static DataStoreInObjects loadLocators(String folderName, String fileName) throws HandleException {
		return allLocators = CommonUtility.loadData(folderName, fileName);
	}

	/**
	 * This method will get the test data from selected file and store in
	 * testData object
	 * 
	 * @param fileName
	 * @return testData
	 * @throws HandleException
	 */
	public static DataStoreInObjects loadTestData(String folderName, String fileName) throws HandleException {
		return allTestData = CommonUtility.loadData(folderName, fileName);
	}
	
	/**
	 * This method will get the configuration data from selected file and store in
	 * configData object
	 * 
	 * @param fileName
	 * @return testData
	 * @throws HandleException
	 */
	public static DataStoreInObjects loadConfigData(String folderName, String fileName) throws HandleException {
		return allConfigData = CommonUtility.loadData(folderName, fileName);
	}
	
	/**
	 * This method will wait for provided seconds 
	 * @throws InterruptedException 
	 */
	public static void waitSeconds(int seconds) throws InterruptedException{
		TimeUnit.SECONDS.sleep(seconds);
		
	}
	public static Properties loadDataDemo(String folderName, String fileName) throws HandleException {
		Properties configData = new Properties();
		//DataStoreInObjects mapData = new DataStoreInObjects();
		String filePath = "src/" + folderName + "/" + fileName + ".properties";
		
		if (isFileExit(filePath)) {
			InputStream fileData = null;
			try {
				fileData = new FileInputStream(filePath);
				try {
					if (fileData.read() != -1) {
						try {
							configData.load(new FileInputStream(filePath));
							logger.info("Property file is loaded successfully: " + filePath);
						} catch (IOException e) {
							e.printStackTrace();
						}
					} else {
						logger.debug("File is empty: " + filePath);
						throw new HandleException("File is empty: " + filePath);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			logger.error("Filed file not found: " + filePath);
			throw new HandleException("Filed file not found: " + filePath);
		}
//		Set<String> propertyNames = configData.stringPropertyNames();
//		for (String Property : propertyNames) {
//			mapData.put(Property, configData.getProperty(Property));
		//}
		return configData;
	}


}
