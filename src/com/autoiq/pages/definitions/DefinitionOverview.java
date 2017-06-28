package com.autoiq.pages.definitions;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.autoiq.base.TestBase;

/**
 * The Class DefinitionOverview Page.
 */
public class DefinitionOverview extends TestBase {
	WebDriver driver = null;
	int index;

	@FindBy(xpath = "//a[contains(text(),'Definitions')]")
	WebElement definition;

	@FindBy(xpath = "//span[contains(text(),'Create New Definition')]")
	WebElement createDefinitionButton;

	@FindBy(xpath = "//input[@id='definitionName']")
	WebElement processDefinitionName;

	@FindBy(xpath = "//span[contains(text(),'Create New Definition')]")
	WebElement clickCreateNewDefinitionButton;

	@FindBy(xpath = "//textarea[@name='definitionDescription']")
	WebElement description;

	@FindBy(xpath = "(//button[@class='btn btn-default save-draft-btn'])[2]")
	WebElement saveButton;

	@FindAll({ @FindBy(xpath = "(//div[@class='primary-text'])") })
	List<WebElement> definitionList;
	
	@FindAll({ @FindBy(xpath = "(//div[@class='secondary-text'])") })
	List<WebElement> descriptionList;

	@FindAll({ @FindBy(xpath = "(//div[@class='icon-ellipsis-vert'])") })
	List<WebElement> hamburgerIconList;

	@FindAll({ @FindBy(xpath = "(//li/a/span/i[@class='icon-pencil-3 popover-icon'])") })
	List<WebElement> editIconList;

	@FindAll({ @FindBy(xpath = "//li/a[@class='text-danger']") })
	List<WebElement> deleteIconList;

	@FindBy(xpath = "//span[contains(text(),'Save Draft')]")
	WebElement clickSaveButton;

	@FindBy(xpath = "//span[contains(text(),'Close')]")
	WebElement closeButton;

	@FindBy(xpath = "//button[contains(text(),'Yes')]")
	WebElement yesButton;

	@FindBy(xpath = "//button[@class='ajs-button ajs-cancel']")
	WebElement noButton;

	@FindBy(xpath = "//div[@class='toast toast-success']")
	WebElement successToasterMsg;

	@FindBy(xpath = "//button[contains(text(),'Ok')]")
	WebElement okButton;

	@FindBy(xpath = "(//div[contains(text(),'Total:')])")
	WebElement totalDefinitionCount;

	@FindAll({ @FindBy(xpath = "(//span[@class='popover-elipsis']/following-sibling::div[1])") })
	List<WebElement> chevronIconList;

	@FindAll({ @FindBy(xpath = "//table[@class='undefined']/tbody/tr/td[1]") })
	List<WebElement> processList;
	
	String badgeCount = "((//div[@class='col-xs-4 col-sm-2 col-md-1 col-lg-1 no-padding text-center definition-type'])[";
	String badgeCountValue = "]/span[@class='badge'])";
	String successToaster = "//div[@class='toast toast-success']";

	/**
	 * Definition page
	 * 
	 * @param driver
	 *            the driver
	 */
	public DefinitionOverview(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}

	/**
	 * get Definition Text
	 * 
	 * @return Definition text
	 */
	public String getCreateButtonText() {
		return createDefinitionButton.getText();

	}

	/**
	 * get Definition List
	 */
	public List<WebElement> getDefinitionList() {
		return definitionList;
	}

	/**
	 * navigate To definition
	 */
	public void navigateToDefinition() {
		wait(2);
		definition.click();
		wait(3);
	}

	/**
	 * checks if yes button is enable
	 */
	public boolean isYesEnabled() {
		return yesButton.isEnabled();
	}

	/**
	 * checks if No button is enable
	 */
	public boolean isNoEnabled() {
		return noButton.isEnabled();
	}

	/**
	 * Set set Definition Name in textbox
	 * 
	 * @param strUserName
	 */

	public void setDefinitionName(String strDefinitionName) {
		processDefinitionName.clear();
		processDefinitionName.sendKeys(strDefinitionName);
		wait(2);
	}

	/**
	 * Set set Definition Name in textbox
	 * 
	 * @param strUserName
	 */

	public void setDescription(String strDescription) {
		description.clear();
		description.sendKeys(strDescription);
		wait(2);
	}

