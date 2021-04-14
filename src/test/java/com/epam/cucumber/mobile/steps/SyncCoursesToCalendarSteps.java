package com.epam.cucumber.mobile.steps;

import com.epam.pages.mobile.coursera.SettingsSection;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.TimeoutException;
import org.testng.asserts.SoftAssert;

import static com.epam.cucumber.mobile.reflection.PageManager.getPage;

public class SyncCoursesToCalendarSteps {
    private static final Logger LOGGER = LogManager.getRootLogger();
    private static final String SWITCH_OFF = "OFF";
    private static final String SWITCH_ON = "ON";

    @And("the user taps sync to my calendar switch")
    public void tapSyncToMyCalendarCheckbox() {
        getPage(SettingsSection.class).tapSyncSwitch();
        getPage(SettingsSection.class).tapAllowButton();
    }

    @Then("the calendar is synced")
    public void verifySyncMessage() {
        SoftAssert softAssert = new SoftAssert();
        try {
            softAssert.assertTrue(getPage(SettingsSection.class).getSyncMessage(SWITCH_ON).contains(SWITCH_ON),
                    "Calendar wasn't synced");
        } catch (TimeoutException exception) {
            LOGGER.warn("the button wasn't tapped");
            getPage(SettingsSection.class).tapSyncSwitch();
            softAssert.assertTrue(getPage(SettingsSection.class).getSyncMessage(SWITCH_ON).contains(SWITCH_ON),
                    "Calendar wasn't synced");
        }
        getPage(SettingsSection.class).tapSyncSwitch();
        getPage(SettingsSection.class).tapTurnOffButton();
        softAssert.assertEquals(getPage(SettingsSection.class).getSyncMessage(SWITCH_OFF), SWITCH_OFF,
                "Calendar wasn't unsynced");
        softAssert.assertAll();
    }
}
