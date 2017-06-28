package definitions;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.autoiq.base.AutoiqCommonActions;
import com.autoiq.common.utility.CommonUtility;
import com.autoiq.common.utility.CommonWebFunctions;
import com.autoiq.common.utility.DataStoreInObjects;
import com.autoiq.common.utility.HandleException;

public class Definition {
	final static Logger logger = Logger.getLogger(Definition.class.getName());

	CommonWebFunctions actions = new CommonWebFunctions();
	DataStoreInObjects locators = new DataStoreInObjects();
	DataStoreInObjects testData = new DataStoreInObjects();

	AutoiqCommonActions appActions = new AutoiqCommonActions();

	public Definition() throws HandleException {
		locators = CommonUtility.loadLocators("Page Objects", "DefinitionPage");
		testData = CommonUtility.loadTestData("Test Data", "DefinitionTestData");
	}

	/**
	 * Verification for created Definition name
	 * 
	 * @throws HandleException
	 */
	public void verifyNameForCreatedDefinition(String expectedDefinitionName) throws HandleException {
		logger.info("Verification for created Definition name- Begin! ");
		String actualDefinitionName = actions
				.getElementText(actions.getDynamicXpath(expectedDefinitionName, locators.getValue("definationName")));
		actions.verifyTextWithAssertContains(actualDefinitionName, expectedDefinitionName);
		logger.info("Verification for created Definition name- End! ");
	}

	/**
	 * Verification for created Definition name
	 * 
	 * @throws HandleException
	 */
	public void verifyDescriptionForCreatedDefinition(String expectedDefinitionDescription) throws HandleException {
		logger.info("Verification for created Definition name- Begin! ");
		String actualDefinitionDescription = actions.getElementText(
				actions.getDynamicXpath(expectedDefinitionDescription, locators.getValue("descriptionText")));
		actions.verifyTextWithAssertContains(actualDefinitionDescription, expectedDefinitionDescription);
		logger.info("Verification for created Definition name- End! ");
	}

	/**
	 * This method will click on definition name on web page
	 * 
	 * @param definitionName
	 * @throws HandleException
	 */
	public void selectDefinition(String definitionName) throws HandleException {
		String selectDefinition = actions.getDynamicXpath(definitionName, locators.getValue("selectDefination"));
		appActions.selectElement(selectDefinition);
	}

	/**
	 * This method will delete the definition on web page
	 * 
	 * @param definitionName
	 * @throws HandleException
	 */
	public void deleteDefinition(String definitionName) throws HandleException {
		String deleteDefinition = actions.getDynamicXpath(definitionName, locators.getValue("deleteDifinition"));
		appActions.deleteElement(deleteDefinition);
		actions.clickOnElement(locators.getValue("toasterMsg"));
	}

	/**
	 * verify Toaster Message After Save Draft
	 * 
	 * @throws HandleException
	 * 
	 */
	public void verifyToasterMsgAfterSaveDraft() throws HandleException {
		String successToasterMsg = actions.getElementText(locators.getValue("successToasterMsg"));
		String expectedSuccessValidationMsg = testData.getValue("expectedSuccessValidationMsg");
		actions.verifyTextWithAssertContains(successToasterMsg, expectedSuccessValidationMsg);
	}
	
	/**
	 * verify Error Toaster Message 
	 * 
	 * @throws HandleException
	 * 
	 */
	public void verifyErrorToasterMsg(String expectedString) throws HandleException {
		String actualToasterMsg = actions.getElementText(locators.getValue("errorToasterMsg"));
		actions.clickOnElement(locators.getValue("toasterMsg"));
		actions.verifyTextWithAssertContains(actualToasterMsg, expectedString);
	}

