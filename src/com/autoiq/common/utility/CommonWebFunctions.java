package com.autoiq.common.utility;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * This class consist all the selenium methods
 * 
 * @author bharatp : 11/04/2017
 *
 */

public class CommonWebFunctions {

	final static Logger logger = Logger.getLogger(CommonWebFunctions.class.getName());
	DataStoreInObjects locators = new DataStoreInObjects();
	public static WebDriver driver;
	private WebElement webElement;
	private List<WebElement> allElements;

	// public CommonWebFunctions() throws HandleException {
	// locators = CommonUtility.loadLocators("Page Objects", "ProcessPage");

	// }
	public WebDriver driver() throws HandleException {
		DataStoreInObjects configData = new DataStoreInObjects();
		configData = CommonUtility.loadConfigData("Configuration Files", "config");
		String os = System.getProperty("os.name").toLowerCase();
		String browserName = configData.getValue("browser");

		if (driver == null) {
			if (browserName.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
				Log.info("New Mozila driver instantiated");

			} else if (browserName.equalsIgnoreCase("chrome")) {

				if (os.contains("windows")) {
					// System.setProperty("webdriver.chrome.driver",
					// configData.getValue("windows_chromeDriverPath"));
					driver = new ChromeDriver();
					logger.info("New Chrome driver instantiated");
				} else if (os.contains("linux")) {
					System.setProperty("webdriver.chrome.driver", configData.getValue("linux_chromeDriverPath"));
					driver = new ChromeDriver();
	
					logger.info("New Chrome driver instantiated");
				} else if (os.contains("mac")) {
					System.setProperty("webdriver.chrome.driver", configData.getValue("mac_chromeDriverPath"));
					driver = new ChromeDriver();
				}

			} else if (browserName.equalsIgnoreCase("ie")) {
				logger.info("New IE driver instantiated");

				if (os.contains("linux")) {
					System.setProperty("webdriver.ie.driver", configData.getValue("ieDriverPath"));
					driver = new InternetExplorerDriver();
				} else if (os.contains("mac")) {
					System.setProperty("webdriver.ie.driver", configData.getValue("ieDriverPath"));
					driver = new InternetExplorerDriver();
				} else if (os.contains("windows")) {
					System.setProperty("webdriver.ie.driver", configData.getValue("windows_ieDriverPath"));
					driver = new InternetExplorerDriver();
				}

			} else if (configData.getValue("browser").equalsIgnoreCase("headless")) {
				System.setProperty("phantomjs.binary.path", configData.getValue("phantomjsDriverPath"));
				driver = new PhantomJSDriver();

			}
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			logger.info("Implicit wait applied on the driver for 60 seconds");

			driver.manage().window().maximize();
			logger.info("Maximixe the window");
			return driver;
		} else
			throw new HandleException("Failed to instaintiated the browser: " + driver);
	}
	// /**
	// * This method will get web driver instantiated
	// *
	// * @throws HandleException
	// * @return WebDriver instance
	// * @throws IOException
	// */
	// public WebDriver driver() throws HandleException {
	// DataStoreInObjects configData = new DataStoreInObjects();
	// configData = CommonUtility.loadConfigData("Configuration Files",
	// "config");
	// String browserName = configData.getValue("browser");
	// if (driver == null) {
	// if (browserName.equalsIgnoreCase("chrome")) {
	// driver = new ChromeDriver();
	//
	// Log.info("New Chrome driver instantiated");
	// } else if (browserName.equalsIgnoreCase("firefox")) {
	// driver = new FirefoxDriver();
	// Log.info("New Mozila driver instantiated");
	// }
	// driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	// Log.info("Implicit wait applied on the driver for 60 seconds");
	//
	// driver.manage().window().maximize();
	// Log.info("Maximixe the window");
	// return driver;
	// } else
	// throw new HandleException("Failed to instaintiated the browser: " +
	// driver);
	// }

