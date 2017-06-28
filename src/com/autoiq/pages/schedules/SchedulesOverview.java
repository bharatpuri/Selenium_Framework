package com.autoiq.pages.schedules;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
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
 * The Class Overview Page.
 */
public class SchedulesOverview extends TestBase {
	WebDriver driver = null;
	int index;

	@FindBy(xpath = "//a[contains(text(),' Schedules')]")
    WebElement schedule;

	@FindBy(xpath = "//span[contains(text(),'Create New Schedule')]")
	WebElement createScheduleButton;

	@FindBy(xpath = "//button[@class='btn btn-default']")
	WebElement cancelButton;
	
	@FindAll({ @FindBy(xpath = "(//div[@class='primary-text'])") })
	List<WebElement> scheduleList;
	
	@FindAll({ @FindBy(xpath = "(//div[@class='primary-text']/following-sibling::div[1])") })
	List<WebElement> descriptionList;
	
	@FindBy(xpath = "//div[@class='toast toast-success']")
	WebElement successToasterMsg;
	
	@FindAll({ @FindBy(xpath = "(//span[@class='icon-ellipsis-vert'])") })
	List<WebElement> hamburgerIconList;
			
	@FindAll({ @FindBy(xpath = "(//i[@class='icon-pencil-3 popover-icon'])") })
	List<WebElement> editIconList;
	
	@FindAll({ @FindBy(xpath = "(//a[@class='text-danger'])") })
	List<WebElement> deleteIconList;
	
	@FindAll({ @FindBy(xpath = "(//span[@class='badge'])") })
	List<WebElement> badgeList;
	
	@FindAll({ @FindBy(xpath = "(//span[@class='icon-ellipsis-vert']/following-sibling::div[1])") })
	List<WebElement> chevronIconList;
	
	@FindBy(xpath = "//button[@class='ajs-button ajs-cancel']")
	WebElement noButton;
	
	@FindBy(xpath = "//button[@class='ajs-button ajs-ok'][contains(text(),'Yes')]")
	WebElement yesButton;
	
	@FindBy(xpath = "//button[@class='ajs-button ajs-ok'][contains(text(),'Ok')]")
	WebElement okButton;
	
	@FindBy(xpath = "(//div[@class='col-xs-12 col-sm-12 col-md-7 col-lg-6 no-padding text-center time-range-band'])")
	WebElement activeDays;
	
	@FindBy(xpath = "//div/h4[contains(text(),'This schedule cannot be deleted because it has 1 processes assigned to it.')]")
    WebElement popupContent;
	
	@FindAll({ @FindBy(xpath = "//table[@class='undefined']/tbody/tr/td[1]") })
	List<WebElement> processList;
	
	String activeDayXpath = "(//div[@class='col-xs-12 col-sm-12 col-md-7 col-lg-6 no-padding text-center time-range-band'])[";
	
	String activeDayIndex= "]/div[@class='time-range active']/div[@class='day']";
	
	String activeStartTimeIndex=  "]/div[@class='time-range active']/div[@class='start']";
	
	String activeEndTimeIndex=  "]/div[@class='time-range active']/div[@class='end']";
	
	@FindBy(xpath = "(//div/h4[contains(text(),'This update will impact all associated processes. Do you want to proceed?')])")
    WebElement editConfirmation;
	
	String scheduleName=  "(//div[@class='primary-text'])[";
	
	String followingDesc=  "]/following-sibling::div[1]";
	
	String successToaster = "//div[@class='toast toast-success']";
	
	/**
	 * Schedule Page
	 * 
	 * @param driver
	 *            the driver
	 */
	public SchedulesOverview(WebDriver driver) 	{
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}

	/**
	 * get Schedule Text
	 * 
	 * @return Schedule text
	 */
	public String getScheduleText()  {
		return schedule.getText();
	}

	/**
	 * click Create New Schedule Button
	 */
	public void clickCreateNewScheduleButton()  {
		waitForElementVisible(createScheduleButton, 3);
		createScheduleButton.click();
	}
	/**
	 * click Cancel Button
	 */
	public void clickCancelButton() throws InterruptedException  {
		cancelButton.click();
		wait(1);
	}
	
	/**
	 * get toaster success message
	 * 
	 */
	
	public String getToasterSuccessMsg()  {
		waitForElementToBePresent(successToaster, 5);
		waitForElementVisible(successToasterMsg, 5);
		 return successToasterMsg.getText();
		
		} 
	
	/**
	 * get create button text
	 * 
	 */
	
	public String getCreateButtonText()  {
		 return createScheduleButton.getText();
		
		} 
	
