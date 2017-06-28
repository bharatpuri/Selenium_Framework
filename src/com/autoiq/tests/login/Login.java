package com.autoiq.tests.login;

import org.apache.log4j.Logger;

import com.autoiq.common.utility.CommonUtility;
import com.autoiq.common.utility.CommonWebFunctions;
import com.autoiq.common.utility.DataStoreInObjects;
import com.autoiq.common.utility.HandleException;

/**
 * This class consist the all login scenarios
 * 
 * @author bharatp : 17/04/2017
 *
 */
public class Login {
	final static Logger logger = Logger.getLogger(Login.class.getName());
	CommonWebFunctions actions = new CommonWebFunctions();
	DataStoreInObjects locators = new DataStoreInObjects();
	DataStoreInObjects testData = new DataStoreInObjects();

	public Login() throws HandleException {

		locators = CommonUtility.loadLocators("Page Objects", "LoginPage");
		testData = CommonUtility.loadTestData("Test Data", "LoginTestData");

	}

	/**
	 * Verify the login functionality with Valid credentials
	 * 
	 * @throws HandleException
	 * @throws InterruptedException 
	 */
	public void loginWithValidCredentials() throws HandleException, InterruptedException {
		actions.launchBrowser();
		actions.sendKeysToElement(testData.getValue("userName"), locators.getValue("userName"));
		actions.sendKeysToElement(testData.getValue("password"), locators.getValue("password"));
		actions.clickOnElement(locators.getValue("loginButton"));
		actions.verifyTextWithAssertContains(actions.getElementText(locators.getValue("dashboard")),
				testData.getValue("dashboard"));
		logger.info("Verified login functionality with Valid credentials: ");
	}

	/**
	 * Verify the login functionality with inValid credentials
	 * 
	 * @throws HandleException
	 * @throws InterruptedException 
	 */
	public void loginWithInvalidCredentials() throws HandleException, InterruptedException {
		actions.launchBrowser();
		actions.sendKeysToElement(testData.getValue("invalidUsername"), locators.getValue("userName"));
		actions.sendKeysToElement(testData.getValue("invalidPassword"), locators.getValue("password"));
		actions.clickOnElement(locators.getValue("loginButton"));
		actions.verifyTextWithAssertContains(actions.getElementText(locators.getValue("dashboard")),
				testData.getValue("dashboard"));
		logger.info("Verified login functionality with Invalid credentials: ");
	}

	/**
	 * Verify the login functionality without providing userName and password
	 * 
	 * @throws HandleException
	 */
	public void loginWithBlankCredentials() throws HandleException {
		actions.launchBrowser();
		actions.clickOnElement(locators.getValue("loginButton"));
		actions.verifyTextWithAssertContains(actions.getElementText(locators.getValue("invalidCredentialMsg")),
				testData.getValue("invalidCredentialMsg"));
		logger.info("Verified login functionality with black credentials: ");
	}

	/**
	 * Verify login functionality with invalid userName and valid password
	 * 
	 * @throws HandleException
	 * @throws InterruptedException 
	 */
	public void loginWithInvalidUsername() throws HandleException, InterruptedException {
		actions.launchBrowser();
		actions.sendKeysToElement(testData.getValue("invalidUsername"), locators.getValue("userName"));
		actions.sendKeysToElement(testData.getValue("password"), locators.getValue("password"));
		actions.clickOnElement(locators.getValue("loginButton"));
		actions.verifyTextWithAssertContains(actions.getElementText(locators.getValue("invalidCredentialMsg")),
				testData.getValue("invalidCredentialMsg"));
		logger.info("Verified login functionality with Invalid userNames: ");

	}

	/**
	 * Verify login functionality with valid userName and invalid password
	 * 
	 * @throws HandleException
	 * @throws InterruptedException 
	 */
	public void loginWithInvalidPassword() throws HandleException, InterruptedException {
		actions.launchBrowser();
		actions.sendKeysToElement(testData.getValue("userName"), locators.getValue("userName"));
		actions.sendKeysToElement(testData.getValue("invalidPassword"), locators.getValue("password"));
		actions.clickOnElement(locators.getValue("loginButton"));
		actions.verifyTextWithAssertContains(actions.getElementText(locators.getValue("invalidCredentialMsg")),
				testData.getValue("invalidCredentialMsg"));
		logger.info("Verified login functionality with Invalid password : ");

	}

	/**
	 * This method will verify login functionality providing special character
	 * as userName and password
	 * 
	 * @throws HandleException
	 * @throws InterruptedException 
	 */
	public void loginWithSpceialCharater() throws HandleException, InterruptedException {
		actions.launchBrowser();
		actions.sendKeysToElement(testData.getValue("specialUsername"), locators.getValue("userName"));
		actions.sendKeysToElement(testData.getValue("specialPassword"), locators.getValue("password"));
		actions.clickOnElement(locators.getValue("loginButton"));
		actions.verifyTextWithAssertContains(actions.getElementText(locators.getValue("invalidCredentialMsg")),
				testData.getValue("invalidCredentialMsg"));
		logger.info("Verified login functionality with providing special character as credentials: ");

	}

}
