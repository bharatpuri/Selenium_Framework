package com.autoiq.tests.processes;

import java.awt.AWTException;
import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.autoiq.base.TestBase;
import com.autoiq.common.utility.CommonUtility;
import com.autoiq.common.utility.CommonWebFunctions;
import com.autoiq.common.utility.DataStoreInObjects;
import com.autoiq.common.utility.HandleException;
import com.autoiq.pages.NavigationBar;
import com.autoiq.pages.login.Login;
import com.autoiq.pages.processes.CreateProcess;
import com.autoiq.pages.processes.DeleteProcess;
import com.autoiq.pages.processes.ProcessOverview;
import com.autoiq.tests.dashboard.Navigation;
import com.autoiq.tests.login.TestLogin;

public class TestCreateProcess extends TestBase {
	final static Logger logger = Logger.getLogger(TestCreateProcess.class.getName());
	DataStoreInObjects testData = new DataStoreInObjects();
	DataStoreInObjects locators = new DataStoreInObjects();
	CommonWebFunctions actions; 
	Navigation navigation;
	
	public TestCreateProcess() throws HandleException {
		actions = new CommonWebFunctions();
		navigation = new Navigation();

		testData = CommonUtility.loadTestData("Test Data", "ProcessPage");
		locators = CommonUtility.loadLocators("Page Objects", "ProcessPage");
	}
	
	
	
//	Login lp;
//	ProcessOverview op;
//	CreateProcess cp;
//	DeleteProcess dp;
//	NavigationBar np;

	//@BeforeClass
//	public void setup() throws MalformedURLException {
//		try {
//			lp = new Login(driver);
//			op = new ProcessOverview(driver);
//			cp = new CreateProcess(driver);
//			dp = new DeleteProcess(driver);
//			np = new NavigationBar(driver);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * check Default Values In Create Process Page
	 * @throws HandleException 
	 */
//	@Test(priority = 1)
//	public void verifyDefaultValuesInCreateProcessPage() throws InterruptedException, IOException, AWTException, HandleException {
//		logger.info("---------------------------------------------------------------------------------");
//		logger.info("Verify Default Values In Create Process Page - Begin");
//		//actions.launchBrowser();
//	TestLogin login = new TestLogin();
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
//	    logger.info("-----------------------------------------XXX--------------------------------------");
//	}


