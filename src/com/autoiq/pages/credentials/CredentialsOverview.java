package com.autoiq.pages.credentials;

import java.io.IOException;
import java.util.List;

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
 * The Class CredentialsOverview Page.
 */
public class CredentialsOverview extends TestBase {
	WebDriver driver = null;
	int index;

	@FindBy(xpath = "(//span[@class='icon-plus icon-color'])[1]")
	WebElement addCredentialGroupButton;
	
	@FindBy(xpath = "(//span[@class='icon-plus icon-color'])[2]")
	WebElement addApplicationsButton;
	
	@FindBy(xpath = "(//span[@class='icon-plus icon-color'])[3]")
	WebElement addHostGroupButton;
	
	@FindBy(xpath = "//button[@class='btn btn-default']")
	WebElement cancelAddCredentialGroupButton;

	@FindBy(xpath = "//input[@id='credentialGroupName']")
	WebElement credentialGroupName;
	
	@FindBy(xpath = "//input[@id='CredentialUserID']")
	WebElement credentialName;
	
	@FindBy(xpath = "//input[@id='CredentialPassword']")
	WebElement credentialPassword;
	
	@FindBy(xpath = "//input[@id='expiryDate']")
	WebElement expiryDate;
	
	@FindBy(xpath = "(//input[@name='runOnce'])[1]")
	WebElement status;

	@FindBy(xpath = "(//a[@data-handler='next'])")
	WebElement nextMonth;
	
	@FindAll({ @FindBy(xpath = "(//table[@class='ui-datepicker-calendar']//td)") })
	public List<WebElement> all_Dates;
	
	@FindBy(xpath = "//textarea[@name='credentialGroupDescription']")
	WebElement description;

	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement saveButton;
	
	@FindAll({ @FindBy(xpath = "(//div[@class='col-xs-10 group-title'])") })
	List<WebElement> credentialGroupList;
	
	@FindAll({ @FindBy(xpath = "//div[@class='container-fluid']/div[6]/div/div/div/autoiq-datatable/p-datatable/div/div/table/tbody/tr/td[1]/span") })
	List<WebElement> credentialList;
	
	@FindBy(xpath = "(//div[@class='alert-danger small custom-error'])")
	WebElement nameValidationMsg;
	
	@FindAll({ @FindBy(xpath = "//div[@id='credentialGroupWidget']/div/autoiq-tools-group/div/div/div/div/div/div[3]/span") })
	List<WebElement> hamburgerCredentialGrpIconList;
	
	@FindAll({ @FindBy(xpath = "(//div[@class='container-fluid']/div[6]/div/div/div/autoiq-datatable/p-datatable/div/div/table/tbody/tr/td[4]/span/span/div[@class='icon-ellipsis-vert'])") })
	List<WebElement> hamburgerCredentialIconList;
	
	String commonCredentialXpath = "(//div[@class='container-fluid']/div[";
	String credentialHamburger = "]/div/div/div/autoiq-datatable/p-datatable/div/div/table/tbody/tr/td[4]/span/span/div[@class='icon-ellipsis-vert'])";
    String credentialDelete ="]/div/div/div/autoiq-datatable/p-datatable/div/div/table/tbody/tr/td[4]/span/span/popover-content/div/div/ul/li[2])";
    String credentialEdit ="]/div/div/div/autoiq-datatable/p-datatable/div/div/table/tbody/tr/td[4]/span/span/popover-content/div/div/ul/li[1])";
	
	@FindAll({ @FindBy(xpath = "//div[@class='container-fluid']/div/div/div/div/span[@class='icon-angle-down icon-angle' or @class='icon-angle-down icon-angle disabled']") })
	List<WebElement> expandCredentialGrpIconList;

	@FindAll({ @FindBy(xpath = "(//div/ul/li[3]/a[@class='text-danger'])") })
	List<WebElement> deleteCredentailGrpIconList;
	
	@FindAll({ @FindBy(xpath = "//div[@class='container-fluid']/div[6]/div/div/div/autoiq-datatable/p-datatable/div/div/table/tbody/tr/td[4]/span/span/popover-content/div/div/ul/li[2]") })
	List<WebElement> deleteCredentailIconList;
	
	@FindAll({ @FindBy(xpath = "(//div/span/popover-content/div/div/ul/li[1]/a/span/i[@class='icon-plus popover-icon'])") })
	List<WebElement> addCredentailIconList;
	
	@FindAll({ @FindBy(xpath = "(//div/ul/li[2]/a[@class='text-danger'])") })
	List<WebElement> deleteApplicationIconList;

	@FindBy(xpath = "//span[contains(text(),'Save Draft')]")
	WebElement clickSaveButton;

	@FindBy(xpath = "//button[contains(text(),'Yes')]")
	WebElement yesButton;

	@FindBy(xpath = "//div[@class='toast toast-success']")
	WebElement successToasterMsg;
	
