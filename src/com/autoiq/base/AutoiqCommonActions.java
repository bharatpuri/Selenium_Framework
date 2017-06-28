package com.autoiq.base;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.autoiq.common.utility.CommonUtility;
import com.autoiq.common.utility.CommonWebFunctions;
import com.autoiq.common.utility.DataStoreInObjects;
import com.autoiq.common.utility.HandleException;

public class AutoiqCommonActions {
	final static Logger logger = Logger.getLogger(AutoiqCommonActions.class.getName());
	CommonWebFunctions actions = new CommonWebFunctions();
	DataStoreInObjects locators = new DataStoreInObjects();
	
	public AutoiqCommonActions() throws HandleException{
		locators = CommonUtility.loadLocators("Page Objects", "DefinitionPage");
	}

	
	/**
	 * This method will click on provided element on web page
	 * @throws HandleException 
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	public void selectElement(String element) throws HandleException  {
		actions.clickOnElement(element);

	}
	
	/**
	 * This method will delete the provided element on web page
	 * @throws HandleException 
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	public void deleteElement(String element) throws HandleException  {
	//	String loctor_type = element.split("=")[0].replace("\"", "");
		String locator_value = element.split("=", 2)[1].replace("\"", "");
		WebElement webElement;
		webElement = actions.driver.findElement(By.xpath(locator_value));
		JavascriptExecutor executor = (JavascriptExecutor)actions.driver;
		executor.executeScript("arguments[0].click()", webElement);
		actions.clickOnElement(locators.getValue("yesButton"));
	}

	
//	/**
//	 * navigate to Home page through url
//	 * @throws InterruptedException 
//	 */
//	public void navigateToHomePage() throws InterruptedException {
//		logger.info("Navigate to Home page through url - Begin");
//		String currentUrl = CommonWebFunctions.driver.getCurrentUrl();
//		CommonWebFunctions.driver.get(currentUrl.substring(0,33));
//		wait(2);
//		logger.info("Navigate to Home page through url - End");
//	}
	
	
}
