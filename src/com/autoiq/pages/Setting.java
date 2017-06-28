package com.autoiq.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.autoiq.base.TestBase;

/**
 * The Class LoginPage.
 */
public class Setting extends TestBase {
	WebDriver driver = null;

	@FindBy(xpath = "//label[@class='form-check-label btn btn-default'][1]")
    WebElement twelveHour;

	@FindBy(xpath = "//label[@class='form-check-label btn btn-default'][2]")
	WebElement twentyfourHour;
	
	/**
	 * Instantiates a new Login page.
	 * 
	 * @param driver
	 *            the driver
	 */
	public Setting(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}

	/**
	 * Clicks on 12 hr radio button
	 */
	public void clickTwelveHr() {
		twelveHour.click();
	}

	/**
	 * Clicks on 24 hr radio button
	 */
	public void clickTwentyFourHr() {
		twentyfourHour.click();
	}


}