	/**
	 * Verification Active Bread Crumb on Process Definition Wizard Page 1
	 * 
	 * @throws HandleException
	 */
	public void verifyActiveToasterOnDefinitionWizardPageOne() throws HandleException {
		logger.info("verify Active Toaster On Definition Wizard Page One - Begin");
		Assert.assertEquals(actions.findElement(locators.getValue("activeStep1BreadCrumb")).isDisplayed(), true);
		Assert.assertEquals(actions.findElement(locators.getValue("activeStep1BreadCrumb")).isEnabled(), true);
		Assert.assertEquals(actions.findElement(locators.getValue("inactiveStep2BreadCrumb")).isDisplayed(), true);
		Assert.assertEquals(actions.findElement(locators.getValue("inactiveStep2BreadCrumb")).isSelected(), false);
		logger.info("verify Active Toaster On Definition Wizard Page One - End");
	}

	/**
	 * Verification Active Bread Crumb on Process Definition Wizard Page 2
	 * 
	 * @throws HandleException
	 */
	public void verifyActiveToasterOnDefinitionWizardPageTwo() throws HandleException {
		logger.info("verify Active Toaster On Definition Wizard Page Two - Begin");
		Assert.assertEquals(actions.findElement(locators.getValue("activeStep1BreadCrumb")).isDisplayed(), true);
		Assert.assertEquals(actions.findElement(locators.getValue("activeStep1BreadCrumb")).isEnabled(), true);
		Assert.assertEquals(actions.findElement(locators.getValue("activeStep1BreadCrumb")).isSelected(), false);
		Assert.assertEquals(actions.findElement(locators.getValue("inactiveStep2BreadCrumb")).isDisplayed(), true);
		logger.info("verify Active Toaster On Definition Wizard Page Two - End");
	}
	/**
	 * perform Action As Exit
	 * @throws HandleException 
	 */
	public void performActionAsExit(int location, int reasonIndex) throws HandleException {
		String exitAction = testData.getValue("actionExit");
		String exitReason = testData.getValue("reason");
		actions.selectOptionFromDropDownByVisiableText(locators.getValue("actionDropdown"), exitAction);
		actions.sendKeysToElement(exitReason, locators.getValue("exitReason"));
		actions.clickOnElement(locators.getValue("okButton"));
		String actualAction = actions.getTextByIndexFromElementList(location, locators.getValue("actionText"));
		actions.verifyTextWithAssertContains(actualAction, exitAction);
		String actualReason = actions.getTextByIndexFromElementList(location, locators.getValue("reasonOnCollapsedView"));
		actions.verifyTextWithAssertContains(actualReason, exitReason);

	}
	/**
	 * Perform Action As Perform
	 * @throws HandleException 
	 * 
	 */
	public void performActionAsPerform(int location) throws HandleException {
		String performAction = testData.getValue("actionPerform");
		actions.selectOptionFromDropDownByVisiableText(locators.getValue("actionDropdown"), performAction);
		actions.selectOptionFromDropDownByIndex(1, locators.getValue("activityDropdown"));
		String activityValueSelected = (actions.getSelectedValueFromDropDown(locators.getValue("actionDropdown")));
		actions.clickOnElement(locators.getValue("okButton"));
		String expectedAction = actions.getTextByIndexFromElementList(location, locators.getValue("actionText"));
		actions.verifyTextWithAssertContains(expectedAction, performAction);
		String actualActivityValueSelected = actions.getTextByIndexFromElementList(location, locators.getValue("actionText"));
		actions.verifyTextContainsInString(activityValueSelected, actualActivityValueSelected);

	}
	
