package framework.gurruPremier.loginAsAdmin;

import framework.gurruPremier.testbase.TestBaseGurruPremier;
import framework.pages.gurruPremier.GurruPremierContactsPage;
import framework.pages.gurruPremier.GurruPremierLoginPage;
import framework.pages.planetakino.PlanetaKinoCartPage;
import framework.pages.planetakino.PlanetaKinoLoginPopUp;
import framework.pages.planetakino.PlanetaKinoPaymentPage;
import framework.planetakino.testcase.TestBasePlanetaKino;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GurruPremierAdminLoginTest extends TestBaseGurruPremier{


    @Test
    public void loginAsAdmin() {
        GurruPremierContactsPage premierLogin =  gurruPremierLoginPage.loginToGurruPremier("wtAdmin", "Aa123456!");
    }
}
