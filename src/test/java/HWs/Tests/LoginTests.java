package HWs.Tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import HWs.pageObjects.HomePage;
import HWs.pageObjects.LoginPage;

public class LoginTests extends BaseTest{
    @Test
    public void loginTest_correctCredentials_loggedToApp() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        HomePage homePage = loginPage.login("testpro.user02@testpro.io", "te$t$tudent02");
        Assert.assertTrue(homePage.isHomepage());
    }

    @Test
    public void loginTest_incorrectCredentials_notLoggedToApp() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.login("testpro.user02@testpro.io", "********");
        Assert.assertTrue(loginPage.isError());
    }



}