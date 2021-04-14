package com.epam.tests.api;

import com.epam.core.enums.StatusCode;
import com.epam.core.webdriver.factory.DriverManager;
import com.epam.pages.coursera.CourseraHomePage;
import com.epam.pages.coursera.CourseraLoginPage;
import com.epam.pages.coursera.CourseraUserPage;
import com.epam.service.UsersManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import static com.epam.core.utilities.service.JsonService.getJsonFile;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class DisableNotificationsTest {
    private static final String BODY = "body/request-body-disable-notifications.json";
    private static final String SCHEMA = "schema/disable-notifications-schema.json";
    private static final String BASE_URI = "https://www.coursera.org/api/userNoteGlobalSettings.v1/80990376";
    private static final String COOKIE_NAME = "CAUTH";
    private final CourseraHomePage homePage = new CourseraHomePage();
    private final CourseraUserPage userPage = new CourseraUserPage();
    private final CourseraLoginPage loginPage = new CourseraLoginPage();
    private WebDriver driver;

    @BeforeSuite
    public void setUp() {
        driver = DriverManager.getDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void disableNotifications() {
        homePage.openPage();
        homePage.clickLoginButton();
        loginPage.loginWithGoogleAccount(UsersManager.getUserEmailU());
        userPage.waitUntilUserIsLoggedIn();
        Cookie cookie = driver.manage().getCookieNamed(COOKIE_NAME);
        RestAssured.baseURI = BASE_URI;
        given().body(getJsonFile(BODY))
                .contentType(ContentType.JSON)
                .cookie(String.valueOf(cookie))
                .when().put()
                .then().log().ifError().assertThat().statusCode(StatusCode.OK_200.getValue())
                .contentType(ContentType.JSON)
                .body(matchesJsonSchema(getJsonFile(SCHEMA)));
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        DriverManager.closeDriver();
    }
}
