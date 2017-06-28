package com.autoiq.tests.schedules;

import java.awt.AWTException;
import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.autoiq.base.TestBase;
import com.autoiq.pages.NavigationBar;
import com.autoiq.pages.processes.CreateProcess;
import com.autoiq.pages.processes.ProcessOverview;
import com.autoiq.pages.schedules.CreateSchedule;
import com.autoiq.pages.schedules.SchedulesOverview;

/**
 * The Class Test_schedule.
 */
public class TestSchedule extends TestBase {
	ProcessOverview op;
	SchedulesOverview sp;
	NavigationBar np;
	CreateSchedule csp;
	CreateProcess cp;

	/**
	 * This executes before all the test methods
	 */

	@BeforeClass
	public void setup() throws MalformedURLException {
		try {
			op = new ProcessOverview(driver);
			sp = new SchedulesOverview(driver);
			np = new NavigationBar(driver);
			cp = new CreateProcess(driver);
			csp = new CreateSchedule(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * verify navigate to schedule page
	 */
	@Test(priority = 1)
	public void verifyNavigateToSchedulePage() {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify Navigate To Schedule Page - Begin!!");
		np.navigateToHomeAndClickOnProcessesTab();
		np.schedulesSubTab();
		log.info("Schedule tab clicked!!!!");
		Assert.assertEquals(sp.getCreateButtonText(), schedulesPageProp.getProperty("createScheduleButtonText"));
		log.info("Verify Navigate To Schedule Page - end!!");
		log.info("-----------------------------------------XXX--------------------------------------");
	}

	/**
	 * verify whether create new schedule button is clickable
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 2)
	public void verifyCreateButtonIsClickable() throws InterruptedException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify if Create New Schedule button is enabled - Begin!!");
		np.navigateToHomeAndClickOnProcessesTab();
		np.schedulesSubTab();
		Assert.assertTrue(sp.createScheduleButtonIsClickable(), "Create New Schedule button is not clickable");
		log.info("Verify if Create New Schedule button is enabled");
		log.info("-----------------------------------------XXX--------------------------------------");
	}

	/**
	 * verify Delete For Schedule With No Process Assigned
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test(priority = 3)
	public void verifyDeleteForScheduleWithNoProcessAssigned() throws InterruptedException, IOException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify Delete For Schedule With No Process Assigned - Begin");
		np.navigateToHomeAndClickOnProcessesTab();
		np.schedulesSubTab();
		String scheduleName = createSchedulePageProp.getProperty("scheduleWithNoProcessAssigned");
		sp.clickCreateNewScheduleButton();
		csp.setScheduleName(scheduleName);
		csp.selectMonday();
		csp.clickSave();
		wait(2);
		sp.verifyNameForCreatedSchedule(scheduleName);
		sp.deleteSchedule(scheduleName);
		wait(1);
		String expectedSucessMsg = schedulesPageProp.getProperty("expectedSuccessToasterDeleteMsg");
		sp.verifySuccessToasterMsg(expectedSucessMsg);
		log.info("Verify Delete For Schedule With No Process Assigned - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}

	/**
	 * verify Delete For Schedule With Process Assigned
	 * 
	 * @throws AWTException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Test(priority = 4)
	public void verifyDeleteForScheduleWithProcessAssigned() throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify Delete For Schedule With Process Assigned- Begin");
		String scheduleName = createSchedulePageProp.getProperty("scheduleWithProcessAssigned");
		String processName = createProcessPageProp.getProperty("nameProcessWithScheduleAssignedForDeleteSchedule");
		String scheduleDesc = createSchedulePageProp.getProperty("scheduleDescription");
		createSchedule(scheduleName, scheduleDesc);
		int initialProcessCount = sp.getProcessCountForSchedule(scheduleName);
		log.info("Test count: " + initialProcessCount);
		selectScheduleInProcess(scheduleName, processName);
		np.processesTab();
		np.schedulesSubTab();
		int expectedProcessCount = initialProcessCount + 1;
		Assert.assertEquals(sp.getProcessCountForSchedule(scheduleName), expectedProcessCount,
				"Process count is not increased");
		String expectedMsg = schedulesPageProp.getProperty("expectedDeletePopupMsg");
		sp.verifyDeletePopup(scheduleName, expectedMsg);
		log.info("Create Schedule & Select in Process - End");
		np.processesTab();
		np.overviewSubTab();
		op.deleteProcess(processName);
		wait(2);
		np.processesTab();
		np.schedulesSubTab();
		sp.deleteSchedule(scheduleName);
		log.info("Verify Delete For Schedule With Process Assigned  - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}

	/**
	 * verify Process associated with Schedule
	 * 
	 * @throws AWTException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Test(priority = 5)
	public void verifyProcessAssociatedWithSchedule() throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify Process Associated With Schedule- Begin");
		String scheduleName = createSchedulePageProp.getProperty("scheduleToverifyProcessAssociated");
		String processName = createProcessPageProp.getProperty("nameProcessAssociatedWithSchedule");
		String scheduleDesc = createSchedulePageProp.getProperty("scheduleDescription");
		createSchedule(scheduleName, scheduleDesc);
		int initialProcessCount = sp.getProcessCountForSchedule(scheduleName);
		log.info("Test count: " + initialProcessCount);
		selectScheduleInProcess(scheduleName, processName);
		np.processesTab();
		np.schedulesSubTab();
		int expectedProcessCount = initialProcessCount + 1;
		Assert.assertEquals(sp.getProcessCountForSchedule(scheduleName), expectedProcessCount,
				"Process count is not increased");
		sp.clickOnScheduleChevronIcon(scheduleName);
		wait(1);
		String expectedProcessName = sp.getFirstAssociatedProcessName();
		Assert.assertEquals(processName, expectedProcessName, "Process is not associated to the schedule");
		np.processesTab();
		np.overviewSubTab();
		op.deleteProcess(processName);
		wait(2);
		np.processesTab();
		np.schedulesSubTab();
		sp.deleteSchedule(scheduleName);
		log.info("Verify Process Associated With Schedule  - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}

	/**
	 * verify Edit Schedule for schedule with Process Associated
	 * 
	 * @throws AWTException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Test(priority = 6)
	public void verifyEditScheduleProcessAssociated() throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify Edit Schedule for schedule with Process Associated  - Begin");
		String scheduleName = createSchedulePageProp.getProperty("scheduleToVerifyEditScheduleProcessAssociated");
		String processName = createProcessPageProp.getProperty("nameProcessToVerifyEditSchedule");
		String scheduleDesc = createSchedulePageProp.getProperty("scheduleDescription");
		createSchedule(scheduleName, scheduleDesc);
		selectScheduleInProcess(scheduleName, processName);
		np.processesTab();
		np.schedulesSubTab();
		int index = sp.getScheduleIndex(scheduleName);
		sp.clickHamburgerIcon(index - 1);
		sp.clickEditLink(index - 1);
		sp.clickYesButton();
		Assert.assertEquals(scheduleName, csp.getScheduleNameText());
		Assert.assertTrue(csp.checkIfMondaySelected());
		String editedScheduleName = createSchedulePageProp.getProperty("editedscheduleToVerifyProcessAssociated");
		String editedScheduledesc = createSchedulePageProp.getProperty("editedscheduleDescription");
		csp.setScheduleName(editedScheduleName);
		csp.setScheduleDescription(editedScheduledesc);
		csp.clickMondayCheckBox();
		csp.selectMultipleDays();
		csp.clickSave();
		sp.verifySuccessToasterMsg(createSchedulePageProp.getProperty("expectedSuccessToasterMessageEditSchedule"));
		sp.verifyNameForCreatedSchedule(editedScheduleName);
		sp.verifyDescriptionForCreatedSchedule(editedScheduleName, editedScheduledesc);
		sp.verifySelectedDaysForCreatedSchedule(editedScheduleName, csp.daysList);
		sp.verifyStarttimeForCreatedSchedule(editedScheduleName, csp.startTime);
		sp.verifyEndtimeForCreatedSchedule(editedScheduleName, csp.endTime);
		np.processesTab();
		np.overviewSubTab();
		String actualScheduleName = op.getScheduleName(op.getProcessIndex(processName) - 1);
		Assert.assertEquals(actualScheduleName, editedScheduleName);
		op.deleteProcess(processName);
		np.navigateToHomePage();
		np.processesTab();
		np.schedulesSubTab();
		sp.deleteSchedule(editedScheduleName);
		log.info("verify Edit Schedule for schedule with Process Associated  - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}

	/**
	 * verify Edit Schedule if no Process Associated
	 * 
	 * @throws AWTException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Test(priority = 7)
	public void verifyEditScheduleNoProcessAssociated() throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify Edit Schedule If No Processes Associated  - Begin");
		String scheduleName = createSchedulePageProp.getProperty("scheduleToVerifyEditScheduleNoProcessAssociated");
		String scheduleDesc = createSchedulePageProp.getProperty("scheduleDescription");
		createSchedule(scheduleName, scheduleDesc);
		int index = sp.getScheduleIndex(scheduleName);
		sp.clickHamburgerIcon(index - 1);
		sp.clickEditLink(index - 1);
		String editedScheduleName = createSchedulePageProp.getProperty("editedscheduleToVerifyNoProcessAssociated");
		String editedScheduledesc = createSchedulePageProp.getProperty("editedscheduleDescription");
		csp.setScheduleName(editedScheduleName);
		csp.setScheduleDescription(editedScheduledesc);
		csp.clickMondayCheckBox();
		csp.selectMultipleDays();
		csp.clickSave();
		sp.verifySuccessToasterMsg(createSchedulePageProp.getProperty("expectedSuccessToasterMessageEditSchedule"));
		sp.verifyNameForCreatedSchedule(editedScheduleName);
		sp.verifyDescriptionForCreatedSchedule(editedScheduleName, editedScheduledesc);
		sp.verifySelectedDaysForCreatedSchedule(editedScheduleName, csp.daysList);
		sp.verifyStarttimeForCreatedSchedule(editedScheduleName, csp.startTime);
		sp.verifyEndtimeForCreatedSchedule(editedScheduleName, csp.endTime);
		sp.deleteSchedule(editedScheduleName);
		log.info("Verify Edit Schedule If No Processes Associated  - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}

	/**
	 * verify existing values on Edit Schedule page
	 * 
	 * @throws AWTException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Test(priority = 8)
	public void verifyExistingValuesEditSchedule() throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify Edit Schedule If No Processes Associated  - Begin");
		String scheduleName = createSchedulePageProp.getProperty("scheduleToverifyExistingValues");
		String scheduleDesc = createSchedulePageProp.getProperty("scheduleDescription");
		createSchedule(scheduleName, scheduleDesc);
		int index = sp.getScheduleIndex(scheduleName);
		sp.clickHamburgerIcon(index - 1);
		sp.clickEditLink(index - 1);
		Assert.assertEquals(scheduleName, csp.getScheduleNameText());
		Assert.assertEquals(scheduleDesc, csp.getScheduleDescriptionText());
		Assert.assertTrue(csp.checkIfMondaySelected());
		Assert.assertEquals((csp.getDelayIntervalValue()).substring(0, 2),
				createSchedulePageProp.getProperty("defaultDelayIntervalValue"));
		String editedScheduleName = createSchedulePageProp.getProperty("editedscheduleToverifyExistingValues");
		String editedScheduledesc = createSchedulePageProp.getProperty("editedscheduleDescription");
		csp.setScheduleName(editedScheduleName);
		csp.setScheduleDescription(editedScheduledesc);
		int DelayInterval = Integer.parseInt(createSchedulePageProp.getProperty("delayIntervalValue"));
		for (int i = 0; i < DelayInterval; i++) {
			csp.clickPlusOnDelayInterval();
		}
		csp.selectTuesday();
		csp.clickSave();
		sp.verifySuccessToasterMsg(createSchedulePageProp.getProperty("expectedSuccessToasterMessageEditSchedule"));
		int index1 = sp.getScheduleIndex(editedScheduleName);
		sp.clickHamburgerIcon(index1 - 1);
		sp.clickEditLink(index1 - 1);
		Assert.assertEquals(csp.getScheduleNameText(), editedScheduleName);
		Assert.assertEquals(csp.getScheduleDescriptionText(), editedScheduledesc);
		Assert.assertTrue(csp.checkIfMondaySelected());
		Assert.assertTrue(csp.checkIfTuesdaySelected());
		Assert.assertEquals((csp.getDelayIntervalValue()).substring(0, 2),
				createSchedulePageProp.getProperty("delayIntervalValue"));
		csp.clickSave();
		sp.verifySuccessToasterMsg(createSchedulePageProp.getProperty("expectedSuccessToasterMessageEditSchedule"));
		sp.deleteSchedule(editedScheduleName);
		log.info("Verify Edit Schedule If No Processes Associated  - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}

	/**
	 * create Schedule
	 * 
	 * @throws AWTException
	 * @throws IOException
	 * @throws InterruptedException
	 */

	public void createSchedule(String scheduleName, String scheduleDesc) throws InterruptedException, IOException {
		np.navigateToHomeAndClickOnProcessesTab();
		np.schedulesSubTab();
		sp.clickCreateNewScheduleButton();
		csp.setScheduleName(scheduleName);
		csp.setScheduleDescription(scheduleDesc);
		csp.selectMonday();
		csp.clickSave();
		wait(2);
		sp.verifyNameForCreatedSchedule(scheduleName);
	}

	/**
	 * Select In Process
	 * 
	 * @throws AWTException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void selectScheduleInProcess(String scheduleName, String processName)
			throws IOException, InterruptedException, AWTException {
		np.processesTab();
		op.deleteProcessIfAlreadyExists(processName);
		op.clickCreateNewProcessButton();
		cp.setProcessName(processName);
		cp.selectOptionFromScheduleDropDown(scheduleName);
		wait(2);
		cp.clickSave();
		cp.verifyCreateProcessSuccessToasterMsg();
	}

}
