package com.autoiq.tests.processes;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import com.autoiq.common.utility.CommonUtility;
import com.autoiq.common.utility.CommonWebFunctions;
import com.autoiq.common.utility.DataStoreInObjects;
import com.autoiq.common.utility.HandleException;

import com.autoiq.pages.processes.CreateProcesses;
import com.autoiq.tests.dashboard.Navigation;
import com.autoiq.tests.login.TestLogin;

public class TestCreateProcessesNew {
	final static Logger logger = Logger.getLogger(TestCreateProcessesNew.class.getName());
	DataStoreInObjects testData = new DataStoreInObjects();
	DataStoreInObjects locators = new DataStoreInObjects();
	CommonWebFunctions actions; 
	Navigation navigation;
	CreateProcesses process;
	public TestCreateProcessesNew() throws HandleException {
		actions = new CommonWebFunctions();
		navigation = new Navigation();
		process = new CreateProcesses();
		testData = CommonUtility.loadTestData("Test Data", "ProcessPage");
		locators = CommonUtility.loadLocators("Page Objects", "ProcessPage");
	}
	
	 @BeforeTest
	 public void setup() throws HandleException{
			actions.launchBrowser();
			//TestLogin login = new TestLogin();
			//login.loginWithValidCredentials();
	 }
	
	

	/**
	 * check Default Values In Create Process Page
	 * @throws HandleException 
	 * @throws InterruptedException 
	 */
//	@Test(priority = 1)
//	public void verifyDefaultValuesInCreateProcessPage() throws InterruptedException, IOException, AWTException, HandleException {
//		logger.info("---------------------------------------------------------------------------------");
//		logger.info("Verify Default Values In Create Process Page - Begin");
//		//actions.launchBrowser();
//		TestLogin login = new TestLogin();
//		login.loginWithValidCredentials();
//		navigation.navigateToHomePage();
//		navigation.processesTab();
//		navigation.overviewTab();
//		actions.clickOnElement(locators.getValue("createProcessButton"));
//		wait(1);
//		actions.verifyTextWithAssert(actions.getSelectedValueFromDropDown(locators.getValue("scheduleDropdown")), testData.getValue("defaultDefinitionDropdownValue"));
//		actions.verifyTextWithAssert(actions.getSelectedValueFromDropDown(locators.getValue("definationDropdown")), testData.getValue("defaultDefinitionDropdownValue"));
//		actions.verifyTextWithAssert(actions.getSelectedValueFromDropDown(locators.getValue("selectWorkQueue")), testData.getValue("defaultWorkQueueDropdownValue"));
//		actions.verifyTextWithAssert(actions.getSelectedValueFromDropDown(locators.getValue("selectWorkItemTask")), testData.getValue("defaultTaskDropdownValue"));
//	    actions.clickOnElement(locators.getValue("cancelButton"));
//		logger.info("Verify Default Values In Create Process Page - End");
//		logger.info("-----------------------------------------XXX--------------------------------------");
//	}
//	/**
//	 * Check Cancel Process Creation.
//	 * @throws HandleException 
//	 * 
//	 */
//	@Test(priority = 2)
//	public void verifyCancelProcessCreation() throws  HandleException, InterruptedException {
//		logger.info("---------------------------------------------------------------------------------");
//		logger.info("Verify cancel Process Creation - Begin");
//		TestLogin login = new TestLogin();
//		login.loginWithValidCredentials();
//		navigation.navigateToHomePage();
//		navigation.processesTab();
//		//navigation.overviewTab();
//		actions.clickOnElement(locators.getValue("createProcessButton"));
//		actions.sendKeysToElement(testData.getValue("nameCancelProcessCreation"), locators.getValue("processName"));
//		actions.sendKeysToElement(testData.getValue("descriptioncancelProcessCreation"), locators.getValue("description"));
//		actions.wait(2);
//		actions.clickOnElement(locators.getValue("cancelButton"));
//		actions.verifyTextNotPresentInList(locators.getValue("processList"),testData.getValue("nameCancelProcessCreation"));
//		logger.info("Verify cancel Process Creation - End");
//		logger.info("-----------------------------------------XXX--------------------------------------");
//	}
	
