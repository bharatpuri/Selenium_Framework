package com.autoiq.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.autoiq.base.TestBase;
import com.autoiq.pages.processes.ProcessOverview;

/**
 * The Class NavBarPage.
 */
public class NavigationBar extends TestBase {
	WebDriver driver = null;
	ProcessOverview op;
	Actions actions;
	
	@FindBy(xpath = "//span[contains(text(), 'DASHBOARD')]")
	WebElement dashboard;

	@FindBy(xpath = "(//div[@class='workitems-title'])")
	WebElement dashboardPageVerifier;

	@FindBy(xpath = "//span[contains(text(), 'REPORTS')]")
	WebElement reports;

	@FindBy(xpath = "//a[contains(text(),'All Reports')]")
	WebElement reportsPageVerifier;
	
	@FindBy(xpath = "//span[contains(text(), 'TOOLS')]")
	WebElement tools;

	@FindBy(xpath = "//a[contains(text(),'Credentials')]")
	WebElement toolsPageVerifier;
	
	@FindBy(xpath = "//a[contains(text(),'Credentials')]")
	WebElement credentials;

	@FindBy(xpath = "//span[contains(text(),'Credential Groups')]")
	WebElement credentialsPageVerifier;

	@FindBy(xpath = "(//span[@class='icon-cogs'])")
	WebElement processes;

	@FindBy(xpath = "//a[contains(text(),'Overview')]")
	WebElement processesPageVerifier;

	@FindBy(xpath = "//a[contains(text(),'Overview')]")
	WebElement overview;

	@FindBy(xpath = "//span[contains(text(),'Create New Process')]")
	WebElement overviewPageVerifier;

	@FindBy(xpath = "//a[contains(text(),' Schedules')]")
	WebElement schedules;

	@FindBy(xpath = "//span[contains(text(),'Create New Schedule')]")
	WebElement schedulesPageVerifier;

	@FindBy(xpath = "//a[contains(text(), 'Definitions')]")
	WebElement definitions;

	@FindBy(xpath = "//span[contains(text(),'Create New Definition')]")
	WebElement definitionsPageVerifier;
	
	@FindBy(xpath = "(//span[@class='report-title'])")
	WebElement allReportsPageVerifier;
	
	@FindBy(xpath = "//div[@class='hamburger-icon']")
	private WebElement hamburgerIcon;

	@FindBy(xpath = "//a[contains(text(),'SETTINGS')]")
	private WebElement setting;

	@FindBy(xpath = "//h2[contains(text(),'Choose your theme')]")
	WebElement settingsPageVerifier;

	@FindBy(xpath = "(//ul/li[@class='text-center active'])")
	WebElement allReports;

	@FindBy(xpath = "(//ul/li[@class='text-center'])")
	WebElement buildcustomReport;
	

