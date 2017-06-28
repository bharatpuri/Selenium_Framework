package com.autoiq.tests.definitions;

import java.awt.AWTException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
public class TestEditDefinition extends TestBase {
	ProcessOverview op;
	SchedulesOverview sp;
	DefinitionOverview dp;
	CreateDefinition cdp;
	NavigationBar np;
	CreateProcess cp;
	public List<String> expectedRuleNameListOnLeftPanel;
	public List<String> expectedActivityNameList;

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
	 * verify existing activities on Edit definition page
	 * 
	 * @throws AWTException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Test(priority = 1)
	public void verifyExistingActivities() throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("verify Existing activities on Edit Definition  - Begin");
		np.navigateToHomeAndClickOnProcessesTab();
		np.definitionsSubTab();
		String definitionName = definitionPageProp.getProperty("definitionNameForExistingActivityVerification");
		String definitionDescription = definitionPageProp
				.getProperty("definitiondescriptionForExistingValueVerification");
		dp.clickCreateNewDefinitionButton();
		wait(2);
		cdp.enterDefinitionNameAndDescription(definitionName, definitionDescription);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		int activityCount = Integer.parseInt(createDefinitionPageProp.getProperty("activityCount"));
		cdp.addActivities(activityCount);
		cdp.clickSave();
		cdp.verifyToasterMsgAfterSaveDraft();
		cdp.clickClose();
		dp.editDefinition(definitionName);
		Assert.assertEquals(cdp.getDefinitionNameText(), definitionName, "Definition name does not match");
		Assert.assertEquals(cdp.getDefinitionDescriptionText(), definitionDescription,
				"Definition description does not match");
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		Assert.assertEquals(cdp.getTotalActivityCount(), activityCount + 2, "Activity count doesnot match on right window");
		Assert.assertEquals(cdp.getTotalActivityCountOnLeftPanel(), activityCount + 2,"Activity count doesnot match on Left panel");
		cdp.clickAddActivity();
		cdp.clickSave();
		cdp.verifyUpdatedToasterMsgAfterSaveDraft();
		cdp.clickClose();
		dp.editDefinition(definitionName);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		int newActivityCount=activityCount+1;
		Assert.assertEquals(cdp.getTotalActivityCount(), newActivityCount + 2,"Activity count doesnot match on right window");
		Assert.assertEquals(cdp.getTotalActivityCountOnLeftPanel(), newActivityCount + 2,"Activity count doesnot match on Left Panel");
		cdp.clickSave();
		cdp.verifyUpdatedToasterMsgAfterSaveDraft();
		cdp.clickClose();
		dp.deleteDefinition(definitionName);
		log.info("verify Existing activities on Edit Definition  - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}
	
	/**
	 * verify existing Actions And Rule Count on edit definition page
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 */
	@Test(priority = 2)
	public void verifyExistingActionsAndRuleCount() throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("verification Add Perform Action And Rule Count - Begin");
		np.navigateToHomeAndClickOnProcessesTab();
		np.definitionsSubTab();
		String definitionName = definitionPageProp.getProperty("definitionNameForExistingActionsAndRuleCount");
		String definitionDescription = definitionPageProp
				.getProperty("definitiondescriptionForExistingValueVerification");
		dp.clickCreateNewDefinitionButton();
		wait(2);
		cdp.enterDefinitionNameAndDescription(definitionName, definitionDescription);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		cdp.clickAddActivity();
		int actCount = cdp.getTotalActivityCount();
		log.info(actCount);
		
		cdp.clickPerformActionWithRespectToIndex(actCount - 2);
		int expectedRuleCount = cdp.getActionDropDownListCount();
		String exitAction = createDefinitionPageProp.getProperty("actionExit");
		String exitReason = createDefinitionPageProp.getProperty("reason");
		cdp.addExitAction(exitAction, exitReason);
		
		cdp.clickPerformActionWithRespectToIndex(actCount - 2);
		String abortAction = createDefinitionPageProp.getProperty("actionAbort");
		String abortReason = createDefinitionPageProp.getProperty("reason");
		cdp.addAbortAction(abortAction, abortReason);
		
		cdp.clickPerformActionWithRespectToIndex(actCount - 2);
		String processAction = createDefinitionPageProp.getProperty("actionProcess");
		cdp.selectOptionFromActionDropDown(processAction);
		cdp.selectOptionFromActivityByIndex(1);
		String activityValueSelectedForProcess = (cdp.getSelectedValueFromActivityDropDown()).trim();
		cdp.clickOk();

		cdp.clickPerformActionWithRespectToIndex(actCount - 2);
		String performAction = createDefinitionPageProp.getProperty("actionPerform");
		cdp.selectOptionFromActionDropDown(performAction);
		cdp.selectOptionFromActivityByIndex(1);
		String activityValueSelectedForPerform = (cdp.getSelectedValueFromActivityDropDown()).trim();
		cdp.clickOk();
		
		cdp.clickSave();
		cdp.verifyToasterMsgAfterSaveDraft();
		cdp.clickClose();
		dp.editDefinition(definitionName);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		
		verifyExistingAction(exitAction, abortAction, processAction, performAction, exitReason, abortReason, activityValueSelectedForProcess, activityValueSelectedForPerform);
		Assert.assertEquals(cdp.getCollapsedViewCountOfActionBlock(),expectedRuleCount-1 );
		Assert.assertEquals(cdp.getTotalRuleCount(), expectedRuleCount-1);
		Assert.assertEquals(cdp.getTotalRuleCountOnLeftPanel(), expectedRuleCount-1);
		
		cdp.clickPerformActionWithRespectToIndex(actCount - 2);
		String runAction = createDefinitionPageProp.getProperty("actionRun");
		String onSuccessExit = createDefinitionPageProp.getProperty("onSuccessExit");
		String onFailureExit = createDefinitionPageProp.getProperty("onFailureExit");
		cdp.selectOptionFromActionDropDown(runAction);
		cdp.selectOptionFromTaskByIndex(1);
		String taskValueSelected = (cdp.getSelectedValueFromTaskDropDown()).trim();
		cdp.selectOptionFromSuccessDropDown(onSuccessExit);
		cdp.selectOptionFromFailureDropDown(onFailureExit);
		cdp.clickOk();
		
		cdp.clickSave();
		cdp.verifyUpdatedToasterMsgAfterSaveDraft();
		cdp.clickClose();
		dp.editDefinition(definitionName);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		verifyExistingAction(exitAction, abortAction, processAction, performAction, exitReason, abortReason, activityValueSelectedForProcess, activityValueSelectedForPerform);
		Assert.assertTrue(compareTextContains(cdp.getActionTextByIndex(4), runAction));
		Assert.assertTrue(compareTextContains(cdp.getActionTextByIndex(4), taskValueSelected));
		Assert.assertTrue(compareTextContains(cdp.getOnSuccessTextOnCollaspedView(), onSuccessExit));
		Assert.assertTrue(compareTextContains(cdp.getOnFailureTextOnCollaspedView(), onFailureExit));
		
		Assert.assertEquals(cdp.getCollapsedViewCountOfActionBlock(),expectedRuleCount);
		Assert.assertEquals(cdp.getTotalRuleCount(), expectedRuleCount);
		Assert.assertEquals(cdp.getTotalRuleCountOnLeftPanel(), expectedRuleCount);
		cdp.clickSave();
		cdp.verifyUpdatedToasterMsgAfterSaveDraft();
		cdp.clickClose();
		dp.deleteDefinition(definitionName);
		log.info("verification Add Perform Action And Rule Count  - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}
	
	/**
	 * Verify Existing Condition Values and connector types on Edit Definition page
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 */
	@Test(priority = 3)
	public void verifyExistingConditionAndConnectorType() throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify Existing Condition Values and connector types on Edit Definition page- Begin");
		np.navigateToHomeAndClickOnProcessesTab();
		np.definitionsSubTab();
		String definitionName = definitionPageProp.getProperty("definitionNameForExistingConditionVerification");
		String definitionDescription = definitionPageProp.getProperty("definitiondescriptionForExistingValueVerification");
		dp.clickCreateNewDefinitionButton();
		wait(2);
		cdp.enterDefinitionNameAndDescription(definitionName,definitionDescription);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		cdp.clickAddNewRule(0);
		
		String valueInput = createDefinitionPageProp.getProperty("valueInput");
		cdp.selectOptionFromDropdown(1, 1, valueInput);
		String fieldValue = cdp.getSelectedValueFromFieldDropDown();
		String operatorValue = cdp.getSelectedValueFromOperatorDropDown().trim();
		String value = cdp.getValueFieldText();
		cdp.clickOk();
		cdp.verifyCollapsedView(fieldValue, operatorValue, value,0);
		cdp.clickOnAndButton(0);
		
		cdp.selectOptionFromDropdown(2, 6, valueInput);
		String fieldValue1 = cdp.getSelectedValueFromFieldDropDown();
		String operatorValue1 = cdp.getSelectedValueFromOperatorDropDown().trim();
		String value1 = cdp.getValueFieldText();
		cdp.clickOk();
		cdp.verifyCollapsedView(fieldValue1, operatorValue1, value1,1);
		cdp.clickAndConnector(0);
		cdp.clickDownConnector();
		cdp.clickSave();
		cdp.verifyToasterMsgAfterSaveDraft();
		cdp.clickClose();
		
		dp.editDefinition(definitionName);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		cdp.verifyOrConnector(0);
		Assert.assertEquals(cdp.getCollapsedViewCountOfConditionBlock(), 2);
		cdp.verifyCollapsedView(fieldValue, operatorValue, value,0);
		cdp.verifyCollapsedView(fieldValue1, operatorValue1, value1,1);
		cdp.clickRuleOverlay(0);
		cdp.clickOnOrButton(0);
		cdp.selectOptionFromDropdown(1, 1, valueInput);
		String fieldValue2 = cdp.getSelectedValueFromFieldDropDown();
		String operatorValue2 = cdp.getSelectedValueFromOperatorDropDown().trim();
		String value2 = cdp.getValueFieldText();
		cdp.clickOk();
		cdp.verifyCollapsedView(fieldValue2, operatorValue2, value2,2);
		cdp.clickOrConnector(0);
		cdp.clickUpConnector();
		cdp.clickSave();
		cdp.verifyUpdatedToasterMsgAfterSaveDraft();
		cdp.clickClose();
		
		dp.editDefinition(definitionName);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		
		cdp.verifyAndConnector(0);
		Assert.assertEquals(cdp.getCollapsedViewCountOfConditionBlock(), 3);
		cdp.verifyCollapsedView(fieldValue, operatorValue, value,0);
		cdp.verifyCollapsedView(fieldValue1, operatorValue1, value1,1);
		cdp.verifyCollapsedView(fieldValue2, operatorValue2, value2,2);
		cdp.clickSave();
		cdp.verifyUpdatedToasterMsgAfterSaveDraft();
		cdp.clickClose();
		dp.deleteDefinition(definitionName);
		
		log.info("Verify Existing Condition Values and  connector types on Edit Definition page  - End");
		log.info("---------------------------------------XXX------------------------------------------");
}
	
	
	/**
	  * Verify Edit definition if container is added to condition block
	  * 
	  * @throws InterruptedException
	  * @throws IOException
	  * @throws AWTException
	  */
	 @Test(priority = 4)
	 public void verifyEditDefinitionWithContainer() throws InterruptedException, IOException, AWTException {
	  log.info("---------------------------------------------------------------------------------");
	  log.info("Verify Edit definition if container is added to condition block - Begin");
	  np.navigateToHomeAndClickOnProcessesTab();
	  np.definitionsSubTab();
	  String definitionName = createDefinitionPageProp.getProperty("definitionNameWithContainerOnEdit");
	  String definitionDescription = createDefinitionPageProp.getProperty("descriptionWithContainerOnEdit");
	  dp.clickCreateNewDefinitionButton();
	  wait(2);
	  cdp.enterDefinitionNameAndDescription(definitionName,definitionDescription);
	  cdp.clickNextButtonAndWaitTillPage2IsOpened();
	  cdp.clickAddNewRule(0);
	  
	  String valueInput = createDefinitionPageProp.getProperty("valueInput");
	  cdp.selectOptionFromDropdown(1, 1, valueInput);
	  String fieldValue = cdp.getSelectedValueFromFieldDropDown();
	  String operatorValue = cdp.getSelectedValueFromOperatorDropDown().trim();
	  String value = cdp.getValueFieldText();
	  cdp.clickOk();
	  cdp.verifyCollapsedView(fieldValue, operatorValue, value,0);
	  
	  cdp.clickOnAndButton(0);
	  cdp.selectOptionFromDropdown(2, 6, valueInput);
	  String fieldValue1 = cdp.getSelectedValueFromFieldDropDown();
	  String operatorValue1 = cdp.getSelectedValueFromOperatorDropDown().trim();
	  String value1 = cdp.getValueFieldText();
	  cdp.clickOk();
	  cdp.verifyCollapsedView(fieldValue1, operatorValue1, value1,1);
	  
	  int hamburgerListcount=cdp.getCollapsedViewCountOfConditionBlock();
	  cdp.clickOnContainerButton(0);
	  cdp.clickOnContainerCheckbox(0, hamburgerListcount - 1);
	  cdp.clickOnDoneButton(0);
	  Assert.assertTrue(cdp.isContainerAddedForCondition(0), "Container is not added");
	  cdp.clickSave();
	  cdp.clickClose();
	  dp.editDefinition(definitionName);
	  cdp.clickNextButtonAndWaitTillPage2IsOpened();
	  Assert.assertTrue(cdp.isContainerAddedForCondition(0), "Container is not added");
	  cdp.clickRuleOverlay(0);
	  cdp.clickOnContainerEllipse(0);
	  cdp.clickOnUngroupContainerIcon();
	  cdp.clickSave();
	  cdp.verifyToasterMsgSaveDraftForProcessUpdate();
	  cdp.clickClose();
	  dp.editDefinition(definitionName);
	  cdp.clickNextButtonAndWaitTillPage2IsOpened();
	  Assert.assertFalse(cdp.isUngroupContainerIconDisplayed(), "Container is not Removed");
	  cdp.clickClose();
	  dp.deleteDefinition(definitionName);
	  log.info("Verify Edit definition if container is added to condition block - End");
	  log.info("--------------------------------------XXX-------------------------------------------"); 
	 }
	 
	 /**
	  * Verify Existing condition values With Edit Condition 
	  * 
	  * @throws InterruptedException
	  * @throws IOException
	  * @throws AWTException
	  */
	 @Test(priority = 5)
	 public void verifyExistingConditionWithEditCondition() throws InterruptedException, IOException, AWTException {
	  log.info("---------------------------------------------------------------------------------");
	  log.info("Verify Existing condition values With Edit Condition   - Begin");
	  np.navigateToHomeAndClickOnProcessesTab();
	  np.definitionsSubTab();
	  String definitionName = createDefinitionPageProp.getProperty("definitionNameForEditConditionAfterCreation");
	  String definitionDescription = createDefinitionPageProp.getProperty("descriptionEditConditionAfterCreation");
	  dp.clickCreateNewDefinitionButton();
	  wait(2);
	  cdp.enterDefinitionNameAndDescription(definitionName,definitionDescription);
	  cdp.clickNextButtonAndWaitTillPage2IsOpened();
	  cdp.clickAddNewRule(0);
	  
	  String valueInput = createDefinitionPageProp.getProperty("valueInput");
	  cdp.selectOptionFromDropdown(1, 1, valueInput);
	  String fieldValue = cdp.getSelectedValueFromFieldDropDown();
	  String operatorValue = cdp.getSelectedValueFromOperatorDropDown().trim();
	  String value = cdp.getValueFieldText();
	  cdp.clickOk();
	  cdp.verifyCollapsedView(fieldValue, operatorValue, value,0);
	  
	  cdp.clickOnAndButton(0);
	  cdp.selectOptionFromDropdown(2, 6, valueInput);
	  String fieldValue1 = cdp.getSelectedValueFromFieldDropDown();
	  String operatorValue1 = cdp.getSelectedValueFromOperatorDropDown().trim();
	  String value1 = cdp.getValueFieldText();
	  cdp.clickOk();
	  cdp.verifyCollapsedView(fieldValue1, operatorValue1, value1,1);
	  int hamburgerList=cdp.getCollapsedViewCountOfConditionBlock();
	  cdp.clickAndVerifyConditionEllipsesIcon(hamburgerList-1);
	  cdp.clickOnEditConditionIcon();
	  
	  String newvalueInput = createDefinitionPageProp.getProperty("newValueInput");
	  cdp.selectOptionFromDropdown(3, 4, newvalueInput);
	  String fieldValue2 = cdp.getSelectedValueFromFieldDropDown();
	  String operatorValue2 = cdp.getSelectedValueFromOperatorDropDown().trim();
	  String value2 = cdp.getValueFieldText();
	  cdp.clickOk();
	  cdp.verifyCollapsedView(fieldValue2, operatorValue2, value2,1);
	  cdp.clickSave();
	  cdp.clickClose();
	  
	  dp.editDefinition(definitionName);
	  cdp.clickNextButtonAndWaitTillPage2IsOpened();
	  Assert.assertEquals(cdp.getCollapsedViewCountOfConditionBlock(),hamburgerList);
	  cdp.verifyCollapsedView(fieldValue, operatorValue, value,0);
	  cdp.verifyCollapsedView(fieldValue2, operatorValue2, value2,1);
	  cdp.clickRuleOverlay(0);
	  cdp.clickOnOrButton(0);
	  cdp.selectOptionFromDropdown(1, 1, valueInput);
	  cdp.clickOk();
	  cdp.verifyCollapsedView(fieldValue, operatorValue, value,2);
	  int hamburgerListNew=cdp.getCollapsedViewCountOfConditionBlock();
	  cdp.clickAndVerifyConditionEllipsesIcon(hamburgerListNew-1);
	  cdp.clickOnEditConditionIcon();
	  cdp.selectOptionFromDropdown(2, 6, newvalueInput);
	  cdp.clickOk();
	  cdp.clickSave();
	  cdp.clickClose();
	  
	  dp.editDefinition(definitionName);
	  cdp.clickNextButtonAndWaitTillPage2IsOpened();
	  Assert.assertEquals(cdp.getCollapsedViewCountOfConditionBlock(),hamburgerListNew);
	  cdp.verifyCollapsedView(fieldValue, operatorValue, value,0);
	  cdp.verifyCollapsedView(fieldValue2, operatorValue2, value2,1);
	  cdp.verifyCollapsedView(fieldValue1, operatorValue1, newvalueInput,2);
	  cdp.clickSave();
	  cdp.clickClose();
	  dp.deleteDefinition(definitionName);
	  log.info("Verify Existing condition values With Edit Condition   - End");
	  log.info("----------------------------------------XXX-----------------------------------------");
	 }
	 
	 /**
	  * Verify Deleting condition on edit definition
	  * 
	  * @throws InterruptedException
	  * @throws IOException
	  * @throws AWTException
	  */
	 @Test(priority = 6)
	 public void verifyDeletingConditionOnEditDefinition() throws InterruptedException, IOException, AWTException {
	  log.info("---------------------------------------------------------------------------------");
	  log.info("Verify Deleting condition on edit definition - Begin");
	  np.navigateToHomeAndClickOnProcessesTab();
	  np.definitionsSubTab();
	  String definitionName = createDefinitionPageProp.getProperty("definitionNameForDeleteConditionOnEdit");
	  String definitionDescription = createDefinitionPageProp.getProperty("descriptionForDeleteConditionOnEdit");
	  dp.clickCreateNewDefinitionButton();
	  wait(2);
	  cdp.enterDefinitionNameAndDescription(definitionName,definitionDescription);
	  cdp.clickNextButtonAndWaitTillPage2IsOpened();
	  cdp.clickAddNewRule(0);
	  
	  String valueInput = createDefinitionPageProp.getProperty("valueInput");
	  cdp.addConditionAndVerifyCollapsedView(1, 1, valueInput);
	  cdp.clickOnAndButton(0);
	  cdp.addConditionAndVerifyCollapsedView(2, 5, valueInput);
	  cdp.clickOnAndButton(0);
	  cdp.addConditionAndVerifyCollapsedView(2, 6, valueInput);
	  
	  int hamburgerList=cdp.getCollapsedViewCountOfConditionBlock();
	  cdp.clickOnContainerButton(0);
	  cdp.clickOnContainerCheckbox(0, hamburgerList - 1);
	  cdp.clickOnDoneButton(0);
	  cdp.clickAndVerifyConditionEllipsesIcon(hamburgerList-2);
	  cdp.deleteCondition();
	  cdp.clickSave();
	  int hamburgerListNew=cdp.getCollapsedViewCountOfConditionBlock();
	  cdp.clickClose();
	  
	  dp.editDefinition(definitionName);
	  cdp.clickNextButtonAndWaitTillPage2IsOpened();
	  Assert.assertEquals(cdp.getCollapsedViewCountOfConditionBlock(), hamburgerListNew);
	  cdp.clickRuleOverlay(0);
	  cdp.clickOnContainerEllipse(0);
	  cdp.clickOnUngroupContainerIcon();
	  cdp.clickAndVerifyConditionEllipsesIcon(hamburgerListNew-1);
	  cdp.deleteCondition();
	  cdp.clickSave();
	  int hamburgerListcount=cdp.getCollapsedViewCountOfConditionBlock();
	  cdp.clickClose();
	  wait(2);
	  
	  dp.editDefinition(definitionName);
	  cdp.clickNextButtonAndWaitTillPage2IsOpened();
	  Assert.assertEquals(cdp.getCollapsedViewCountOfConditionBlock(),hamburgerListcount);
	  cdp.clickClose();
	  dp.deleteDefinition(definitionName);
	  log.info("Verify Deleting condition on edit definition - End");
	  log.info("-------------------------------------XXX--------------------------------------------");
	 }
	 
	/**
	 * verify Edit Definition for Definition with Process Associated
	 * 
	 * @throws AWTException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Test(priority = 7)
	public void verifyEditDefinitionProcessAssociated() throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify Edit Definition for Definition with Process Assigned  - Begin");
		String definitionName = createDefinitionPageProp.getProperty("definitionNameForEditVerification");
		String definitionDescription = createDefinitionPageProp.getProperty("definitiondescriptionForEditVerification");
		String processName = createProcessPageProp.getProperty("processNameToVerifyEditDefinition");
		createDefinitionWithNameAndDescription(definitionName, definitionDescription);
		selectDefinitionInProcess(definitionName, processName);
		String editeddefinitionName = createDefinitionPageProp.getProperty("editedDefinitionNameForEditVerification");
		String editeddefinitionDescription = createDefinitionPageProp
				.getProperty("editedDefinitiondescriptionForEditVerification");
		editDefinitionWithNameAndDescription(definitionName, editeddefinitionName, editeddefinitionDescription);
		np.navigateToHomeAndClickOnProcessesTab();
		np.overviewSubTab();
		String actualDefinitionName = op.getDefinitionName(op.getProcessIndex(processName) - 1);
		Assert.assertEquals(actualDefinitionName, editeddefinitionName);
		op.clickCreateNewProcessButton();
		Assert.assertTrue(cp.isDefinitionPresentInDropdown(editeddefinitionName),
				"Active Definition should be present in definition dropdown");
		cp.clickCancelButton();
		op.editProcess(processName);
		Assert.assertEquals(cp.getSelectedValueFromDefinitionDropDown().trim(), editeddefinitionName,
				"Active Definition should be present in definition dropdown");
		cp.clickCancelButton();
		op.deleteProcess(processName);
		np.navigateToHomePage();
		np.processesTab();
		np.definitionsSubTab();
		dp.deleteDefinition(editeddefinitionName);
		log.info("verify Edit Definition for Definition with Process Assigned  - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}
	
	/**
	 * verify Edit Definition for delete rules
	 * 
	 * @throws AWTException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Test(priority = 8)
	public void verifyDeleteRules() throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify Delete rules  - Begin");
		np.navigateToHomeAndClickOnProcessesTab();
		np.definitionsSubTab();
		String definitionName = createDefinitionPageProp.getProperty("nameToVerifyDeleteRules");
		dp.clickCreateNewDefinitionButton();
		wait(2);
		cdp.enterDefinitionName(definitionName);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		cdp.clickAddNewRule(0);
		String valueInput = createDefinitionPageProp.getProperty("valueInput");
		cdp.addConditionAndVerifyCollapsedView(1, 1, valueInput);
		cdp.clickAddNewRule(0);
		cdp.addConditionAndVerifyCollapsedView(2, 5, valueInput);
		
		cdp.clickAddActivity();
		cdp.clickAddNewRule(1);
		cdp.addConditionAndVerifyCollapsedView(2, 6, valueInput); 
		cdp.clickPerformActionByIndex(1);
		cdp.performActionAsRun(0);
		
		cdp.clickPerformActionByIndex(2);
		cdp.performActionAsRun(1);
		scrollup();
		cdp.clickRuleOverlay(0);
		cdp.clickOnDeleteRule(0);
		
		System.out.println(cdp.getTotalRuleCount());
		cdp.clickSave();
		Assert.assertEquals(cdp.getTotalRuleCount(), 4);
		Assert.assertEquals(cdp.getTotalRuleCountOnLeftPanel(), 4);
		cdp.clickClose();
		dp.editDefinition(definitionName);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		Assert.assertEquals(cdp.getTotalRuleCount(), 4);
		Assert.assertEquals(cdp.getTotalRuleCountOnLeftPanel(), 4);
		cdp.clickRuleOverlay(1);
		cdp.clickOnDeleteRule(1);
		cdp.clickSave();
		Assert.assertEquals(cdp.getTotalRuleCount(), 3);
		Assert.assertEquals(cdp.getTotalRuleCountOnLeftPanel(), 3);
		cdp.clickClose();
		dp.deleteDefinition(definitionName);
		log.info("Verify Delete rules  - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}
		
	/**
	 * verify overlay on rules
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 */
	@Test(priority = 9)
	public void verifyRuleOverlay() throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("verify overlay on rules - Begin");
		np.navigateToHomeAndClickOnProcessesTab();
		np.definitionsSubTab();
		String definitionName = createDefinitionPageProp.getProperty("nameToVerifyOverlayOnRules");
		dp.clickCreateNewDefinitionButton();
		wait(2);
		cdp.enterDefinitionName(definitionName);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		cdp.clickAddActivity();
		int actCount = cdp.getTotalActivityCount();
		log.info(actCount);

		cdp.clickPerformActionWithRespectToIndex(actCount - 2);
		int expectedRuleCount = cdp.getActionDropDownListCount();
		cdp.performActionAsExit(0,0);

		cdp.clickPerformActionWithRespectToIndex(actCount - 2);
		cdp.performActionAsPerform(1);

		cdp.clickPerformActionWithRespectToIndex(actCount - 2);
		cdp.performActionAsProcess(2);

		cdp.clickPerformActionWithRespectToIndex(actCount - 2);
		cdp.performActionAsRun(3);

		cdp.clickPerformActionWithRespectToIndex(actCount - 2);
		cdp.performActionAsAbort(4,1);
		Assert.assertEquals(cdp.getOverlaySize(), 4,"Overlay not displayed correctly");

		cdp.clickSave();
		cdp.verifyToasterMsgAfterSaveDraft();
		Assert.assertTrue(cdp.isOverlayDisplayed(0),"Overlay should be displayed");
		Assert.assertTrue(cdp.isOverlayDisplayed(1),"Overlay should be displayed");
		Assert.assertTrue(cdp.isOverlayDisplayed(2),"Overlay should be displayed");
		Assert.assertTrue(cdp.isOverlayDisplayed(3),"Overlay should be displayed");
		Assert.assertEquals(cdp.getOverlaySize(), 5,"Overlay not displayed correctly");
		
		scrollup();
		cdp.clickRuleOverlay(0);
		cdp.clickOnDeleteRule(0);
		Assert.assertEquals(cdp.getOverlaySize(), 4,"Overlay is not displayed for all rules");
		
		cdp.clickRuleOverlay(3);
		cdp.clickOnDuplicateRule(3);
		Assert.assertTrue(cdp.isOverlayDisplayed(0),"Overlay should be displayed");
		Assert.assertTrue(cdp.isOverlayDisplayed(1),"Overlay should be displayed");
		Assert.assertTrue(cdp.isOverlayDisplayed(2),"Overlay should be displayed");
		Assert.assertTrue(cdp.isOverlayDisplayed(3),"Overlay should be displayed");
		Assert.assertEquals(cdp.getOverlaySize(), 4,"Overlay not displayed correctly");
		
		cdp.clickSave();
		cdp.clickClose();
		dp.editDefinition(definitionName);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		for(int i=0;i<expectedRuleCount;i++){
			Assert.assertTrue(cdp.isOverlayDisplayed(0),"Overlay is not displayed for rule:"+i);
		}
		
		cdp.clickPerformActionWithRespectToIndex(0);
		cdp.performActionAsExit(0,0);
		cdp.clickSave();
		Assert.assertEquals(cdp.getOverlaySize(), 6,"Overlay is not displayed correctly");
		
		cdp.clickPerformActionWithRespectToIndex(actCount-1);
		cdp.performActionAsRun(6);
		cdp.clickSave();
		Assert.assertEquals(cdp.getOverlaySize(), 7,"Overlay is not displayed correctly");
		cdp.clickRuleOverlay(6);
		cdp.clickOnDeleteRule(6);
		Assert.assertEquals(cdp.getOverlaySize(), 6,"Overlay is not displayed for all rules");
		cdp.clickSave();
		cdp.clickClose();
		
		dp.deleteDefinition(definitionName);
		log.info("verify overlay on rules  - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}
	
	/**
	 * Verify Add Left and Right Condition Block
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 */
	@Test(priority = 10)
	public void verifyAddLeftRightConditionBlock() throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify Edit Condition Block- Begin");
		np.navigateToHomeAndClickOnProcessesTab();
		np.definitionsSubTab();
		String definitionName = createDefinitionPageProp.getProperty("nameToVerifyAddLeftRightConditionBlock");
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
		cdp.performActionAsExit(0,0);
		int hamburgerCount = cdp.getCollapsedViewCountOfConditionBlock();
		cdp.clickAndVerifyConditionEllipsesIcon(hamburgerCount - 1);
		cdp.clickAddLeftOnCondition();
		cdp.selectOptionFromDropdown(1, 6, valueInput);
		cdp.clickOk();
		cdp.clickSave();
		cdp.verifyAndConnector(0);
		cdp.verifyOrConnector(0);
		int hamburgerCount1 = cdp.getCollapsedViewCountOfConditionBlock();
		Assert.assertEquals(hamburgerCount1, hamburgerCount+1);
		cdp.clickClose();
		dp.editDefinition(definitionName);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		cdp.clickRuleOverlay(0);
		cdp.clickAndVerifyConditionEllipsesIcon(hamburgerCount1 - 1);
		cdp.clickAddRightOnCondition();
		cdp.selectOptionFromDropdown(2, 8, valueInput);
		cdp.clickOk();
		cdp.clickSave();
		cdp.verifyAndConnector(1);
		int hamburgerCount2 = cdp.getCollapsedViewCountOfConditionBlock();
		Assert.assertEquals(hamburgerCount2, hamburgerCount1+1);
		cdp.clickRuleOverlay(0);
		cdp.clickOnContainerButton(0);
		cdp.clickOnContainerCheckbox(1, 2);
		cdp.clickOnDoneButton(0);
		cdp.clickAndVerifyConditionEllipsesIcon(2);
		cdp.clickAddRightOnCondition();
		cdp.selectOptionFromDropdown(2, 8, valueInput);
		cdp.clickOk();
		cdp.clickSave();
		cdp.verifyOrConnectorInsideContainer(1);
		cdp.clickClose();
		dp.deleteDefinition(definitionName);
		log.info("Verify Edit Condition Block- End");
		log.info("----------------------------------------XXX-----------------------------------------");
	}
	
	 /**
	   * Verify Add Conditional boxes to left of existing action box
	   * 
	   * @throws InterruptedException
	   * @throws IOException
	   * @throws AWTException
	   */
	@Test(priority = 11)
	public void verifyAddConditionToLeftofAction() throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify Add Conditional boxes to left of existing action box - Begin");
		np.navigateToHomeAndClickOnProcessesTab();
		np.definitionsSubTab();
		String definitionName = createDefinitionPageProp.getProperty("nameToVerifyAddLeftRightConditionBlock");
		dp.clickCreateNewDefinitionButton();
		wait(2);
		cdp.enterDefinitionName(definitionName);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		cdp.clickPerformAction();
		cdp.performActionAsExit(0,0);
		cdp.clickAndVerifyHambugerActionBlock(0);
		cdp.clickOnaddLeftConditionIconFromPerformActionMenu();
		String valueInput = createDefinitionPageProp.getProperty("valueInput");
		cdp.addConditionAndVerifyCollapsedView(1, 1, valueInput);
		cdp.clickSave();
		int conditionBlockCount = cdp.getCollapsedViewCountOfConditionBlock();
		Assert.assertEquals(conditionBlockCount, 1);
		cdp.clickClose();
		dp.editDefinition(definitionName);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		Assert.assertEquals(conditionBlockCount, 1);
		cdp.clickRuleOverlay(0);
		cdp.clickAndVerifyHambugerActionBlock(0);
		cdp.clickOnaddLeftConditionIconFromPerformActionMenu();
		cdp.addConditionAndVerifyCollapsedView(1, 1, valueInput);
		cdp.clickSave();
		cdp.verifyAndConnector(0);
		int conditionBlockCount1 = cdp.getCollapsedViewCountOfConditionBlock();
		Assert.assertEquals(conditionBlockCount1, conditionBlockCount+1);
		cdp.clickClose();
		dp.deleteDefinition(definitionName);
		log.info("Verify Add Conditional boxes to left of existing action box - End");
		log.info("---------------------------------------XXX-----------------------------------------");
	}
	
