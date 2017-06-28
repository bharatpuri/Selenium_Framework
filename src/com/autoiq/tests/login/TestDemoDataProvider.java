package com.autoiq.tests.login;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.autoiq.common.utility.CommonUtility;
import com.autoiq.common.utility.CommonWebFunctions;
import com.autoiq.common.utility.DataStoreInObjects;
import com.autoiq.common.utility.HandleException;

public class TestDemoDataProvider {
	CommonWebFunctions actions = new CommonWebFunctions();
	DataStoreInObjects locators = new DataStoreInObjects();
	DataStoreInObjects testData = new DataStoreInObjects();

	public TestDemoDataProvider() throws HandleException {

		locators = CommonUtility.loadLocators("Page Objects", "LoginPage");
		testData = CommonUtility.loadTestData("Test Data", "LoginTestData");

	}
	
	@DataProvider(name = "Authentication")
	public Object[][] credentials() throws HandleException {
		return new Object[][] { {testData.getValue("userName"), testData.getValue("password")}, { "testuser_1", "Test@123" } };

	}

	// Here we are calling the Data Provider object with its Name
	@Test(dataProvider = "Authentication")
	public void login(String sUsername, String sPassword) {
	}
}
