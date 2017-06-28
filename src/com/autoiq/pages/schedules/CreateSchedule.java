package com.autoiq.pages.schedules;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.autoiq.base.TestBase;

/**
 * The Class CreateSchedulePage.
 */
public class CreateSchedule extends TestBase {
	WebDriver driver = null;
	String slider;
	public List<String> daysList;
	public List<String> startTime;
	public List<String> startTimeValue;
	public List<String> endTime;
	public List<String> endTimeValue;
	public List<String> startTimeOnUnChecking;
	public List<String> endTimeOnUnChecking;
	public List<String> startTimeOnChecking;
	public List<String> endTimeOnChecking;

	@FindBy(xpath = "//input[@id='ScheduleName']")
	public
	WebElement scheduleName;

	@FindBy(xpath = "//textarea[@name='scheduleDescription']")
	WebElement scheduledescription;

	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement saveButton;

	@FindBy(xpath = "//button[@class='btn btn-default']")
	WebElement cancelButton;

	@FindBy(xpath = "//input[@id='startDate']")
	WebElement startDate;

	@FindBy(xpath = "(//a[@data-handler='next'])")
	WebElement nextMonth;

	@FindBy(xpath = "//input[@id='endDate']")
	WebElement endDate;
	
	@FindBy(xpath = "(//span[@class='custom-delay-counters'])[1]")
	WebElement delayIntervalMinus;
	
	@FindBy(xpath = "(//span[@class='custom-delay-counters'])[2]")
	WebElement delayIntervalPlus;
	
	@FindBy(xpath = "//input[@id='delayInterval']")
	WebElement delayIntervalValue;

	@FindBy(xpath = "//input[@id='dailySchedule0']")
	WebElement mondayCheckbox;
	
	@FindBy(xpath = "//input[@id='dailySchedule1']")
	WebElement tuesdayCheckbox;

	@FindBy(xpath = "//input[@id='dailySchedule2']")
	WebElement wednesdayCheckbox;

	@FindBy(xpath = "//input[@id='dailySchedule3']")
	WebElement thursdayCheckbox;

	@FindBy(xpath = "//input[@id='dailySchedule4']")
	WebElement fridayCheckbox;

	@FindBy(xpath = "//input[@id='dailySchedule5']")
	WebElement saturdayCheckbox;

	@FindBy(xpath = "//input[@id='dailySchedule6']")
	WebElement sundayCheckbox;

	@FindBy(xpath = "//input[@id='dailySchedule0']/..")
	WebElement mondayText;

	@FindBy(xpath = "//input[@id='dailySchedule1']/..")
	WebElement tuesdayText;

	@FindBy(xpath = "//input[@id='dailySchedule2']/..")
	WebElement wednesdayText;

	@FindBy(xpath = "//input[@id='dailySchedule3']/..")
	WebElement thursdayText;

	@FindBy(xpath = "//input[@id='dailySchedule4']/..")
	WebElement fridayText;

	@FindBy(xpath = "//input[@id='dailySchedule5']/..")
	WebElement saturdayText;

	@FindBy(xpath = "//input[@id='dailySchedule6']/..")
	WebElement sundayText;

	@FindBy(xpath = "(//div[@class='custom-tooltip'])[1]")
	WebElement tooltip1;

	@FindBy(xpath = "(//div[@class='custom-tooltip'])[2]")
	WebElement tooltip2;

	@FindBy(xpath = "(//div[@class='custom-tooltip'])[3]")
	WebElement tooltip3;

	@FindBy(xpath = "(//div[@class='custom-tooltip'])[4]")
	WebElement tooltip4;

	@FindBy(xpath = "(//div[@class='custom-tooltip'])[5]")
	WebElement tooltip5;

	@FindBy(xpath = "(//div[@class='custom-tooltip'])[6]")
	WebElement tooltip6;

	@FindBy(xpath = "(//span[@style='left: 0%;'][@tabindex='0'])[1]")
	WebElement mon_starttime;

	@FindBy(xpath = "(//span[@style='left: 100%;'][@tabindex='0'])[1]")
	WebElement mon_endtime;

	@FindBy(xpath = "(//span[@style='left: 0%;'][@tabindex='0'])[2]")
	WebElement tue_starttime;

