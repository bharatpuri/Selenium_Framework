package com.autoiq.pages.definitions;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.autoiq.base.TestBase;

/**
 * The Class CreateDefinitionPage.
 */
public class CreateDefinition extends TestBase {
	WebDriver driver = null;
	public List<String> ruleNameListOnLeftPanel;
	public List<String> ruleNameListOnRightPanel;
	public List<String> activityNameList;

	@FindBy(xpath = "//input[@id='definitionName']")
	WebElement processDefinitionName;

	@FindBy(xpath = "(//button[@class='btn btn-default save-draft-btn'])[2]")
	WebElement saveButton;

	@FindBy(xpath = "(//button[@class='btn btn-default save-draft-btn'])[1]")
	WebElement previousButton;

	@FindBy(xpath = "//textarea[@name='definitionDescription']")
	WebElement description;

	@FindBy(xpath = "//span[contains(text(),'Close')]")
	WebElement closeButton;

	@FindBy(xpath = "//button[contains(text(),'Yes')]")
	WebElement yesButton;

	@FindBy(xpath = "(//button[@class='ajs-button ajs-cancel'])")
	WebElement noButton;

	@FindBy(xpath = "(//div[@class='alert-danger small custom-error'])")
	WebElement nameValidationMsg;

	@FindBy(xpath = "//div[@class='toast toast-error']")
	WebElement errorToasterMsg;

	@FindBy(xpath = "//div[@class='toast toast-success']")
	WebElement successToasterMsg;

	@FindBy(xpath = "(//button[@id='#nextBtn'])")
	WebElement nextButton;

	@FindBy(xpath = "(//div[@class='middle-band left-border'])[1]")
	WebElement performActionButton;

	@FindBy(xpath = "(//button[@class='btn btn-primary btn-block btn-sm'])")
	WebElement okButton;

	@FindBy(xpath = "(//button[@class='btn btn-danger custom-button btn-block btn-sm'])")
	WebElement cancelButton;

	@FindBy(xpath = "(//div[@class='cancel-action'])")
	WebElement cancelContainerButton;

	@FindBy(xpath = "(//div[@class='text-center small action-error'])")
	WebElement invalidFromMsg;

	@FindBy(xpath = "(//select[@id='actionDropDown'])")
	WebElement actionDropdown;

	@FindBy(xpath = "(//select[@id='successOption'])")
	WebElement successDropdown;

	@FindBy(xpath = "(//select[@id='errorOption'])")
	WebElement failureDropdown;

	@FindBy(xpath = "(//select[@id='runTaskDropDown'])")
	WebElement taskDropdown;

	@FindBy(xpath = "(//select[@id='performDropdown'])")
	WebElement activityDropdown;

	@FindBy(xpath = "(//select[@id='actionDropDown'])/option")
	List<WebElement> actionDropDownList;

	@FindBy(xpath = "(//div[@class='middle-band left-border'])")
	List<WebElement> addPerformActionList;

	@FindBy(xpath = "(//li/span/span[@class='rule-name'])")
	List<WebElement> ruleListOnLeftPanel;

	@FindBy(xpath = "(//div[@class='actiontype-text text-center'])[1]")
	WebElement actionTextRule1;

	@FindBy(xpath = "(//div[contains(text(),'On Success')]/following-sibling::div)[1]")
	WebElement successTextRule1;

	@FindBy(xpath = "(//div[@class='failure-text text-center'])[1]")
	WebElement failureTextRule1;

	@FindBy(xpath = "(//div[@class='col-xs-12 text-center']/label[contains(text(),'Task')])")
	WebElement taskTextRule1;

	@FindBy(xpath = "(//div[@class='add-time'])")
	WebElement addActivity;

	@FindBy(xpath = "(//div[@class='text-left col-xs-4 activity-name'])")
	List<WebElement> activityList;

	@FindBy(xpath = "(//span[@class='title'])")
	List<WebElement> activityListOnLeftPanel;

	@FindBy(xpath = "(//div[@class='middle-band left-border'])")
	List<WebElement> performActionList;

	@FindBy(xpath = "(//div[@class='actiontype-text text-center'])")
	List<WebElement> actionText;

	@FindBy(xpath = "(//div[@class='middle-band'])")
	List<WebElement> ruleListOnRightPanel;

	@FindAll({ @FindBy(xpath = "(//div[@class='middle-band right-border']/p[contains(text(),'Add New Rule')])") })
	List<WebElement> addNewRuleButton;

	@FindBy(xpath = "(//div[@class='text-center small fieldcondition-error'])")
	WebElement invalidAddRuleFromMsg;

	@FindBy(xpath = "(//select[@id='fieldDropDown'])")
	WebElement fieldDropdown;

	@FindBy(xpath = "(//select[@id='conditional'])")
	WebElement operatorDropdown;

	@FindBy(xpath = "(//input[@id='rightValue'])")
	WebElement valueField;

	@FindAll({ @FindBy(xpath = "(//i[@class='icon-flash mini popover-icon'])") })
	List<WebElement> boltIconList;

	@FindAll({ @FindBy(xpath = "(//span[@class='icon-ellipsis-vert fieldcondition-ellipsis'])") })
	List<WebElement> conditionhamburgerList;

	@FindAll({ @FindBy(xpath = "(//div[@class='icon-ellipsis-vert action-ellipsis'])") })
	List<WebElement> actionhamburgerList;

	@FindAll({ @FindBy(xpath = "(//div[@class='field-text text-center'])") })
	List<WebElement> fieldText;

	@FindAll({ @FindBy(xpath = "(//div[@class='conditional-text text-center'])") })
	List<WebElement> operatorText;

	@FindAll({ @FindBy(xpath = "(//div[@class='value-text text-center'])") })
	List<WebElement> valueText;

	@FindAll({ @FindBy(xpath = "(//div[@class='connector']/span[contains(text(),'And')])") })
	List<WebElement> andButton;

	@FindAll({ @FindBy(xpath = "(//div[@class='connector']/span[contains(text(),'Or')])") })
	List<WebElement> orButton;

	@FindAll({ @FindBy(xpath = "(//div[@class='con-connector'])") })
	List<WebElement> andConnector;

	@FindAll({ @FindBy(xpath = "(//div[@class='con-connector or-condition'])") })
	List<WebElement> orConnector;

	@FindAll({ @FindBy(xpath = "(//div[@class='if-icon-container conditions or-condition'])") })
	List<WebElement> orConnectorInContainer;

	@FindBy(xpath = "(//div[@class='down-connector animate-down'])")
	WebElement downConnector;

	@FindBy(xpath = "(//div[@class='up-connector animateup'])")
	WebElement upConnector;

	@FindBy(xpath = "(//button[@id='#publishBtn'])")
	WebElement publishButton;

	@FindBy(xpath = "(//input[@id='exitTaskDropDown'])")
	WebElement exitReason;

