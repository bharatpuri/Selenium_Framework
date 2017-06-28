package com.autoiq.pages.processes;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.autoiq.common.utility.CommonUtility;
import com.autoiq.common.utility.CommonWebFunctions;
import com.autoiq.common.utility.DataStoreInObjects;
import com.autoiq.common.utility.HandleException;
import com.autoiq.tests.dashboard.Navigation;

public class CreateProcesses {
	final static Logger logger = Logger.getLogger(CreateProcesses.class.getName());
	DataStoreInObjects locators = new DataStoreInObjects();
	DataStoreInObjects testData = new DataStoreInObjects();
	
	public static WebDriver driver;
	private WebElement webElement;
	private List<WebElement> allElements;
	CommonWebFunctions actions; 
	Navigation navigation;
	
	public CreateProcesses() throws HandleException {
		locators = CommonUtility.loadLocators("Page Objects", "ProcessPage");
		testData = CommonUtility.loadTestData("Test Data", "ProcessPage");
		actions = new CommonWebFunctions();
		navigation = new Navigation();
	}
	
	public void createNewProcessWithEnableProcess(String name, String description ,int value)
			throws InterruptedException, IOException, AWTException, HandleException {
		actions.clickOnElement(locators.getValue("checkEnableProcess"));
		actions.clickOnElement(locators.getValue("saveButton"));
		actions.wait(2);
		String ac=actions.getElementText(locators.getValue("processNameErrorMessage"));
		System.out.println("test"+ac);
		actions.verifyTextWithAssertContains(actions.getElementText(locators.getValue("processNameErrorMessage")),testData.getValue("expectedRequiredNameValidationMsg"));
		actions.verifyTextWithAssertContains(actions.getElementText(locators.getValue("scheduleReqMessage")),testData.getValue("scheduleNameValidationMsg"));
		actions.verifyTextWithAssertContains(actions.getElementText(locators.getValue("processDefinitionReqMessage")),testData.getValue("definitionNameValidationMsg"));
		actions.verifyTextWithAssertContains(actions.getElementText(locators.getValue("workItemTaskReqMessage")),testData.getValue("workItemValidationMsg"));
		actions.sendKeysToElement(name,locators.getValue("processName"));
		actions.clickOnElement(locators.getValue("saveButton"));
		actions.verifyTextWithAssertContains(actions.getElementText(locators.getValue("scheduleReqMessage")),testData.getValue("scheduleNameValidationMsg"));
		actions.verifyTextWithAssertContains(actions.getElementText(locators.getValue("processDefinitionReqMessage")),testData.getValue("definitionNameValidationMsg"));
		actions.verifyTextWithAssertContains(actions.getElementText(locators.getValue("workItemTaskReqMessage")),testData.getValue("workItemValidationMsg"));
		actions.sendKeysToElement(description,locators.getValue("description"));
		actions.clickOnElement(locators.getValue("saveButton"));
		actions.selectOptionFromDropDownByIndex(value,locators.getValue("scheduleDropdown"));
		actions.clickOnElement(locators.getValue("saveButton"));
		actions.verifyTextWithAssertContains(actions.getElementText(locators.getValue("processDefinitionReqMessage")),testData.getValue("definitionNameValidationMsg"));
		actions.verifyTextWithAssertContains(actions.getElementText(locators.getValue("workItemTaskReqMessage")),testData.getValue("workItemValidationMsg"));
		actions.selectOptionFromDropDownByIndex(value,locators.getValue("definationDropdown"));
		actions.clickOnElement(locators.getValue("saveButton"));
		actions.verifyTextWithAssertContains(actions.getElementText(locators.getValue("workItemTaskReqMessage")),testData.getValue("workItemValidationMsg"));
		actions.selectOptionFromDropDownByIndex(value,locators.getValue("selectWorkQueue"));
		actions.clickOnElement(locators.getValue("saveButton"));
		actions.selectOptionFromDropDownByIndex(1,locators.getValue("selectWorkItemTask"));
		actions.clickOnElement(locators.getValue("runOnce"));
	}
	
	/**
//	 * create New Process With Enable Test Mode
//	 * 
//	 
	 * @throws HandleException */
	public void createNewProcessWithEnableTestMode(String name, String description)
		throws InterruptedException, IOException, AWTException, HandleException {
	actions.sendKeysToElement(name,locators.getValue("processName"));
	actions.sendKeysToElement(description,locators.getValue("description"));
	actions.clickOnElement(locators.getValue("checkEnableTestMode"));

	}
	/**
	 * verify Successful Test Mode Assignment
	 * @throws HandleException 
	 */
	public void verifySuccessfulTestModeAssignment(String testModeList, String processname) throws HandleException {
		logger.info("verify Successful Test Mode Assignment - Begin");
		System.out.println(testModeList);
		allElements = actions.findElements(testModeList);
		//allElements = actions.findElements(testModeList);
		String name=actions.getDynamicXpath(testData.getValue("nameProcessWithEnableTestModeSelected"), locators.getValue("ProcessName"));
		actions.wait(2);
		
		
		System.out.println("test1");
		for (WebElement testMode : allElements) {
			String actualProcessName = actions.getElementText(name);
			if (actualProcessName.equals(processname)) {
				Assert.assertTrue(testMode.isDisplayed());
				// getActualSelectAllIconPosition(index + 2);
			}
			break;
		}
		logger.info("Process assigned with Test Mode Succcessfully!!");
		logger.info("verify Successful Test Mode Assignment - End");
	}
}
