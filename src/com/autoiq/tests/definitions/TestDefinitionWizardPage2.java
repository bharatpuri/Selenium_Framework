package com.autoiq.tests.definitions;

import java.awt.AWTException;
import java.io.IOException;
import java.net.MalformedURLException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.autoiq.base.TestBase;
import com.autoiq.pages.NavigationBar;
import com.autoiq.pages.definitions.CreateDefinition;
import com.autoiq.pages.definitions.DefinitionOverview;
import com.autoiq.pages.processes.CreateProcess;
import com.autoiq.pages.processes.ProcessOverview;
import com.autoiq.pages.schedules.SchedulesOverview;

/**
 * The Class Test_schedule.
 */
public class TestDefinitionWizardPage2 extends TestBase {
	ProcessOverview op;
	SchedulesOverview sp;
	DefinitionOverview dp;
	CreateDefinition cdp;
	NavigationBar np;
	CreateProcess cp;

	/**
	 * This executes before all the test methods
	 */

	@BeforeClass
	public void setup() throws MalformedURLException {
		try {
			op = new ProcessOverview(driver);
			sp = new SchedulesOverview(driver);
			dp = new DefinitionOverview(driver);
			cp = new CreateProcess(driver);
			cdp = new CreateDefinition(driver);
			np = new NavigationBar(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Dialog Box Verification of invalid form
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 */
	@Test(priority = 1)
	public void verifyInvalidActionFormValidationMsg() throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify Perform Action Default View- Begin");
		np.navigateToHomeAndClickOnProcessesTab();
		np.definitionsSubTab();
		String definitionName = createDefinitionPageProp.getProperty("nameForverificationInvalidMessage");
		dp.clickCreateNewDefinitionButton();
		wait(2);
		cdp.enterDefinitionName(definitionName);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		cdp.clickPerformAction();
		cdp.clickOk();
		String expectedMsg = createDefinitionPageProp.getProperty("expectedInvalidFormMsg");
		Assert.assertEquals(cdp.getInvalidFromMsg(), expectedMsg, "Invalid form message is not displayed");

		String runAction = createDefinitionPageProp.getProperty("actionRun");
		cdp.selectOptionFromActionDropDown(runAction);
		cdp.clickOk();
		Assert.assertEquals(cdp.getInvalidFromMsg(), expectedMsg, "Invalid form message is not displayed");

		cdp.selectOptionFromTaskByIndex(1);
		cdp.clickOk();
		Assert.assertEquals(cdp.getInvalidFromMsg(), expectedMsg, "Invalid form message is not displayed");

		String onSuccessExit = createDefinitionPageProp.getProperty("onSuccessExit");
		cdp.selectOptionFromSuccessDropDown(onSuccessExit);
		cdp.clickOk();
		Assert.assertEquals(cdp.getInvalidFromMsg(), expectedMsg, "Invalid form message is not displayed");

		String actionPerform = createDefinitionPageProp.getProperty("actionPerform");
		cdp.selectOptionFromActionDropDown(actionPerform);
		cdp.clickOk();
		Assert.assertEquals(cdp.getInvalidFromMsg(), expectedMsg, "Invalid form message is not displayed");

		String actionProcess = createDefinitionPageProp.getProperty("actionProcess");
		cdp.selectOptionFromActionDropDown(actionProcess);
		cdp.clickOk();
		Assert.assertEquals(cdp.getInvalidFromMsg(), expectedMsg, "Invalid form message is not displayed");

		String actionExit = createDefinitionPageProp.getProperty("actionExit");
		cdp.selectOptionFromActionDropDown(actionExit);
		cdp.clickOk();
		Assert.assertEquals(cdp.getInvalidFromMsg(), expectedMsg, "Invalid form message is not displayed");

		String actionAbort = createDefinitionPageProp.getProperty("actionAbort");
		cdp.selectOptionFromActionDropDown(actionAbort);
		cdp.clickOk();
		Assert.assertEquals(cdp.getInvalidFromMsg(), expectedMsg, "Invalid form message is not displayed");

		cdp.clickCancel();
		cdp.clickClose();
		cdp.clickYes();
		log.info("Verify Perform Action Default View - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}

	/**
	 * Dialog Box Verification of create Definition with Exit Perform Action
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 */
	@Test(priority = 2)
	public void verifyCreateProcessDefinitionWithPerformActionAsExit()
			throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify Create Process Definition With Exit Option in Perform Action- Begin");
		np.navigateToHomeAndClickOnProcessesTab();
		np.definitionsSubTab();
		String definitionName = createDefinitionPageProp.getProperty("nameWithExitPerformAction");
		dp.clickCreateNewDefinitionButton();
		wait(2);
		cdp.enterDefinitionName(definitionName);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		cdp.clickPerformAction();
		String expectedActionValue = createDefinitionPageProp.getProperty("defaultActionDropdownValue");
		Assert.assertTrue(compareTextContains(cdp.getSelectedValueFromActionDropDown(), expectedActionValue));
		String exitAction = createDefinitionPageProp.getProperty("actionExit");
		String exitReason = createDefinitionPageProp.getProperty("reason");
		cdp.selectOptionFromActionDropDown(exitAction);
		cdp.enterExitReason(exitReason);
		cdp.clickOk();
		Assert.assertTrue(compareTextContains(cdp.getActionTextOnCollaspedView(), exitAction));
		cdp.clickSave();
		cdp.verifyToasterMsgAfterSaveDraft();
		cdp.clickClose();
		dp.deleteDefinition(definitionName);
		log.info("Verify Create Process Definition With Exit Option in Perform Action - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}

	/**
	 * Create Process Definition With Perform Action as Perform Verification
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 */
	@Test(priority = 3)
	public void verifyCreateProcessDefinitionWithPerformActionAsPerform()
			throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify Create Process Definition With Perform Option in Perform Action- Begin");
		np.navigateToHomeAndClickOnProcessesTab();
		np.definitionsSubTab();
		String definitionName = createDefinitionPageProp.getProperty("nameWithPerformPerformAction");
		dp.clickCreateNewDefinitionButton();
		wait(2);
		cdp.enterDefinitionName(definitionName);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		cdp.clickAddActivity();
		cdp.clickPerformAction();
		String expectedActionValue = createDefinitionPageProp.getProperty("defaultActionDropdownValue");
		Assert.assertTrue(compareTextContains(cdp.getSelectedValueFromActionDropDown(), expectedActionValue));
		String performAction = createDefinitionPageProp.getProperty("actionPerform");
		cdp.selectOptionFromActionDropDown(performAction);
		String expectedTaskValue = createDefinitionPageProp.getProperty("defaultActivityDropdownValue");
		Assert.assertTrue(compareTextContains(cdp.getSelectedValueFromActivityDropDown(), expectedTaskValue));
		cdp.selectOptionFromActivityByIndex(1);
		String activityValueSelected = (cdp.getSelectedValueFromActivityDropDown()).trim();
		cdp.clickOk();
		Assert.assertTrue(compareTextContains(cdp.getActionTextOnCollaspedView(), performAction));
		Assert.assertTrue(compareTextContains(cdp.getActionTextOnCollaspedView(), activityValueSelected));
		cdp.clickSave();
		cdp.verifyToasterMsgAfterSaveDraft();
		cdp.clickClose();
		dp.deleteDefinition(definitionName);
		log.info("Verify Create Process Definition With Perform Option in Perform Action - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}

	/**
	 * Create Process Definition With Perform Action as Run Verification
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 */
	@Test(priority = 4)
	public void verifyCreateProcessDefinitionWithPerformActionAsRun()
			throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify Create Process Definition With Run Option in Perform Action- Begin");
		np.navigateToHomeAndClickOnProcessesTab();
		np.definitionsSubTab();
		String definitionName = createDefinitionPageProp.getProperty("nameWithRunPerformAction");
		dp.clickCreateNewDefinitionButton();
		wait(2);
		cdp.enterDefinitionName(definitionName);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		cdp.clickPerformAction();
		String expectedActionValue = createDefinitionPageProp.getProperty("defaultActionDropdownValue");
		Assert.assertTrue(compareTextContains(cdp.getSelectedValueFromActionDropDown(), expectedActionValue));
		String runAction = createDefinitionPageProp.getProperty("actionRun");
		cdp.selectOptionFromActionDropDown(runAction);
		String expectedTaskValue = createDefinitionPageProp.getProperty("defaultTaskDropdownValue");
		String expectedOnSuccessValue = createDefinitionPageProp.getProperty("defaultSuccessDropdownValue");
		String expectedOnFailureValue = createDefinitionPageProp.getProperty("defaultFailureDropdownValue");
		Assert.assertTrue(compareTextContains(cdp.getSelectedValueFromTaskDropDown(), expectedTaskValue));
		Assert.assertTrue(compareTextContains(cdp.getSelectedValueFromSuccessDropDown(), expectedOnSuccessValue));
		Assert.assertTrue(compareTextContains(cdp.getSelectedValueFromFailureDropDown(), expectedOnFailureValue));
		cdp.selectOptionFromTaskByIndex(1);
		String taskValueSelected = (cdp.getSelectedValueFromTaskDropDown()).trim();
		String onSuccessExit = createDefinitionPageProp.getProperty("onSuccessExit");
		cdp.selectOptionFromSuccessDropDown(onSuccessExit);
		String onFailureExit = createDefinitionPageProp.getProperty("onFailureExit");
		cdp.selectOptionFromFailureDropDown(onFailureExit);
		cdp.clickOk();
		Assert.assertTrue(compareTextContains(cdp.getActionTextOnCollaspedView(), runAction));
		Assert.assertTrue(compareTextContains(cdp.getActionTextOnCollaspedView(), taskValueSelected));
		Assert.assertTrue(compareTextContains(cdp.getOnSuccessTextOnCollaspedView(), onSuccessExit));
		Assert.assertTrue(compareTextContains(cdp.getOnFailureTextOnCollaspedView(), onFailureExit));
		cdp.clickSave();
		cdp.verifyToasterMsgAfterSaveDraft();
		cdp.clickClose();
		dp.deleteDefinition(definitionName);
		log.info("Verify Create Process Definition With Run Option in Perform Action - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}

	/**
	 * Create Process Definition With Perform Action as Process Verification
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 */
	@Test(priority = 5)
	public void verifyCreateProcessDefinitionWithPerformActionAsProcess()
			throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Create Process Definition With Process Option in Perform Action- Begin");
		np.navigateToHomeAndClickOnProcessesTab();
		np.definitionsSubTab();
		String definitionName = createDefinitionPageProp.getProperty("nameWithProcessPerformAction");
		dp.clickCreateNewDefinitionButton();
		wait(2);
		cdp.enterDefinitionName(definitionName);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		cdp.clickAddActivity();
		cdp.clickPerformAction();
		String expectedActionValue = createDefinitionPageProp.getProperty("defaultActionDropdownValue");
		Assert.assertTrue(compareTextContains(cdp.getSelectedValueFromActionDropDown(), expectedActionValue));
		String processAction = createDefinitionPageProp.getProperty("actionProcess");
		cdp.selectOptionFromActionDropDown(processAction);
		String expectedTaskValue = createDefinitionPageProp.getProperty("defaultActivityDropdownValue");
		Assert.assertTrue(compareTextContains(cdp.getSelectedValueFromActivityDropDown(), expectedTaskValue));

		cdp.selectOptionFromActivityByIndex(1);
		String activityValueSelected = (cdp.getSelectedValueFromActivityDropDown()).trim();
		cdp.clickOk();
		Assert.assertTrue(compareTextContains(cdp.getActionTextOnCollaspedView(), processAction));
		Assert.assertTrue(compareTextContains(cdp.getActionTextOnCollaspedView(), activityValueSelected));
		cdp.clickSave();
		cdp.verifyToasterMsgAfterSaveDraft();
		Assert.assertTrue(compareTextContains(cdp.getActionTextOnCollaspedView(), processAction));
		Assert.assertTrue(compareTextContains(cdp.getActionTextOnCollaspedView(), activityValueSelected));
		cdp.clickClose();
		dp.deleteDefinition(definitionName);
		log.info("Create Process Definition With Process Option in Perform Action - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}

	/**
	 * Dialog Box Verification of create Definition with Abort Perform Action
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 */
	@Test(priority = 6)
	public void verifyCreateProcessDefinitionWithPerformActionAsAbort()
			throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Create Process Definition With Abort Option in Perform Action- Begin");
		np.navigateToHomeAndClickOnProcessesTab();
		np.definitionsSubTab();
		String definitionName = createDefinitionPageProp.getProperty("nameWithAbortPerformAction");
		dp.clickCreateNewDefinitionButton();
		wait(2);
		cdp.enterDefinitionName(definitionName);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		cdp.clickPerformAction();
		String expectedActionValue = createDefinitionPageProp.getProperty("defaultActionDropdownValue");
		Assert.assertTrue(compareTextContains(cdp.getSelectedValueFromActionDropDown(), expectedActionValue));
		String abortAction = createDefinitionPageProp.getProperty("actionAbort");
		cdp.selectOptionFromActionDropDown(abortAction);
		String abortReason = createDefinitionPageProp.getProperty("reason");
		cdp.enterAbortReason(abortReason);
		cdp.clickOk();
		Assert.assertTrue(compareTextContains(cdp.getActionTextOnCollaspedView(), abortAction));
		cdp.clickSave();
		cdp.verifyToasterMsgAfterSaveDraft();
		Assert.assertTrue(compareTextContains(cdp.getActionTextOnCollaspedView(), abortAction));
		cdp.clickClose();
		dp.deleteDefinition(definitionName);
		log.info("Create Process Definition With Abort Option in Perform Action - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}

	/**
	 * verify Add Perform Action And Rule Count
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 */
	@Test(priority = 7)
	public void verifyAddPerformActionAndRuleCount() throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("verification Add Perform Action And Rule Count - Begin");
		np.navigateToHomeAndClickOnProcessesTab();
		np.definitionsSubTab();
		String definitionName = createDefinitionPageProp.getProperty("nameToVerifyAddPerformActionRuleCount");
		dp.clickCreateNewDefinitionButton();
		wait(2);
		cdp.enterDefinitionName(definitionName);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		cdp.clickAddActivity();
		int actCount = cdp.getTotalActivityCount();
		log.info(actCount);

		cdp.clickPerformActionWithRespectToIndex(actCount - 2);
		int expectedRuleCount = cdp.getActionDropDownListCount();
		cdp.performActionAsExit(0, 0);

		cdp.clickPerformActionWithRespectToIndex(actCount - 2);
		cdp.performActionAsPerform(1);

		cdp.clickPerformActionWithRespectToIndex(actCount - 2);
		cdp.performActionAsProcess(2);

		cdp.clickPerformActionWithRespectToIndex(actCount - 2);
		cdp.performActionAsRun(3);

		cdp.clickPerformActionWithRespectToIndex(actCount - 2);
		cdp.performActionAsAbort(4, 1);

		cdp.clickSave();
		cdp.verifyToasterMsgAfterSaveDraft();
		Assert.assertEquals(cdp.getTotalRuleCount(), expectedRuleCount);
		Assert.assertEquals(cdp.getTotalRuleCountOnLeftPanel(), expectedRuleCount);
		cdp.clickClose();
		dp.deleteDefinition(definitionName);
		log.info("verification Add Perform Action And Rule Count  - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}

	/**
	 * verification of Add Activity
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 */
	@Test(priority = 8)
	public void verifyAddActivityFunctionality() throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("verification of Add Activity - Begin");
		np.navigateToHomeAndClickOnProcessesTab();
		np.definitionsSubTab();
		String definitionName = createDefinitionPageProp.getProperty("nameForaddActivityVerification");
		dp.clickCreateNewDefinitionButton();
		wait(2);
		cdp.enterDefinitionName(definitionName);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		int activityCount = Integer.parseInt(createDefinitionPageProp.getProperty("activityCount"));
		cdp.addActivities(activityCount);
		cdp.clickSave();
		cdp.verifyToasterMsgAfterSaveDraft();
		Assert.assertEquals(cdp.getTotalActivityCount(), activityCount + 2);
		Assert.assertEquals(cdp.getTotalActivityCountOnLeftPanel(), activityCount + 2);
		cdp.clickClose();
		dp.deleteDefinition(definitionName);
		log.info("verification of Add Activity  - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}

	/**
	 * Verify Add New Rule With Invalid Form
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 */
	@Test(priority = 9)
	public void verifyAddRuleInvalidFormValidationMsg() throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify Add New Rule With Invalid Form- Begin");
		np.navigateToHomeAndClickOnProcessesTab();
		np.definitionsSubTab();
		String definitionName = createDefinitionPageProp.getProperty("nameForAddRuleverificationInvalidMessage");
		dp.clickCreateNewDefinitionButton();
		wait(2);
		cdp.enterDefinitionName(definitionName);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		cdp.clickAddNewRule(0);
		cdp.clickOk();
		String expectedMsg = createDefinitionPageProp.getProperty("expectedInvalidFormMsg");
		Assert.assertEquals(cdp.getInvalidAddRuleFormMsg(), expectedMsg, "Invalid form message is not displayed");
		cdp.selectOptionFromFieldByIndex(1);
		cdp.clickOk();
		Assert.assertEquals(cdp.getInvalidAddRuleFormMsg(), expectedMsg, "Invalid form message is not displayed");
		cdp.selectOptionFromOperatorByIndex(1);
		cdp.clickOk();
		Assert.assertEquals(cdp.getInvalidAddRuleFormMsg(), expectedMsg, "Invalid form message is not displayed");
		String valueInput = createDefinitionPageProp.getProperty("valueInput");
		cdp.enterValue(valueInput);
		cdp.clickCancel();
		cdp.clickClose();
		cdp.clickYes();
		log.info("Verify Add New Rule With Invalid Form - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}

	/**
	 * Verify Create Process Definition With Add Rule
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 */
	@Test(priority = 10)
	public void verifyCreateProcessDefinitionWithAddRule() throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify Create Process Definition With Add Rule- Begin");
		np.navigateToHomeAndClickOnProcessesTab();
		np.definitionsSubTab();
		String definitionName = createDefinitionPageProp.getProperty("nameForAddRule");
		dp.clickCreateNewDefinitionButton();
		wait(2);
		cdp.enterDefinitionName(definitionName);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		cdp.clickAddNewRule(0);
		String expectedFieldValue = createDefinitionPageProp.getProperty("defaultFieldValue");
		String expectedOperatorValue = createDefinitionPageProp.getProperty("defaultOperatorDropdownValue");
		String expectedValue = createDefinitionPageProp.getProperty("defaultValueDropdownValue");
		cdp.verifyDefaultView(expectedFieldValue, expectedOperatorValue, expectedValue);
		String valueInput = createDefinitionPageProp.getProperty("valueInput");
		cdp.selectOptionFromDropdown(1, 1, valueInput);
		String fieldValue = cdp.getSelectedValueFromFieldDropDown();
		String operatorValue = cdp.getSelectedValueFromOperatorDropDown().trim();
		String value = cdp.getValueFieldText();
		cdp.clickOk();
		int collapsedViewCount = cdp.getCollapsedViewCountOfConditionBlock();
		cdp.verifyCollapsedView(fieldValue, operatorValue, value, collapsedViewCount - 1);
		cdp.clickSave();
		cdp.verifyToasterMsgAfterSaveDraft();
		cdp.verifyCollapsedView(fieldValue, operatorValue, value, collapsedViewCount - 1);
		cdp.clickClose();
		// cdp.clickYes();
		dp.deleteDefinition(definitionName);
		log.info("Verify Create Process Definition With Add Rule- End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}

	/**
	 * Verify Create Process Definition With And Connector
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 */
	@Test(priority = 11)
	public void verifyCreateProcessDefinitionWithAndConnector() throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify Create Process Definition With And Connector - Begin");
		np.navigateToHomeAndClickOnProcessesTab();
		np.definitionsSubTab();
		String definitionName = createDefinitionPageProp.getProperty("nameForActivityWithAnd");
		dp.clickCreateNewDefinitionButton();
		wait(2);
		cdp.enterDefinitionName(definitionName);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		log.info("Add New Rule & And Connector for Start Activity :");
		cdp.clickAddNewRule(0);
		String valueInput = createDefinitionPageProp.getProperty("valueInput");
		cdp.selectOptionFromDropdown(1, 1, valueInput);
		cdp.clickOk();
		cdp.clickOnAndButton(0);
		cdp.selectOptionFromDropdown(2, 4, valueInput);
		cdp.clickOk();
		cdp.verifyAndConnector(0);
		cdp.clickAddActivity();
		int activiyCount = cdp.getActivityIndex();
		log.info("Toctal activity : " + activiyCount);
		log.info("Add New Rule & And Connector for Intermediate Activity :");
		cdp.clickAddNewRule(activiyCount - 2);
		cdp.selectOptionFromDropdown(1, 1, valueInput);
		wait(2);
		cdp.clickOk();
		cdp.clickOnAndButton(activiyCount - 2);
		cdp.selectOptionFromDropdown(2, 4, valueInput);
		cdp.clickOk();
		cdp.verifyAndConnector(activiyCount - 2);
		log.info("Add New Rule & And Connector for Final Activity :");
		cdp.clickAddNewRule(activiyCount - 1);
		wait(2);
		cdp.selectOptionFromDropdown(1, 1, valueInput);
		cdp.clickOk();
		cdp.clickOnAndButton(activiyCount - 1);
		cdp.selectOptionFromDropdown(2, 4, valueInput);
		cdp.clickOk();
		cdp.verifyAndConnector(activiyCount - 1);
		cdp.clickSave();
		cdp.verifyToasterMsgAfterSaveDraft();
		cdp.clickClose();
		// cdp.clickYes();
		dp.deleteDefinition(definitionName);
		log.info("Verify Create Process Definition With And Connector - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}

	/**
	 * Verify Create Process Definition With Multiple And
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 */
	@Test(priority = 12)
	public void verifyCreateProcessDefinitionWithMultipleAnd() throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify Create Process Definition With Multiple And - Begin");
		np.navigateToHomeAndClickOnProcessesTab();
		np.definitionsSubTab();
		String definitionName = createDefinitionPageProp.getProperty("nameForAddRuleMultipleAnd");
		dp.clickCreateNewDefinitionButton();
		wait(2);
		cdp.enterDefinitionName(definitionName);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		cdp.clickAddNewRule(0);
		String valueInput = createDefinitionPageProp.getProperty("valueInput");
		cdp.addConditionAndVerifyCollapsedView(1, 1, valueInput);
		cdp.clickOnAndButton(0);
		cdp.addConditionAndVerifyCollapsedView(2, 4, valueInput);
		cdp.clickOnAndButton(0);
		cdp.addConditionAndVerifyCollapsedView(1, 1, valueInput);
		cdp.clickOnAndButton(0);
		cdp.addConditionAndVerifyCollapsedView(2, 4, valueInput);
		cdp.clickSave();
		cdp.verifyToasterMsgAfterSaveDraft();
		cdp.clickClose();
		// cdp.clickYes();
		dp.deleteDefinition(definitionName);
		log.info("Verify Create Process Definition With Multiple And - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}

	/**
	 * Verify Create Process Definition With Or Connector
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 */
	@Test(priority = 13)
	public void verifyCreateProcessDefinitionWithOrConnector() throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify Create Process Definition With Or Connector - Begin");
		np.navigateToHomeAndClickOnProcessesTab();
		np.definitionsSubTab();
		String definitionName = createDefinitionPageProp.getProperty("nameForActivityWithOr");
		dp.clickCreateNewDefinitionButton();
		wait(2);
		cdp.enterDefinitionName(definitionName);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		log.info("Add New Rule & Or Connector for Start Activity :");
		cdp.clickAddNewRule(0);
		String valueInput = createDefinitionPageProp.getProperty("valueInput");
		cdp.selectOptionFromDropdown(1, 1, valueInput);
		cdp.clickOk();
		cdp.clickOnOrButton(0);
		cdp.selectOptionFromDropdown(2, 4, valueInput);
		cdp.clickOk();
		cdp.verifyOrConnector(0);
		cdp.clickAddActivity();
		int activiyCount = cdp.getActivityIndex();
		log.info("Toctal activity : " + activiyCount);
		log.info("Add New Rule & Or Connector for Intermediate Activity :");
		cdp.clickAddNewRule(activiyCount - 2);
		cdp.selectOptionFromDropdown(1, 1, valueInput);
		wait(2);
		cdp.clickOk();
		cdp.clickOnOrButton(activiyCount - 2);
		cdp.selectOptionFromDropdown(2, 4, valueInput);
		cdp.clickOk();
		cdp.verifyOrConnector(activiyCount - 2);
		log.info("Add New Rule & Or Connector for Final Activity :");
		cdp.clickAddNewRule(activiyCount - 1);
		wait(2);

		cdp.selectOptionFromDropdown(1, 1, valueInput);
		cdp.clickOk();
		cdp.clickOnOrButton(activiyCount - 1);
		cdp.selectOptionFromDropdown(2, 4, valueInput);
		cdp.clickOk();
		cdp.verifyOrConnector(activiyCount - 1);
		cdp.clickSave();
		String actualValidationMsg = cdp.getSuccessToasterMsg();
		String expectedValidationMsg = createDefinitionPageProp.getProperty("expectedSuccessValidationMsg");
		Assert.assertTrue(compareTextContains(actualValidationMsg, expectedValidationMsg),
				"Success message not displayed");
		cdp.clickClose();
		// cdp.clickYes();
		dp.deleteDefinition(definitionName);
		log.info("Verify Create Process Definition With Or Connector - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}

	/**
	 * Verify Create Process Definition With Multiple Or Connector
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 */
	@Test(priority = 14)
	public void verifyCreateProcessDefinitionWithMultipleOrConnector()
			throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify Create Process Definition With Multiple Or Connector - Begin");
		np.navigateToHomeAndClickOnProcessesTab();
		np.definitionsSubTab();
		String definitionName = createDefinitionPageProp.getProperty("nameForAddRuleMultipleOr");
		dp.clickCreateNewDefinitionButton();
		wait(2);
		cdp.enterDefinitionName(definitionName);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		cdp.clickAddNewRule(0);
		String valueInput = createDefinitionPageProp.getProperty("valueInput");
		cdp.addConditionAndVerifyCollapsedView(1, 1, valueInput);
		cdp.clickOnOrButton(0);
		cdp.addConditionAndVerifyCollapsedView(2, 4, valueInput);
		cdp.clickOnOrButton(0);
		cdp.addConditionAndVerifyCollapsedView(1, 1, valueInput);
		cdp.clickOnOrButton(0);
		cdp.addConditionAndVerifyCollapsedView(1, 1, valueInput);
		cdp.clickSave();
		cdp.verifyToasterMsgAfterSaveDraft();
		cdp.clickClose();
		// cdp.clickYes();
		dp.deleteDefinition(definitionName);
		log.info("Verify Create Process Definition With Multiple Or Connector - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}

	/**
	 * Verify Create Process Definition With Combination of And & Or
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 */
	@Test(priority = 15)
	public void verifyCreateProcessDefinitionWithCombinationOfAndOr()
			throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify Create Process Definition With Combination of And & Or - Begin");
		np.navigateToHomeAndClickOnProcessesTab();
		np.definitionsSubTab();
		String definitionName = createDefinitionPageProp.getProperty("nameForCombinationOfAndOr");
		dp.clickCreateNewDefinitionButton();
		wait(2);
		cdp.enterDefinitionName(definitionName);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		cdp.clickAddNewRule(0);
		String valueInput = createDefinitionPageProp.getProperty("valueInput");
		cdp.addConditionAndVerifyCollapsedView(1, 1, valueInput);
		cdp.clickOnAndButton(0);
		cdp.addConditionAndVerifyCollapsedView(2, 4, valueInput);
		cdp.clickOnOrButton(0);
		cdp.addConditionAndVerifyCollapsedView(1, 1, valueInput);
		cdp.clickSave();
		cdp.verifyToasterMsgAfterSaveDraft();
		cdp.clickClose();
		// cdp.clickYes();
		dp.deleteDefinition(definitionName);
		log.info("Verify Create Process Definition With Combination of And & Or  - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}

	/**
	 * Verify Create Process Definition Change Connector Type
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 */
	@Test(priority = 16)
	public void verifyCreateProcessDefinitionChangeConnectorType()
			throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify Create Process Definition Change Connector Type- Begin");
		np.navigateToHomeAndClickOnProcessesTab();
		np.definitionsSubTab();
		String definitionName = createDefinitionPageProp.getProperty("createProcessDefinitionChangeConnectorType");
		dp.clickCreateNewDefinitionButton();
		wait(2);
		cdp.enterDefinitionName(definitionName);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		cdp.clickAddNewRule(0);
		String valueInput = createDefinitionPageProp.getProperty("valueInput");
		cdp.addConditionAndVerifyCollapsedView(1, 1, valueInput);
		cdp.clickOnAndButton(0);
		cdp.addConditionAndVerifyCollapsedView(2, 4, valueInput);
		cdp.clickAndConnector(0);
		cdp.clickDownConnector();
		cdp.verifyOrConnector(0);
		cdp.clickSave();
		cdp.verifyToasterMsgAfterSaveDraft();
		cdp.verifyOrConnector(0);
		cdp.clickRuleOverlay(0);
		cdp.clickOnOrButton(0);
		cdp.addConditionAndVerifyCollapsedView(1, 1, valueInput);
		cdp.clickOrConnector(1);
		cdp.clickUpConnector();
		cdp.verifyOrConnector(0);
		cdp.clickSave();
		cdp.verifyAndConnector(0);
		// cdp.verifyToasterMsgAfterSaveDraft();
		cdp.clickClose();
		dp.deleteDefinition(definitionName);
		log.info("Verify Create Process Definition Change Connector Type  - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}

	/**
	 * Verify Container Validation
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 */
	@Test(priority = 17)
	public void verifyContainerValidation() throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify Container Validation - Begin");
		np.navigateToHomeAndClickOnProcessesTab();
		np.definitionsSubTab();
		String definitionName = createDefinitionPageProp.getProperty("nameForInvalidContainer");
		dp.clickCreateNewDefinitionButton();
		wait(2);
		cdp.enterDefinitionName(definitionName);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		cdp.clickAddNewRule(0);
		String valueInput = createDefinitionPageProp.getProperty("valueInput");
		cdp.addConditionAndVerifyCollapsedView(1, 1, valueInput);
		cdp.clickOnAndButton(0);
		cdp.addConditionAndVerifyCollapsedView(2, 4, valueInput);
		cdp.clickOnOrButton(0);
		cdp.addConditionAndVerifyCollapsedView(1, 1, valueInput);
		int hamburgerCount = cdp.getCollapsedViewCountOfConditionBlock();
		log.info("hamburger count : " + hamburgerCount);
		cdp.clickOnContainerButton(0);
		Assert.assertFalse(cdp.isAndButtonClickable(0), "AND button should not be clickable while creating container");
		Assert.assertFalse(cdp.isOrButtonClickable(0), "OR button should not be clickable while creating container");
		cdp.clickOnContainerCheckbox(0, hamburgerCount - 1);
		cdp.clickOnDoneButton(0);
		String expectedToasterErrorMsg = createDefinitionPageProp
				.getProperty("expectedInvalidContainerErrorToasterMessage");
		cdp.verifyErrorToasterMsg(expectedToasterErrorMsg);
		cdp.clickCancelContainer();
		cdp.clickAndConnector(0);
		cdp.clickDownConnector();
		cdp.clickOnContainerButton(0);
		cdp.clickOnContainerCheckbox(0, hamburgerCount - 1);
		cdp.clickOnContainerCheckbox(1, 1);
		cdp.clickOnDoneButton(0);
		cdp.verifyErrorToasterMsg(expectedToasterErrorMsg);
		cdp.clickOnContainerCheckbox(1, 1);
		cdp.clickOnDoneButton(0);
		Assert.assertFalse(cdp.isOrConnectorClickable(), "Connector should not be clickable if in container");
		cdp.clickClose();
		cdp.clickYes();
		log.info("Verify Container Validation  - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}

	/**
	 * Verify Create Process Definition With And In Container
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 */
	@Test(priority = 18)
	public void verifyCreateProcessDefinitionWithAndInContainer()
			throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify Create Process Definition With And In Container - Begin");
		np.navigateToHomeAndClickOnProcessesTab();
		np.definitionsSubTab();
		String definitionName = createDefinitionPageProp.getProperty("nameForAndInContainer");
		dp.clickCreateNewDefinitionButton();
		wait(2);
		cdp.enterDefinitionName(definitionName);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		cdp.clickAddNewRule(0);
		String valueInput = createDefinitionPageProp.getProperty("valueInput");
		cdp.addConditionAndVerifyCollapsedView(1, 1, valueInput);
		cdp.clickOnAndButton(0);
		cdp.addConditionAndVerifyCollapsedView(2, 4, valueInput);
		cdp.clickOnAndButton(0);
		cdp.addConditionAndVerifyCollapsedView(1, 1, valueInput);
		int hamburgerCount = cdp.getCollapsedViewCountOfConditionBlock();
		log.info("hamburger count : " + hamburgerCount);
		cdp.clickOnContainerButton(0);
		cdp.clickOnContainerCheckbox(0, hamburgerCount - 1);
		cdp.clickOnDoneButton(0);
		cdp.clickSave();
		cdp.verifyToasterMsgAfterSaveDraft();
		cdp.clickClose();
		dp.deleteDefinition(definitionName);
		log.info("Verify Create Process Definition With With And In Container - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}

	/**
	 * Verify Create Process Definition With OR In Container
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 */
	@Test(priority = 19)
	public void verifyCreateProcessDefinitionWithOrInContainer()
			throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify Create Process Definition With Or In Container - Begin");
		np.navigateToHomeAndClickOnProcessesTab();
		np.definitionsSubTab();
		String definitionName = createDefinitionPageProp.getProperty("nameForOrInContainer");
		dp.clickCreateNewDefinitionButton();
		wait(2);
		cdp.enterDefinitionName(definitionName);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		cdp.clickAddNewRule(0);
		String valueInput = createDefinitionPageProp.getProperty("valueInput");
		cdp.addConditionAndVerifyCollapsedView(1, 1, valueInput);
		cdp.clickOnOrButton(0);
		cdp.addConditionAndVerifyCollapsedView(2, 4, valueInput);
		cdp.clickOnOrButton(0);
		cdp.addConditionAndVerifyCollapsedView(1, 1, valueInput);
		int hamburgerCount = cdp.getCollapsedViewCountOfConditionBlock();
		log.info("hamburger count : " + hamburgerCount);
		cdp.clickOnContainerButton(0);
		cdp.clickOnContainerCheckbox(0, hamburgerCount - 1);
		cdp.clickOnDoneButton(0);
		cdp.clickSave();
		cdp.verifyToasterMsgAfterSaveDraft();
		cdp.clickClose();
		dp.deleteDefinition(definitionName);
		log.info("Verify Create Process Definition With With Or In Container - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}

	/**
	 * Verify Create Process Definition With Combination of And & Or In
	 * Container
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 */
	@Test(priority = 20)
	public void verifyCreateProcessDefinitionWithCombinationOfAndOrInContainer()
			throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify Create Process Definition With Combination of And & Or In Container - Begin");
		np.navigateToHomeAndClickOnProcessesTab();
		np.definitionsSubTab();
		dp.clickCreateNewDefinitionButton();
		String definitionName = createDefinitionPageProp.getProperty("nameForCombinationOfAndOrInContainer");
		wait(2);
		cdp.enterDefinitionName(definitionName);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		cdp.clickAddNewRule(0);
		String valueInput = createDefinitionPageProp.getProperty("valueInput");
		cdp.addConditionAndVerifyCollapsedView(1, 1, valueInput);
		cdp.clickOnAndButton(0);
		cdp.addConditionAndVerifyCollapsedView(2, 4, valueInput);
		cdp.clickOnAndButton(0);
		cdp.addConditionAndVerifyCollapsedView(1, 1, valueInput);
		cdp.clickOnOrButton(0);
		cdp.addConditionAndVerifyCollapsedView(1, 6, valueInput);
		cdp.clickOnOrButton(0);
		cdp.addConditionAndVerifyCollapsedView(2, 5, valueInput);
		int hamburgerCount = cdp.getCollapsedViewCountOfConditionBlock();
		log.info("hamburger count : " + hamburgerCount);
		cdp.clickOnContainerButton(0);
		cdp.clickOnContainerCheckbox(0, 2);
		cdp.clickOnDoneButton(0);
		cdp.clickOnContainerButton(0);
		cdp.clickOnContainerCheckbox(0, 1);
		cdp.clickOnDoneButton(0);

		cdp.clickSave();
		cdp.verifyToasterMsgAfterSaveDraft();
		cdp.clickClose();

		dp.deleteDefinition(definitionName);
		log.info("Verify Create Process Definition With Combination of And & Or In Container  - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}

	/**
	 * Verify add container using mouse drag
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 */
	@Test(priority = 20)
	public void verifyAddContainerUsingMouseDrag() throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify Create Process Definition With Combination of And & Or In Container - Begin");
		np.navigateToHomeAndClickOnProcessesTab();
		np.definitionsSubTab();
		dp.clickCreateNewDefinitionButton();
		String definitionName = createDefinitionPageProp.getProperty("nameForAddContainerUsingMouseDrag");
		wait(2);
		cdp.enterDefinitionName(definitionName);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		cdp.clickAddNewRule(0);
		String valueInput = createDefinitionPageProp.getProperty("valueInput");
		cdp.addConditionAndVerifyCollapsedView(1, 1, valueInput);
		cdp.clickOnAndButton(0);
		cdp.addConditionAndVerifyCollapsedView(2, 4, valueInput);
		cdp.clickOnOrButton(0);
		cdp.addConditionAndVerifyCollapsedView(1, 1, valueInput);
		cdp.clickOnOrButton(0);
		cdp.addConditionAndVerifyCollapsedView(1, 6, valueInput);
		cdp.clickOnOrButton(0);
		cdp.addConditionAndVerifyCollapsedView(2, 5, valueInput);
		int hamburgerCount = cdp.getCollapsedViewCountOfConditionBlock();
		log.info("hamburger count : " + hamburgerCount);
		cdp.clickOnContainerButton(0);
		cdp.mouseDragAndSelectFieldCondition(0, 2);
		cdp.clickOnDoneButton(0);
		String expectedToasterErrorMsg = createDefinitionPageProp
				.getProperty("expectedInvalidContainerErrorToasterMessage");
		cdp.verifyErrorToasterMsg(expectedToasterErrorMsg);
		cdp.clickCancelContainer();
		cdp.clickOnContainerButton(0);
		cdp.mouseDragAndSelectFieldCondition(3, 4);
		cdp.clickOnDoneButton(0);
		cdp.clickSave();
		cdp.verifyToasterMsgAfterSaveDraft();
		Assert.assertTrue(cdp.isContainerAddedForCondition(0), "Container is not added");
		cdp.clickClose();

		dp.deleteDefinition(definitionName);
		log.info("Verify Create Process Definition With Combination of And & Or In Container  - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}

	/**
	 * Verify Type Ahead In Condition Block
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 */
	@Test(priority = 21)
	public void verifyTypeAheadInConditionBlock() throws InterruptedException, IOException, AWTException {
		log.info("----------------------------------------------------------------------------------");
		log.info("Verify Type Ahead In Condition Block  - End");
		np.navigateToHomeAndClickOnProcessesTab();
		np.definitionsSubTab();
		String definitionName = createDefinitionPageProp.getProperty("nameToVerifyTypeAheadInValueField");
		dp.clickCreateNewDefinitionButton();
		wait(2);
		cdp.enterDefinitionName(definitionName);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		cdp.clickAddNewRule(0);
		String valueInput = "P";
		String expectedValueInput = "TCPPacketData";
		cdp.selectOptionFromFieldByText("Image");
		cdp.selectOptionFromOperatorByIndex(5);
		cdp.enterValue(valueInput);
		cdp.selectOptionWithTextInTypeAhead(expectedValueInput);
		Assert.assertEquals(cdp.getValueFieldText(), expectedValueInput, "Value selected by type ahead is not correct");
		cdp.clickOk();
		cdp.clickOnAndButton(0);
		cdp.selectOptionFromFieldByText("CategoryType");
		cdp.selectOptionFromOperatorByIndex(3);
		String valueInput1 = createDefinitionPageProp.getProperty("valueInput");
		cdp.enterValue(valueInput1);
		Assert.assertEquals(cdp.getValueFieldText(), valueInput1, "Custom Value is not added to value field");
		cdp.clickOk();
		cdp.clickClose();
		cdp.clickYes();
		log.info("Verify Type Ahead In Condition Block  - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}

	/**
	 * Verify Type Ahead In Condition Block
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 */
	@Test(priority = 22)
	public void autoSearchPreviousValuesExitAndAbortAction() throws InterruptedException, IOException, AWTException {
		log.info("Verify Type Ahead In Condition Block  - Begin");
		log.info("-------------------------------------------------------------------------------");
		np.navigateToHomeAndClickOnProcessesTab();
		np.definitionsSubTab();
		String definitionName = createDefinitionPageProp.getProperty("nameToVerifyAutoSearchPreviousValues");
		dp.clickCreateNewDefinitionButton();
		wait(2);
		cdp.enterDefinitionName(definitionName);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		cdp.clickPerformAction();
		String exitAction = createDefinitionPageProp.getProperty("actionExit");
		String exitReason = createDefinitionPageProp.getProperty("exitReason");
		cdp.selectOptionFromActionDropDown(exitAction);
		cdp.enterExitReason(exitReason);
		cdp.clickOk();
		cdp.clickPerformAction();
		cdp.selectOptionFromActionDropDown(exitAction);
		cdp.enterExitReason("N");
		cdp.selectOptionWithTextInTypeAhead(exitReason);
		Assert.assertEquals(cdp.getExitReasonText(), exitReason, "Exit reason entered from autosearch is incorrect");
		cdp.clickOk();
		cdp.clickPerformAction();
		cdp.selectOptionFromActionDropDown(exitAction);
		cdp.enterExitReason("N");
		int count = cdp.getsListOfOptionWithTextInTypeAhead(exitReason);
		Assert.assertEquals(count, 1, "Single option with previously entered value should be present");
		cdp.selectOptionWithTextInTypeAhead(exitReason);
		cdp.clickOk();
		cdp.clickPerformAction();
		String abortAction = createDefinitionPageProp.getProperty("actionAbort");
		String abortReason = createDefinitionPageProp.getProperty("abortReason");
		cdp.selectOptionFromActionDropDown(abortAction);
		cdp.enterAbortReason(abortReason);
		cdp.clickOk();
		cdp.clickPerformAction();
		cdp.selectOptionFromActionDropDown(abortAction);
		cdp.enterAbortReason("N");
		cdp.selectOptionWithTextInTypeAhead(abortReason);
		Assert.assertEquals(cdp.getAbortReasonText(), abortReason, "Abort reason entered from autosearch is incorrect");
		cdp.clickOk();
		cdp.clickPerformAction();
		cdp.selectOptionFromActionDropDown(abortAction);
		cdp.enterAbortReason("N");
		int count1 = cdp.getsListOfOptionWithTextInTypeAhead(abortReason);
		Assert.assertEquals(count1, 1, "Single option with previously entered value should be present");
		cdp.selectOptionWithTextInTypeAhead(abortReason);
		cdp.clickOk();
		cdp.clickClose();
		cdp.clickYes();
		log.info("Verify Type Ahead In Condition Block  - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}

	/**
	 * Verify Add Action After Condition In Container
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 */
	@Test(priority = 23)
	public void verifyAddActionAfterConditionInContainer() throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify Add Action After Condition In Container - Begin");
		np.navigateToHomeAndClickOnProcessesTab();
		np.definitionsSubTab();
		String definitionName = createDefinitionPageProp.getProperty("nameForRuleInContainerAndAction");
		dp.clickCreateNewDefinitionButton();
		wait(2);
		cdp.enterDefinitionName(definitionName);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		cdp.clickAddNewRule(0);
		String valueInput = createDefinitionPageProp.getProperty("valueInput");
		cdp.addConditionAndVerifyCollapsedView(1, 1, valueInput);
		cdp.clickOnOrButton(0);
		cdp.addConditionAndVerifyCollapsedView(2, 4, valueInput);
		cdp.clickOnOrButton(0);
		cdp.addConditionAndVerifyCollapsedView(1, 1, valueInput);
		int hamburgerCount = cdp.getCollapsedViewCountOfConditionBlock();
		log.info("Hamburger count : " + hamburgerCount);
		cdp.clickOnContainerButton(0);
		cdp.clickOnContainerCheckbox(1, hamburgerCount - 1);
		cdp.clickOnDoneButton(0);
		cdp.clickOnPerformActionIcon(0);
		cdp.performActionAsExit(0, 0);
		cdp.clickSave();
		cdp.verifyToasterMsgAfterSaveDraft();
		cdp.verifyPerformActionConnector(0);
		cdp.verifyPerformActionGetAddedBlueBoltIndicator(0);
		cdp.clickClose();
		dp.deleteDefinition(definitionName);
		log.info("Verify Add Action After Condition In Container- End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}

	/**
	 * Verify Add Action After Condition
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 */
	@Test(priority = 24)
	public void verifyAddActionAfterCondition() throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify Add Action After Condition - Begin");
		np.navigateToHomeAndClickOnProcessesTab();
		np.definitionsSubTab();
		String definitionName = createDefinitionPageProp.getProperty("nameForAddActionAfterCondition");
		dp.clickCreateNewDefinitionButton();
		wait(2);
		cdp.enterDefinitionName(definitionName);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		cdp.clickAddActivity();
		cdp.clickAddNewRule(0);
		String valueInput = createDefinitionPageProp.getProperty("valueInput");
		addActionAfterCondition(1, 5, valueInput, "Exit", 0);
		cdp.clickAddNewRule(0);
		addActionAfterCondition(2, 4, valueInput, "Perform", 1);
		cdp.clickAddNewRule(0);
		addActionAfterCondition(1, 6, valueInput, "Process", 2);
		cdp.clickAddNewRule(0);
		addActionAfterCondition(2, 8, valueInput, "Run", 3);
		cdp.clickAddNewRule(0);
		addActionAfterCondition(1, 1, valueInput, "Abort", 4);
		cdp.clickClose();
		dp.deleteDefinition(definitionName);
		log.info("Verify Add Action After Condition - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}

	/**
	 * Verify Publish Definition Without Action
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 */
	@Test(priority = 25)
	public void verifyPublishDefinitionWithoutAction() throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info(" Verify Publish Definition Without Action - Begin");
		np.navigateToHomeAndClickOnProcessesTab();
		np.definitionsSubTab();
		String definitionName = createDefinitionPageProp.getProperty("nameForPublishDefinitionWithoutAction");
		dp.clickCreateNewDefinitionButton();
		wait(2);
		cdp.enterDefinitionName(definitionName);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		String valueInput = createDefinitionPageProp.getProperty("valueInput");
		cdp.clickAddNewRule(0);
		cdp.addConditionAndVerifyCollapsedView(1, 2, valueInput);
		cdp.clickPublishButton();
		String expectedErrorToasterMsg = createDefinitionPageProp
				.getProperty("expectedToasterMsgOnPublishWithoutAction");
		cdp.verifyErrorToasterMsg(expectedErrorToasterMsg);
		cdp.clickClose();
		dp.deleteDefinition(definitionName);
		log.info(" Verify Publish Definition Without Action - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}

	/**
	 * Verify Remove Container
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 */
	@Test(priority = 26)
	public void verifyRemoveContainer() throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify Remove Container - Begin");
		np.navigateToHomeAndClickOnProcessesTab();
		np.definitionsSubTab();
		String definitionName = createDefinitionPageProp.getProperty("nameForRuleWithRemoveContainer");
		dp.clickCreateNewDefinitionButton();
		wait(2);
		cdp.enterDefinitionName(definitionName);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		cdp.clickAddNewRule(0);
		String valueInput = createDefinitionPageProp.getProperty("valueInput");
		cdp.addConditionAndVerifyCollapsedView(1, 1, valueInput);
		cdp.clickOnOrButton(0);
		cdp.addConditionAndVerifyCollapsedView(2, 4, valueInput);
		int hamburgerCount = cdp.getCollapsedViewCountOfConditionBlock();
		log.info("Hamburger count : " + hamburgerCount);
		cdp.clickOnContainerButton(0);
		cdp.clickOnContainerCheckbox(0, hamburgerCount - 1);
		cdp.clickOnDoneButton(0);
		cdp.clickSave();
		cdp.verifyToasterMsgAfterSaveDraft();
		Assert.assertTrue(cdp.isContainerAddedForCondition(0), "Container is not added");
		cdp.clickRuleOverlay(0);
		cdp.clickOnContainerEllipse(0);
		cdp.verifyActionMenuContainer();
		cdp.clickOnUngroupContainerIcon();
		cdp.clickSave();
		cdp.verifyToasterMsgSaveDraftForProcessUpdate();
		Assert.assertFalse(cdp.isUngroupContainerIconDisplayed(), "Container is not Removed");
		cdp.clickClose();
		dp.deleteDefinition(definitionName);
		log.info("Verify Remove Container - Begin");
		log.info("--------------------------------------XXX-------------------------------------------");
	}

	/**
	 * Verify if Save Draft is disabled if definition is Publish - Begin
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 */
	@Test(priority = 27)
	public void verifyIfSaveDraftDisabledAfterPublish() throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify if Save Draft is disabled if definition is Publish - Begin");
		np.navigateToHomeAndClickOnProcessesTab();
		np.definitionsSubTab();
		String definitionName = createDefinitionPageProp.getProperty("nameForSaveDraftDisabledAfterPublish");
		dp.clickCreateNewDefinitionButton();
		wait(2);
		cdp.enterDefinitionName(definitionName);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		cdp.clickSave();
		cdp.verifyToasterMsgAfterSaveDraft();
		cdp.clickPublishButton();
		dp.verifyToasterMsgOnPublishAfterSave();
		wait(2);
		dp.editDefinition(definitionName);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		Assert.assertFalse(cdp.isSaveDraftButtonEnabled(),
				"Save draft button should not be enabled on edit if definition is already published");
		Assert.assertTrue(cdp.isPublishButtonEnabled(), "Publish button should be enabled");
		cdp.clickClose();
		dp.deleteDefinition(definitionName);
		log.info("Verify if Save Draft is disabled if definition is Publish - End");
		log.info("--------------------------------------XXX-------------------------------------------");
	}

	/**
	 * Verify Edit Condition Block
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 */
	@Test(priority = 28)
	public void verifyEditConditionBlock() throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify Edit Condition Block- Begin");
		np.navigateToHomeAndClickOnProcessesTab();
		np.definitionsSubTab();
		String definitionName = createDefinitionPageProp.getProperty("nameForEditConditionVerification");
		dp.clickCreateNewDefinitionButton();
		wait(2);
		cdp.enterDefinitionName(definitionName);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		cdp.clickAddNewRule(0);
		String valueInput = createDefinitionPageProp.getProperty("valueInput");
		cdp.addConditionAndVerifyCollapsedView(1, 1, valueInput);
		cdp.clickOnOrButton(0);
		cdp.addConditionAndVerifyCollapsedView(2, 4, valueInput);
		cdp.clickOnPerformActionIcon(0);
		cdp.performActionAsExit(0, 0);
		int hamburgerCount = cdp.getCollapsedViewCountOfConditionBlock();
		cdp.clickAndVerifyConditionEllipsesIcon(hamburgerCount - 1);
		cdp.verifyActionMenuCondition();
		String newvalueInput = createDefinitionPageProp.getProperty("newValueInput");
		cdp.clickOnEditConditionIcon();
		cdp.addConditionAndVerifyCollapsedView(1, 6, newvalueInput);
		cdp.clickSave();
		cdp.clickClose();
		dp.deleteDefinition(definitionName);
		log.info("Verify Edit Condition Block- End");
		log.info("---------------------------------------XXX------------------------------------------");
	}

	/**
	 * Verify Menu items when clicked on vertical ellipse for condition block
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 */
	@Test(priority = 29)
	public void verifyMenuItemsWhenClickedOnEllipsesForCondition()
			throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify Menu items when clicked on vertical ellipse for condition block- Begin");
		np.navigateToHomeAndClickOnProcessesTab();
		np.definitionsSubTab();
		String definitionName = createDefinitionPageProp.getProperty("nameForMenuItemVerification");
		dp.clickCreateNewDefinitionButton();
		wait(2);
		cdp.enterDefinitionName(definitionName);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		cdp.clickAddNewRule(0);
		String valueInput = createDefinitionPageProp.getProperty("valueInput");
		cdp.addConditionAndVerifyCollapsedView(1, 1, valueInput);
		cdp.clickOnOrButton(0);
		cdp.addConditionAndVerifyCollapsedView(2, 4, valueInput);
		int hamburgerCount = cdp.getCollapsedViewCountOfConditionBlock();
		cdp.clickAndVerifyConditionEllipsesIcon(hamburgerCount - 1);
		cdp.verifyActionMenuCondition();
		wait(2);
		cdp.clickClose();
		cdp.clickYes();
		log.info("Verify Menu items when clicked on vertical ellipse for condition block- End");
		log.info("-------------------------------------XXX--------------------------------------------");
	}

	/**
	 * Verify delete condition block
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 */
	@Test(priority = 30)
	public void verifyDeleteConditionWithActionBlock() throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify delete condition block- Begin");
		np.navigateToHomeAndClickOnProcessesTab();
		np.definitionsSubTab();
		String definitionName = createDefinitionPageProp.getProperty("nameForDeleteConditionWithActionVerification");
		dp.clickCreateNewDefinitionButton();
		wait(2);
		cdp.enterDefinitionName(definitionName);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		cdp.clickAddNewRule(0);
		String valueInput = createDefinitionPageProp.getProperty("valueInput");
		cdp.addConditionAndVerifyCollapsedView(1, 1, valueInput);
		cdp.clickOnOrButton(0);
		cdp.addConditionAndVerifyCollapsedView(2, 4, valueInput);
		cdp.clickOnPerformActionIcon(0);
		cdp.performActionAsExit(0, 0);
		int hamburgerCount = cdp.getCollapsedViewCountOfConditionBlock();
		cdp.clickAndVerifyConditionEllipsesIcon(hamburgerCount - 1);
		cdp.deleteCondition();
		cdp.clickSave();
		cdp.verifyToasterMsgAfterSaveDraft();
		Assert.assertEquals(cdp.getCollapsedViewCountOfConditionBlock(), hamburgerCount - 1,
				"Condition block is not deleted");
		wait(2);
		cdp.clickClose();
		dp.deleteDefinition(definitionName);
		log.info("Verify delete condition block- End");
		log.info("---------------------------------------XXX------------------------------------------");
	}

	/**
	 * Verify delete condition block Without Action Block
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 */
	@Test(priority = 31)
	public void verifyDeleteConditionWithoutActionBlock() throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify delete condition block Without Action Block- Begin");
		np.navigateToHomeAndClickOnProcessesTab();
		np.definitionsSubTab();
		String definitionName = createDefinitionPageProp.getProperty("nameForDeleteConditionWithoutActionVerification");
		dp.clickCreateNewDefinitionButton();
		wait(2);
		cdp.enterDefinitionName(definitionName);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		cdp.clickAddNewRule(0);
		String valueInput = createDefinitionPageProp.getProperty("valueInput");
		cdp.addConditionAndVerifyCollapsedView(1, 1, valueInput);
		cdp.clickOnOrButton(0);
		cdp.addConditionAndVerifyCollapsedView(2, 4, valueInput);
		cdp.clickOnOrButton(0);
		cdp.addConditionAndVerifyCollapsedView(1, 3, valueInput);
		int hamburgerCount = cdp.getCollapsedViewCountOfConditionBlock();
		cdp.clickAndVerifyConditionEllipsesIcon(hamburgerCount - 1);
		cdp.deleteCondition();
		cdp.clickSave();
		cdp.verifyToasterMsgAfterSaveDraft();
		Assert.assertEquals(cdp.getCollapsedViewCountOfConditionBlock(), hamburgerCount - 1,
				"Condition block is not deleted");
		wait(2);
		cdp.clickClose();
		dp.deleteDefinition(definitionName);
		log.info("Verify delete condition block Without Action Block- End");
		log.info("--------------------------------------XXX-------------------------------------------");
	}

	/**
	 * Verify Disabling of all other elements On Create/Edit Condition/Action
	 * block
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 */
	@Test(priority = 32)
	public void verifyDisableElementsOnCreateEditConditionAction()
			throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify Disabling of all other elements On Create/Edit Condition/Action block - Begin");
		np.navigateToHomeAndClickOnProcessesTab();
		np.definitionsSubTab();
		String definitionName = createDefinitionPageProp.getProperty("nameForDisablingCondition");
		dp.clickCreateNewDefinitionButton();
		wait(2);
		cdp.enterDefinitionName(definitionName);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		cdp.clickAddNewRule(0);
		cdp.verifyDisablingOnCreateEditConditionAction();
		String valueInput = createDefinitionPageProp.getProperty("valueInput");
		cdp.addConditionAndVerifyCollapsedView(1, 1, valueInput);
		int hamburgerCount = cdp.getCollapsedViewCountOfConditionBlock();
		cdp.clickAndVerifyConditionEllipsesIcon(hamburgerCount - 1);
		cdp.clickOnEditConditionIcon();
		cdp.verifyDisablingOnCreateEditConditionAction();
		cdp.clickOk();
		cdp.clickOnPerformActionIcon(0);
		cdp.verifyDisablingOnCreateEditConditionAction();
		cdp.performActionAsExit(0, 0);
		cdp.clickClose();
		cdp.clickYes();
		log.info("Verify Disabling of all other elements On Create/Edit Condition/Action block - End");
		log.info("----------------------------------------XXX-----------------------------------------");
	}

	/**
	 * Verify presence of only Active Process definitions on Create/Edit process
	 * page
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 */
	@Test(priority = 33)
	public void VerifyActiveDefinitionsOnCreateEditProcessPage()
			throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify presence of only Active Process definitions on Create/Edit process page- Begin");
		np.navigateToHomeAndClickOnProcessesTab();
		np.definitionsSubTab();
		String draftDefinitionName = createDefinitionPageProp.getProperty("nameForDraftProcessDefinition");
		String activeDefinitionName = createDefinitionPageProp.getProperty("nameForActiveProcessDefinition");
		dp.clickCreateNewDefinitionButton();
		wait(2);

		cdp.enterDefinitionName(draftDefinitionName);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		cdp.clickSave();
		cdp.verifyToasterMsgAfterSaveDraft();
		cdp.clickClose();
		dp.clickCreateNewDefinitionButton();
		wait(2);
		cdp.enterDefinitionName(activeDefinitionName);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		cdp.clickPublishButton();
		dp.verifyToasterMsgOnPublish();

		np.processesTab();
		np.overviewSubTab();
		op.clickCreateNewProcessButton();
		String pname = createProcessPageProp.getProperty("nameWithActiveDefinitionProcessCreation");
		String description = createProcessPageProp.getProperty("descriptionProcessWithNameAndDescription");
		cp.enterProcessNameAndDescription(pname, description);
		Assert.assertTrue(cp.isDefinitionPresentInDropdown(activeDefinitionName),
				"Active Definition should be present in definition dropdown");
		Assert.assertFalse(cp.isDefinitionPresentInDropdown(draftDefinitionName),
				"Draft Definition should not be present in definition dropdown");
		cp.selectOptionFromDefinitionDown(activeDefinitionName);
		cp.clickSave();

		op.editProcess(pname);
		Assert.assertTrue(cp.isDefinitionPresentInDropdown(activeDefinitionName),
				"Active Definition should be present in definition dropdown");
		Assert.assertFalse(cp.isDefinitionPresentInDropdown(draftDefinitionName),
				"Draft Definition should not be present in definition dropdown");
		cp.clickSave();
		op.deleteProcess(pname);
		np.definitionsSubTab();
		dp.deleteDefinition(draftDefinitionName);
		dp.deleteDefinition(activeDefinitionName);
		log.info("Verify presence of only Active Process definitions on Create/Edit process page- End");
		log.info("------------------------------------XXX---------------------------------------------");
	}

	/**
	 * Verify Menu items when clicked on vertical ellipse for action block
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 */
	@Test(priority = 34)
	public void verifyMenuItemsWhenClickedOnEllipsesForAction() throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify Menu items when clicked on vertical ellipse for action block- Begin");
		np.navigateToHomeAndClickOnProcessesTab();
		np.definitionsSubTab();
		String definitionName = createDefinitionPageProp.getProperty("nameForMenuItemVerificationForAction");
		dp.clickCreateNewDefinitionButton();
		wait(2);
		cdp.enterDefinitionName(definitionName);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		cdp.clickPerformAction();
		cdp.performActionAsExit(0, 0);
		int hamburgerCount = cdp.getCollapsedViewCountOfActionBlock();
		cdp.clickAndVerifyHambugerActionBlock(hamburgerCount - 1);
		cdp.verifyPerformActionMenu();
		wait(2);
		cdp.clickClose();
		cdp.clickYes();
		log.info("Verify Menu items when clicked on vertical ellipse for action block- End");
		log.info("--------------------------------------XXX-------------------------------------------");
	}

	/**
	 * Verify Auto Scroll to Active box For Container
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 */
	@Test(priority = 35)
	public void verifyAutoScrolltoActivebox() throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify Auto Scroll to Active box  - Begin");
		np.navigateToHomeAndClickOnProcessesTab();
		np.definitionsSubTab();
		String definitionName = createDefinitionPageProp.getProperty("nameForAutoScrolltoActivebox");
		dp.clickCreateNewDefinitionButton();
		wait(2);
		cdp.enterDefinitionName(definitionName);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		String valueInput = createDefinitionPageProp.getProperty("valueInput");
		cdp.clickAddNewRule(0);
		cdp.addConditionAndVerifyCollapsedView(1, 1, valueInput);
		createConditionalBlock(valueInput, 9);
		cdp.clickOnOrButton(0);
		cdp.verifyAutoScrolltoActiveboxForCondition();
		cdp.clickCancel();
		cdp.clickOnPerformActionIcon(0);
		cdp.verifyAutoScrolltoActiveboxForAction();
		cdp.performActionAsExit(0, 0);
		cdp.clickAndVerifyHambugerActionBlock(0);
		cdp.clickOnaddLeftConditionIconFromPerformActionMenu();
		cdp.verifyAutoScrolltoActiveboxForCondition();
		cdp.clickCancel();
		cdp.clickAndVerifyConditionEllipsesIcon(0);
		cdp.clickAddLeftOnCondition();
		wait(2);
		cdp.verifyAutoScrolltoActiveboxForCondition();
		cdp.selectOptionFromDropdown(1, 6, valueInput);
		cdp.clickOk();
		int hamburgerCount1 = cdp.getCollapsedViewCountOfConditionBlock();
		cdp.clickAndVerifyConditionEllipsesIcon(hamburgerCount1 - 1);
		cdp.clickAddRightOnCondition();
		wait(2);
		cdp.verifyAutoScrolltoActiveboxForCondition();
		cdp.clickCancel();
		cdp.clickClose();
		cdp.clickYes();
		log.info("Verify Auto Scroll to Active box - End");
		log.info("-------------------------------------XXX--------------------------------------------");
	}

	/**
	 * Verify Active Rule Highlight On Left Panel 
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 */
	@Test(priority = 36)
	public void verifyActiveRuleHighlightOnLeftPanel() throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify Rule Highlight On Left Panel  - Begin");
		np.navigateToHomeAndClickOnProcessesTab();
		np.definitionsSubTab();
		String definitionName = createDefinitionPageProp.getProperty("nametoVerifyRuleHighlightOnLeftPanel");
		dp.clickCreateNewDefinitionButton();
		wait(2);
		cdp.enterDefinitionName(definitionName);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		String valueInput = createDefinitionPageProp.getProperty("valueInput");
		cdp.clickAddNewRule(0);
		cdp.addConditionAndVerifyCollapsedView(2, 5, valueInput);
		cdp.clickAddActivity();
		cdp.clickAddNewRule(1);
		cdp.addConditionAndVerifyCollapsedView(1, 1, valueInput);
		for(int i=1;i<=5;i++){
		cdp.clickOnDuplicateRule(1);}
		cdp.clickRuleOverlay(4);
		cdp.moveToSidePanel();
		Assert.assertTrue(compareTextContains(cdp.getActiveRuleOnLeftPanel(),cdp.getRightPanelRuleText(5)));
		cdp.clickOnLeftPanelrule(2);
		wait(3);
		cdp.clickOnRightPanelrule(2);
		cdp.clickClose();
		cdp.clickYes();
		log.info("Verify Active Rule Highlight On Left Panel - End");
		log.info("---------------------------------------XXX------------------------------------------");
	}
	
	/**
	 * creates multiple Conditional Blocks
	 */
	public void createConditionalBlock(String valueInput, int conditionblockCount)
			throws InterruptedException, IOException, AWTException {
		for (int i = 0; i < conditionblockCount; i++) {
			cdp.clickOnOrButton(0);
			cdp.selectOptionFromDropdown(1, 1, valueInput);
			cdp.clickOk();
		}
	}

	/**
	 * add Action After Condition depending upon parameter value
	 * 
	 * @throws AWTException
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void addActionAfterCondition(int fieldInput, int operatorInput, String valueInput, String action,
			int actionindex) throws IOException, InterruptedException, AWTException {
		cdp.addConditionAndVerifyCollapsedView(fieldInput, operatorInput, valueInput);
		cdp.clickOnPerformActionIcon(actionindex);
		if (action.equals("Abort")) {
			cdp.performActionAsAbort(actionindex, 1);
		} else if (action.equals("Exit")) {
			cdp.performActionAsExit(actionindex, 0);
		} else if (action.equals("Process")) {
			cdp.performActionAsProcess(actionindex);
		} else if (action.equals("Perform")) {
			cdp.performActionAsPerform(actionindex);
		} else if (action.equals("Run")) {
			cdp.performActionAsRun(actionindex);
		}
		cdp.clickSave();
		cdp.verifyPerformActionConnector(actionindex);
		cdp.verifyPerformActionGetAddedBlueBoltIndicator(actionindex);
	}

}