	/**
	 * Check create Process with Process Name.
	 * 
	 * @throws InterruptedException
	 * @throws HandleException 
	 */
//	@Test(priority = 3)
//	public void verifyCreateProcessWithProcessNameOnly() throws InterruptedException, IOException, HandleException {
//		logger.info("---------------------------------------------------------------------------------");
//		logger.info("Verify create Process With Process Name Only - Begin");
//		TestLogin login = new TestLogin();
//		login.loginWithValidCredentials();
//		navigation.navigateToHomePage();
//		navigation.processesTab();
//		actions.clickOnElement(locators.getValue("createProcessButton"));
//		actions.sendKeysToElement(testData.getValue("nameProcessWithNameOnly"), locators.getValue("processName"));
//		actions.wait(2);
//		actions.clickOnElement(locators.getValue("saveButton"));
//		actions.verifyTextWithAssert(actions.getElementText(locators.getValue("successToasterMsg")),testData.getValue("successToasterMessage"));
//		actions.verifyTextPresentInList(locators.getValue("processList"),testData.getValue("nameProcessWithNameOnly"));
//		
//		int processIndex = op.getProcessIndex(processName);
//		op.deleteProcess(processName);
//		cp.verifyDeleteProcessSuccessToasterMsg();
//		logger.info("Verify create Process With Process Name Only - End");
//		logger.info("-----------------------------------------XXX--------------------------------------");
//	}
	 
//	 /**
//		 * Check create Process with Process Name and Description.
//		 * 	 
//	 * @throws HandleException */
//	 @Test(priority = 4)
//		public void verifyCreateProcessWithProcessNameAndDescription() throws InterruptedException, IOException, HandleException {
//		 logger.info("---------------------------------------------------------------------------------");
//		 logger.info("Verify create Process With Process Name and Description - Begin");
//		 TestLogin login = new TestLogin();
//		 login.loginWithValidCredentials();
//		 navigation.navigateToHomePage();
//		 navigation.processesTab();
//		 navigation.overviewTab();
//		 actions.clickOnElement(locators.getValue("createProcessButton"));
//		 actions.sendKeysToElement(testData.getValue("nameProcessWithNameAndDescription"), locators.getValue("processName"));
//		 actions.sendKeysToElement(testData.getValue("descriptionProcessWithNameAndDescription"), locators.getValue("description"));
//		 actions.wait(2);
//		 actions.clickOnElement(locators.getValue("saveButton"));
//		 actions.verifyTextWithAssert(actions.getElementText(locators.getValue("successToasterMsg")),testData.getValue("successToasterMessage"));
//		 actions.verifyTextPresentInList(locators.getValue("processList"),testData.getValue("nameProcessWithNameAndDescription"));
//			//op.deleteProcess(processName);
//			//cp.verifyDeleteProcessSuccessToasterMsg();
//		 logger.info("Verify create Process With Process Name and Description - End");
//		 logger.info("-----------------------------------------XXX--------------------------------------");
//		}
	 
	 /**
		 * Check create Process with Schedule.
		 * 
		 * @throws AWTException
	 * @throws HandleException 
		 * 
		 */
//	@Test(priority = 5)
//	public void verifyCreateProcessWithSchedule() throws InterruptedException, IOException, AWTException, HandleException {
//			logger.info("---------------------------------------------------------------------------------");
//			logger.info("Verify create Process With Schedule - Begin");
//			TestLogin login = new TestLogin();
//			login.loginWithValidCredentials();
//			navigation.navigateToHomePage();
//			navigation.processesTab();
//			navigation.overviewTab();
//			actions.clickOnElement(locators.getValue("createProcessButton"));
//			actions.sendKeysToElement(testData.getValue("nameProcessWithSchedule"), locators.getValue("processName"));
//			actions.sendKeysToElement(testData.getValue("descriptionProcessWithSchedule"), locators.getValue("description"));
//			actions.selectOptionFromDropDownByIndex(1,locators.getValue("scheduleDropdown"));
//			actions.wait(2);
//			actions.clickOnElement(locators.getValue("saveButton"));
//			actions.verifyTextWithAssert(actions.getElementText(locators.getValue("successToasterMsg")),testData.getValue("successToasterMessage"));
//			actions.verifyTextPresentInList(locators.getValue("processList"),testData.getValue("nameProcessWithSchedule"));
			
