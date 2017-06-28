package com.autoiq.pages.dashboard;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.autoiq.base.TestBase;

public class Dashboard extends TestBase {
	
	WebDriver driver = null;

	@FindBy(xpath = "(//div[@class='workitems-title'])")
	WebElement workItemsWidget;

	@FindBy(xpath = "(//div[@class='robots-summary-title'])")
	WebElement robotsSummaryWidget;
	
	@FindBy(xpath = "(//div[@class='alerts-notifications-title'])")
	WebElement alertsAndNotificationWidget;
	
	@FindBy(xpath = "(//div[@class='high-priority-label priority-label clearfix'])")
	 WebElement highPriortyWidget;
	 
	 @FindBy(xpath = "(//div[@class='normal-priority-label priority-label clearfix'])")
	 WebElement normalWidget;
	 
	 @FindBy(xpath = "(//div[@class='medium-priority-label priority-label clearfix'])")
	 WebElement mediumWidget;
	 
	 @FindBy(xpath = "(//div[@class='robots-summary-label'])[1]")
	 WebElement licensedWidget;
	 
	 @FindBy(xpath = "(//div[@class='robots-summary-label'])[2]")
	 WebElement activeWidget;
	 
	 @FindBy(xpath = "(//div[@class='robots-summary-label'])[3]")
	 WebElement inActiveWidget;
	 
	 @FindBy(xpath = "(//div[@class='workitem-label'])[1]")
	 WebElement failedWidget;
	 
	 @FindBy(xpath = "(//div[@class='workitem-label'])[2]")
	 WebElement processedWidget;
	 
	 @FindBy(xpath = "(//div[@class='workitem-label'])[1]")
	 WebElement totalWidget;
	
	/**
	 * Instantiates a new Create Process page.
	 * 
	 * @param driver
	 *            the driver
	 */
	public Dashboard(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
	
	/**
	 *  verifies dashboard page contents
	 */
	public void dashboardPageContentVerification() {
		log.info("Dashboard Page Content Verification - Begin");
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		try {
			Assert.assertTrue(isElementDisplayed(workItemsWidget), "Work Items widget is not displayed on Dashboard Page");
			Assert.assertTrue(isElementDisplayed(workItemsWidget), "Robots Summary widget is not displayed on Dashboard Page");
			Assert.assertTrue(isElementDisplayed(workItemsWidget), "Alerts and Notifications widget is not displayed on Dashboard Page");
		} finally {
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		}
		log.info("Dashboard Page Content Verification - End");
	}
	
	 /**
	  *  verifies dashboard page sub contents
	  */
	 public void dashboardPageSubContentVerification() {
	  log.info("Dashboard Page Sub Content Verification - Begin");
	  alertsAndNotificationsContentVerification();
	  robotsSummaryContentVerification();
	  workItemsContentVerification();
	  log.info("Dashboard Page Sub Content Verification - End");
	 }
	 
	 /**
	  *  vAlerts And Notifications Content Verification
	  */
	 public void alertsAndNotificationsContentVerification() {
	  log.info("Alerts And Notifications Content Verification - Begin");
	  driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	  try {
	   Assert.assertTrue(isElementDisplayed(highPriortyWidget), "High Priority widget is not displayed on Dashboard Page");
	   Assert.assertTrue(isElementDisplayed(normalWidget), "Normal widget is not displayed on Dashboard Page");
	   Assert.assertTrue(isElementDisplayed(mediumWidget), "Medium widget is not displayed on Dashboard Page");
	  } finally {
	   driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  }
	  log.info("Alerts And Notifications Content Verification - End");
	 }
	 
	 /**
	  *  Robots Summary Content Verification
	  */
	 public void robotsSummaryContentVerification() {
	  log.info("Robots Summary Content Verification - Begin");
	  driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	  try {
	   Assert.assertTrue(isElementDisplayed(licensedWidget), "License widget is not displayed on Dashboard Page");
	   Assert.assertTrue(isElementDisplayed(activeWidget), "Active widget is not displayed on Dashboard Page");
	   Assert.assertTrue(isElementDisplayed(inActiveWidget), "Inactive widget is not displayed on Dashboard Page");
	  } finally {
	   driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  }
	  log.info("Robots Summary Content Verification - End");
	 }
	 
	 /**
	  *  Work Item Content Verification 
	  */
	 public void workItemsContentVerification() {
	  log.info("Work Item Content Verification - Begin");
	  driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	  try {
	   Assert.assertTrue(isElementDisplayed(failedWidget), "Failed widget is not displayed on Dashboard Page");
	   Assert.assertTrue(isElementDisplayed(processedWidget), "Processed widget is not displayed on Dashboard Page");
	   Assert.assertTrue(isElementDisplayed(totalWidget), "Total widget is not displayed on Dashboard Page");
	  } finally {
	   driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  }
	  log.info("Work Item Content Verification - End");
	 }

}
