package com.epam.cucumber.mobile.steps;

import com.epam.cucumber.mobile.commonData.SharingData;
import com.epam.pages.mobile.coursera.BottomSection;
import com.epam.pages.mobile.coursera.SettingsSection;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import static com.epam.cucumber.mobile.reflection.PageManager.getPage;

public class AccountVerificationStepDefs {
    private static final String KEY = "email";
    private final SharingData sharingData;

    public AccountVerificationStepDefs(final SharingData data) {
        this.sharingData = data;
    }

    @Then("user's email is displayed")
    public void userEmailIsDisplayed() {
        getPage(BottomSection.class).navigateToProfile();
        getPage(SettingsSection.class).openSettings();
        Assert.assertEquals(getPage(SettingsSection.class).getProfileNameFromSettingsSection(),
                sharingData.getDataForTest().get(KEY), "email is not correct!");
    }
}
