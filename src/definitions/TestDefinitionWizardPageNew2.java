package definitions;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.autoiq.base.AutoiqCommonActions;
import com.autoiq.common.utility.CommonUtility;
import com.autoiq.common.utility.CommonWebFunctions;
import com.autoiq.common.utility.DataStoreInObjects;
import com.autoiq.common.utility.HandleException;
import com.autoiq.tests.dashboard.Navigation;
import com.autoiq.tests.login.TestLogin;

public class TestDefinitionWizardPageNew2 {
	final static Logger logger = Logger.getLogger(TestDefinitionWizardPageNew2.class.getName());

	CommonWebFunctions actions = new CommonWebFunctions();
	DataStoreInObjects locators = new DataStoreInObjects();
	DataStoreInObjects testData = new DataStoreInObjects();
	AutoiqCommonActions appCommon = new AutoiqCommonActions();

	TestLogin login = new TestLogin();
	Navigation navigation = new Navigation();
	Definition definition = new Definition();

	public TestDefinitionWizardPageNew2() throws HandleException {
		locators = CommonUtility.loadLocators("Page Objects", "DefinitionPage");
		testData = CommonUtility.loadTestData("Test Data", "DefinitionTestData");

	}

	@BeforeTest
	public void setup() throws HandleException {
		actions.launchBrowser();
		login.loginWithValidCredentials();
	}
	/**
	 * Dialog Box Verification of invalid form
	 * 
	 * @throws HandleException
	 * 
	 */
	// @Test(priority = 1)
	// public void verifyInvalidActionFormValidationMsg() throws
	// HandleException{
	// logger.info("---------------------------------------------------------------------------------");
	// logger.info("Verify Perform Action Default View- Begin");
	// navigation.navigateToHomePage();
	// navigation.definitionsTab();
	// String definitionName =
	// testData.getValue("nameForverificationInvalidMessage");
	// actions.clickOnElement(locators.getValue("clickCreateNewDefinitionButton"));
	// actions.sendKeysToElement(definitionName,
	// locators.getValue("processDefinitionName"));
	// actions.clickOnElement(locators.getValue("nextButton"));
	// actions.clickOnElement(locators.getValue("performActionButton"));
	// actions.clickOnElement(locators.getValue("okButton"));
	//
	// String expectedMsg = testData.getValue("expectedInvalidFormMsg");
	// String actualMsg =
	// actions.getElementText(locators.getValue("invalidFromMsg"));
	// actions.verifyTextWithAssert(actualMsg, expectedMsg);
	//
	// String runAction = testData.getValue("actionRun");
	// actions.selectOptionFromDropDownByVisiableText(locators.getValue("actionDropdown"),
	// runAction);
	// actions.clickOnElement(locators.getValue("okButton"));
	// actions.verifyTextWithAssert(actualMsg, expectedMsg);
	//
	// actions.selectOptionFromDropDownByIndex(1,locators.getValue("taskDropdown"));
	// actions.clickOnElement(locators.getValue("okButton"));
	// actions.verifyTextWithAssert(actualMsg, expectedMsg);
	//
	// String onSuccessExit = testData.getValue("onSuccessExit");
	// actions.selectOptionFromDropDownByVisiableText(locators.getValue("successDropdown"),
	// onSuccessExit);
	// actions.clickOnElement(locators.getValue("okButton"));
	// actions.verifyTextWithAssert(actualMsg, expectedMsg);
	//
	// String actionPerform = testData.getValue("actionPerform");
	// actions.selectOptionFromDropDownByVisiableText(locators.getValue("actionDropdown"),
	// actionPerform);
	// actions.clickOnElement(locators.getValue("okButton"));
	// actions.verifyTextWithAssert(actualMsg, expectedMsg);
	//
	// String actionProcess = testData.getValue("actionProcess");
	// actions.selectOptionFromDropDownByVisiableText(locators.getValue("actionDropdown"),
	// actionProcess);
	// actions.clickOnElement(locators.getValue("okButton"));
	// actions.verifyTextWithAssert(actualMsg, expectedMsg);
	//
	//
	// String actionExit = testData.getValue("actionExit");
	// actions.selectOptionFromDropDownByVisiableText(locators.getValue("actionDropdown"),
	// actionExit);
	// actions.clickOnElement(locators.getValue("okButton"));
	// actions.verifyTextWithAssert(actualMsg, expectedMsg);
	//
	// String actionAbort = testData.getValue("actionAbort");
	// actions.selectOptionFromDropDownByVisiableText(locators.getValue("actionDropdown"),
	// actionAbort);
	// actions.clickOnElement(locators.getValue("okButton"));
	// actions.verifyTextWithAssert(actualMsg, expectedMsg);
	//
	// actions.clickOnElement(locators.getValue("cancelButton"));
	// actions.clickOnElement(locators.getValue("closeButton"));
	// actions.clickOnElement(locators.getValue("yesButton"));
	//
	// logger.info("Verify Perform Action Default View - End");
	// logger.info("-----------------------------------------XXX--------------------------------------");
	//
	// }

	/**
	 * Dialog Box Verification of create Definition with Exit Perform Action
	 * 
	 * @throws HandleException
	 * 
	 */
	// @Test(priority = 2)
	// public void verifyCreateProcessDefinitionWithPerformActionAsExit()
	// throws InterruptedException, IOException, AWTException, HandleException {
	// logger.info("---------------------------------------------------------------------------------");
	// logger.info("Verify Create Process Definition With Exit Option in Perform
	// Action- Begin");
	// navigation.navigateToHomePage();
	// navigation.definitionsTab();
	// String definitionName = testData.getValue("nameWithExitPerformAction");
	// actions.clickOnElement(locators.getValue("clickCreateNewDefinitionButton"));
	// actions.sendKeysToElement(definitionName,
	// locators.getValue("processDefinitionName"));
	// actions.clickOnElement(locators.getValue("nextButton"));
	// actions.clickOnElement(locators.getValue("performActionButton"));
	// String expectedActionValue =
	// testData.getValue("defaultActionDropdownValue");
	// String actualActionValue =
	// actions.getSelectedValueFromDropDown(locators.getValue("actionDropdown"));
	// actions.verifyTextWithAssert(actualActionValue, expectedActionValue);
	//
	// String exitAction = testData.getValue("actionExit");
	// String exitReason = testData.getValue("reason");
	// actions.selectOptionFromDropDownByVisiableText(locators.getValue("actionDropdown"),
	// exitAction);
	// actions.sendKeysToElement(exitReason, locators.getValue("exitReason"));
	// actions.clickOnElement(locators.getValue("okButton"));
	//
	// String exitActionExpaected =
	// actions.getElementText(locators.getValue("actionTextRule1"));
	// actions.verifyTextWithAssert(exitActionExpaected, exitAction);
	// actions.clickOnElement(locators.getValue("saveButton"));
	// definition.verifyToasterMsgAfterSaveDraft();
	// actions.clickOnElement(locators.getValue("toasterMsg"));
	// actions.clickOnElement(locators.getValue("closeButton"));
	// definition.selectDefinition(definitionName);
	// definition.deleteDefinition(definitionName);
	//
	// logger.info("Verify Create Process Definition With Exit Option in Perform
	// Action - End");
	// logger.info("-----------------------------------------XXX--------------------------------------");
	// }