	String successToaster = "//div[@class='toast toast-success']";

	/**
	 * Credential Overview page
	 * 
	 * @param driver
	 *            the driver
	 */
	public CredentialsOverview(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}

	/**
	 * Click on add Credential Group Button
	 */
	public void clickAddCredentialGroupButton() {
		wait(2);
		addCredentialGroupButton.click();
		wait(3);
	}
	
	/**
	 * Click on Cancel button on add Credential Group page
	 */
	public void clickCancelAddCredentialGroupButton() {
		wait(2);
		cancelAddCredentialGroupButton.click();
		wait(3);
	}

	/**
	 * checks if add Credential Groups Button is displayeds
	 */
	public boolean isaddCredentialsGroupDisplayed() {
		return addCredentialGroupButton.isDisplayed();
	}
	
	/**
	 * checks if add Applications Button is displayed
	 */
	public boolean isaddApplicationsDisplayed() {
		return addApplicationsButton.isDisplayed();
	}
	
	/**
	 * checks if add Host Groups Button is displayed
	 */
	public boolean isaddHostGroupDisplayed() {
		return addHostGroupButton.isDisplayed();
	}

	/**
	 * Set Credential Group Name in textbox
	 * 
	 * @param strUserName
	 */

	public void setCredentialGroupName(String strCredentialGroupName) {
		credentialGroupName.clear();
		credentialGroupName.sendKeys(strCredentialGroupName);
	}

	/**
	 * Set Description in textbox
	 * 
	 * @param strUserName
	 */

	public void setDescription(String strDescription) {
		description.clear();
		description.sendKeys(strDescription);
	}
	
	/**
	 * Set Credential Name in textbox
	 * 
	 * @param strUserName
	 */

	public void setCredentialName(String strCredentialName) {
		credentialName.clear();
		credentialName.sendKeys(strCredentialName);
	}
	
	/**
	 * Set Credential Name in textbox
	 * 
	 * @param strUserName
	 */

	public void setCredentialPassword(String strCredentialPassword) {
		credentialPassword.clear();
		credentialPassword.sendKeys(strCredentialPassword);
	}
	
	/**
	 * returns Credential Group Name in textbox
	 */

	public String getCredentialGroupNameText() {
		String inputText = credentialGroupName.getAttribute("value");
		if (inputText.length() == 0) {
			return credentialGroupName.getAttribute("placeholder");
		} else {
			return inputText;
		}
	}
	
	/**
	 * returns Credential Group description in textbox
	 */

	public String getCredentialGroupDescriptionText() {
		String inputText = description.getAttribute("value");
		if (inputText.length() == 0) {
			return description.getAttribute("placeholder");
		} else {
			return inputText;
		}
	}
	
	/**
	 * clicks on Save button
	 */
	public void clickSaveButton() {
		saveButton.click();
		wait(2);
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
	 * Deletes the credential Group
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void deleteCredentialGroup(String cgname) throws IOException, InterruptedException {
		int index = getCredentialGroupIndex(cgname);
		clickHamburgerIcon(index - 1);
		clickOnDelete(index - 1);
		clickYes(credentialPageProp.getProperty("expectedSuccessCredentialGroupDeletionMsg"));
	}
	
	/**
	 * Deletes the credential
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void deleteCredential(String cgname,String cname) throws IOException, InterruptedException {
		int cgroupIndex = getCredentialGroupIndex(cgname);
		int cindex = getCredentialIndex(cname);
		clickCredentialHamburgerIcon(cgroupIndex,cindex);
		clickOnDeleteCredential(cgroupIndex,cindex);
		clickYes(credentialPageProp.getProperty("expectedSuccessCredentialDeletionMsg"));
	}
	
	/**
	 * Edits the credential
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void editCredential(String cgname,String cname) throws IOException, InterruptedException {
		int cgroupIndex = getCredentialGroupIndex(cgname);
		int cindex = getCredentialIndex(cname);
		clickCredentialHamburgerIcon(cgroupIndex,cindex);
		clickOnEditCredential(cgroupIndex,cindex);
	}
	
	/**
	 * Deletes the Expand credential Group
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void clickExpandCredentialGroup(String cgname) throws IOException, InterruptedException {
		int index = getCredentialGroupIndex(cgname);
		clickDownArrowIcon(index-1);
		wait(1);
	}
	
	/**
	 * Adds new credential to the credential Group
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void AddCredential(String cgname) throws IOException, InterruptedException {
		int index = getCredentialGroupIndex(cgname);
		clickHamburgerIcon(index - 1);
		clickOnAddCredential(index - 1);
	}
	
	/**
	 * gets Credential Group Index
	 */
	public int getCredentialGroupIndex(String cgname) throws IOException, InterruptedException {
		String credentialGroupName = cgname;
		int count = 0;
		for (WebElement credentialGroup : credentialGroupList) {
			count++;
			if ((credentialGroup.getText()).equalsIgnoreCase(credentialGroupName)) {
				log.info("Credential Group Added successfully");
				break;
			}
		}
		return count;
	}
	
	/**
	 * gets Credential Index
	 */
	public int getCredentialIndex(String cname) throws IOException, InterruptedException {
		String credentialName = cname;
		int count = 0;
		for (WebElement credential : credentialList) {
			count++;
			if ((credential.getText()).equalsIgnoreCase(credentialName)) {
				log.info("Credential Added successfully");
				break;
			}
		}
		return count;
	}
	
	/**
	 * Verification for delete Credential Group
	 */
	public void verifyDeleteCredentialGroup(String cgname) throws IOException, InterruptedException  {
		log.info("verify Delete Credential Group - Begin");
		Assert.assertTrue(checksWhetherCredentialGroupDeleted(cgname),"Error in deleting definition");
		log.info("verify Delete Credential Group - End");
	}
	
	/**
	 * checks Whether Credential Group Deleted
	 */
	public boolean checksWhetherCredentialGroupDeleted(String cgname) throws IOException, InterruptedException {
		String credentialGroupName = cgname;
		boolean flag = true;
		for (WebElement credentialGroup : credentialGroupList) {
			if ((credentialGroup.getText()).equals(credentialGroupName)) {
				flag =false;
				break;
			}
		}
		return flag;
	}
	
	/**
	 * click hamburger icon
	 */
	public void clickHamburgerIcon(int location) throws InterruptedException {
		wait(1);
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);", hamburgerCredentialGrpIconList.get(location));
		hamburgerCredentialGrpIconList.get(location).click();
		wait(2);
	}

