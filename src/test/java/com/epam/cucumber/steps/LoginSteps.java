package com.epam.cucumber.steps;

import com.epam.pages.coursera.CourseraHomePage;
import com.epam.pages.coursera.CourseraLoginPage;
import com.epam.pages.coursera.CourseraUserPage;
import com.epam.service.UsersManager;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class LoginSteps {
    private final CourseraHomePage homePage = new CourseraHomePage();
    private final CourseraLoginPage loginPage = new CourseraLoginPage();
    private final CourseraUserPage userPage = new CourseraUserPage();

    @When("the user with {string} google account is logged in")
    public void openPageAndLogIn(final String account) {
        homePage.openPage();
        homePage.clickLoginButton();
        switch (account) {
            case "Vlad":
                loginPage.loginWithGoogleAccount(UsersManager.getUserEmailU());
                break;
            case "Pavel":
                loginPage.loginWithGoogleAccount(UsersManager.getUserWithProfileProperties());
                break;
            case "Alex":
                loginPage.loginWithGoogleAccount(UsersManager.getGoogleUser());
                break;
            default:
                loginPage.loginWithGoogleAccount(UsersManager.getCourseraUser());
        }
        userPage.waitUntilUserIsLoggedIn();
    }

    @Then("at the top right corner of the page logged in user is displayed")
    public void verifyLoginOperation() {
        Assert.assertEquals(userPage.getLoggedInUserName(), UsersManager.getGoogleUser().getFullName());
    }
}
