package framework.gurruPremierIntroTest.testbase;

import framework.pages.GurruPageFactory;
import framework.pages.gurruPremierIntro.GurruPremierLogin;
import framework.utility.LogFactory;
import framework.utility.PropertyLoader;
import framework.webdriver.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBaseGurruPremierIntro {
	
	private static final Logger LOG = LogFactory.getLogger(TestBaseGurruPremierIntro.class);

	protected WebDriver webDriver;
	
	protected GurruPremierLogin gurruPremierLogin;


	@BeforeMethod
	public void setup() {
		//String browserName = System.getProperty("browser");
		//webDriver = WebDriverFactory.getInstance(browserName);
		WebDriverManager.chromedriver().setup();
		
		LOG.info("Navigating to test url");
		webDriver.get(PropertyLoader.loadProperty("testsite7.url"));
		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		gurruPremierLogin = GurruPageFactory.initElements(webDriver, GurruPremierLogin.class);
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		if (webDriver != null) {
			LOG.info("Killing web driver");
			WebDriverFactory.killDriverInstance();
		}
	}

}