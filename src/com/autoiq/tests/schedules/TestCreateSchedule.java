package com.autoiq.tests.schedules;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.autoiq.base.TestBase;
import com.autoiq.common.utility.CommonUtility;
import com.autoiq.common.utility.CommonWebFunctions;
import com.autoiq.common.utility.DataStoreInObjects;
import com.autoiq.common.utility.HandleException;
//import com.autoiq.pages.schedules.SchedulesOverview;
import com.autoiq.tests.dashboard.Navigation;
import com.autoiq.tests.login.TestLogin;

public class TestCreateSchedule extends TestBase {
	
	
	final static Logger logger = Logger.getLogger(TestCreateSchedule.class.getName());

	DataStoreInObjects testData = new DataStoreInObjects();
	DataStoreInObjects locators = new DataStoreInObjects();

	CommonWebFunctions actions; 
	Navigation navigation;
	//SchedulesOverview schedule = new SchedulesOverview();

	public TestCreateSchedule() throws HandleException {
		actions = new CommonWebFunctions();
		navigation = new Navigation();

		testData = CommonUtility.loadTestData("Test Data", "ScheduleTestData");
		locators = CommonUtility.loadLocators("Page Objects", "SchedulePage");
	}
	
	
	
	
//	
//	Login lp;
//	ProcessOverview op;
//	CreateSchedule csp;
//	SchedulesOverview sp;
//	NavigationBar np;
//
//	@BeforeClass
//	public void setup() throws MalformedURLException {
//		try {
//			lp = new Login(driver);
//			op = new ProcessOverview(driver);
//			csp = new CreateSchedule(driver);
//			sp = new SchedulesOverview(driver);
//			np = new NavigationBar(driver);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Creating Schedule With Schedule Name Only
	 * @throws HandleException 
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 0)
	public void createScheduleWithScheduleNameOnly() throws HandleException, InterruptedException{
		logger.info("---------------------------------------------------------------------------------");
		logger.info("Verify create Schedule With Schedule Name Only - Begin");
		actions.launchBrowser();
		TestLogin login = new TestLogin();
		login.loginWithValidCredentials();
		navigation.navigateToHomePage();
		navigation.schedulesTab();
		//String scheduleName = locators.getValue("scheduleName");
		actions.clickOnElement(locators.getValue("createScheduleButton"));
		actions.sendKeysToElement(testData.getValue("scheduleName"), locators.getValue("scheduleName"));
		actions.clickOnElement(locators.getValue("mondayCheckbox"));
		actions.clickOnElement(locators.getValue("saveButton"));
		actions.verifyTextWithAssertContains(locators.getValue("successToasterMsg"), testData.getValue("expectedSuccessToasterMessage"));
		String scheduleName = actions.getElementTextInElementList(locators.getValue("scheduleList"), locators.getValue("scheduleName"));
		deleteSchedule(scheduleName);
		
		
		//expectedSuccessToasterMessage
		//locator = successToasterMsg
//		
//		np.navigateToHomeAndClickOnProcessesTab();
//		np.schedulesSubTab();
//		String scheduleName = createSchedulePageProp.getProperty("scheduleName");
//		sp.clickCreateNewScheduleButton();
//		enterScheduleName(scheduleName);
//		csp.selectMonday();
//		csp.clickSave();
//		String expectedSucessMsg = createSchedulePageProp.getProperty("expectedSuccessToasterMessage");
	//	sp.verifySuccessToasterMsg(expectedSucessMsg);
//		//sp.verifyNameForCreatedSchedule(scheduleName);
//		sp.deleteSchedule(scheduleName);
		logger.info("Verify create Schedule With Schedule Name Only - End");
		logger.info("-----------------------------------------XXX--------------------------------------");
	}
	/**
	 * Deletes the schedule
	 * @throws InterruptedException 
	 * @throws IOException 
	 * @throws HandleException 
	 */
	public void deleteSchedule(String schName) throws HandleException, InterruptedException  {
	int index = actions.getElementsIndex(locators.getValue("scheduleList"), schName);
		//actions.clickOnElement(locators.getValue("scheduleList"));
		//actions.clickOnIndex(index-1,locators.getValue("hamburgerIconList"));
		//clickHamburgerIcon(index-1);
	//	actions.clickOnIndex(index-1,locators.getValue("deleteIconList"));
		//clickDeleteLink(index-1);
		actions.clickOnElement(locators.getValue("yesButton"));
		//clickYesButton();
	}
	
