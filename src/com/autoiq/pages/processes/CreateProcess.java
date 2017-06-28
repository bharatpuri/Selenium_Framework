package com.autoiq.pages.processes;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.autoiq.base.TestBase;

/**
 * The Class CreateProcessPage.
 */
public class CreateProcess extends TestBase {

	WebDriver driver = null;

	@FindBy(xpath = "//input[@id='processName']")
	WebElement processName;

	@FindBy(xpath = "//textarea[@name='processDescription']")
	WebElement description;

	@FindBy(xpath = "//select[@id='processDefinition']")
	WebElement definationDropdown;
	
	@FindBy(xpath = "(//select[@id='processDefinition']/option)")
	 List<WebElement> definationDropdownOptions;
			
	@FindBy(xpath = "//select[@id='processWorkItemTask']")
	WebElement selectWorkQueue;

	@FindBy(xpath = "//select[@id='processRetrievalTask']")
	WebElement selectWorkItemTask;

	@FindBy(xpath = "(//input[@name='runOnce'])[1]")
	WebElement runOnce;

	@FindBy(xpath = "//input[@name='enableProcess']")
	WebElement checkEnableProcess;

	@FindBy(xpath = "//input[@name='testMode']")
	WebElement checkEnableTestMode;

	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement saveButton;

	@FindBy(xpath = "//button[@class='btn btn-default']")
	WebElement cancelButton;

	@FindBy(xpath = "//div[contains(text(),'Schedule is required.')]")
	WebElement scheduleReqMessage;

	@FindBy(xpath = "//div[contains(text(),'Definition is required.')]")
	WebElement processDefinitionReqMessage;

	@FindBy(xpath = "//div[contains(text(),'Work Queue is required.')]")
	WebElement workQueueReqMessage;

	@FindBy(xpath = "//div[contains(text(),'Work Item Task is required.')]")
	WebElement workItemTaskReqMessage;

	@FindBy(xpath = "//Select[@id='processSchedule']")
	WebElement scheduleDropdown;

	@FindBy(xpath = "(//div[@class='alert-danger small custom-error'])")
	WebElement processNameErrorMessage;

	@FindBy(xpath = "(//div[@class='toast toast-error'])")
	WebElement errorToaster;

	@FindBy(xpath = "//div[@class='toast toast-success']")
	WebElement successToasterMsg;

	@FindBy(xpath = "(//input[@name='runOnce'])[2]")
	WebElement repeatedly;

	@FindBy(xpath = "(//table[@class='table table-condensed config-parameter-table'])[1]/tbody/tr[1]/td[2]")
	WebElement workQueueRegionValue;

	@FindBy(xpath = "(//table[@class='table table-condensed config-parameter-table'])[1]/tbody/tr[2]/td[2]")
	WebElement workQueueQueueValue;

	@FindBy(xpath = "(//table[@class='table table-condensed config-parameter-table'])[2]/tbody/tr[1]/td[2]")
	WebElement workItemRegionValue;

	@FindBy(xpath = "(//table[@class='table table-condensed config-parameter-table'])[2]/tbody/tr[2]/td[2]")
	WebElement workItemQueueValue;

	@FindBy(xpath = "(//input[@id='booleanTypeRetrievalTaskParam87'])[1]")
	WebElement yesRadioButton;

	@FindBy(xpath = "(//input[@id='booleanTypeRetrievalTaskParam87'])[2]")
	WebElement noRadioButton;
	
	@FindBy(xpath = "(//div[@class='col-xs-3 col-sm-3 col-md-5 col-lg-5 text-right']/h4)")
	WebElement pageTitle;

	/**
	 * Instantiates a new Create Process page.
	 * 
	 * @param driver
	 *            the driver
	 */
	public CreateProcess(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}

	/**
	 * Set blank Process Name in textbox
	 * 
	 * @param strProcessName
	 * @throws AWTException
	 */

	public void setProcessNameBlank() throws AWTException {
		log.info("set Process Name Blank - Begin");
		String selectAll = Keys.chord(Keys.CONTROL, "a");
		processName.sendKeys(selectAll + Keys.DELETE);
		log.info("set Process Name Blank - End");
	}

