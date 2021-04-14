package com.epam.cucumber.mobile.steps;

import com.epam.pages.mobile.coursera.BottomSection;
import com.epam.pages.mobile.coursera.SettingsSection;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static com.epam.cucumber.mobile.reflection.PageManager.getPage;

public class SendLogsStepDefs {
    private static final String STATUS_MESSAGE = "Success";

    @When("the user tries to send logs")
    public void sendLogs() {
        getPage(BottomSection.class).navigateToProfile();
        getPage(SettingsSection.class).openSettings();
        getPage(SettingsSection.class)
                .clickSendLogs()
                .clickSubmitLogs();
    }

    @Then("successful status message is displayed")
    public void successfulStatusMessageIsDisplayed() {
        Assert.assertEquals(getPage(SettingsSection.class).getAlertTitle(), STATUS_MESSAGE,
                "Send logs operation failed!");
    }
}
