package com.epam.cucumber.steps;

import com.epam.core.utilities.service.StringService;
import com.epam.pages.coursera.CourseraAccountSettingsPage;
import com.epam.pages.coursera.CourseraUserPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ChangeFullNameSteps {
    private static final int RANDOM_STRING_LENGTH = 10;
    private final CourseraUserPage userPage = new CourseraUserPage();
    private final CourseraAccountSettingsPage accountSettingsPage = new CourseraAccountSettingsPage();

    @When("the user opens account settings")
    public void openAccountSettings() {
        userPage.clickOnLoggedInUser();
        userPage.clickSettingsButton();
    }

    @When("the user changes full name")
    public void changeFullName() {
        accountSettingsPage.erasePreviousFullName();
        accountSettingsPage.enterNewFullNameAndSave(StringService.getRandomString(RANDOM_STRING_LENGTH));
    }

    @Then("status message with {string} text is displayed")
    public void verifyStatusMessage(final String statusMessage) {
        String statusMessageActual = accountSettingsPage.getStatusMessage();
        Assert.assertEquals(statusMessageActual, statusMessage, "Status message is incorrect");
    }
}