	/**
	 * Create Process Definition With Perform Action as Perform Verification
	 * 
	 * @throws HandleException
	 * 
	 */
	// @Test(priority = 3)
	// public void verifyCreateProcessDefinitionWithPerformActionAsPerform()
	// throws HandleException {
	// logger.info("---------------------------------------------------------------------------------");
	// logger.info("Verify Create Process Definition With Perform Option in
	// Perform Action- Begin");
	// navigation.navigateToHomePage();
	// navigation.definitionsTab();
	// String definitionName =
	// testData.getValue("nameWithPerformPerformAction");
	// actions.clickOnElement(locators.getValue("clickCreateNewDefinitionButton"));
	// actions.sendKeysToElement(definitionName,
	// locators.getValue("processDefinitionName"));
	// actions.clickOnElement(locators.getValue("nextButton"));
	// actions.clickOnElement(locators.getValue("addActivity"));
	// actions.clickOnElement(locators.getValue("performActionButton"));
	// String expectedActionValue =
	// testData.getValue("defaultActionDropdownValue");
	// String actualActionValue =
	// actions.getSelectedValueFromDropDown(locators.getValue("actionDropdown"));
	// actions.verifyTextWithAssertContains(actualActionValue,
	// expectedActionValue);
	//
	//
	// String performAction = testData.getValue("actionPerform");
	// actions.selectOptionFromDropDownByVisiableText(locators.getValue("actionDropdown"),
	// performAction);
	//
	// String expectedTaskValue =
	// testData.getValue("defaultActivityDropdownValue");
	// String actualTaskValue =
	// actions.getSelectedValueFromDropDown(locators.getValue("activityDropdown"));
	// actions.verifyTextWithAssertContains(actualTaskValue, expectedTaskValue);
	//
	// actions.selectOptionFromDropDownByIndex(1,
	// locators.getValue("activityDropdown"));
	// String activityValueSelected =
	// actions.getSelectedValueFromDropDown(locators.getValue("activityDropdown")).trim();
	//
	// actions.clickOnElement(locators.getValue("okButton"));
	// String actualPerformActiontext =
	// actions.getElementText(locators.getValue("actionTextRule1"));
	// actions.verifyTextWithAssertContains(actualPerformActiontext,
	// performAction);
	// actions.verifyTextWithAssertContains(activityValueSelected,
	// activityValueSelected);
	// actions.clickOnElement(locators.getValue("saveButton"));
	// definition.verifyToasterMsgAfterSaveDraft();
	// actions.clickOnElement(locators.getValue("toasterMsg"));
	// actions.clickOnElement(locators.getValue("closeButton"));
	// definition.selectDefinition(definitionName);
	// definition.deleteDefinition(definitionName);
	// logger.info("Verify Create Process Definition With Perform Option in
	// Perform Action - End");
	// logger.info("-----------------------------------------XXX--------------------------------------");
	//
	// }

	/**
	 * Create Process Definition With Perform Action as Run Verification
	 * 
	 * @throws HandleException
	 * 
	 */
	// @Test(priority = 4)
	// public void verifyCreateProcessDefinitionWithPerformActionAsRun() throws
	// HandleException {
	// logger.info("---------------------------------------------------------------------------------");
	// logger.info("Verify Create Process Definition With Run Option in Perform
	// Action- Begin");
	// navigation.navigateToHomePage();
	// navigation.definitionsTab();
	// String definitionName = testData.getValue("nameWithRunPerformAction");
	// actions.clickOnElement(locators.getValue("clickCreateNewDefinitionButton"));
	// actions.sendKeysToElement(definitionName,
	// locators.getValue("processDefinitionName"));
	// actions.clickOnElement(locators.getValue("nextButton"));
	// actions.clickOnElement(locators.getValue("performActionButton"));
	// String expectedActionValue =
	// testData.getValue("defaultActionDropdownValue");
	// String actualActionValue =
	// actions.getSelectedValueFromDropDown(locators.getValue("actionDropdown"));
	// actions.verifyTextWithAssertContains(actualActionValue,
	// expectedActionValue);
	// String runAction = testData.getValue("actionRun");
	// actions.selectOptionFromDropDownByVisiableText(locators.getValue("actionDropdown"),
	// runAction);
	// String expectedTaskValue = testData.getValue("defaultTaskDropdownValue");
	// String expectedOnSuccessValue =
	// testData.getValue("defaultSuccessDropdownValue");
	// String expectedOnFailureValue =
	// testData.getValue("defaultFailureDropdownValue");
	// String actualTaskValue =
	// actions.getSelectedValueFromDropDown(locators.getValue("taskDropdown"));
	// actions.verifyTextWithAssertContains(actualTaskValue, expectedTaskValue);
	// String actualOnSuccessValue =
	// actions.getSelectedValueFromDropDown(locators.getValue("successDropdown"));
	// actions.verifyTextWithAssertContains(actualOnSuccessValue,
	// expectedOnSuccessValue);
	// String actualOnFailureValue =
	// actions.getSelectedValueFromDropDown(locators.getValue("failureDropdown"));
	// actions.verifyTextWithAssertContains(actualOnFailureValue,
	// expectedOnFailureValue);
	// actions.selectOptionFromDropDownByIndex(1,
	// locators.getValue("taskDropdown"));
	// String taskValueSelected =
	// actions.getSelectedValueFromDropDown(locators.getValue("taskDropdown"));
	// String onSuccessExit = testData.getValue("onSuccessExit");
	// actions.selectOptionFromDropDownByVisiableText(locators.getValue("successDropdown"),
	// onSuccessExit);
	// String onFailureExit = testData.getValue("onFailureExit");
	// actions.selectOptionFromDropDownByVisiableText(locators.getValue("failureDropdown"),
	// onFailureExit);
	// actions.clickOnElement(locators.getValue("okButton"));
	// actions.verifyTextWithAssertContains(actions.getElementText(locators.getValue("actionTextRule1")),
	// runAction);
	// actions.verifyTextContainsInString(taskValueSelected,
	// actions.getElementText(locators.getValue("actionTextRule1")));
	// actions.verifyTextWithAssertContains(actions.getElementText(locators.getValue("successTextRule1")),
	// onSuccessExit);
	// actions.verifyTextWithAssertContains(actions.getElementText(locators.getValue("failureTextRule1")),
	// onFailureExit);
	// actions.clickOnElement(locators.getValue("saveButton"));
	// definition.verifyToasterMsgAfterSaveDraft();
	// actions.clickOnElement(locators.getValue("toasterMsg"));
	// actions.clickOnElement(locators.getValue("closeButton"));
	// definition.selectDefinition(definitionName);
	// definition.deleteDefinition(definitionName);
	// logger.info("Verify Create Process Definition With Run Option in Perform
	// Action - End");
	// logger.info("-----------------------------------------XXX--------------------------------------");
	//
	//
	// }
	/**
	 * Create Process Definition With Perform Action as Process Verification
	 * 
	 * @throws HandleException
	 * 
	 */
	// @Test(priority = 5)
	// public void verifyCreateProcessDefinitionWithPerformActionAsProcess()
	// throws HandleException{
	// logger.info("---------------------------------------------------------------------------------");
	// logger.info("Create Process Definition With Process Option in Perform
	// Action- Begin");
	// navigation.navigateToHomePage();
	// navigation.definitionsTab();
	// String definitionName =
	// testData.getValue("nameWithProcessPerformAction");
	// actions.clickOnElement(locators.getValue("clickCreateNewDefinitionButton"));
	// actions.sendKeysToElement(definitionName,
	// locators.getValue("processDefinitionName"));
	// actions.clickOnElement(locators.getValue("nextButton"));
	// actions.clickOnElement(locators.getValue("addActivity"));
	// actions.clickOnElement(locators.getValue("performActionButton"));
	// String expectedActionValue =
	// testData.getValue("defaultActionDropdownValue");
	// actions.verifyTextWithAssertContains(actions.getSelectedValueFromDropDown(locators.getValue("actionDropdown")),expectedActionValue);
	// String processAction = testData.getValue("actionProcess");
	// actions.selectOptionFromDropDownByVisiableText(locators.getValue("actionDropdown"),
	// processAction);
	// String expectedTaskValue =
	// testData.getValue("defaultActivityDropdownValue");
	// actions.verifyTextWithAssertContains(actions.getSelectedValueFromDropDown(locators.getValue("activityDropdown")),
	// expectedTaskValue);
	// actions.selectOptionFromDropDownByIndex(1,
	// locators.getValue("activityDropdown"));
	// String activityValueSelected =
	// actions.getSelectedValueFromDropDown(locators.getValue("activityDropdown"));
	// actions.clickOnElement(locators.getValue("okButton"));
	// actions.verifyTextContainsInString(processAction,
	// actions.getElementText(locators.getValue("actionTextRule1")));
	// actions.verifyTextContainsInString(activityValueSelected,
	// actions.getElementText(locators.getValue("actionTextRule1")));
	// actions.clickOnElement(locators.getValue("saveButton"));
	// definition.verifyToasterMsgAfterSaveDraft();
	// actions.clickOnElement(locators.getValue("toasterMsg"));
	// actions.verifyTextContainsInString(processAction,
	// actions.getElementText(locators.getValue("actionTextRule1")));
	// actions.verifyTextContainsInString(activityValueSelected,
	// actions.getElementText(locators.getValue("actionTextRule1")));
	// actions.clickOnElement(locators.getValue("closeButton"));
	// definition.selectDefinition(definitionName);
	// definition.deleteDefinition(definitionName);
	// logger.info("Create Process Definition With Process Option in Perform
	// Action - End");
	// logger.info("-----------------------------------------XXX--------------------------------------");
	//
	// }

