package framework.gurruPremierIntroTest.createUserAndLogin;

import framework.gurruPremierIntroTest.testbase.TestBaseGurruPremierIntro;
import framework.pages.gurruPremierIntro.GurruPremierUserDashboard;
import framework.pages.gurruPremierIntro.GurruPremierUsersPageAfterUserCreation;
import org.testng.Assert;
import org.testng.annotations.Test;


import framework.pages.gurruPremierIntro.GurruPremierEditUserPage;
import framework.pages.gurruPremierIntro.GurruPremierUsersPage;


import org.testng.annotations.Test;

public class GurruPremierCreateUserAndLoginTest extends TestBaseGurruPremierIntro {

	@Test
	public void buyTicketsTest() {
	//	PlanetaKinoLoginPopUp planetaKinoLoginPopUp = planetaKinoHomePage
			//	.clickOnMovieByIndex(2)
				//.selectFirstAvailableStreamTomorrow()
			//	.selectFirstAvailableSeat();
		
	//	PlanetaKinoCartPage planetaKinoCartPage = planetaKinoLoginPopUp.loginToPlanetaKino("wtAdmin", "Aa123456!");
		//PlanetaKinoPaymentPage planetaKinoPaymentPage = planetaKinoCartPage.clickPayButton();
		
	//	Assert.assertTrue(planetaKinoPaymentPage.isPlatonPaymentSystemAvailable());
	}

	@Test
	public void createNewUserTest(){
		GurruPremierUsersPage gurruPremierUsersPage = gurruPremierLogin.loginToGurruPremier("wtAdmin", "Aa123456!");

		GurruPremierEditUserPage gurruPremierUsersPageAfterUserCreation = gurruPremierUsersPage
				.openUserCreatePage()
				.createNewUser()
				.checkConfirmPopupAndGoToEditUserPage();

		//Assert.assertTrue(confirmPopup.getAttribute().contains("Successfully created User"));

	}

	@Test
	public void checkUserData(){
	}

	/*
	.checkUserData()
				.loginToGurruPremierAsNewUser("test567@test55.com", "123456")
				.checkUserFullName();
	 */
}