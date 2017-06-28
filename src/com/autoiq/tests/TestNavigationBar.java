package com.autoiq.tests;

import java.awt.AWTException;
import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.autoiq.base.TestBase;
import com.autoiq.pages.NavigationBar;

/**
 * The Class Test_DeleteProcess.
 * 
 * @author YogeshC
 */
public class TestNavigationBar extends TestBase {
	NavigationBar np;
	
	@BeforeClass
	public void setup() throws MalformedURLException {
		try {
			np = new NavigationBar(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * verify Main Navigation Bar
	 * 
	 * @throws InterruptedException
	 * @throws AWTException 
	 */
	@Test(priority = 1)
	public void verifyMainNavBar() throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify Main Nav Bar - Begin");
		np.dashboardTab();
		np.reportsTab();
		np.processesTab();
		log.info("Verify Main Nav Bar - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}
	
	/**
	 * verify Sub Navigation Bar
	 * 
	 * @throws InterruptedException
	 * @throws AWTException 
	 */
	@Test(priority = 2)
	public void verifySubNavBar() throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify Sub Nav Bar - Begin");
		np.processesTab();
		np.schedulesSubTab();
		np.definitionsSubTab();
		np.overviewSubTab();
		log.info("Verify Sub Nav Bar - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}

}