	/**
	 * Dialog Box Verification of create Definition with Abort Perform Action
	 * 
	 * @throws HandleException
	 * 
	 */
	// @Test(priority = 6)
	// public void verifyCreateProcessDefinitionWithPerformActionAsAbort()
	// throws HandleException{
	// logger.info("---------------------------------------------------------------------------------");
	// logger.info("Create Process Definition With Abort Option in Perform
	// Action- Begin");
	// navigation.navigateToHomePage();
	// navigation.definitionsTab();
	// String definitionName = testData.getValue("nameWithAbortPerformAction");
	// actions.clickOnElement(locators.getValue("clickCreateNewDefinitionButton"));
	// actions.sendKeysToElement(definitionName,
	// locators.getValue("processDefinitionName"));
	// actions.clickOnElement(locators.getValue("nextButton"));
	// actions.clickOnElement(locators.getValue("performActionButton"));
	// String expectedActionValue =
	// testData.getValue("defaultActionDropdownValue");
	// actions.verifyTextWithAssertContains(actions.getSelectedValueFromDropDown(locators.getValue("actionDropdown")),
	// expectedActionValue);
	// String abortAction = testData.getValue("actionAbort");
	// actions.selectOptionFromDropDownByVisiableText(locators.getValue("actionDropdown"),
	// abortAction);
	// String abortReason = testData.getValue("reason");
	// actions.sendKeysToElement(abortReason, locators.getValue("abortReason"));
	// actions.clickOnElement(locators.getValue("okButton"));
	// actions.verifyTextWithAssertContains(actions.getElementText(locators.getValue("actionTextRule1")),
	// abortAction);
	// actions.clickOnElement(locators.getValue("saveButton"));
	// definition.verifyToasterMsgAfterSaveDraft();
	// actions.clickOnElement(locators.getValue("toasterMsg"));
	// actions.verifyTextWithAssertContains(actions.getElementText(locators.getValue("actionTextRule1")),
	// abortAction);
	// actions.clickOnElement(locators.getValue("closeButton"));
	// definition.selectDefinition(definitionName);
	// definition.deleteDefinition(definitionName);
	// logger.info("Create Process Definition With Abort Option in Perform
	// Action - End");
	// logger.info("-----------------------------------------XXX--------------------------------------");
	//
	// }

	/**
	 * verify Add Perform Action And Rule Count
	 * 
	 * @throws HandleException
	 */
	// @Test(priority = 7)
	// public void verifyAddPerformActionAndRuleCount() throws HandleException{
	// logger.info("---------------------------------------------------------------------------------");
	// logger.info("verification Add Perform Action And Rule Count - Begin");
	// navigation.navigateToHomePage();
	// navigation.definitionsTab();
	// String definitionName =
	// testData.getValue("nameToVerifyAddPerformActionRuleCount");
	// actions.clickOnElement(locators.getValue("clickCreateNewDefinitionButton"));
	// actions.sendKeysToElement(definitionName,
	// locators.getValue("processDefinitionName"));
	// actions.clickOnElement(locators.getValue("nextButton"));
	// actions.clickOnElement(locators.getValue("addActivity"));
	// int actCount =
	// actions.getElementCountFromElementList(locators.getValue("activityList"));
	// actions.clickOnIndexFromElementList(actCount-2,
	// locators.getValue("performActionList"));
	// int expectedRuleCount =
	// actions.getElementCountFromElementList(locators.getValue("actionDropDownList"));
	// definition.performActionAsExit(0,0);
	//
	// actions.clickOnIndexFromElementList(actCount-2,
	// locators.getValue("performActionList"));
	// definition.performActionAsPerform(1);
	//
	// actions.clickOnIndexFromElementList(actCount-2,
	// locators.getValue("performActionList"));
	// definition.performActionAsProcess(2);
	//
	// actions.clickOnIndexFromElementList(actCount-2,
	// locators.getValue("performActionList"));
	// definition.performActionAsRun(3);
	//
	// actions.clickOnIndexFromElementList(actCount-2,
	// locators.getValue("performActionList"));
	// definition.performActionAsAbort(4, 1);
	//
	// actions.clickOnElement(locators.getValue("saveButton"));
	// definition.verifyToasterMsgAfterSaveDraft();
	// actions.clickOnElement(locators.getValue("toasterMsg"));
	//
	// int actualRuleCount =
	// actions.getElementCountFromElementList(locators.getValue("ruleListOnRightPanel"));
	// Assert.assertEquals(actualRuleCount, expectedRuleCount-1);
	// actions.clickOnElement(locators.getValue("closeButton"));
	// definition.selectDefinition(definitionName);
	// definition.deleteDefinition(definitionName);
	// logger.info("verification Add Perform Action And Rule Count - End");
	// logger.info("-----------------------------------------XXX--------------------------------------");
	//
	// }