	@FindBy(xpath = "(//span[@style='left: 100%;'][@tabindex='0'])[2]")
	WebElement tue_endtime;

	@FindBy(xpath = "(//span[@style='left: 0%;'][@tabindex='0'])[3]")
	WebElement wed_starttime;

	@FindBy(xpath = "(//span[@style='left: 100%;'][@tabindex='0'])[3]")
	WebElement wed_endtime;

	@FindBy(xpath = "(//span[@style='left: 0%;'][@tabindex='0'])[4]")
	WebElement thur_starttime;

	@FindBy(xpath = "(//span[@style='left: 0%;'][@tabindex='0'])[3]")
	WebElement thur_endtime;

	@FindBy(xpath = "(//span[@style='left: 0%;'][@tabindex='0'])[5]")
	WebElement fri_starttime;

	@FindBy(xpath = "(//span[@style='left: 100%;'][@tabindex='0'])[5]")
	WebElement fri_endtime;

	@FindBy(xpath = "(//span[@style='left: 0%;'][@tabindex='0'])[6]")
	WebElement sat_starttime;

	@FindBy(xpath = "(//span[@style='left: 100%;'][@tabindex='0'])[6]")
	WebElement sat_endtime;

	@FindBy(xpath = "(//span[@style='left: 0%;'][@tabindex='0'])[7]")
	WebElement sun_starttime;

	@FindBy(xpath = "(//span[@style='left: 100%;'][@tabindex='0'])[7]")
	WebElement sun_endtime;

	@FindBy(xpath = "(//div[@class='alert-danger small custom-error'])[1]")
	WebElement actualNameValidationMsg;

	@FindBy(xpath = "//div[@class='toast toast-error']")
	WebElement errorToasterMsg;

	@FindBy(xpath = "(//div[@class='alert-danger small custom-error'])[4]")
	WebElement actualEnddateValidationMsg;

	@FindBy(xpath = "(//div[@class='alert-danger small custom-error'])[5]")
	WebElement actualSelectDayValidationMsg;

	@FindAll({ @FindBy(xpath = "(//table[@class='ui-datepicker-calendar']//td)") })
	public List<WebElement> all_Dates;

	@FindBy(xpath = "//label[@class='form-check-label btn btn-default no-margin-left pull-down-5']")
	WebElement moveAllSliderTogether;

	@FindBy(xpath = "(//span[@class='slider-label-margin-right'])[1]")
	WebElement leftSliderLabel;

	@FindBy(xpath = "(//span[@class='slider-label-margin-left'])[1]")
	WebElement rightSliderLabel;
	
	String errorToaster = "(//div[@class='toast toast-error'])";

	/**
	 * Instantiates a new Create Process page.
	 * 
	 * @param driver
	 *            the driver
	 */
	public CreateSchedule(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}

	/**
	 * Set set Schedule Name in textbox
	 * 
	 * @param strUserName
	 */

	public void setScheduleName(String strScheduleName) {
		scheduleName.clear();
		scheduleName.sendKeys(strScheduleName);
		wait(2);
	}
	
	/**
	 * gets Schedule Name value
	 */

	public String getScheduleNameText() {
		String inputText = scheduleName.getAttribute("value");
		if (inputText.length() == 0) {
			return scheduleName.getAttribute("placeholder");
		} else {
			return inputText;
		}
	}
	
	/**
	 * gets Schedule description value
	 */

	public String getScheduleDescriptionText() {
		String inputText = scheduledescription.getAttribute("value");
		if (inputText.length() == 0) {
			return scheduledescription.getAttribute("placeholder");
		} else {
			return inputText;
		}
	}

	/**
	 * gets delay interval value
	 */

	public String getDelayIntervalValue() {
		return delayIntervalValue.getAttribute("value");
	}
	
	/**
	 * gets  start date value
	 */

	public String getStartDateValue() {
		return startDate.getAttribute("value");
	}
	
	/**
	 * gets End date value
	 */

	public String getEndDateValue() {
		return endDate.getAttribute("value");
	}
	
	/**
	 * Set Schedule Description textbox
	 * 
	 * @param strPassword
	 */

	public void setScheduleDescription(String strDescription) {
		scheduledescription.clear();
		scheduledescription.sendKeys(strDescription);
	}
	
	/**
	 * clicks on monday checkbox
	 */
	
