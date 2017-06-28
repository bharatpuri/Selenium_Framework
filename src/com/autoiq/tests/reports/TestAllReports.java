package com.autoiq.tests.reports;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.autoiq.base.TestBase;
import com.autoiq.pages.NavigationBar;
import com.autoiq.pages.processes.CreateProcess;
import com.autoiq.pages.processes.ProcessOverview;
import com.autoiq.pages.reports.AllReports;
import com.autoiq.pages.schedules.CreateSchedule;
import com.autoiq.pages.schedules.SchedulesOverview;

/**
 * The Class Test_schedule.
 */
public class TestAllReports extends TestBase {
	ProcessOverview op;
	SchedulesOverview sp;
	NavigationBar np;
	CreateSchedule csp;
	CreateProcess cp;
	AllReports ar;

	/**
	 * This executes before all the test methods
	 */

	@BeforeClass
	public void setup() throws MalformedURLException {
		try {
			np = new NavigationBar(driver);
			ar = new AllReports(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * verify contents of reports page
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 1)
	public void verifyContentsOfReportsPage() throws InterruptedException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify Reports Page content - Begin!!");
		np.reportsTab();
		np.allReportSubTab();
		ar.reportPageContentVerification();
		log.info("Verify Reports Page content - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}
	
	/**
	 * verify Chevron Icon On Left Panel
	 * 
	 * @throws InterruptedException
	 */
//	@Test(priority = 2)
	public void verifyChevronIconOnLeftPanelForAllReports() throws InterruptedException {
		log.info("---------------------------------------------------------------------------------");
		log.info("verify Chevron Icon On Left Panel - Begin!!");
		np.reportsTab();
		np.allReportSubTab();
		ar.verifyChevronIcon();
		log.info("verify Chevron Icon On Left Panel - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}
	
	/**
	 * Right panel Content Verification
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 2)
	public void verifyRightpanelContent() throws InterruptedException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify Right panel Content - Begin!!");
		np.reportsTab();
		np.allReportSubTab();
		ar.clickOnStandardReportByIndex(1);
		ar.reportPageRightPanelContentVerification();
		log.info("Verify Right panel Content - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}
	
	/**
	 * verify showmore/showless button Verification
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 3)
	public void verifyShowmoreShowlessButton() throws InterruptedException {
		log.info("---------------------------------------------------------------------------------");
		log.info("verify Showmore/Showless Button on standard Reports - Begin!!");
		np.reportsTab();
		np.allReportSubTab();
		if(ar.isShowmoreButtonPresent()==true){
			Assert.assertTrue(compareTextContains(ar.getShowmoreShowlessButtonText(), "Show More"));
			ar.clickOnShowMoreOrLessButton();
			Assert.assertTrue(ar.getTotalreportsCount() > 10,"Reports count is less than 10 , hence show more should not be displayed");
			Assert.assertTrue(compareTextContains(ar.getShowmoreShowlessButtonText(), "Show Less"));
			ar.clickOnShowMoreOrLessButton();
			Assert.assertEquals(ar.getTotalreportsCount(),10, "On Show less,10 standard reports should be displayed");
		}else{
			Assert.assertTrue(ar.getTotalreportsCount() < 10,"Reports count is greater than 10, hence show more should be displayed ");
		}
		log.info("verify Showmore/Showless Button on standard Reports - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}

}
