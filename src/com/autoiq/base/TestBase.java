package com.autoiq.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public abstract class TestBase {
	protected static WebDriver driver = null;
	protected static org.apache.log4j.Logger log = null;
	protected static Properties config = null;
	protected static Properties loginPageProp = null;
	protected static Properties overviewPageProp = null;
	protected static Properties createProcessPageProp = null;
	protected static Properties schedulesPageProp = null;
	protected static Properties createSchedulePageProp = null;
	protected static Properties definitionPageProp = null;
	protected static Properties createDefinitionPageProp = null;
	protected static Properties credentialPageProp = null;
	protected static Properties data = null;
	protected static Connection conn = null;

	/**
	 * Instantiates a new test base.
	 */
	protected TestBase() {
		initLog();
		initConfig();
		initLoginConfig();
		initOverviewConfig();
		initCreateProcessConfig();
		initScheduleConfig();
		initCreateScheduleConfig();
		initCreateDefinitionConfig();
		initDefinitionConfig();
		initCredentialsConfig();
	}

	/**
	 * Inits the log.
	 */
	private void initLog() {
		if (log == null) {
			PropertyConfigurator.configure(
					System.getProperty("user.dir") + File.separator + "config" + File.separator + "log4j.properties");
			log = org.apache.log4j.Logger.getLogger("AutoIQLogger");
			System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Jdk14Logger");
			log.debug("Debug Log is initialized");
		}
	}

	/**
	 * Inits the config.
	 */
	private static void initConfig() {
		if (config == null) {
			config = new Properties();
			FileInputStream ip = null;

			try {
				ip = new FileInputStream(System.getProperty("user.dir") + File.separator + "config" + File.separator
						+ "config.properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				config.load(ip);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
	
	/**
	 * Inits the create Schedule page config
	 */
	private static void initCreateScheduleConfig() {
		if (createSchedulePageProp == null) {
			createSchedulePageProp = new Properties();
			FileInputStream ip = null;

			try {
				ip = new FileInputStream(System.getProperty("user.dir") + File.separator + "data" + File.separator
						+ "CreateSchedulePage.properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				createSchedulePageProp.load(ip);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Inits the Definition page config
	 */
	private static void initDefinitionConfig() {
		if (definitionPageProp == null) {
			definitionPageProp = new Properties();
			FileInputStream ip = null;

			try {
				ip = new FileInputStream(System.getProperty("user.dir") + File.separator + "data" + File.separator
						+ "DefinitionPage.properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				definitionPageProp.load(ip);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	/**
	 * Inits the Craete Definition page config
	 */
	private static void initCreateDefinitionConfig() {
		if (createDefinitionPageProp == null) {
			createDefinitionPageProp = new Properties();
			FileInputStream ip = null;

			try {
				ip = new FileInputStream(System.getProperty("user.dir") + File.separator + "data" + File.separator
						+ "CreateDefinitionPage.properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				createDefinitionPageProp.load(ip);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	/**
	 * Inits the Schedule page config
	 */
	private static void initScheduleConfig() {
		if (schedulesPageProp == null) {
			schedulesPageProp = new Properties();
			FileInputStream ip = null;

			try {
				ip = new FileInputStream(System.getProperty("user.dir") + File.separator + "data" + File.separator
						+ "SchedulesPage.properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				schedulesPageProp.load(ip);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	/**
	 * Inits the login page config.
	 */
	private static void initLoginConfig() {
		if (loginPageProp == null) {
			loginPageProp = new Properties();
			FileInputStream ip = null;

			try {
				ip = new FileInputStream(System.getProperty("user.dir") + File.separator + "data" + File.separator
						+ "loginPage.properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				loginPageProp.load(ip);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	/**
	 * Inits the create process page config.
	 */
	private static void initCreateProcessConfig() {
		if (createProcessPageProp == null) {
			createProcessPageProp = new Properties();
			FileInputStream ip = null;

			try {
				ip = new FileInputStream(System.getProperty("user.dir") + File.separator + "data" + File.separator
						+ "CreateProcessPage.properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				createProcessPageProp.load(ip);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	/**
	 * Inits the overview page config.
	 */
	private static void initOverviewConfig() {
		if (overviewPageProp == null) {
			overviewPageProp = new Properties();
			FileInputStream ip = null;

			try {
				ip = new FileInputStream(System.getProperty("user.dir") + File.separator + "data" + File.separator
						+ "OverviewPage.properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				overviewPageProp.load(ip);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
	
	/**
	 * Inits the create Credentials page config.
	 */
	private static void initCredentialsConfig() {
		if (credentialPageProp == null) {
			credentialPageProp = new Properties();
			FileInputStream ip = null;

			try {
				ip = new FileInputStream(System.getProperty("user.dir") + File.separator + "data" + File.separator
						+ "CredentialsPage.properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				credentialPageProp.load(ip);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	/**
	 * Initialize driver as per the configuration/properties file's browser type
	 */
	protected static void initDriver() {
		String os = System.getProperty("os.name").toLowerCase();

		if (config.getProperty("browser").equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();

		} else if (config.getProperty("browser").equalsIgnoreCase("chrome")) {
			
			if (os.contains("windows")){
				System.setProperty("webdriver.chrome.driver", config.getProperty("windows_chromeDriverPath"));
				driver = new ChromeDriver();
			} else if(os.contains("linux")){
				System.setProperty("webdriver.chrome.driver", config.getProperty("linux_chromeDriverPath"));
				driver = new ChromeDriver();
			} else if (os.contains("mac")){
				System.setProperty("webdriver.chrome.driver", config.getProperty("mac_chromeDriverPath"));
				driver = new ChromeDriver();
			}
			
		} else if (config.getProperty("browser").equalsIgnoreCase("ie")) {
			
			if(os.contains("linux")){
				System.setProperty("webdriver.ie.driver", config.getProperty("ieDriverPath"));
				driver = new InternetExplorerDriver();
			} else if (os.contains("mac")){
				System.setProperty("webdriver.ie.driver", config.getProperty("ieDriverPath"));
				driver = new InternetExplorerDriver();
			} else if (os.contains("windows")){
				System.setProperty("webdriver.ie.driver", config.getProperty("windows_ieDriverPath"));
				driver = new InternetExplorerDriver();
			}

		} else if (config.getProperty("browser").equalsIgnoreCase("headless")) {
			System.setProperty("phantomjs.binary.path", config.getProperty("phantomjsDriverPath"));
			driver = new PhantomJSDriver();

		}
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		String appUrl = System.getProperty("applicationUrl");

		if (appUrl != null) {
			driver.get(System.getProperty("applicationUrl"));
		} else {
			driver.get(config.getProperty("testsiteBaseURl"));
		}
		log.info("Execution started on url: "+driver.getCurrentUrl());
	}

	/**
	 * Close the driver.
	 */
	public static void closeDriver() {
		driver.close();
		driver = null;
		log.debug("Closing the Browser");
	}

	/**
	 * Quit driver.
	 */
	public static void quitDriver() {
		driver.quit();
		driver = null;
		log.debug("Quiting the Browser");
	}

	/**
	 * Gets the driver. Used to re-initialize driver in case required (example,
	 * after browser quit/crash)
	 * 
	 * @return the driver
	 */
	public static WebDriver getDriver() {
		if (driver == null) {
			initDriver();
		}
		return driver;
	}

	/**
	 * Checks if element is displayed
	 */
	public static boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	/**
	 * Checks if element is enabled
	 */
	public static boolean isElementEnabled(WebElement element) {
		return element.isEnabled();
	}

	/**
	 * Gets the config.
	 * 
	 * @return the config
	 */
	public static Properties getConfig() {
		if (config == null) {
			initConfig();
		}
		return config;
	}

	/**
	 * This method will Initialize the driver
	 */
	@BeforeSuite
	public void initializeTheDriver() throws Exception {
		File file = new File("./Screenshots/");
		deleteFilesFromFolder(file);
		initDriver();
	}

	/**
	 * This method will quit driver after every suite execution
	 */
	@AfterSuite
	public void quitTheDriver() throws Exception {
		quitDriver();
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
	 * Wrapper method for WebDriverWait (ExpectedCondition =
	 * elementToBeClickable)
	 * 
	 * @param element
	 * @param timeInSeconds
	 */
	public static void waitForElementClickable(WebElement element, int timeInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * Wrapper method for WebDriverWait (ExpectedCondition = visibilityOf
	 * element)
	 * 
	 * @param element
	 * @param timeInSeconds
	 */
	public static void waitForElementVisible(WebElement element, int timeInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * Wrapper method for WebDriverWait (ExpectedCondition = presenceof
	 * element)
	 * 
	 * @param element
	 * @param timeInSeconds
	 */
	public static void waitForElementToBePresent(String locatorXpath, int timeInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locatorXpath)));
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
	 * gets current date
	 * 
	 */
	public String getCurrentDate() {
		DateFormat df = new SimpleDateFormat("M/d/yyyy");
		Date dateobj = new Date();
		return df.format(dateobj);
	}
	
	/**
	 * deletes files from folder
	 * 
	 */
	public void deleteFilesFromFolder(File file) throws IOException {
		String[] fileList;
		if (file.isDirectory()) {
			fileList = file.list();
			for (int i = 0; i < fileList.length; i++) {
				File myFile = new File(file, fileList[i]);
				myFile.delete();
			}
		}
	}

	/**
	 * captures the screenshot
	 * 
	 * @param result
	 *            the result
	 * @param screenshot
	 *            Name the screenshot Name
	 */
//	@AfterMethod
//	public void captureScreenshot(ITestResult result) {
//		log.info("Method Name: " + result.getMethod().getMethodName());
//		log.info("Success Status: " + result.isSuccess());
//
//		if (!result.isSuccess()) {
//			try {
//				TakesScreenshot ts = (TakesScreenshot) driver;
//				File source = ts.getScreenshotAs(OutputType.FILE);
//				org.apache.commons.io.FileUtils.copyFile(source,
//						new File("./Screenshots/" + result.getMethod().getMethodName() + ".png"));
//				log.info("Screenshot Taken");
//			} catch (IOException e) {
//				log.info("Exception while taking screenshot " + e.getMessage());
//			}
//
//		}
//	}
	
	/**
	 * This method executes after every test method
	 * 
	 * @param result
	 *            the result
	 */
	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult result) throws Exception {
		log.info("Method Name: " + result.getMethod().getMethodName());
		log.info("Success Status: " + result.isSuccess());
		if (!result.isSuccess())
			captureScreenshot(result);
	}

	/**
	 * captures the screenshot
	 * 
	 * @param result
	 *            the result
	 */
	public void captureScreenshot(ITestResult result) {
		String methodName = result.getName();
		System.setProperty("org.uncommons.reportng.escape-output", "false");
			try {
				String failureImageFileName = methodName;
				TakesScreenshot ts = (TakesScreenshot) driver;
				File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(source, new File("./Screenshots/" + failureImageFileName + ".png"));
				String directory = System.getProperty("user.dir") + File.separator + "Screenshots" + File.separator;
				String s1 = "<table><tr><td><font style=\"text-decoration: underline;\" size=\"3\" face=\"Comic sans MS\" color=\"green\"><b>"
						+ failureImageFileName + " (Screenshot at " + new Date() + ")" + "</b></font></td></tr> ";
				String s2 = "<table><tr><td><font style=\"text-decoration: underline;\" size=\"3\" face=\"Comic sans MS\" color=\"grey\"><b>"
						+ result.getTestClass() + "</b></font></td></tr> ";
				Reporter.log(s2);
				Reporter.log(s1);
				Reporter.log("<tr><td><a href=\"" + directory + failureImageFileName + ".png"
						+ "\"><img src=\"file:///" + directory + failureImageFileName + ".png" + "\" alt=\"\""
						+ "height='120' width='120'/></td></tr> ");
				Reporter.setCurrentTestResult(null);

			} catch (IOException e) {
				log.info("Exception while taking screenshot " + e.getMessage());
			}
		}
	
	/**
	 * This method selects the options available on type ahead
	 * 
	 * @param result
	 *            the result
	 */
	public void selectOptionWithText(WebElement autoOptions,String textToSelect) {
		try {
			waitForElementVisible(autoOptions, 3);
			List<WebElement> optionsToSelect = autoOptions.findElements(By.tagName("li"));
			for(WebElement option : optionsToSelect){
		        if(option.getText().equals(textToSelect)) {
		        	log.info("Trying to select: "+textToSelect);
		            option.click();
		            break;
		        }
		    }
			
		} catch (NoSuchElementException e) {
			log.info(e.getStackTrace());
		}
		catch (Exception e) {
			log.info(e.getStackTrace());
		}
		wait(3);
	}
	
	/**
	 * drag and drop
	 */
	public void mouseDragAndDrop(WebElement dragElement, WebElement dropElement) throws InterruptedException {
		Actions builder = new Actions(driver); // Configure the Action
		Action dragAndDrop = builder.clickAndHold(dragElement).moveToElement(dropElement).release(dropElement).build();
		dragAndDrop.perform();
	}
	
	/**
	 * scrolls up
	 */
	public void scrollup() {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("scroll(0, -250);");
	}
}
