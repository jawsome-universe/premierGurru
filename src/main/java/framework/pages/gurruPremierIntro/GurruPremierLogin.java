package framework.pages.gurruPremierIntro;

import com.google.common.base.Function;
import framework.pages.GurruPageFactory;
import framework.pages.Page;
import framework.pages.gurruPremier.GurruPremierContactsPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GurruPremierLogin extends Page {

	@FindBy(xpath = "//*[@id=\"login_form\"]/div[1]/img")
	private WebElement gurruLogoImage;

	@FindBy(xpath = "//*[@id=\"login-username\"]")
	private WebElement usernameTextField;

	@FindBy(xpath = "//*[@id=\"login-password\"]")
	private WebElement passwordTextField;

	@FindBy(xpath = "//*[@id=\"loginBtn\"]")
	private WebElement loginButton;


	public GurruPremierLogin(WebDriver webDriver) { super(webDriver); }

	@Step("Login to Gurru Premier with Admin credentials: {login} / ********")
	public GurruPremierUsersPage loginToGurruPremier(String adminLogin, String adminPassword) {
		gurruLogoImage.isDisplayed();
		usernameTextField.clear();
		usernameTextField.sendKeys(adminLogin);
		passwordTextField.clear();
		passwordTextField.sendKeys(adminPassword);
		loginButton.click();

		return GurruPageFactory.initElements(webDriver, GurruPremierUsersPage.class); }




	@Override
	public Function<WebDriver, ?> isPageLoaded() { return wait -> !usernameTextField.isEnabled(); }

}