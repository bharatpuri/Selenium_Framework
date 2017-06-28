package com.autoiq.pages.processes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.autoiq.base.TestBase;

/**
 * The Class DeleteProcessPage.
 */
public class DeleteProcess extends TestBase{
	WebDriver driver = null;
	ProcessOverview op;

	@FindBy(xpath = "//button[contains(text(),'Yes')")
	WebElement yesButton;

	/**
	 * Instantiates a new Create Process page.
	 * 
	 * @param driver
	 *            the driver
	 */
	public DeleteProcess(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
	
	
	
}
