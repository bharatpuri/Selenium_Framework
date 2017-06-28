package com.selenium.browser.actions.implementions;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import com.autoiq.common.utility.CommonUtility;
import com.autoiq.common.utility.DataStoreInObjects;
import com.autoiq.common.utility.HandleException;
import com.autoiq.common.utility.Log;
import com.selenium.browser.actions.Browser;

public class BrowserActions implements Browser{

	final static Logger logger = Logger.getLogger(BrowserActions.class.getName());
	DataStoreInObjects locators = new DataStoreInObjects();
	public static WebDriver driver;
	
	@Override
	public void openBrowser() throws HandleException {
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

	@Override
	public void quiteBrowser() throws HandleException {
		if (driver != null) {
			driver.close();
			driver.quit();
			driver = null;
			logger.info("Close all the browser open by selenium webdriver");
		} else
			throw new HandleException("Failed while closing/quiting the browser");
		
	}
	@Override
	public void closeBrowser() throws HandleException {
		if (driver != null) {
			driver.close();
			driver = null;
			logger.info("Close all the browser open by selenium webdriver");
		} else
			throw new HandleException("Failed while closing/quiting the browser");
		
	}
		
	
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

}