	/**
	 * Check Cancel Process Creation.
	 * @throws HandleException 
	 * @throws InterruptedException 
	 * 
	 */
	//@Test(priority = 2)
//	public void verifyCancelProcessCreation() throws  HandleException, InterruptedException {
//		logger.info("---------------------------------------------------------------------------------");
//		logger.info("Verify cancel Process Creation - Begin");
//		TestLogin login = new TestLogin();
//		login.loginWithValidCredentials();
//		navigation.navigateToHomePage();
//		navigation.processesTab();
//		navigation.overviewTab();
//		actions.clickOnElement(locators.getValue("createProcessButton"));
//		actions.sendKeysToElement(testData.getValue("nameCancelProcessCreation"), locators.getValue("processName"));
//		actions.sendKeysToElement(testData.getValue("descriptioncancelProcessCreation"), locators.getValue("description"));
//		actions.clickOnElement(locators.getValue("cancelButton"));
//		
		
		
		
		
		
		
		
		
//		np.navigateToHomeAndClickOnProcessesTab();
//		np.overviewSubTab();
//		String pname = createProcessPageProp.getProperty("nameCancelProcessCreation");
//		String description = createProcessPageProp.getProperty("descriptioncancelProcessCreation");
//		op.clickCreateNewProcessButton();
//	enterProcessNameAndDescription(pname, description);
	//	cp.clickCancelButton();
	//	op.verifyNoProcessCreation(createProcessPageProp.getProperty("nameCancelProcessCreation"));
//		logger.info("Verify cancel Process Creation - End");
//		logger.info("-----------------------------------------XXX--------------------------------------");
//	}
//
//	/**
//	 * Check create Process with Process Name.
//	 * 
//	 * @throws InterruptedException
//	 */
//	@Test(priority = 3)
//	public void verifyCreateProcessWithProcessNameOnly() throws InterruptedException, IOException {
//		log.info("---------------------------------------------------------------------------------");
//		log.info("Verify create Process With Process Name Only - Begin");
//		np.navigateToHomeAndClickOnProcessesTab();
//		np.overviewSubTab();
//		String processName = createProcessPageProp.getProperty("nameProcessWithNameOnly");
//		op.clickCreateNewProcessButton();
//		enterProcessName(processName);
//		cp.clickSave();
		//cp.verifyCreateProcessSuccessToasterMsg();
//		int processIndex = op.getProcessIndex(processName);
	//op.verifySuccessfulProcessCreation(processIndex, processName);
//		op.deleteProcess(processName);
//		cp.verifyDeleteProcessSuccessToasterMsg();
//		log.info("Verify create Process With Process Name Only - End");
//		log.info("-----------------------------------------XXX--------------------------------------");
	//}
//
//	/**
//	 * Check create Process with Process Name and Description.
//	 * 
//	 */
//	@Test(priority = 4)
//	public void verifyCreateProcessWithProcessNameAndDescription() throws InterruptedException, IOException {
//		log.info("---------------------------------------------------------------------------------");
//		log.info("Verify create Process With Process Name and Description - Begin");
//		np.navigateToHomeAndClickOnProcessesTab();
//		np.overviewSubTab();
//		String processName = createProcessPageProp.getProperty("nameProcessWithNameAndDescription");
//		String description = createProcessPageProp.getProperty("descriptionProcessWithNameAndDescription");
//		op.clickCreateNewProcessButton();
//		enterProcessNameAndDescription(processName, description);
//		cp.clickSave();
//		cp.verifyCreateProcessSuccessToasterMsg();
//		int processIndex = op.getProcessIndex(processName);
//		op.verifySuccessfulProcessCreation(processIndex, processName);
//		op.deleteProcess(processName);
//		cp.verifyDeleteProcessSuccessToasterMsg();
//		log.info("Verify create Process With Process Name and Description - End");
//		log.info("-----------------------------------------XXX--------------------------------------");
//	}
//
//	/**
//	 * Check create Process with Schedule.
//	 * 
//	 * @throws AWTException
//	 * 
//	 */
//	@Test(priority = 5)
//	public void verifyCreateProcessWithSchedule() throws InterruptedException, IOException, AWTException {
//		log.info("---------------------------------------------------------------------------------");
//		log.info("Verify create Process With Schedule - Begin");
//		np.navigateToHomeAndClickOnProcessesTab();
//		np.overviewSubTab();
//		String processName = createProcessPageProp.getProperty("nameProcessWithSchedule");
//		String description = createProcessPageProp.getProperty("descriptionProcessWithSchedule");
//		op.clickCreateNewProcessButton();
//		enterProcessNameDescriptionAndSchedule(processName, description, 1);
//		cp.clickSave();
//		cp.verifyCreateProcessSuccessToasterMsg();
//		int processIndex = op.getProcessIndex(processName);
//		op.verifySuccessfulProcessCreation(processIndex, processName);
//		op.deleteProcess(processName);
//		cp.verifyDeleteProcessSuccessToasterMsg();
//		log.info("Verify create Process With Schedule - End");
//		log.info("-----------------------------------------XXX--------------------------------------");
//	}
//
//	/**
//	 * Check create Process with Definition.
//	 * 
//	 * @throws AWTException
//	 * 
//	 */
//	@Test(priority = 6)
//	public void verifyCreateProcessWithDefinition() throws InterruptedException, IOException, AWTException {
//		log.info("---------------------------------------------------------------------------------");
//		log.info("Verify create Process With Definition - Begin");
//		np.navigateToHomeAndClickOnProcessesTab();
//		np.overviewSubTab();
//		String processName = createProcessPageProp.getProperty("nameProcessWithDefinition");
//		String description = createProcessPageProp.getProperty("descriptionProcessWithDefinition");
//		op.clickCreateNewProcessButton();
//		enterProcessNameDescriptionScheduleAndDefinition(processName, description, 1);
//		cp.clickSave();
//		cp.verifyCreateProcessSuccessToasterMsg();
//		int processIndex = op.getProcessIndex(processName);
//		op.verifySuccessfulProcessCreation(processIndex, processName);
//		op.deleteProcess(processName);
//		cp.verifyDeleteProcessSuccessToasterMsg();
//		log.info("Verify create Process With Definition - End");
//		log.info("-----------------------------------------XXX--------------------------------------");
//	}
//
//	/**
//	 * Check create Process With Work Queue.
//	 * 
//	 */
//	@Test(priority = 7)
//	public void verifyCreateProcessWithWorkQueue() throws InterruptedException, IOException, AWTException {
//		log.info("---------------------------------------------------------------------------------");
//		log.info("Verify create Process With Work Queue - Begin");
//		np.navigateToHomeAndClickOnProcessesTab();
//		np.overviewSubTab();
//		String processName = createProcessPageProp.getProperty("nameProcessWithWorkQueue");
//		String description = createProcessPageProp.getProperty("descriptionProcessWithWorkQueue");
//		op.clickCreateNewProcessButton();
//		enterProcessNameDescriptionScheduleDefinitionAndWorkQueue(processName, description, 1);
//		cp.clickSave();
//		cp.verifyCreateProcessSuccessToasterMsg();
//		int processIndex = op.getProcessIndex(processName);
//		op.verifySuccessfulProcessCreation(processIndex, processName);
//		op.deleteProcess(processName);
//		cp.verifyDeleteProcessSuccessToasterMsg();
//		log.info("Verify create Process With Work Queue - End");
//		log.info("-----------------------------------------XXX--------------------------------------");
//	}
//
//	/**
//	 * Check create Process With Work Item Task.
//	 * 
//	 */
//	@Test(priority = 8)
//	public void verifyCreateProcessWithWorkItemTask() throws InterruptedException, IOException, AWTException {
//		log.info("---------------------------------------------------------------------------------");
//		log.info("Verify create Process With Work Item Task - Begin");
//		np.navigateToHomeAndClickOnProcessesTab();
//		np.overviewSubTab();
//		String processName = createProcessPageProp.getProperty("nameProcessWithWorkItemTask");
//		String description = createProcessPageProp.getProperty("descriptionProcessWithWorkItemTask");
//		op.clickCreateNewProcessButton();
//		enterProcessNameDescriptionScheduleDefinitionWorkQueueAndWorkItemTask(processName, description, 1);
//		cp.clickSave();
//		cp.verifyCreateProcessSuccessToasterMsg();
//		int processIndex = op.getProcessIndex(processName);
//		op.verifySuccessfulProcessCreation(processIndex, processName);
//		op.deleteProcess(processName);
//		cp.verifyDeleteProcessSuccessToasterMsg();
//		log.info("Verify create Process With Work Item Task - End");
//		log.info("-----------------------------------------XXX--------------------------------------");
//	}
//
//	/**
//	 * Check create Process With Run once
//	 * 
//	 */
//	@Test(priority = 9)
//	public void verifyCreateProcessWithRunOnce() throws InterruptedException, IOException, AWTException {
//		log.info("---------------------------------------------------------------------------------");
//		log.info("Verify create Process With Run once - Begin");
//		np.navigateToHomeAndClickOnProcessesTab();
//		np.overviewSubTab();
//		String processName = createProcessPageProp.getProperty("nameProcessWithRunOnce");
//		String description = createProcessPageProp.getProperty("descriptionProcessRunOnce");
//		op.clickCreateNewProcessButton();
//		enterProcessNameDescriptionScheduleDefinitionWorkQueueWorkItemTaskAndRunOnce(processName, description, 1);
//		cp.clickSave();
//		cp.verifyCreateProcessSuccessToasterMsg();
//		int processIndex = op.getProcessIndex(processName);
//		op.verifySuccessfulProcessCreation(processIndex, processName);
//		op.deleteProcess(processName);
//		cp.verifyDeleteProcessSuccessToasterMsg();
//		log.info("Verify create Process With Run once - End");
//		log.info("-----------------------------------------XXX--------------------------------------");
//	}
//
//	/**
//	 * Check create Process With Enable Process.
//	 * 
//	 */
//	@Test(priority = 10)
//	public void verifyCreateProcessWithEnableProcess() throws InterruptedException, IOException, AWTException {
//		log.info("---------------------------------------------------------------------------------");
//		log.info("Verify create Process With Enable Process - Begin");
//		np.navigateToHomeAndClickOnProcessesTab();
//		np.overviewSubTab();
//		String processName = createProcessPageProp.getProperty("nameProcessWithEnableProcessSelected");
//		String description = createProcessPageProp.getProperty("descriptionProcessEnableProcessSelected");
//		op.clickCreateNewProcessButton();
//		createNewProcessWithEnableProcess(processName, description, 1);
//		cp.clickSave();
//		cp.verifyCreateAndEnableProcessSuccessToasterMsg();
//		int processIndex = op.getProcessIndex(processName);
//		op.verifySuccessfulProcessCreation(processIndex, processName);
//		op.editProcess(processName);
//		cp.setSelectEnableProcess();
//		cp.clickSave();
//		op.deleteProcess(processName);
//		cp.verifyDeleteProcessSuccessToasterMsg();
//		log.info("Verify create Process With Enable Process - End");
//		log.info("-----------------------------------------XXX--------------------------------------");
//	}
//
//	/**
//	 * Check create Process With Enable Test Mode.
//	 * 
//	 */
//	@Test(priority = 11)
//	public void verifyCreateProcessWithEnableTestMode() throws InterruptedException, IOException, AWTException {
//		log.info("---------------------------------------------------------------------------------");
//		log.info("Verify create Process With Enable Test Mode - Begin");
//		np.navigateToHomeAndClickOnProcessesTab();
//		np.overviewSubTab();
//		String processName = createProcessPageProp.getProperty("nameProcessWithEnableTestModeSelected");
//		String description = createProcessPageProp.getProperty("descriptionProcessWithEnableTestModeSelected");
//		op.checkSelectAll();
//		op.clickDisableTestModeButton();
//		op.clickCreateNewProcessButton();
//		createNewProcessWithEnableTestMode(processName, description);
//		cp.clickSave();
//		cp.verifyCreateProcessSuccessToasterMsg();
//		int processIndex = op.getProcessIndex(processName);
//		op.verifySuccessfulProcessCreation(processIndex, processName);
//		op.verifySuccessfulTestModeAssignment(processIndex, processName);
//		log.info("Test Mode successfully assigned to the Process");
//		op.deleteProcess(processName);
//		cp.verifyDeleteProcessSuccessToasterMsg();
//		log.info("Verify create Process With Enable Test Mode - End");
//		log.info("-----------------------------------------XXX--------------------------------------");
//	}
//
//	/**
//	 * Check create Process With Disable Test Mode.
//	 * 
//	 */
//	@Test(priority = 12)
//	public void verifyCreateProcessWithDisableTestMode() throws InterruptedException, IOException, AWTException {
//		log.info("---------------------------------------------------------------------------------");
//		log.info("Verify create Process With Disable Test Mode - Begin");
//		np.navigateToHomeAndClickOnProcessesTab();
//		np.overviewSubTab();
//		String processName = createProcessPageProp.getProperty("nameProcessWithDisableTestModeSelected");
//		String description = createProcessPageProp.getProperty("descriptionProcessWithDisableTestModeSelected");
//		op.checkSelectAll();
//		op.clickDisableTestModeButton();
//		op.clickCreateNewProcessButton();
//		createNewProcessWithEnableTestMode(processName, description);
//		cp.clickSave();
//		cp.verifyCreateProcessSuccessToasterMsg();
//		int processIndex = op.getProcessIndex(processName);
//		op.verifySuccessfulProcessCreation(processIndex, processName);
//		op.verifySuccessfulTestModeAssignment(processIndex, processName);
//		op.editProcess(processName);
//		cp.setSelectEnableTestMode();
//		cp.clickSave();
//		op.verifySuccessfulTestModeDisabled(processIndex, processName);
//		op.deleteProcess(processName);
//		cp.verifyDeleteProcessSuccessToasterMsg();
//		log.info("Verify create Process With Disable Test Mode - End");
//		log.info("-----------------------------------------XXX--------------------------------------");
//	}
//
//	/**
//	 * Check create Process With Enable Test Mode From Overview Page.
//	 * 
//	 */
//	@Test(priority = 13)
//	public void verifyCreateProcessWithEnableTestModeFromOverviewPage()
//			throws InterruptedException, IOException, AWTException {
//		log.info("---------------------------------------------------------------------------------");
//		log.info("Verify create Process With Enable Test Mode From Overview Page - Begin");
//		np.navigateToHomeAndClickOnProcessesTab();
//		np.overviewSubTab();
//		String processName = createProcessPageProp.getProperty("nameProcessWithEnableTestModeFromOverviewPage");
//		String description = createProcessPageProp.getProperty("descriptionProcessWithEnableTestModeFromOverviewPage");
//		op.checkSelectAll();
//		op.clickDisableTestModeButton();
//		wait(2);
//		op.clickCreateNewProcessButton();
//		enterProcessNameAndDescription(processName, description);
//		cp.clickSave();
//		cp.verifyCreateProcessSuccessToasterMsg();
//		int processIndex = op.getProcessIndex(processName);
//		op.verifySuccessfulProcessCreation(processIndex, processName);
//		op.clickOnProcessCheckbox(processIndex);
//		op.clickEnableTestModeButton();
//		op.verifySuccessfulTestModeAssignment(processIndex, processName);
//		op.clickHamburgerIcon(processIndex);
//		op.clickOnEdit(processIndex);
//		cp.verifyIsEnableTestModeSelected();
//		log.info("Test Mode successfully assigned to the Process");
//		cp.clickCancelButton();
//		op.deleteProcess(processName);
//		cp.verifyDeleteProcessSuccessToasterMsg();
//		log.info("Verify create Process With Enable Test Mode From Overview Page - End");
//		log.info("-----------------------------------------XXX--------------------------------------");
//	}
//
//	/**
//	 * Check create Process With Duplicate Process Name.
//	 * 
//	 */
//	@Test(priority = 14)
//	public void verifyUniqueNameVerification() throws InterruptedException, IOException, AWTException {
//		log.info("---------------------------------------------------------------------------------");
//		log.info("Verify create Process With Duplicate Process Name - Begin");
//		np.navigateToHomeAndClickOnProcessesTab();
//		np.overviewSubTab();
//		String processName = createProcessPageProp.getProperty("processWithUniqueProcessName");
//		String description = createProcessPageProp.getProperty("descriptionProcessWithUniqueProcessName");
//		op.clickCreateNewProcessButton();
//		enterProcessNameAndDescription(processName, description);
//		cp.clickSave();
//		cp.verifyCreateProcessSuccessToasterMsg();
//		int processIndex = op.getProcessIndex(processName);
//		op.verifySuccessfulProcessCreation(processIndex, processName);
//		op.clickCreateNewProcessButton();
//		enterProcessNameAndDescription(processName, description);
//		cp.clickSave();
//		cp.duplicateProcessNameErrorMessageValidation();
//		cp.clickCancelButton();
//		op.deleteProcess(processName);
//		cp.verifyDeleteProcessSuccessToasterMsg();
//		log.info("Verify create Process With Duplicate Process Name - End");
//		log.info("-----------------------------------------XXX--------------------------------------");
//	}
//
//	/**
//	 * Check create Process With Blank Process Name.
//	 * 
//	 */
//	@Test(priority = 15)
//	public void verifyCreateProcessWithBlankProcessName() throws InterruptedException, IOException, AWTException {
//		log.info("---------------------------------------------------------------------------------");
//		log.info("Verify create Process With Blank Process Name - Begin");
//		np.navigateToHomeAndClickOnProcessesTab();
//		np.overviewSubTab();
//		op.clickCreateNewProcessButton();
//		String description = createProcessPageProp.getProperty("descriptionProcessWithBlnkProcessName");
//		enterProcessNameAndDescription("", description);
//		cp.clickSave();
//		String expectedBlankErrorMessage = createProcessPageProp.getProperty("blankProcessnameErrorMessage");
//		cp.blankProcessNameErrorMessageValidation(expectedBlankErrorMessage);
//		cp.clickCancelButton();
//		log.info("Verify create Process With Blank Process Name - End");
//		log.info("-----------------------------------------XXX--------------------------------------");
//	}
//
//	/**
//	 * Check create Process With Blank Process Name On Edit
//	 * 
//	 */
//	@Test(priority = 16)
//	public void verifyCreateProcessWithBlankProcessNameOnEdit() throws InterruptedException, IOException, AWTException {
//		log.info("---------------------------------------------------------------------------------");
//		log.info("Verify create Process With Blank Process Name On Edit - Begin");
//		np.navigateToHomeAndClickOnProcessesTab();
//		np.overviewSubTab();
//		String processName = createProcessPageProp.getProperty("nameProcessWithEdit");
//		op.clickCreateNewProcessButton();
//		enterProcessName(processName);
//		cp.clickSave();
//		int processIndex = op.getProcessIndex(processName);
//		op.verifySuccessfulProcessCreation(processIndex, processName);
//		op.editProcess(processName);
//		cp.setProcessNameBlank();
//		cp.clickSave();
//		String blankProcessErrorMsg = createProcessPageProp.getProperty("blankProcessnameErrorMessage");
//		cp.blankProcessNameErrorMessageValidation(blankProcessErrorMsg);
//		cp.clickCancelButton();
//		op.deleteProcess(processName);
//		cp.verifyDeleteProcessSuccessToasterMsg();
//		log.info("Verify create Process With Blank Process Name On Edit - End");
//		log.info("-----------------------------------------XXX--------------------------------------");
//	}
//
//	/**
//	 * Check create Process With Duplicate Process Name On Edit
//	 * 
//	 */
//	@Test(priority = 17)
//	public void verifyCreateProcessWithDuplicateProcessNameOnEdit() throws InterruptedException, IOException, AWTException {
//		log.info("---------------------------------------------------------------------------------");
//		log.info("Verify create Process With Duplicate Process Name On Edit - Begin");
//		np.navigateToHomeAndClickOnProcessesTab();
//		np.overviewSubTab();
//		String processName =createProcessPageProp.getProperty("nameProcessWithDuplicate");
//		op.clickCreateNewProcessButton();
//		enterProcessName(processName);
//		cp.clickSave();
//		cp.verifyCreateProcessSuccessToasterMsg();
//		int processIndex = op.getProcessIndex(processName);
//		op.verifySuccessfulProcessCreation(processIndex, processName);
//		op.clickCreateNewProcessButton();
//		String pname = createProcessPageProp.getProperty("nameProcessWithNameAndDescription");
//		String description = createProcessPageProp.getProperty("descriptionProcessWithNameAndDescription");
//		enterProcessNameAndDescription(pname, description);
//		cp.clickSave();
//		cp.verifyCreateProcessSuccessToasterMsg();
//		int pnameIndex = op.getProcessIndex(pname);
//		op.verifySuccessfulProcessCreation(pnameIndex, pname);
//		op.editProcess(pname);
//		enterProcessName(processName);
//		cp.clickSave();
//		cp.duplicateProcessNameErrorMessageValidation();
//		cp.clickCancelButton();
//		np.navigateToHomeAndClickOnProcessesTab();
//		op.deleteProcess(processName);
//		cp.verifyDeleteProcessSuccessToasterMsg();
//		np.navigateToHomeAndClickOnProcessesTab();
//		op.deleteProcess(pname);
//		log.info("Verify create Process With Duplicate Process Name On Edit - End");
//		log.info("-----------------------------------------XXX--------------------------------------");
//	}
//
//	/**
//	 * Check Existing values in update Process Page
//	 * 
//	 */
//	@Test(priority = 18)
//	public void verifyExistingValuesEditProcess() throws InterruptedException, IOException, AWTException {
//		log.info("---------------------------------------------------------------------------------");
//		log.info("Verify Existing values in update Process Page  - Begin");
//		String processName = createProcessPageProp.getProperty("processNameToVerifyExistingValues");
//		String processDesc = createProcessPageProp.getProperty("processDescription");
//		np.navigateToHomeAndClickOnProcessesTab();
//		np.overviewSubTab();
//		op.clickCreateNewProcessButton();
//		cp.setProcessName(processName);
//		cp.setDescription(processDesc);
//		cp.selectOptionFromScheduleDownByIndex(1);
//		String actualSchedule = cp.getSelectedValueFromScheduleDropDown();
//		cp.selectOptionFromDefinitionDownByIndex(1);
//		String actualDefinition = cp.getSelectedValueFromDefinitionDropDown();
//		cp.setSelectRunOnce();
//		cp.selectOptionFromWorkQueueByIndex(2);
//		String actualWorkQueue = cp.getSelectedValueFromWorkQueueDropDown();
//		cp.enterWorkQueueRegion(createProcessPageProp.getProperty("workQueueRegion"));
//		String actualWorkQueueRegion = cp.getWorkQueueRegion();
//		cp.enterWorkQueueQueue(createProcessPageProp.getProperty("workQueueQueue"));
//		String actualWorkQueueQueue = cp.getWorkQueueQueue();
//		wait(1);
//		cp.selectOptionFromWorkItemTaskByIndex(2);
//		String actualWorkItemTask = cp.getSelectedValueFromTaskDropDown();
//		cp.enterTaskRegion(createProcessPageProp.getProperty("workItemTaskRegion"));
//		String actualTaskRegion = cp.getTaskRegion();
//		wait(1);
//		cp.enterTaskQueue(createProcessPageProp.getProperty("workItemTaskQueue"));
//		String actualTaskQueue = cp.getTaskQueue();
//		cp.clickYesRadioButton();
//		cp.clickSave();
//
//		cp.verifyCreateProcessSuccessToasterMsg();
//		op.editProcess(processName);
//
//		Assert.assertEquals(cp.getProcessNameValue(), processName);
//		Assert.assertEquals(cp.getDescriptionValue(), processDesc);
//		Assert.assertTrue(cp.isRunOnceSelected());
//		Assert.assertEquals(cp.getSelectedValueFromScheduleDropDown(), actualSchedule);
//		Assert.assertEquals(cp.getSelectedValueFromDefinitionDropDown(), actualDefinition);
//		Assert.assertEquals(cp.getSelectedValueFromWorkQueueDropDown(), actualWorkQueue);
//		Assert.assertEquals(cp.getSelectedValueFromTaskDropDown(), actualWorkItemTask);
//		Assert.assertEquals(cp.getWorkQueueRegion(), actualWorkQueueRegion);
//		Assert.assertEquals(cp.getWorkQueueQueue(), actualWorkQueueQueue);
//		Assert.assertEquals(cp.getTaskRegion(), actualTaskRegion);
//		Assert.assertEquals(cp.getTaskQueue(), actualTaskQueue);
//		Assert.assertTrue(cp.isYesSelected());
//
//		String editedProcessName = createProcessPageProp.getProperty("updatedProcessName");
//		String editedProcessDesc = createProcessPageProp.getProperty("UpdatedDescription");
//		cp.setProcessName(editedProcessName);
//		cp.setDescription(editedProcessDesc);
//		cp.selectOptionFromScheduleDownByIndex(2);
//		String editedSchedule = cp.getSelectedValueFromScheduleDropDown();
//		cp.selectOptionFromDefinitionDownByIndex(2);
//		String editedDefinition = cp.getSelectedValueFromDefinitionDropDown();
//		cp.setSelectRepeatedly();
//		cp.selectOptionFromWorkQueueByIndex(3);
//		String editedWorkQueue = cp.getSelectedValueFromWorkQueueDropDown();
//		cp.enterWorkQueueRegion(createProcessPageProp.getProperty("updatedWorkQueueRegion"));
//		String editedWorkQueueRegion = cp.getWorkQueueRegion();
//		wait(2);
//		cp.selectOptionFromWorkItemTaskByIndex(2);
//		String editedWorkItemTask = cp.getSelectedValueFromTaskDropDown();
//		cp.enterTaskRegion(createProcessPageProp.getProperty("updatedWorkItemTaskRegion"));
//		String editedTaskRegion = cp.getTaskRegion();
//		cp.enterTaskQueue(createProcessPageProp.getProperty("updatedWorkItemTaskQueue"));
//		String editedTaskQueue = cp.getTaskQueue();
//		cp.clickNoRadioButton();
//		cp.clickSave();
//
//		cp.verifyUpdateProcessSuccessToasterMsg();
//		op.editProcess(editedProcessName);
//
//		Assert.assertEquals(cp.getProcessNameValue(), editedProcessName);
//		Assert.assertEquals(cp.getDescriptionValue(), editedProcessDesc);
//		Assert.assertTrue(cp.isRepeatedlySelected());
//		Assert.assertEquals(cp.getSelectedValueFromScheduleDropDown(), editedSchedule);
//		Assert.assertEquals(cp.getSelectedValueFromDefinitionDropDown(), editedDefinition);
//		Assert.assertEquals(cp.getSelectedValueFromWorkQueueDropDown(), editedWorkQueue);
//		Assert.assertEquals(cp.getSelectedValueFromTaskDropDown(), editedWorkItemTask);
//		Assert.assertEquals(cp.getWorkQueueRegion(), editedWorkQueueRegion);
//		Assert.assertEquals(cp.getTaskRegion(), editedTaskRegion);
//		Assert.assertEquals(cp.getTaskQueue(), editedTaskQueue);
//		Assert.assertTrue(cp.isNoSelected());
//		cp.clickSave();
//		op.deleteProcess(editedProcessName);
//		log.info("Verify Existing values in update Process Page  - End");
//		log.info("-----------------------------------------XXX--------------------------------------");
//	}
//	
//	/**
//	 * Verify duplicate process functionality
//	 * 
//	 */
//	@Test(priority = 19)
//	public void verifyDuplicateProcessFunctionality() throws InterruptedException, IOException {
//		log.info("---------------------------------------------------------------------------------");
//		log.info("Verify duplicate process functionality - Begin");
//		np.navigateToHomeAndClickOnProcessesTab();
//		np.overviewSubTab();
//		String processName = createProcessPageProp.getProperty("nameProcessForDuplicateNameVerification");
//		op.clickCreateNewProcessButton();
//		enterProcessName(processName);
//		cp.clickSave();
//		cp.verifyCreateProcessSuccessToasterMsg();
//		int processIndex = op.getProcessIndex(processName);
//		op.verifySuccessfulProcessCreation(processIndex, processName);
//		op.OpensDuplicateProcessPage(processIndex);
//		String expectedProcessPageTilte = createProcessPageProp.getProperty("expectedDuplicateProcessPageTitle");
//		String expectedProcessName = createProcessPageProp.getProperty("expectedDuplicateNameVerification");
//		Assert.assertTrue(compareTextContains(cp.getCreateProcessPageTitle(), expectedProcessPageTilte),"Title should be Duplicate Process");
//		Assert.assertEquals(cp.getProcessNameValue(), expectedProcessName);
//		cp.clickSave();
//		cp.verifyCreateProcessSuccessToasterMsg();
//		int processIndex2 = op.getProcessIndex(expectedProcessName);
//		op.verifySuccessfulProcessCreation(processIndex2, expectedProcessName);
//		op.deleteProcess(processName);
//		cp.verifyDeleteProcessSuccessToasterMsg();
//		np.navigateToHomeAndClickOnProcessesTab();
//		op.deleteProcess(expectedProcessName);
//		cp.verifyDeleteProcessSuccessToasterMsg();
//		log.info("Verify duplicate process functionality - End");
//		log.info("-----------------------------------------XXX--------------------------------------");
//	}
//
//	/**
//	 * enter Process Name
//	 * 
//	 */
//	public String enterProcessName(String name) {
//		cp.setProcessName(name);
//		return name;
//	}
//
//	/**
//	 * enter Process Description
//	 * 
//	 */
//	public void enterProcessDescription(String description) {
//		cp.setDescription(description);
//	}
//
//	/**
//	 * enter Process Name and description
//	 * 
//	 */
//	public void enterProcessNameAndDescription(String name, String description) {
//		cp.setProcessName(name);
//		cp.setDescription(description);
//	}
//
//	/**
//	 * enter Process Name, description and Schedule
//	 * 
//	 */
//	public void enterProcessNameDescriptionAndSchedule(String name, String description)
//			throws InterruptedException, IOException, AWTException {
//		cp.setProcessName(name);
//		cp.setDescription(description);
//		cp.selectOptionFromScheduleDownByIndex(1);
//	}
//
//	/**
//	 * enter Process Name, description,Schedule and definition
//	 * 
//	 */
//	public void enterProcessNameDescriptionScheduleAndDefinition(String name, String description)
//			throws InterruptedException, IOException, AWTException {
//		cp.setProcessName(name);
//		cp.setDescription(description);
//		cp.selectOptionFromScheduleDownByIndex(1);
//		cp.selectOptionFromDefinitionDownByIndex(1);
//	}
//
//	/**
//	 * enter Process Name, description, Schedule, definition, and work queue
//	 * 
//	 */
//	public void enterProcessNameDescriptionScheduleDefinitionAndWorkQueue(String name, String description)
//			throws InterruptedException, IOException, AWTException {
//		cp.setProcessName(name);
//		cp.setDescription(description);
//		cp.selectOptionFromScheduleDownByIndex(1);
//		cp.selectOptionFromDefinitionDownByIndex(1);
//		cp.selectOptionFromWorkQueueByIndex(1);
//	}
//
//	/**
//	 * enter Process Name, description, Schedule, definition, work queue and work item task
//	 * 
//	 */
//	public void enterProcessNameDescriptionScheduleDefinitionWorkQueueAndWorkItemTask(String name, String description)
//			throws InterruptedException, IOException, AWTException {
//		cp.setProcessName(name);
//		cp.setDescription(description);
//		cp.selectOptionFromScheduleDownByIndex(1);
//		cp.selectOptionFromDefinitionDownByIndex(1);
//		cp.selectOptionFromWorkQueueByIndex(1);
//		cp.selectOptionFromWorkItemTaskByIndex(1);
//	}
//
//	/**
//	 * enter Process Name, description, Schedule, definition, work queue, work item task and run once
//	 * 
//	 */
//	public void enterProcessNameDescriptionScheduleDefinitionWorkQueueWorkItemTaskAndRunOnce(String name,
//			String description) throws InterruptedException, IOException, AWTException {
//		cp.setProcessName(name);
//		cp.setDescription(description);
//		cp.selectOptionFromScheduleDownByIndex(1);
//		cp.selectOptionFromDefinitionDownByIndex(1);
//		cp.selectOptionFromWorkQueueByIndex(1);
//		cp.selectOptionFromWorkItemTaskByIndex(1);
//		cp.setSelectRunOnce();
//	}
//
//	/**
//	 * create New Process With Enable Process
//	 * 
//	 */
//	public void createNewProcessWithEnableProcess(String name, String description)
//			throws InterruptedException, IOException, AWTException {
//		cp.setSelectEnableProcess();
//		cp.clickSave();
//		cp.processNameReqMessage();
//		cp.scheduleReqMessage();
//		cp.processDefinitionReqMessage();
//		cp.workQueueReqMessage();
//		// cp.workItemTaskReqMessage();
//		cp.setProcessName(name);
//		cp.clickSave();
//		cp.scheduleReqMessage();
//		cp.processDefinitionReqMessage();
//		cp.workQueueReqMessage();
//		cp.workItemTaskReqMessage();
//		cp.setDescription(description);
//		cp.clickSave();
//		cp.selectOptionFromScheduleDownByIndex(1);
//		cp.clickSave();
//		cp.processDefinitionReqMessage();
//		cp.workQueueReqMessage();
//		cp.workItemTaskReqMessage();
//		cp.selectOptionFromDefinitionDownByIndex(1);
//		cp.clickSave();
//		cp.workQueueReqMessage();
//		cp.workItemTaskReqMessage();
//		cp.selectOptionFromWorkQueueByIndex(1);
//		cp.clickSave();
//		cp.workItemTaskReqMessage();
//		cp.selectOptionFromWorkItemTaskByIndex(1);
//		cp.setSelectRunOnce();
	//}
//
//	/**
//	 * create New Process With Enable Test Mode
//	 * 
//	 */
//	public void createNewProcessWithEnableTestMode(String name, String description)
//			throws InterruptedException, IOException, AWTException {
//		cp.setProcessName(name);
//		cp.setDescription(description);
//		cp.setSelectEnableTestMode();
//	}
//
//	/**
//	 * enter Process Name Description And Schedule
//	 * 
//	 */
//	public void enterProcessNameDescriptionAndSchedule(String name, String description, int index)
//			throws InterruptedException, IOException, AWTException {
//		cp.setProcessName(name);
//		cp.setDescription(description);
//		cp.setSelectSchedule(index);
//	}
//
//	/**
//	 * enter Process Name Description, Schedule and definition
//	 * 
//	 */
//	public void enterProcessNameDescriptionScheduleAndDefinition(String name, String description, int index)
//			throws InterruptedException, IOException, AWTException {
//		cp.setProcessName(name);
//		cp.setDescription(description);
//		cp.setSelectSchedule(index);
//		cp.setSelectDefinition(index);
//	}
//
//	/**
//	 * enter Process Name Description, Schedule, definition and work Queue
//	 * 
//	 */
//	public void enterProcessNameDescriptionScheduleDefinitionAndWorkQueue(String name, String description, int index)
//			throws InterruptedException, IOException, AWTException {
//		cp.setProcessName(name);
//		cp.setDescription(description);
//		cp.setSelectSchedule(index);
//		cp.setSelectDefinition(index);
//		cp.setSelectWorkQueue(index);
//	}
//
//	/**
//	 * enter Process Name Description, Schedule, definition, work Queue and workitem task
//	 * 
//	 */
//	public void enterProcessNameDescriptionScheduleDefinitionWorkQueueAndWorkItemTask(String name, String description,
//			int index) throws InterruptedException, IOException, AWTException {
//		cp.setProcessName(name);
//		cp.setDescription(description);
//		cp.setSelectSchedule(index);
//		cp.setSelectDefinition(index);
//		cp.setSelectWorkQueue(index);
//		cp.setSelectWorkItemTask(index);
//	}
//
//	/**
//	 * enter Process Name Description, Schedule, definition, work Queue, workitem task and run once
//	 * 
//	 */
//	public void enterProcessNameDescriptionScheduleDefinitionWorkQueueWorkItemTaskAndRunOnce(String name,
//			String description, int index) throws InterruptedException, IOException, AWTException {
//		cp.setProcessName(name);
//		cp.setDescription(description);
//		cp.setSelectSchedule(index);
//		cp.setSelectDefinition(index);
//		cp.setSelectWorkQueue(index);
//		cp.setSelectWorkItemTask(index);
//		cp.setSelectRunOnce();
//	}
//
//	/**
//	 * create New Process With Enable Process
//	 * 
//	 */
//	public void createNewProcessWithEnableProcess(String name, String description, int index)
//			throws InterruptedException, IOException, AWTException {
//		cp.setSelectEnableProcess();
//		cp.clickSave();
//		cp.processNameReqMessage();
//		cp.scheduleReqMessage();
//		cp.processDefinitionReqMessage();
//		cp.workQueueReqMessage();
//		// cp.workItemTaskReqMessage();
//		cp.setProcessName(name);
//		cp.clickSave();
//		cp.scheduleReqMessage();
//		cp.processDefinitionReqMessage();
//		cp.workQueueReqMessage();
//		cp.workItemTaskReqMessage();
//		cp.setDescription(description);
//		cp.clickSave();
//		cp.setSelectSchedule(index);
//		cp.clickSave();
//		cp.processDefinitionReqMessage();
//		cp.workQueueReqMessage();
//		cp.workItemTaskReqMessage();
//		cp.setSelectDefinition(index);
//		cp.clickSave();
//		cp.workQueueReqMessage();
//		cp.workItemTaskReqMessage();
//		cp.setSelectWorkQueue(index);
//		cp.clickSave();
//		cp.workItemTaskReqMessage();
//		cp.setSelectWorkItemTask(index);
//		cp.setSelectRunOnce();
//	}

}