	/**
	 * This method will launch the web browser with respective URL
	 * 
	 * @throws HandleException
	 * @throws IOException
	 */
	public void launchBrowser() throws HandleException {
		DataStoreInObjects configData = new DataStoreInObjects();
		configData = CommonUtility.loadConfigData("Configuration Files", "config");
		String webURL = configData.getValue("testsiteBaseURl");
		try {
			driver().get(webURL);
			logger.info("Web application launched: " + webURL);
		} catch (HandleException e) {
			throw new HandleException("Failed to launch the browser with:" + webURL);
		}
	}

	/**
	 * This method will quite/close all the Browsers open by selenium webdriver
	 * 
	 * @throws HandleException
	 */
	public static void cleanUp() throws HandleException {
		if (driver != null) {
			driver.close();
			driver.quit();
			driver = null;
			logger.info("Close all the browser open by selenium webdriver");
		} else
			throw new HandleException("Failed while closing/quiting the browser");
	}

	/**
	 * Clicks on web element
	 * 
	 * @param element
	 * @throws HandleException
	 */
	public void clickOnElement(String element) throws HandleException {
		webElement = findElement(element);
		if (waitForElement().until(ExpectedConditions.elementToBeClickable(webElement)).isEnabled()
				&& waitForElement().until(ExpectedConditions.visibilityOf(webElement)).isDisplayed()) {
			webElement.click();
			logger.info("Click action performed on this element: " + element);
		} else
			throw new HandleException("Failed to click on element on this locator: " + element);
	}