	public void clickMondayCheckBox(){
		mondayCheckbox.click();
	}
	
	/**
	 * checks if Monday checkbox is selected
	 */
	public boolean checkIfMondaySelected(){
		return mondayCheckbox.isSelected();
	}
	
	/**
	 * clicks on tuesday checkbox
	 */
	
	public void clickTuesdayCheckBox(){
		tuesdayCheckbox.click();
	}
	
	/**
	 * checks if tuesday Checkbox is selected
	 */
	public boolean checkIfTuesdaySelected(){
		return tuesdayCheckbox.isSelected();
	}
	
	/**
	 * checks if wednesday Checkbox is selected
	 */
	public boolean checkIfWednesdaySelected(){
		return wednesdayCheckbox.isSelected();
	}
	
	/**
	 * checks if thursday Checkbox is selected
	 */
	public boolean checkIfThursdaySelected(){
		return thursdayCheckbox.isSelected();
	}
	
	/**
	 * checks if friday Checkbox is selected
	 */
	public boolean checkIfFridaySelected(){
		return fridayCheckbox.isSelected();
	}
	
	/**
	 * checks if saturday Checkbox is selected
	 */
	public boolean checkIfSaturdaySelected(){
		return saturdayCheckbox.isSelected();
	}
	
	/**
	 * checks if sunday Checkbox is selected
	 */
	public boolean checkIfSundaySelected(){
		return sundayCheckbox.isSelected();
	}
	
	
	/**
	 * clicks on '-' sign on delay interval
	 */
	
	public void clickMinusOnDelayInterval(){
		delayIntervalMinus.click();
	}
	
	/**
	 * clicks on '+' sign on delay interval
	 */
	
	public void clickPlusOnDelayInterval(){
		delayIntervalPlus.click();
	}

	/**
	 * select monday
	 * 
	 * @throws InterruptedException
	 */

	public void selectMonday() throws InterruptedException {
		log.info("select Monday - Begin");
		mondayCheckbox.click();
		String monday_text = mondayText.getText();
		daysList = new ArrayList<String>();
		daysList.add(monday_text);
		log.info("Monday selected..!!");
		startTime = getStartTimeValue(tooltip1);
		endTime = getEndTimeValue(tooltip2);
		log.info("select Monday - End");
	}

	/**
	 * select tuesday
	 * 
	 * @throws InterruptedException
	 */

	public void selectTuesday() throws InterruptedException {
		log.info("select Tuesday - Begin");
		tuesdayCheckbox.click();
		String tuesday_text = tuesdayCheckbox.getText();
		daysList = new ArrayList<String>();
		daysList.add(tuesday_text);
		log.info("Tuesday selected..!!");
		startTime = getStartTimeValue(tooltip3);
		endTime = getEndTimeValue(tooltip4);
		log.info("select Tuesday - End");
	}
	
	/**
	 * // select monday with different timing
	 * 
	 * @throws InterruptedException
	 */
	public void selectMondayWithDifferentTiming() throws InterruptedException, IOException {
		log.info("select Monday With Different Timing - Begin");
		mondayCheckbox.click();
		String monday_text = mondayText.getText();
		daysList = new ArrayList<String>();
		daysList.add(monday_text);
		log.info("Monday selected..!!");
		leftslidermovement(mon_starttime, 60);
		rightslidermovement(mon_endtime, -60);
		startTime = getStartTimeValue(tooltip1);
		endTime = getEndTimeValue(tooltip2);
		log.info("select Monday With Different Timing - End");

	}

	/**
	 * // Select multiple days
	 * 
	 * @throws InterruptedException
	 */

	public void selectMultipleDays() throws InterruptedException {
		log.info("select Multiple Days - End");
		mondayCheckbox.click();
		wednesdayCheckbox.click();
		thursdayCheckbox.click();
		String monday_text = mondayText.getText();
		String wednesday_text = wednesdayText.getText();
		String thursday_text = thursdayText.getText();
		daysList = new ArrayList<String>();
		daysList.add(monday_text);
		daysList.add(wednesday_text);
		daysList.add(thursday_text);
		log.info("Monday ,Wednesday,Thursday selected..!!");
		startTime = getStartTimeValue(tooltip1, tooltip3, tooltip5);
		endTime = getEndTimeValue(tooltip2, tooltip4, tooltip6);
		log.info("select Multiple Days - End");
	}

