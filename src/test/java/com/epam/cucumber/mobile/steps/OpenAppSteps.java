package com.epam.cucumber.mobile.steps;

import com.epam.pages.mobile.coursera.LoginPage;
import com.epam.pages.mobile.coursera.LoginWithEmailPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static com.epam.cucumber.mobile.reflection.PageManager.getPage;

public class OpenAppSteps {

    @When("the user opens app without login")
    public void openAppWithoutLogin() {
        getPage(LoginPage.class).signupLater();
    }

    @When("the user logs in coursera app with google account")
    public void logInCourseraAppWithGoogleAccount() {
        getPage(LoginPage.class).loginWithGoogleAccount();
    }

    @Then("the user redirected to the login screen")
    public void verifyLoginScreen() {
        Assert.assertTrue(getPage(LoginPage.class).getGoogleButton().isDisplayed());
    }

    @When("the user logs in coursera app with {string} account")
    public void loginWithEmail(final String account) {
        getPage(LoginPage.class).goToLoginWithEmailPage();
        getPage(LoginWithEmailPage.class).loginWithEmail(account);
    }
}
