package com.autoiq.tests.processes;

import java.awt.AWTException;
import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.autoiq.base.TestBase;
import com.autoiq.pages.NavigationBar;
import com.autoiq.pages.login.Login;
import com.autoiq.pages.processes.CreateProcess;
import com.autoiq.pages.processes.ProcessOverview;

/**
 * The Class Test_DeleteProcess.
 * 
 * @author YogeshC
 */
public class TestDeleteProcess extends TestBase {
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
	 * Check delete disabled Process functionality
	 * 
	 */
	@Test(priority = 1)
	public void verifyDeleteDisabledProcess() throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify Check delete disabled Process - Begin");
		np.navigateToHomeAndClickOnProcessesTab();
		np.overviewSubTab();
		String processName=createProcessPageProp.getProperty("ProcessNameToVerifyDelete");
		String description=createProcessPageProp.getProperty("ProcessDescriptionToVerifyDelete");
		op.clickCreateNewProcessButton();
		enterProcessNameAndDescription(processName,description);
		cp.clickSave();
		cp.verifyCreateProcessSuccessToasterMsg();
		op.deleteProcess(processName);
		cp.verifyDeleteProcessSuccessToasterMsg();
		log.info("Verify Check delete disabled Process - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}
	
	/**
	 * enter Process Name And Description
	 * 
	 */
	public void enterProcessNameAndDescription(String name, String description) {
		cp.setProcessName(name);
		cp.setDescription(description);
	}

}
