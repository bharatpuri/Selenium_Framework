package com.autoiq.pages.processes;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.autoiq.base.TestBase;

/**
 * The Class Overview Page.
 */
public class ProcessOverview extends TestBase {

	WebDriver driver = null;

	@FindBy(xpath = "//a[contains(text(), 'Overview')]")
    WebElement overviewtext;

	@FindBy(xpath = "//span[contains(text(),'Create New Process')]")
	WebElement createProcessButton;

	@FindAll({ @FindBy(xpath = "(//tbody[@class='ui-datatable-data ui-widget-content']/tr/td[2])") })
	private List<WebElement> processList;

	@FindAll({ @FindBy(xpath = "(//tbody[@class='ui-datatable-data ui-widget-content']/tr/td[6])") })
	List<WebElement> scheduleList;
	
	@FindAll({ @FindBy(xpath = "(//tbody[@class='ui-datatable-data ui-widget-content']/tr/td[5])") })
	List<WebElement> definitionList;

	@FindAll({ @FindBy(xpath = "//i[@class='icon-beaker test-mode']") })
	List<WebElement> testModeList;

	@FindAll({ @FindBy(xpath = "(//div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default'])") })
	List<WebElement> selectAllList;

	@FindAll({ @FindBy(xpath = "(//tbody[@class='ui-datatable-data ui-widget-content']/tr/td[9])") })
	List<WebElement> hamburgerIconList;

	@FindAll({ @FindBy(xpath = "(//li/a[@class='text-danger'])") })
	List<WebElement> deleteIconList;

	@FindAll({ @FindBy(xpath = "(//li/a/span/i[@class='icon-pencil-3 popover-icon'])") })
	List<WebElement> editIconList;
	
	@FindAll({ @FindBy(xpath = "(//li/a/span/i[@class='icon-docs-1 popover-icon'])") })
	List<WebElement> duplicateIconList;
	
	@FindBy(xpath = "//span[contains(text(),'Enable Test Mode')]")
	WebElement enableTestModeButton;

	@FindBy(xpath = "//span[contains(text(),'Disable Test Mode')]")
	WebElement disableTestModeButton;

	@FindBy(xpath = "//Select[@id='processSchedule']")
	WebElement editSelectSchedule;

	@FindBy(xpath = "//select[@id='processDefinition']")
	WebElement editSelectDefinition;

	@FindBy(xpath = "//select[@id='processWorkItemTask']")
	WebElement selectWorkQueue;

	@FindBy(xpath = "//select[@id='processRetrievalTask']")
	WebElement selectWorkItemTask;

	@FindBy(xpath = "//button[@class='ajs-button ajs-ok'][contains(text(),'Yes')]")
	WebElement yesButton;

	@FindBy(xpath = "(//span[@class='ui-column-title'])[1]")
	WebElement sortByProcessName;

	@FindBy(xpath = "(//span[@class='ui-column-title'])[4]")
	WebElement sortByDefinitions;

	@FindBy(xpath = "(//span[@class='ui-column-title'])[5]")
	WebElement sortBySchedules;

	@FindBy(xpath = "//div[@class='col-sm-2']")
	WebElement totalProcessCount;

	@FindBy(xpath = "(//div[@class='toast toast-error'])")
	WebElement ErrorToasterMsg;

	@FindBy(xpath = "//div[@class='toast toast-success']")
	WebElement successToasterMsg;
	
	String errorToaster = "(//div[@class='toast toast-error'])";
	String successToaster = "//div[@class='toast toast-success']";

	/**
	 * Instantiates a new Overview page.
	 * 
	 * @param driver
	 *            the driver
	 */
	public ProcessOverview(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}

	public List<WebElement> getProcessList()
	{
	    return processList;
	}

	/**
	 * Get Overview text
	 * 
	 * @return Overview text
	 */
	public String getOverviewText() {
		return overviewtext.getText();
	}

	/**
	 * Get success toaster message
	 * 
	 * @return Overview text
	 */
	public String getSuccessToaster() {
		waitForElementToBePresent(successToaster, 5);
		waitForElementVisible(successToasterMsg, 5);
		return successToasterMsg.getText();
	}

	/**
	 * Get Overview text
	 * 
	 * @return Overview text
	 */
	public String getErrorToaster() {
		waitForElementToBePresent(errorToaster, 5);
		waitForElementVisible(ErrorToasterMsg, 5);
		return ErrorToasterMsg.getText();
	}

