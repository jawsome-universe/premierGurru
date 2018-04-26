package framework.pages.gurruPremier;

import com.google.common.base.Function;
import framework.pages.LitsPageFactory;
import framework.pages.Page;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GurruPremierLoginPage extends Page {

	@FindBy(xpath = "//*[@id=\"login_form\"]/div[1]/img")
	private WebElement gurruLogoImage;

	@FindBy(xpath = "//*[@id=\"login-username\"]")
	private WebElement usernameTextField;

	@FindBy(xpath = "//*[@id=\"login-password\"]")
	private WebElement passwordTextField;

	@FindBy(xpath = "//*[@id=\"loginBtn\"]")
	private WebElement loginButton;


	public GurruPremierLoginPage(WebDriver webDriver) {
		super(webDriver); }

	@Step("Login to Gurru Premier with Admin credentials: {login} / ******")
	public GurruPremierContactsPage loginToGurruPremier(String login, String password) {
		gurruLogoImage.isDisplayed();
		usernameTextField.clear();
		usernameTextField.sendKeys(login);
		passwordTextField.clear();
		passwordTextField.sendKeys(password);
		loginButton.click();

		return LitsPageFactory.initElements(webDriver, GurruPremierContactsPage.class); }

	@Override
	public Function<WebDriver, ?> isPageLoaded() {
		return wait -> !usernameTextField.isEnabled(); }

}