	/**
	 * checks if create Schedule Button Is Clickable
	 */
	public boolean createScheduleButtonIsClickable() throws InterruptedException {
		return isElementEnabled(createScheduleButton);
	}
	
	/**
	 * click hamburger icon
	 */
	public void clickHamburgerIcon(int location) throws InterruptedException 
	{
		wait(3);
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);", hamburgerIconList.get(location));
		hamburgerIconList.get(location).click();
		wait(1);
	}
	
	/**
	 * click chevron icon
	 */
	public void clickChevronIcon(int location) throws InterruptedException 
	{
		wait(3);
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);", hamburgerIconList.get(location));
		chevronIconList.get(location).click();
		wait(1);
	}
	
	/**
	 * click Delete link
	 */
	public void clickDeleteLink(int location) throws InterruptedException 
	{
		deleteIconList.get(location).click();
		wait(1);
	}
	
	/**
	 * click Edit link
	 */
	public void clickEditLink(int location) throws InterruptedException 
	{
		editIconList.get(location).click();
		wait(1);
	}
	
	/**
	 * click ok Button on Delete popup
	 */
	public void clickOkButton() throws InterruptedException 
	{
		okButton.click();
		wait(1);
	}
	
	/**
	 * click yes Button on Delete popup
	 */
	public void clickYesButton() throws InterruptedException 
	{
		yesButton.click();
		wait(1);
	}
	
	/**
	 * click No Button on Delete popup
	 */
	public void clickNoButton() throws InterruptedException 
	{
		noButton.click();
		wait(1);
	}
	
	 /**
     * get popup message
     */
    public String getPopupMsg() throws InterruptedException 
    {
        wait(1);
        return popupContent.getText();
    }
	
	/**
	 * get Active Days
	 */
		
	public List<WebElement> getActiveDays(int index) throws InterruptedException  {
		log.info("actday:"+activeDayXpath+index+activeDayIndex);
		  return driver.findElements(By.xpath(activeDayXpath+index+activeDayIndex)); 
	}
	/**
	 * get Active Start Time
	 */
	public List<WebElement> getActiveStartTime(int index) throws InterruptedException  {
		log.info("actday:"+activeDayXpath+index+activeStartTimeIndex);
		  return driver.findElements(By.xpath(activeDayXpath+index+activeStartTimeIndex)); 
	}
	/**
	 * get Active End Time
	 */
	public List<WebElement> getActiveEndTime(int index) throws InterruptedException 
	{
		log.info("actday:"+activeDayXpath+index+activeEndTimeIndex);
		  return driver.findElements(By.xpath(activeDayXpath+index+activeEndTimeIndex)); 
	}
	
	/**
	 * get getAssociatedProcessName
	 */
	public String getFirstAssociatedProcessName(){
		log.info("Size of list: "+processList.size());
		return processList.get(0).getText();
	}
		
	/**
	 * get schedule index
	 */
	public int getScheduleIndex(String scheduleName) throws IOException, InterruptedException  {

		int count = 0;
		for (WebElement schedule : scheduleList) {
			count++;
			if ((schedule.getText()).equalsIgnoreCase(scheduleName)) {
				log.info("Schedule Added successfully");
				break;
			}
		}
		return count;
	}

	/**
	 * deletes Schedule If Already Exists
	 */
	public void deleteScheduleIfAlreadyExists(String scheduleName) throws IOException, InterruptedException {
		boolean flag = false;
		for (WebElement schedule : scheduleList) {
			if ((schedule.getText()).equalsIgnoreCase(scheduleName)) {
				log.info("Schedule is present");
                flag =true;
			}
		}
		if (flag==true){
			deleteSchedule(scheduleName);
			wait(1);
		}
	}
	
	/**
	 * Verification for created schedule name
	 */
	public void verifyNameForCreatedSchedule(String expectedScheduleName) throws IOException, InterruptedException  {
		log.info("Verification for created schedule name- Begin! ");
		String actualScheduleName = scheduleList.get(getScheduleIndex(expectedScheduleName) - 1).getText();
		Assert.assertEquals(actualScheduleName, expectedScheduleName, "Name not found on schedule overview page");
		log.info("Verification for created schedule name- End! ");
	}
	/**
	 * Verification for created schedule description
	 */
	
	public void verifyDescriptionForCreatedSchedule(String givenScheduleName, String expectedScheduleDescription)throws IOException, InterruptedException, AWTException 
	{
		log.info("Verification for created schedule description- Begin! ");
		int count = getScheduleIndex(givenScheduleName);
		log.info("Count: " + count);
		log.info("actday:"+scheduleName+count+followingDesc);
		WebElement description = driver.findElement(By.xpath(scheduleName+count+followingDesc));
		String actualDescription = description.getText(); 
		Assert.assertEquals(actualDescription, expectedScheduleDescription,
				"Description not found on schedule overview page");
		log.info("Verification for created schedule description- End! ");
	}

	/**
	 * Verification for created schedule selected days
	 */
	public void verifySelectedDaysForCreatedSchedule(String givenScheduleName, List<String> expectedDays)throws IOException, InterruptedException  {
		log.info("Verification for created schedule selected days- Begin! ");
		int count = getScheduleIndex(givenScheduleName);
		log.info("days count: " + count);
		List<WebElement> days = getActiveDays(count);
		List<String> x = new ArrayList<String>();
		for (WebElement day : days) {
			x.add(day.getText());
		}
		log.info("Actual days:" + x);
		log.info("Expected days:" + expectedDays);
		Assert.assertEquals(x, expectedDays, "Selected Days not found on schedule overview page");
	log.info("Verification for created schedule selected days- End! ");
	}

	/**
	 * Verification for created schedule starttime
	 */
	public void verifyStarttimeForCreatedSchedule(String givenScheduleName, List<String> expectedStarttime)throws IOException, InterruptedException  {
	log.info("Verification for created schedule starttime- Begin! ");
		int count = getScheduleIndex(givenScheduleName);
		List<WebElement> starttime = getActiveStartTime(count);
		List<String> y = new ArrayList<String>();
		for (WebElement strttime : starttime) {
			y.add(strttime.getText());
			log.info("Fetched start time :"+strttime.getText());
		}
		Assert.assertEquals(y, expectedStarttime, "Selected starttime not found on schedule overview page");
		log.info("Verification for created schedule starttime- End! ");
	}

	/**
	 * Verification for created schedule endtime
	 */
	public void verifyEndtimeForCreatedSchedule(String givenScheduleName, List<String> expectedEndtime)throws IOException, InterruptedException, AWTException  {
		log.info("Verification for created schedule endtime- Begin! ");
		int count = getScheduleIndex(givenScheduleName);
		List<WebElement> endtime = getActiveEndTime(count);
		List<String> z = new ArrayList<String>();
		for (WebElement edtime : endtime) {
			z.add(edtime.getText());
		}
		Assert.assertEquals(z, expectedEndtime, "Selected Endtime not found on schedule overview page");
		log.info("Verification for created schedule endtime- End! ");
	}
	
	/**
	 * Verification for success message toaster
	 * @throws InterruptedException 
	 */
	public void verifySuccessToasterMsg(String expectedSucessMsg) throws InterruptedException  {
		log.info("Success Message: "+getToasterSuccessMsg());
		String actualSuccessMsg = getToasterSuccessMsg();
		Assert.assertTrue(compareTextContains(actualSuccessMsg,expectedSucessMsg),"Success message not displayed");
	}
	
	/**
	 * Deletes the schedule
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	public void deleteSchedule(String schName) throws IOException, InterruptedException  {
		int index = getScheduleIndex(schName);
		clickHamburgerIcon(index-1);
		clickDeleteLink(index-1);
		clickYesButton();
	}
	
	/**
	 * verify delete popup for schedule with processes assigned
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	public void verifyDeletePopup(String schName, String expectedPopupMsg) throws IOException, InterruptedException  {
		int index = getScheduleIndex(schName);
		clickHamburgerIcon(index-1);
		clickDeleteLink(index-1);
		//log.info("BeforeWait:"+popupContent);
        wait(2);
        //log.info("AfterWait:"+popupContent);
        String actualPopupMsg = popupContent.getText();
        Assert.assertTrue(compareTextContains(actualPopupMsg,expectedPopupMsg),"Proper message is not displayed on popup");
        
		clickOkButton();
	}
	
	/**
	 * get count of processes associated with schedule
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	public int getProcessCountForSchedule(String schName) throws IOException, InterruptedException  {
		int index = getScheduleIndex(schName);
		String processCountForSchedule = badgeList.get(index-1).getText();
		return Integer.parseInt(processCountForSchedule);
	}
	
	/**
	 * Clicks on the chevron icon
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	public void clickOnScheduleChevronIcon(String schName) throws IOException, InterruptedException  {
		int index = getScheduleIndex(schName);
		clickChevronIcon(index-1);
	}
	
	/**
     * Get edit confirmation msg
     * @throws InterruptedException 
     * @throws IOException 
     */
    public String getEditConfirmationMsg() throws InterruptedException 
    {
        return editConfirmation.getText();
    }
}