	/**
	 * Set Process Name in textbox
	 * 
	 * @param strProcessName
	 */

	public void setProcessName(String strProcessName) {
		log.info("set Process Name - Begin");
		processName.clear();
		processName.sendKeys(strProcessName);
		log.info("set Process Name - End");
	}

	/**
	 * get Process Name from textbox
	 * 
	 * @param strProcessName
	 */

	public String getProcessNameValue() {
		return processName.getAttribute("value");
	}

	/**
	 * Set Description in Description textarea
	 * 
	 * @param strDescription
	 */

	public void setDescription(String strDescription) {
		log.info("set Description - Begin");
		description.clear();
		description.sendKeys(strDescription);
		log.info("set Description - End");
	}

	/**
	 * get Process Name from textbox
	 * 
	 * @param strProcessName
	 */

	public String getDescriptionValue() {
		return description.getAttribute("value");
	}
	
	/**
	 * get Process page title
	 */

	public String getCreateProcessPageTitle() {
		return pageTitle.getText();
	}

	/**
	 * Select option from Schedule Drop Down
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws IOException
	 */
	public void setSelectSchedule(int index) throws InterruptedException, IOException, AWTException {
		log.info("set Select Schedule - Begin");
		selectOptionFromScheduleDownByIndex(index);
		wait(2);
		log.info("set Select Schedule - End");
	}

	/**
	 * Select option from Definition Drop Down
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws IOException
	 */
	public void setSelectDefinition(int index) throws InterruptedException, IOException, AWTException {
		log.info("set Select Definition - Begin");
		selectOptionFromDefinitionDownByIndex(index);
		wait(2);
		log.info("set Select Definition - End");
	}

	/**
	 * Select option from Work Queue Drop Down
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws IOException
	 */
	public void setSelectWorkQueue(int index) throws InterruptedException, IOException, AWTException {
		log.info("set Select Work Queue - Begin");

		selectOptionFromWorkQueueByIndex(index);
		wait(2);
		log.info("set Select Work Queue - End");
	}

	/**
	 * Select option from Work Item Task Drop Down
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws IOException
	 */
	public void setSelectWorkItemTask(int index) throws InterruptedException, IOException, AWTException {
		log.info("set Select Work Item Task - Begin");
		selectOptionFromWorkItemTaskByIndex(index);
		wait(2);
		log.info("set Select Work Item Task - End");
	}

	/**
	 * Click on no button
	 * 
	 * @throws InterruptedException
	 */
	public void clickNoRadioButton() throws InterruptedException {
		log.info("click Yes Radio Button - Begin");
		noRadioButton.click();
		wait(2);
		log.info("click Yes Radio Button - End");
	}
	
	/**
	 * Get schedule name required toaster
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws IOException
	 */
	public String getScheduleNameToasterMsg() throws InterruptedException {
		return scheduleReqMessage.getText();

	}

	/**
	 * Get definition name required toaster
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws IOException
	 */
	public String getDefinitioneNameToasterMsg() throws InterruptedException {
		return processDefinitionReqMessage.getText();

	}

	/**
	 * Get work item required toaster
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws IOException
	 */
	public String getWorkItemTaskToasterMsg() throws InterruptedException {
		return workItemTaskReqMessage.getText();

	}

	/**
	 * Click on Run Once
	 * 
	 * @throws InterruptedException
	 */
	public void setSelectRunOnce() throws InterruptedException {
		log.info("set Select Run Once - Begin");
		runOnce.click();
		wait(2);
		log.info("set Select Run Once - End");
	}

	/**
	 * Check if Run Once checkbox is selected
	 * 
	 * @throws InterruptedException
	 */
	public boolean isRunOnceSelected() throws InterruptedException {
		return runOnce.isSelected();
	}