	/**
	 * verification of Add Activity
	 * 
	 * @throws HandleException
	 * 
	 */
	// @Test(priority = 8)
	// public void verifyAddActivityFunctionality() throws HandleException{
	// logger.info("---------------------------------------------------------------------------------");
	// logger.info("verification of Add Activity - Begin");
	// navigation.navigateToHomePage();
	// navigation.definitionsTab();
	// String definitionName =
	// testData.getValue("nameForaddActivityVerification");
	// actions.clickOnElement(locators.getValue("clickCreateNewDefinitionButton"));
	// actions.sendKeysToElement(definitionName,
	// locators.getValue("processDefinitionName"));
	// actions.clickOnElement(locators.getValue("nextButton"));
	// int activityCount = Integer.parseInt(testData.getValue("activityCount"));
	// definition.addActivities(activityCount);
	// actions.clickOnElement(locators.getValue("saveButton"));
	// definition.verifyToasterMsgAfterSaveDraft();
	// actions.clickOnElement(locators.getValue("toasterMsg"));
	// int totalActivityCount =
	// actions.getElementCountFromElementList(locators.getValue("activityList"));
	// actions.verifyAssertEqualsForInt(totalActivityCount, activityCount+2);
	// int totalActivityCountFromLeftPanel =
	// actions.getElementCountFromElementList(locators.getValue("activityListOnLeftPanel"));
	// actions.verifyAssertEqualsForInt(totalActivityCountFromLeftPanel,
	// activityCount+2);
	// actions.clickOnElement(locators.getValue("closeButton"));
	// definition.selectDefinition(definitionName);
	// definition.deleteDefinition(definitionName);
	// logger.info("verification of Add Activity - End");
	// logger.info("-----------------------------------------XXX--------------------------------------");
	//
	// }

	/**
	 * Verify Add New Rule With Invalid Form
	 * 
	 * @throws HandleException
	 * 
	 */
	// @Test(priority = 9)
	// public void verifyAddRuleInvalidFormValidationMsg() throws
	// HandleException {
	// logger.info("---------------------------------------------------------------------------------");
	// logger.info("Verify Add New Rule With Invalid Form- Begin");
	//
	// navigation.navigateToHomePage();
	// navigation.definitionsTab();
	// String definitionName =
	// testData.getValue("nameForAddRuleverificationInvalidMessage");
	// actions.clickOnElement(locators.getValue("clickCreateNewDefinitionButton"));
	// actions.sendKeysToElement(definitionName,
	// locators.getValue("processDefinitionName"));
	// actions.clickOnElement(locators.getValue("nextButton"));
	// actions.clickOnIndexFromElementList(0,
	// locators.getValue("addNewRuleButton"));
	// actions.clickOnElement(locators.getValue("okButton"));
	// String expectedMsg = testData.getValue("expectedInvalidFormMsg");
	// String actualMsg =
	// actions.getElementText(locators.getValue("invalidAddRuleFromMsg"));
	// actions.verifyTextWithAssertEquals(actualMsg, expectedMsg);
	// actions.selectOptionFromDropDownByIndex(1,
	// locators.getValue("fieldDropdown"));
	// actions.clickOnElement(locators.getValue("okButton"));
	// String actualMsgAfterOk =
	// actions.getElementText(locators.getValue("invalidAddRuleFromMsg"));
	// actions.verifyTextWithAssertEquals(actualMsgAfterOk, expectedMsg);
	// String valueInput = testData.getValue("valueInput");
	// actions.sendKeysToElement(valueInput, locators.getValue("valueField"));
	// actions.clickOnElement(locators.getValue("cancelButton"));
	// actions.clickOnElement(locators.getValue("closeButton"));
	// actions.clickOnElement(locators.getValue("yesButton"));
	// logger.info("Verify Add New Rule With Invalid Form - End");
	// logger.info("-----------------------------------------XXX--------------------------------------");
	// }

	/**
	 * Verify Create Process Definition With Add Rule
	 * 
	 * @throws HandleException
	 */
	// @Test(priority = 10)
	// public void verifyCreateProcessDefinitionWithAddRule() throws
	// HandleException {
	// logger.info("---------------------------------------------------------------------------------");
	// logger.info("Verify Create Process Definition With Add Rule- Begin");
	//
	// navigation.navigateToHomePage();
	// navigation.definitionsTab();
	// String definitionName = testData.getValue("nameForAddRule");
	// actions.clickOnElement(locators.getValue("clickCreateNewDefinitionButton"));
	// actions.sendKeysToElement(definitionName,
	// locators.getValue("processDefinitionName"));
	// actions.clickOnElement(locators.getValue("nextButton"));
	// actions.clickOnIndexFromElementList(0,
	// locators.getValue("addNewRuleButton"));
	// String expectedFieldValue = testData.getValue("defaultFieldValue");
	// String expectedOperatorValue =
	// testData.getValue("defaultOperatorDropdownValue");
	// String expectedValue = testData.getValue("defaultValueDropdownValue");
	// definition.verifyDefaultView(expectedFieldValue, expectedOperatorValue,
	// expectedValue);
	// String valueInput = testData.getValue("valueInput");
	// definition.selectOptionFromDropdown(1, 1, valueInput);
	// String fieldValue =
	// actions.getSelectedValueFromDropDown(locators.getValue("fieldDropdown"));
	// String operatorValue =
	// actions.getSelectedValueFromDropDown(locators.getValue("operatorDropdown")).trim();
	// String value =
	// actions.getElementPlaceholder(locators.getValue("valueField"));
	// actions.clickOnElement(locators.getValue("okButton"));
	// int collapsedViewCount =
	// actions.getElementCountFromElementList(locators.getValue("conditionhamburgerList"));
	// definition.verifyCollapsedView(fieldValue, operatorValue, value,
	// collapsedViewCount-1);
	// actions.clickOnElement(locators.getValue("saveButton"));
	// definition.verifyToasterMsgAfterSaveDraft();
	// actions.clickOnElement(locators.getValue("toasterMsg"));
	// definition.verifyCollapsedView(fieldValue, operatorValue, value,
	// collapsedViewCount-1);
	// actions.clickOnElement(locators.getValue("closeButton"));
	// definition.selectDefinition(definitionName);
	// definition.deleteDefinition(definitionName);
	// logger.info("Verify Create Process Definition With Add Rule- End");
	// logger.info("-----------------------------------------XXX--------------------------------------");
	// }

	/**
	 * Verify Create Process Definition With And Connector
	 * 
	 * @throws HandleException
	 */
	// @Test(priority = 11)
	// public void verifyCreateProcessDefinitionWithAndConnector() throws
	// HandleException {
	// logger.info("---------------------------------------------------------------------------------");
	// logger.info("Verify Create Process Definition With And Connector -
	// Begin");
	//
	// navigation.navigateToHomePage();
	// navigation.definitionsTab();
	// String definitionName = testData.getValue("nameForActivityWithAnd");
	// actions.clickOnElement(locators.getValue("clickCreateNewDefinitionButton"));
	// actions.sendKeysToElement(definitionName,
	// locators.getValue("processDefinitionName"));
	// actions.clickOnElement(locators.getValue("nextButton"));
	// logger.info("Add New Rule & And Connector for Start Activity :");
	// actions.clickOnElement(locators.getValue("addNewRuleButton"));
	// actions.clickOnIndexFromElementList(0,
	// locators.getValue("addNewRuleButton"));
	// String valueInput = testData.getValue("valueInput");
	//
	// definition.selectOptionFromDropdown(1, 1, valueInput);
	// actions.clickOnElement(locators.getValue("okButton"));
	// actions.clickOnElement(locators.getValue("andButton"));
	// definition.selectOptionFromDropdown(2, 4, valueInput);
	// actions.clickOnElement(locators.getValue("okButton"));
	// definition.verifyAndConnector(0);
	// actions.clickOnElement(locators.getValue("addActivity"));
	// int activiyCount =
	// actions.getElementCountFromElementList(locators.getValue("activityList"));
	// logger.info("Toctal activity : " + activiyCount);
	// logger.info("Add New Rule & And Connector for Intermediate Activity :");
	// actions.clickOnIndexFromElementList(activiyCount - 2,
	// locators.getValue("addNewRuleButton"));
	// definition.selectOptionFromDropdown(1, 1, valueInput);
	// actions.clickOnElement(locators.getValue("okButton"));
	// actions.clickOnIndexFromElementList(activiyCount - 2,
	// locators.getValue("andButton"));
	// definition.selectOptionFromDropdown(2, 4, valueInput);
	// actions.clickOnElement(locators.getValue("okButton"));
	// definition.verifyAndConnector(activiyCount - 2);
	// logger.info("Add New Rule & And Connector for Final Activity :");
	// actions.clickOnIndexFromElementList(activiyCount - 1,
	// locators.getValue("addNewRuleButton"));
	// definition.selectOptionFromDropdown(1, 1, valueInput);
	// actions.clickOnElement(locators.getValue("okButton"));
	// actions.clickOnIndexFromElementList(activiyCount - 1,
	// locators.getValue("andButton"));
	// definition.selectOptionFromDropdown(2, 4, valueInput);
	// actions.clickOnElement(locators.getValue("okButton"));
	// definition.verifyAndConnector(activiyCount - 1);
	//
	// actions.clickOnElement(locators.getValue("saveButton"));
	// definition.verifyToasterMsgAfterSaveDraft();
	// actions.clickOnElement(locators.getValue("toasterMsg"));
	// actions.clickOnElement(locators.getValue("closeButton"));
	// definition.selectDefinition(definitionName);
	// definition.deleteDefinition(definitionName);
	// logger.info("Verify Create Process Definition With And Connector - End");
	// logger.info("-----------------------------------------XXX--------------------------------------");
	// }