		//op.deleteProcess(processName);
			//cp.verifyDeleteProcessSuccessToasterMsg();
//		logger.info("Verify create Process With Schedule - End");
//			logger.info("-----------------------------------------XXX--------------------------------------");
//	}
	 
		/**
		 * Check create Process with Definition.
		 * 
		 * @throws AWTException
		 * @throws HandleException 
		 * 
		 */
//		@Test(priority = 6)
//		public void verifyCreateProcessWithDefinition() throws InterruptedException, IOException, AWTException, HandleException {
//			logger.info("---------------------------------------------------------------------------------");
//			logger.info("Verify create Process With Definition - Begin");
//			TestLogin login = new TestLogin();
//			login.loginWithValidCredentials();
//			navigation.navigateToHomePage();
//			navigation.processesTab();
//			navigation.overviewTab();
//			actions.clickOnElement(locators.getValue("createProcessButton"));
//			actions.sendKeysToElement(testData.getValue("nameProcessWithDefinition"), locators.getValue("processName"));
//			actions.sendKeysToElement(testData.getValue("descriptionProcessWithDefinition"), locators.getValue("description"));
//			actions.selectOptionFromDropDownByIndex(1,locators.getValue("scheduleDropdown"));
//			actions.selectOptionFromDropDownByIndex(1,locators.getValue("definationDropdown"));
//			actions.wait(2);
//			actions.clickOnElement(locators.getValue("saveButton"));
//			actions.verifyTextWithAssert(actions.getElementText(locators.getValue("successToasterMsg")),testData.getValue("successToasterMessage"));
//			actions.verifyTextPresentInList(locators.getValue("processList"),testData.getValue("nameProcessWithDefinition"));
		
//			
//			op.deleteProcess(processName);
//			cp.verifyDeleteProcessSuccessToasterMsg();
//			logger.info("Verify create Process With Definition - End");			
//			logger.info("-----------------------------------------XXX--------------------------------------");
//	}
	 
	/**
	 * Check create Process With Work Queue.
	 * 
	 
	 * @throws HandleException */
//	@Test(priority = 7)
//	public void verifyCreateProcessWithWorkQueue() throws InterruptedException, IOException, AWTException, HandleException {
//		logger.info("---------------------------------------------------------------------------------");
//		logger.info("Verify create Process With Work Queue - Begin");
//		TestLogin login = new TestLogin();
//		login.loginWithValidCredentials();
//		navigation.navigateToHomePage();
//		navigation.processesTab();
//		navigation.overviewTab();
//		actions.clickOnElement(locators.getValue("createProcessButton"));
//		actions.sendKeysToElement(testData.getValue("nameProcessWithWorkQueue"), locators.getValue("processName"));
//		actions.sendKeysToElement(testData.getValue("descriptionProcessWithWorkQueue"), locators.getValue("description"));
//		actions.selectOptionFromDropDownByIndex(1,locators.getValue("scheduleDropdown"));
//		actions.selectOptionFromDropDownByIndex(1,locators.getValue("definationDropdown"));
//		actions.selectOptionFromDropDownByIndex(1,locators.getValue("selectWorkQueue"));
//		actions.wait(2);
//		actions.clickOnElement(locators.getValue("saveButton"));
//		actions.verifyTextWithAssert(actions.getElementText(locators.getValue("successToasterMsg")),testData.getValue("successToasterMessage"));
//		actions.verifyTextPresentInList(locators.getValue("processList"),testData.getValue("nameProcessWithWorkQueue"));
//		
		
