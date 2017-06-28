package definitions;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.autoiq.base.AutoiqCommonActions;
import com.autoiq.common.utility.CommonUtility;
import com.autoiq.common.utility.CommonWebFunctions;
import com.autoiq.common.utility.DataStoreInObjects;
import com.autoiq.common.utility.HandleException;
import com.autoiq.tests.dashboard.Navigation;
import com.autoiq.tests.login.TestLogin;

public class TestDefinitionWizardPageNew1 {
	final static Logger logger = Logger.getLogger(TestDefinitionWizardPageNew1.class.getName());

	CommonWebFunctions actions = new CommonWebFunctions();
	DataStoreInObjects locators = new DataStoreInObjects();
	DataStoreInObjects testData = new DataStoreInObjects();
	AutoiqCommonActions appCommon = new AutoiqCommonActions();

	TestLogin login = new TestLogin();
	Navigation navigation = new Navigation();
	Definition definition = new Definition();

	public TestDefinitionWizardPageNew1() throws HandleException {
		locators = CommonUtility.loadLocators("Page Objects", "DefinitionPage");
		testData = CommonUtility.loadTestData("Test Data", "DefinitionTestData");

	}

	@BeforeTest
	public void setup() throws HandleException {
		actions.launchBrowser();
		login.loginWithValidCredentials();
	}

	/**
	 * Check Default Values In Definition wizard Page1
	 */
	@Test(priority = 1)
	public void verifyDefaultValuesInCreateDefinitionPage1() throws HandleException {
		logger.info("---------------------------------------------------------------------------------");
		logger.info("Verify Default Values In Definition wizard Page1 - Begin");
		navigation.navigateToHomePage();
		navigation.definitionsTab();
		actions.clickOnElement(locators.getValue("clickCreateNewDefinitionButton"));
		String expectedDefinitionNamePlaceHolder = "";
		String expectedDefinitiondescriptionPlaceHolder = "";
		String actualDefinitionNamePlaceHolder = actions
				.getElementPlaceholder(locators.getValue("processDefinitionName"));
		String actualDefinitiondescriptionPlaceHolder = actions.getElementPlaceholder(locators.getValue("description"));
		actions.verifyTextWithAssertContains(actualDefinitionNamePlaceHolder, expectedDefinitionNamePlaceHolder);
		actions.verifyTextWithAssertContains(actualDefinitiondescriptionPlaceHolder, expectedDefinitiondescriptionPlaceHolder);
		actions.clickOnElement(locators.getValue("closeButton"));
		logger.info("Verify Default Values In Definition wizard Page1 - End");
		logger.info("-----------------------------------------XXX--------------------------------------");
	}

	/**
	 * Creating Definition With DefinitionName Only
	 * 
	 * @throws InterruptedException
	 * @throws HandleException
	 */
	@Test(priority = 2)
	public void verifyCreateDefinitionWithDefinitionNameOnly() throws HandleException {
		logger.info("---------------------------------------------------------------------------------");
		logger.info("Verify create Definition With Definition Name Only - Begin");
		navigation.navigateToHomePage();
		navigation.definitionsTab();
		String defName = testData.getValue("definitionName");
		actions.clickOnElement(locators.getValue("clickCreateNewDefinitionButton"));
		actions.sendKeysToElement(defName, locators.getValue("processDefinitionName"));
		actions.clickOnElement(locators.getValue("nextButton"));
		actions.clickOnElement(locators.getValue("saveButton"));
		String successToasterMsg = actions.getElementText(locators.getValue("successToasterMsg"));
		String expectedSuccessValidationMsg = testData.getValue("expectedSuccessValidationMsg");
		actions.verifyTextWithAssertContains(successToasterMsg, expectedSuccessValidationMsg);
		actions.clickOnElement(locators.getValue("toasterMsg"));
		actions.clickOnElement(locators.getValue("closeButton"));
		String actualDefinitionName = actions
				.getElementText(actions.getDynamicXpath(defName, locators.getValue("definationName")));
		actions.verifyTextWithAssertContains(actualDefinitionName, defName);

		String selectDefinition = actions.getDynamicXpath(defName, locators.getValue("selectDefination"));
		appCommon.selectElement(selectDefinition);

		String deleteDefinition = actions.getDynamicXpath(defName, locators.getValue("deleteDifinition"));
		appCommon.deleteElement(deleteDefinition);

		actions.clickOnElement(locators.getValue("toasterMsg"));

		logger.info("Verify create Definition With Process Name Only - End");
		logger.info("-----------------------------------------XXX--------------------------------------");

	}