	/**
	 * Select multiple days with different timing from calendar
	 * 
	 * @throws InterruptedException
	 */
	public void selectMultipleDaysWithDifferentTiming() throws InterruptedException, IOException {
		log.info("select Multiple Days With Different Timing - Begin");
		mondayCheckbox.click();
		wednesdayCheckbox.click();
		String monday_text = mondayText.getText();
		String wednesday_text = wednesdayText.getText();
		daysList = new ArrayList<String>();
		daysList.add(monday_text);
		daysList.add(wednesday_text);
		log.info("Monday ,Wednesday selected..!!");
		leftslidermovement(wed_starttime, 60);
		rightslidermovement(wed_endtime, -60);
		leftslidermovement(mon_starttime, 60);
		rightslidermovement(mon_endtime, -60);
		startTime = getStartTimeValue(tooltip1, tooltip3);
		endTime = getEndTimeValue(tooltip2, tooltip4);
		log.info("select Multiple Days With Different Timing - End");
	}

	/**
	 * Select multiple days with same timing from calendar
	 * 
	 * @throws InterruptedException
	 */
	public void selectmultipledayswithsametiming() throws InterruptedException, IOException {
		log.info("select Multiple Days With same Timing - Begin");
		mondayCheckbox.click();
		wednesdayCheckbox.click();
		String monday_text = mondayText.getText();
		String wednesday_text = wednesdayText.getText();
		daysList = new ArrayList<String>();
		daysList.add(monday_text);
		daysList.add(wednesday_text);
		log.info("Monday ,Wednesday selected..!!");
		clickMoveAllSlider();
		leftslidermovement(mon_starttime, 60);
		rightslidermovement(mon_endtime, -60);
		startTime = getStartTimeValue(tooltip1, tooltip3);
		endTime = getEndTimeValue(tooltip2, tooltip4);
		log.info("select Multiple Days With same Timing - End");
	}

	/**
	 * bluk select slider verification
	 * 
	 * @throws InterruptedException
	 */
	public void sliderVerification() throws InterruptedException, IOException {
		log.info("Move all slider together verification - Begin");
		mondayCheckbox.click();
		wednesdayCheckbox.click();
		String monday_text = mondayText.getText();
		String wednesday_text = wednesdayText.getText();
		daysList = new ArrayList<String>();
		daysList.add(monday_text);
		daysList.add(wednesday_text);
		log.info("Monday ,Wednesday selected..!!");
		clickMoveAllSlider();
		wait(1);
		leftslidermovement(mon_starttime, 60);
		rightslidermovement(mon_endtime, -60);
		startTime = getStartTimeValue(tooltip1, tooltip3);
		endTime = getEndTimeValue(tooltip2, tooltip4);
		fridayCheckbox.click();
		wait(1);
		clickMoveAllSlider();
		wait(1);
		startTimeOnUnChecking = getStartTimeValue(tooltip1, tooltip3);
		endTimeOnUnChecking = getEndTimeValue(tooltip2, tooltip4);
		clickMoveAllSlider();
		wait(1);
		startTimeOnChecking = getStartTimeValue(tooltip1, tooltip3);
		endTimeOnChecking = getEndTimeValue(tooltip2, tooltip4);
		log.info("Move all slider together verification - End");
	}

	/**
	 * gets Start Time Value
	 * 
	 * @throws InterruptedException
	 */
	public List<String> getStartTimeValue(WebElement... Webelements) throws InterruptedException {
		startTimeValue = new ArrayList<String>();
		for (WebElement i : Webelements) {
			startTimeValue.add(i.getText());
		}
		return startTimeValue;
	}

	/**
	 * gets End Time Value
	 * 
	 * @throws InterruptedException
	 */
	public List<String> getEndTimeValue(WebElement... Webelements) throws InterruptedException {
		endTimeValue = new ArrayList<String>();
		for (WebElement i : Webelements) {
			endTimeValue.add(i.getText());
		}
		return endTimeValue;

	}

	/**
	 * get Actual Actual Name Validation Msg
	 * 
	 * @throws InterruptedException
	 */
	public String getActualNameValidationMsg() throws InterruptedException {
		return actualNameValidationMsg.getText();

	}

	/**
	 * get Actual End date Validation Msg
	 * 
	 * @throws InterruptedException
	 */

