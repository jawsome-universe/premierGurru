package framework.pages.gurruPremier;

import com.google.common.base.Function;
import framework.pages.GurruPageFactory;
import framework.pages.Page;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GurruPremierEditContactPage extends Page {

	/////

	//Click on Title drop-down menu
	@FindBy(xpath = "//span[contains(@class, 'k-dropdown-wrap k-state-default')]")
	private WebElement titleDropdown;

	//Select Title from drop-down list - Mr
	@FindBy(xpath = "//ul[contains(@class, 'k-list k-reset')]//li[contains(@data-offset-index, '0')]")
	private WebElement selectTitle;

	//Find First Name text input field
	@FindBy(xpath = "//div[contains(@class, 'form-group form-group-select')]/input")
	private WebElement firstNameTextField;

	//Find Last Name text input field
	@FindBy(xpath = "//div[contains(@class, 'form-group')]/input[contains(@ng-model, 'contact.lastName')]")
	private WebElement lastNameTextField;

	//Find Mobile text input field
	@FindBy(xpath = "//div[contains(@class, 'form-group')]/input[contains(@ng-model, 'contact.mobilePhone')]")
	private WebElement mobileTextField;

	//Find Email text input field
	@FindBy(xpath = "//div[contains(@class, 'form-group')]/input[contains(@ng-model, 'contact.primaryEmail')]")
	private WebElement emailTextField;

	//Find Position text input field
	@FindBy(xpath = "//div[contains(@class, 'form-group')]/input[contains(@ng-model, 'contact.position')]")
	private WebElement positionTextField;


	/////


	//Click on Save button
	@FindBy(xpath = "//div[contains(@class, 'btn_grup dbim')]/button[3]")
	private WebElement saveButton;

	//Check Confirm message is present
	@FindBy(xpath = "//div[contains(@class, 'growl-item alert ng-scope alert-success icon alert-dismissable')]")
	private WebElement confirmSavePopup;


	public GurruPremierEditContactPage(WebDriver webDriver) {
		super(webDriver);
	}

	@Step("Edit Contact page checking existed values and update one")
	public GurruPremierEditContactPage checkValuesOnContactPage() { //add new page class

		//titleDropdown.click();
		//selectTitle.click();
		//firstNameTextField.sendKeys("Robert"); //option for this should be added
		//lastNameTextField.sendKeys("Plant");  //option for this should be added
		//mobileTextField.sendKeys();//option for this should be added
		//emailTextField.sendKeys();//option for this should be added
		//positionTextField.sendKeys(); //option for this should be added
		saveButton.click();
		getWebDriverWait(5).until(ExpectedConditions.invisibilityOf((WebElement) confirmSavePopup));
		confirmSavePopup.isDisplayed();


		return GurruPageFactory.initElements(webDriver, GurruPremierEditContactPage.class); //add new page class
	}

	@Override
	public Function<WebDriver, ?> isPageLoaded() {
		return wait -> !saveButton.isEnabled();
	}
}
