package com.autoiq.common.utility;

import java.util.Properties;

public class TestData {

	public static void main(String[] args) throws HandleException {
		DataStoreInObjects locators=new DataStoreInObjects();
		locators=CommonUtility.loadData("Test Data","LoginTestData");
		locators.getValue("userName");
		System.out.println(locators.getValue("userName"));
//		Properties testData = CommonUtility.loadDataDemo("Page Objects","LoginPage");
//		Properties locators = CommonUtility.loadDataDemo("Test Data","DefinitionTestData");
//		System.out.println(testData.getProperty("userName"));
//		System.out.println(locators.getProperty("definitionName"));
//		System.out.println(locators.getProperty("definitionNameWithDescription"));
//		System.out.println(testData.getProperty("userName"));
//		System.out.println(locators.getProperty("onFailureRestart"));
	}
	
}
