package framework.gurruPremierIntroTest.createUserAndLogin;

import framework.gurruPremierIntroTest.testbase.TestBaseGurruPremierIntro;
import framework.pages.gurruPremierIntro.GurruPremierEditUserPage;
import framework.pages.gurruPremierIntro.GurruPremierUsersPage;
import framework.utility.PropertyLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GurruPremierSimpleIntroTest extends TestBaseGurruPremierIntro {


	@Test
	public void createNewUserTest() {
		webDriver.get(PropertyLoader.loadProperty("testsite7.url"));
		WebDriverWait wdWait0 = new WebDriverWait(webDriver, 5);
		wdWait0.until(ExpectedConditions.visibilityOf(webDriver.findElement(By.xpath("//*[@id=\"login-username\"]"))));

		//Gurru Logo
		WebElement gurruLogoImaged = webDriver.findElement(By.xpath("//*[@id=\"login_form\"]/div[1]/img"));
		gurruLogoImaged.isDisplayed();

		//Fill Username field
		WebElement userNameTextField = webDriver.findElement(By.xpath("//*[@id=\"login-username\"]"));
		userNameTextField.sendKeys("wtAdmin");

		//Fill Password field
		WebElement passwordTextField = webDriver.findElement(By.xpath("//*[@id=\"login-password\"]"));
		passwordTextField.sendKeys("Aa123456!");

		//Login button click
		WebElement loginButton = webDriver.findElement(By.xpath("//*[@id=\"loginBtn\"]"));
		loginButton.click();
		//wait until page is loading after login
		wdWait0.until(ExpectedConditions.visibilityOf(webDriver.findElement(By.xpath("//li[contains(@ng-class, 'UserAdministration')]//span"))));

		//Verify that Admin is logged in
		String checkAdminName = webDriver.findElement(By.xpath(".//*[@id='dLabel']")).getText();
		Assert.assertTrue(checkAdminName.contains("Admin")); ////////////////////

		////////////

		//Click on Users tab
		WebElement usersTab = webDriver.findElement(By.xpath("//li[contains(@ng-class, 'UserAdministration')]//a[contains(@ui-sref , 'users')]"));
		usersTab.click();
		wdWait0.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("//*[contains(text(), 'Create User')]"))));

		//Click on Create User button
		WebElement createUserButton = webDriver.findElement(By.xpath("//*[contains(text(), 'Create User')]"));
		createUserButton.click();
		//wait until Create user page is load
		wdWait0.until(ExpectedConditions.visibilityOf(webDriver.findElement(By.xpath("//span[contains(@class, 'k-widget k-dropdown k-header form-control ng-valid ng-valid-required ng-not-modified ng-pristine k-invalid ng-touched')]/*[1]"))));

		////////////// Fill Create user fields

		//Email text input field
		WebElement emailTextField = webDriver.findElement(By.xpath("//div[contains(@class, 'form-group')]/input[contains(@ng-model, 'user.email')]"));
		emailTextField.sendKeys("test567@test55.com");

		//Username text input field
		WebElement usernameTextField = webDriver.findElement(By.xpath("//div[contains(@class, 'form-group')]/input[contains(@ng-model, 'user.userName')]"));
		usernameTextField.sendKeys("AutomationSales");

		//First Name text input field
		WebElement firstNameTextField = webDriver.findElement(By.xpath("//div[contains(@class, 'form-group')]/input[contains(@ng-model, 'user.firstName')]"));
		firstNameTextField.sendKeys("Automation");

		//Last Name text input field
		WebElement lastNameTextField = webDriver.findElement(By.xpath("//div[contains(@class, 'form-group')]/input[contains(@ng-model, 'user.lastName')]"));
		lastNameTextField.sendKeys("Test");

		//Phone Number text input field
		WebElement phoneNumberTextField = webDriver.findElement(By.xpath("//div[contains(@class, 'form-group')]/input[contains(@ng-model, 'user.phoneNumber')]"));
		phoneNumberTextField.sendKeys("0123456789");

		//Position text input field
		WebElement positionTextField = webDriver.findElement(By.xpath("//div[contains(@class, 'form-group')]/input[contains(@ng-model, 'user.position')]"));
		positionTextField.sendKeys("Sales person");

		//Click on Role drop-down menu
		WebElement openRoleDropdown = webDriver.findElement(By.xpath("//span[contains(@aria-activedescendant, 'ac53e975-4a39-4169-bee2-5bda79379b10')]/*[1]"));
		openRoleDropdown.click();
		//Select Role from drop-down list - Sales
		WebElement selectRole = webDriver.findElement(By.xpath("//span[contains(@aria-activedescendant, 'ac53e975-4a39-4169-bee2-5bda79379b10')]//option[contains(@value, 'fa13ba5f-fd45-4a6d-a859-4f95649b9ed5')]"));
		selectRole.click();

		//Click on Supervisor drop-down menu
		WebElement openSupervisorDropdown = webDriver.findElement(By.xpath("//span[contains(@class, 'k-widget k-dropdown k-header form-control ng-valid ng-valid-required ng-not-modified ng-pristine k-invalid ng-touched')]/*[1]"));
		openSupervisorDropdown.click();
		//Select Supervisor from drop-down list - Sales
		WebElement selectSupervisor = webDriver.findElement(By.xpath("//span[contains(@class, 'k-widget k-dropdown k-header form-control ng-valid ng-valid-required ng-not-modified ng-pristine k-invalid ng-touched')]//option[1]"));
		selectSupervisor.click();

		//Password text input field
		WebElement userPasswordTextField = webDriver.findElement(By.xpath("//div[contains(@class, 'form-group')]/input[contains(@ng-model, 'user.password')][1]"));
		userPasswordTextField.sendKeys("123456");

		//Confirm Password text input field
		WebElement confirmUserPasswordTextField = webDriver.findElement(By.xpath("/html//div[2]/form/div[1]//fieldset/div[12]/input"));
		confirmUserPasswordTextField.clear();
		confirmUserPasswordTextField.sendKeys("123456");

		//Create user
		WebElement createButton = webDriver.findElement(By.xpath("//button[contains(@class, 'btn bg_gradient_blue btn_like btn_update')][2]"));
		createButton.click();
		wdWait0.until(ExpectedConditions.visibilityOf(webDriver.findElement(By.xpath("//*[@id=\"login_form\"]/div[1]/img"))));


		/////////////////////////Users page after creation


		//Check Confirm message is present
		String confirmPopup = webDriver.findElement(By.xpath("//div[contains(@ng-class, 'alertClasses(message)')]")).getText();
		Assert.assertTrue(confirmPopup.contains("Successfully created User"));

		//Close pop up
		WebElement confirmPopupCloseButton = webDriver.findElement(By.xpath("//div[contains(@ng-class, 'alertClasses(message)')]/button[1]"));
		confirmPopupCloseButton.click();

		//Find first user in the Users grid
		WebElement firstElementFromUsersList = webDriver.findElement(By.xpath("//tbody[contains(@role, 'rowgroup')]/tr[1]"));
		firstElementFromUsersList.click();
		Actions actions = new Actions(webDriver);
		actions.doubleClick(firstElementFromUsersList);
		actions.perform();
		//wait for element loading on Edit user page
		wdWait0.until(ExpectedConditions.visibilityOf(webDriver.findElement(By.xpath("//span[contains(@class, 'k-widget k-dropdown k-header form-control ng-valid ng-valid-required ng-not-modified ng-pristine k-invalid ng-touched')]/*[1]"))));


		///////////// Edit user page
		//Email value verification
		String emailValue = webDriver.findElement(By.xpath("//div[contains(@class, 'form-group')]/input[contains(@ng-model, 'user.email')]")).getText();
		Assert.assertTrue(emailValue.contains("test567@test55.com"));

		//Username value verification
		String usernameValue = webDriver.findElement(By.xpath("//div[contains(@class, 'form-group')]/input[contains(@ng-model, 'user.userName')]")).getText();
		Assert.assertTrue(usernameValue.contains("AutomationSales"));

		//Phone Number value verification
		String phoneValue = webDriver.findElement(By.xpath("//div[contains(@class, 'form-group')]/input[contains(@ng-model, 'user.phoneNumber')]")).getText();
		Assert.assertTrue(phoneValue.contains("456"));

		//Logout
		WebElement topBarDropdown = webDriver.findElement(By.xpath(".//*[@id='dLabel']"));
		topBarDropdown.click();
		WebElement logoutButton = webDriver.findElement(By.xpath(".//*[@id='logoutLnk']"));
		logoutButton.click();
		wdWait0.until(ExpectedConditions.visibilityOf(webDriver.findElement(By.xpath("//span[contains(@class, 'k-widget k-dropdown k-header form-control ng-valid ng-valid-required ng-not-modified ng-pristine k-invalid ng-touched')]/*[1]"))));
		Assert.assertTrue(gurruLogoImaged.isDisplayed());
	}


	@Test
	public void loginAsCreatedUser() {
		webDriver.get(PropertyLoader.loadProperty("testsite7.url"));
		WebDriverWait wdWait0 = new WebDriverWait(webDriver, 5);
		wdWait0.until(ExpectedConditions.visibilityOf(webDriver.findElement(By.xpath("//*[@id=\"login-username\"]"))));

		//Fill Username field
		WebElement userNameTextField = webDriver.findElement(By.xpath("//*[@id=\"login-username\"]"));
		userNameTextField.sendKeys("test567@test55.com");

		//Fill Password field
		WebElement passwordTextField = webDriver.findElement(By.xpath("//*[@id=\"login-password\"]"));
		passwordTextField.sendKeys("123456");

		//Login button click
		WebElement loginButton = webDriver.findElement(By.xpath("//*[@id=\"loginBtn\"]"));
		loginButton.click();
		//wait until page is loading after login
		wdWait0.until(ExpectedConditions.visibilityOf(webDriver.findElement(By.xpath("//li[contains(@ng-class, 'UserAdministration')]//span"))));

		//Verify that Admin is logged in
		String checkAdminName = webDriver.findElement(By.xpath(".//*[@id='dLabel']")).getText();
		Assert.assertTrue(checkAdminName.contains("Automation Test")); ////////////////////

	}
}