	/**
	 * Click on create new process button
	 */
	public void clickCreateNewProcessButton() {
		log.info("click Create New Process Button - Begin");
		wait(3);
		waitForElementClickable(createProcessButton, 3);
		createProcessButton.click();
		log.info("click Create New Process Button - Begin");
	}

	/**
	 * verifies Successful Select Process
	 */
	public void verifySuccessfulSelectProcess(int processnumber, String processname) {
		log.info("verify Successful Select Process - Begin");
		log.info("Process count is" + selectAllList.size());
		clickOnProcessCheckbox(processnumber);
		log.info("verify Successful Select Process - End");
	}

	/**
	 * deletes the Process
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	public void deleteProcess(String processName) throws IOException, InterruptedException {
		log.info("Delete Existing Process - Begin");
		int index = getProcessIndex(processName);
		System.out.println("Name:"+processName);
		log.info("Process count is :" + index);
		clickHamburgerIcon(index);
		clickOnDelete(index);
		clickConfirmDeleteProcessButton();
		log.info("Process removed Succcessfully!!");
		log.info("Delete Existing Process - End");
	}
	
	/**
	 * opens duplicate process page
	 */
	public void OpensDuplicateProcessPage(int processnumber) {
		log.info("Duplicates Existing Process - Begin");
		log.info("Process count is :" + processnumber);
		clickHamburgerIcon(processnumber);
		clickOnDuplicate(processnumber);
		log.info("Process removed Succcessfully!!");
		log.info("Duplicates Existing Process - End");
	}

	/**
	 * verify Successful Test Mode Assignment
	 */
	public void verifySuccessfulTestModeAssignment(int index, String processname) {
		log.info("verify Successful Test Mode Assignment - Begin");
		log.info("Test mode count is" + testModeList.size());
		for (WebElement testMode : testModeList) {
			String actualProcessName = processList.get(index - 1).getText();
			if (actualProcessName.equals(processname)) {
				Assert.assertTrue(testMode.isDisplayed());
				// getActualSelectAllIconPosition(index + 2);
			}
			break;
		}
		log.info("Process assigned with Test Mode Succcessfully!!");
		log.info("verify Successful Test Mode Assignment - End");
	}

	/**
	 * verify Successful Test Mode disabled
	 */
	public void verifySuccessfulTestModeDisabled(int index, String processname) {
		log.info("verify Successful Test Mode disable - Begin");
		Assert.assertTrue(isTestModeDisabledForAllProcess(),"Test mode not disabled for all process");
		log.info("verify Successful Test Mode disable - End");
	}

	/**
	 * checks whether test mode is disabled for all process
	 */
	public boolean isTestModeDisabledForAllProcess(){
	driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	try {
		return testModeList.size() == 0;
	} finally {
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}
	}