	/**
	 * This method will find the webElement with using the provided properties
	 * of the element.
	 * 
	 * @param loctor_type
	 * @param locator_value:
	 * @return : identified WebElement
	 * @throws IOException
	 */
	public WebElement findElement(String locator) throws HandleException {
		WebElement webElement = null;

		String loctor_type = locator.split("=")[0].replace("\"", "");
		String locator_value = locator.split("=", 2)[1].replace("\"", "");

		switch (loctor_type) {
		case "id": // Search the element with Id property
			if (waitForElement().until(ExpectedConditions.visibilityOfElementLocated(By.id(locator_value)))
					.isDisplayed()) {
				webElement = driver.findElement(By.id(locator_value));
			} else
				throw new HandleException("No element found on web page by " + locator_value);
			break;
		case "name": // Search the element with Name property
			if (waitForElement().until(ExpectedConditions.visibilityOfElementLocated(By.name(locator_value)))
					.isDisplayed()) {
				webElement = driver.findElement(By.name(locator_value));
			} else
				throw new HandleException("No element found on web page by " + locator_value);
			break;
		case "cssSelector": // Search the element with cssSelector property
			if (waitForElement().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator_value)))
					.isDisplayed()) {
				webElement = driver.findElement(By.cssSelector(locator_value));
			} else
				throw new HandleException("No element found on web page by " + locator_value);
			break;
		case "xpath": // Search the element with xpath property
			if (waitForElement().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator_value)))
					.isDisplayed()) {
				webElement = driver.findElement(By.xpath(locator_value));
				JavascriptExecutor je = (JavascriptExecutor) driver;
				je.executeScript("arguments[0].scrollIntoView(true);", webElement);

			} else
				throw new HandleException("No element found on web page by " + locator_value);
			break;
		case "className": // Search the element with className property
			if (waitForElement().until(ExpectedConditions.visibilityOfElementLocated(By.className(locator_value)))
					.isDisplayed()) {
				webElement = driver.findElement(By.className(locator_value));
			} else
				throw new HandleException("No element found on web page by " + locator_value);
			break;
		case "linkText": // Search the element with linkText property
			if (waitForElement().until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locator_value)))
					.isDisplayed()) {
				webElement = driver.findElement(By.linkText(locator_value));
			} else
				throw new HandleException("No element found on web page by " + locator_value);
			break;
		case "partialLinkText":// Search the element with partialLinkText
								// property
			if (waitForElement().until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(locator_value)))
					.isDisplayed()) {
				webElement = driver.findElement(By.partialLinkText(locator_value));
			} else
				throw new HandleException("No element found on web page by " + locator_value);
			break;
		case "tagName": // Search the element with tagName property
			if (waitForElement().until(ExpectedConditions.visibilityOfElementLocated(By.tagName(locator_value)))
					.isDisplayed()) {
				webElement = driver.findElement(By.tagName(locator_value));
			} else
				throw new HandleException("Failed invalid locator type: " + locator_value);
			break;
		default:// //Throw exception if any invalid WebElement is found
			throw new HandleException("Failed to read the data from file" + loctor_type);
		}
		return webElement;
	}

	/**
	 * This method will wait util 120 seconds
	 * 
	 * @return
	 * @throws HandleException
	 */
	public WebDriverWait waitForElement() throws HandleException {
		return new WebDriverWait(driver, 120);
	}

	/**
	 * This method will save the screen shot with name "screenshot.png"
	 * 
	 * @throws HandleException
	 * @throws WebDriverException
	 */
	public void getScreenShot() throws WebDriverException, HandleException {
		File screenfile = ((TakesScreenshot) driver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenfile, new File("D:\\screenshot.png"));
		} catch (Exception e) {
			throw new HandleException("Failed to take the screen shot");
		}
	}

	/**
	 * This method will get text from element
	 * 
	 * @param element
	 * @return Text on this element
	 * @throws HandleException
	 */
	public String getElementText(String element) throws HandleException {
		webElement = findElement(element);
		String text = null;
		if (webElement.isDisplayed()) {
			text = webElement.getText();
			logger.info("Text found on this locator: " + element);
		} else {
			throw new HandleException("Failed to get the text on this locator: " + element);
		}
		return text;
	}

	/**
	 * This method will verify the element is present on web page or not
	 * 
	 * @param element
	 * @throws HandleException
	 */
	public boolean verifyElementIsdisplayed(String element) throws HandleException {
		webElement = findElement(element);

		if (!webElement.isDisplayed() == true) {
			logger.info("The element is present on screen : " + element);
			return true;
		} else {
			logger.info("The element is not enabled on screen : " + element);
			return false;
		}

	}

	/**
	 * This method will verify the element is enabled on web page or not
	 * 
	 * @param element
	 * @throws HandleException
	 */
	public boolean verifyElementIsEnabled(String element) throws HandleException {
		webElement = findElement(element);
		if (webElement.isEnabled() == true) {
			logger.info("The element is enabled on screen : " + element);
			return true;
		} else {
			logger.info("The element is not enabled on screen : " + element);
			return false;
		}
	}

	/**
	 * This method will verify the element is selected on web page or not
	 * 
	 * @param element
	 * @throws HandleException
	 */
	public boolean verifyElementIsSelected(String element) throws HandleException {
		webElement = findElement(element);
		if (webElement.isSelected() == true) {
			logger.info("The element is selected on screen : " + element);
			return true;
		} else {
			logger.info("The element is not selected on screen : " + element);
			return false;
		}
	}
	