	/**
	 * Click on Repeatedly
	 * 
	 * @throws InterruptedException
	 */
	public void setSelectRepeatedly() throws InterruptedException {
		log.info("set Select Repeatedly - Begin");
		repeatedly.click();
		wait(2);
		log.info("set Select Repeatedly - End");
	}

	/**
	 * Click on Enable Process
	 * 
	 * @throws InterruptedException
	 */
	public void setSelectEnableProcess() throws InterruptedException {
		log.info("set Select Enable Process - Begin");
		checkEnableProcess.click();
		wait(2);
		log.info("set Select Enable Process - End");
	}

	/**
	 * Click on Test Mode
	 * 
	 * @throws InterruptedException
	 */
	public void setSelectEnableTestMode() throws InterruptedException {
		log.info("set Select Enable Test Mode - Begin");
		checkEnableTestMode.click();
		wait(2);
		log.info("set Select Enable Test Mode - End");
	}

	/**
	 * enter Process Name and description
	 * 
	 */
	public void enterProcessNameAndDescription(String name, String description) {
		setProcessName(name);
		setDescription(description);
	}
	
	/**
	 * get toaster success message
	 * 
	 */

	public String getSuccessToasterMsg() {
		waitForElementVisible(successToasterMsg, 3);
		return successToasterMsg.getText();

	}

	/**
	 * Get page error msg
	 * 
	 * @throws InterruptedException
	 */
	public String getErrorToaster() throws InterruptedException {
		return errorToaster.getText();
	}

	/**
	 * Check if Test Mode is checked on Create/Edit Process page
	 * 
	 * @throws InterruptedException
	 */
	public void verifyIsEnableTestModeSelected() throws InterruptedException {
		log.info("set Select Enable Test Mode - Begin");
		Assert.assertTrue(checkEnableTestMode.isSelected(), "Test Mode not assigned. Please check in the application");
		log.info("set Select Enable Test Mode - End");
	}

	/**
	 * Click on Save button
	 * 
	 * @throws InterruptedException
	 */
	public void clickSave() throws InterruptedException {
		log.info("click Save - Begin");
		saveButton.click();
		wait(2);
		log.info("click Save - End");
	}

	/**
	 * Click on cancel button
	 * 
	 * @throws InterruptedException
	 */
	public void clickCancelButton() throws InterruptedException {
		log.info("click Cancel Button - Begin");
		cancelButton.click();
		wait(1);
		log.info("click Cancel Button - End");
	}

	/**
	 * Duplicate Process Name error message verification
	 * 
	 * @throws InterruptedException
	 */
	public void duplicateProcessNameErrorMessageValidation() throws InterruptedException {
		log.info("duplicate Process Name Error Message 	Validation - Begin");
		String actualDuplicateToasterMsg = getErrorToaster();
		String expectedDuplicateToasterMsg = createProcessPageProp.getProperty("dublicateErrorTosterMsg");
		Assert.assertTrue(compareTextContains(actualDuplicateToasterMsg, expectedDuplicateToasterMsg),
				"Success Process Creation message not displayed");
		wait(2);
		String actualToasterMsg = processNameErrorMessage.getText();
		String expectedToasterMsg = createProcessPageProp.getProperty("duplicateNameValidationMsg");
		Assert.assertTrue(compareTextContains(actualToasterMsg, expectedToasterMsg), "Success message not displayed");
		log.info("duplicate Process Name Error Message Validation - End");
	}

	/**
	 * Blank Process Name error message verification
	 * 
	 * @throws InterruptedException
	 */
	public void blankProcessNameErrorMessageValidation(String expectedErrorMessage) throws InterruptedException {
		log.info("Blank ProcessName Error Message Validation - Begin");
		String actualErrorMsg = processNameErrorMessage.getText();
		Assert.assertEquals(actualErrorMsg, expectedErrorMessage);
		String actualFormMsg = getErrorToaster();
		String expectedFormMsg = createProcessPageProp.getProperty("pageErrorToaster");
		Assert.assertTrue(compareTextContains(actualFormMsg, expectedFormMsg), "Success message not displayed");
		log.info("Blank ProcessName Error Message Validation - End");
	}