	/**
	 * Perform Action As Process
	 * @throws HandleException 
	 */
	public void performActionAsProcess(int location) throws HandleException {
		String processAction = testData.getValue("actionProcess");
		actions.selectOptionFromDropDownByVisiableText(locators.getValue("actionDropdown"), processAction);
		String expectedTaskValue = testData.getValue("defaultActivityDropdownValue");
		actions.verifyTextWithAssertContains(actions.getSelectedValueFromDropDown(locators.getValue("activityDropdown")), expectedTaskValue);
		actions.selectOptionFromDropDownByIndex(1, locators.getValue("activityDropdown"));

		String activityValueSelected1 = actions.getSelectedValueFromDropDown(locators.getValue("activityDropdown"));
		actions.clickOnElement(locators.getValue("okButton"));
		
		String actualProcessAction = actions.getTextByIndexFromElementList(location, locators.getValue("actionText"));
		actions.verifyTextWithAssertContains(actualProcessAction, processAction);

		String expectedActivityValueSelected1 = actions.getTextByIndexFromElementList(location, locators.getValue("actionText"));
		actions.verifyTextContainsInString(activityValueSelected1, expectedActivityValueSelected1);
	}

	
	/**
	 * Perform Action As Run
	 * @throws HandleException 
	 */
	public void performActionAsRun(int location) throws HandleException {
		String runAction = testData.getValue("actionRun");
		actions.selectOptionFromDropDownByVisiableText(locators.getValue("actionDropdown"), runAction);
	
		actions.selectOptionFromDropDownByIndex(1, locators.getValue("taskDropdown"));
		String taskValueSelected = actions.getSelectedValueFromDropDown(locators.getValue("taskDropdown"));
		String onSuccessExit = testData.getValue("onSuccessExit");
		actions.selectOptionFromDropDownByVisiableText(locators.getValue("successDropdown"), onSuccessExit);
	
		String onFailureExit = testData.getValue("onFailureExit");
		actions.selectOptionFromDropDownByVisiableText(locators.getValue("failureDropdown"), onFailureExit);
		actions.clickOnElement(locators.getValue("okButton"));

		String actualRunAction = actions.getTextByIndexFromElementList(location, locators.getValue("actionText"));
		actions.verifyTextWithAssertContains(actualRunAction, runAction);
		String actualTaskValueSelected = actions.getTextByIndexFromElementList(location, locators.getValue("actionText"));
		actions.verifyTextContainsInString(taskValueSelected, actualTaskValueSelected);
		String actualOnSuccessExit = actions.getElementText(locators.getValue("successTextRule1"));
		actions.verifyTextWithAssertContains(actualOnSuccessExit, onSuccessExit);
		String actualOnFailureExit = actions.getElementText(locators.getValue("failureTextRule1"));
		actions.verifyTextWithAssertContains(actualOnFailureExit, onFailureExit);

	}
	
	/**
	 * Perform Action As Abort
	 * @throws HandleException 
	 */
	public void performActionAsAbort(int location, int reasonIndex) throws HandleException {
		String abortAction = testData.getValue("actionAbort");
		String abortReason = testData.getValue("reason");
		actions.selectOptionFromDropDownByVisiableText(locators.getValue("actionDropdown"), abortAction);
		actions.sendKeysToElement(abortReason, locators.getValue("abortReason"));
		actions.clickOnElement(locators.getValue("okButton"));
		String actualAbortAction = actions.getTextByIndexFromElementList(location, locators.getValue("actionText"));
		actions.verifyTextWithAssertContains(actualAbortAction, abortAction);
		String actualAbortReason = actions.getTextByIndexFromElementList(reasonIndex, locators.getValue("reasonOnCollapsedView"));
		actions.verifyTextWithAssertContains(actualAbortReason, abortReason);
	}
	
	/**
	 * Click Add Activities
	 * @throws HandleException 
	 */
	public void addActivities(int count) throws HandleException{
		for (int i = 1; i <= count; i++) {
			actions.clickOnElement(locators.getValue("addActivity"));
		}
	
	}
	/**
	 * click On Container Check box With Respect To Index
	 * @throws HandleException 
	 */
	public void clickOnContainerCheckbox(int startValue, int index, String elementList) throws HandleException {
		List<WebElement> allElements = actions. findElements(elementList);
		for (int i = startValue; i <= index; i++) {
			allElements.get(i).click();
		}
	}
	
