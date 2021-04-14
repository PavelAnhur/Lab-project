package com.epam.cucumber.mobile.steps;

import com.epam.pages.mobile.coursera.SettingsSection;
import com.epam.pages.mobile.coursera.UrlBar;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static com.epam.cucumber.mobile.reflection.PageManager.getPage;

public class SettingsSteps {
    private static final int RADIO_BUTTON_INDEX = 1;
    private final UrlBar urlBar = new UrlBar();

    @When("the user opens settings and turns on offline mode")
    public void opensSettingsAndTurnOnOfflineMode() {
        getPage(SettingsSection.class).openSettings();
        getPage(SettingsSection.class).useOffline();
    }

    @Then("the user can see {string} message")
    public void verifyMessage(final String message) {
        Assert.assertEquals(getPage(SettingsSection.class).getOfflineToolbarText(), message);
    }

    @When("the user opens settings")
    public void openSettings() {
        getPage(SettingsSection.class).openSettings();
    }

    @When("the user changes storage location")
    public void changeStorageLocation() {
        getPage(SettingsSection.class).openStorageLocationOption();
        getPage(SettingsSection.class).clickOnRadioButton(RADIO_BUTTON_INDEX);
        getPage(SettingsSection.class).submit();
    }

    @Then("the user can see that storage location changed")
    public void verifyStorageLocation() {
        Assert.assertTrue(getPage(SettingsSection.class).getSdCardLocation().isDisplayed());
    }

    @When("the user opens terms of use")
    public void openTermsOfUse() {
        getPage(SettingsSection.class).openTerms();
    }

    @Then("the user can see {string} page of {string}")
    public void verifyPage(final String page, final String coursera) {
        Assert.assertTrue(urlBar.getUrlBarText().contains(coursera)
                && urlBar.getUrlBarText().contains(page));
    }

    @When("the user opens privacy policy")
    public void opensPrivacyPolicy() {
        getPage(SettingsSection.class).getBack();
        getPage(SettingsSection.class).openPrivacy();
    }

    @When("the user opens settings and selects the payment information section")
    public void openSettingAndSelectPaymentInformation() {
        getPage(SettingsSection.class).openSettings();
        getPage(SettingsSection.class).openPaymentInformationPage();
    }
}