	/**
	 * Check if Process Name Required Message is displayed or not
	 * 
	 * @throws InterruptedException
	 */
	public void processNameReqMessage() throws InterruptedException {
		log.info("process Name Req Message - Begin");
		String actualValidationMsg = processNameErrorMessage.getText();
		String expectedValidationMsg = createProcessPageProp.getProperty("expectedRequiredNameValidationMsg");
		Assert.assertTrue(compareTextContains(actualValidationMsg, expectedValidationMsg),
				"Process name Validation message not displayed");
		wait(2);
		log.info("process Name Req Message - End");
	}

	/**
	 * Check if Schedule Required Message is displayed or not
	 * 
	 * @throws InterruptedException
	 */
	public void scheduleReqMessage() throws InterruptedException {
		log.info("schedule Req Message - Begin");
		String actualValidationMsg = getScheduleNameToasterMsg();
		String expectedValidationMsg = createProcessPageProp.getProperty("scheduleNameValidationMsg");
		Assert.assertTrue(compareTextContains(actualValidationMsg, expectedValidationMsg),
				"Schedule name Validation message not displayed");
		wait(2);
		log.info("schedule Req Message - End");
	}

	/**
	 * Check if Definition Required Message is displayed or not
	 * 
	 * @throws InterruptedException
	 */
	public void processDefinitionReqMessage() throws InterruptedException {
		String actualValidationMsg = getDefinitioneNameToasterMsg();
		String expectedValidationMsg = createProcessPageProp.getProperty("definitionNameValidationMsg");
		Assert.assertTrue(compareTextContains(actualValidationMsg, expectedValidationMsg),
				"Definition name Validation message not displayed");
		wait(2);
		log.info("process Definition Req Message - End");
	}

	/**
	 * Check if Work Queue Required Message is displayed or not
	 * 
	 * @throws InterruptedException
	 */
	public void workQueueReqMessage() throws InterruptedException {
		log.info("work Queue Re qMessage - Begin");
		workQueueReqMessage.isDisplayed();
		wait(2);
		log.info("work Queue Req Message - End");
	}

	/**
	 * Check if Repeatedly radio button is selected
	 * 
	 * @throws InterruptedException
	 */
	public boolean isRepeatedlySelected() throws InterruptedException {
		return repeatedly.isSelected();
	}

	/**
	 * Check if Work Item Task Required Message is displayed or not
	 * 
	 * @throws InterruptedException
	 */
	public void workItemTaskReqMessage() throws InterruptedException {
		log.info("work Item Task Req Message - Begin");
		String actualValidationMsg = getWorkItemTaskToasterMsg();
		String expectedValidationMsg = createProcessPageProp.getProperty("workItemValidationMsg");
		Assert.assertTrue(compareTextContains(actualValidationMsg, expectedValidationMsg),
				"Work item Validation message not displayed");
		wait(2);
		log.info("work Item Task Req Message - End");
	}

	/**
	 * Verification for Create Process success message toaster
	 * 
	 * @throws InterruptedException
	 */
	public void verifyCreateProcessSuccessToasterMsg() throws InterruptedException {
		log.info("verify Create Process Success Toaster Msg - Begin");
		String actualSuccessMsg = getSuccessToasterMsg();
		String expectedSucessMsg = createProcessPageProp.getProperty("successToasterMessage");
		log.info("act:" + actualSuccessMsg);
		log.info("exp:" + expectedSucessMsg);
		Assert.assertTrue(compareTextContains(actualSuccessMsg, expectedSucessMsg), "Success message not displayed");
		wait(2);
		log.info("verify Create Process Success Toaster Msg - End");
	}

	/**
	 * Verification for Create Process success message toaster
	 * 
	 * @throws InterruptedException
	 */
	public void verifyCreateAndEnableProcessSuccessToasterMsg() throws InterruptedException {
		log.info("Success Message: " + getSuccessToasterMsg());
		String actualSuccessMsg = getSuccessToasterMsg();
		String expectedSucessMsg = createProcessPageProp
				.getProperty("expectedCreateAndEnableProcessSuccessToasterMessage");
		Assert.assertTrue(compareTextContains(actualSuccessMsg, expectedSucessMsg), "Success message not displayed");
	}