	/**
	 * Instantiates a new Create Process page.
	 * 
	 * @param driver
	 *            the driver
	 */
	public NavigationBar(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);

	}

	/**
	 * Navigate to Dashboard page
	 */

	public void dashboardTab() {
		log.info("dashboard Tab - Begin");
		navigateToDashboardPage();
		dashboardPageVerification();
		wait(2);
		log.info("dashboard Tab - End");
	}

	/**
	 * Navigate to Reports page
	 */

	public void reportsTab() {
		log.info("reports Tab - Begin");
		navigateToReportsPage();
		reportsPageVerification();
		wait(2);
		log.info("reports Tab - End");
	}

	/**
	 * Navigate to Process Page
	 */
	public void processesTab() {
		log.info("processes Tab - Begin");
		navigateToProcessesPage();
		processesPageVerification();
		wait(2);
		log.info("processes Tab - End");
	}
	
	/**
	 * Navigate to Tools Page
	 */
	public void toolsTab() {
		log.info("tool Tab - Begin");
		navigateToToolsPage();
		toolsPageVerification();
		wait(2);
		log.info("tools Tab - End");
	}
	
	/**
	 * Navigate to Process Page
	 */
	public void navigateToHomeAndClickOnProcessesTab() {
		log.info("Navigate to home page and click on processes Tab - Begin");
		navigateToHomePage();
		processesTab();
		log.info("Navigate to home page and click on processes Tab - End");
	}

	/**
	 * Navigate to Overview Page
	 */

	public void overviewSubTab() {
		log.info("overview sub Tab - Begin");
		navigateToOverviewPage();
		overviewPageVerification();
		wait(2);
		log.info("overview Sub Tab - End");
	}

	/**
	 * Navigate to Schedules Page
	 */

	public void schedulesSubTab() {
		log.info("schedules Sub Tab - Begin");
		navigateToSchedulesPage();
		schedulesPageVerification();
		wait(2);
		log.info("schedules Sub Tab - End");
	}

	/**
	 * Navigate to Definitions Page
	 */
	public void definitionsSubTab() {
		log.info("definitions Sub Tab - Begin");
		wait(2);
		navigateToDefinitionsPage();
		definitionsPageVerification();
		wait(2);
		log.info("definitions Sub Tab - End");
	}
	
	/**
	 * Navigate to Credentials Page
	 */
	public void credentialsSubTab() {
		log.info("credentials Sub Tab - Begin");
		wait(2);
		navigateToCredentialsPage();
		credentialsPageVerification();
		wait(2);
		log.info("credentials Sub Tab - End");
	}

	/**
	 * Navigate to All Report sub tab
	 */
	public void allReportSubTab() {
		log.info("All Reports Sub Tab - Begin");
		wait(2);
		navigateToAllReportsPage();
		allReportsPageVerification();
		wait(2);
		log.info("All Reports Sub Tab - End");
	}
	
	/**
	 * Navigate to Dashboard Page
	 */
	public void navigateToDashboardPage() {
		log.info("navigate To Dashboard Page - Begin");
		actions.moveToElement(dashboard).click().perform();
		log.info("navigate To Dashboard Page - End");
	}

	public void dashboardPageVerification() {
		log.info("dashboard Page Verification - Begin");
		waitForElementVisible(dashboardPageVerifier, 5);
		log.info("dashboard Page Verification - End");
	}

	public void navigateToReportsPage() {
		log.info("navigate To Reports Page - Begin");
		actions.moveToElement(reports).click().perform();
		log.info("navigate To Reports Page - End");
	}

	public void reportsPageVerification() {
		log.info("reports Page Verification - Begin");
		reportsPageVerifier.isDisplayed();
		log.info("reports Page Verification - End");
	}

	public void navigateToProcessesPage() {
		log.info("navigate To Processes Page - Begin");
		wait(2);
		actions.moveToElement(processes).click().perform();
		log.info("navigate To Processes Page - End");
	}
	
	public void navigateToToolsPage() {
		log.info("navigate To Tools Page - Begin");
		actions.moveToElement(tools).click().perform();
		log.info("navigate To Tools Page - End");
	}

	public void toolsPageVerification() {
		log.info("tools Page Verification - Begin");
		toolsPageVerifier.isDisplayed();
		log.info("tools Page Verification - End");
	}

	public void processesPageVerification() {
		log.info("processes Page Verification - Begin");
		processesPageVerifier.isDisplayed();
		log.info("processes Page Verification - End");
	}

	public void navigateToOverviewPage() {
		log.info("navigate To Overview Page - Begin");
		actions.moveToElement(overview).click().perform();
		log.info("navigate To Overview Page - End");
	}

	public void overviewPageVerification() {
		log.info("overview Page Verification - Begin");
		overviewPageVerifier.isDisplayed();
		log.info("overview Page Verification - End");
	}

	public void navigateToSchedulesPage() {
		log.info("navigate To Schedules Page - Begin");
		actions.moveToElement(schedules).click().perform();
		log.info("navigate To Schedules Page - End");
	}

	public void schedulesPageVerification() {
		log.info("schedules Page Verification - Begin");
		schedulesPageVerifier.isDisplayed();
		log.info("schedules Page Verification - End");
	}

	public void navigateToDefinitionsPage() {
		log.info("navigate To Definitions Page - Begin");
		actions.moveToElement(definitions).click().perform();
		log.info("navigate To Definitions Page - End");
	}

	public void definitionsPageVerification() {
		log.info("definitions Page Verification - Begin");
		definitionsPageVerifier.isDisplayed();
		log.info("definitions Page Verification - End");
	}
	
	public void navigateToCredentialsPage() {
		log.info("navigate To Credentials Page - Begin");
		actions.moveToElement(credentials).click().perform();
		log.info("navigate To Credentials Page - End");
	}
	
	public void credentialsPageVerification() {
		log.info("credentials Page Verification - Begin");
		credentialsPageVerifier.isDisplayed();
		log.info("credentials Page Verification - End");
	}
	
	public void allReportsPageVerification() {
		log.info("All Reports Page Verification - Begin");
		allReportsPageVerifier.isDisplayed();
		log.info("All Reports Page Verification - End");
	}

	/**
	 * Navigate to settings page
	 */
	public void navigateToSettingsPage() {
		log.info("navigate To Settings Page - Begin");
		hamburgerIcon.click();
		wait(1);
		setting.click();
		log.info("navigate To Settings Page - End");
	}

	/**
	 * Settings page verification
	 */
	public void settingsPageVerification() {
		log.info("Settings Page Verification - Begin");
		settingsPageVerifier.isDisplayed();
		log.info("Settings Page Verification - End");
	}
	
	/**
	 * navigate to Home page through url
	 */
	public void navigateToHomePage() {
		log.info("Navigate to Home page through url - Begin");
		String currentUrl = driver.getCurrentUrl();
		driver.get(currentUrl.substring(0,33));
		wait(2);
		log.info("Navigate to Home page through url - End");
	}
	
	/**
	 * navigate to Home page through url
	 */
	public void navigateToAllReportsPage() {
		log.info("Navigate to All Reports Page - Begin");
		actions.moveToElement(allReports).click().perform();
		log.info("Navigate to All Reports Page - End");
	}
}


