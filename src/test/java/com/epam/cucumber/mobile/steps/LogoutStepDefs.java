package com.epam.cucumber.mobile.steps;

import com.epam.pages.mobile.coursera.BottomSection;
import com.epam.pages.mobile.coursera.LoginPage;
import com.epam.pages.mobile.coursera.SettingsSection;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static com.epam.cucumber.mobile.reflection.PageManager.getPage;

public class LogoutStepDefs {

    @When("the user tries to logout")
    public void logout() {
        getPage(BottomSection.class).navigateToProfile();
        getPage(SettingsSection.class).openSettings();
        getPage(SettingsSection.class).clickLogoutButton();
    }

    @Then("login page is displayed")
    public void isLoginPageDisplayed() {
        Assert.assertTrue(getPage(LoginPage.class).isSignupDisplayed(), "Sign up button is not displayed!");
    }
}
