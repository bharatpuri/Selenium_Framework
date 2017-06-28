package com.autoiq.pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.autoiq.base.TestBase;

/**
 * The Class LoginPage.
 */
public class Login extends TestBase {
	WebDriver driver = null;
	
	@FindBy(xpath = "//input[@name='j_username']")
	public WebElement userName;

	@FindBy(xpath = "//input[@name='j_password']")
	public WebElement password;

	@FindBy(xpath = "//input[@value='LOGIN']")
	public WebElement login;

	@FindBy(xpath = "//div[contains(text(), 'Did You Know !')]")
	public WebElement loginPageText;

	@FindBy(xpath = "//div[@id='error-box']")
	public WebElement invalidCredentialMsg;

	/**
	 * Instantiates a new Login page.
	 * 
	 * @param driver
	 *            the driver
	 */
	public Login(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}

	/**
	 * Set user name in textbox
	 * 
	 * @param strUserName
	 */

	public void setUserName(String strUserName) {
		userName.clear();
		userName.sendKeys(strUserName);
	}

	/**
	 * Set password in password textbox
	 * 
	 * @param strPassword
	 */

	public void setPassword(String strPassword) {
		password.clear();
		password.sendKeys(strPassword);
	}

	/**
	 * Click on login button
	 */
	public void clickLogin() {
		login.click();
	}

	/**
	 * Get login button text
	 * 
	 * @return login button text
	 */
	public String getLoginButtonText() {
		return login.getText();
	}

	/**
	 * Get login page text
	 * 
	 * @return login page text
	 */
	public String getLoginPageText() {
		return loginPageText.getText();
	}

	/**
	 * Get error message text
	 * 
	 * @return login invalid creadentials message
	 */
	public String getInvalidCredentialMsg() {
		return invalidCredentialMsg.getText();
	}

	/**
	 * 
	 * This POM method will be exposed in test case to login in the application
	 * 
	 * @param strUserName
	 * 
	 * @param strPasword
	 * 
	 * @throws InterruptedException
	 */

	public void login(String strUserName, String strPasword) throws InterruptedException {
		this.setUserName(strUserName);
		this.setPassword(strPasword);
		this.clickLogin();
		wait(1);
		
	}
}
