package framework.gurruPremierIntroTest.createUserAndLogin;

import framework.gurruPremierIntroTest.testbase.TestBaseGurruPremierIntro;
import framework.pages.gurruPremierIntro.GurruPremierEditUserPage;
import framework.pages.gurruPremierIntro.GurruPremierUsersPage;
import framework.utility.PropertyLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GurruPremierSimpleIntroTest extends TestBaseGurruPremierIntro {


	@Test
	public void createNewUserTest(){
		webDriver.get(PropertyLoader.loadProperty("testsite7.url"));
		WebDriverWait wdWait0 = new WebDriverWait(webDriver, 5);
		wdWait0.until(ExpectedConditions.visibilityOf(webDriver.findElement(By.xpath("//*[@id=\"login-username\"]"))));

		

		//First Name text input field
		WebElement firstNameField = driver.findElement(By.name("firstname")); //xpath = "//*[@name='firstname']"
		firstNameField.sendKeys(firstName);

		//Second Name text input field
		WebElement lastNameField = driver.findElement(By.name("lastname")); //xpath = "//*[@name='lastname']"
		lastNameField.sendKeys(lastName);

		//Sex (gender) radiobutton
		WebElement sex = driver.findElement(By.xpath("//*[@id='sex-0']")); //male
		sex.click();

		//Years of Experience radiobutton
		WebElement experienceYears = driver.findElement(By.xpath("//*[@id='exp-2']")); //3
		experienceYears.click();

		//Date text input field
		WebElement dateField = driver.findElement(By.xpath("//*[@id='datepicker']"));
		dateField.sendKeys("11.22.63");

		//Profession checkboxes
		WebElement manualTester = driver.findElement(By.xpath("//*[@id='profession-0']")); //manual
		manualTester.click();
		WebElement automationTester = driver.findElement(By.xpath("//*[@id='profession-1']")); //manual
		automationTester.click();

		//Automation Tools checkboxes
		WebElement automationTool = driver.findElement(By.xpath("//*[@id='tool-1']")); //Selenium IDE
		automationTester.click();
		automationTester.findElement(By.xpath("//*[@id='tool-2']")).click(); //Selenium Webdriver

		//Selenium commands
		WebElement seleniumCommandWebElementFirst = driver.findElement(By.xpath("//*[@id='selenium_commands']/option[5]"));
		seleniumCommandWebElementFirst.click();
		WebElement seleniumCommandWebElementSecond = driver.findElement(By.xpath(".//*[@id='selenium_commands']/option[3]"));
		seleniumCommandWebElementSecond.click();

		//Text1
		String textOne = driver.findElement(By.xpath("//*[@id='NextedText']/span")).getText();
		Assert.assertTrue(textOne.contains("Text"));

		//Submit button
		WebElement submitButton = driver.findElement(By.xpath("//*[@id='submit']"));
		submitButton.click();
	}

	@Test //Second step(or test)
	public void SecondStepTest() throws Exception {
		driver.get(baseUrl);
		WebDriverWait wdWait0 = new WebDriverWait(driver, 5);
		wdWait0.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='continents']"))));

		//Continents drop-down menu
		WebElement continents = driver.findElement(By.xpath("//*[@id='continents']"));
		//Move to drop-down menu
		Actions actions = new Actions(driver);
		actions.moveToElement(continents);
		actions.perform();
		//Thread.sleep(2000);
		continents.click();

		//Select Antartica
		WebElement antartica = driver.findElement(By.xpath("//*[@id='continents']/option[7]"));
		antartica.click();
		//Verify that selected value contains some text
		String antarticaValid = driver.findElement(By.xpath("//*[@id='continents']/option[7]")).getText();
		Assert.assertTrue(antarticaValid.contains("Antar"));


		//Select Profile Picture
		WebElement profilePicture = driver.findElement(By.xpath("//*[@id='photo']"));
		//profilePicture.sendKeys("/Users/xsaven/Downloads/shield.jpg");
		profilePicture.sendKeys("/Users/xsaven/IdeaProjects/LastSeleniumHomework/src/test/java/image/shield.jpg");
		// Thread.sleep(5000);

		//Link Test
		WebElement linkTest = driver.findElement(By.xpath("//*[@title='Automation Practice Table'][contains(strong,'Link Test')]/*[1]"));
		actions.moveToElement(linkTest);
		actions.perform();
		linkTest.click();
		//Thread.sleep(3000);

	}


	@Test //Third step(or test)
	public void ThirdStepTest() throws Exception {
		driver.get(baseUrl);
		WebDriverWait wdWait0 = new WebDriverWait(driver, 5);
		wdWait0.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[.='Selenium Automation Hybrid Framework']"))));

		//Download framework
		WebElement seleniumAutomationHybridFramework = driver.findElement(By.xpath("//a[.='Selenium Automation Hybrid Framework']"));
		Actions secondActions = new Actions(driver);
		secondActions.moveToElement(seleniumAutomationHybridFramework);
		secondActions.perform();
		seleniumAutomationHybridFramework.click();
		//Thread.sleep(5000);


	}
}