	/**
	 * Verify Create Process Definition With Multiple And
	 * 
	 * @throws HandleException
	 */
	// @Test(priority = 12)
	// public void verifyCreateProcessDefinitionWithMultipleAnd() throws
	// HandleException {
	// logger.info("---------------------------------------------------------------------------------");
	// logger.info("Verify Create Process Definition With Multiple And -
	// Begin");
	//
	// navigation.navigateToHomePage();
	// navigation.definitionsTab();
	// String definitionName = testData.getValue("nameForAddRuleMultipleAnd");
	// actions.clickOnElement(locators.getValue("clickCreateNewDefinitionButton"));
	// actions.sendKeysToElement(definitionName,
	// locators.getValue("processDefinitionName"));
	// actions.clickOnElement(locators.getValue("nextButton"));
	// actions.clickOnIndexFromElementList(0,
	// locators.getValue("addNewRuleButton"));
	// String valueInput = testData.getValue("valueInput");
	// definition.addConditionAndVerifyCollapsedView(1, 1, valueInput);
	// actions.clickOnIndexFromElementList(0, locators.getValue("andButton"));
	// definition.addConditionAndVerifyCollapsedView(2, 4, valueInput);
	// actions.clickOnIndexFromElementList(0, locators.getValue("andButton"));
	// definition.addConditionAndVerifyCollapsedView(1, 1, valueInput);
	// actions.clickOnIndexFromElementList(0, locators.getValue("andButton"));
	// definition.addConditionAndVerifyCollapsedView(2, 4, valueInput);
	//
	// actions.clickOnElement(locators.getValue("saveButton"));
	// definition.verifyToasterMsgAfterSaveDraft();
	// actions.clickOnElement(locators.getValue("toasterMsg"));
	// actions.clickOnElement(locators.getValue("closeButton"));
	// definition.selectDefinition(definitionName);
	// definition.deleteDefinition(definitionName);
	// logger.info("Verify Create Process Definition With Multiple And - End");
	// logger.info("-----------------------------------------XXX--------------------------------------");
	// }

	/**
	 * Verify Create Process Definition With Or Connector
	 * 
	 * @throws HandleException
	 */
	// @Test(priority = 13)
	// public void verifyCreateProcessDefinitionWithOrConnector() throws
	// HandleException {
	// logger.info("---------------------------------------------------------------------------------");
	// logger.info("Verify Create Process Definition With Or Connector -
	// Begin");
	// navigation.navigateToHomePage();
	// navigation.definitionsTab();
	// String definitionName = testData.getValue("nameForActivityWithOr");
	// actions.clickOnElement(locators.getValue("clickCreateNewDefinitionButton"));
	// actions.sendKeysToElement(definitionName,
	// locators.getValue("processDefinitionName"));
	// actions.clickOnElement(locators.getValue("nextButton"));
	// logger.info("Add New Rule & Or Connector for Start Activity :");
	// actions.clickOnIndexFromElementList(0,
	// locators.getValue("addNewRuleButton"));
	// String valueInput = testData.getValue("valueInput");
	// definition.selectOptionFromDropdown(1, 1, valueInput);
	// actions.clickOnElement(locators.getValue("okButton"));
	// actions.clickOnIndexFromElementList(0, locators.getValue("orButton"));
	// definition.selectOptionFromDropdown(2, 4, valueInput);
	// actions.clickOnElement(locators.getValue("okButton"));
	// definition.verifyOrConnector(0);
	// actions.clickOnElement(locators.getValue("addActivity"));
	// int activiyCount =
	// actions.getElementCountFromElementList(locators.getValue("activityList"));
	// logger.info("Toctal activity : " + activiyCount);
	// logger.info("Add New Rule & Or Connector for Intermediate Activity :");
	// actions.clickOnIndexFromElementList(activiyCount-2,
	// locators.getValue("addNewRuleButton"));
	// definition.selectOptionFromDropdown(1, 1, valueInput);
	// actions.clickOnElement(locators.getValue("okButton"));
	// actions.clickOnIndexFromElementList(activiyCount-2,
	// locators.getValue("orButton"));
	// definition.selectOptionFromDropdown(2, 4, valueInput);
	// actions.clickOnElement(locators.getValue("okButton"));
	// definition.verifyOrConnector(activiyCount-2);
	// logger.info("Add New Rule & Or Connector for Final Activity :");
	// actions.clickOnIndexFromElementList(activiyCount-1,
	// locators.getValue("addNewRuleButton"));
	// definition.selectOptionFromDropdown(1, 1, valueInput);
	// actions.clickOnElement(locators.getValue("okButton"));
	// actions.clickOnIndexFromElementList(activiyCount-1,
	// locators.getValue("orButton"));
	// definition.selectOptionFromDropdown(2, 4, valueInput);
	// actions.clickOnElement(locators.getValue("okButton"));
	// definition.verifyOrConnector(activiyCount-1);
	//
	// actions.clickOnElement(locators.getValue("saveButton"));
	// definition.verifyToasterMsgAfterSaveDraft();
	// actions.clickOnElement(locators.getValue("toasterMsg"));
	// actions.clickOnElement(locators.getValue("closeButton"));
	// definition.selectDefinition(definitionName);
	// definition.deleteDefinition(definitionName);
	// logger.info("Verify Create Process Definition With Or Connector - End");
	// logger.info("-----------------------------------------XXX--------------------------------------");
	//
	// }

