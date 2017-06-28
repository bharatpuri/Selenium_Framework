package com.autoiq.tests.dashboard;

import java.awt.AWTException;
import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.autoiq.base.TestBase;
import com.autoiq.pages.NavigationBar;
import com.autoiq.pages.dashboard.Dashboard;

/**
 * The Class TestDefinition.ok
 */
public class TestDashboard extends TestBase {
	NavigationBar np;
	Dashboard d;

	/**
	 * This executes before all the test methods
	 */

	@BeforeClass
	public void setup() throws MalformedURLException {
		try {
			np = new NavigationBar(driver);
			d = new Dashboard(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Verify Dashboard Page Contents
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(priority = 1)
	public void VerifyDashboardPageContent() throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify Dashboard Page Contents - Begin");
		np.dashboardTab();
		d.dashboardPageContentVerification();
		log.info("Verify Dashboard Page Contents - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}
	
	/**
	 * Verify Dashboard Page sub Contents
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(priority = 1)
	public void VerifyDashboardPageSubContent() throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify Dashboard Page Sub Contents - Begin");
		np.dashboardTab();
		d.dashboardPageSubContentVerification();
		log.info("Verify Dashboard Page Contents - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}
	


}