		//op.deleteProcess(processName);
		//cp.verifyDeleteProcessSuccessToasterMsg();
//		logger.info("Verify create Process With Work Queue - End");
//		logger.info("-----------------------------------------XXX--------------------------------------");
//	}
	 
	 /**
//		 * Check create Process With Work Item Task.
//		 * 
//		 
	 * @throws HandleException */
//		@Test(priority = 8)
//		public void verifyCreateProcessWithWorkItemTask() throws InterruptedException, IOException, AWTException, HandleException {
//		logger.info("---------------------------------------------------------------------------------");
//		logger.info("Verify create Process With Work Item Task - Begin");
//		TestLogin login = new TestLogin();
//		login.loginWithValidCredentials();
//		navigation.navigateToHomePage();
//		navigation.processesTab();
//		navigation.overviewTab();
//		actions.clickOnElement(locators.getValue("createProcessButton"));
//		actions.sendKeysToElement(testData.getValue("nameProcessWithWorkItemTask"), locators.getValue("processName"));
//		actions.sendKeysToElement(testData.getValue("descriptionProcessWithWorkItemTask"), locators.getValue("description"));
//		actions.selectOptionFromDropDownByIndex(1,locators.getValue("scheduleDropdown"));
//		actions.selectOptionFromDropDownByIndex(1,locators.getValue("definationDropdown"));
//		actions.selectOptionFromDropDownByIndex(1,locators.getValue("selectWorkQueue"));
//		actions.selectOptionFromDropDownByIndex(1,locators.getValue("selectWorkItemTask"));
//		actions.wait(1);
//		actions.clickOnElement(locators.getValue("saveButton"));
//		actions.verifyTextWithAssert(actions.getElementText(locators.getValue("successToasterMsg")),testData.getValue("successToasterMessage"));
//		actions.verifyTextPresentInList(locators.getValue("processList"),testData.getValue("nameProcessWithWorkItemTask"));
		

//			op.deleteProcess(processName);
//			cp.verifyDeleteProcessSuccessToasterMsg();
//			logger.info("Verify create Process With Work Item Task - End");
//			logger.info("-----------------------------------------XXX--------------------------------------");
//	}
	 
	 /**
//		 * Check create Process With Run once
//		 * 
//		 
	 * @throws HandleException */
//		@Test(priority = 9)
//		public void verifyCreateProcessWithRunOnce() throws InterruptedException, IOException, AWTException, HandleException {
//		logger.info("---------------------------------------------------------------------------------");
//		logger.info("Verify create Process With Run once - Begin");
//		TestLogin login = new TestLogin();
//		login.loginWithValidCredentials();
//		navigation.navigateToHomePage();
//		navigation.processesTab();
//		navigation.overviewTab();
//		actions.clickOnElement(locators.getValue("createProcessButton"));
//		actions.sendKeysToElement(testData.getValue("nameProcessWithRunOnce"), locators.getValue("processName"));
//		actions.sendKeysToElement(testData.getValue("descriptionProcessRunOnce"), locators.getValue("description"));
//		actions.selectOptionFromDropDownByIndex(1,locators.getValue("scheduleDropdown"));
//		actions.selectOptionFromDropDownByIndex(1,locators.getValue("definationDropdown"));
//		actions.selectOptionFromDropDownByIndex(1,locators.getValue("selectWorkQueue"));
//		actions.selectOptionFromDropDownByIndex(1,locators.getValue("selectWorkItemTask"));
//		actions.wait(1);
//		actions.clickOnElement(locators.getValue("runOnce"));
//		actions.wait(1);
//		actions.clickOnElement(locators.getValue("saveButton"));
//		actions.verifyTextWithAssert(actions.getElementText(locators.getValue("successToasterMsg")),testData.getValue("successToasterMessage"));
//		actions.verifyTextPresentInList(locators.getValue("processList"),testData.getValue("nameProcessWithRunOnce"));
//			

	
//			op.deleteProcess(processName);
//			cp.verifyDeleteProcessSuccessToasterMsg();
//			logger.info("Verify create Process With Run once - End");
//		logger.info("-----------------------------------------XXX--------------------------------------");
//	}
	 
