package com.epam.cucumber.steps;

import com.epam.pages.coursera.CourseraAccountSettingsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class UpdateTimezoneSteps {

    private final CourseraAccountSettingsPage accountSettingsPage = new CourseraAccountSettingsPage();
    private String inputTimezone;
    private String realSetTimezone;

    @When("the user changes {string} to {string}")
    public void changeTimezone(final String timezoneMinsk, final String timezoneKiev) {
        inputTimezone = accountSettingsPage.changeTimezone(timezoneMinsk, timezoneKiev);
        accountSettingsPage.clickButtonSave();
        accountSettingsPage.refresh();
        realSetTimezone = accountSettingsPage.getRealTimezone();
    }

    @Then("the timezone is successfully updated")
    public void checkSetTimezone() {
        Assert.assertEquals(inputTimezone, realSetTimezone, "Timezone didn't change in the profile");
    }
}
