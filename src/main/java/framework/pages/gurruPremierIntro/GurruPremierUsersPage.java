package framework.pages.gurruPremierIntro;

import com.google.common.base.Function;
import framework.pages.GurruPageFactory;
import framework.pages.Page;
import framework.pages.gurruPremier.GurruPremierCreateContactPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GurruPremierUsersPage extends Page {

	//Click on Users expand list
	@FindBy(xpath = "//li[contains(@ng-class, 'UserAdministration')]//span")
	private WebElement usersExpandList;

	//Click on Users tab
	@FindBy(xpath = "//li[contains(@ng-class, 'UserAdministration')]//a[contains(@ui-sref , 'users')]")
	private WebElement usersTab;

	//Click on Create User button
	@FindBy(xpath = "//*[contains(text(), 'Create User')]")
	private WebElement createUserButton;


	public GurruPremierUsersPage(WebDriver webDriver) {
		super(webDriver);
	}

	@Step("Open Create new user page")
	public GurruPremierCreateUserPage openUserCreatePage() {
		usersExpandList.click();
		usersTab.click();
		getWebDriverWait(10).until(ExpectedConditions.elementToBeClickable(createUserButton));
		createUserButton.click();
		getWebDriverWait(10).until(ExpectedConditions.elementToBeClickable(createUserButton));


		return GurruPageFactory.initElements(webDriver, GurruPremierCreateUserPage.class);
	}

	@Override
	public Function<WebDriver, ?> isPageLoaded() {
		return wait -> !usersExpandList.isEnabled();
	}
}