	public String getActualEnddateValidationMsg() throws InterruptedException {
		return actualEnddateValidationMsg.getText();

	}

	/**
	 * get Actual Select Day Validation Msg
	 * 
	 * @throws InterruptedException
	 */

	public String getActualSelectDayValidationMsg() throws InterruptedException {
		return actualSelectDayValidationMsg.getText();

	}

	/**
	 * get toaster error message
	 * 
	 * @throws InterruptedException
	 */

	public String getToasterErrorMsg() throws InterruptedException {
		waitForElementToBePresent(errorToaster, 5);
		waitForElementVisible(errorToasterMsg, 5);
		return errorToasterMsg.getText();

	}

	/**
	 * get left slider label
	 */

	public String getLeftSliderLabel() {
		return leftSliderLabel.getText();

	}

	/**
	 * get right slider label
	 */

	public String getRightSliderLabel() {
		return rightSliderLabel.getText();

	}

	/**
	 * Click on save button
	 * 
	 * @throws InterruptedException
	 */
	public void clickSave() throws InterruptedException {
		waitForElementClickable(saveButton, 5);
		saveButton.click();
		wait(2);
	}

	/**
	 * Click on cancel button
	 * 
	 * @throws InterruptedException
	 */
	public void clickCancelButton() throws InterruptedException {
		cancelButton.click();
		wait(1);
	}

	/**
	 * Click on Move all selected slider together check box
	 * 
	 * @throws InterruptedException
	 */
	public void clickMoveAllSlider() throws InterruptedException {
		moveAllSliderTogether.click();
		wait(1);
	}
	
	/**
	 * checks if move All Slider Together checkbox is selected
	 */
	public boolean checkIfMoveAllSliderTogetherSelected(){
		return moveAllSliderTogether.isSelected();
	}
	
	

	/**
	 * Click on enter Start Date
	 * 
	 * @throws InterruptedException
	 */
	public void enterStartDate(String date) throws IOException, InterruptedException {
		startDate.click();
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

	}

	/**
	 * Click on enter End Date
	 * 
	 * @throws InterruptedException
	 */
	public void enterEndDate(String date) throws IOException, InterruptedException {
		endDate.click();
		wait(1);
		waitForElementVisible(nextMonth, 5);
		nextMonth.click();
		wait(1);
		log.info("date fetch=" + date);
		for (WebElement all_Date : all_Dates) {
			if ((all_Date.getText()).equalsIgnoreCase(date)) {
				all_Date.click();
				log.info("End date selected successfully");

				break;
			}
		}
		log.info("End date: " + date);

	}

	/**
	 * Click on left slider movement
	 * 
	 * @throws InterruptedException
	 */
	public void leftslidermovement(WebElement slider, int value) throws IOException {
		Actions move = new Actions(driver);
		Action action = move.dragAndDropBy(slider, value, 0).build();
		action.perform();
	}

	/**
	 * Click on right slider movement
	 * 
	 * @throws InterruptedException
	 */

	public void rightslidermovement(WebElement slider, int value) throws IOException {
		Actions move = new Actions(driver);
		Action action = move.dragAndDropBy(slider, value, 0).build();
		action.perform();

	}

	/**
	 * Verification for error message toaster
	 * 
	 * @throws InterruptedException
	 */
	public void verifyErrorToasterMsg(String actualErrorMsg,String expectedErrorMsg) throws InterruptedException {
		Assert.assertTrue(compareTextContains(actualErrorMsg, expectedErrorMsg), "Error message not displayed");
	}
	
	/**
	 * selects Multiple Days For Edit Schedule
	 * 
	 * @throws InterruptedException
	 */
	public void selectMultipleDaysForEditSchedule() throws InterruptedException {
        log.info("select Multiple Days - End");
        wednesdayCheckbox.click();
        thursdayCheckbox.click();
        String wednesday_text = wednesdayText.getText();
        String thursday_text = thursdayText.getText();
        daysList = new ArrayList<String>();
        daysList.add(wednesday_text);
        daysList.add(thursday_text);
        log.info("Wednesday,Thursday selected..!!");
        startTime = getStartTimeValue(tooltip3, tooltip5);
        endTime = getEndTimeValue(tooltip4, tooltip6);
        log.info("select Multiple Days - End");
    }
}
