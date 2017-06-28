package com.autoiq.tests.definitions;

import java.awt.AWTException;
import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.autoiq.base.TestBase;
import com.autoiq.pages.NavigationBar;
import com.autoiq.pages.definitions.CreateDefinition;
import com.autoiq.pages.definitions.DefinitionOverview;
import com.autoiq.pages.processes.CreateProcess;
import com.autoiq.pages.processes.ProcessOverview;
import com.autoiq.pages.schedules.SchedulesOverview;

/**
 * The Class TestDefinition.
 */
public class TestDefinition extends TestBase {
	ProcessOverview op;
	SchedulesOverview sp;
	DefinitionOverview dp;
	CreateDefinition cdp;
	CreateProcess cp;
	NavigationBar np;

	/**
	 * This executes before all the test methods
	 */

	@BeforeClass
	public void setup() throws MalformedURLException {
		try {
			op = new ProcessOverview(driver);
			sp = new SchedulesOverview(driver);
			dp = new DefinitionOverview(driver);
			cdp = new CreateDefinition(driver);
			cp = new CreateProcess(driver);
			np = new NavigationBar(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Verify Delete For Definition With No Process Assigned
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(priority = 1)
	public void verifyDeleteForDefinitionWithNoProcessAssigned()
			throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify Delete For Definition With No Process Assigned - Begin");
		np.navigateToHomeAndClickOnProcessesTab();
		np.definitionsSubTab();
		String definitionName = definitionPageProp.getProperty("nameDefinitionWithNoProcessAssociated");
		String Description = definitionPageProp.getProperty("descriptionDefinitionToDeleteDetails");
		dp.clickCreateNewDefinitionButton();
		enterDefinitionNameAndDescription(definitionName, Description);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		dp.clickSaveButton();
		String actualValidationMsg = dp.getSuccessToasterMsg();
		String expectedValidationMsg = definitionPageProp.getProperty("expectedSuccessValidationMsg");
		Assert.assertTrue(compareTextContains(actualValidationMsg, expectedValidationMsg),
				"Success message not displayed");
		cdp.clickPublishButton();
		dp.deleteDefinition(definitionName);
		dp.verifySuccessDeleteToasterMsg();
		dp.verifyDeleteDefinition(definitionName);
		log.info("Verify Delete For Definition With No Process Assigned - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}

	/**
	 * verify Delete For Definition With Process Assigned
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(priority = 2)
	public void verifyDeleteForDefinitionWithProcessAssigned() throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify Delete For Definition With Process Assigned - Begin");
		np.navigateToHomeAndClickOnProcessesTab();
		np.definitionsSubTab();
		String definitionName = definitionPageProp.getProperty("definitionNameForProcessAssociated");
		String Description = definitionPageProp.getProperty("definitiondescriptionForProcessToBeDeleted");
		dp.clickCreateNewDefinitionButton();
		enterDefinitionNameAndDescription(definitionName, Description);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		dp.clickSaveButton();
		String actualValidationMsg = dp.getSuccessToasterMsg();
		String expectedValidationMsg = definitionPageProp.getProperty("expectedSuccessValidationMsg");
		Assert.assertTrue(compareTextContains(actualValidationMsg, expectedValidationMsg),
				"Success message not displayed");
		cdp.clickPublishButton();
		np.processesTab();
		op.clickCreateNewProcessButton();
		String processName=createProcessPageProp.getProperty("processNameToBeDelete");
		enterProcessName(processName);
		cp.selectOptionFromDefinitionDown(definitionName);
		wait(2);
		cp.clickSave();
		dp.navigateToDefinition();
		dp.clickOkOnDeletePopup(definitionName);
		np.processesTab();
		op.deleteProcess(processName);
		np.definitionsSubTab();
		dp.deleteDefinition(definitionName);
		dp.verifySuccessDeleteToasterMsg();
		dp.verifyDeleteDefinition(definitionName);
		log.info("Verify Delete For Definition With Process Assigned - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}

	/**
	 * create Process Definition & check with no option
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(priority = 3)
	public void verifyNoOnDeletePopup() throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify No On Delete Popup - Begin");
		np.navigateToHomeAndClickOnProcessesTab();
		np.definitionsSubTab();
		String definitionName = definitionPageProp.getProperty("definitionNameWithNo");
		String Description = definitionPageProp.getProperty("definitiondescriptionWithNo");
		dp.createProcessDefinitionButtonIsClickable();
		dp.clickCreateNewDefinitionButton();
		enterDefinitionNameAndDescription(definitionName, Description);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		dp.clickSaveButton();
		String actualValidationMsg = dp.getSuccessToasterMsg();
		String expectedValidationMsg = definitionPageProp.getProperty("expectedSuccessValidationMsg");
		Assert.assertTrue(compareTextContains(actualValidationMsg, expectedValidationMsg),
				"Success message not displayed");
		dp.clickClose();
		dp.clickNoOnDeletePopup(definitionName);
		dp.deleteDefinition(definitionName);
		dp.verifyDeleteDefinition(definitionName);
		log.info("Verify No On Delete Popup - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}

	/**
	 * verify Definition Count
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(priority = 4)
	public void verifyDefinitionCount() throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify Definition Count - Begin");
		np.navigateToHomeAndClickOnProcessesTab();
		np.definitionsSubTab();
		String definitionName = definitionPageProp.getProperty("definitionNameForCount");
		String Description = definitionPageProp.getProperty("definitiondescriptionForCount");
		int defCountBeforeCreatingNewDefinition = Integer.parseInt(dp.getDefinitionCount());
		dp.clickCreateNewDefinitionButton();
		enterDefinitionNameAndDescription(definitionName, Description);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		dp.clickSaveButton();
		String actualValidationMsg = dp.getSuccessToasterMsg();
		String expectedValidationMsg = definitionPageProp.getProperty("expectedSuccessValidationMsg");
		Assert.assertTrue(compareTextContains(actualValidationMsg, expectedValidationMsg),
				"Success message not displayed");
		cdp.clickPublishButton();
		log.info("Definition count after adding new definition ");
		dp.compareCounts();
		int defCountAfterCreatingNewDefinition = Integer.parseInt(dp.getDefinitionCount());
		Assert.assertEquals(defCountAfterCreatingNewDefinition, defCountBeforeCreatingNewDefinition + 1,
				"Total definition count displayed is incorrect");
		dp.deleteDefinition(definitionName);
		log.info("Definition count after Deleting the definition ");
		dp.compareCounts();
		log.info("Verify Definition Count - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}

	/**
	 * verify badge count for Definition
	 * 
	 * @throws AWTException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Test(priority = 5)
	public void verifyBadgeCountWithDefinition() throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify Badge Count With Definition - Begin");
		np.navigateToHomeAndClickOnProcessesTab();
		np.definitionsSubTab();
		String definitionName = definitionPageProp.getProperty("definitionNameForBadgeCountVerification");
		String Description = definitionPageProp.getProperty("definitiondescriptionForBadgeCountVerification");
		dp.clickCreateNewDefinitionButton();
		enterDefinitionNameAndDescription(definitionName, Description);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		dp.clickSaveButton();
		String actualValidationMsg = dp.getSuccessToasterMsg();
		String expectedValidationMsg = definitionPageProp.getProperty("expectedSuccessValidationMsg");
		Assert.assertTrue(compareTextContains(actualValidationMsg, expectedValidationMsg),
				"Success message not displayed");
		cdp.clickPublishButton();
		int number = dp.getDefinitionIndex(definitionName);
		int intialBadgeCount = Integer.parseInt(dp.getBadgeCount(number));
		log.info("Badge count before adding process : " + intialBadgeCount);
		np.processesTab();
		op.clickCreateNewProcessButton();
		String processName = createProcessPageProp.getProperty("processNameBadgecountVerification");
		enterProcessName(processName);
		cp.selectOptionFromDefinitionDown(definitionName);
		wait(2);
		cp.clickSave();
		np.definitionsSubTab();
		int badgeCount = Integer.parseInt(dp.getBadgeCount(number));
		log.info("Badge count after adding process : " + badgeCount);
		Assert.assertEquals(badgeCount, intialBadgeCount + 1);
		np.processesTab();
		op.deleteProcess(processName);
		np.definitionsSubTab();
		int badgeCountAfterDeletingProcess = Integer.parseInt(dp.getBadgeCount(number));
		log.info("Badge count after deleting process : " + badgeCountAfterDeletingProcess);
		dp.deleteDefinition(definitionName);
		log.info("Verify Badge Count With Definition  - End");
		log.info("-----------------------------------------XXX--------------------------------------");

	}
	
	/**
	 * verify hide badge count for draft Definition
	 * 
	 * @throws AWTException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Test(priority = 6)
	public void hideBadgeCountForDraftDefinition() throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify hide badge count for draft Definition - Begin");
		np.navigateToHomeAndClickOnProcessesTab();
		np.definitionsSubTab();
		String definitionName = definitionPageProp.getProperty("definitionNameForHideBadgeCount");
		String Description = definitionPageProp.getProperty("descriptionForHideBadgeCount");
		dp.clickCreateNewDefinitionButton();
		enterDefinitionNameAndDescription(definitionName, Description);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		dp.clickSaveButton();
		String actualValidationMsg = dp.getSuccessToasterMsg();
		String expectedValidationMsg = definitionPageProp.getProperty("expectedSuccessValidationMsg");
		Assert.assertTrue(compareTextContains(actualValidationMsg, expectedValidationMsg),
				"Success message not displayed");
		dp.clickClose();
		int number = dp.getDefinitionIndex(definitionName);
		Assert.assertFalse(dp.isBadgeCountDisplayed(number), "badge count should not be displayed for draft definition");
		dp.deleteDefinition(definitionName);
		log.info("Verify hide badge count for draft Definition  - End");
		log.info("-----------------------------------------XXX--------------------------------------");

	}

	/**
	 * verify Process Associated With Definition
	 * 
	 * @throws AWTException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Test(priority = 7)
	public void verifyProcessAssociatedWithDefinition() throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify Process Associated With Definition- Begin");
		np.navigateToHomeAndClickOnProcessesTab();
		np.definitionsSubTab();
		String definitionName = definitionPageProp.getProperty("definitionNameForProcessVerification");
		String Description = definitionPageProp.getProperty("definitiondescriptionForProcessVerification");
		dp.clickCreateNewDefinitionButton();
		enterDefinitionNameAndDescription(definitionName, Description);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		dp.clickSaveButton();
		String actualValidationMsg = dp.getSuccessToasterMsg();
		String expectedValidationMsg = definitionPageProp.getProperty("expectedSuccessValidationMsg");
		Assert.assertTrue(compareTextContains(actualValidationMsg, expectedValidationMsg),
				"Success message not displayed");
		cdp.clickPublishButton();
		np.processesTab();
		op.clickCreateNewProcessButton();
		String processName = createProcessPageProp.getProperty("processNameForProcessVerification");
		enterProcessName(processName);
		cp.selectOptionFromDefinitionDown(definitionName);
		wait(2);
		cp.clickSave();
		np.definitionsSubTab();
		dp.clickOnDefinitionChevronIcon(definitionName);
		String expectedProcessName = sp.getFirstAssociatedProcessName();
		Assert.assertEquals(processName, expectedProcessName, "Process is not associated to the Definition");
		np.processesTab();
		op.deleteProcess(processName);
		np.definitionsSubTab();
		dp.deleteDefinition(definitionName);
		log.info("Verify Process Associated With Definition  - End");
		log.info("-----------------------------------------XXX--------------------------------------");

	}

	/**
	 * enter Definition name & description
	 */
	public void enterDefinitionNameAndDescription(String name, String description) {
		dp.setDefinitionName(name);
		dp.setDescription(description);
	}

	/**
	 * enter Process name
	 */
	public void enterProcessName(String name) {
		cp.setProcessName(name);
	}

}
