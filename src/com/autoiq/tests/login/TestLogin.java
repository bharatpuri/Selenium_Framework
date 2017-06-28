package com.autoiq.tests.login;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.security.UserAndPassword;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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
public class TestLogin {
	final static Logger logger = Logger.getLogger(Login.class.getName());
	CommonWebFunctions actions = new CommonWebFunctions();
	DataStoreInObjects locators = new DataStoreInObjects();
	DataStoreInObjects testData = new DataStoreInObjects();

	public TestLogin() throws HandleException {

		locators = CommonUtility.loadLocators("Page Objects", "LoginPage");
		testData = CommonUtility.loadTestData("Test Data", "LoginTestData");

	}
	
//	 @BeforeTest
//	 public void setup() throws HandleException{
//			actions.launchBrowser();
//	 }

	/**
	 * Verify the login functionality with Valid credentials
	 * 
	 * @throws HandleException
	 * @throws InterruptedException 
	 */
	@Test(priority = 1)
	public void loginWithValidCredentials() throws HandleException {
		//Alert alert = null ;
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
	@Test(priority = 2)
	public void loginWithInvalidCredentials() throws HandleException, InterruptedException {
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
	@Test(priority = 3)
	public void loginWithBlankCredentials() throws HandleException {
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
	@Test(priority = 4)
	public void loginWithInvalidUsername() throws HandleException, InterruptedException {
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
	@Test(priority = 5)
	public void loginWithInvalidPassword() throws HandleException, InterruptedException {
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
	@Test(priority = 6)
	public void loginWithSpceialCharater() throws HandleException, InterruptedException {
		actions.sendKeysToElement(testData.getValue("specialUsername"), locators.getValue("userName"));
		actions.sendKeysToElement(testData.getValue("specialPassword"), locators.getValue("password"));
		actions.clickOnElement(locators.getValue("loginButton"));
		actions.verifyTextWithAssertContains(actions.getElementText(locators.getValue("invalidCredentialMsg")),
				testData.getValue("invalidCredentialMsg"));
		logger.info("Verified login functionality with providing special character as credentials: ");

	}
	
	// Login lp;
	// ProcessOverview op;
	// NavigationBar np;
	// SchedulesOverview sp;
	// DefinitionOverview dp;
	//
	// /**
	// * This executes before all the test methods
	// */
	//
	// @BeforeClass
	// public void setup() throws MalformedURLException {
	// try {
	// lp = new Login(driver);
	// op = new ProcessOverview(driver);
	// np = new NavigationBar(driver);
	// sp = new SchedulesOverview(driver);
	// dp = new DefinitionOverview(driver);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	//
	// /**
	// * verify login with invalid Username and Password
	// */
	// @Test(priority = 1)
	// public void verifyLoginWithInvalidUsernameandPassword() {
	// log.info("---------------------------------------------------------------------------------");
	// log.info("Verify Login With Invalid Username and Password - Begin");
	// login(loginPageProp.getProperty("ivUsername"),
	// loginPageProp.getProperty("ivPassword"));
	// Assert.assertEquals(loginPageProp.getProperty("expectedInvalidCredentialMsg"),
	// lp.getInvalidCredentialMsg());
	// log.info("Invalid credentials error message displayed, scenario
	// verified");
	// log.info("Verify Login With Invalid Username and Password - End");
	// log.info("-----------------------------------------XXX--------------------------------------");
	// }
	//
	// /**
	// * verify login with invalid credentials
	// */
	// @Test(priority = 2)
	// public void verifyLoginWithBlankCredentials() {
	// log.info("---------------------------------------------------------------------------------");
	// log.info("Verify Login With Blank Username and Password - Begin");
	// login(loginPageProp.getProperty("blankUsername"),
	// loginPageProp.getProperty("blankPassword"));
	// Assert.assertEquals(loginPageProp.getProperty("expectedInvalidCredentialMsg"),
	// lp.getInvalidCredentialMsg());
	// log.info("Invalid credentials error message displayed, scenario
	// verified");
	// log.info("Verify Login With Blank Username and Password - End");
	// log.info("-----------------------------------------XXX--------------------------------------");
	// }
	//
	// /**
	// * verify login with invalid Username
	// */
	// @Test(priority = 3)
	// public void verifyLoginWithInvalidUsername() {
	// log.info("---------------------------------------------------------------------------------");
	// log.info("Verify Login With Invalid Username - Begin");
	// login(loginPageProp.getProperty("invalidUsername"),
	// loginPageProp.getProperty("validPassword"));
	// Assert.assertEquals(loginPageProp.getProperty("expectedInvalidCredentialMsg"),
	// lp.getInvalidCredentialMsg());
	// log.info("Invalid credentials error message displayed, scenario
	// verified");
	// log.info("Verify Login With Invalid Username - End");
	// log.info("-----------------------------------------XXX--------------------------------------");
	// }
	//
	// /**
	// * verify login with invalid Password
	// */
	// @Test(priority = 4)
	// public void verifyLoginWithInvalidPassword() {
	// log.info("---------------------------------------------------------------------------------");
	// log.info("Verify Login With Invalid Password - Begin");
	// login(loginPageProp.getProperty("validUsername"),
	// loginPageProp.getProperty("invalidPassword"));
	// Assert.assertEquals(loginPageProp.getProperty("expectedInvalidCredentialMsg"),
	// lp.getInvalidCredentialMsg());
	// log.info("Invalid credentials error message displayed, scenario
	// verified");
	// log.info("Verify Login With Invalid Password - End");
	// log.info("-----------------------------------------XXX--------------------------------------");
	// }
	//
	// /**
	// * verify login with valid credentials
	// */
	// @Test(priority = 5)
	// public void verifyLoginWithValidCredentials() {
	// log.info("---------------------------------------------------------------------------------");
	// log.info("Verify Login With Valid Credentials - Start");
	// log.info("Application launched Successfully!");
	// waitForElementVisible(lp.loginPageText, 6000);
	// login(loginPageProp.getProperty("username"),
	// loginPageProp.getProperty("password"));
	//// Assert.assertEquals(overviewPageProp.getProperty("expectedOverviewText"),
	// op.getOverviewText());
	// log.info("Logged in Successfully!");
	// log.info("Verify Login With Valid Credentials - End");
	// log.info("-----------------------------------------XXX--------------------------------------");
	// }
	//
	// /**
	// * verify login with valid credentials
	// * @throws InterruptedException
	// * @throws IOException
	// */
	// @Test(priority = 6)
	// public void deleteIfExists() throws IOException, InterruptedException {
	// log.info("---------------------------------------------------------------------------------");
	// log.info("Delete if exists - Start");
	// np.processesTab();
	// np.overviewSubTab();
	// List<String> processNames = new ArrayList<String>();
	// processNames.addAll(Arrays.asList(createProcessPageProp.getProperty("updatedProcessName"),
	// createProcessPageProp.getProperty("nameProcessWithNameOnly"),
	// createProcessPageProp.getProperty("nameProcessAssociatedWithSchedule"),
	// createProcessPageProp.getProperty("nameProcessToVerifyEditSchedule"),
	// createProcessPageProp.getProperty("nameProcessWithNameAndDescription"),
	// createProcessPageProp.getProperty("nameProcessWithSchedule"),
	// createProcessPageProp.getProperty("nameProcessWithDefinition"),
	// createProcessPageProp.getProperty("nameProcessWithWorkQueue"),
	// createProcessPageProp.getProperty("nameProcessWithWorkItemTask"),
	// createProcessPageProp.getProperty("nameProcessWithRunOnce"),
	// createProcessPageProp.getProperty("nameProcessWithEnableProcessSelected"),
	// createProcessPageProp.getProperty("nameProcessWithEnableTestModeSelected"),
	// createProcessPageProp.getProperty("nameProcessWithDisableTestModeSelected"),
	// createProcessPageProp.getProperty("nameProcessWithEnableTestModeFromOverviewPage"),
	// createProcessPageProp.getProperty("ProcessNameToVerifyDelete"),
	// createProcessPageProp.getProperty("nameProcessWithDuplicateProcessName"),
	// createProcessPageProp.getProperty("processWithUniqueProcessName"),
	// createProcessPageProp.getProperty("nameCancelProcessCreation"),
	// createProcessPageProp.getProperty("nameProcessWithDuplicate"),
	// createProcessPageProp.getProperty("processNameToVerifyExistingValues"),
	// createProcessPageProp.getProperty("nameWithActiveDefinitionProcessCreation"),
	// createProcessPageProp.getProperty("processNameToVerifyEditDefinition"),
	// createProcessPageProp.getProperty("processNameBadgecountVerification"),
	// createProcessPageProp.getProperty("processNameToBeDelete"),
	// createProcessPageProp.getProperty("processNameForProcessVerification"),
	// createProcessPageProp.getProperty("nameProcessWithEdit"),
	// createProcessPageProp.getProperty("nameProcessForDuplicateNameVerification"),
	// createProcessPageProp.getProperty("expectedDuplicateNameVerification"),
	// overviewPageProp.getProperty("processName"),
	// overviewPageProp.getProperty("editProcessName"),
	// overviewPageProp.getProperty("nameProcessWithScheduleAssignedForDeleteSchedule")));
	// for(String process: processNames){
	// op.deleteProcessIfAlreadyExists(process);
	// }
	//
	// np.processesTab();
	// np.schedulesSubTab();
	// List<String> scheduleNames = new ArrayList<String>();
	// scheduleNames.addAll(Arrays.asList(
	// createSchedulePageProp.getProperty("scheduleName"),
	// createSchedulePageProp.getProperty("scheduleWithDescription"),
	// createSchedulePageProp.getProperty("scheduleWithStartdate"),
	// createSchedulePageProp.getProperty("scheduleWithEnddate"),
	// createSchedulePageProp.getProperty("scheduleWithOneDay"),
	// createSchedulePageProp.getProperty("scheduleWithMultipleDays"),
	// createSchedulePageProp.getProperty("scheduleWithSingleDayDiffTiming"),
	// createSchedulePageProp.getProperty("scheduleWithMultipledaysDiffTiming"),
	// createSchedulePageProp.getProperty("scheduleWithMultipledaysSameTiming"),
	// createSchedulePageProp.getProperty("scheduleNoDaySelected"),
	// createSchedulePageProp.getProperty("scheduleEnddateVerification"),
	// createSchedulePageProp.getProperty("editedscheduleName"),
	// createSchedulePageProp.getProperty("uniquescheduleName"),
	// createSchedulePageProp.getProperty("expectedScheduleNamePlaceHolder"),
	// createSchedulePageProp.getProperty("scheduleWithNoProcessAssigned"),
	// createSchedulePageProp.getProperty("scheduleWithProcessAssigned"),
	// createSchedulePageProp.getProperty("scheduleToverifyProcessAssociated"),
	// createSchedulePageProp.getProperty("scheduleToVerifyEditScheduleProcessAssociated"),
	// createSchedulePageProp.getProperty("editedscheduleToVerifyProcessAssociated"),
	// createSchedulePageProp.getProperty("scheduleToVerifyEditScheduleNoProcessAssociated"),
	// createSchedulePageProp.getProperty("editedscheduleToVerifyNoProcessAssociated"),
	// createSchedulePageProp.getProperty("scheduleToverifyExistingValues"),
	// createSchedulePageProp.getProperty("editedscheduleToverifyExistingValues"),
	// createSchedulePageProp.getProperty("scheduleToVerifyTimeSetting")));
	// for(String schedule: scheduleNames){
	// sp.deleteScheduleIfAlreadyExists(schedule);
	// }
	//
	// np.processesTab();
	// np.definitionsSubTab();
	// List<String> definitionNames = new ArrayList<String>();
	// definitionNames.addAll(Arrays.asList(
	// createDefinitionPageProp.getProperty("definitionName"),
	// createDefinitionPageProp.getProperty("definitionNameWithDescription"),
	// createDefinitionPageProp.getProperty("uniqueNameVerification"),
	// createDefinitionPageProp.getProperty("closeDefinitionWithSaveDraft"),
	// createDefinitionPageProp.getProperty("closeDefinitionWithoutSaveDraft"),
	// createDefinitionPageProp.getProperty("nameForverificationInvalidMessage"),
	// createDefinitionPageProp.getProperty("nameWithExitPerformAction"),
	// createDefinitionPageProp.getProperty("nameWithRunPerformAction"),
	// createDefinitionPageProp.getProperty("nameWithPerformPerformAction"),
	// createDefinitionPageProp.getProperty("nameWithProcessPerformAction"),
	// createDefinitionPageProp.getProperty("nameWithAbortPerformAction"),
	// createDefinitionPageProp.getProperty("nameForaddActivityVerification"),
	// createDefinitionPageProp.getProperty("nameToVerifyAddPerformActionRuleCount"),
	// createDefinitionPageProp.getProperty("nameToVerifyTypeAheadInValueField"),
	// createDefinitionPageProp.getProperty("nameToVerifyAutoSearchPreviousValues"),
	// createDefinitionPageProp.getProperty("nameForAddRuleverificationInvalidMessage"),
	// createDefinitionPageProp.getProperty("nameForAddRule"),
	// createDefinitionPageProp.getProperty("nameForActivityWithAnd"),
	// createDefinitionPageProp.getProperty("nameForAddRuleMultipleAnd"),
	// createDefinitionPageProp.getProperty("nameForActivityWithOr"),
	// createDefinitionPageProp.getProperty("nameForAddRuleMultipleOr"),
	// createDefinitionPageProp.getProperty("nameForCombinationOfAndOr"),
	// createDefinitionPageProp.getProperty("createProcessDefinitionChangeConnectorType"),
	// createDefinitionPageProp.getProperty("nameForInvalidContainer"),
	// createDefinitionPageProp.getProperty("nameForAndInContainer"),
	// createDefinitionPageProp.getProperty("nameForOrInContainer"),
	// createDefinitionPageProp.getProperty("nameForRuleInContainerAndAction"),
	// createDefinitionPageProp.getProperty("nameForCombinationOfAndOrInContainer"),
	// createDefinitionPageProp.getProperty("nameForAddActionAfterCondition"),
	// createDefinitionPageProp.getProperty("nameForRuleWithRemoveContainer"),
	// createDefinitionPageProp.getProperty("nameForSaveDraftDisabledAfterPublish"),
	// createDefinitionPageProp.getProperty("nameForEditConditionVerification"),
	// createDefinitionPageProp.getProperty("nameForMenuItemVerification"),
	// createDefinitionPageProp.getProperty("nameForDraftProcessDefinition"),
	// createDefinitionPageProp.getProperty("nameForActiveProcessDefinition"),
	// createDefinitionPageProp.getProperty("nameForDeleteConditionWithActionVerification"),
	// createDefinitionPageProp.getProperty("nameForDeleteConditionWithoutActionVerification"),
	// createDefinitionPageProp.getProperty("nameForDisablingCondition"),
	// createDefinitionPageProp.getProperty("nameForPublishDefinitionWithoutAction"),
	// createDefinitionPageProp.getProperty("nameForAddContainerUsingMouseDrag"),
	// createDefinitionPageProp.getProperty("nameToVerifyOverlayOnRules"),
	// createDefinitionPageProp.getProperty("nameToVerifyDeleteRules"),
	// createDefinitionPageProp.getProperty("nameToVerifyAddLeftRightConditionBlock"),
	// createDefinitionPageProp.getProperty("nameToVerifyMoveRuleWithinActivity"),
	// createDefinitionPageProp.getProperty("nameForMenuItemVerificationForAction"),
	// createDefinitionPageProp.getProperty("nameForAutoScrolltoActivebox"),
	// createDefinitionPageProp.getProperty("nameForConditiontoleftofexistingactionbox"),
	// createDefinitionPageProp.getProperty("definitionNameWithContainerOnEdit"),
	// createDefinitionPageProp.getProperty("definitionNameForEditConditionAfterCreation"),
	// createDefinitionPageProp.getProperty("definitionNameForDeleteConditionOnEdit"),
	// createDefinitionPageProp.getProperty("definitionNameForEditVerification"),
	// createDefinitionPageProp.getProperty("editedDefinitionNameForEditVerification"),
	// createDefinitionPageProp.getProperty("nameToVerifyAddLeftRightConditionBlock"),
	// createDefinitionPageProp.getProperty("nameToVerifyMoveRuleWithinActivity"),
	// createDefinitionPageProp.getProperty("nameForMenuItemVerificationForAction"),
	// createDefinitionPageProp.getProperty("nameForAutoScrolltoActivebox"),
	// createDefinitionPageProp.getProperty("nameForConditiontoleftofexistingactionbox"),
	// createDefinitionPageProp.getProperty("definitionNameWithContainerOnEdit"),
	// createDefinitionPageProp.getProperty("verifyBreadCrumbOnDefinitionWizard"),
	// createDefinitionPageProp.getProperty("nameToVerifyDuplicateRules"),
	// createDefinitionPageProp.getProperty("nameToVerifyMoveRuleAcrossActivity"),
	// createDefinitionPageProp.getProperty("nametoVerifyRuleHighlightOnLeftPanel"),
	// createDefinitionPageProp.getProperty("nameForRenameActivity"),
	// createDefinitionPageProp.getProperty("nameForRenameRule"),
	// createDefinitionPageProp.getProperty("nameForDeleteActivity"),
	// definitionPageProp.getProperty("definitionNameForCount"),
	// definitionPageProp.getProperty("nameDefinitionWithNoProcessAssociated"),
	// definitionPageProp.getProperty("nameDefinitionAfterEditDetails"),
	// definitionPageProp.getProperty("definitionNameWithNo"),
	// definitionPageProp.getProperty("definitionNameForProcess"),
	// definitionPageProp.getProperty("definitionNameForBadgeCountVerification"),
	// definitionPageProp.getProperty("definitionNameForProcessDelete"),
	// definitionPageProp.getProperty("definitionNameForProcessAssociated"),
	// definitionPageProp.getProperty("definitionNameForProcessVerification"),
	// definitionPageProp.getProperty("definitionNameForExistingActivityVerification"),
	// definitionPageProp.getProperty("definitionNameForExistingActionsAndRuleCount"),
	// definitionPageProp.getProperty("definitionNameForExistingConditionVerification"),
	// definitionPageProp.getProperty("definitionNameForHideBadgeCount")));
	// for(String definition: definitionNames){
	// dp.deleteDefinitionIfAlreadyExists(definition);
	// }
	//
	// log.info("Delete if exists - End");
	// log.info("-----------------------------------------XXX--------------------------------------");
	// }
	//
	//
	// /**
	// * Login to the application
	// */
	// public void login(String username, String password) {
	// try {
	// lp.login(username, password);
	// } catch (InterruptedException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }

}