	 /**
//		 * Check create Process With Run once
//		 * 
//		 
//	 * @throws HandleException */
//	 @Test(priority = 10)
//		public void verifyCreateProcessWithEnableProcess() throws InterruptedException, IOException, AWTException, HandleException {
//				logger.info("---------------------------------------------------------------------------------");
//				logger.info("Verify create Process With Enable Process - Begin");
//				TestLogin login = new TestLogin();
//				login.loginWithValidCredentials();
//				navigation.navigateToHomePage();
//				navigation.processesTab();
//				navigation.overviewTab();
//				actions.clickOnElement(locators.getValue("createProcessButton"));
//				process.createNewProcessWithEnableProcess(testData.getValue("nameProcessWithEnableProcessSelected"), testData.getValue("descriptionProcessEnableProcessSelected"), 1);
//				actions.clickOnElement(locators.getValue("saveButton"));
//		 		actions.verifyTextWithAssert(actions.getElementText(locators.getValue("successToasterMsg")),testData.getValue("expectedCreateAndEnableProcessSuccessToasterMessage"));
//		 		//int processIndex = actions.getElementsIndex(locators.getValue("processList"), testData.getValue("nameProcessWithEnableProcessSelected"));
//		 		actions.verifyTextPresentInList(locators.getValue("processList"),testData.getValue("nameProcessWithEnableProcessSelected"));
//		 
		 
				
				//int processIndex = op.getProcessIndex(processName);

//				op.editProcess(processName);
//				cp.setSelectEnableProcess();
//				cp.clickSave();
//				op.deleteProcess(processName);
////				cp.verifyDeleteProcessSuccessToasterMsg();
//		 		logger.info("Verify create Process With Enable Process - End");
//				logger.info("-----------------------------------------XXX--------------------------------------");
//			}
	 /**
//		 * Check create Process With Enable Test Mode.
//		 * 
//		 
	 * @throws HandleException */
//		@Test(priority = 11)
//		public void verifyCreateProcessWithEnableTestMode() throws InterruptedException, IOException, AWTException, HandleException {
//			logger.info("---------------------------------------------------------------------------------");
//			logger.info("Verify create Process With Enable Test Mode - Begin");
//			TestLogin login = new TestLogin();
//		login.loginWithValidCredentials();
//		navigation.navigateToHomePage();
//		navigation.processesTab();
//		navigation.overviewTab();
//	 	actions.clickOnElement(locators.getValue("selectAllCheckbox"));
//	 	actions.clickOnElement(locators.getValue("disableTestModeButton"));
//		actions.clickOnElement(locators.getValue("createProcessButton"));
//	 	process.createNewProcessWithEnableTestMode(testData.getValue("nameProcessWithEnableTestModeSelected"), testData.getValue("descriptionProcessWithEnableTestModeSelected"));
//	 	actions.wait(2);
//	 actions.clickOnElement(locators.getValue("saveButton"));
//	 actions.verifyTextWithAssert(actions.getElementText(locators.getValue("successToasterMsg")),testData.getValue("successToasterMessage"));
//	actions.verifyTextPresentInList(locators.getValue("processList"),testData.getValue("nameProcessWithEnableTestModeSelected"));
//
//		process.verifySuccessfulTestModeAssignment(locators.getValue("testModeList"), testData.getValue("nameProcessWithEnableTestModeSelected"));
//		logger.info("Test Mode successfully assigned to the Process");
//	 

//			op.deleteProcess(processName);
//			cp.verifyDeleteProcessSuccessToasterMsg();
//		logger.info("Verify create Process With Enable Test Mode - End");
//		logger.info("-----------------------------------------XXX--------------------------------------");
//	}
	
	 
	 /**
//		 * Check create Process With Duplicate Process Name.
//		 * 
//		 
	 * @throws HandleException */
//		@Test(priority = 14)
//		public void verifyUniqueNameVerification() throws InterruptedException, IOException, AWTException, HandleException {
//			logger.info("---------------------------------------------------------------------------------");
//			logger.info("Verify create Process With Duplicate Process Name - Begin");
//			TestLogin login = new TestLogin();
//			login.loginWithValidCredentials();
//			navigation.navigateToHomePage();
//			navigation.processesTab();
//			navigation.overviewTab();
//			actions.clickOnElement(locators.getValue("createProcessButton"));
//			actions.sendKeysToElement(testData.getValue("processWithUniqueProcessName"), locators.getValue("processName"));
//			actions.sendKeysToElement(testData.getValue("descriptionProcessWithUniqueProcessName"), locators.getValue("description"));
//			actions.wait(2);
//			actions.clickOnElement(locators.getValue("saveButton"));
//			
//			actions.verifyTextWithAssert(actions.getElementText(locators.getValue("successToasterMsg")),testData.getValue("successToasterMessage"));
//			actions.verifyTextPresentInList(locators.getValue("processList"),testData.getValue("processWithUniqueProcessName"));
//			actions.wait(3);
//			actions.clickOnElement(locators.getValue("createProcessButton"));
//			actions.sendKeysToElement(testData.getValue("processWithUniqueProcessName"), locators.getValue("processName"));
//			actions.sendKeysToElement(testData.getValue("descriptionProcessWithUniqueProcessName"), locators.getValue("description"));
//			actions.clickOnElement(locators.getValue("saveButton"));
//			
//			actions.verifyTextWithAssert(actions.getElementText(locators.getValue("errorToasterMsg")),testData.getValue("dublicateErrorTosterMsg"));
//			actions.verifyTextWithAssert(actions.getElementText(locators.getValue("processNameErrorMessage")),testData.getValue("duplicateNameValidationMsg"));
//			actions.clickOnElement(locators.getValue("cancelButton"));
//		
//			
//			op.deleteProcess(processName);
//			cp.verifyDeleteProcessSuccessToasterMsg();
//			logger.info("Verify create Process With Duplicate Process Name - End");
//			logger.info("-----------------------------------------XXX--------------------------------------");
//	} 
	 