	/**
	 * Verify Create Process Definition With Multiple Or Connector
	 * 
	 * @throws HandleException
	 */
//	@Test(priority = 14)
//	public void verifyCreateProcessDefinitionWithMultipleOrConnector() throws HandleException {
//		logger.info("---------------------------------------------------------------------------------");
//		logger.info("Verify Create Process Definition With Multiple Or Connector - Begin");
//		navigation.navigateToHomePage();
//		navigation.definitionsTab();
//		String definitionName = testData.getValue("nameForAddRuleMultipleOr");
//		actions.clickOnElement(locators.getValue("clickCreateNewDefinitionButton"));
//		actions.sendKeysToElement(definitionName, locators.getValue("processDefinitionName"));
//		actions.clickOnElement(locators.getValue("nextButton"));
//		actions.clickOnIndexFromElementList(0, locators.getValue("addNewRuleButton"));
//		String valueInput = testData.getValue("valueInput");
//		definition.addConditionAndVerifyCollapsedView(1, 1, valueInput);
//		actions.clickOnIndexFromElementList(0, locators.getValue("orButton"));
//		definition.addConditionAndVerifyCollapsedView(2, 4, valueInput);
//		actions.clickOnIndexFromElementList(0, locators.getValue("orButton"));
//		definition.addConditionAndVerifyCollapsedView(1, 1, valueInput);
//		actions.clickOnIndexFromElementList(0, locators.getValue("orButton"));
//		definition.addConditionAndVerifyCollapsedView(1, 1, valueInput);
//		actions.clickOnElement(locators.getValue("saveButton"));
//		definition.verifyToasterMsgAfterSaveDraft();
//		actions.clickOnElement(locators.getValue("toasterMsg"));
//		actions.clickOnElement(locators.getValue("closeButton"));
//		definition.selectDefinition(definitionName);
//		definition.deleteDefinition(definitionName);
//		logger.info("Verify Create Process Definition With Multiple Or Connector - End");
//		logger.info("-----------------------------------------XXX--------------------------------------");
//	}
	
	/**
	 * Verify Create Process Definition With Combination of And & Or
	 * @throws HandleException 
	 */
//	@Test(priority = 15)
//	public void verifyCreateProcessDefinitionWithCombinationOfAndOr() throws HandleException {
//		logger.info("---------------------------------------------------------------------------------");
//		logger.info("Verify Create Process Definition With Combination of And & Or - Begin");
//		navigation.navigateToHomePage();
//		navigation.definitionsTab();
//		String definitionName = testData.getValue("nameForCombinationOfAndOr");
//		actions.clickOnElement(locators.getValue("clickCreateNewDefinitionButton"));
//		actions.sendKeysToElement(definitionName, locators.getValue("processDefinitionName"));
//		actions.clickOnElement(locators.getValue("nextButton"));
//		actions.clickOnIndexFromElementList(0, locators.getValue("addNewRuleButton"));
//		String valueInput = testData.getValue("valueInput");
//		definition.addConditionAndVerifyCollapsedView(1, 1, valueInput);
//		actions.clickOnIndexFromElementList(0, locators.getValue("andButton"));
//		definition.addConditionAndVerifyCollapsedView(2, 4, valueInput);
//		actions.clickOnIndexFromElementList(0, locators.getValue("orButton"));
//		definition.addConditionAndVerifyCollapsedView(1, 1, valueInput);
//		actions.clickOnElement(locators.getValue("saveButton"));
//		definition.verifyToasterMsgAfterSaveDraft();
//		actions.clickOnElement(locators.getValue("toasterMsg"));
//		actions.clickOnElement(locators.getValue("closeButton"));
//		definition.selectDefinition(definitionName);
//		definition.deleteDefinition(definitionName);
//		
//		logger.info("Verify Create Process Definition With Combination of And & Or  - End");
//		logger.info("-----------------------------------------XXX--------------------------------------");
//	}
	
	/**
	 * Verify Create Process Definition Change Connector Type
	 * @throws HandleException 
	 */
//	@Test(priority = 16)
//	public void verifyCreateProcessDefinitionChangeConnectorType() throws HandleException {
//		logger.info("---------------------------------------------------------------------------------");
//		logger.info("Verify Create Process Definition Change Connector Type- Begin");
//		navigation.navigateToHomePage();
//		navigation.definitionsTab();
//		String definitionName = testData.getValue("createProcessDefinitionChangeConnectorType");
//		actions.clickOnElement(locators.getValue("clickCreateNewDefinitionButton"));
//		actions.sendKeysToElement(definitionName, locators.getValue("processDefinitionName"));
//		actions.clickOnElement(locators.getValue("nextButton"));
//		actions.clickOnIndexFromElementList(0, locators.getValue("addNewRuleButton"));
//		String valueInput = testData.getValue("valueInput");
//		definition.addConditionAndVerifyCollapsedView(1, 1, valueInput);
//		actions.clickOnIndexFromElementList(0, locators.getValue("andButton"));
//		definition.addConditionAndVerifyCollapsedView(2, 4, valueInput);
//		actions.clickOnIndexFromElementList(0, locators.getValue("andConnector"));
//		actions.clickOnElement(locators.getValue("downConnector"));
//		definition.verifyOrConnector(0);
//		actions.clickOnElement(locators.getValue("saveButton"));
//		definition.verifyToasterMsgAfterSaveDraft();
//		actions.clickOnElement(locators.getValue("toasterMsg"));
//		definition.verifyOrConnector(0);
//		actions.clickOnIndexFromElementList(0, locators.getValue("rulesOverlay"));
//		actions.clickOnIndexFromElementList(0, locators.getValue("orButton"));
//		definition.addConditionAndVerifyCollapsedView(1, 1, valueInput);
//		actions.clickOnIndexFromElementList(1, locators.getValue("orConnector"));
//		actions.clickOnElement(locators.getValue("upConnector"));
//		definition.verifyOrConnector(0);
//		actions.clickOnElement(locators.getValue("saveButton"));
//		actions.clickOnElement(locators.getValue("toasterMsg"));
//		definition.verifyAndConnector(0);
//		
//		actions.clickOnElement(locators.getValue("closeButton"));
//		definition.selectDefinition(definitionName);
//		definition.deleteDefinition(definitionName);
//		logger.info("Verify Create Process Definition Change Connector Type  - End");
//		logger.info("-----------------------------------------XXX--------------------------------------");
//	}
	
