package framework.pages.gurruPremierIntro;

import com.google.common.base.Function;
import framework.pages.GurruPageFactory;
import framework.pages.Page;
import framework.pages.gurruPremier.GurruPremierContactsPageAfterContactCreation;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GurruPremierCreateUserPage extends Page {

	//Click on Email text input field
	@FindBy(xpath = "//div[contains(@class, 'form-group')]/input[contains(@ng-model, 'user.email')]")
	private WebElement emailTestField;

	//Click on Username text input field
	@FindBy(xpath = "//div[contains(@class, 'form-group')]/input[contains(@ng-model, 'user.userName')]")
	private WebElement usernameTextField;

	//Click on First Name text input field
	@FindBy(xpath = "//div[contains(@class, 'form-group')]/input[contains(@ng-model, 'user.firstName')]")
	private WebElement firstNameTextField;

	//Click on Last Name text input field
	@FindBy(xpath = "//div[contains(@class, 'form-group')]/input[contains(@ng-model, 'user.lastName')]")
	private WebElement lastNameTextField;

	//Click on Phone Number text input field
	@FindBy(xpath = "//div[contains(@class, 'form-group')]/input[contains(@ng-model, 'user.phoneNumber')]")
	private WebElement phoneNumberTextField;

	//Click on Position text input field
	@FindBy(xpath = "//div[contains(@class, 'form-group')]/input[contains(@ng-model, 'user.position')]")
	private WebElement positionTextField;

	//Click on Role drop-down menu
	@FindBy(xpath = "//span[contains(@aria-activedescendant, 'ac53e975-4a39-4169-bee2-5bda79379b10')]/*[1]")
	private WebElement openRoleDropdown;

	//Select Role from drop-down list - Sales
	@FindBy(xpath = "//span[contains(@aria-activedescendant, 'ac53e975-4a39-4169-bee2-5bda79379b10')]//option[contains(@value, 'fa13ba5f-fd45-4a6d-a859-4f95649b9ed5')]")
	private WebElement selectRole;

	//Click on Supervisor drop-down menu
	@FindBy(xpath = "//span[contains(@class, 'k-widget k-dropdown k-header form-control ng-valid ng-valid-required ng-not-modified ng-pristine k-invalid ng-touched')]/*[1]")
	private WebElement openSupervisorDropdown;

	//Select Supervisor from drop-down list - Sales
	@FindBy(xpath = "//span[contains(@class, 'k-widget k-dropdown k-header form-control ng-valid ng-valid-required ng-not-modified ng-pristine k-invalid ng-touched')]//option[1]")
	private WebElement selectSupervisor;

	//Click on Password text input field
	@FindBy(xpath = "//div[contains(@class, 'form-group')]/input[contains(@ng-model, 'user.password')][1]")
	private WebElement passwordTextField;

	//Click on Confirm Password text input field
	@FindBy(xpath = "/html//div[2]/form/div[1]//fieldset/div[12]/input")
	private WebElement confirmPasswordTextField;

	@FindBy(xpath = "//button[contains(@class, 'btn bg_gradient_blue btn_like btn_update')][2]")
	private WebElement createButton;


	public GurruPremierCreateUserPage(WebDriver webDriver) {
		super(webDriver);
	}

	@Step("Create User")
	public GurruPremierContactsPageAfterContactCreation loginToGurruPremier(String login, String password) { //add new page class
		emailTestField.sendKeys("test567@test55.com"); //option for this should be added
		usernameTextField.sendKeys("AutomationSales"); //option for this should be added
		firstNameTextField.sendKeys("Automation"); //option for this should be added
		lastNameTextField.sendKeys("Sales Test");  //option for this should be added
		phoneNumberTextField.sendKeys("0123456789");
		positionTextField.sendKeys("Sales person");
		openRoleDropdown.click();
		selectRole.click();
		openSupervisorDropdown.click();
		selectSupervisor.click();
		passwordTextField.sendKeys("123456");
		confirmPasswordTextField.sendKeys("123456");
		createButton.click();

		return GurruPageFactory.initElements(webDriver, GurruPremierContactsPageAfterContactCreation.class); //add new page class
	}

	@Override
	public Function<WebDriver, ?> isPageLoaded() {
		return wait -> !openSupervisorDropdown.isEnabled();
	}
}