//	/**
//	 * Creating Schedule With Schedule Name Only
//	 * 
//	 * @throws InterruptedException
//	 */
//	@Test(priority = 1)
//	public void verifyCreateScheduleWithScheduleNameOnly() throws InterruptedException, IOException {
//		log.info("---------------------------------------------------------------------------------");
//		log.info("Verify create Schedule With Schedule Name Only - Begin");
//		np.navigateToHomeAndClickOnProcessesTab();
//		np.schedulesSubTab();
//		String scheduleName = createSchedulePageProp.getProperty("scheduleName");
//		sp.clickCreateNewScheduleButton();
//		enterScheduleName(scheduleName);
//		csp.selectMonday();
//		csp.clickSave();
//		String expectedSucessMsg = createSchedulePageProp.getProperty("expectedSuccessToasterMessage");
//		sp.verifySuccessToasterMsg(expectedSucessMsg);
//		sp.verifyNameForCreatedSchedule(scheduleName);
//		sp.deleteSchedule(scheduleName);
//		log.info("Verify create Schedule With Schedule Name Only - End");
//		log.info("-----------------------------------------XXX--------------------------------------");
//	}
//
//	/**
//	 * Creating Schedule With ScheduleName & Description Only
//	 * 
//	 * @throws InterruptedException
//	 * @throws IOException
//	 * @throws AWTException
//	 */
//	@Test(priority = 2)
//	public void verifyCreateScheduleWithScheduleNameAndDescription() throws InterruptedException, IOException, AWTException {
//		log.info("---------------------------------------------------------------------------------");
//		log.info("Verify create Schedule With Schedule Name and Description - Begin");
//		np.navigateToHomeAndClickOnProcessesTab();
//		np.schedulesSubTab();
//		String scheduleName = createSchedulePageProp.getProperty("scheduleWithDescription");
//		String scheduleDescription = createSchedulePageProp.getProperty("scheduleDescriptionWithDescription");
//		sp.clickCreateNewScheduleButton();
//		enterScheduleNameAndDescription(scheduleName, scheduleDescription);
//		csp.selectMonday();
//		csp.clickSave();
//		String expectedSucessMsg = createSchedulePageProp.getProperty("expectedSuccessToasterMessage");
//		sp.verifySuccessToasterMsg(expectedSucessMsg);
//		sp.verifyNameForCreatedSchedule(scheduleName);
//		sp.verifyDescriptionForCreatedSchedule(scheduleName, scheduleDescription);
//		sp.deleteSchedule(scheduleName);
//		log.info("Schedule displayed on schedule Overview page. Create New Schedule verification Done Succcessfully!!");
//		log.info("Verify create Schedule With Schedule Name and Description - End");
//		log.info("-----------------------------------------XXX--------------------------------------");
//	}
//
//	/**
//	 * Creating Schedule With Start Date
//	 * 
//	 * @throws InterruptedException
//	 * @throws AWTException
//	 */
//	@Test(priority = 3)
//	public void verifyCreateScheduleWithStartDate() throws InterruptedException, IOException, AWTException {
//		log.info("---------------------------------------------------------------------------------");
//		log.info("Verify create Schedule With Start Date - Begin");
//		np.navigateToHomeAndClickOnProcessesTab();
//		np.schedulesSubTab();
//		String scheduleName = createSchedulePageProp.getProperty("scheduleWithStartdate");
//		String scheduleDescription = createSchedulePageProp.getProperty("scheduleDescription");
//		sp.clickCreateNewScheduleButton();
//		enterScheduleNameAndDescription(scheduleName, scheduleDescription);
//		csp.enterStartDate(createSchedulePageProp.getProperty("startDateValue"));
//		csp.selectMonday();
//		csp.clickSave();
//		String expectedSucessMsg = createSchedulePageProp.getProperty("expectedSuccessToasterMessage");
//		sp.verifySuccessToasterMsg(expectedSucessMsg);
//		sp.verifyNameForCreatedSchedule(scheduleName);
//		sp.verifyDescriptionForCreatedSchedule(scheduleName, scheduleDescription);
//		sp.verifySelectedDaysForCreatedSchedule(scheduleName, csp.daysList);
//		sp.verifyStarttimeForCreatedSchedule(scheduleName, csp.startTime);
//		sp.verifyEndtimeForCreatedSchedule(scheduleName, csp.endTime);
//		sp.deleteSchedule(scheduleName);
//		log.info("Verify create Schedule With Start Date - End");
//		log.info("-----------------------------------------XXX--------------------------------------");
//	}
//
//	/**
//	 * Creating Schedule With End Date
//	 * 
//	 * @throws InterruptedException
//	 * @throws AWTException
//	 */
//	@Test(priority = 4)
//	public void verifyCreateScheduleWithEndDate() throws InterruptedException, IOException, AWTException {
//		log.info("---------------------------------------------------------------------------------");
//		log.info("Verify create Schedule With End Date - Begin");
//		np.navigateToHomeAndClickOnProcessesTab();
//		np.schedulesSubTab();
//		String scheduleName = createSchedulePageProp.getProperty("scheduleWithEnddate");
//		String scheduleDescription = createSchedulePageProp.getProperty("scheduleDescription");
//		sp.clickCreateNewScheduleButton();
//		enterScheduleNameAndDescription(scheduleName, scheduleDescription);
//		csp.enterEndDate(createSchedulePageProp.getProperty("endDatevalue"));
//		csp.selectMonday();
//		csp.clickSave();
//		String expectedSucessMsg = createSchedulePageProp.getProperty("expectedSuccessToasterMessage");
//		sp.verifySuccessToasterMsg(expectedSucessMsg);
//		sp.verifyNameForCreatedSchedule(scheduleName);
//		sp.verifyDescriptionForCreatedSchedule(scheduleName, scheduleDescription);
//		sp.verifySelectedDaysForCreatedSchedule(scheduleName, csp.daysList);
//		sp.verifyStarttimeForCreatedSchedule(scheduleName, csp.startTime);
//		sp.verifyEndtimeForCreatedSchedule(scheduleName, csp.endTime);
//		sp.deleteSchedule(scheduleName);
//		log.info("Verify create Schedule With End Date - End");
//		log.info("-----------------------------------------XXX--------------------------------------");
//	}
//
//	/**
//	 * Creating Schedule By Selecting One Day
//	 * 
//	 * @throws InterruptedException
//	 * @throws AWTException
//	 */
//	@Test(priority = 5)
//	public void verifyCreateScheduleWithOneDay() throws InterruptedException, IOException, AWTException {
//		log.info("---------------------------------------------------------------------------------");
//		log.info("Verify create Schedule With One Day - Begin");
//		np.navigateToHomeAndClickOnProcessesTab();
//		np.schedulesSubTab();
//		String scheduleName = createSchedulePageProp.getProperty("scheduleWithOneDay");
//		String scheduleDescription = createSchedulePageProp.getProperty("scheduleDescription");
//		sp.clickCreateNewScheduleButton();
//		enterScheduleNameAndDescription(scheduleName, scheduleDescription);
//		csp.enterStartDate(createSchedulePageProp.getProperty("startDateValue"));
//		wait(1);
//		csp.enterEndDate(createSchedulePageProp.getProperty("endDatevalue"));
//		wait(2);
//		csp.selectMonday();
//		csp.clickSave();
//		String expectedSucessMsg = createSchedulePageProp.getProperty("expectedSuccessToasterMessage");
//		sp.verifySuccessToasterMsg(expectedSucessMsg);
//		sp.verifyNameForCreatedSchedule(scheduleName);
//		sp.verifyDescriptionForCreatedSchedule(scheduleName, scheduleDescription);
//		sp.verifySelectedDaysForCreatedSchedule(scheduleName, csp.daysList);
//		sp.verifyStarttimeForCreatedSchedule(scheduleName, csp.startTime);
//		sp.verifyEndtimeForCreatedSchedule(scheduleName, csp.endTime);
//		sp.deleteSchedule(scheduleName);
//		log.info("Verify create Schedule With One Day - End");
//		log.info("-----------------------------------------XXX--------------------------------------");
//	}
//
//	/**
//	 * Creating Schedule By Selecting Multiple Days with default time
//	 * 
//	 * @throws InterruptedException
//	 * @throws AWTException
//	 */
//	@Test(priority = 6)
//	public void verifyCreateScheduleWithMultipleDays() throws InterruptedException, IOException, AWTException {
//		log.info("---------------------------------------------------------------------------------");
//		log.info("Verify create Schedule With Multiple Days - Begin");
//		np.navigateToHomeAndClickOnProcessesTab();
//		np.schedulesSubTab();
//		String scheduleName = createSchedulePageProp.getProperty("scheduleWithMultipleDays");
//		String scheduleDescription = createSchedulePageProp.getProperty("scheduleDescription");
//		sp.clickCreateNewScheduleButton();
//		enterScheduleNameAndDescription(scheduleName, scheduleDescription);
//		csp.enterStartDate(createSchedulePageProp.getProperty("startDateValue"));
//		wait(1);
//		csp.enterEndDate(createSchedulePageProp.getProperty("endDatevalue"));
//		wait(2);
//		csp.selectMultipleDays();
//		csp.clickSave();
//		String expectedSucessMsg = createSchedulePageProp.getProperty("expectedSuccessToasterMessage");
//		sp.verifySuccessToasterMsg(expectedSucessMsg);
//		sp.verifyNameForCreatedSchedule(scheduleName);
//		sp.verifyDescriptionForCreatedSchedule(scheduleName, scheduleDescription);
//		sp.verifySelectedDaysForCreatedSchedule(scheduleName, csp.daysList);
//		sp.verifyStarttimeForCreatedSchedule(scheduleName, csp.startTime);
//		sp.verifyEndtimeForCreatedSchedule(scheduleName, csp.endTime);
//		sp.deleteSchedule(scheduleName);
//		log.info("Verify create Schedule With Multiple Days - End");
//		log.info("-----------------------------------------XXX--------------------------------------");
//	}
//
//	/**
//	 * Creating Schedule By Selecting single Day with different timings
//	 * 
//	 * @throws InterruptedException
//	 */
//	@Test(priority = 7)
//	public void verifyCreateScheduleWithSingleDayWithDifferentTiming()
//			throws InterruptedException, IOException, AWTException {
//		log.info("---------------------------------------------------------------------------------");
//		log.info("Verify create Schedule With Single Day With Different Timing - Begin");
//		String scheduleName = createSchedulePageProp.getProperty("scheduleWithSingleDayDiffTiming");
//		String scheduleDescription = createSchedulePageProp.getProperty("scheduleDescription");
//		np.navigateToHomeAndClickOnProcessesTab();
//		np.schedulesSubTab();
//		sp.clickCreateNewScheduleButton();
//		enterScheduleNameAndDescription(scheduleName, scheduleDescription);
//		csp.enterStartDate(createSchedulePageProp.getProperty("startDateValue"));
//		wait(2);
//		csp.enterEndDate(createSchedulePageProp.getProperty("endDatevalue"));
//		wait(2);
//		csp.selectMondayWithDifferentTiming();
//		csp.clickSave();
//		String expectedSucessMsg = createSchedulePageProp.getProperty("expectedSuccessToasterMessage");
//		sp.verifySuccessToasterMsg(expectedSucessMsg);
//		wait(2);
//		sp.verifyNameForCreatedSchedule(scheduleName);
//		sp.verifyDescriptionForCreatedSchedule(scheduleName, scheduleDescription);
//		sp.verifySelectedDaysForCreatedSchedule(scheduleName, csp.daysList);
//		sp.verifyStarttimeForCreatedSchedule(scheduleName, csp.startTime);
//		sp.verifyEndtimeForCreatedSchedule(scheduleName, csp.endTime);
//		sp.deleteSchedule(scheduleName);
//		log.info("Verify create Schedule With Single Day With Different Timing - End");
//		log.info("-----------------------------------------XXX--------------------------------------");
//	}
//
//	/**
//	 * Creating Schedule By Selecting Multiple Days with different timings
//	 * 
//	 * @throws InterruptedException
//	 * @throws AWTException
//	 */
//	@Test(priority = 8)
//	public void verifyCreateScheduleWithMultipleDaysWithDifferentTiming()
//			throws InterruptedException, IOException, AWTException {
//		log.info("---------------------------------------------------------------------------------");
//		log.info("Verify create Schedule With Multiple Days With Different Timing - Begin");
//		np.navigateToHomeAndClickOnProcessesTab();
//		np.schedulesSubTab();
//		String scheduleName = createSchedulePageProp.getProperty("scheduleWithMultipledaysDiffTiming");
//		String scheduleDescription = createSchedulePageProp.getProperty("scheduleDescription");
//		sp.clickCreateNewScheduleButton();
//		enterScheduleNameAndDescription(scheduleName, scheduleDescription);
//		csp.enterStartDate(createSchedulePageProp.getProperty("startDateValue"));
//		wait(2);
//		csp.enterEndDate(createSchedulePageProp.getProperty("endDatevalue"));
//		wait(2);
//		csp.selectMultipleDaysWithDifferentTiming();
//		csp.clickSave();
//		sp.getToasterSuccessMsg();
//		sp.verifyNameForCreatedSchedule(scheduleName);
//		sp.verifyDescriptionForCreatedSchedule(scheduleName, scheduleDescription);
//		sp.verifySelectedDaysForCreatedSchedule(scheduleName, csp.daysList);
//		sp.verifyStarttimeForCreatedSchedule(scheduleName, csp.startTime);
//		sp.verifyEndtimeForCreatedSchedule(scheduleName, csp.endTime);
//		sp.deleteSchedule(scheduleName);
//		log.info("Verify create Schedule With Multiple Days With Different Timing - End");
//		log.info("-----------------------------------------XXX--------------------------------------");
//	}
//
//	/**
//	 * Creating Schedule By Selecting Multiple Days with same timings
//	 * 
//	 * @throws InterruptedException
//	 * @throws AWTException
//	 */
//	@Test(priority = 9)
//	public void verifyCreateScheduleWithMultipleDaysWithSameTiming() throws InterruptedException, IOException, AWTException {
//		log.info("---------------------------------------------------------------------------------");
//		log.info("Verify Selecting checkbox for multiple days with same timing- Begin!");
//		np.navigateToHomeAndClickOnProcessesTab();
//		np.schedulesSubTab();
//		String scheduleName = createSchedulePageProp.getProperty("scheduleWithMultipledaysSameTiming");
//		String scheduleDescription = createSchedulePageProp.getProperty("scheduleDescription");
//		sp.clickCreateNewScheduleButton();
//		enterScheduleNameAndDescription(scheduleName, scheduleDescription);
//		csp.enterStartDate(createSchedulePageProp.getProperty("startDateValue"));
//		wait(2);
//		csp.enterEndDate(createSchedulePageProp.getProperty("endDatevalue"));
//		wait(2);
//		csp.selectmultipledayswithsametiming();
//		csp.clickSave();
//		String expectedSucessMsg = createSchedulePageProp.getProperty("expectedSuccessToasterMessage");
//		sp.verifySuccessToasterMsg(expectedSucessMsg);
//		sp.verifyNameForCreatedSchedule(scheduleName);
//		sp.verifyDescriptionForCreatedSchedule(scheduleName, scheduleDescription);
//		sp.verifySelectedDaysForCreatedSchedule(scheduleName, csp.daysList);
//		sp.verifyStarttimeForCreatedSchedule(scheduleName, csp.startTime);
//		sp.verifyEndtimeForCreatedSchedule(scheduleName, csp.endTime);
//		sp.deleteSchedule(scheduleName);
//		log.info("Verify Selecting checkbox for multiple days with same timing - End!");
//		log.info("-----------------------------------------XXX--------------------------------------");
//	}
//
//	@Test(priority = 10)
//	public void VerifyMoveAllSliderFunctionality() throws InterruptedException, IOException, AWTException {
//		log.info("---------------------------------------------------------------------------------");
//		log.info("Verify  of move all slider functionality = Begin!");
//		np.navigateToHomeAndClickOnProcessesTab();
//		np.schedulesSubTab();
//		String scheduleName = createSchedulePageProp.getProperty("scheduleWithMultipledaysDiffTiming");
//		String scheduleDescription = createSchedulePageProp.getProperty("scheduleDescription");
//		sp.clickCreateNewScheduleButton();
//		enterScheduleNameAndDescription(scheduleName, scheduleDescription);
//		csp.sliderVerification();
//		log.info(csp.startTime + "test " + csp.startTimeOnUnChecking);
//		Assert.assertEquals(csp.startTime, csp.startTimeOnUnChecking,
//				"Start time doesnot remain as it is on unchecking move all selected slider together");
//		Assert.assertEquals(csp.endTime, csp.endTimeOnUnChecking,
//				"End time doesnot remain as it is on unchecking move all selected slider together");
//		List<String> defaultStarttime = new ArrayList<String>();
//		defaultStarttime.add(schedulesPageProp.getProperty("defaultStarttime12Hr"));
//		defaultStarttime.add(schedulesPageProp.getProperty("defaultStarttime12Hr"));
//		List<String> defaultEndtime = new ArrayList<String>();
//		defaultEndtime.add(schedulesPageProp.getProperty("defaultEndtime12Hr"));
//		defaultEndtime.add(schedulesPageProp.getProperty("defaultEndtime12Hr"));
//		log.info(csp.startTimeOnChecking + "test " + defaultStarttime);
//		Assert.assertEquals(csp.startTimeOnChecking, defaultStarttime,
//				"Start time is not setting to default position on checking move all selected slider together");
//		Assert.assertEquals(csp.endTimeOnChecking, defaultEndtime,
//				"End time is not setting to default position on checking move all selected slider together");
//		csp.clickCancelButton();
//		log.info("Verify  of move all slider functionality = End!");
//		log.info("-----------------------------------------XXX--------------------------------------");
//	}
//
//	/**
//	 * Checking uniqueName Verification
//	 * 
//	 * @throws InterruptedException
//	 * @throws AWTException
//	 */
//
//	@Test(priority = 11)
//	public void verifyUniqueNameVerification() throws IOException, InterruptedException, AWTException {
//		log.info("---------------------------------------------------------------------------------");
//		log.info("Verify unique Name Verification - Begin");
//		np.navigateToHomeAndClickOnProcessesTab();
//		np.schedulesSubTab();
//		String scheduleName = createSchedulePageProp.getProperty("uniquescheduleName");
//		sp.clickCreateNewScheduleButton();
//		enterScheduleName(scheduleName);
//		csp.selectMonday();
//		csp.clickSave();
//		wait(2);
//		sp.clickCreateNewScheduleButton();
//		enterScheduleName(scheduleName);
//		csp.selectMonday();
//		csp.clickSave();
//		String actualValidationMsg = csp.getActualNameValidationMsg();
//		String expectedValidationMsg = createSchedulePageProp.getProperty("expectedNameValidationMsg");
//		Assert.assertEquals(actualValidationMsg, expectedValidationMsg, "Unique Name Validation message not displayed");
//		String actualErrorMsg = csp.getToasterErrorMsg();
//		String expectedErrorMsg = createSchedulePageProp.getProperty("expectedErrorToasterMessage");
//		csp.verifyErrorToasterMsg(actualErrorMsg,expectedErrorMsg);
//		csp.clickCancelButton();
//		sp.deleteSchedule(scheduleName);
//		log.info("Verify unique Name Verification- End ");
//		log.info("-----------------------------------------XXX--------------------------------------");
//	}
//
//	/**
//	 * Checking blank ScheduleName Verification
//	 * 
//	 * @throws InterruptedException
//	 * @throws AWTException
//	 */
//	@Test(priority = 12)
//	public void verifyBlankScheduleNameVerification() throws IOException, InterruptedException, AWTException {
//		log.info("---------------------------------------------------------------------------------");
//		log.info("Verify blank Schedule Name Verification - Begin");
//		np.navigateToHomeAndClickOnProcessesTab();
//		np.schedulesSubTab();
//		sp.clickCreateNewScheduleButton();
//		csp.selectMonday();
//		csp.clickSave();
//		String actualValidationMsg = csp.getActualNameValidationMsg();
//		String expectedValidationMsg = createSchedulePageProp.getProperty("expectedRequiredNameValidationMsg");
//		Assert.assertEquals(actualValidationMsg, expectedValidationMsg,
//				"Blank schedule name Validation message not displayed");
//		csp.clickCancelButton();
//		log.info("Verify blank Schedule Name Verification - End");
//		log.info("-----------------------------------------XXX--------------------------------------");
//	}
//
//	/**
//	 * Checking scheduleName With Space Verification
//	 * 
//	 * @throws InterruptedException
//	 * @throws AWTException
//	 */
//
//	@Test(priority = 13)
//	public void verifyScheduleNameWithSpaceVerification() throws IOException, InterruptedException, AWTException {
//		log.info("---------------------------------------------------------------------------------");
//		log.info("Verify schedule Name With Space Verification - Begin");
//		np.navigateToHomeAndClickOnProcessesTab();
//		np.schedulesSubTab();
//		sp.clickCreateNewScheduleButton();
//		enterScheduleName(" ");
//		csp.selectMonday();
//		csp.clickSave();
//		String actualValidationMsg = csp.getActualNameValidationMsg();
//		String expectedValidationMsg = createSchedulePageProp.getProperty("expectedRequiredNameValidationMsg");
//		Assert.assertEquals(actualValidationMsg, expectedValidationMsg,
//				"Schedule name with space Validation message not displayed");
//		csp.clickCancelButton();
//		log.info("Verify schedule Name With Space Verification - End");
//		log.info("-----------------------------------------XXX--------------------------------------");
//	}
//
//	/**
//	 * Checking no Day Selected Verification
//	 * 
//	 * @throws InterruptedException
//	 * @throws AWTException
//	 */
//
//	@Test(priority = 14)
//	public void verifyNoDaySelectedVerification() throws IOException, InterruptedException, AWTException {
//		log.info("---------------------------------------------------------------------------------");
//		log.info("Verify no Day Selected Verification - Begin");
//		np.navigateToHomeAndClickOnProcessesTab();
//		np.schedulesSubTab();
//		String scheduleName = createSchedulePageProp.getProperty("scheduleNoDaySelected");
//		sp.clickCreateNewScheduleButton();
//		enterScheduleName(scheduleName);
//		csp.clickSave();
//		String actualValidationMsg = csp.getActualSelectDayValidationMsg();
//		String expectedValidationMsg = createSchedulePageProp.getProperty("expectedSelectDayValidationMsg");
//		Assert.assertEquals(actualValidationMsg, expectedValidationMsg,
//				"No Days selected Validation message not displayed");
//		csp.clickCancelButton();
//		log.info("Verify no Day Selected Verification - End");
//		log.info("-----------------------------------------XXX--------------------------------------");
//	}
//
//	/**
//	 * Checking end Date Verification
//	 * 
//	 * @throws InterruptedException
//	 * @throws AWTException
//	 */
//	@Test(priority = 15)
//	public void verifyEndDateVerification() throws IOException, InterruptedException, AWTException {
//		log.info("---------------------------------------------------------------------------------");
//		log.info("Verify end Date Verification - Begin");
//		np.navigateToHomeAndClickOnProcessesTab();
//		np.schedulesSubTab();
//		String scheduleName = createSchedulePageProp.getProperty("scheduleEnddateVerification");
//		sp.clickCreateNewScheduleButton();
//		enterScheduleName(scheduleName);
//		csp.enterEndDate(createSchedulePageProp.getProperty("endDateValueSmaller"));
//		csp.enterStartDate(createSchedulePageProp.getProperty("startDateValueGreater"));
//		csp.selectMonday();
//		csp.clickSave();
//		String actualValidationMsg = csp.getActualEnddateValidationMsg();
//		String expectedValidationMsg = createSchedulePageProp.getProperty("expectedEnddateValidationMsg");
//		Assert.assertEquals(actualValidationMsg, expectedValidationMsg,
//				"End date verification Validation message not displayed");
//		csp.clickCancelButton();
//		log.info("Verify end Date Verification - End");
//		log.info("-----------------------------------------XXX--------------------------------------");
//	}
//	
//	/**
//	 * check Default Values In Create Schedule Page
//	 */
//	@Test(priority = 16)
//	public void verifyDefaultValuesInCreateSchedulePage() throws InterruptedException, IOException, AWTException {
//		log.info("---------------------------------------------------------------------------------");
//		log.info("Verify Default Values In Create Schedule Page - Begin");
//		np.navigateToHomeAndClickOnProcessesTab();
//		np.schedulesSubTab();
//		sp.clickCreateNewScheduleButton();
//		String expectedNamePlaceHolder = createSchedulePageProp.getProperty("expectedScheduleNamePlaceHolder");
//		String expectedDescriptionPlaceHolder = createSchedulePageProp.getProperty("expectedScheduledescriptionPlaceHolder");
//		String actualNamePlaceHolder= csp.getScheduleNameText();
//		String actualDescriptionPlaceHolder =csp.getScheduleDescriptionText();
//		Assert.assertEquals(actualNamePlaceHolder, expectedNamePlaceHolder, "Name Placeholder is incorrect");
//		Assert.assertEquals(actualDescriptionPlaceHolder, expectedDescriptionPlaceHolder,"Description Placeholder is incorrect");
//		Assert.assertFalse(csp.checkIfMondaySelected());
//		Assert.assertFalse(csp.checkIfTuesdaySelected());
//		Assert.assertFalse(csp.checkIfWednesdaySelected());
//		Assert.assertFalse(csp.checkIfThursdaySelected());
//		Assert.assertFalse(csp.checkIfFridaySelected());
//		Assert.assertFalse(csp.checkIfSaturdaySelected());
//		Assert.assertFalse(csp.checkIfSundaySelected());
//		Assert.assertFalse(csp.checkIfMoveAllSliderTogetherSelected());
//		Assert.assertEquals(csp.getStartDateValue(), getCurrentDate(),
//				"By default current date is not displayed or is displayed in different format");
//		log.info("Verify Default Values In Create Schedule Page - End");
//		log.info("-----------------------------------------XXX--------------------------------------");
//	}
//	
//	/**
//	 * enter schedule name
//	 */
//	public void enterScheduleName(String name) {
//		csp.setScheduleName(name);
//	}
//
//	/**
//	 * enter schedule description
//	 */
//	public void enterScheduleDescription(String description) {
//		csp.setScheduleDescription(description);
//	}
//
//	/**
//	 * enter schedule name and description
//	 */
//	public void enterScheduleNameAndDescription(String name, String description) {
//		csp.setScheduleName(name);
//		csp.setScheduleDescription(description);
//	}

}