	/**
	 * Verify Container Validation
	 * @throws HandleException 
	 */
//	@Test(priority = 17)
//	public void verifyContainerValidation() throws HandleException{
//		logger.info("---------------------------------------------------------------------------------");
//		logger.info("Verify Container Validation - Begin");
//		navigation.navigateToHomePage();
//		navigation.definitionsTab();
//		String definitionName = testData.getValue("nameForInvalidContainer");
//		actions.clickOnElement(locators.getValue("clickCreateNewDefinitionButton"));
//		actions.sendKeysToElement(definitionName, locators.getValue("processDefinitionName"));
//		actions.clickOnElement(locators.getValue("nextButton"));
//		actions.clickOnIndexFromElementList(0, locators.getValue("addNewRuleButton"));
//		String valueInput = testData.getValue("valueInput");
//		definition.addConditionAndVerifyCollapsedView(1, 1, valueInput);
//		actions.clickOnIndexFromElementList(0, locators.getValue("andButton"));
//		definition.addConditionAndVerifyCollapsedView(2, 4, valueInput);
//		actions.clickOnIndexFromElementList(0, locators.getValue("orButton"));
//		definition.addConditionAndVerifyCollapsedView(1, 1, valueInput);
//		int hamburgerCount = actions.getElementCountFromElementList(locators.getValue("conditionhamburgerList"));
//		logger.info("hamburger count : " + hamburgerCount);
//		actions.clickOnIndexFromElementList(0, locators.getValue("containerIcon"));
//		//commneted line are reaminig to do
//		//Assert.assertFalse(cdp.isAndButtonClickable(0), "AND button should not be clickable while creating container");
//		//Assert.assertFalse(cdp.isOrButtonClickable(0), "OR button should not be clickable while creating container");
//		definition.clickOnContainerCheckbox(0, hamburgerCount-1, locators.getValue("containerCheckBox"));
//		actions.clickOnIndexFromElementList(0, locators.getValue("doneButton"));
//		String expectedToasterErrorMsg = testData.getValue("expectedInvalidContainerErrorToasterMessage");
//		definition.verifyErrorToasterMsg(expectedToasterErrorMsg);
//		actions.clickOnElement(locators.getValue("cancelContainerButton"));
//		actions.clickOnIndexFromElementList(0, locators.getValue("andConnector"));
//		actions.clickOnElement(locators.getValue("downConnector"));
//		actions.clickOnIndexFromElementList(0, locators.getValue("containerIcon"));
//		definition.clickOnContainerCheckbox(0, hamburgerCount-1, locators.getValue("containerCheckBox"));
//		definition.clickOnContainerCheckbox(1, 1, locators.getValue("containerCheckBox"));
//		actions.clickOnIndexFromElementList(0, locators.getValue("doneButton"));
//		definition.verifyErrorToasterMsg(expectedToasterErrorMsg);
//		definition.clickOnContainerCheckbox(1, 1, locators.getValue("containerCheckBox"));
//		actions.clickOnIndexFromElementList(0, locators.getValue("doneButton"));
//		//Assert.assertFalse(cdp.isOrConnectorClickable(), "Connector should not be clickable if in container");
//		 actions.clickOnElement(locators.getValue("closeButton"));
//		 actions.clickOnElement(locators.getValue("yesButton"));
//		logger.info("Verify Container Validation  - End");
//		logger.info("-----------------------------------------XXX--------------------------------------");
//	}
	
	/**
	 * Verify Create Process Definition With And In Container
	 * @throws HandleException 
	 */
//	@Test(priority = 18)
//	public void verifyCreateProcessDefinitionWithAndInContainer()throws HandleException {
//		logger.info("---------------------------------------------------------------------------------");
//		logger.info("Verify Create Process Definition With And In Container - Begin");
//		navigation.navigateToHomePage();
//		navigation.definitionsTab();
//		String definitionName = testData.getValue("nameForAndInContainer");
//		actions.clickOnElement(locators.getValue("clickCreateNewDefinitionButton"));
//		actions.sendKeysToElement(definitionName, locators.getValue("processDefinitionName"));
//		actions.clickOnElement(locators.getValue("nextButton"));
//		actions.clickOnIndexFromElementList(0, locators.getValue("addNewRuleButton"));
//		String valueInput = testData.getValue("valueInput");
//		definition.addConditionAndVerifyCollapsedView(1, 1, valueInput);
//		actions.clickOnIndexFromElementList(0, locators.getValue("andButton"));
//		definition.addConditionAndVerifyCollapsedView(2, 4, valueInput);
//		actions.clickOnIndexFromElementList(0, locators.getValue("andButton"));
//		definition.addConditionAndVerifyCollapsedView(1, 1, valueInput);
//		int hamburgerCount = actions.getElementCountFromElementList(locators.getValue("conditionhamburgerList"));
//		logger.info("hamburger count : " + hamburgerCount);
//		actions.clickOnIndexFromElementList(0, locators.getValue("containerIcon"));
//		definition.clickOnContainerCheckbox(0, hamburgerCount-1, locators.getValue("containerCheckBox"));
//		actions.clickOnIndexFromElementList(0, locators.getValue("doneButton"));
//		actions.clickOnElement(locators.getValue("saveButton"));
//		definition.verifyToasterMsgAfterSaveDraft();
//		actions.clickOnElement(locators.getValue("toasterMsg"));
//		actions.clickOnElement(locators.getValue("closeButton"));
//		definition.selectDefinition(definitionName);
//		definition.deleteDefinition(definitionName);
//		logger.info("Verify Create Process Definition With With And In Container - End");
//		logger.info("-----------------------------------------XXX--------------------------------------");
//		
//	}
	
	/**
	 * Verify Create Process Definition With OR In Container
	 * @throws HandleException 
	 */
//	@Test(priority = 19)
//	public void verifyCreateProcessDefinitionWithOrInContainer() throws HandleException {
//		logger.info("---------------------------------------------------------------------------------");
//		logger.info("Verify Create Process Definition With Or In Container - Begin");
//		navigation.navigateToHomePage();
//		navigation.definitionsTab();
//		String definitionName = testData.getValue("nameForOrInContainer");
//		actions.clickOnElement(locators.getValue("clickCreateNewDefinitionButton"));
//		actions.sendKeysToElement(definitionName, locators.getValue("processDefinitionName"));
//		actions.clickOnElement(locators.getValue("nextButton"));
//		actions.clickOnIndexFromElementList(0, locators.getValue("addNewRuleButton"));
//		String valueInput = testData.getValue("valueInput");
//		definition.addConditionAndVerifyCollapsedView(1, 1, valueInput);
//		actions.clickOnIndexFromElementList(0, locators.getValue("orButton"));
//		definition.addConditionAndVerifyCollapsedView(2, 4, valueInput);
//		actions.clickOnIndexFromElementList(0, locators.getValue("orButton"));
//		definition.addConditionAndVerifyCollapsedView(1, 1, valueInput);
//		int hamburgerCount =  actions.getElementCountFromElementList(locators.getValue("conditionhamburgerList"));
//		logger.info("hamburger count : " + hamburgerCount);
//		actions.clickOnIndexFromElementList(0, locators.getValue("containerIcon"));
//		definition.clickOnContainerCheckbox(0, hamburgerCount-1, locators.getValue("containerCheckBox"));
//		actions.clickOnIndexFromElementList(0, locators.getValue("doneButton"));
//		actions.clickOnElement(locators.getValue("saveButton"));
//		definition.verifyToasterMsgAfterSaveDraft();
//		actions.clickOnElement(locators.getValue("toasterMsg"));
//		actions.clickOnElement(locators.getValue("closeButton"));
//		definition.selectDefinition(definitionName);
//		definition.deleteDefinition(definitionName);
//		logger.info("Verify Create Process Definition With With Or In Container - End");
//		logger.info("-----------------------------------------XXX--------------------------------------");
//		
//	}
	