	@FindBy(xpath = "(//input[@id='abortTaskDropDown'])")
	WebElement abortReason;

	@FindBy(xpath = "//div[contains(text(),'Reason')]/following-sibling::div")
	List<WebElement> reasonOnCollapsedView;
////////////////////Need to move into property file
	@FindAll({ @FindBy(xpath = "(//span[@class='group-icon active'])") })
	List<WebElement> containerIcon;

	@FindAll({ @FindBy(xpath = "(//input[@name='conditionSelect'])") })
	List<WebElement> containerCheckBox;

	@FindAll({ @FindBy(xpath = "(//span[@class='done-action'])") })
	List<WebElement> doneButton;

	@FindBy(xpath = "(//ul[@class='dropdown-menu'])")
	WebElement autoOptions;

	@FindAll({ @FindBy(xpath = "(//span/I[@class='icon-flash mini popover-icon'])") })
	List<WebElement> performActionIcon;

	@FindAll({ @FindBy(xpath = "(//div[@class='icon-flash'])") })
	List<WebElement> performActionConnector;

	@FindAll({ @FindBy(xpath = "(//span[@class='action-icon duplicat-icon bolt-icon-blue'])") })
	List<WebElement> actionIconColor;

	@FindAll({ @FindBy(xpath = "(//div[@class='condition-holder'])") })
	List<WebElement> containerBlock;

	@FindAll({ @FindBy(xpath = "(//span[@class='icon-ellipsis-vert container-ellipsis'])") })
	List<WebElement> containerEllipse;

	@FindAll({ @FindBy(xpath = "(//span[@class='delete-icon']/i[@class='close-icon mini popover-icon text-danger'])") })
	List<WebElement> deleteRule;

	@FindAll({ @FindBy(xpath = "(//i[@class='icon-docs-1 popover-icon'])") })
	List<WebElement> duplicateRule;

	@FindBy(xpath = "(//div[@class='action-menu-container'])")
	WebElement actionMenuContainer;

	@FindBy(xpath = "(//span[@class='close-action'])")
	WebElement closeMenuContainer;

	@FindBy(xpath = "(//span[@class='icon-ungroup'])")
	WebElement containerUngroupIcon;

	@FindBy(xpath = "(//div[@class='action-menu-container conditional'])")
	WebElement actionMenuCondition;

	@FindBy(xpath = "(//span[@class='icon-pencil-3'])")
	WebElement editCondition;

	@FindBy(xpath = "(//span[@class='icon-left'])")
	WebElement addLeftCondition;

	@FindBy(xpath = "(//span[@class='icon-right'])")
	WebElement addRightCondition;

	@FindBy(xpath = "(//span[@class='close-action'])")
	WebElement crossIcon;

	@FindBy(xpath = "(//span[@class='icon-trash-4'])")
	WebElement deleteCondition;

	@FindBy(xpath = " (//div[@class='definition-form-backdrop'])")
	WebElement disableDefinitionForm;

	@FindAll({ @FindBy(xpath = "(//div[@class='rules-list-overlay'])") })
	List<WebElement> rulesOverlay;

	@FindBy(xpath = "(//div[@class='side-drawer'])")
	WebElement sideDrawer;

	@FindBy(xpath = "(//div[@class='action-menu-container'])")
	WebElement performActionMenu;

	@FindBy(xpath = "(//div[@class='fieldcondition-container-expanded upFront'])")
	WebElement conditionActiveBox;

	@FindBy(xpath = "(//div[@class='action-container-expanded upFront'])")
	WebElement actionActiveBox;

	@FindBy(xpath = "(//a[@id='a-step-1'])")
	WebElement activeStep1BreadCrumb;

	@FindBy(xpath = "(//a[@id='a-step-2'])")
	WebElement inactiveStep2BreadCrumb;

	@FindBy(xpath = "(//ul/li[@class='current'])")
	WebElement activeRuleOnLeft;

	@FindAll({ @FindBy(xpath = "(//div[@class='inplace-edit-container']/span[@class='display-name'])") })
	List<WebElement> editActivityName;

	@FindBy(xpath = "(//div[@class='middle-band']/autoiq-inplace-edit/div)")
	WebElement editRuleName;

	@FindAll({ @FindBy(xpath = "(//div[@class='delete-icon pull-right'])") })
	List<WebElement> deleteActivity;
	
	@FindBy(xpath = "(//div[@class='col-sm-12 no-padding text-muted warning-info-text'])")
	 WebElement deletePopupText;

	String errorToaster = "(//div[@class='toast toast-error'])";
	String successToaster = "//div[@class='toast toast-success']";

	/**
	 * Instantiates a new Create Process page.
	 * 
	 * @param driver
	 *            the driver
	 */
	public CreateDefinition(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}

	/**
	 * Set Definition Name in textbox
	 * 
	 * @param strUserName
	 */

	public void setDefinitionName(String strDefinitionName) {
		processDefinitionName.clear();
		processDefinitionName.sendKeys(strDefinitionName);
		wait(2);
	}String inputText = processDefinitionName.getAttribute("value");

	/**
	 * returns Definition Name in textbox
	 */

	public String getDefinitionNameText() {
		
		if (inputText.length() == 0) {
			return processDefinitionName.getAttribute("placeholder");
		} else {
			return inputText;
		}
	}

	/**
	 * Set set Definition Name in textbox
	 * 
	 * @param strUserName
	 */

	public void setDescription(String strDescription) {
		description.clear();
		description.sendKeys(strDescription);
		wait(2);
	}

	/**
	 * returns Definition description in textbox
	 */

	public String getDefinitionDescriptionText() {
		String inputText = description.getAttribute("value");
		if (inputText.length() == 0) {
			return description.getAttribute("placeholder");
		} else {
			return inputText;
		}
	}

	/**
	 * enter Definition name
	 */
	public void enterDefinitionName(String name) {
		setDefinitionName(name);
	}

	/**
	 * enter Definition description
	 */
	public void enterDefinitionDescription(String desc) {
		setDescription(desc);
	}

	/**
	 * enter Definition name & description
	 */
	public void enterDefinitionNameAndDescription(String name, String description) {
		setDefinitionName(name);
		setDescription(description);
	}

	/**
	 * clicks next button and Waits Till Page2 Is Opened
	 */
	public void clickNextButtonAndWaitTillPage2IsOpened() throws InterruptedException {
		log.info("Navigate to next page - Begin");
		waitForElementClickable(nextButton, 10);
		clickNextButton();
		waitForElementVisible(publishButton, 5);
		log.info("Navigate to next page - End");
	}

	/**
	 * clicks next button
	 */
	public void clickNextButton() throws InterruptedException {
		log.info("Click on next button - Begin");
		nextButton.click();
		log.info("Click on next button - End");
	}

