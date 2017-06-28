package com.autoiq.tests.processes;

import java.awt.AWTException;
import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.autoiq.base.TestBase;
import com.autoiq.pages.NavigationBar;
import com.autoiq.pages.login.Login;
import com.autoiq.pages.processes.CreateProcess;
import com.autoiq.pages.processes.ProcessOverview;

public class TestOverview extends TestBase {
	Login lp;
	ProcessOverview op;
	CreateProcess cp;
	NavigationBar np;

	@BeforeClass
	public void setup() throws MalformedURLException {
		try {
				lp = new Login(driver);
				op = new ProcessOverview(driver);
				cp = new CreateProcess(driver);
				np = new NavigationBar(driver);
			} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/**
	 *Sort By Process Name In Ascending Order
	 * 
	 * @throws InterruptedException
	 * @throws AWTException 
	 */
	@Test(priority = 1)
	public void verifySortByProcessNameAscending() throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify sort By Process Name Ascending - Begin");
		np.navigateToHomeAndClickOnProcessesTab();
		np.overviewSubTab();
		op.clickSortByProcessName();
		log.info("Verify sort By Process Name Ascending - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}
	
	/**
	 *Sort By Process Name In Descending Order
	 * 
	 * @throws InterruptedException
	 * @throws AWTException 
	 */
	@Test(priority = 2)
	public void verifySortByProcessNameDescending() throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify sort By Process Name Descending - Begin");
		np.processesTab();
		np.overviewSubTab();
		op.clickSortByProcessName();
		op.clickSortByProcessName();
		log.info("Verify sort By Process Name Descending - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}
	
	/**
	 *Sort By Definitions In Ascending Order
	 * 
	 * @throws InterruptedException
	 * @throws AWTException 
	 */
	@Test(priority = 3)
	public void verifySortByDefinitionsAscending() throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify sort By Definitions Ascending - Begin");
		np.processesTab();
		np.overviewSubTab();
		op.clickSortByDefinitions();
		log.info("Verify sort By Definitions Ascending - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}
	
	/**
	 *Sort By Definitions In Descending Order
	 * 
	 * @throws InterruptedException
	 * @throws AWTException 
	 */
	@Test(priority = 4)
	public void verifySortByDefinitionsDescending() throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify sort By Definitions Descending - Begin");
		np.processesTab();
		np.overviewSubTab();
		op.clickSortByDefinitions();
		op.clickSortByDefinitions();
		log.info("Verify sort By Definitions Descending - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}
	
	/**
	 *Sort By Schedules In Ascending Order
	 * 
	 * @throws InterruptedException
	 * @throws AWTException 
	 */
	@Test(priority = 5)
	public void verifySortBySchedulesAscending() throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify sort By Schedules Ascending - Begin");
		np.processesTab();
		np.overviewSubTab();
		op.clickSortBySchedules();
		log.info("Verify sort By Schedules Ascending - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}
	
	/**
	 *Sort By Schedules In Descending Order
	 * 
	 * @throws InterruptedException
	 * @throws AWTException 
	 */
	@Test(priority = 6)
	public void verifySortBySchedulesDescending() throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify sort By Schedules Descending - Begin");
		np.processesTab();
		np.overviewSubTab();
		op.clickSortBySchedules();
		op.clickSortBySchedules();
		log.info("Verify sort By Schedules Descending - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}
	
	/**
	 * Select Enable Disable TestMode For One Process
	 * 
	 * @throws InterruptedException
	 * @throws AWTException 
	 */
	@Test(priority = 7)
	public void verifyEnableDisableTestModeForOneProcess() throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify select All Disable Test Mode - Begin");
		np.navigateToHomeAndClickOnProcessesTab();
		np.overviewSubTab();
		op.selectCheckBox(0);
		op.clickDisableTestModeButton();
		wait(3);
		op.selectCheckBox(1);
		op.clickEnableTestModeButton();
		op.verifyTestModeEnableToasterMsg();
		op.selectCheckBox(1);
		op.clickDisableTestModeButton();
		op.verifyTestModeDisableToasterMsg();
		log.info("Verify select All Disable Test Mode - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}
	
	/**
	 *Select Enable TestMode For All Process
	 * 
	 * @throws InterruptedException
	 * @throws AWTException 
	 */
	@Test(priority = 8)
	public void verifyBulkEnableTestMode() throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify bulk Enable Test Mode - Begin");
		np.navigateToHomeAndClickOnProcessesTab();
		np.overviewSubTab();
		op.selectCheckBox(0);
		op.clickDisableTestModeButton();
		wait(3);
		op.selectCheckBox(0);
		op.clickEnableTestModeButton();
		op.verifyTestModeEnableToasterMsg();
		op.verifyProcessesAssignedToTestMode();
		log.info("Verify bulk Enable Test Mode - End");
		log.info("-----------------------------------------XXX--------------------------------------");
		}
	
	/**
	 *Select Disable TestMode For All Process
	 * 
	 * @throws InterruptedException
	 * @throws AWTException 
	 */
	@Test(priority = 9)
	public void verifyBulkDisableTestMode() throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify bulk Disable Test Mode - Begin");
		np.navigateToHomeAndClickOnProcessesTab();
		np.overviewSubTab();
		op.selectCheckBox(0);
		op.clickDisableTestModeButton();
		wait(3);
		op.selectCheckBox(0);
		op.clickEnableTestModeButton();
		op.verifyTestModeEnableToasterMsg();
		op.verifyProcessesAssignedToTestMode();
		op.selectCheckBox(0);
		op.clickDisableTestModeButton();
		op.verifyTestModeDisableToasterMsg();
		log.info("Verify bulk Disable Test Mode - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}
	
	/**
	 * get Process Index
	 * 
	 * @throws InterruptedException
	 * @throws AWTException 
	 */
	public int getProcessIndex(String pname) throws IOException, InterruptedException {
		log.info("get Process Index - Begin");
		String processName = pname;
		int count = 0;
		for (WebElement process : op.getProcessList()) {
			count++;
			if ((process.getText()).equals(processName)) {
				log.info("Process Added successfully");
				break;
			}
		}
		log.info("get Process Index - End");
		return count;
	}
	
	/**
	 * enter Process Details
	 * 
	 * @throws InterruptedException
	 * @throws AWTException 
	 */
	public void enterProcessDetails(String name, String description,int index) throws InterruptedException, IOException, AWTException {
		log.info("enter Process Details - Start");
		cp.setProcessName(name);
		cp.setDescription(description);
		cp.setSelectSchedule(index);
		cp.setSelectDefinition(index);
		cp.setSelectWorkQueue(index);
		cp.setSelectWorkItemTask(index);
		cp.setSelectRunOnce();
		log.info("enter Process Details - End");
	}
	
	/**
	 * enter Edit Process Details
	 * 
	 * @throws InterruptedException
	 * @throws AWTException 
	 */
	public void enterEditProcessDetails(String name, String description,int index) throws InterruptedException, IOException, AWTException {
		log.info("enter Edit Process Details - Start");
		cp.setProcessName(name);
		cp.setDescription(description);
		op.setEditSelectSchedule(index);
		op.setEditSelectDefinition(index);
		op.setEditSelectWorkQueue(index);
		op.setEditSelectWorkItemTask(index);
		log.info("enter Edit Process Details - End");
	}
}
