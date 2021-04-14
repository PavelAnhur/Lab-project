package com.epam.cucumber.steps;

import com.epam.pages.coursera.CourseraHomePage;
import com.epam.pages.coursera.CourseraSignupPage;
import com.epam.service.UsersManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class SignupSteps {
    private final CourseraSignupPage signupPage = new CourseraSignupPage();
    private final CourseraHomePage homePage = new CourseraHomePage();

    @When("the user signs up")
    public void clickSignupButton() {
        homePage.clickSignupButton();
        signupPage.signUp(UsersManager.getGoogleUser().getFullName(), UsersManager.getGoogleUser().getEmail(),
                UsersManager.getGoogleUser().getPassword());
    }

    @When("the user opens signup page")
    public void openSignupPage() {
        homePage.clickSignupButton();
    }

    @When("the user opens {string} page")
    public void clickOnLink(final String linkName) {
        signupPage.getLink(linkName).click();
    }

    @Then("recaptcha appears")
    public void verifyRecaptcha() {
        Assert.assertTrue(signupPage.getRecaptchaWindow().isDisplayed());
    }
}