	/**
	 * verify Default View of condition block
	 * @throws HandleException 
	 */
	public void verifyDefaultView(String expectedFieldValue, String expectedOperatorValue, String expectedValue ) throws HandleException {
		String actualFieldValue = actions.getSelectedValueFromDropDown(locators.getValue("fieldDropdown"));
		actions.verifyTextWithAssertContains(actualFieldValue, expectedFieldValue);
		String actualOperatorValue = actions.getSelectedValueFromDropDown(locators.getValue("operatorDropdown"));
		actions.verifyTextWithAssertContains(actualOperatorValue, expectedOperatorValue);
		String actualValue = actions.getElementPlaceholder(locators.getValue("valueField"));
		actions.verifyTextWithAssertContains(actualValue, expectedValue);
	}
	
	/**
	 * select Option From Dropdown
	 * @throws HandleException 
	 */
	public void selectOptionFromDropdown(int field, int operator, String value) throws HandleException {
		actions.selectOptionFromDropDownByIndex(field, locators.getValue("fieldDropdown"));
		actions.selectOptionFromDropDownByIndex(operator, locators.getValue("operatorDropdown"));
		actions.sendKeysToElement(value, locators.getValue("valueField"));
	}
	
	/**
	 * verify Collapsed View of condition block
	 * @throws HandleException 
	 */
	public void verifyCollapsedView(String fieldValue, String operatorValue, String value, int collapsedViewCount) throws HandleException {
		String actualFieldValue = actions.getTextByIndexFromElementList(collapsedViewCount, locators.getValue("fieldText"));
		actions.verifyTextWithAssertContains(actualFieldValue, fieldValue);
		String actualOperatorValue = actions.getTextByIndexFromElementList(collapsedViewCount, locators.getValue("operatorText"));
		actions.verifyTextWithAssertContains(actualOperatorValue, operatorValue);
		String actualValue = actions.getTextByIndexFromElementList(collapsedViewCount, locators.getValue("valueText"));
		actions.verifyTextWithAssertContains(actualValue, value);
	}
	
	/**
	 * Verification for And Connector
	 * @throws HandleException 
	 *
	 */
	public void verifyAndConnector(int location) throws HandleException {
		String expectedAndConnector = testData.getValue("andConnector");
		String actualAndConnector =  actions.getTextByIndexFromElementList(location, locators.getValue("andConnector"));
		actions.verifyTextWithAssertContains(actualAndConnector, expectedAndConnector);
	}
	
	
	/**
	 * Verification for OR Connector
	 * @throws HandleException 

	 */
	public void verifyOrConnector(int location) throws HandleException  {
		String expectedOrConnector = testData.getValue("orConnector");
		String actualOrConnector =  actions.getTextByIndexFromElementList(location, locators.getValue("orConnector"));
		actions.verifyTextWithAssertContains(actualOrConnector, expectedOrConnector);
	}
	/**
	 * Add condition and verify collapsed view
	 * @throws HandleException 

	 */
	public void addConditionAndVerifyCollapsedView(int fieldInput, int operatorInput, String valueInput) throws HandleException{
		selectOptionFromDropdown(fieldInput, operatorInput, valueInput);
		String fieldValue = actions.getSelectedValueFromDropDown(locators.getValue("fieldDropdown"));
		String operatorValue = actions.getSelectedValueFromDropDown(locators.getValue("operatorDropdown")).trim();
		String value = actions.getElementPlaceholder(locators.getValue("valueField")); 
		actions.clickOnElement(locators.getValue("okButton"));
		int collapsedViewCount = actions.getElementCountFromElementList(locators.getValue("conditionhamburgerList"));
		verifyCollapsedView(fieldValue, operatorValue, value, collapsedViewCount - 1);
	}
	
	/**
	 * drag and select field condition
	 */
	public void mouseDragAndSelectFieldCondition(int dragIndex, int dropIndex) throws InterruptedException {
		

//		WebElement dragElement = locators.getValue("conditionhamburgerList").get(dragIndex);
//		WebElement dropElement = conditionhamburgerList.get(dropIndex);
		//mouseDragAndDrop(dragElement, dropElement);
		//wait(1);
	}
	



}
