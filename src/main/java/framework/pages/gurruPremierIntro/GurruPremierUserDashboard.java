package framework.pages.gurruPremierIntro;

import com.google.common.base.Function;
import framework.pages.GurruPageFactory;
import framework.pages.Page;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GurruPremierUserDashboard extends Page {

	//Check user first name
	@FindBy(xpath = ".//*[@id='dLabel']")
	private WebElement topBarDropdown;


	public GurruPremierUserDashboard(WebDriver webDriver) {
		super(webDriver);
	}

	@Step("check user full name")
	public boolean checkUserFullName() { /////
		topBarDropdown.click();
		topBarDropdown.getAttribute("Automation Test");

		return topBarDropdown.isDisplayed(); ///
	}

	@Override
	public Function<WebDriver, ?> isPageLoaded() {
		return wait -> !topBarDropdown.isEnabled();
	}
}
