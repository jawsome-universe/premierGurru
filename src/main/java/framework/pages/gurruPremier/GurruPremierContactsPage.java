package framework.pages.gurruPremier;

import com.google.common.base.Function;
import framework.pages.GurruPageFactory;
import framework.pages.Page;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.ui.ExpectedConditions;

public class GurruPremierContactsPage extends Page {

	//Click on Customers expand list
	@FindBy(xpath = "//li[contains(@class, 'ng-scope')]//span")
	private WebElement customersExpandList;

	//Click on Contacts tab
	@FindBy(xpath = "//li[contains(@class, 'ng-scope')]//a[contains(@ui-sref , 'contacts')]")
	private WebElement contactsTab;

	//Click on Create Contact button
	@FindBy(xpath = "//*[contains(text(), 'Create Contact')]")
	private WebElement createContactButton;


	public GurruPremierContactsPage(WebDriver webDriver) {
		super(webDriver);
	}

	@Step("Proceed to Create new Contact page")
	public GurruPremierCreateContactPage loginToGurruPremier(String login, String password) {
		customersExpandList.click();
		contactsTab.click();
		getWebDriverWait(10).until(ExpectedConditions.elementToBeClickable(createContactButton));
		createContactButton.click();
		getWebDriverWait(10).until(ExpectedConditions.elementToBeClickable(createContactButton));



		return GurruPageFactory.initElements(webDriver, GurruPremierCreateContactPage.class);
	}

	@Override
	public Function<WebDriver, ?> isPageLoaded() {
		return wait -> !createContactButton.isEnabled();
	}
}