	/**
	 * Verify drag and drop rule within activity functionality
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 */
	@Test(priority = 12)
	public void verifyMoveRuleWithinActivity() throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify drag and drop rule within activity functionality - Begin");
		np.navigateToHomeAndClickOnProcessesTab();
		np.definitionsSubTab();
		String definitionName = createDefinitionPageProp.getProperty("nameToVerifyMoveRuleWithinActivity");
		dp.clickCreateNewDefinitionButton();
		wait(2);
		
		cdp.enterDefinitionName(definitionName);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		cdp.clickAddActivity();
		cdp.clickAddNewRule(1);
		String valueInput = createDefinitionPageProp.getProperty("valueInput");
		cdp.addConditionAndVerifyCollapsedView(1, 1, valueInput);
		for(int i=1;i<=3;i++){
		cdp.clickOnDuplicateRule(0);}
		cdp.moveToSidePanel();
		cdp.dragAndMoveRule(1, 3);
		expectedRuleNameListOnLeftPanel = new ArrayList<String>();
		expectedRuleNameListOnLeftPanel.addAll(Arrays.asList("Rule 1","Rule 1 - Clone 2","Rule 1 - Clone 1","Rule 1 - Clone 3"));
		cdp.clickSave();
		Assert.assertEquals(cdp.getRuleListOnLeftPanel(), expectedRuleNameListOnLeftPanel);
		Assert.assertEquals(cdp.getRuleListOnLeftPanel(), cdp.getRuleListOnRightPanel());
		cdp.clickClose();
		dp.editDefinition(definitionName);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		cdp.moveToSidePanel();
		Assert.assertEquals(cdp.getRuleListOnLeftPanel(), expectedRuleNameListOnLeftPanel);
		Assert.assertEquals(cdp.getRuleListOnLeftPanel(), cdp.getRuleListOnRightPanel());
		cdp.dragAndMoveRule(2, 3);
		expectedRuleNameListOnLeftPanel.clear();
		expectedRuleNameListOnLeftPanel.addAll(Arrays.asList("Rule 1","Rule 1 - Clone 2","Rule 1 - Clone 3","Rule 1 - Clone 1"));
		cdp.clickSave();
		Assert.assertEquals(cdp.getRuleListOnLeftPanel(), expectedRuleNameListOnLeftPanel);
		Assert.assertEquals(cdp.getRuleListOnLeftPanel(), cdp.getRuleListOnRightPanel());
		cdp.clickClose();
		dp.deleteDefinition(definitionName);
		log.info("Verify drag and drop rule within activity functionality- End");
		log.info("---------------------------------------XXX------------------------------------------");
	}
	
	/**
	 * verify Edit Definition for Duplicate rules
	 * 
	 * @throws AWTException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Test(priority = 13)
	public void verifyDuplicateRules() throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify Duplicate rules  - Begin");
		np.navigateToHomeAndClickOnProcessesTab();
		np.definitionsSubTab();
		String definitionName = createDefinitionPageProp.getProperty("nameToVerifyDuplicateRules");
		dp.clickCreateNewDefinitionButton();
		wait(2);
		cdp.enterDefinitionName(definitionName);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		cdp.clickAddNewRule(0);
		String valueInput = createDefinitionPageProp.getProperty("valueInput");
		cdp.addConditionAndVerifyCollapsedView(1, 1, valueInput);
	
		cdp.clickAddActivity();
		cdp.clickPerformActionByIndex(1);
		cdp.performActionAsRun(0);
		
		scrollup();
		cdp.clickRuleOverlay(0);
		System.out.println(cdp.getTotalRuleCount());
		cdp.clickSave();
		Assert.assertEquals(cdp.getTotalRuleCount(), 2);
		Assert.assertEquals(cdp.getTotalRuleCountOnLeftPanel(), 2);
		cdp.clickClose();
		dp.editDefinition(definitionName);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		Assert.assertEquals(cdp.getTotalRuleCount(), 2);
		Assert.assertEquals(cdp.getTotalRuleCountOnLeftPanel(), 2);
		cdp.clickRuleOverlay(0);
		cdp.clickOnDuplicateRule(0);
		cdp.clickSave();
		cdp.clickClose();
		
		dp.editDefinition(definitionName);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		Assert.assertEquals(cdp.getTotalRuleCount(), 3);
		Assert.assertEquals(cdp.getTotalRuleCountOnLeftPanel(), 3);
		cdp.clickRuleOverlay(2);
		cdp.clickOnDuplicateRule(2);
		cdp.clickSave();
		cdp.clickClose();
		dp.editDefinition(definitionName);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		Assert.assertEquals(cdp.getTotalRuleCount(), 4);
		Assert.assertEquals(cdp.getTotalRuleCountOnLeftPanel(), 4);
		cdp.clickClose();
		dp.deleteDefinition(definitionName);
		log.info("Verify Duplicate rules  - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}
	
	/**
	 * Verify drag and drop rule across activity
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 */
	@Test(priority = 14)
	public void verifyMoveRuleAcrossActivity() throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify drag and drop rule across activity functionality - Begin");
		np.navigateToHomeAndClickOnProcessesTab();
		np.definitionsSubTab();
		String definitionName = createDefinitionPageProp.getProperty("nameToVerifyMoveRuleAcrossActivity");
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
		for(int i=1;i<=3;i++){
		cdp.clickOnDuplicateRule(1);}
		cdp.moveToSidePanel();
		cdp.dragAndMoveRule(1, 0);
		expectedRuleNameListOnLeftPanel = new ArrayList<String>();
		expectedRuleNameListOnLeftPanel.addAll(Arrays.asList("Rule 1","Rule 2","Rule 1 - Clone 3","Rule 1 - Clone 2","Rule 1 - Clone 1"));
		cdp.clickSave();
		Assert.assertEquals(cdp.getRuleListOnLeftPanel(), expectedRuleNameListOnLeftPanel);
		Assert.assertEquals(cdp.getRuleListOnLeftPanel(), cdp.getRuleListOnRightPanel());
		cdp.clickClose();
		dp.editDefinition(definitionName);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		cdp.moveToSidePanel();
		Assert.assertEquals(cdp.getRuleListOnLeftPanel(), expectedRuleNameListOnLeftPanel);
		Assert.assertEquals(cdp.getRuleListOnLeftPanel(), cdp.getRuleListOnRightPanel());
		cdp.dragAndMoveRule(4, 1);
		expectedRuleNameListOnLeftPanel.clear();
		expectedRuleNameListOnLeftPanel.addAll(Arrays.asList("Rule 1","Rule 2","Rule 1 - Clone 1","Rule 1 - Clone 3","Rule 1 - Clone 2"));
		cdp.clickSave();
		Assert.assertEquals(cdp.getRuleListOnLeftPanel(), expectedRuleNameListOnLeftPanel);
		Assert.assertEquals(cdp.getRuleListOnLeftPanel(), cdp.getRuleListOnRightPanel());
		cdp.clickClose();
		dp.deleteDefinition(definitionName);
		log.info("Verify drag and drop rule across activity functionality- End");
		log.info("---------------------------------------XXX------------------------------------------");
	}
	
	 /**
	  * verify Rename activity
	  * 
	  * @throws AWTException
	  * @throws IOException
	  * @throws InterruptedException
	  */
	 @Test(priority = 15)
	 public void verifyRenameActivity() throws InterruptedException, IOException, AWTException {
	  log.info("---------------------------------------------------------------------------------");
	  log.info("Verify Rename activity  - Begin");
	  np.navigateToHomePage();
	  np.processesTab();
	  np.definitionsSubTab();
	  String definitionName = createDefinitionPageProp.getProperty("nameForRenameActivity");
	  String activityName = createDefinitionPageProp.getProperty("activityName");
	  String newActivityName = createDefinitionPageProp.getProperty("newActivityName");
	  dp.clickCreateNewDefinitionButton();
	  wait(2);
	  
	  cdp.enterDefinitionName(definitionName);
	  cdp.clickNextButtonAndWaitTillPage2IsOpened();
	  cdp.clickAddActivity();
	  int count=cdp.getActivityIndex();
	  cdp.verifyAndRenameActivity(0,activityName);
	  cdp.verifyActivityName(activityName,count-2);
	  cdp.clickClose();
	  dp.editDefinition(definitionName);
	  cdp.clickNextButtonAndWaitTillPage2IsOpened();
	  cdp.verifyActivityName(activityName,count-2);
	  cdp.clickAddActivity();
	  int activityCount=cdp.getActivityIndex();
	  cdp.verifyAndRenameActivity(1,newActivityName);
	  cdp.verifyActivityName(newActivityName,activityCount-2);
	  cdp.clickClose();
	  
	  dp.editDefinition(definitionName);
	  cdp.clickNextButtonAndWaitTillPage2IsOpened();
	  cdp.verifyActivityName(activityName,activityCount-3);
	  cdp.verifyActivityName(newActivityName,activityCount-2);
	  cdp.clickClose();
	  dp.deleteDefinition(definitionName);
	  log.info("Verify Rename activity  - End");
	  log.info("---------------------------------------------------------------------------------");
	 }
	
	 /**
	  * verify Rename Rule
	  * 
	  * @throws AWTException
	  * @throws IOException
	  * @throws InterruptedException
	  */
	 @Test(priority = 16)
	 public void verifyRenameRule() throws InterruptedException, IOException, AWTException {
	  log.info("---------------------------------------------------------------------------------");
	  log.info("Verify Rename Rule  - Begin");
	  np.navigateToHomePage();
	  np.processesTab();
	  np.definitionsSubTab();
	  String definitionName = createDefinitionPageProp.getProperty("nameForRenameRule");
	  String ruleName = createDefinitionPageProp.getProperty("ruleName");
	  String ruleNameForDuplicateRule = createDefinitionPageProp.getProperty("ruleNameForFinal");
	  dp.clickCreateNewDefinitionButton();
	  wait(2);
	  cdp.enterDefinitionName(definitionName);
	  cdp.clickNextButtonAndWaitTillPage2IsOpened();
	  
	  cdp.clickAddNewRule(0);
	  String valueInput = createDefinitionPageProp.getProperty("valueInput");
	  cdp.addConditionAndVerifyCollapsedView(1, 1, valueInput);
	  cdp.verifyAndRenameRule(ruleName);
	  cdp.clickAddActivity();
	  cdp.clickAddNewRule(1);
	  cdp.addConditionAndVerifyCollapsedView(6, 4, valueInput);
	  cdp.verifyAndRenameRule(ruleName);
	  cdp.clickAddNewRule(2);
	  cdp.addConditionAndVerifyCollapsedView(2, 5, valueInput);
	  cdp.verifyAndRenameRule(ruleName);
	  verifyRuleNameAfterSave(ruleName,2);
	  cdp.clickClose();
	  
	  dp.editDefinition(definitionName);
	  cdp.clickNextButtonAndWaitTillPage2IsOpened();
	  verifyRuleNameAfterSave(ruleName,2);
	  cdp.clickRuleOverlay(2);
	  cdp.clickOnDuplicateRule(2);
	  cdp.clickRuleOverlay(2);
	  cdp.verifyAndRenameRule(ruleNameForDuplicateRule);
	  cdp.verifyRuleName(ruleNameForDuplicateRule,3);
	  cdp.clickClose();
	  dp.deleteDefinition(definitionName);
	  log.info("Verify Rename Rule  - End");
	  log.info("---------------------------------------------------------------------------------");
	 }
	 
	 /**
	   * verify delete activity
	   * 
	   * @throws AWTException
	   * @throws IOException
	   * @throws InterruptedException
	   */
	  @Test(priority = 17)
	  public void verifyDeleteActivity() throws InterruptedException, IOException, AWTException {
	   log.info("---------------------------------------------------------------------------------");
	   log.info("Verify Delete Activity - Begin");
	   np.navigateToHomeAndClickOnProcessesTab();
	   np.definitionsSubTab();
	   String definitionName = createDefinitionPageProp.getProperty("nameForDeleteActivity");
	   dp.clickCreateNewDefinitionButton();
	   wait(2);
	   cdp.enterDefinitionName(definitionName);
	   cdp.clickNextButtonAndWaitTillPage2IsOpened();
	   int activityCount = Integer.parseInt(createDefinitionPageProp.getProperty("activityCount"));
	   cdp.addActivities(activityCount);
	   cdp.clickSave();
	   Assert.assertEquals(cdp.getTotalActivityCount(), activityCount + 2, "Activity count does not match ");
	   cdp.verifyAndClickOnDeleteActivity(3);  
	   cdp.clickSave();
	   cdp.verifyUpdatedToasterMsgAfterSaveDraft();
	   cdp.clickClose();
	   
	   dp.editDefinition(definitionName);
	   cdp.clickNextButtonAndWaitTillPage2IsOpened();
	   Assert.assertEquals(cdp.getTotalActivityCount(), activityCount + 1 , "Activity count does not match ");
	   cdp.verifyAndClickOnDeleteActivity(2);  
	   cdp.clickSave();
	   cdp.verifyUpdatedToasterMsgAfterSaveDraft(); 
	   cdp.clickClose();
	   
	   dp.editDefinition(definitionName);
	   cdp.clickNextButtonAndWaitTillPage2IsOpened();
	   Assert.assertEquals(cdp.getTotalActivityCount(), activityCount , "Activity count does not match ");
	   expectedActivityNameList = new ArrayList<String>();
	   expectedActivityNameList.addAll(Arrays.asList("Start Activity","Activity 1","Activity 2","Activity 3","Final Activity"));
	   Assert.assertEquals(cdp.getListOfActivityName(), expectedActivityNameList , "Activity Names does not match ");
	   cdp.clickClose();
	   dp.deleteDefinition(definitionName);
	   log.info("Verify Delete Activity  - End");
	   log.info("---------------------------------------------------------------------------------");
	  }
	 
	/**
	 * verifies Rule Name After Save
	 */
	public void verifyRuleNameAfterSave(String ruleName, int index) throws InterruptedException {
		for (int i = 0; i <= index; i++) {
			cdp.verifyRuleName(ruleName, index);
		}
	}
		  
	/**
	 * verifies Existing Action blocks
	 * 
	 * @throws AWTException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void verifyExistingAction(String exitAction, String abortAction, String processAction, String performAction,
			String exitReason, String abortReason, String activityValueSelectedForProcess, String activityValueSelectedForPerform)
					throws InterruptedException {
		Assert.assertTrue(compareTextContains(cdp.getActionTextByIndex(0), exitAction));
		Assert.assertTrue(compareTextContains(cdp.getReasonTextOnCollapsedView(0), exitReason));

		Assert.assertTrue(compareTextContains(cdp.getActionTextByIndex(1), abortAction));
		Assert.assertTrue(compareTextContains(cdp.getReasonTextOnCollapsedView(1), abortReason));

		Assert.assertTrue(compareTextContains(cdp.getActionTextByIndex(2), processAction));
		Assert.assertTrue(compareTextContains(cdp.getActionTextByIndex(2), activityValueSelectedForProcess));

		Assert.assertTrue(compareTextContains(cdp.getActionTextByIndex(3), performAction));
		Assert.assertTrue(compareTextContains(cdp.getActionTextByIndex(3), activityValueSelectedForPerform));
	}
	
	/**
	 * Select In Process
	 * 
	 * @throws AWTException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void selectDefinitionInProcess(String definitionName, String processName)
			throws IOException, InterruptedException, AWTException {
		np.processesTab();
		op.clickCreateNewProcessButton();
		cp.setProcessName(processName);
		cp.selectOptionFromDefinitionDown(definitionName);
		wait(2);
		cp.clickSave();
		cp.verifyCreateProcessSuccessToasterMsg();
	}
	
	/**
	 * create Definition with name and description
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	public void createDefinitionWithNameAndDescription(String definitionName,String Description) throws InterruptedException, IOException{
	np.navigateToHomeAndClickOnProcessesTab();
	np.definitionsSubTab();
	dp.clickCreateNewDefinitionButton();
	enterNameDescriptionAndPublish(definitionName, Description);
	dp.verifyToasterMsgOnPublish();
	}
	
	/**
	 * create Definition with name and description
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	public void editDefinitionWithNameAndDescription(String definitionName,String editeddefinitionName, String editedDescription) throws InterruptedException, IOException{
	np.processesTab();
	np.definitionsSubTab();
	dp.editDefinition(definitionName);
	enterNameDescriptionAndPublish(editeddefinitionName, editedDescription);
	dp.verifyToasterMsgOnPublishAfterSave();
	}
	
	/**
	 * enter Name and Description And Publish definition
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	public void enterNameDescriptionAndPublish(String definitionName,String Description) throws InterruptedException{
		cdp.enterDefinitionNameAndDescription(definitionName, Description);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		cdp.clickPublishButton();
	}
	
	
}