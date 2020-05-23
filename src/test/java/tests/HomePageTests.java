package tests;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class HomePageTests extends BaseTest{
    private static final Logger logger = LogManager.getLogger(HomePage.class);

    @AfterMethod
    public void tearDown() {
        Header header = new Header("Authorization", "Bearer " + LoginPage.getToken());
        Response response = RestAssured.given()
                .baseUri("https://koelapp.testpro.io/")
                .header(header)
                .when()
                .delete("api/playlust/" + HomePage.id)
                .then()
                .statusCode(200)
                .extract()
                .response();
    }

    @Parameters({"email", "password"})
    @Test
    public void homePage_AddPlayList_PlaylistIsCreated(String login, String pwd) {
        var loginPage = new LoginPage(driver);
        loginPage.openPage();
        logger.info(driver.getCurrentUrl());
        var homePage = loginPage.login(login, pwd);
        homePage.addPlayList("zZounds");
        Assert.assertTrue(homePage.isPLCreated("zZounds"));
    }

    @Parameters({"email", "password"})
    @Test
    public void homePage_ChangePlaylistName_NameIsChanged(String login, String pwd) {
        var loginPage = new LoginPage(driver);
        loginPage.openPage();
        var homePage = loginPage.login(login, pwd);
        homePage.addPlayList("zZounds");
        homePage.plScroll("zZounds");
        homePage.changePlayListItemName("zZounds", "zZounds_Changed");
        Assert.assertTrue(homePage.isPLCreated("zZounds_Changed"));
    }

    @Test
    public void homePage_addSongsToPlayList_SongsAreAdded() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        HomePage homePage = loginPage.login("testpro.user02@testpro.io", "te$t$tudent02");
        homePage.addSongsToPL("zzz");
    }
}