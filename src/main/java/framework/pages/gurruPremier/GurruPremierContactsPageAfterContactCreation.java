package framework.pages.gurruPremier;

import com.google.common.base.Function;
import framework.pages.GurruPageFactory;
import framework.pages.Page;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.interactions.Actions;


import java.util.List;

public class GurruPremierContactsPageAfterContactCreation extends Page {
	Actions action = new Actions(webDriver);

	//Check Confirm message is present
	@FindBy(xpath = "//div[contains(@class, 'growl-item alert ng-scope alert-success icon alert-dismissable')]")
	private WebElement confirmPopup;

	//Click on close button
	@FindBy(xpath = "//div[contains(@class, 'growl-item alert ng-scope alert-success icon alert-dismissable')]/button")
	private WebElement confirmPopupCloseButton;

	//Find first contact in the Contact grid
	@FindBy(xpath = "//tbody[contains(@role, 'rowgroup')]/tr[1]")
	private List<WebElement> firstElementFromContactsList;

	public GurruPremierContactsPageAfterContactCreation(WebDriver webDriver) {
		super(webDriver);
	}

	@Step("Check validation pop up and proceed to Edit Contact page")
	public GurruPremierEditContactPage loginToGurruPremier(String login, String password) {
		confirmPopup.isDisplayed();
		//confirmPopup.getAttribute("Successfully created Contact");
		confirmPopupCloseButton.click();
		getWebDriverWait(5).until(ExpectedConditions.elementToBeClickable((WebElement) firstElementFromContactsList));
		action.doubleClick((WebElement) firstElementFromContactsList).perform(); //doubleclick on first element in the grid

		return GurruPageFactory.initElements(webDriver, GurruPremierEditContactPage.class);
	}

	@Override
	public Function<WebDriver, ?> isPageLoaded() {
		return wait -> !confirmPopup.isEnabled();
	}
}