	 /**
//		 * Check create Process With Blank Process Name.
//		 * 
//		 
//	 * @throws HandleException */
//		@Test(priority = 15)
//		public void verifyCreateProcessWithBlankProcessName() throws InterruptedException, IOException, AWTException, HandleException {
//			logger.info("---------------------------------------------------------------------------------");
//			logger.info("Verify create Process With Blank Process Name - Begin");
//			TestLogin login = new TestLogin();
//			login.loginWithValidCredentials();
//			navigation.navigateToHomePage();
//			navigation.processesTab();
//			navigation.overviewTab();
//			actions.clickOnElement(locators.getValue("createProcessButton"));
//			actions.sendKeysToElement("", locators.getValue("processName"));
//			actions.sendKeysToElement(testData.getValue("descriptionProcessWithBlnkProcessName"), locators.getValue("description"));
//			actions.clickOnElement(locators.getValue("saveButton"));
//			
//			actions.verifyTextWithAssert(actions.getElementText(locators.getValue("errorToasterMsg")),testData.getValue("blankPageErrorToaster"));
//			actions.verifyTextWithAssert(actions.getElementText(locators.getValue("processNameErrorMessage")),testData.getValue("blankProcessnameErrorMessage"));
//			
//			actions.clickOnElement(locators.getValue("cancelButton"));
//	 
//			logger.info("Verify create Process With Blank Process Name - End");
//			logger.info("-----------------------------------------XXX--------------------------------------");
//		}
	 
	 
	@AfterTest
	 public void Quit() throws HandleException{
			actions.cleanUp();
	 }
}
