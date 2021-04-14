package com.epam.cucumber.steps;

import com.epam.pages.coursera.CourseraAccountSettingsPage;
import com.epam.pages.coursera.CourseraUserVerificationPage;
import com.epam.service.UsersManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ConfirmRealNameSteps {
    private final CourseraAccountSettingsPage accountSettingsPage = new CourseraAccountSettingsPage();
    private final CourseraUserVerificationPage userVerificationPage = new CourseraUserVerificationPage();

    @When("the user confirms real name")
    public void confirmRealName() {
        accountSettingsPage.clickUserVerificationButton();
        userVerificationPage.enterFirstName(UsersManager.getGoogleUser().getFirstName());
        userVerificationPage.enterMiddleName(UsersManager.getGoogleUser().getMiddleName());
        userVerificationPage.enterLastName(UsersManager.getGoogleUser().getLastName());
        userVerificationPage.clickSubmitButton();
    }

    @Then("verification message is visible")
    public void verifyConfirmRealNameOperation() {
        String appearedVerificationString = accountSettingsPage.getVerificationMessage();
        Assert.assertTrue(appearedVerificationString.contains(UsersManager.getGoogleUser().getFirstName() + " "
                + UsersManager.getGoogleUser().getMiddleName() + " " + UsersManager.getGoogleUser().getLastName()));
    }
}