	/**
	 * Creating Definition With definition Name & Description Only
	 * 
	 * @throws HandleException
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 */
	@Test(priority = 3)
	public void verifyCreateDefinitionWithDefinitionNameAndDescription() throws HandleException {
		logger.info("---------------------------------------------------------------------------------");
		logger.info("Verify create Definition With Definition Name and Description - Begin");
		navigation.navigateToHomePage();
		navigation.definitionsTab();
		String defName = testData.getValue("definitionName");
		String defDescription = testData.getValue("definitionDescription");
		actions.clickOnElement(locators.getValue("clickCreateNewDefinitionButton"));
		actions.sendKeysToElement(defName, locators.getValue("processDefinitionName"));
		actions.sendKeysToElement(defDescription, locators.getValue("description"));
		actions.clickOnElement(locators.getValue("nextButton"));
		actions.clickOnElement(locators.getValue("saveButton"));
		definition.verifyToasterMsgAfterSaveDraft();
		actions.clickOnElement(locators.getValue("toasterMsg"));
		actions.clickOnElement(locators.getValue("closeButton"));
		definition.verifyNameForCreatedDefinition(defName);
		definition.verifyDescriptionForCreatedDefinition(defDescription);
		definition.selectDefinition(defName);
		definition.deleteDefinition(defName);
		actions.clickOnElement(locators.getValue("toasterMsg"));
		logger.info("Verify create Definition With Definition Name and Description - End");
		logger.info("-----------------------------------------XXX--------------------------------------");
	}

	/**
	 * unique Definition Name Verification
	 * 
	 * @throws HandleException
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 */
	@Test(priority = 4)
	public void verifyUniqueProcessDefinitionNameVerification() throws HandleException, InterruptedException {
		logger.info("---------------------------------------------------------------------------------");
		logger.info("Verify unique Process Definition Name Verification - Begin");
		navigation.navigateToHomePage();
		navigation.definitionsTab();
		String defName = testData.getValue("uniqueNameVerification");
		actions.clickOnElement(locators.getValue("clickCreateNewDefinitionButton"));
		actions.sendKeysToElement(defName, locators.getValue("processDefinitionName"));
		actions.clickOnElement(locators.getValue("nextButton"));
		actions.clickOnElement(locators.getValue("saveButton"));
		definition.verifyToasterMsgAfterSaveDraft();
		actions.clickOnElement(locators.getValue("toasterMsg"));
		actions.clickOnElement(locators.getValue("closeButton"));
		// CommonUtility.waitSeconds(3);
		actions.clickOnElement(locators.getValue("clickCreateNewDefinitionButton"));
		// CommonUtility.waitSeconds(3);
		String definitionNameVerification = testData.getValue("uniqueNameVerification");
		actions.sendKeysToElement(definitionNameVerification, locators.getValue("processDefinitionName"));
		actions.clickOnElement(locators.getValue("nextButton"));

		String actualVerificationMsg = actions.getElementText(locators.getValue("nameValidationMsg"));
		String expectedVerificationMsg = testData.getValue("expectedUniqueNameValidationMsg");
		actions.verifyTextWithAssertContains(actualVerificationMsg, expectedVerificationMsg);

		String actualErrorMsg = actions.getElementText(locators.getValue("errorToasterMsg"));
		String expectedToasterErrorMsg = testData.getValue("expectedUniqueNameErrorToasterMessage");
		System.out.println(actualErrorMsg);
		System.out.println(expectedToasterErrorMsg);
		actions.verifyTextWithAssertContains(actualErrorMsg, expectedToasterErrorMsg);
		actions.clickOnElement(locators.getValue("toasterMsg"));

		actions.clickOnElement(locators.getValue("closeButton"));
		actions.clickOnElement(locators.getValue("yesButton"));

		definition.selectDefinition(defName);
		definition.deleteDefinition(defName);
		actions.clickOnElement(locators.getValue("toasterMsg"));

		logger.info("Verify unique Process Definition Name Verification - End");
		logger.info("-----------------------------------------XXX--------------------------------------");

	}

	/**
	 * Blank Definition Name Verification
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 * @throws HandleException
	 */
	@Test(priority = 5)
	public void verifyBlankProcessDefinitionNameVerification() throws HandleException {
		logger.info("---------------------------------------------------------------------------------");
		logger.info("Verify blank Process Definition Name Verification - Begin");
		navigation.navigateToHomePage();
		navigation.definitionsTab();
		actions.clickOnElement(locators.getValue("clickCreateNewDefinitionButton"));
		actions.clickOnElement(locators.getValue("nextButton"));
		String actualValidationMsg = actions.getElementText(locators.getValue("nameValidationMsg"));
		String expectedValidationMsg = testData.getValue("expectedRequiredNameValidationMsg");
		actions.verifyTextWithAssertContains(actualValidationMsg, expectedValidationMsg);

		String expectedToasterErrorMsg = testData.getValue("expectedRequiredNameErrorToasterMessage");
		String actualErrorMsg = actions.getElementText(locators.getValue("errorToasterMsg"));
		actions.verifyTextWithAssertContains(actualErrorMsg, expectedToasterErrorMsg);
		actions.clickOnElement(locators.getValue("toasterMsg"));
		actions.clickOnElement(locators.getValue("closeButton"));

		logger.info("Verify blank Process Definition Name Verification - End");
		logger.info("-----------------------------------------XXX--------------------------------------");
	}

