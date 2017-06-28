package com.autoiq.tests.dashboard;

import org.apache.log4j.Logger;

import com.autoiq.common.utility.CommonUtility;
import com.autoiq.common.utility.CommonWebFunctions;
import com.autoiq.common.utility.DataStoreInObjects;
import com.autoiq.common.utility.HandleException;

/**
 * This class consist all the Navigation scenarios
 * 
 * @author bharatp : 17/04/2017
 *
 */
public class Navigation {
	final static Logger logger = Logger.getLogger(Navigation.class.getName());
	CommonWebFunctions actions = new CommonWebFunctions();
	DataStoreInObjects locators = new DataStoreInObjects();

	public Navigation() throws HandleException {
		locators = CommonUtility.loadLocators("Page Objects", "NavigationBarPage");

	}

	/**
	 * Verify Main Navigation Bar
	 * 
	 * @throws HandleException
	 * 
	 */
	public void mainNevigationBar() throws HandleException {
		dashboardTap();
		reportsTab();
		processesTab();
		toolsTab();
		logger.info("Verified main navigation bar: ");

	}

	/**
	 * Verify Sub Navigation Bar
	 * 
	 * @throws HandleException
	 */
	public void subNavigationBar() throws HandleException {
		overviewTab();
		schedulesTab();
		definitionsTab();
		logger.info("Verified sub navigation bar: ");

	}

	/**
	 * Verify dashboard page displayed
	 * 
	 * @throws HandleException
	 */
	public void dashboardTap() throws HandleException {
		actions.clickOnElement(locators.getValue("dashboard"));
		actions.verifyElementIsdisplayed(locators.getValue("dashboardPageVerifier"));
		logger.info("Verified dashboard tap: ");

	}

	/**
	 * Verify reports page displayed
	 * 
	 * @throws HandleException
	 */
	public void reportsTab() throws HandleException {
		actions.clickOnElement(locators.getValue("reports"));
		actions.verifyElementIsdisplayed(locators.getValue("reportsPageVerifier"));
		logger.info("Verified reports tap: ");

	}

	/**
	 * Verify processes page displayed
	 * 
	 * @throws HandleException
	 */
	public void processesTab() throws HandleException {
		actions.clickOnElement(locators.getValue("processes"));
		actions.verifyElementIsdisplayed(locators.getValue("processesPageVerifier"));
		logger.info("Verified processes tap: ");

	}

	/**
	 * Verify tools page displayed
	 * 
	 * @throws HandleException
	 */
	public void toolsTab() throws HandleException {
		actions.clickOnElement(locators.getValue("tools"));
		actions.verifyElementIsdisplayed(locators.getValue("toolsPageVerifier"));
		logger.info("Verified tools tap: ");

	}

	/**
	 * Verify overview page displayed
	 * 
	 * @throws HandleException
	 */
	public void overviewTab() throws HandleException {
		actions.clickOnElement(locators.getValue("processes"));
		actions.clickOnElement(locators.getValue("overview"));
		actions.verifyElementIsdisplayed(locators.getValue("overviewPageVerifier"));
		logger.info("Verified overview tap: ");

	}

	/**
	 * Verify schedules page displayed
	 * 
	 * @throws HandleException
	 */
	public void schedulesTab() throws HandleException {
		actions.clickOnElement(locators.getValue("processes"));
		actions.clickOnElement(locators.getValue("schedules"));
		actions.verifyElementIsdisplayed(locators.getValue("schedulesPageVerifier"));
		logger.info("Verified schedules tap: ");

	}

	/**
	 * Verify definitions page displayed
	 * 
	 * @throws HandleException
	 */
	public void definitionsTab() throws HandleException {
		actions.clickOnElement(locators.getValue("processes"));
		actions.clickOnElement(locators.getValue("definitions"));
		actions.verifyElementIsdisplayed(locators.getValue("definitionsPageVerifier"));
		logger.info("Verified definitions tap: ");

	}
	
	public void navigateToHomePage() {
		logger.info("Navigate to Home page through url - Begin");
		String currentUrl = CommonWebFunctions.driver.getCurrentUrl();
		CommonWebFunctions.driver.get(currentUrl.substring(0,33));
		logger.info(currentUrl);
		logger.info("Navigate to Home page through url - End");
	}

}
