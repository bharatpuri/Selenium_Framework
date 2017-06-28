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

public class TestDefinitionWizardPage1 extends TestBase {
	ProcessOverview op;
	SchedulesOverview sp;
	DefinitionOverview dp;
	CreateDefinition cdp;
	NavigationBar np;
	CreateProcess cp;

	/**
	 * This executes before all the test methods
	 */

	@BeforeClass
	public void setup() throws MalformedURLException {
		try {
			op = new ProcessOverview(driver);
			sp = new SchedulesOverview(driver);
			dp = new DefinitionOverview(driver);
			cp = new CreateProcess(driver);
			cdp = new CreateDefinition(driver);
			np = new NavigationBar(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * check Default Values In Definition wizard Page1
	 */
	@Test(priority = 1)
	public void verifyDefaultValuesInCreateDefinitionPage1() throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify Default Values In Definition wizard Page1 - Begin");
		np.navigateToHomeAndClickOnProcessesTab();
		np.definitionsSubTab();
		dp.clickCreateNewDefinitionButton();
		String expectedNamePlaceHolder = createDefinitionPageProp.getProperty("expectedDefinitionNamePlaceHolder");
		String expectedDescriptionPlaceHolder = createDefinitionPageProp.getProperty("expectedDefinitiondescriptionPlaceHolder");
		String actualNamePlaceHolder= cdp.getDefinitionNameText();
		String actualDescriptionPlaceHolder =cdp.getDefinitionDescriptionText();
		Assert.assertEquals(actualNamePlaceHolder, expectedNamePlaceHolder, "Name Placeholder is incorrect");
		Assert.assertEquals(actualDescriptionPlaceHolder, expectedDescriptionPlaceHolder,"Description Placeholder is incorrect");
		cdp.clickClose();
		log.info("Verify Default Values In Definition wizard Page1 - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}

	/**
	 * Creating Definition With DefinitionName Only
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 2)
	public void verifyCreateDefinitionWithDefinitionNameOnly() throws InterruptedException, IOException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify create Definition With Definition Name Only - Begin");
		np.navigateToHomeAndClickOnProcessesTab();
		np.definitionsSubTab();
		String definitionName = createDefinitionPageProp.getProperty("definitionName");
		dp.createProcessDefinitionButtonIsClickable();
		dp.clickCreateNewDefinitionButton();
		cdp.enterDefinitionName(definitionName);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		cdp.clickSave();
		cdp.verifyToasterMsgAfterSaveDraft();
		cdp.clickClose();
		dp.verifyNameForCreatedDefinition(definitionName);
		 dp.deleteDefinition(definitionName);
		log.info("Verify create Definition With Process Name Only - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}

	/**
	 * Creating Definition With definition Name & Description Only
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 */
	@Test(priority = 3)
	public void verifyCreateDefinitionWithDefinitionNameAndDescription()
			throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify create Definition With Definition Name and Description - Begin");
		np.navigateToHomeAndClickOnProcessesTab();
		np.definitionsSubTab();
		String definitionName = createDefinitionPageProp.getProperty("definitionNameWithDescription");
		String description = createDefinitionPageProp.getProperty("definitionDescription");
		dp.createProcessDefinitionButtonIsClickable();
		dp.clickCreateNewDefinitionButton();
		cdp.enterDefinitionNameAndDescription(definitionName, description);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		cdp.clickSave();
		cdp.verifyToasterMsgAfterSaveDraft();
		cdp.clickClose();
		dp.verifyNameForCreatedDefinition(definitionName);
		dp.verifyDescriptionForCreatedDefinition(definitionName, description);
		 dp.deleteDefinition(definitionName);
		log.info("Verify create Definition With Definition Name and Description - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}

	/**
	 * unique Definition Name Verification
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 */
	@Test(priority = 4)
	public void verifyUniqueProcessDefinitionNameVerification() throws IOException, InterruptedException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify unique Process Definition Name Verification - Begin");
		np.navigateToHomeAndClickOnProcessesTab();
		np.definitionsSubTab();
		String definitionName = createDefinitionPageProp.getProperty("uniqueNameVerification");
		dp.createProcessDefinitionButtonIsClickable();
		dp.clickCreateNewDefinitionButton();
		cdp.enterDefinitionName(definitionName);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		cdp.clickSave();
		cdp.verifyToasterMsgAfterSaveDraft();
		cdp.clickClose();
		dp.clickCreateNewDefinitionButton();
		String definitionNameVerification = createDefinitionPageProp.getProperty("uniqueNameVerification");
		cdp.enterDefinitionName(definitionNameVerification);
		cdp.clickNextButton();
		String actualVerificationMsg = cdp.getActualUniqueNameValidationMsg();
		String expectedVerificationMsg = createDefinitionPageProp.getProperty("expectedUniqueNameValidationMsg");
		Assert.assertEquals(actualVerificationMsg, expectedVerificationMsg,
				"Unique Definition name Validation message not displayed");
		String expectedToasterErrorMsg = createDefinitionPageProp.getProperty("expectedUniqueNameErrorToasterMessage");
		cdp.verifyErrorToasterMsg(expectedToasterErrorMsg);
		cdp.clickClose();
		cdp.clickYes();
		 dp.deleteDefinition(definitionName);
		log.info("Verify unique Process Definition Name Verification - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}

	/**
	 * Blank Definition Name Verification
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 */
	@Test(priority = 5)
	public void verifyBlankProcessDefinitionNameVerification() throws IOException, InterruptedException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify blank Process Definition Name Verification - Begin");
		np.navigateToHomeAndClickOnProcessesTab();
		np.definitionsSubTab();
		dp.createProcessDefinitionButtonIsClickable();
		dp.clickCreateNewDefinitionButton();
		cdp.clickNextButton();
		String actualValidationMsg = cdp.getActualNameValidationMsg();
		String expectedValidationMsg = createDefinitionPageProp.getProperty("expectedRequiredNameValidationMsg");
		Assert.assertEquals(actualValidationMsg, expectedValidationMsg,
				"Definition name Validation message not displayed");
		String expectedToasterErrorMsg = createDefinitionPageProp
				.getProperty("expectedRequiredNameErrorToasterMessage");
		cdp.verifyErrorToasterMsg(expectedToasterErrorMsg);
		cdp.clickClose();
		log.info("Verify blank Process Definition Name Verification - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}

	/**
	 * Definition Name with space Verification
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 */
	@Test(priority = 6)
	public void verifyProcessDefinitionNameWithSpaceVerification()
			throws IOException, InterruptedException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify process Definition Name With Space Verification - Begin");
		np.navigateToHomeAndClickOnProcessesTab();
		np.definitionsSubTab();
		dp.createProcessDefinitionButtonIsClickable();
		dp.clickCreateNewDefinitionButton();
		cdp.enterDefinitionName(" ");
		cdp.clickNextButton();
		String actualValidationMsg = cdp.getActualNameValidationMsg();
		String expectedValidationMsg = createDefinitionPageProp.getProperty("expectedRequiredNameValidationMsg");
		Assert.assertTrue(compareTextContains(actualValidationMsg, expectedValidationMsg),
				"Definition name with space Validation message not displayed");
		String expectedToasterErrorMsg = createDefinitionPageProp
				.getProperty("expectedRequiredNameErrorToasterMessage");
		cdp.verifyErrorToasterMsg(expectedToasterErrorMsg);
		cdp.clickClose();
		cdp.clickYes();
		log.info("Verify process Definition Name With Space Verification - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}

	/**
	 * Verify Close Definition With SaveDraft
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 */
	@Test(priority = 7)
	public void verifyCloseDefinitionWithSaveDraft() throws InterruptedException, IOException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify Dialog box verification With Save Draft - Begin! ");
		np.navigateToHomeAndClickOnProcessesTab();
		np.definitionsSubTab();
		dp.createProcessDefinitionButtonIsClickable();
		dp.clickCreateNewDefinitionButton();
		String definitionName = createDefinitionPageProp.getProperty("closeDefinitionWithSaveDraft");
		cdp.enterDefinitionName(definitionName);
		String Description = createDefinitionPageProp.getProperty("definitionDescriptionDialogBoxWithSave");
		cdp.enterDefinitionDescription(Description);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		cdp.clickSave();
		cdp.verifyToasterMsgAfterSaveDraft();
		cdp.clickClose();
		 dp.deleteDefinition(definitionName);
		log.info("Verify Dialog box verification With Save Draft - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}

	/**
	 * Verify Close Definition Without SaveDraft
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 */
	@Test(priority = 8)
	public void verifyCloseDefinitionWithoutSaveDraft() throws InterruptedException, IOException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify dialog Box Verification Without Save Draft - Begin");
		np.navigateToHomeAndClickOnProcessesTab();
		np.definitionsSubTab();
		dp.createProcessDefinitionButtonIsClickable();
		dp.clickCreateNewDefinitionButton();
		wait(2);
		String definitionName = createDefinitionPageProp.getProperty("closeDefinitionWithoutSaveDraft");
		cdp.enterDefinitionName(definitionName);
		cdp.clickClose();
		wait(2);
		Assert.assertTrue(dp.isYesEnabled(), "Yes button is not clickable");
		Assert.assertTrue(dp.isNoEnabled(), "No button is not clickable");
		dp.clickYes();
		log.info("Verify dialog Box Verification Without Save Draft - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}
	
	/**
	 * Verify Breadcrumb on Process Definition Wizard Page 1 and Page 2
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 */
	@Test(priority = 9)
	public void verifyActivePageBreadcrumbOnProcessDefinitionWizard() throws InterruptedException, IOException {
		log.info("---------------------------------------------------------------------------------");
		log.info("verify Active Page Breadcrumb On Process Definition Wizard - Begin");
		np.navigateToHomeAndClickOnProcessesTab();
		np.definitionsSubTab();
		dp.createProcessDefinitionButtonIsClickable();
		dp.clickCreateNewDefinitionButton();
		wait(2);
		cdp.verifyActiveToasterOnDefinitionWizardPageOne();
		String definitionName = createDefinitionPageProp.getProperty("verifyBreadCrumbOnDefinitionWizard");
		cdp.enterDefinitionName(definitionName);
		cdp.clickNextButtonAndWaitTillPage2IsOpened();
		wait(2);
		cdp.verifyActiveToasterOnDefinitionWizardPageTwo();
		/*Assert.assertTrue(dp.isYesEnabled(), "Yes button is not clickable");
		Assert.assertTrue(dp.isNoEnabled(), "No button is not clickable");
		dp.clickYes();*/
		log.info("verify Active Page Breadcrumb On Process Definition Wizard - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}

}