	/**
	 * Definition Name with space Verification
	 * 
	 * @throws HandleException
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 */
	@Test(priority = 6)
	public void verifyProcessDefinitionNameWithSpaceVerification() throws HandleException, InterruptedException {
		logger.info("---------------------------------------------------------------------------------");
		logger.info("Verify process Definition Name With Space Verification - Begin");
		navigation.navigateToHomePage();
		navigation.definitionsTab();
		actions.clickOnElement(locators.getValue("clickCreateNewDefinitionButton"));
		String defName = "  ";
		actions.sendKeysToElement(defName, locators.getValue("processDefinitionName"));
		actions.clickOnElement(locators.getValue("nextButton"));

		String actualValidationMsg = actions.getElementText(locators.getValue("nameValidationMsg"));
		String expectedValidationMsg = testData.getValue("expectedRequiredNameValidationMsg");
		actions.verifyTextWithAssertContains(actualValidationMsg, expectedValidationMsg);

		String expectedToasterErrorMsg = testData.getValue("expectedRequiredNameErrorToasterMessage");
		String actualErrorMsg = actions.getElementText(locators.getValue("errorToasterMsg"));
		actions.verifyTextWithAssertContains(actualErrorMsg, expectedToasterErrorMsg);

		actions.clickOnElement(locators.getValue("closeButton"));
		actions.clickOnElement(locators.getValue("yesButton"));

		logger.info("Verify process Definition Name With Space Verification - End");
		logger.info("-----------------------------------------XXX--------------------------------------");

	}

	/**
	 * Verify Close Definition With SaveDraft
	 * 
	 * @throws HandleException
	 */
	@Test(priority = 7)
	public void verifyCloseDefinitionWithSaveDraft() throws HandleException {
		logger.info("---------------------------------------------------------------------------------");
		logger.info("Verify Dialog box verification With Save Draft - Begin! ");

		navigation.navigateToHomePage();
		navigation.definitionsTab();
		actions.clickOnElement(locators.getValue("clickCreateNewDefinitionButton"));
		String definitionName = testData.getValue("closeDefinitionWithSaveDraft");
		actions.sendKeysToElement(definitionName, locators.getValue("processDefinitionName"));
		String defDescription = testData.getValue("definitionDescriptionDialogBoxWithSave");
		actions.sendKeysToElement(defDescription, locators.getValue("description"));
		actions.clickOnElement(locators.getValue("nextButton"));
		actions.clickOnElement(locators.getValue("saveButton"));
		definition.verifyToasterMsgAfterSaveDraft();
		actions.clickOnElement(locators.getValue("closeButton"));

		definition.selectDefinition(definitionName);
		definition.deleteDefinition(definitionName);

		logger.info("Verify Dialog box verification With Save Draft - End");
		logger.info("-----------------------------------------XXX--------------------------------------");
	}

	/**
	 * Verify Close Definition Without SaveDraft
	 * 
	 * @throws HandleException
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 8)
	public void verifyCloseDefinitionWithoutSaveDraft() throws HandleException {
		logger.info("---------------------------------------------------------------------------------");
		logger.info("Verify dialog Box Verification Without Save Draft - Begin");

		navigation.navigateToHomePage();
		navigation.definitionsTab();
		actions.clickOnElement(locators.getValue("clickCreateNewDefinitionButton"));
		String definitionName = testData.getValue("closeDefinitionWithoutSaveDraft");
		actions.sendKeysToElement(definitionName, locators.getValue("processDefinitionName"));

		actions.clickOnElement(locators.getValue("closeButton"));

		actions.verifyElementIsEnabled(locators.getValue("yesButton"));
		actions.verifyElementIsEnabled(locators.getValue("noButton"));

		actions.clickOnElement(locators.getValue("yesButton"));

		logger.info("Verify dialog Box Verification Without Save Draft - End");
		logger.info("-----------------------------------------XXX--------------------------------------");
	}

	/**
	 * Verify Breadcrumb on Process Definition Wizard Page 1 and Page 2
	 * 
	 * @throws HandleException
	 */
	@Test(priority = 9)
	public void verifyActivePageBreadcrumbOnProcessDefinitionWizard() throws HandleException {
		logger.info("---------------------------------------------------------------------------------");
		logger.info("verify Active Page Breadcrumb On Process Definition Wizard - Begin");
		navigation.navigateToHomePage();
		navigation.definitionsTab();
		actions.clickOnElement(locators.getValue("clickCreateNewDefinitionButton"));
		definition.verifyActiveToasterOnDefinitionWizardPageOne();
		String definitionName = testData.getValue("verifyBreadCrumbOnDefinitionWizard");
		actions.sendKeysToElement(definitionName, locators.getValue("processDefinitionName"));
		actions.clickOnElement(locators.getValue("nextButton"));
		definition.verifyActiveToasterOnDefinitionWizardPageTwo();
		logger.info("verify Active Page Breadcrumb On Process Definition Wizard - End");
		logger.info("-----------------------------------------XXX--------------------------------------");
	}

}