	/**
	 * Verify Create Process Definition With Combination of And & Or In
	 * Container
	 * @throws HandleException 
	 * 
	 */
//	@Test(priority = 20)
//	public void verifyCreateProcessDefinitionWithCombinationOfAndOrInContainer() throws HandleException {
//		logger.info("---------------------------------------------------------------------------------");
//		logger.info("Verify Create Process Definition With Combination of And & Or In Container - Begin");
//		navigation.navigateToHomePage();
//		navigation.definitionsTab();
//		String definitionName = testData.getValue("nameForCombinationOfAndOrInContainer");
//		actions.clickOnElement(locators.getValue("clickCreateNewDefinitionButton"));
//		actions.sendKeysToElement(definitionName, locators.getValue("processDefinitionName"));
//		actions.clickOnElement(locators.getValue("nextButton"));
//		actions.clickOnIndexFromElementList(0, locators.getValue("addNewRuleButton"));
//		String valueInput = testData.getValue("valueInput");
//		definition.addConditionAndVerifyCollapsedView(1, 1, valueInput);
//		actions.clickOnIndexFromElementList(0, locators.getValue("andButton"));
//		definition.addConditionAndVerifyCollapsedView(2, 4, valueInput);
//		actions.clickOnIndexFromElementList(0, locators.getValue("andButton"));
//		definition.addConditionAndVerifyCollapsedView(1, 1, valueInput);
//		actions.clickOnIndexFromElementList(0, locators.getValue("orButton"));
//		definition.addConditionAndVerifyCollapsedView(1, 6, valueInput);
//		actions.clickOnIndexFromElementList(0, locators.getValue("orButton"));
//		definition.addConditionAndVerifyCollapsedView(2, 5, valueInput);
//		int hamburgerCount = actions.getElementCountFromElementList(locators.getValue("conditionhamburgerList"));
//		logger.info("hamburger count : " + hamburgerCount);
//		actions.clickOnIndexFromElementList(0, locators.getValue("containerIcon"));
//		definition.clickOnContainerCheckbox(0, 2, locators.getValue("containerCheckBox"));
//		actions.clickOnIndexFromElementList(0, locators.getValue("doneButton"));
//		actions.clickOnIndexFromElementList(0, locators.getValue("containerIcon"));
//		definition.clickOnContainerCheckbox(0, 1, locators.getValue("containerCheckBox"));
//		actions.clickOnIndexFromElementList(0, locators.getValue("doneButton"));
//		
//		actions.clickOnElement(locators.getValue("saveButton"));
//		definition.verifyToasterMsgAfterSaveDraft();
//		actions.clickOnElement(locators.getValue("toasterMsg"));
//		actions.clickOnElement(locators.getValue("closeButton"));
//		definition.selectDefinition(definitionName);
//		definition.deleteDefinition(definitionName);
//		logger.info("Verify Create Process Definition With Combination of And & Or In Container  - End");
//		logger.info("-----------------------------------------XXX--------------------------------------");
//		
//	}
	
	/**
	 * Verify add container using mouse drag
	 * @throws HandleException 
	 */
//	@Test(priority = 21)
//	public void verifyAddContainerUsingMouseDrag() throws HandleException {
//		logger.info("---------------------------------------------------------------------------------");
//		logger.info("Verify Create Process Definition With Combination of And & Or In Container - Begin");
//		navigation.navigateToHomePage();
//		navigation.definitionsTab();
//		String definitionName = testData.getValue("nameForAddContainerUsingMouseDrag");
//		actions.clickOnElement(locators.getValue("toasterMsg"));
//		actions.clickOnElement(locators.getValue("toasterMsg"));
//		actions.clickOnElement(locators.getValue("clickCreateNewDefinitionButton"));
//		actions.sendKeysToElement(definitionName, locators.getValue("processDefinitionName"));
////			actions.clickOnElement(locators.getValue("toasterMsg"));
////			actions.clickOnElement(locators.getValue("toasterMsg"));
//		actions.clickOnElement(locators.getValue("nextButton"));
//		actions.clickOnIndexFromElementList(0, locators.getValue("addNewRuleButton"));
//		String valueInput = testData.getValue("valueInput");
//		definition.addConditionAndVerifyCollapsedView(1, 1, valueInput);
//		actions.clickOnIndexFromElementList(0, locators.getValue("andButton"));
//		definition.addConditionAndVerifyCollapsedView(1, 4, valueInput);//previous first index was 2
//		actions.clickOnIndexFromElementList(0, locators.getValue("orButton"));
//		definition.addConditionAndVerifyCollapsedView(1, 1, valueInput);
//		actions.clickOnIndexFromElementList(0, locators.getValue("orButton"));
//		definition.addConditionAndVerifyCollapsedView(1, 6, valueInput);
//		actions.clickOnIndexFromElementList(0, locators.getValue("orButton"));
//		definition.addConditionAndVerifyCollapsedView(1, 5, valueInput);//previous first index was 2
//		int hamburgerCount = actions.getElementCountFromElementList(locators.getValue("conditionhamburgerList"));
//		logger.info("hamburger count : " + hamburgerCount);
//		actions.clickOnIndexFromElementList(0, locators.getValue("containerIcon"));
//		WebElement dragIndex = actions.getElementByIndexFromElementList(0, locators.getValue("conditionhamburgerList"));
//		WebElement dropIndex = actions.getElementByIndexFromElementList(2, locators.getValue("conditionhamburgerList"));
//		actions.mouseDragAndDrop(dragIndex, dropIndex);
//		actions.clickOnIndexFromElementList(0, locators.getValue("doneButton"));
//		String expectedToasterErrorMsg = testData.getValue("expectedInvalidContainerErrorToasterMessage");
//		definition.verifyErrorToasterMsg(expectedToasterErrorMsg);
//		actions.clickOnElement(locators.getValue("cancelContainerButton"));
//		actions.clickOnIndexFromElementList(0, locators.getValue("containerIcon"));
//		WebElement dragIndexTwo = actions.getElementByIndexFromElementList(3, locators.getValue("conditionhamburgerList"));
//		WebElement dropIndexTwo = actions.getElementByIndexFromElementList(4, locators.getValue("conditionhamburgerList"));
//		actions.mouseDragAndDrop(dragIndexTwo, dropIndexTwo);
//		actions.clickOnIndexFromElementList(0, locators.getValue("doneButton"));
//		actions.clickOnElement(locators.getValue("saveButton"));
//		//Assert.assertTrue(cdp.isContainerAddedForCondition(0), "Container is not added");
//		actions.clickOnElement(locators.getValue("toasterMsg"));
//		actions.clickOnElement(locators.getValue("closeButton"));
//		definition.selectDefinition(definitionName);
//		definition.deleteDefinition(definitionName);
//		logger.info("Verify Create Process Definition With Combination of And & Or In Container  - End");
//		logger.info("-----------------------------------------XXX--------------------------------------");
//		
//	}
	
	/**
	 * Verify Type Ahead In Condition Block
	 * @throws HandleException 
	 */
	@Test(priority = 1)
	public void verifyTypeAheadInConditionBlock() throws HandleException {
		logger.info("----------------------------------------------------------------------------------");
		logger.info("Verify Type Ahead In Condition Block  - End");
		navigation.navigateToHomePage();
		navigation.definitionsTab();
		String definitionName = testData.getValue("nameToVerifyTypeAheadInValueField");
		actions.clickOnElement(locators.getValue("toasterMsg"));
		actions.clickOnElement(locators.getValue("toasterMsg"));
		actions.clickOnElement(locators.getValue("clickCreateNewDefinitionButton"));
		actions.sendKeysToElement(definitionName, locators.getValue("processDefinitionName"));
//			actions.clickOnElement(locators.getValue("toasterMsg"));
//			actions.clickOnElement(locators.getValue("toasterMsg"));
		actions.clickOnElement(locators.getValue("nextButton"));
		actions.clickOnIndexFromElementList(0, locators.getValue("addNewRuleButton"));
		String valueInput = "P";
		String expectedValueInput = "TCPPacketData";
		actions.selectOptionFromDropDownByIndex(1, locators.getValue("fieldDropdown"));
		//actions.selectOptionFromDropDownByVisiableText(locators.getValue("fieldDropdown"), "Image");
		actions.selectOptionFromDropDownByIndex(5, locators.getValue("operatorDropdown"));
		actions.sendKeysToElement(valueInput, locators.getValue("valueField"));
		actions.sendKeysToElement(expectedValueInput, locators.getValue("autoOptions"));
		
		
		
	}
}

