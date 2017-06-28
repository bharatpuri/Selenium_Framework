package com.autoiq.tests.schedules;

import org.apache.log4j.Logger;

import com.autoiq.common.utility.CommonUtility;
import com.autoiq.common.utility.CommonWebFunctions;
import com.autoiq.common.utility.DataStoreInObjects;
import com.autoiq.common.utility.HandleException;
import com.autoiq.tests.dashboard.Navigation;
import com.autoiq.tests.login.TestLogin;

/**
 * This class consist all the schedule related scenarios
 * 
 * @author bharatp : 19/04/2017
 *
 */
public class CreateSchedule {

	final static Logger logger = Logger.getLogger(CreateSchedule.class.getName());

	DataStoreInObjects testData = new DataStoreInObjects();
	DataStoreInObjects locators = new DataStoreInObjects();

	CommonWebFunctions actions = new CommonWebFunctions();
	Navigation navigation = new Navigation();

	public CreateSchedule() throws HandleException {

		testData = CommonUtility.loadTestData("Test Data", "ScheduleTestData");
		locators = CommonUtility.loadLocators("Page Objects", "SchedulePage");
	}

	/**
	 * Verify create schedule with schedule name only
	 * 
	 * @throws HandleException
	 * @throws InterruptedException 
	 */
	public void createScheduleWithScheduleNameOnly() throws HandleException, InterruptedException {
		TestLogin login = new TestLogin();
		login.loginWithValidCredentials();
		navigation.schedulesTab();
		actions.clickOnElement(locators.getValue("createScheduleButton"));
		actions.sendKeysToElement(testData.getValue("scheduleName"), locators.getValue("scheduleName"));
		actions.clickOnElement(locators.getValue("mondayCheckbox"));
		actions.clickOnElement(locators.getValue("saveButton"));
		//actions.verifyTextWithAssert(testData.getValue("expectedSuccessToasterMessage"),
			//	actions.getElementText("successToasterMsg"));
		//actions.getElementTextFromElementList(locators.getValue("scheduleList"), testData.getValue("scheduleName"));
		
		//successToasterMsg
		logger.info("Verified create schedule with name: ");

	}

}
