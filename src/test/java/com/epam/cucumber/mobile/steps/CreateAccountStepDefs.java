package com.epam.cucumber.mobile.steps;

import com.epam.pages.mobile.coursera.BottomSection;
import com.epam.pages.mobile.coursera.CreateAccountPage;
import com.epam.pages.mobile.coursera.LoginPage;
import com.epam.pages.mobile.coursera.ProfilePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static com.epam.cucumber.mobile.reflection.PageManager.getPage;

public class CreateAccountStepDefs {

    @When("the user clicks create account button")
    public void clickCreateAccountButton() {
        getPage(LoginPage.class).clickCreateAccountButton();
    }

    @When("the user enters valid credentials")
    public void inputValidCredentials() {
        getPage(CreateAccountPage.class).inputFullName();
        getPage(CreateAccountPage.class).inputEmail();
        getPage(CreateAccountPage.class).inputPassword();
        getPage(CreateAccountPage.class).clickCreateAccountButton();
    }

    @Then("account is created")
    public void accountIsCreated() {
        getPage(LoginPage.class).clickFindCourseButton();
        getPage(BottomSection.class).navigateToProfile();
        Assert.assertEquals(getPage(ProfilePage.class).getProfileName(),
                getPage(CreateAccountPage.class).getFullName(), "account full name not equal!");
    }
}
