package com.autoiq.pages.reports;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.autoiq.base.TestBase;

/**
 * The Class AllReports Page.
 */
public class AllReports extends TestBase {
	WebDriver driver = null;
	int index;

	@FindBy(xpath = "(//a[@aria-controls='favorite-reports'])")
	WebElement favorites;

	@FindBy(xpath = "(//a[@aria-controls='all-reports'])")
	WebElement all;

	@FindBy(xpath = "(//button[@class='btn btn-xs']/i[@class='icon-sort-name-up'])[2]")
	WebElement sortButton;

	@FindBy(xpath = "(//i[@class='icon-search'])[2]")
	WebElement searchButton;

	@FindBy(xpath = "(//div[@aria-labelledby='standardReports']/ul/li)")
	List<WebElement> standardReports;
	
	@FindBy(xpath = "(//div[@aria-labelledby='customReports']/ul/li)")
	List<WebElement> customReports;

	@FindBy(xpath = "(//div[@class='load-more-items']/button)")
	WebElement showMoreOrLess;
	
	@FindBy(xpath = "(//div/span/i[@class='icon-star-empty'])")
	WebElement favoriteIconOnRight;
	
	@FindBy(xpath = "(//i[@class='icon-print-1'])")
	WebElement printIcon;
	
	@FindBy(xpath = "(//i[@class='icon-download-alt'])")
	WebElement downloadIcon;
	
	@FindBy(xpath = "(//i[@class='icon-export-1'])")
	WebElement exportIcon;
	
	@FindBy(xpath = "(//i[@class='icon-trash-4'])")
	WebElement deleteIcon;
	
	@FindBy(xpath = "(//i[@class='icon-pencil-3'])")
	WebElement editIcon;
	
	@FindBy(xpath = "(//i[@class='icon-resize-full'])")
	WebElement screenResizeIcon;
	
	@FindBy(xpath = "(//span[@aria-controls='standardReports']/i[@class='icon-angle-up'])")
	WebElement standardReportChevronUpIcon;
	
	@FindBy(xpath = "(//span[@aria-controls='customReports']/i[@class='icon-angle-up'])")
	WebElement customReportChevronUpIcon;
	
	@FindBy(xpath = "(//span[@aria-controls='standardReports']/i[@class='icon-angle-down'])")
	WebElement standardReportChevronDownIcon;
	
	@FindBy(xpath = "(//span[@aria-controls='customReports']/i[@class='icon-angle-down'])")
	WebElement customReportChevronDownIcon;

	/**
	 * All Reports Page
	 * 
	 * @param driver
	 *            the driver
	 */
	public AllReports(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}

	/**
	 * clicks on show more / show less button
	 */
	public void clickOnShowMoreOrLessButton() {
		showMoreOrLess.click();
		wait(2);
	}
	