	/**
	 * Verification for Delete Process success message toaster
	 * 
	 * @throws InterruptedException
	 */
	public void verifyDeleteProcessSuccessToasterMsg() throws InterruptedException {
		log.info("verify Delete Process Success Toaster Msg - Begin");
		String actualSuccessMsg = getSuccessToasterMsg();
		log.info("Success Message: " + actualSuccessMsg);
		String expectedSucessMsg = createProcessPageProp.getProperty("deleteSuccessToasterMsg");
		Assert.assertTrue(compareTextContains(actualSuccessMsg, expectedSucessMsg),
				"Successful delete proccess message not displayed");
		wait(3);
		log.info("verify Delete Process Success Toaster Msg - End");
	}

	/**
	 * Verification for Update Process success message toaster
	 * 
	 * @throws InterruptedException
	 */
	public void verifyUpdateProcessSuccessToasterMsg() throws InterruptedException {
		log.info("verify Update Process Success Toaster Msg - Begin");
		String actualSuccessMsg = getSuccessToasterMsg();
		String expectedSucessMsg = createProcessPageProp.getProperty("expectedUpdateSuccessToasterMessage");
		Assert.assertTrue(compareTextContains(actualSuccessMsg, expectedSucessMsg), "Success message not displayed");
		wait(2);
		log.info("verify Update Process Success Toaster Msg - End");
	}

	/**
	 * selects Option From Definition Down by text
	 */
	public void selectOptionFromDefinitionDown(String defination){
		Select select = new Select(definationDropdown);
		select.selectByVisibleText(defination);
	}
	
	/**
	 * checks if definition available in the dropdown
	 */
	public boolean isDefinitionPresentInDropdown(String defination){
		wait(2);
		boolean found = false ;
		for(int i=0; i<definationDropdownOptions.size(); i++) {
		    if((definationDropdownOptions.get(i).getText().trim()).equals(defination)) {
		        found=true;
		        break;
		    }
		}
		return found;
	}

	/**
	 * selects Option From Definition Down by index
	 */
	public void selectOptionFromDefinitionDownByIndex(int value){
		Select select = new Select(definationDropdown);
		select.selectByIndex(value);
	}

	/**
	 * gets Selected Value From Definition DropDown
	 */
	public String getSelectedValueFromDefinitionDropDown(){
		Select select = new Select(definationDropdown);
		WebElement option = select.getFirstSelectedOption();
		return option.getText();
	}

	/**
	 * selects Option From Schedule Down by text
	 */
	public void selectOptionFromScheduleDropDown(String schedule){
		Select select = new Select(scheduleDropdown);
		select.selectByVisibleText(schedule);
	}

	/**
	 * selects Option From Schedule dropDown by index
	 */
	public void selectOptionFromScheduleDownByIndex(int value) throws IOException, InterruptedException, AWTException {
		Select select = new Select(scheduleDropdown);
		select.selectByIndex(value);
	}

	/**
	 * gets Selected Value From Schedule DropDown
	 */
	public String getSelectedValueFromScheduleDropDown() throws IOException, InterruptedException, AWTException {
		Select select = new Select(scheduleDropdown);
		WebElement option = select.getFirstSelectedOption();
		return option.getText();
	}

	/**
	 * selects Option From WorkQueue dropDown by text
	 */
	public void selectOptionFromWorkQueueDropDown(String workQueue)
			throws IOException, InterruptedException, AWTException {
		Select select = new Select(selectWorkQueue);
		select.selectByVisibleText(workQueue);
	}

	/**
	 * selects Option From WorkQueue dropDown by index
	 */
	public void selectOptionFromWorkQueueByIndex(int value) throws IOException, InterruptedException, AWTException {
		Select select = new Select(selectWorkQueue);
		select.selectByIndex(value);
	}

