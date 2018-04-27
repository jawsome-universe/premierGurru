package framework.gurruPremier.testbase;

import framework.pages.GurruPageFactory;
import framework.pages.gurruPremier.GurruPremierLoginPage;
import framework.pages.planetakino.PlanetaKinoHomePage;
import framework.utility.LogFactory;
import framework.utility.PropertyLoader;
import framework.webdriver.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBaseGurruPremier {
	
	private static final Logger LOG = LogFactory.getLogger(TestBaseGurruPremier.class);

	protected WebDriver webDriver;
	
	protected GurruPremierLoginPage gurruPremierLoginPage;


	@BeforeMethod
	public void setup() {
		String browserName = System.getProperty("browser");
		webDriver = WebDriverFactory.getInstance(browserName);
		
		LOG.info("Navigating to test url");
		webDriver.get(PropertyLoader.loadProperty("testsite7.url"));
		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		gurruPremierLoginPage = GurruPageFactory.initElements(webDriver, GurruPremierLoginPage.class);
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		if (webDriver != null) {
			LOG.info("Killing web driver");
			WebDriverFactory.killDriverInstance();
		}
	}

}