	/**
	 * click hamburger icon
	 */
	public void clickCredentialHamburgerIcon(int cgindex, int cindex) throws InterruptedException {
		wait(1);
		String hamburgerXpath=commonCredentialXpath+cgindex+credentialHamburger;
		driver.findElements(By.xpath(hamburgerXpath)).get(cindex-1).click();
		wait(2);
	}

	
	/**
	 * click hamburger icon
	 */
	public void clickDownArrowIcon(int location) throws InterruptedException {
		wait(1);
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);", expandCredentialGrpIconList.get(location));
		expandCredentialGrpIconList.get(location).click();
		wait(2);
	}
	
	/**
	 * clicks on Delete Group button
	 */
	public void clickOnDelete(int location) throws InterruptedException {
		deleteCredentailGrpIconList.get(location).click();
		wait(1);
	}
	
	/**
	 * clicks on Delete button for Credential
	 */
	public void clickOnDeleteCredential(int cgindex,int cindex) throws InterruptedException {
		String deleteXpath=commonCredentialXpath+cgindex+credentialDelete;
		driver.findElements(By.xpath(deleteXpath)).get(cindex-1).click();
		wait(1);
	}
	
	/**
	 * clicks on Edit button for Credential
	 */
	public void clickOnEditCredential(int cgindex,int cindex) throws InterruptedException {
		String editXpath=commonCredentialXpath+cgindex+credentialEdit;
		driver.findElements(By.xpath(editXpath)).get(cindex-1).click();
		wait(1);
	}
	
	/**
	 * clicks on Add Credential button
	 */
	public void clickOnAddCredential(int location) throws InterruptedException {
		addCredentailIconList.get(location).click();
		wait(1);
	}
	
	/**
	 * gets name validation message
	 */
	public String getActualNameValidationMsg() throws InterruptedException {
		return nameValidationMsg.getText();

	}

	/**
	 * clicks on yes button
	 */
	public void clickYes(String deleteMsg) throws InterruptedException {
		isYesEnabled();
		yesButton.click();
		wait(1);
		String actualDeleteValidationMsg = getSuccessToasterMsg();
		Assert.assertTrue(compareTextContains(actualDeleteValidationMsg, deleteMsg),
				"Success message not displayed");
		wait(1);
	}
	
	/**
	 * clicks on Enabled option
	 */
	public void clickEnabled() throws InterruptedException {
		status.click();
		wait(1);
	}

	/**
	 * checks if yes button is enable
	 */
	public boolean isYesEnabled() {
		return yesButton.isEnabled();
	}
	
	/**
	 * Click on enter Start Date
	 * 
	 * @throws InterruptedException
	 */
	public void enterStartDate(String date) throws IOException, InterruptedException {
		expiryDate.click();
		wait(1);
		waitForElementVisible(nextMonth, 5);
		nextMonth.click();
		wait(1);
		for (WebElement all_Date : all_Dates) {
			if ((all_Date.getText()).equalsIgnoreCase(date)) {

				all_Date.click();
				log.info("Start date selected successfully");

				break;
			}
		}
		log.info("Start date: " + date);
		wait(1);
	}
}