	/**
	 * checks if showmore button present
	 */
	public boolean isShowmoreButtonPresent() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		try {
			return driver.findElements(By.xpath("(//div[@class='load-more-items']/button)")).size() > 0;
		} finally {
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		}
	}
	
	/**
	 * gets button text
	 */
	public String getShowmoreShowlessButtonText(){
		return showMoreOrLess.getText();
	}
	
	/**
	 * verifies Report page contents
	 */
	public void reportPageContentVerification() {
		log.info("Report Page Content Verification - Begin");
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		try {
			Assert.assertTrue(isElementDisplayed(all), "All tab is not displayed on Reports Page");
			Assert.assertTrue(isElementDisplayed(favorites), "Favorites tab is not displayed on Reports Page");
			Assert.assertTrue(isElementDisplayed(sortButton), "Sort button is not displayed on Reports Page");
			Assert.assertTrue(isElementDisplayed(searchButton), "Search button is not displayed on Reports Page");
		} finally {
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		}
		log.info("Report Page Content Verification - End");
	}
	
	/**
	 * clicks on Standard Report Chevron Up Icon
	 */
	public void clickOnStdReportChevronUpIcon() {
		standardReportChevronUpIcon.click();
	}
	
	/**
	 * clicks on Standard Report Chevron down Icon
	 */
	public void clickOnStdReportChevronDownIcon() {
		standardReportChevronDownIcon.click();
	}
	
	/**
	 * clicks on custom Report Chevron Up Icon
	 */
	public void clickOnCustomReportChevronUpIcon() {
		customReportChevronUpIcon.click();
	}
	
	/**
	 * clicks on custom Report Chevron down Icon
	 */
	public void clickOnCustomReportChevronDownIcon() {
		customReportChevronDownIcon.click();
	}
	
	/**
	 * clicks on standard Reports by index
	 */
	public void clickOnStandardReportByIndex(int index) {
		standardReports.get(index).click();
	}
	
	/**
	 * gets total standard reports count
	 */
	public int getTotalreportsCount() {
		return standardReports.size();
	}
	
	/**
	 * verifies Report page contents
	 */
	public void verifyChevronIcon() {
		log.info("Report Page Content Verification - Begin");
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		try {
			Assert.assertTrue(standardReportChevronUpIcon.isDisplayed(), "Standard Report Chevron Up Icon is not displayed on Reports Page");
			clickOnStdReportChevronUpIcon();
			wait(1);
			Assert.assertTrue(standardReportChevronDownIcon.isDisplayed(), "Standard Report Chevron Down Icon is not displayed on Reports Page");
			Assert.assertFalse(standardReportChevronUpIcon.isDisplayed(), "Standard Report Chevron Up Icon should not be displayed on Reports Page");
			clickOnStdReportChevronDownIcon();
			wait(1);
			Assert.assertFalse(standardReportChevronDownIcon.isDisplayed(), "Standard Report Chevron Down Icon should not be displayed on Reports Page");
			Assert.assertTrue(standardReportChevronUpIcon.isDisplayed(), "Standard Report Chevron Up Icon is not displayed on Reports Page");
			
			Assert.assertTrue(customReportChevronUpIcon.isDisplayed(), "Custom Report Chevron Up Icon is not displayed on Reports Page");
			clickOnCustomReportChevronUpIcon();
			wait(1);
			Assert.assertTrue(customReportChevronDownIcon.isDisplayed(), "Custom Report Chevron Down Icon is not displayed on Reports Page");
			Assert.assertFalse(customReportChevronUpIcon.isDisplayed(), "Custom Report Chevron Up Icon should not be displayed on Reports Page");
			clickOnCustomReportChevronDownIcon();
			wait(1);
			Assert.assertFalse(customReportChevronDownIcon.isDisplayed(), "Custom Report Chevron Doen Icon should not be displayed on Reports Page");
			Assert.assertTrue(customReportChevronUpIcon.isDisplayed(), "Custom Report Chevron Up Icon is not displayed on Reports Page");
		} finally {
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		}
		log.info("Report Page Content Verification - End");
	}
	
	/**
	 * report Page Right Panel Content Verification
	 */
	public void reportPageRightPanelContentVerification() {
		log.info("Report Page Right Panel Content Verification - Begin");
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		try {
			Assert.assertTrue(isElementDisplayed(favoriteIconOnRight), "Favorite button is not displayed on Reports Page");
			Assert.assertTrue(isElementDisplayed(printIcon), "Print button is not displayed on Reports Page");
			Assert.assertTrue(isElementDisplayed(downloadIcon), "Download button is not displayed on Reports Page");
			Assert.assertTrue(isElementDisplayed(exportIcon), "Export button is not displayed on Reports Page");
			Assert.assertTrue(isElementDisplayed(deleteIcon), "Delete button is not displayed on Reports Page");
			Assert.assertTrue(isElementDisplayed(editIcon), "Eidt button is not displayed on Reports Page");
			Assert.assertTrue(isElementDisplayed(screenResizeIcon), "Screen resize button is not displayed on Reports Page");
		} finally {
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		}
		log.info("Report Page Right Panel Content Verification - End");
	}

}
