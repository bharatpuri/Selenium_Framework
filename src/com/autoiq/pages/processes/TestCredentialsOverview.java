package com.autoiq.pages.processes;

import java.awt.AWTException;
import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.autoiq.base.TestBase;
import com.autoiq.pages.NavigationBar;
import com.autoiq.pages.credentials.CredentialsOverview;

/**
 * The Class TestCredentialsOverview.
 */
public class TestCredentialsOverview extends TestBase {
	NavigationBar np;
	CredentialsOverview cro;

	/**
	 * This executes before all the test methods
	 */

	@BeforeClass
	public void setup() throws MalformedURLException {
		try {
			np = new NavigationBar(driver);
			cro = new CredentialsOverview(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Verify Credential Groups Widget
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(priority = 1)
	public void verifyCredentialGroupsWidget()
			throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("verify Credential Groups Widget - Begin");
		np.navigateToHomePage();
		np.toolsTab();
		np.credentialsSubTab();
		np.credentialsPageVerification();
		cro.isaddCredentialsGroupDisplayed();
		log.info("verify Credential Groups Widget - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}
	
	/**
	 * Verify Applications Widget
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(priority = 2)
	public void verifyApplicationsWidget()
			throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("verify Applications Widget - Begin");
		np.navigateToHomePage();
		np.toolsTab();
		np.credentialsSubTab();
		np.credentialsPageVerification();
		cro.isaddApplicationsDisplayed();
		log.info("verify Applications Widget - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}
	
	/**
	 * Verify Credential Groups Widget
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(priority = 3)
	public void verifyHostGroupsWidget()
			throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("verify Host Groups Widget - Begin");
		np.navigateToHomePage();
		np.toolsTab();
		np.credentialsSubTab();
		np.credentialsPageVerification();
		cro.isaddHostGroupDisplayed();
		log.info("verify Host Groups Widget - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}
	
	/**
	 * Verify Cancel button on Add Credential Group page
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(priority = 4)
	public void verifyCancelAddCredentialGroup()
			throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("verify Cancel Add Credential Group - Begin");
		np.navigateToHomePage();
		np.toolsTab();
		np.credentialsSubTab();
		np.credentialsPageVerification();
		cro.isaddCredentialsGroupDisplayed();
		cro.clickAddCredentialGroupButton();
		cro.clickCancelAddCredentialGroupButton();
		log.info("verify Cancel Add Credential Group - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}

	/**
	 * check Default Values In Add Credential Group Page
	 */
	@Test(priority = 5)
	public void verifyDefaultValuesInAddCredentialGroupPage() throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify Default Values In Add Credential Group Page - Begin");
		np.navigateToHomePage();
		np.toolsTab();
		np.credentialsSubTab();
		np.credentialsPageVerification();
		cro.isaddCredentialsGroupDisplayed();
		cro.clickAddCredentialGroupButton();
		String expectedNamePlaceHolder = credentialPageProp.getProperty("expectedCredentialGroupNamePlaceHolder");
		String expectedDescriptionPlaceHolder = credentialPageProp.getProperty("expectedCredentialGroupdescriptionPlaceHolder");
		String actualNamePlaceHolder= cro.getCredentialGroupNameText();
		String actualDescriptionPlaceHolder =cro.getCredentialGroupDescriptionText();
		Assert.assertEquals(actualNamePlaceHolder, expectedNamePlaceHolder, "Name Placeholder is incorrect");
		Assert.assertEquals(actualDescriptionPlaceHolder, expectedDescriptionPlaceHolder,"Description Placeholder is incorrect");
		cro.clickCancelAddCredentialGroupButton();
		log.info("Verify Default Values In Add Credential Group Page - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}
	
	
	/**
	 * Verify Add Credential Group With Name Only
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(priority = 6)
	public void verifyAddCredentialGroupWithNameOnly()
			throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("verify Cancel Add Credential Group With Name Only - Begin");
		np.navigateToHomePage();
		np.toolsTab();
		np.credentialsSubTab();
		np.credentialsPageVerification();
		cro.isaddCredentialsGroupDisplayed();
		cro.clickAddCredentialGroupButton();
		String credentialGroupName = credentialPageProp.getProperty("credentialGroupWithNameOnly");
		cro.setCredentialGroupName(credentialGroupName);
		cro.clickSaveButton();
		String actualValidationMsg = cro.getSuccessToasterMsg();
		String expectedValidationMsg = credentialPageProp.getProperty("expectedSuccessValidationMsg");
		Assert.assertTrue(compareTextContains(actualValidationMsg,expectedValidationMsg),
				"Success message not displayed");
		cro.deleteCredentialGroup(credentialGroupName);
		cro.verifyDeleteCredentialGroup(credentialGroupName);
		log.info("verify Add Credential Group With Name Only - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}
	
	/**
	 * Verify Add Credential Group With Name And Description
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(priority = 7)
	public void verifyAddCredentialGroupWithNameAndDescription()
			throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("verify Cancel Add Credential Group With Name And Description - Begin");
		np.navigateToHomePage();
		np.toolsTab();
		np.credentialsSubTab();
		np.credentialsPageVerification();
		cro.isaddCredentialsGroupDisplayed();
		cro.clickAddCredentialGroupButton();
		String credentialGroupNameAndDescription = credentialPageProp.getProperty("credentialGroupNameAndDescription");
		String credentialGroupDescription = credentialPageProp.getProperty("credentialGroupDescription");
		cro.setCredentialGroupName(credentialGroupNameAndDescription);
		cro.setDescription(credentialGroupDescription);
		cro.clickSaveButton();
		String actualValidationMsg = cro.getSuccessToasterMsg();
		String expectedValidationMsg = credentialPageProp.getProperty("expectedSuccessValidationMsg");
		Assert.assertTrue(compareTextContains(actualValidationMsg, expectedValidationMsg),
				"Success message not displayed");
		cro.deleteCredentialGroup(credentialGroupNameAndDescription);
		cro.verifyDeleteCredentialGroup(credentialGroupNameAndDescription);
		log.info("verify Add Credential Group With Name And Description - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}
	
	/**
	 * Blank Credential Group Name Verification
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 */
	@Test(priority = 8)
	public void verifyBlankCredentialGroupNameVerification() throws IOException, InterruptedException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("Verify blank Credential Group Name Verification - Begin");
		np.navigateToHomePage();
		np.toolsTab();
		np.credentialsSubTab();
		np.credentialsPageVerification();
		cro.isaddCredentialsGroupDisplayed();
		cro.clickAddCredentialGroupButton();
		cro.clickSaveButton();
		String actualValidationMsg = cro.getActualNameValidationMsg();
		String expectedValidationMsg = credentialPageProp.getProperty("expectedRequiredNameValidationMsg");
		Assert.assertEquals(actualValidationMsg, expectedValidationMsg,
				"Credential Group name Validation message not displayed");
		cro.clickCancelAddCredentialGroupButton();
		log.info("Verify blank Credential Group Name Verification - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}

	/**
	 * Credential Group Name with space Verification
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 */
	@Test(priority = 9)
	public void verifyCredentialGroupNameWithSpaceVerification()
			throws IOException, InterruptedException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("verify Credential Group Name With Space Verification - Begin");
		np.navigateToHomePage();
		np.toolsTab();
		np.credentialsSubTab();
		np.credentialsPageVerification();
		cro.isaddCredentialsGroupDisplayed();
		cro.clickAddCredentialGroupButton();
		cro.setCredentialGroupName(" ");
		cro.clickSaveButton();
		String actualValidationMsg = cro.getActualNameValidationMsg();
		String expectedValidationMsg = credentialPageProp.getProperty("expectedRequiredNameValidationMsg");
		Assert.assertTrue(compareTextContains(actualValidationMsg, expectedValidationMsg),
				"Credential Group name with space Validation message not displayed");
		cro.clickCancelAddCredentialGroupButton();
		log.info("verify Credential Group Name With Space Verification - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}
	
	/**
	 * Verify Add Credential  With Name, Password And Expiry Date
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(priority = 10)
	public void verifyAddCredentialWithUserNamePasswordAndExpiryDate()
			throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("verify Cancel Add Credential Group With Name And Description - Begin");
		np.navigateToHomePage();
		np.toolsTab();
		np.credentialsSubTab();
		np.credentialsPageVerification();
		cro.isaddCredentialsGroupDisplayed();
		cro.clickAddCredentialGroupButton();
		String credentialGroupNameAndDescription = credentialPageProp.getProperty("credentialGroupToAddCredential");
		String credentialGroupDescription = credentialPageProp.getProperty("credentialGroupDescription");
		cro.setCredentialGroupName(credentialGroupNameAndDescription);
		cro.setDescription(credentialGroupDescription);
		cro.clickSaveButton();
		String actualValidationMsg = cro.getSuccessToasterMsg();
		String expectedValidationMsg = credentialPageProp.getProperty("expectedSuccessValidationMsg");
		Assert.assertTrue(compareTextContains(actualValidationMsg, expectedValidationMsg),
				"Success message not displayed");
		cro.AddCredential(credentialGroupNameAndDescription);
		String credentialName=credentialPageProp.getProperty("credentialName");
		String credentialPassword = credentialPageProp.getProperty("credentialPassword");
		cro.setCredentialName(credentialName);
		cro.setCredentialPassword(credentialPassword);
		cro.enterStartDate(credentialPageProp.getProperty("startDateValue"));
		cro.clickSaveButton();
		String credentialActualValidationMsg = cro.getSuccessToasterMsg();
		String credentialExpectedValidationMsg = credentialPageProp.getProperty("credentialExpectedSuccessValidationMsg");
		Assert.assertTrue(compareTextContains(credentialActualValidationMsg, credentialExpectedValidationMsg),
				"Success message not displayed");
		cro.deleteCredentialGroup(credentialGroupNameAndDescription);
		cro.verifyDeleteCredentialGroup(credentialGroupNameAndDescription);
		log.info("verify Add Credential with Name, Password And Expiry - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}
	
	/**
	 * Verify Add Credential  With Name, Password And Expiry Date
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(priority = 11)
	public void verifyAddCredentialWithUserNamePasswordStatusAndExpiryDate()
			throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("verify Add Credential With Name, Password, Status And Expiry Date - Begin");
		np.navigateToHomePage();
		np.toolsTab();
		np.credentialsSubTab();
		np.credentialsPageVerification();
		cro.isaddCredentialsGroupDisplayed();
		cro.clickAddCredentialGroupButton();
		String credentialGroupNameAndDescription = credentialPageProp.getProperty("credentialGroupToAddCredentialWithStatus");
		String credentialGroupDescription = credentialPageProp.getProperty("credentialGroupDescription");
		cro.setCredentialGroupName(credentialGroupNameAndDescription);
		cro.setDescription(credentialGroupDescription);
		cro.clickSaveButton();
		String actualValidationMsg = cro.getSuccessToasterMsg();
		String expectedValidationMsg = credentialPageProp.getProperty("expectedSuccessValidationMsg");
		Assert.assertTrue(compareTextContains(actualValidationMsg, expectedValidationMsg),
				"Success message not displayed");
		cro.AddCredential(credentialGroupNameAndDescription);
		String credentialName=credentialPageProp.getProperty("credentialNameWithEnabledStatus");
		String credentialPassword = credentialPageProp.getProperty("credentialPassword");
		cro.setCredentialName(credentialName);
		cro.setCredentialPassword(credentialPassword);
		cro.clickEnabled();
		cro.enterStartDate(credentialPageProp.getProperty("startDateValue"));
		cro.clickSaveButton();
		String credentialActualValidationMsg = cro.getSuccessToasterMsg();
		String credentialExpectedValidationMsg = credentialPageProp.getProperty("credentialExpectedSuccessValidationMsg");
		Assert.assertTrue(compareTextContains(credentialActualValidationMsg, credentialExpectedValidationMsg),
				"Success message not displayed");
		cro.deleteCredentialGroup(credentialGroupNameAndDescription);
		cro.verifyDeleteCredentialGroup(credentialGroupNameAndDescription);
		log.info("verify Add Credential with Name, Password, Status And Expiry Date - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}
	
	/**
	 * Verify Delete Credential
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(priority = 12)
	public void verifyDeleteCredential()
			throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("verify Delete Credential - Begin");
		np.navigateToHomePage();
		np.toolsTab();
		np.credentialsSubTab();
		np.credentialsPageVerification();
		cro.isaddCredentialsGroupDisplayed();
		cro.clickAddCredentialGroupButton();
		String credentialGroupNameAndDescription = credentialPageProp.getProperty("credentialGroupToCheckDeleteCredential");
		String credentialGroupDescription = credentialPageProp.getProperty("credentialGroupDescription");
		cro.setCredentialGroupName(credentialGroupNameAndDescription);
		cro.setDescription(credentialGroupDescription);
		cro.clickSaveButton();
		String actualValidationMsg = cro.getSuccessToasterMsg();
		String expectedValidationMsg = credentialPageProp.getProperty("expectedSuccessValidationMsg");
		Assert.assertTrue(compareTextContains(actualValidationMsg, expectedValidationMsg),
				"Success message not displayed");
		cro.AddCredential(credentialGroupNameAndDescription);
		String credentialName=credentialPageProp.getProperty("credentialNameWithDeleteVerification");
		String credentialPassword = credentialPageProp.getProperty("credentialPassword");
		cro.setCredentialName(credentialName);
		cro.setCredentialPassword(credentialPassword);
		cro.clickEnabled();
		cro.enterStartDate(credentialPageProp.getProperty("startDateValue"));
		cro.clickSaveButton();
		String credentialActualValidationMsg = cro.getSuccessToasterMsg();
		String credentialExpectedValidationMsg = credentialPageProp.getProperty("credentialExpectedSuccessValidationMsg");
		Assert.assertTrue(compareTextContains(credentialActualValidationMsg, credentialExpectedValidationMsg),
				"Success message not displayed");
		cro.clickExpandCredentialGroup(credentialGroupNameAndDescription);
		cro.deleteCredential(credentialGroupNameAndDescription,credentialName);
		cro.deleteCredentialGroup(credentialGroupNameAndDescription);
		cro.verifyDeleteCredentialGroup(credentialGroupNameAndDescription);
		log.info("verify Edit Credential - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}
	
	/**
	 * Verify Edit Credential  With Name, Password And Expiry Date
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(priority = 13)
	public void verifyEditCredentialWithNameDescriptionPasswordStatus()
			throws InterruptedException, IOException, AWTException {
		log.info("---------------------------------------------------------------------------------");
		log.info("verify Edit Credential With Name, Password, Status And Expiry Date - Begin");
		np.navigateToHomePage();
		np.toolsTab();
		np.credentialsSubTab();
		np.credentialsPageVerification();
		cro.isaddCredentialsGroupDisplayed();
		cro.clickAddCredentialGroupButton();
		String credentialGroupNameAndDescription = credentialPageProp.getProperty("credentialGroupToCheckEditCredential");
		String credentialGroupDescription = credentialPageProp.getProperty("credentialGroupDescription");
		cro.setCredentialGroupName(credentialGroupNameAndDescription);
		cro.setDescription(credentialGroupDescription);
		cro.clickSaveButton();
		String actualValidationMsg = cro.getSuccessToasterMsg();
		String expectedValidationMsg = credentialPageProp.getProperty("expectedSuccessValidationMsg");
		Assert.assertTrue(compareTextContains(actualValidationMsg, expectedValidationMsg),
				"Success message not displayed");
		cro.AddCredential(credentialGroupNameAndDescription);
		String credentialName=credentialPageProp.getProperty("credentialNameWithEditVerification");
		String credentialPassword = credentialPageProp.getProperty("credentialPassword");
		cro.setCredentialName(credentialName);
		cro.setCredentialPassword(credentialPassword);
		cro.enterStartDate(credentialPageProp.getProperty("startDateValue"));
		cro.clickSaveButton();
		String credentialActualValidationMsg = cro.getSuccessToasterMsg();
		String credentialExpectedValidationMsg = credentialPageProp.getProperty("credentialExpectedSuccessValidationMsg");
		Assert.assertTrue(compareTextContains(credentialActualValidationMsg, credentialExpectedValidationMsg),
				"Success message not displayed");
		cro.clickExpandCredentialGroup(credentialGroupNameAndDescription);
		cro.editCredential(credentialGroupNameAndDescription,credentialName);
		String editCredentialName=credentialPageProp.getProperty("credentialNameEdited");
		String editCredentialPassword = credentialPageProp.getProperty("credentialPasswordEdited");
		cro.setCredentialName(editCredentialName);
		cro.setCredentialPassword(editCredentialPassword);
		cro.clickEnabled();
		cro.clickSaveButton();
		String updateCredentialActualValidationMsg = cro.getSuccessToasterMsg();
		String updatecredentialExpectedValidationMsg = credentialPageProp.getProperty("expectedSuccessCredentialUpdateMsg");
		Assert.assertTrue(compareTextContains(updateCredentialActualValidationMsg, updatecredentialExpectedValidationMsg),
				"Success message not displayed");
		cro.clickExpandCredentialGroup(credentialGroupNameAndDescription);
		cro.deleteCredential(credentialGroupNameAndDescription,editCredentialName);
		cro.deleteCredentialGroup(credentialGroupNameAndDescription);
		cro.verifyDeleteCredentialGroup(credentialGroupNameAndDescription);
		log.info("verify Edit Credential with Name, Password, Status And Expiry Date - End");
		log.info("-----------------------------------------XXX--------------------------------------");
	}
}