//	/**
//	 * This method will check element is clickable
//	 * @throws HandleException 
//	 */
//	public boolean isElementClickable(String elementList) throws HandleException {
//		allElements = findElements(elementList);
//		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
//		try {
//			return allElements.size() > 1;
//		} finally {
//			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
//		}
//	}

  	/** This method will check the element clickable by assert false
	 * @param element
	 */
	public void verifyWithAssertFalse(boolean element) {
		Assert.assertFalse(element, "Element should not be clickable");
	}

	/**
	 * This method will get the Text form Alert/Popup message
	 * 
	 * @return it will return the text present on alert
	 * @throws HandleException
	 */
	public String getAlertText() throws HandleException {
		Alert simpleAlert;

		waitForElement().until(ExpectedConditions.alertIsPresent());

		simpleAlert = driver().switchTo().alert();

		String alertText = simpleAlert.getText();

		return alertText;
	}

	/**
	 * This method is use for Handle the Alert as Accept or Dismiss
	 * 
	 * @param action
	 *            will be accept or dismiss
	 * @throws HandleException
	 */
	public void handleAlert(String action) throws HandleException {
		Alert simpleAlert;
		waitForElement().until(ExpectedConditions.alertIsPresent());

		simpleAlert = driver().switchTo().alert();

		if (action.equalsIgnoreCase("accept")) {
			simpleAlert.accept();
		} else
			simpleAlert.dismiss();
	}
	/**
	 * This method will drag and drop the element 
	 * @throws HandleException 
	 */
	public void mouseDragAndDrop(WebElement dragElement, WebElement dropElement) throws HandleException {
		Actions builder = new Actions(driver); // Configure the Action
		Action dragAndDrop = builder.clickAndHold(dragElement).moveToElement(dropElement).release(dropElement).build();
		dragAndDrop.perform();
	}

	/**
	 * This method will Submit on web element
	 * 
	 * @param element
	 */
	public void submitOnElement(String element) throws HandleException {
		webElement = findElement(element);

		if (webElement.isEnabled()) {
			webElement.submit();
			logger.info("Submit action performed on this element: " + element);
		} else
			throw new HandleException("Failed to submit on element with this locator: " + element);
	}

	/**
	 * This method will clears the contents from text field
	 * 
	 * @param element
	 */
	public void clearText(String element) throws HandleException {
		webElement = findElement(element);

		if (webElement.isEnabled()) {
			webElement.clear();
			logger.info("Clear text on this locator: " + element);
		} else
			throw new HandleException("Failed to clear the element text on this locator: " + element);
	}

	/**
	 * This method sends key to web element
	 * 
	 * @param textToSend
	 *            string which sending to the text field
	 * @param element
	 *            name of the on which we are sending the text/data
	 * @throws InterruptedException
	 */
	public void sendKeysToElement(String textToSend, String element) throws HandleException {
		webElement = findElement(element);
		if (webElement.isEnabled()) {
			webElement.clear();
			webElement.sendKeys(textToSend);
			logger.info("Text entered on this locator :" + element + "" + textToSend);
		} else
			throw new HandleException("Failed to send the key on this locator: " + element);
	}

	/**
	 * This method will verify two string
	 * 
	 * @param actualText:
	 *            actual text will get from test data file
	 * @param expectedTest:
	 *            actual text will get form element
	 */
	public void verifyText(String actualText, String expectedText) throws HandleException {

		if (actualText != expectedText) {
			throw new HandleException(
					"Failed actual text is not match with expected text:" + actualText + "" + expectedText);
		} else
			logger.info("Actual text is match with expected text :" + actualText + "" + expectedText);
	}

	/** This method will compare text with contains 
	 * @param actualText
	 * @param expectedTest
	 */
	public void verifyTextWithAssertContains(String actualText, String expectedText) {
		Assert.assertTrue(compareTextContains(actualText, expectedText), "Actual text is not match with expected text");
	}
	
	/** This method verify the string is present in the provided string 
	 * @param textPresent
	 * @param inThisText
	 */
	public void verifyTextContainsInString(String textPresent, String inThisText){
		inThisText.toLowerCase().contains(textPresent.toLowerCase());
		
	}
	
	/** This method will compare text with Assert equals  
	 * @param actualText
	 * @param expectedText
	 */
	public void verifyTextWithAssertEquals(String actualText, String expectedText) {

		Assert.assertEquals(actualText, expectedText);
	}
	
	/** This method will compare two numbers using Assert equals  
	 * @param actualCount
	 * @param expectedCount
	 */
	public void verifyAssertEqualsForInt(int actualCount, int expectedCount) {

		Assert.assertEquals(expectedCount, expectedCount);
	}

	public void verifyTextNotPresentInList(String Locator, String Text) throws HandleException {
		allElements = findElements(Locator);
		String List = allElements.toString();
		Assert.assertFalse(List.contains(Text));
	}

	public void verifyTextPresentInList(String locator, String expectedText) throws HandleException {
		String actualText = getElementTextInElementList(locator, expectedText);
		verifyTextWithAssertContains(actualText, expectedText);
	}

	/**
	 * This method will find the list of webElements with using the provided
	 * properties of the element.
	 * 
	 * @param loctor_type
	 * @param locator_value:
	 * @return : identified WebElement list
	 * @throws IOException
	 */
	public List<WebElement> findElements(String locator) throws HandleException {
		List<WebElement> allElements = null;

		String loctor_type = locator.split("=")[0].replace("\"", "");
		String locator_value = locator.split("=", 2)[1].replace("\"", "");

		switch (loctor_type) {
		case "id": // Search the element with Id property
			if (waitForElement().until(ExpectedConditions.visibilityOfElementLocated(By.id(locator_value)))
					.isDisplayed()) {
				allElements = driver.findElements(By.id(locator_value));
			} else
				throw new HandleException("No element list found on web page by " + locator_value);
			break;
		case "name": // Search the element with Name property
			if (waitForElement().until(ExpectedConditions.visibilityOfElementLocated(By.name(locator_value)))
					.isDisplayed()) {
				allElements = driver.findElements(By.name(locator_value));
			} else
				throw new HandleException("No element list found on web page by " + locator_value);
			break;
		case "cssSelector": // Search the element with cssSelector property
			if (waitForElement().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator_value)))
					.isDisplayed()) {
				allElements = driver.findElements(By.cssSelector(locator_value));
			} else
				throw new HandleException("No element list found on web page by " + locator_value);
			break;
		case "xpath": // Search the element with xpath property
			if (waitForElement().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator_value)))
					.isDisplayed()) {
				allElements = driver.findElements(By.xpath(locator_value));
			} else
				throw new HandleException("No element list found on web page by " + locator_value);
			break;
		case "className": // Search the element with className property
			if (waitForElement().until(ExpectedConditions.visibilityOfElementLocated(By.className(locator_value)))
					.isDisplayed()) {
				allElements = driver.findElements(By.className(locator_value));
			} else
				throw new HandleException("No element list found on web page by " + locator_value);
			break;
		case "linkText": // Search the element with linkText property
			if (waitForElement().until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locator_value)))
					.isDisplayed()) {
				allElements = driver.findElements(By.linkText(locator_value));
			} else
				throw new HandleException("No element list found on web page by " + locator_value);
			break;
		case "partialLinkText":// Search the element with partialLinkText
								// property
			if (waitForElement().until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(locator_value)))
					.isDisplayed()) {
				allElements = driver.findElements(By.partialLinkText(locator_value));
			} else
				throw new HandleException("No element list found on web page by " + locator_value);
			break;
		case "tagName": // Search the element with tagName property
			if (waitForElement().until(ExpectedConditions.visibilityOfElementLocated(By.tagName(locator_value)))
					.isDisplayed()) {
				allElements = driver.findElements(By.tagName(locator_value));
			} else
				throw new HandleException("Failed invalid locator type: " + locator_value);
			break;
		default:// //Throw exception if any invalid WebElement is found
			throw new HandleException("Failed to read the data from file");
		}
		return allElements;
	}

	/**
	 * This method will verify the provided element in provided list
	 * 
	 * @param elementList
	 * @param element
	 * @return
	 * @throws HandleException
	 */
	public String getElementTextInElementList(String elementList, String element) throws HandleException {
		allElements = findElements(elementList);
		String actualString = "";
		for (WebElement elemt : allElements) {
			if (elemt.getText().equalsIgnoreCase(element)) {
				actualString = elemt.getText();
			//	System.out.println(elemt.getText());
				break;
			}
		}
		return actualString;
	}

	/** This method will return the element count from proveded element list
	 * @param elementList
	 * @return
	 * @throws HandleException 
	 */
	public int getElementCountFromElementList(String elementList) throws HandleException{
		int count = 0;
		allElements = findElements(elementList);
		count = allElements.size();
		return count;
	}
	/**
	 * This method will verify the provided element in provided list
	 * 
	 * @param elementList
	 * @param element
	 * @return
	 * @throws HandleException
	 */
	public void verifyElementInElementList(String elementList, String element) throws HandleException {
		allElements = findElements(elementList);
		for (WebElement elemt : allElements) {
			if (elemt.getText().equalsIgnoreCase(element)) {
				// actualString = elemt.getText();
				// System.out.println(elemt.getText());
				break;
			}
		}
	}

	/**
	 * get elements index
	 * 
	 * @throws HandleException
	 */
	public int getElementsIndex(String elementList, String elementName) throws HandleException {
		allElements = findElements(elementList);
		int count = 0;
		for (WebElement element : allElements) {
			count++;
			if ((element.getText()).equalsIgnoreCase(elementName)) {
				logger.info("Element is present");
				break;
			}
		}
		return count;
	}

	/**
	 * This method will click on provided index in provided element list
	 * 
	 * @throws HandleException
	 */
	public void clickOnIndexFromElementList(int location, String elementList) throws HandleException {
		allElements = findElements(elementList);
		
		 allElements.get(location).click();
	}
	
	/** This method will give the text on provided element index from element list
	 * @param index
	 * @return
	 * @throws HandleException 
	 */
	public String getTextByIndexFromElementList(int index, String elementList) throws HandleException{
		allElements = findElements(elementList);
		String elementText = allElements.get(index).getText();
		return elementText;
		
	}
	
	/** This method will give the element on provided element index from element list
	 * @param index
	 * @return webelement
	 * @throws HandleException 
	 */
	public WebElement getElementByIndexFromElementList(int index, String elementList) throws HandleException{
		allElements = findElements(elementList);
		WebElement element = allElements.get(index);
		return element;
	}

	/**
	 * gets Selected Value From DropDown
	 * 
	 * @throws HandleException
	 */
	public String getSelectedValueFromDropDown(String element)throws HandleException {
		webElement = findElement(element);
		Select select = new Select(webElement);
		WebElement option = select.getFirstSelectedOption();
		return option.getText();
	}

	/**
	 * selects Option From Schedule dropDown by index
	 * 
	 * @throws HandleException
	 */
	public void selectOptionFromDropDownByIndex(int value, String element)
			throws HandleException {
		webElement = findElement(element);
		Select select = new Select(webElement);
		select.selectByIndex(value);
	}
	
	/**
	 * selects Option From Schedule dropDown by index
	 * 
	 * @throws HandleException
	 */
	public void selectOptionFromDropDownByVisiableText(String dropDownElement, String element)
			throws HandleException {
		webElement = findElement(dropDownElement);
		Select select = new Select(webElement);
		select.selectByVisibleText(element);
	
	}

	/**
	 * Compare text Contains and gives result in true/False.
	 * 
	 * @param expected
	 *            the expected
	 * @param Actual
	 *            the actual
	 * 
	 * @return boolean
	 */
	public boolean compareTextContains(String actual, String expected) {
		boolean compareResult = false;

		if (actual.contains(expected)) {
			compareResult = true;
		}
		return compareResult;
	}

	/**
	 * Wrapper method for Thread.sleep()
	 * 
	 * @param timeInSeconds
	 */
	public static void wait(int timeInSeconds) {
		try {
			Thread.sleep(timeInSeconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will generated the dynamic xpath using provided element name
	 * 
	 * @param elementName
	 * @param xpath
	 * @return xpath
	 */
	public String getDynamicXpath(String elementName, String xpath) {
		String finalXpath = String.format(xpath, elementName);
		return finalXpath;
	}

	public String getElementAtrribute(String element) throws HandleException {
		webElement = findElement(element);
		String atrributeString = webElement.getAttribute("value");
		return atrributeString;

	}

	public String getElementPlaceholder(String element) throws HandleException {
		webElement = findElement(element);
		String inputText = webElement.getAttribute("value");
		if (inputText.length() == 0) {
			return webElement.getAttribute("placeholder");
		} else {
			return inputText;
		}
	}

}
