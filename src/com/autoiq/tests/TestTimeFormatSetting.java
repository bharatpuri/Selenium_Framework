package com.autoiq.tests;

import java.awt.AWTException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.autoiq.base.TestBase;
import com.autoiq.pages.NavigationBar;
import com.autoiq.pages.processes.ProcessOverview;
import com.autoiq.pages.Setting;
import com.autoiq.pages.login.Login;
import com.autoiq.pages.schedules.CreateSchedule;
import com.autoiq.pages.schedules.SchedulesOverview;

public class TestTimeFormatSetting extends TestBase {

	Login lp;
	ProcessOverview op;
	CreateSchedule csp;
	SchedulesOverview sp;
	Setting s;
	NavigationBar np;

	@BeforeClass
	public void setup() throws MalformedURLException {
		try {
			lp = new Login(driver);
			op = new ProcessOverview(driver);
			csp = new CreateSchedule(driver);
			sp = new SchedulesOverview(driver);
			s = new Setting(driver);
			np = new NavigationBar(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * verify Setting Time Format from Settings page
	 * 
	 * @throws InterruptedException
	 * @throws AWTException 
	 */
	@Test
	public void verifySettingTimeFormatOnSchedulePage() throws IOException, InterruptedException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify Setting Time Format On Schedule Page - Begin");
		np.navigateToHomeAndClickOnProcessesTab();
		np.schedulesSubTab();
		String scheduleName = createSchedulePageProp.getProperty("scheduleToVerifyTimeSetting");
		sp.clickCreateNewScheduleButton();
		csp.setScheduleName(scheduleName);
		csp.selectMonday();
		csp.clickSave();
		String expectedSucessMsg = createSchedulePageProp.getProperty("expectedSuccessToasterMessage");
		sp.verifySuccessToasterMsg(expectedSucessMsg);
		sp.verifyNameForCreatedSchedule(scheduleName);
		List<String> Starttime = new ArrayList<String>();
		Starttime.add(schedulesPageProp.getProperty("defaultStarttime12Hr"));
		List<String> endtime = new ArrayList<String>();
		endtime.add(schedulesPageProp.getProperty("defaultEndtime12Hr"));
		sp.verifyStarttimeForCreatedSchedule(scheduleName, Starttime);
		sp.verifyEndtimeForCreatedSchedule(scheduleName, endtime);
		np.navigateToSettingsPage();
		wait(2);
		s.clickTwentyFourHr();
		wait(2);
		np.processesTab();
		np.schedulesSubTab();
		sp.verifyNameForCreatedSchedule(scheduleName);
		List<String> sttime = new ArrayList<String>();
		sttime.add(schedulesPageProp.getProperty("defaultStarttime24Hr"));
		List<String> etime = new ArrayList<String>();
		etime.add(schedulesPageProp.getProperty("defaultEndtime24Hr"));
		sp.verifyStarttimeForCreatedSchedule(scheduleName, sttime);
		sp.verifyEndtimeForCreatedSchedule(scheduleName, etime);
		sp.clickCreateNewScheduleButton();
		Assert.assertEquals(createSchedulePageProp.getProperty("leftMarginTimeLabel"), csp.getLeftSliderLabel(),
				"Start time Didnot match");
		Assert.assertEquals(createSchedulePageProp.getProperty("rightMarginTimeLabel"), csp.getRightSliderLabel(),
				"End time Didnot match");
		np.navigateToSettingsPage();
		wait(2);
		s.clickTwelveHr();
		wait(2);
		np.processesTab();
		np.schedulesSubTab();
		sp.deleteSchedule(scheduleName);
		log.info("Verify Setting Time Format On Schedule Page- End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}
}