	/**
	 * click hamburger icon
	 */
	public void clickHamburgerIcon(int location) throws InterruptedException {
		wait(3);
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);", hamburgerIconList.get(location));
		hamburgerIconList.get(location).click();
		wait(3);
	}

	/**
	 * clicks on Delete button
	 */
	public void clickOnDelete(int location) throws InterruptedException {
		waitForElementVisible(deleteIconList.get(location), 5);
		deleteIconList.get(location).click();
		wait(2);
	}

	/**
	 * clicks on Edit button
	 */
	public void clickOnEdit(int location) throws InterruptedException {
		waitForElementVisible(editIconList.get(location), 5);
		editIconList.get(location).click();
		wait(2);
	}

	/**
	 * clicks on close button
	 */
	public void clickClose() throws InterruptedException {
		closeButton.click();
		wait(3);
	}

	/**
	 * clicks on yesy button
	 */
	public void clickYes() throws InterruptedException {
		yesButton.click();
		wait(1);
	}

	/**
	 * clicks on No button
	 */
	public void clickNo() throws InterruptedException {
		noButton.click();
		wait(3);
	}

	/**
	 * Deletes the definition
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void deleteDefinition(String defName) throws IOException, InterruptedException {
		int index = getDefinitionIndex(defName);
		clickHamburgerIcon(index - 1);
		clickOnDelete(index - 1);
		clickYes();
	}

	/**
	 * Navigates to Edit definition page
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void editDefinition(String defName) throws IOException, InterruptedException {
		int index = getDefinitionIndex(defName);
		clickHamburgerIcon(index - 1);
		clickOnEdit(index - 1);
	}

	/**
	 * click No on Delete Popup
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void clickNoOnDeletePopup(String defName) throws IOException, InterruptedException {
		int index = getDefinitionIndex(defName);
		clickHamburgerIcon(index - 1);
		clickOnDelete(index - 1);
		clickNo();
	}

	/**
	 * clicks ok on Delete Popup the schedule
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void clickOkOnDeletePopup(String defName) throws IOException, InterruptedException {
		int index = getDefinitionIndex(defName);
		clickHamburgerIcon(index - 1);
		clickOnDelete(index - 1);
		clickOK();
	}

	/**
	 * Verification for success message toaster
	 * 
	 * @throws InterruptedException
	 */
	public void verifySuccessDeleteToasterMsg() throws InterruptedException {
		String expectedSucessMsg = definitionPageProp.getProperty("expectedSuccessDeletionMsg");
		String actualSuccessMsg = getSuccessToasterMsg();
		Assert.assertTrue(compareTextContains(actualSuccessMsg, expectedSucessMsg), "Success message not displayed");
	}

	/**
	 * gets success toaster message
	 */
	public String getSuccessToasterMsg() throws InterruptedException {
		waitForElementToBePresent(successToaster, 5);
		waitForElementVisible(successToasterMsg, 5);
		return successToasterMsg.getText();
	}

	/**
	 * clicks on Ok button
	 */
	public void clickOK() throws InterruptedException {
		okButton.click();
		wait(3);
	}

	/**
	 * clicks on Create New Definition button
	 */
	public void clickCreateNewDefinitionButton() {
		clickCreateNewDefinitionButton.click();
		wait(1);
	}

	/**
	 * clicks on Save button
	 */
	public void clickSaveButton() {
		clickSaveButton.click();
		wait(2);
	}

	/**
	 * checks if create Process Definition Button Is Clickable
	 */
	public void createProcessDefinitionButtonIsClickable() throws InterruptedException {
		log.info("create Process Definition Button Is Clickable - Begin");
		Assert.assertTrue(isElementDisplayed(createDefinitionButton), "Create New Definition button is not displayed");
		Assert.assertTrue(isElementEnabled(createDefinitionButton), "Create New Definition button is not clickable");
		log.info("create Process Definition Button Is Clickable - End");
	}

	/**
	 * gets total definition count
	 */
	public String getDefinitionCount() {
		String totalDefinition = totalDefinitionCount.getText();
		String[] originalDefinitionPathArray = totalDefinition.split(": ");
		String totalCount = originalDefinitionPathArray[1];
		return totalCount;
	}

	/**
	 * gets definition list count
	 */
	public int getDefinitionSize() {
		int count = 0;
		for (WebElement definition : definitionList) {
			count++;

		}
		return count;

	}

	/**
	 * compares count
	 */
	public void compareCounts() {
		String totalCount = getDefinitionCount();
		Integer count = getDefinitionSize();
		String defCount = Integer.toString(count);
		if (totalCount.equals(defCount)) {
			log.info("Definition count is :" + totalCount);
		} else {
			log.info("Definition not counted");
		}
	}

	/**
	 * gets Badge Count
	 */
	public String getBadgeCount(int number) throws InterruptedException {
		String actualbadgeCount = badgeCount + number + badgeCountValue;
		return driver.findElement(By.xpath(actualbadgeCount)).getText();
	}

	/**
	 * checks badge Count Is Displayed
	 */
	public boolean isBadgeCountDisplayed(int number) throws InterruptedException {
		String actualbadgeCount = badgeCount + number + badgeCountValue;

		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		try {
			return (driver.findElements(By.xpath(actualbadgeCount)).size()) > 1;
		} finally {
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		}

	}

	/**
	 * clicks on Chevron Icon
	 */
	public void clickChevronIcon(int number) throws InterruptedException {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);", chevronIconList.get(number));
		chevronIconList.get(number).click();
		wait(1);
	}

	/**
	 * get Associated Process Name
	 */
	public String getFirstAssociatedProcessName() {
		log.info("Size of list: " + processList.size());
		return processList.get(0).getText();
	}

	/**
	 * clicks On Definition Chevron Icon
	 */
	public void clickOnDefinitionChevronIcon(String defName) throws IOException, InterruptedException {
		int index = getDefinitionIndex(defName);
		clickChevronIcon(index - 1);
	}
	
	/**
	 * verify Toaster Message After publish
	 * 
	 * @throws InterruptedException
	 */
	public void verifyToasterMsgOnPublishAfterSave() throws InterruptedException {
		String actualValidationMsg = getSuccessToasterMsg();
		String expectedValidationMsg = definitionPageProp.getProperty("expectedSuccessToasterMsgOnPublishAfterSave");
		Assert.assertTrue(compareTextContains(actualValidationMsg, expectedValidationMsg),
				"Success message after publish is not displayed");
	}
	
	/**
	 * verify Toaster Message After publish
	 * 
	 * @throws InterruptedException
	 */
	public void verifyToasterMsgOnPublish() throws InterruptedException {
		String actualValidationMsg = getSuccessToasterMsg();
		String expectedValidationMsg = definitionPageProp.getProperty("expectedSuccessToasterMsgOnPublish");
		Assert.assertTrue(compareTextContains(actualValidationMsg,expectedValidationMsg),
				"Success message after publish is not displayed");
	}

	/**
	 * gets Definition Index
	 */
	public int getDefinitionIndex(String dname) throws IOException, InterruptedException {
		String definitionName = dname;

		int count = 0;
		for (WebElement definition : definitionList) {

			count++;
			if ((definition.getText()).equalsIgnoreCase(definitionName)) {
				log.info("Definition Added successfully");

				break;
			}
		}

		return count;
	}
	
	/**
	 * deletes Definition If Already Exists
	 */
	public void deleteDefinitionIfAlreadyExists(String definitionName) throws IOException, InterruptedException {
		boolean flag = false;
		for (WebElement definition : definitionList) {
			if ((definition.getText()).equalsIgnoreCase(definitionName)) {
				log.info("Definition is present");
                flag =true;
			}
		}
		if (flag==true){
			deleteDefinition(definitionName);
			wait(1);
		}
	}
	
	/**
	 * gets Definition Index
	 */
	public boolean checksWhetherDefinitionDeleted(String dname) throws IOException, InterruptedException {
		String definitionName = dname;
		boolean flag = true;
		for (WebElement definition : definitionList) {
			if ((definition.getText()).equals(definitionName)) {
				flag =false;
				break;
			}
		}
		return flag;
	}
	
	/**
	 * Verification for delete Definition
	 */
	public void verifyDeleteDefinition(String definitionName) throws IOException, InterruptedException  {
		log.info("Verification for delete Definition- Begin! ");
		Assert.assertTrue(checksWhetherDefinitionDeleted(definitionName),"Error in deleting definition");
		log.info("Verification for delete Definition- End! ");
	}
	
	/**
	 * Verification for created Definition name
	 */
	public void verifyNameForCreatedDefinition(String expectedDefinitionName) throws IOException, InterruptedException  {
		log.info("Verification for created Definition name- Begin! ");
		String actualDefinitionName = definitionList.get(getDefinitionIndex(expectedDefinitionName) - 1).getText();
		Assert.assertEquals(actualDefinitionName, expectedDefinitionName, "Name not found on Definition overview page");
		log.info("Verification for created Definition name- End! ");
	}
	
	/**
	 * Verification for created Definition description
	 */
	public void verifyDescriptionForCreatedDefinition(String givenDefinitionName, String expectedDefinitionDescription)throws IOException, InterruptedException, AWTException 
	{
		log.info("Verification for created Definition description- Begin! ");
		int count = getDefinitionIndex(givenDefinitionName);
		String actualDescription = descriptionList.get(count - 1).getText();
		Assert.assertEquals(actualDescription, expectedDefinitionDescription,
				"Description not found on Definition overview page");
		log.info("Verification for created Definition description- End! ");
	}
}