package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;


public class LoginTests_new extends BaseTest{

    @Test
    public void new_loginTest_correctCredentials_loggedToApp(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        HomePage homePage = loginPage.login("testpro.user02@testpro.io","te$t$tudent02");
        Assert.assertTrue(homePage.isHomepage());
    }
    @Test
    public void new_loginTest_incorrectCredentials_notLoggedToApp(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.login("testpro.user02@testpro.io","********");
        Assert.assertTrue(loginPage.isError());
    }


}