	/**
	 * edits the Process 
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	public void editProcess(String processName) throws IOException, InterruptedException {
		log.info("Edit Existing Process - Begin");
		int index = getProcessIndex(processName);
		log.info("Process count is" + index);
		clickHamburgerIcon(index);
		clickOnEdit(index);
		log.info(" Edit Existing Process - End");
	}

	/**
	 * clicks on hamburger icon
	 */
	public void clickHamburgerIcon(int location) {
		wait(1);
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);", hamburgerIconList.get(location-1));
		hamburgerIconList.get(location - 1).click();
		wait(3);
	}

	/**
	 * clicks on Process Checkbox
	 */
	public void clickOnProcessCheckbox(int location) {
		selectAllList.get(location).click();
	}

	/**
	 * clicks on select all checkbox
	 */
	public void checkSelectAll() {
		selectAllList.get(0).click();
	}

	/**
	 * clicks On Edit link
	 */
	public void clickOnEdit(int location) {
		waitForElementVisible(editIconList.get(location-1), 5);
		editIconList.get(location - 1).click();
		wait(3);
	}
	
	/**
	 * clicks On Duplicate link
	 */
	public void clickOnDuplicate(int location) {
		waitForElementVisible(duplicateIconList.get(location-1), 5);
		duplicateIconList.get(location - 1).click();
		wait(3);
	}

	/**
	 * clicks On Delete link
	 */
	public void clickOnDelete(int location) {
		deleteIconList.get(location - 1).click();
		wait(3);
	}

	/**
	 * clicks On Yes button
	 */
	public void clickConfirmDeleteProcessButton() {
		log.info("click Confirm Delete Process Button - Begin");
		Assert.assertTrue(yesButton.isEnabled(), "Yes button not displayed. Please check in the application");
		yesButton.click();
		log.info("click Confirm Delete Process Button - End");
	}

	/**
	 * Sorts By Process Name
	 */
	public void clickSortByProcessName() {
		log.info("click Sort By Process Name - Begin");
		sortByProcessName.click();
		wait(2);
		log.info("click Sort By Process Name - End");
	}

	/**
	 * Sorts By DEfinitions Name
	 */
	public void clickSortByDefinitions() {
		log.info("click Sort By Definitions - Begin");
		sortByDefinitions.click();
		wait(2);
		log.info("click Sort By Definitions - End");
	}

	/**
	 * Sorts By Schedules Name
	 */
	public void clickSortBySchedules() {
		log.info("click Sort By Schedules - Begin");
		sortBySchedules.click();
		wait(2);
		log.info("click Sort By Schedules - End");
	}

	/**
	 * selects Process Checkbox
	 */
	public void selectCheckBox(int index) {
		log.info("click Select All Check Box - Begin");
		clickOnProcessCheckbox(index);
		wait(1);
		log.info("click Select All Check Box - End");
	}

	/**
	 * Click on Enable Test Mode button
	 * 
	 * @throws InterruptedException
	 */
	public void clickEnableTestModeButton() throws InterruptedException {
		log.info("click Enable Test Mode Button - Begin");
		enableTestModeButton.click();
		log.info("click Enable Test Mode Button - End");
	}

	/**
	 * Click on Disable Test Mode button
	 * 
	 * @throws InterruptedException
	 */
	public void clickDisableTestModeButton() throws InterruptedException {
		log.info("click Disable Test Mode Button - Begin");
		disableTestModeButton.click();
		log.info("click Disable Test Mode Button - End");
	}

	/**
	 * verify Processes Asigned To TestMode
	 */
	public void verifyProcessesAsignedToTestMode() throws InterruptedException {
		log.info("Verify Processes Asigned To TestMode - Begin");
		int totalProcessCount = getProcessCount();
		Integer count = testModeList.size();
		if (totalProcessCount == (count)) {
			log.info("Test Mode assigned to all processes & Process count is  :" + count);
		} else {
			log.info("Test Mode not assigned to all processes");
		}
		log.info("Verify Processes Asigned To TestMode - End");
	}

	/**
	 * gets Process Count
	 */
	public int getProcessCount() throws InterruptedException {
		log.info("get Process Count - Begin");
		String totalCount = totalProcessCount.getText();
		String[] partialCount = totalCount.split(":");
		String CountArray = partialCount[1];
		String[] count2 = CountArray.split(" ");
		int totalProcessCount = Integer.parseInt(count2[1]);
		log.info(totalProcessCount);
		wait(3);
		log.info("get Process Count - End");
		return totalProcessCount;
	}

	/**
	 * verify Successful Process Creation
	 */
	public void verifySuccessfulProcessCreation(int index, String expectedProcessname) {
		log.info("verify Successful Process Creation - Begin");
		String actualProcessName = processList.get(index - 1).getText();
		Assert.assertEquals(actualProcessName, expectedProcessname);
		log.info("Process displayed on Process Overview page. Create New Process verification Done Succcessfully!!");
		log.info("verify Successful Process Creation - End");
	}

	/**
	 * verify No Process Creation
	 */
	public void verifyNoProcessCreation(String processname) {
		log.info("verify No Process Creation - Begin");
		Assert.assertEquals(processList.contains(processname), false);
		log.info(
				"Process not displayed on Process Overview page. Cancel New Process verification Done Succcessfully!!");
		log.info("verify Successful Process Creation - End");
	}

	/**
	 * gets schedule name selected in the dropdown
	 */
	public String getScheduleName(int location) {
		String scheduleName = scheduleList.get(location).getText();
		return scheduleName;
	}
	
	/**
	 * gets Definition name selected in the dropdown
	 */
	public String getDefinitionName(int location) {
		String definitionName = definitionList.get(location).getText();
		return definitionName;
	}

	/**
	 * gets Process Index
	 */
	public int getProcessIndex(String pname) throws IOException, InterruptedException {
		String processName = pname;

		int count = 0;
		for (WebElement process : processList) {
			count++;
			if ((process.getText()).equalsIgnoreCase(processName)) {
				log.info("Process Added successfully");

				break;
			}
		}
		return count;
	}
	
	/**
	 * deletes Process If Already Exists
	 */
	public void deleteProcessIfAlreadyExists(String processName) throws IOException, InterruptedException {
		boolean flag = false;
		for (WebElement process : processList) {
			if ((process.getText()).equalsIgnoreCase(processName)) {
				log.info("Process is present");
                flag =true;
			}
		}
		if (flag==true){
			deleteProcess(processName);
			log.info("Process deleted");
			wait(3);
		}
	}

	/**
	 * Verification for Test Mode Enable Success Toaster
	 * 
	 * @throws InterruptedException
	 */
	public void verifyTestModeEnableToasterMsg() throws InterruptedException {
		log.info("Verify Test Mode Enable Success Toaster Msg - Begin");
		String actualSuccessMsg = getSuccessToaster();
		String expectedSucessMsg = overviewPageProp.getProperty("enableTestModeToaster");
		Assert.assertTrue(compareTextContains(actualSuccessMsg, expectedSucessMsg),
				"Success toaster message not displayed");
		wait(3);
		log.info("Verify Test Mode Enable Success Toaster Msg - End");
	}

	/**
	 * Verification for Test Mode Disable Success Toaster
	 * 
	 * @throws InterruptedException
	 */
	public void verifyTestModeDisableToasterMsg() throws InterruptedException {
		log.info("Verify Test Mode Disable Success Toaster Msg - Begin");
		String actualSuccessMsg = getSuccessToaster();
		String expectedSucessMsg = overviewPageProp.getProperty("disableTestModeToaster");
		Assert.assertTrue(compareTextContains(actualSuccessMsg, expectedSucessMsg),
				"Success toaster message not displayed");
		wait(3);
		log.info("Verify Test Mode Disable Success Toaster Msg - End");
	}

	/**
	 * Select option from Schedule Drop Down
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws IOException
	 */
	public void setEditSelectSchedule(int index) throws InterruptedException, IOException, AWTException {
		log.info("set Select Schedule - Begin");
		selectOptionFromScheduleDownByIndex(index);
		wait(2);
		log.info("set Select Schedule - End");
	}

	/**
	 * Select option from Schedule Drop Down by index
	 */
	public void selectOptionFromScheduleDownByIndex(int value) throws IOException, InterruptedException, AWTException {
		Select select = new Select(editSelectSchedule);
		select.selectByIndex(value);
	}

	/**
	 * Select option from Definition Drop Down
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws IOException
	 */
	public void setEditSelectDefinition(int index) throws InterruptedException, IOException, AWTException {
		log.info("set Select Definition - Begin");
		selectOptionFromDefinitionDownByIndex(index);
		wait(2);
		log.info("set Select Definition - End");
	}

	/**
	 * Select option from definition Drop Down by index
	 */
	public void selectOptionFromDefinitionDownByIndex(int value)
			throws IOException, InterruptedException, AWTException {
		Select select = new Select(editSelectDefinition);
		select.selectByIndex(value);
	}
	
	/**
	 * verify Processes Assigned To TestMode
	 * 
	 * @throws InterruptedException
	 */
	public void verifyProcessesAssignedToTestMode() throws InterruptedException  { 
		log.info("Verify Processes Asigned To TestMode - Begin");
		int totalProcessCount=getProcessCount();
		 Integer count=testModeList.size();
		 Assert.assertTrue(totalProcessCount==(count),"Test Mode not assigned to all processes");
	 }

	/**
	 * Select option from Work Queue Drop Down
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws IOException
	 */
	public void setEditSelectWorkQueue(int index) throws InterruptedException, IOException, AWTException {
		log.info("set Select Work Queue - Begin");

		selectOptionFromWorkQueueByIndex(index);
		wait(2);
		log.info("set Select Work Queue - End");
	}

	/**
	 * Select option from WorkQueue Drop Down by index
	 */
	public void selectOptionFromWorkQueueByIndex(int value) throws IOException, InterruptedException, AWTException {
		Select select = new Select(selectWorkQueue);
		select.selectByIndex(value);
	}

	/**
	 * Select option from Work Item Task Drop Down
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws IOException
	 */
	public void setEditSelectWorkItemTask(int index) throws InterruptedException, IOException, AWTException {
		log.info("set Select Work Item Task - Begin");
		selectOptionFromWorkItemTaskByIndex(index);
		wait(2);
		log.info("set Select Work Item Task - End");
	}

	/**
	 * Select option from Work Item Task Drop Down by index
	 */
	public void selectOptionFromWorkItemTaskByIndex(int value) throws IOException, InterruptedException, AWTException {
		Select select = new Select(selectWorkItemTask);
		select.selectByIndex(value);
	}
}
