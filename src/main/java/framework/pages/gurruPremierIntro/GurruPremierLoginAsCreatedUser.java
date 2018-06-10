package framework.pages.gurruPremierIntro;

import com.google.common.base.Function;
import framework.pages.GurruPageFactory;
import framework.pages.Page;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GurruPremierLoginAsCreatedUser extends Page {

	@FindBy(xpath = "//*[@id=\"login-username\"]")
	private WebElement usernameTextField;

	@FindBy(xpath = "//*[@id=\"login-password\"]")
	private WebElement passwordTextField;

	@FindBy(xpath = "//*[@id=\"loginBtn\"]")
	private WebElement loginButton;


	public GurruPremierLoginAsCreatedUser(WebDriver webDriver) { super(webDriver); }

	@Step("Login to Gurru Premier as created user: {login} / ******")
	public GurruPremierUserDashboard loginToGurruPremierAsNewUser(String cretedUserLogin, String createdUserPassword) { ///user data
		usernameTextField.clear();
		usernameTextField.sendKeys(cretedUserLogin); //add as on Login page?
		passwordTextField.clear();
		passwordTextField.sendKeys(createdUserPassword); //add as on Login page?
		loginButton.click();

		return GurruPageFactory.initElements(webDriver, GurruPremierUserDashboard.class); }


	@Override
	public Function<WebDriver, ?> isPageLoaded() { return wait -> !usernameTextField.isEnabled(); }

}