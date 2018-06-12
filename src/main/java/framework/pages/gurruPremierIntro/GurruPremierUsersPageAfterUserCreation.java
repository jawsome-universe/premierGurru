package framework.pages.gurruPremierIntro;

import com.google.common.base.Function;
import framework.pages.GurruPageFactory;
import framework.pages.Page;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class GurruPremierUsersPageAfterUserCreation extends Page {
	Actions action = new Actions(webDriver);

	//Check Confirm message is present
	@FindBy(xpath = "//div[contains(@ng-class, 'alertClasses(message)')]")
	private WebElement confirmPopup;

	//Click on close button
	@FindBy(xpath = "//div[contains(@ng-class, 'alertClasses(message)')]/button[1]")
	private WebElement confirmPopupCloseButton;

	//Find first user in the Users grid
	@FindBy(xpath = "//tbody[contains(@role, 'rowgroup')]/tr[1]")
	private List<WebElement> firstElementFromUsersList;

	public GurruPremierUsersPageAfterUserCreation(WebDriver webDriver) {
		super(webDriver);
	}

	@Step("Check validation pop up and proceed to Edit Contact page")
	public GurruPremierEditUserPage checkConfirmPopupAndGoToEditUserPage() {
		confirmPopup.isDisplayed();
		confirmPopup.getText();
		confirmPopup.getAttribute("Successfully created User");
		confirmPopupCloseButton.click();
		getWebDriverWait(5).until(ExpectedConditions.elementToBeClickable((WebElement) firstElementFromUsersList));
		action.doubleClick((WebElement) firstElementFromUsersList).perform(); //doubleclick on first element in the grid

		return GurruPageFactory.initElements(webDriver, GurruPremierEditUserPage.class);
	}

	@Override
	public Function<WebDriver, ?> isPageLoaded() {
		return wait -> !confirmPopup.isEnabled();
	}
}