	/**
	 * gets Selected Value From WorkQueue DropDown
	 */
	public String getSelectedValueFromWorkQueueDropDown() throws IOException, InterruptedException, AWTException {
		Select select = new Select(selectWorkQueue);
		WebElement option = select.getFirstSelectedOption();
		return option.getText();
	}

	/**
	 * selects Option From Work Item Task dropDown by text
	 */
	public void selectOptionFromWorkItemTaskDropDown(String workQueueTask)
			throws IOException, InterruptedException, AWTException {
		Select select = new Select(selectWorkItemTask);
		select.selectByVisibleText(workQueueTask);
	}

	/**
	 * selects Option From Work item Task dropDown by index
	 */
	public void selectOptionFromWorkItemTaskByIndex(int value) throws IOException, InterruptedException, AWTException {
		Select select = new Select(selectWorkItemTask);
		select.selectByIndex(value);
	}

	/**
	 * gets Selected Value From Task DropDown
	 */
	public String getSelectedValueFromTaskDropDown() throws IOException, InterruptedException, AWTException {
		Select select = new Select(selectWorkItemTask);
		WebElement option = select.getFirstSelectedOption();
		return option.getText();
	}

	/**
	 * Add work queue region
	 * 
	 * @throws InterruptedException
	 */
	public void enterWorkQueueRegion(String region) throws InterruptedException {
		log.info("Add work queue region - Begin");
		Actions actions = new Actions(driver);
		actions.moveToElement(workQueueRegionValue);
		actions.click();
		actions.sendKeys(region);
		actions.build().perform();
		log.info("Add work queue region - End");
	}

	/**
	 * get work queue region
	 */
	public String getWorkQueueRegion() {
		return workQueueRegionValue.getText();
	}

	/**
	 * Add work queue Queue
	 * 
	 * @throws InterruptedException
	 */
	public void enterWorkQueueQueue(String queue) throws InterruptedException {
		log.info("Add work queue Queue - Begin");
		Actions actions = new Actions(driver);
		actions.moveToElement(workQueueQueueValue);
		actions.click();
		actions.sendKeys(queue);
		actions.build().perform();
		log.info("Add work queue Queue - End");
	}

	/**
	 * get work queue Queue
	 */
	public String getWorkQueueQueue() {
		return workQueueQueueValue.getText();
	}

	/**
	 * Add work Item Task region
	 * 
	 * @throws InterruptedException
	 */
	public void enterTaskRegion(String region) throws InterruptedException {
		log.info("Add work Item Task region - Begin");
		Actions actions = new Actions(driver);
		actions.moveToElement(workItemRegionValue);
		actions.click();
		actions.sendKeys(region);
		actions.build().perform();
		log.info("Add work Item Task region - End");
	}

	/**
	 * get work Item Task region
	 */
	public String getTaskRegion() {
		return workItemRegionValue.getText();
	}

	/**
	 * Add work queue Queue
	 * 
	 * @throws InterruptedException
	 */
	public void enterTaskQueue(String queue) throws InterruptedException {
		log.info("Add work Item Task Queue - Begin");
		Actions actions = new Actions(driver);
		actions.moveToElement(workItemQueueValue);
		actions.click();
		actions.sendKeys(queue);
		actions.build().perform();
		log.info("Add work Item Task Queue - End");
	}

	/**
	 * get work queue Queue
	 */
	public String getTaskQueue() {
		return workItemQueueValue.getText();
	}

	/**
	 * Click on yes button
	 * 
	 * @throws InterruptedException
	 */
	public void clickYesRadioButton() throws InterruptedException {
		log.info("click No Radio Button - Begin");
		yesRadioButton.click();
		wait(2);
		log.info("click No Radio Button - End");
	}

	/**
	 * Check if Yes radio button is selected
	 * 
	 * @throws InterruptedException
	 */
	public boolean isYesSelected() throws InterruptedException {
		return yesRadioButton.isSelected();
	}

	/**
	 * Check if No radio button is selected
	 * 
	 * @throws InterruptedException
	 */
	public boolean isNoSelected() throws InterruptedException {
		return noRadioButton.isSelected();
	}

}
