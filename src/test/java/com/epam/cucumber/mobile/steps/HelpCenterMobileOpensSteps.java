package com.epam.cucumber.mobile.steps;

import com.epam.pages.mobile.coursera.BottomSection;
import com.epam.pages.mobile.coursera.HelpCenterMobile;
import com.epam.pages.mobile.coursera.SettingsSection;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static com.epam.cucumber.mobile.reflection.PageManager.getPage;

public class HelpCenterMobileOpensSteps {

    @When("the user opens profile settings")
    public void openProfileSettings() {
        getPage(BottomSection.class).navigateToProfile();
        getPage(SettingsSection.class).openSettings();
    }

    @When("the user taps learner help center button")
    public void tapLearnerHelpCenterButton() {
        getPage(SettingsSection.class).openHelpCenter();
    }

    @Then("help center page is opened, header is displayed")
    public void verifyThatHelpCenterPageHeaderIsDisplayed() {
        Assert.assertTrue(getPage(HelpCenterMobile.class).isPageHeaderDisplayed(),
                "Header doesn't displayed, page doesn't opened ");
    }
}