	/**
	 * checks if overlay is displayed
	 */
	public boolean isOverlayDisplayed(int index) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		try {
			return rulesOverlay.get(index).isDisplayed();
		} finally {
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		}
	}

	/**
	 * get the overlay size
	 */
	public int getOverlaySize() {
		return rulesOverlay.size();
	}

	/**
	 * clicks on rules overlay
	 */
	public void clickRuleOverlay(int index) throws InterruptedException {
		rulesOverlay.get(index).click();
		wait(2);
	}

	/**
	 * drag and select field condition
	 */
	public void mouseDragAndSelectFieldCondition(int dragIndex, int dropIndex) throws InterruptedException {
		WebElement dragElement = conditionhamburgerList.get(dragIndex);
		WebElement dropElement = conditionhamburgerList.get(dropIndex);
		mouseDragAndDrop(dragElement, dropElement);
		wait(1);
	}

	/**
	 * drag and move rule within activity
	 */
	public void dragAndMoveRule(int dragIndex, int dropIndex) throws InterruptedException {
		WebElement dragElement = ruleListOnLeftPanel.get(dragIndex);
		WebElement dropElement = ruleListOnLeftPanel.get(dropIndex);
		wait(1);
		mouseDragAndDrop(dragElement, dropElement);
		wait(1);
	}

	/**
	 * moves To Side Panel
	 */
	public void moveToSidePanel() {
		Actions actions = new Actions(driver);
		actions.moveToElement(sideDrawer);
		actions.click().build().perform();
	}

	/**
	 * get active rule text on left panel
	 */
	public String getActiveRuleOnLeftPanel() {
		return activeRuleOnLeft.getText();
	}

	/**
	 * Verification for error message toaster
	 * 
	 * @throws InterruptedException
	 */
	public void verifyErrorToasterMsg(String expectedErrorMsg) throws InterruptedException {
		String actualErrorMsg = getErrorToasterMsg();
		Assert.assertTrue(compareTextContains(actualErrorMsg, expectedErrorMsg),
				"Expected Error message not displayed");
	}

	/**
	 * Click save button
	 */
	public void clickSave() throws InterruptedException {
		waitForElementClickable(saveButton, 5);
		saveButton.click();
		wait(2);
	}

	/**
	 * Click close button
	 */
	public void clickClose() throws InterruptedException {
		closeButton.click();
		wait(3);
	}

	/**
	 * Click Yes button
	 */
	public void clickYes() throws InterruptedException {
		yesButton.click();
		wait(3);
	}

	/**
	 * Click No button
	 */
	public void clickNo() throws InterruptedException {
		noButton.click();
		wait(3);
	}

	/**
	 * Click Add Activity button
	 */
	public void clickAddActivity() throws InterruptedException {
		addActivity.click();
		wait(1);
	}

	/**
	 * Click Add Activities
	 */
	public void addActivities(int count) throws InterruptedException {
		for (int i = 1; i <= count; i++) {
			clickAddActivity();
		}
		wait(1);
	}

	/**
	 * Click Add left button on condition
	 */
	public void clickAddLeftOnCondition() throws InterruptedException {
		addLeftCondition.click();
		wait(1);
	}

	/**
	 * Click Add left right on condition
	 */
	public void clickAddRightOnCondition() throws InterruptedException {
		addRightCondition.click();
		wait(1);
	}

	/**
	 * gets name validation message
	 */
	public String getActualNameValidationMsg() throws InterruptedException {
		return nameValidationMsg.getText();

	}

	/**
	 * gets error toaster message
	 */
	public String getErrorToasterMsg() throws InterruptedException {
		waitForElementToBePresent(errorToaster, 5);
		waitForElementVisible(errorToasterMsg, 5);
		return errorToasterMsg.getText();

	}

	/**
	 * gets unique name validation message
	 */
	public String getActualUniqueNameValidationMsg() throws InterruptedException {
		return nameValidationMsg.getText();

	}

	/**
	 * gets success toaster message
	 */
	public String getSuccessToasterMsg() throws InterruptedException {
		waitForElementToBePresent(successToaster, 5);
		waitForElementVisible(successToasterMsg, 5);
		return successToasterMsg.getText();

	}

	/**
	 * clicks perform action button
	 */
	public void clickPerformAction() throws InterruptedException {
		waitForElementVisible(performActionButton, 2);
		performActionButton.click();
		wait(3);
	}

	/**
	 * get total rules
	 * 
	 * @throws InterruptedException
	 */
	public int getTotalRuleCount() throws InterruptedException {
		return ruleListOnRightPanel.size();

	}

	/**
	 * get total rules count on left panel
	 * 
	 * @throws InterruptedException
	 */
	public int getTotalRuleCountOnLeftPanel() throws InterruptedException {
		return ruleListOnLeftPanel.size();

	}

	/**
	 * clicks on rule on left panel
	 */
	public void clickOnLeftPanelrule(int location) {
		ruleListOnLeftPanel.get(location).click();
	}

	/**
	 * clicks on rule on right panel
	 */
	public void clickOnRightPanelrule(int location) {
		ruleListOnRightPanel.get(location).click();
	}

	/**
	 * clicks ok button
	 */
	public void clickOk() throws InterruptedException {
		okButton.click();
		wait(3);
	}

	/**
	 * clicks Cancel button
	 */
	public void clickCancel() throws InterruptedException {
		cancelButton.click();
		wait(3);
	}

	/**
	 * clicks Cancel container button
	 */
	public void clickCancelContainer() throws InterruptedException {
		cancelContainerButton.click();
		wait(3);
	}

	/**
	 * clicks on AND button icon
	 */
	public void clickOnAndButton(int location) throws InterruptedException {
		andButton.get(location).click();
		wait(1);
	}

	/**
	 * clicks on delete rule button
	 */
	public void clickOnDeleteRule(int location) throws InterruptedException {
		deleteRule.get(location).click();
		waitForElementVisible(yesButton, 3);
		yesButton.click();
		wait(1);
	}

	/**
	 * clicks on duplicate rule button
	 */
	public void clickOnDuplicateRule(int location) throws InterruptedException {
		duplicateRule.get(location).click();
		wait(2);
	}

	/**
	 * is AND button clickable
	 */
	public boolean isAndButtonClickable(int location) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		try {
			return andButton.size() > 1;
		} finally {
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		}
	}

	/**
	 * clicks on OR button icon
	 */
	public void clickOnOrButton(int location) throws InterruptedException {
		orButton.get(location).click();
		wait(1);
	}

	/**
	 * is OR button clickable
	 */
	public boolean isOrButtonClickable(int location) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		try {
			return orButton.size() > 1;
		} finally {
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		}
	}

	/**
	 * clicks on AND connector
	 */
	public void clickAndConnector(int location) throws InterruptedException {
		andConnector.get(location).click();
		wait(2);
	}

	/**
	 * checks if AND connector clickable
	 */
	public boolean isAndConnectorClickable(int location) throws InterruptedException {
		return andConnector.get(location).isEnabled();
	}

	/**
	 * clicks on OR connector
	 */
	public void clickOrConnector(int location) throws InterruptedException {
		orConnector.get(location).click();
		wait(2);
	}

	/**
	 * checks if OR connector clickable
	 */
	public boolean isOrConnectorClickable() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		try {
			return orConnector.size() > 1;
		} finally {
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		}
	}

	/**
	 * clicks on up connector
	 */
	public void clickUpConnector() throws InterruptedException {
		upConnector.click();
		wait(1);
	}

	/**
	 * clicks on Down connector
	 */
	public void clickDownConnector() throws InterruptedException {
		downConnector.click();
		wait(1);
	}

	/**
	 * clicks on Publish button
	 */
	public void clickPublishButton() throws InterruptedException {
		wait(3);
		publishButton.click();
		wait(2);
	}

	/**
	 * clicks on Container icon
	 */
	public void clickOnContainerButton(int location) throws InterruptedException {
		containerIcon.get(location).click();
		wait(1);
	}

	/**
	 * click On Container Check box With Respect To Index
	 */
	public void clickOnContainerCheckbox(int startValue, int index) {
		for (int i = startValue; i <= index; i++) {
			containerCheckBox.get(i).click();
		}
		wait(1);
	}

	/**
	 * click Done Button With Respect To Index
	 */
	public void clickOnDoneButton(int index) {
		doneButton.get(index).click();
		wait(1);
	}

	/**
	 * gets invalid form message
	 * 
	 */
	public String getInvalidFromMsg() throws InterruptedException {
		return invalidFromMsg.getText();
	}

	/**
	 * click On Container Checkbox individually With Respect To Index
	 */
	public void clickOnContainerCheckboxIndividually(int index) {

		containerCheckBox.get(index).click();
	}

	/**
	 * gets selected value from action dropdown
	 * 
	 */
	public String getSelectedValueFromActionDropDown() throws IOException, InterruptedException, AWTException {
		Select select = new Select(actionDropdown);
		WebElement option = select.getFirstSelectedOption();
		return option.getText();
	}

	/**
	 * gets selected value from Success dropdown
	 * 
	 */
	public String getSelectedValueFromSuccessDropDown() throws IOException, InterruptedException, AWTException {
		Select select = new Select(successDropdown);
		WebElement option = select.getFirstSelectedOption();
		return option.getText();
	}

	/**
	 * gets selected value from Failure dropdown
	 * 
	 */
	public String getSelectedValueFromFailureDropDown() throws IOException, InterruptedException, AWTException {
		Select select = new Select(failureDropdown);
		WebElement option = select.getFirstSelectedOption();
		return option.getText();
	}

	/**
	 * gets selected value from task dropdown
	 * 
	 */
	public String getSelectedValueFromTaskDropDown() throws IOException, InterruptedException, AWTException {
		Select select = new Select(taskDropdown);
		WebElement option = select.getFirstSelectedOption();
		return option.getText();
	}

	/**
	 * gets selected value from Activity dropdown
	 * 
	 */
	public String getSelectedValueFromActivityDropDown() throws IOException, InterruptedException, AWTException {
		Select select = new Select(activityDropdown);
		WebElement option = select.getFirstSelectedOption();
		return option.getText();
	}

	/**
	 * select option from Action Dropdown by text
	 * 
	 */
	public void selectOptionFromActionDropDown(String action) throws IOException, InterruptedException, AWTException {
		Select select = new Select(actionDropdown);
		select.selectByVisibleText(action);
	}

	/**
	 * select option from Success Dropdown by text
	 * 
	 */
	public void selectOptionFromSuccessDropDown(String action) throws IOException, InterruptedException, AWTException {
		Select select = new Select(successDropdown);
		select.selectByVisibleText(action);
	}

	/**
	 * select option from Failue Dropdown by text
	 * 
	 */
	public void selectOptionFromFailureDropDown(String action) throws IOException, InterruptedException, AWTException {
		Select select = new Select(failureDropdown);
		select.selectByVisibleText(action);
	}

	/**
	 * select option from Task Dropdown by text
	 * 
	 */
	public void selectOptionFromTaskDropDown(String action) throws IOException, InterruptedException, AWTException {
		Select select = new Select(taskDropdown);
		select.selectByVisibleText(action);
	}

	/**
	 * select option from task Dropdown by index
	 * 
	 */
	public void selectOptionFromTaskByIndex(int value) throws IOException, InterruptedException, AWTException {
		Select select = new Select(taskDropdown);
		select.selectByIndex(value);
	}

	/**
	 * select option from Activity Dropdown by index
	 * 
	 */
	public void selectOptionFromActivityByIndex(int value) throws IOException, InterruptedException, AWTException {
		Select select = new Select(activityDropdown);
		select.selectByIndex(value);
	}

	/**
	 * gets action text on collasped view
	 * 
	 */
	public String getActionTextOnCollaspedView() throws IOException, InterruptedException, AWTException {
		return actionTextRule1.getText();
	}

	/**
	 * gets On Success Text On Collasped View
	 * 
	 */
	public String getOnSuccessTextOnCollaspedView() throws IOException, InterruptedException, AWTException {
		return successTextRule1.getText();
	}

	/**
	 * gets On Failure Text On Collasped View
	 * 
	 */
	public String getOnFailureTextOnCollaspedView() throws IOException, InterruptedException, AWTException {
		return failureTextRule1.getText();
	}

	/**
	 * gets task Text On Collasped View
	 * 
	 */
	public String getTaskTextOnCollaspedView() throws IOException, InterruptedException, AWTException {
		return taskTextRule1.getText();
	}

	/**
	 * get total activities
	 * 
	 * @throws InterruptedException
	 */
	public int getTotalActivityCount() throws InterruptedException {
		return activityList.size();

	}

	/**
	 * get total activity count on left panel
	 * 
	 * @throws InterruptedException
	 */
	public int getTotalActivityCountOnLeftPanel() throws InterruptedException {
		return activityListOnLeftPanel.size();

	}

	/**
	 * click Perform Action With Respect To Index
	 */
	public void clickPerformActionWithRespectToIndex(int index) {
		performActionList.get(index).click();
		wait(1);
	}

	/**
	 * gets Action Text By Index
	 */
	public String getActionTextByIndex(int index) throws InterruptedException {
		return actionText.get(index).getText();
	}

	/**
	 * gets Action DropDown List Count
	 */
	public int getActionDropDownListCount() throws InterruptedException {
		return (actionDropDownList.size() - 1);
	}

	/**
	 * Click On Add New Rule
	 * 
	 * @throws InterruptedException
	 */
	public void clickAddNewRule(int location) throws InterruptedException {
		addNewRuleButton.get(location).click();
		wait(2);
	}

	/**
	 * Click On Perform Action button
	 * 
	 * @throws InterruptedException
	 */
	public void clickPerformActionByIndex(int location) throws InterruptedException {
		addPerformActionList.get(location).click();
		wait(2);
	}

	/**
	 * gets invalid Add Rule form message
	 * 
	 */
	public String getInvalidAddRuleFormMsg() throws InterruptedException {
		return invalidAddRuleFromMsg.getText();
	}

	/**
	 * selects Option From Field dropdown
	 */
	public void selectOptionFromFieldByIndex(int value) throws IOException, InterruptedException, AWTException {
		Select select = new Select(fieldDropdown);
		select.selectByIndex(value);
	}

	/**
	 * selects Option From Field dropdown
	 */
	public void selectOptionFromFieldByText(String value) throws IOException, InterruptedException, AWTException {
		Select select = new Select(fieldDropdown);
		select.selectByVisibleText(value);
	}

	/**
	 * selects Option From operator dropdown
	 */
	public void selectOptionFromOperatorByIndex(int value) throws IOException, InterruptedException, AWTException {
		Select select = new Select(operatorDropdown);
		select.selectByIndex(value);
	}

	/**
	 * enter custom value to value filed
	 */
	public void enterValue(String value) throws IOException, InterruptedException, AWTException {
		valueField.sendKeys(value);
	}

	/**
	 * verify Default View of condition block
	 */
	public void verifyDefaultView(String expectedFieldValue, String expectedOperatorValue, String expectedValue)
			throws IOException, InterruptedException, AWTException {
		Assert.assertTrue(compareTextContains(getSelectedValueFromFieldDropDown(), expectedFieldValue));
		Assert.assertTrue(compareTextContains(getSelectedValueFromOperatorDropDown(), expectedOperatorValue));
		Assert.assertTrue(compareTextContains(getValueFieldText(), expectedValue));
	}

	/**
	 * gets Selected Value From Field DropDown
	 */
	public String getSelectedValueFromFieldDropDown() throws IOException, InterruptedException, AWTException {
		Select select = new Select(fieldDropdown);
		WebElement option = select.getFirstSelectedOption();
		return option.getText();
	}

	/**
	 * gets Selected Value From Operator DropDown
	 */
	public String getSelectedValueFromOperatorDropDown() throws IOException, InterruptedException, AWTException {
		Select select = new Select(operatorDropdown);
		WebElement option = select.getFirstSelectedOption();
		return option.getText();
	}

	/**
	 * gets Value Field Text
	 */
	public String getValueFieldText() throws IOException, InterruptedException, AWTException {
		String inputText = valueField.getAttribute("value");
		if (inputText.length() == 0) {
			return valueField.getAttribute("placeholder");
		} else {
			return inputText;
		}
	}

	/**
	 * select Option From Dropdown
	 */
	public void selectOptionFromDropdown(int field, int operator, String value)
			throws IOException, InterruptedException, AWTException {
		selectOptionFromFieldByIndex(field);
		selectOptionFromOperatorByIndex(operator);
		enterValue(value);
	}

	/**
	 * verify Collapsed View of condition block
	 */
	public void verifyCollapsedView(String fieldValue, String operatorValue, String value, int collapsedViewCount)
			throws IOException, InterruptedException, AWTException {
		Assert.assertTrue(compareTextContains(getCollapsedViewFieldValue(collapsedViewCount), fieldValue));
		Assert.assertTrue(compareTextContains(getCollapsedViewOperatorValue(collapsedViewCount), operatorValue));
		Assert.assertTrue(compareTextContains(getCollapsedViewValue(collapsedViewCount), value));
	}

	/**
	 * verify Collapsed View of condition block contains data
	 */
	public void verifyCollapsedViewContainsData(int collapsedViewCount)
			throws IOException, InterruptedException, AWTException {
		Assert.assertTrue(getCollapsedViewFieldValue(collapsedViewCount).length() > 0);
		Assert.assertTrue(getCollapsedViewOperatorValue(collapsedViewCount).length() > 0);
		Assert.assertTrue(getCollapsedViewValue(collapsedViewCount).length() > 0);
	}

	/**
	 * Add condition and verify collapsed view
	 * 
	 * @throws AWTException
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void addConditionAndVerifyCollapsedView(int fieldInput, int operatorInput, String valueInput)
			throws IOException, InterruptedException, AWTException {
		selectOptionFromDropdown(fieldInput, operatorInput, valueInput);
		String fieldValue = getSelectedValueFromFieldDropDown();
		String operatorValue = getSelectedValueFromOperatorDropDown().trim();
		String value = getValueFieldText();
		clickOk();
		int collapsedViewCount = getCollapsedViewCountOfConditionBlock();
		verifyCollapsedView(fieldValue, operatorValue, value, collapsedViewCount - 1);
	}

	/**
	 * add condition
	 */
	public String addCondition(int location) {
		return fieldText.get(location).getText();
	}

	/**
	 * gets Collapsed View Field Value
	 */
	public String getCollapsedViewFieldValue(int location) {
		return fieldText.get(location).getText();
	}

	/**
	 * gets Collapsed View Operator Value
	 */
	public String getCollapsedViewOperatorValue(int location) throws InterruptedException {
		return operatorText.get(location).getText();
	}

	/**
	 * gets Collapsed View Value
	 */
	public String getCollapsedViewValue(int location) throws InterruptedException {
		return valueText.get(location).getText();

	}

	/**
	 * gets Collapsed View index
	 */
	public int getCollapsedViewCountOfConditionBlock() {
		return conditionhamburgerList.size();
	}

	/**
	 * gets Collapsed View index
	 */
	public int getCollapsedViewCountOfActionBlock() {
		return actionhamburgerList.size();
	}

	/**
	 * clicks on bolt icon
	 */
	public void clickBoltIcon(int index) {
		boltIconList.get(index).click();
	}

	/**
	 * Verification for And Connector
	 * 
	 * @throws InterruptedException
	 */
	public void verifyAndConnector(int location) throws InterruptedException {
		String expectedAndConnector = createDefinitionPageProp.getProperty("andConnector");
		String actualAndConnector = getAndConnectorText(location);
		Assert.assertTrue(actualAndConnector.equalsIgnoreCase(expectedAndConnector), "And Connector not displayed");
	}

	/**
	 * Verification for OR Connector
	 * 
	 * @throws InterruptedException
	 */
	public void verifyOrConnector(int location) throws InterruptedException {
		String expectedOrConnector = createDefinitionPageProp.getProperty("orConnector");
		String actualOrConnector = getOrConnectorText(location);
		Assert.assertTrue(actualOrConnector.equalsIgnoreCase(expectedOrConnector), "And Connector not displayed");
	}

	/**
	 * Verification for OR Connector inside container
	 * 
	 * @throws InterruptedException
	 */
	public void verifyOrConnectorInsideContainer(int location) throws InterruptedException {
		String expectedOrConnector = createDefinitionPageProp.getProperty("orConnector");
		String actualOrConnector = getOrConnectorTextInsideContainer(location);
		Assert.assertTrue(actualOrConnector.equalsIgnoreCase(expectedOrConnector), "And Connector not displayed");
	}

	/**
	 * get Or Connector text
	 * 
	 * @throws InterruptedException
	 */

	public String getOrConnectorText(int location) throws InterruptedException {
		return orConnector.get(location).getText();
	}

	/**
	 * get Or Connector text inside container
	 * 
	 * @throws InterruptedException
	 */

	public String getOrConnectorTextInsideContainer(int location) throws InterruptedException {
		return orConnectorInContainer.get(location).getText();
	}

	/**
	 * get And Connector message
	 * 
	 * @throws InterruptedException
	 */

	public String getAndConnectorText(int location) throws InterruptedException {
		return andConnector.get(location).getText();
	}

	/**
	 * Get Definition Activity Index
	 */
	public int getActivityIndex() throws IOException, InterruptedException {
		return activityList.size();
	}

	/**
	 * enter exit reason
	 */
	public void enterExitReason(String reason) {
		exitReason.sendKeys(reason);
		;
	}

	/**
	 * get exit reason text
	 */
	public String getExitReasonText() throws InterruptedException {
		return exitReason.getAttribute("value");
	}

	/**
	 * get abort reason text
	 */
	public String getAbortReasonText() throws InterruptedException {
		return abortReason.getAttribute("value");
	}

	/**
	 * get reason text on collapsed view
	 */
	public String getReasonTextOnCollapsedView(int location) throws InterruptedException {
		return reasonOnCollapsedView.get(location).getText();
	}

	/**
	 * selects option from text in type ahead
	 */
	public void selectOptionWithTextInTypeAhead(String textToSelect) throws InterruptedException {
		selectOptionWithText(autoOptions, textToSelect);
	}

	/**
	 * gets List Of Options With Text In TypeAhead
	 */
	public int getsListOfOptionWithTextInTypeAhead(String value) throws InterruptedException {
		List<WebElement> options = autoOptions.findElements(By.tagName("li"));
		log.info(options.size());
		int count = 0;
		for (WebElement option : options) {
			if (value.equals(option.getText())) {
				count++;
			}
		}
		return count;
	}

	/**
	 * enter abort reason
	 */
	public void enterAbortReason(String reason) {
		abortReason.sendKeys(reason);
		;
	}

	/**
	 * clicks on perform action icon
	 */
	public void clickOnPerformActionIcon(int location) throws InterruptedException {
		performActionIcon.get(location).click();
		wait(1);
	}

	/**
	 * clicks on perform action Get Added
	 */
	public void verifyPerformActionGetAddedBlueBoltIndicator(int location) throws InterruptedException {
		log.info("Verify Perform Action Get Added- Begin");
		Assert.assertTrue(actionIconColor.get(location).isDisplayed());
		wait(1);
		log.info("Verify Perform Action Get Added- End");
	}

	/**
	 * Verify Perform Action Connector Displayed
	 */
	public void verifyPerformActionConnector(int location) throws InterruptedException {
		log.info("Verify Perform Action Connector Displayed- Begin");
		Assert.assertTrue(performActionConnector.get(location).isDisplayed());
		wait(2);
		log.info("Verify Perform Action Connector Displayed- End");
	}

	/**
	 * perform Action As Exit
	 * 
	 * @throws AWTException
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void performActionAsExit(int location, int reasonIndex)
			throws IOException, InterruptedException, AWTException {
		String exitAction = createDefinitionPageProp.getProperty("actionExit");
		String exitReason = createDefinitionPageProp.getProperty("reason");
		addExitAction(exitAction, exitReason);
		Assert.assertTrue(compareTextContains(getActionTextByIndex(location), exitAction));
		Assert.assertTrue(compareTextContains(getReasonTextOnCollapsedView(reasonIndex), exitReason));

	}

	/**
	 * Add Exit Action
	 * 
	 * @throws AWTException
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void addExitAction(String exitAction, String exitReason)
			throws IOException, InterruptedException, AWTException {
		selectOptionFromActionDropDown(exitAction);
		enterExitReason(exitReason);
		clickOk();
	}

	/**
	 * perform Action As Abort
	 * 
	 * @throws AWTException
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void performActionAsAbort(int location, int reasonIndex)
			throws IOException, InterruptedException, AWTException {
		String abortAction = createDefinitionPageProp.getProperty("actionAbort");
		String abortReason = createDefinitionPageProp.getProperty("reason");
		addAbortAction(abortAction, abortReason);
		Assert.assertTrue(compareTextContains(getActionTextByIndex(location), abortAction));
		Assert.assertTrue(compareTextContains(getReasonTextOnCollapsedView(reasonIndex), abortReason));
	}

	/**
	 * Add Abort Action
	 * 
	 * @throws AWTException
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void addAbortAction(String abortAction, String abortReason)
			throws IOException, InterruptedException, AWTException {
		selectOptionFromActionDropDown(abortAction);
		enterAbortReason(abortReason);
		clickOk();
	}

	/**
	 * perform Action As Process
	 * 
	 * @throws AWTException
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void performActionAsProcess(int location) throws IOException, InterruptedException, AWTException {
		String processAction = createDefinitionPageProp.getProperty("actionProcess");
		selectOptionFromActionDropDown(processAction);
		String expectedTaskValue = createDefinitionPageProp.getProperty("defaultActivityDropdownValue");
		Assert.assertTrue(compareTextContains(getSelectedValueFromActivityDropDown(), expectedTaskValue));
		selectOptionFromActivityByIndex(1);
		String activityValueSelected1 = (getSelectedValueFromActivityDropDown()).trim();
		clickOk();
		Assert.assertTrue(compareTextContains(getActionTextByIndex(location), processAction));
		Assert.assertTrue(compareTextContains(getActionTextByIndex(location), activityValueSelected1));
	}

	/**
	 * perform Action As Run
	 * 
	 * @throws AWTException
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void performActionAsRun(int location) throws IOException, InterruptedException, AWTException {
		String runAction = createDefinitionPageProp.getProperty("actionRun");
		selectOptionFromActionDropDown(runAction);
		selectOptionFromTaskByIndex(1);
		String taskValueSelected = (getSelectedValueFromTaskDropDown()).trim();
		String onSuccessExit = createDefinitionPageProp.getProperty("onSuccessExit");
		selectOptionFromSuccessDropDown(onSuccessExit);
		String onFailureExit = createDefinitionPageProp.getProperty("onFailureExit");
		selectOptionFromFailureDropDown(onFailureExit);
		clickOk();
		Assert.assertTrue(compareTextContains(getActionTextByIndex(location), runAction));
		Assert.assertTrue(compareTextContains(getActionTextByIndex(location), taskValueSelected));
		Assert.assertTrue(compareTextContains(getOnSuccessTextOnCollaspedView(), onSuccessExit));
		Assert.assertTrue(compareTextContains(getOnFailureTextOnCollaspedView(), onFailureExit));
	}

	/**
	 * perform Action As Perform
	 * 
	 * @throws AWTException
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void performActionAsPerform(int location) throws IOException, InterruptedException, AWTException {
		String performAction = createDefinitionPageProp.getProperty("actionPerform");
		selectOptionFromActionDropDown(performAction);
		selectOptionFromActivityByIndex(1);
		String activityValueSelected = (getSelectedValueFromActivityDropDown()).trim();
		clickOk();
		Assert.assertTrue(compareTextContains(getActionTextByIndex(location), performAction));
		Assert.assertTrue(compareTextContains(getActionTextByIndex(location), activityValueSelected));
	}

	/**
	 * verify Toaster Message After Save Draft
	 * 
	 * @throws InterruptedException
	 */
	public void verifyToasterMsgAfterSaveDraft() throws InterruptedException {
		String actualValidationMsg = getSuccessToasterMsg();
		String expectedValidationMsg = createDefinitionPageProp.getProperty("expectedSuccessValidationMsg");
		Assert.assertTrue(compareTextContains(actualValidationMsg, expectedValidationMsg),
				"Success message after Save Draft is not displayed");
	}

	/**
	 * verify Updated Toaster Message After Save Draft
	 * 
	 * @throws InterruptedException
	 */
	public void verifyUpdatedToasterMsgAfterSaveDraft() throws InterruptedException {
		String actualValidationMsg = getSuccessToasterMsg();
		String expectedValidationMsg = createDefinitionPageProp.getProperty("expectedUpdateToasterMsg");
		Assert.assertTrue(compareTextContains(actualValidationMsg, expectedValidationMsg),
				"Updated toaster message after Save Draft is not displayed");
	}

	/**
	 * verify Toaster Message After Save Draft
	 * 
	 * @throws InterruptedException
	 */
	public void verifyToasterMsgSaveDraftForProcessUpdate() throws InterruptedException {
		String actualValidationMsg = getSuccessToasterMsg();
		String expectedValidationMsg = createDefinitionPageProp.getProperty("expectedProcessDefinitionUpadateMsg");
		Assert.assertTrue(compareTextContains(actualValidationMsg, expectedValidationMsg),
				"Success message not displayed");
	}

	/**
	 * Verification Container Added For Condition
	 * 
	 * @throws InterruptedException
	 */
	public boolean isContainerAddedForCondition(int location) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		try {
			return containerBlock.get(location).isDisplayed();
		} finally {
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		}
	}

	/**
	 * checks if ungroup icon is displayed
	 */
	public boolean isUngroupContainerIconDisplayed() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		try {
			return driver.findElements(By.xpath("(//span[@class='icon-ungroup'])")).size() > 1;
		} finally {
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		}
	}

	/**
	 * clicks on container ellipse
	 */
	public void clickOnContainerEllipse(int location) throws InterruptedException {
		Assert.assertTrue(containerEllipse.get(location).isEnabled());
		containerEllipse.get(location).click();
		wait(2);
	}

	/**
	 * Verification Action Menu Container
	 * 
	 * @throws InterruptedException
	 */
	public void verifyActionMenuContainer() throws InterruptedException {
		log.info("Verification Action Menu Container  - Begin ");
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		try {
			Assert.assertTrue(actionMenuContainer.isDisplayed());
			Assert.assertTrue(closeMenuContainer.isDisplayed());
			Assert.assertTrue(containerUngroupIcon.isDisplayed());
		} finally {
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		}
		log.info("Verification Action Menu Container  - End ");
	}

	/**
	 * Verifies if all the elements are disabled while creating editing
	 * condition / Action block
	 * 
	 * @throws InterruptedException
	 */
	public void verifyDisablingOnCreateEditConditionAction() throws InterruptedException {
		log.info("Verify if all the elements are disabled while creating editing condition / Action block  - Begin ");
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		try {
			Assert.assertTrue(disableDefinitionForm.isDisplayed(),
					"Definition form should be disabled on Edit/Create Action/Condition");
		} finally {
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		}
		log.info("Verify if all the elements are disabled while creating editing condition / Action block  - End ");
	}

	/**
	 * clicks on container ellipse
	 */
	public void clickOnUngroupContainerIcon() throws InterruptedException {
		Assert.assertTrue(containerUngroupIcon.isEnabled());
		containerUngroupIcon.click();
		wait(2);
	}

	/**
	 * gets right panel rule text
	 */
	public String getRightPanelRuleText(int location) throws InterruptedException {
		return ruleListOnRightPanel.get(location).getText();
	}

	/**
	 * checks if Save Draft Button Enabled
	 * 
	 * @throws InterruptedException
	 */
	public boolean isSaveDraftButtonEnabled() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		try {
			return saveButton.isEnabled();
		} finally {
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		}
	}

	/**
	 * checks if Publish Button Enabled
	 * 
	 * @throws InterruptedException
	 */
	public boolean isPublishButtonEnabled() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		try {
			return publishButton.isEnabled();
		} finally {
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		}
	}

	/**
	 * Verification Action Menu Condition
	 * 
	 * @throws InterruptedException
	 */
	public void verifyActionMenuCondition() throws InterruptedException {
		log.info("Verification Action Menu Condition  - Begin ");
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		try {
			Assert.assertTrue(isElementDisplayed(actionMenuCondition), "Action Menu Condition Block Not Displayed");
			Assert.assertTrue(isElementEnabled(addLeftCondition), "Action Menu Add Left Condition Not Displayed");
			Assert.assertTrue(isElementEnabled(addRightCondition), "Action Menu Add Right Condition Not Displayed");
			Assert.assertTrue(isElementEnabled(editCondition), "Action Menu Edit Condition Not Displayed");
			Assert.assertTrue(isElementEnabled(deleteCondition), "Action Menu Delete Condition Not Displayed");
			Assert.assertTrue(isElementEnabled(crossIcon), "Cross Icon Not Displayed");
		} finally {
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		}

		log.info("Verification Action Menu Condition  - End ");
	}

	/**
	 * clicks on edit condition
	 */
	public void clickOnEditConditionIcon() throws InterruptedException {
		editCondition.click();
		wait(2);
	}

	/**
	 * deletes the condition
	 */
	public void deleteCondition() throws InterruptedException {
		deleteCondition.click();
		wait(1);
		yesButton.click();
		wait(2);
	}

	/**
	 * clicks condition ellipse with respect to index
	 */
	public void clickAndVerifyConditionEllipsesIcon(int location) {
		Assert.assertTrue(conditionhamburgerList.get(location).isEnabled());
		conditionhamburgerList.get(location).click();
		wait(2);
	}

	/**
	 * gets list of rules on left panel
	 * 
	 * @return
	 */
	public List<String> getRuleListOnLeftPanel() {
		ruleNameListOnLeftPanel = new ArrayList<String>();
		for (WebElement rule : ruleListOnLeftPanel) {
			ruleNameListOnLeftPanel.add(rule.getText());
		}
		return ruleNameListOnLeftPanel;
	}

	/**
	 * gets list of rules on right panel
	 * 
	 * @return
	 */
	public List<String> getRuleListOnRightPanel() {
		ruleNameListOnRightPanel = new ArrayList<String>();
		for (WebElement rule : ruleListOnRightPanel) {
			ruleNameListOnRightPanel.add(rule.getText());
		}
		return ruleNameListOnRightPanel;
	}

	/**
	 * Click on action hamburger
	 */
	public void clickAndVerifyHambugerActionBlock(int index) {
		Assert.assertTrue(actionhamburgerList.get(index).isEnabled());
		actionhamburgerList.get(index).click();
	}

	/**
	 * Verification Perform Action Menu
	 * 
	 * @throws InterruptedException
	 */
	public void verifyPerformActionMenu() throws InterruptedException {
		log.info("Verification Perform Action Menu - Begin ");
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		try {
			Assert.assertTrue(isElementDisplayed(performActionMenu),
					"Perform Action Menu Condition Block Not Displayed");
			Assert.assertTrue(isElementEnabled(addLeftCondition),
					"Perform Action Menu Add Left Condition Not Displayed");
			Assert.assertTrue(isElementEnabled(editCondition), "Perform Action Menu Edit Condition Not Displayed");
			Assert.assertTrue(isElementEnabled(deleteCondition), "Action Menu Delete Condition Not Displayed");
			wait(2);
			Assert.assertTrue(isElementEnabled(crossIcon), "Cross Icon Not Displayed");
		} finally {
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		}
		log.info("Verification Perform Action Menu - End ");
	}

	/**
	 * verify Auto Scroll to Active box For Condition
	 */
	public void verifyAutoScrolltoActiveboxForCondition() {
		log.info("verify Auto Scroll to Active box For Condition - Begin");
		Assert.assertTrue(conditionActiveBox.isDisplayed(), "Active box For Container is Not Displayed");
		log.info("verify Auto Scroll to Active box For Condition - End");
	}

	/**
	 * clicks on add Left Condition Icon From Perform Action Menu
	 */
	public void clickOnaddLeftConditionIconFromPerformActionMenu() throws InterruptedException {
		addLeftCondition.click();
		wait(2);
	}

	/**
	 * verify Auto Scroll to Active box For Action
	 */
	public void verifyAutoScrolltoActiveboxForAction() {
		log.info("verify Auto Scroll to Active box For Action- Begin");
		Assert.assertTrue(actionActiveBox.isDisplayed(), "Active box For Action is Not Displayed");
		log.info("verify Auto Scroll to Active box For Action- End");
	}

	/**
	 * Verification Active Bread Crumb on Process Definition Wizard Page 1
	 * 
	 * @throws InterruptedException
	 */
	public void verifyActiveToasterOnDefinitionWizardPageOne() throws InterruptedException {
		log.info("verify Active Toaster On Definition Wizard Page One - Begin");
		Assert.assertEquals(activeStep1BreadCrumb.isDisplayed(), true);
		Assert.assertEquals(activeStep1BreadCrumb.isEnabled(), true);
		Assert.assertEquals(inactiveStep2BreadCrumb.isDisplayed(), true);
		Assert.assertEquals(inactiveStep2BreadCrumb.isSelected(), false);
		log.info("verify Active Toaster On Definition Wizard Page One - End");
	}

	/**
	 * Verification Active Bread Crumb on Process Definition Wizard Page 2
	 * 
	 * @throws InterruptedException
	 */
	public void verifyActiveToasterOnDefinitionWizardPageTwo() throws InterruptedException {
		log.info("verify Active Toaster On Definition Wizard Page Two - Begin");
		Assert.assertEquals(activeStep1BreadCrumb.isDisplayed(), true);
		Assert.assertEquals(activeStep1BreadCrumb.isEnabled(), true);
		Assert.assertEquals(activeStep1BreadCrumb.isSelected(), false);
		Assert.assertEquals(inactiveStep2BreadCrumb.isDisplayed(), true);
		log.info("verify Active Toaster On Definition Wizard Page Two - End");
	}

	/**
	 * Verification of rename activity
	 * 
	 * @throws InterruptedException
	 */
	public void verifyAndRenameActivity(int index, String activityName) throws InterruptedException {
		Actions actions = new Actions(driver);
		Assert.assertTrue(editActivityName.get(index).isEnabled());
		actions.moveToElement(editActivityName.get(index)).click().perform();
		actions.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		actions.sendKeys(Keys.DELETE);
		actions.sendKeys(activityName).build().perform();
		clickSave();
	}

	/**
	 * Verification of rename activity
	 * 
	 * @throws InterruptedException
	 */
	public void verifyAndRenameRule(String ruleName) throws InterruptedException {
		Actions actions = new Actions(driver);
		Assert.assertTrue(editRuleName.isEnabled());
		actions.moveToElement(editRuleName).click().perform();
		actions.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		actions.sendKeys(Keys.DELETE);
		actions.sendKeys(ruleName).build().perform();
		clickSave();
	}

	/**
	 * verify Activity Name
	 */
	public void verifyActivityName(String expectedActivityName, int index) throws InterruptedException {
		String actualActivityName = getActivityName(index);
		Assert.assertTrue(compareTextContains(actualActivityName, expectedActivityName),
				"Activity name is not displayed");
	}

	/**
	 * verify Rule Name
	 */
	public void verifyRuleName(String expectedRuleName, int index) throws InterruptedException {
		String actualRuleName = getRuleName(index);
		Assert.assertTrue(compareTextContains(actualRuleName, expectedRuleName), "Rule name is not displayed");
	}

	/**
	 * gets activity name
	 */
	public String getActivityName(int index) throws InterruptedException {
		return activityList.get(index).getText();
	}

	/**
	 * gets rule name
	 */
	public String getRuleName(int index) throws InterruptedException {
		return ruleListOnRightPanel.get(index).getText();
	}

	/**
	 * Verify and clicks on delete activity
	 */
	public void verifyAndClickOnDeleteActivity(int location) throws InterruptedException {
		Assert.assertTrue(deleteActivity.get(location).isEnabled());
		waitForElementVisible(deleteActivity.get(location), 5);
		deleteActivity.get(location).click();
		waitForElementVisible(yesButton, 3);
		String expectedDeleteText = createDefinitionPageProp.getProperty("expectedDeleteText");
		String actualDeleteText = getDeletePopupText();
		Assert.assertTrue(compareTextContains(actualDeleteText, expectedDeleteText));
		yesButton.click();
		wait(2);
	}

	/**
	 * gets list of activity
	 * 
	 * @return
	 */
	public List<String> getListOfActivityName() {
		activityNameList = new ArrayList<String>();
		for (WebElement rule : activityList) {
			activityNameList.add(rule.getText());
		}
		return activityNameList;
	}
	
	 /**
	  * get delete popup text
	  */
	 public String getDeletePopupText() {
	  return deletePopupText.getText();
	 }
}
