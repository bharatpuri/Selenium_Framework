package com.autoiq.tests.dashboard;

import org.apache.log4j.Logger;

import com.autoiq.common.utility.CommonUtility;
import com.autoiq.common.utility.CommonWebFunctions;
import com.autoiq.common.utility.DataStoreInObjects;
import com.autoiq.common.utility.HandleException;

/**
 * This class consist all the Dashboard content verification scenarios
 * 
 * @author bharatp : 17/04/2017
 *
 */
public class Dashboard {

	final static Logger logger = Logger.getLogger(Dashboard.class.getName());
	CommonWebFunctions actions = new CommonWebFunctions();

	DataStoreInObjects locators;

	public Dashboard() throws HandleException {
		locators = new DataStoreInObjects();
		locators = CommonUtility.loadLocators("Page Objects", "DashboardPage");

	}

	/**
	 * Verify dashboard page sub contents
	 * 
	 * @throws HandleException
	 */
	public void dashboardPageSubContentVerification() throws HandleException {
		alertsAndNotificationsContentVerification();
		robotsSummaryContentVerification();
		workItemsContentVerification();
		logger.info("Verified dashboard sub content: ");

	}

	/**
	 * Verify Alerts And Notifications Content Verification
	 * 
	 * @throws HandleException
	 */
	public void alertsAndNotificationsContentVerification() throws HandleException {
		actions.verifyElementIsdisplayed(locators.getValue("highPriortyWidget"));
		actions.verifyElementIsdisplayed(locators.getValue("mediumWidget"));
		actions.verifyElementIsdisplayed(locators.getValue("normalWidget"));
		logger.info("Verified alerts and notifications content: ");
	}

	/**
	 * Verify Robots Summary Content Verification
	 * 
	 * @throws HandleException
	 */
	public void robotsSummaryContentVerification() throws HandleException {
		actions.verifyElementIsdisplayed(locators.getValue("licensedWidget"));
		actions.verifyElementIsdisplayed(locators.getValue("activeWidget"));
		actions.verifyElementIsdisplayed(locators.getValue("inActiveWidget"));
		logger.info("Verified robots summary content: ");
	}

	/**
	 * Verify Work Item Content Verification
	 * 
	 * @throws HandleException
	 */
	public void workItemsContentVerification() throws HandleException {
		actions.verifyElementIsdisplayed(locators.getValue("failedWidget"));
		actions.verifyElementIsdisplayed(locators.getValue("processedWidget"));
		actions.verifyElementIsdisplayed(locators.getValue("totalWidget"));
		logger.info("Verified work item content: ");
	}
}
