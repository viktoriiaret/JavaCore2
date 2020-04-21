package Tests;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;

import java.time.Duration;

public class LoginTests {
    private WebDriver driver;
    private FluentWait<WebDriver> fluentWait;

    @BeforeMethod
    public void startUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
    @Test
    public void loginTest_correctCredentials_loggedToApp(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        HomePage homePage = loginPage.login("testpro.user02@testpro.io","te$t$tudent02");
        Assert.assertTrue(homePage.isHomepage());

    }
    @Test
    public void createNewPlayListTest_provideName_NewPlayListIsCreated() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        HomePage homePage = loginPage.login("testpro.user02@testpro.io", "te$t$tudent02");
        Assert.assertTrue(homePage.isHomepage());
        homePage.createNewPlaylist("Js13");

    }

    @Test
    public void loginTest_incorrectCredentials_notLoggedToApp(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.login("testpro.user02@testpro.io","********");
        Assert.assertTrue(loginPage.isError());
    }

}
