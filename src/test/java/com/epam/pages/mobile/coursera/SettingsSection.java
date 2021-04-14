package com.epam.pages.mobile.coursera;

import com.epam.core.mobile.base.page.BaseMobilePage;
import com.epam.core.utilities.service.WaitersService;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.TimeoutException;

import java.util.List;

public class SettingsSection extends BaseMobilePage {
    private static final String TEXT_OF_BUTTON = "Allow";

    @AndroidFindBy(id = "org.coursera.android:id/settings")
    private MobileElement settings;

    @AndroidFindBy(id = "org.coursera.android:id/settings_switch")
    private List<MobileElement> settingsSwitch;

    @AndroidFindBy(id = "org.coursera.android:id/offline_toolbar_text")
    private MobileElement offlineToolbar;

    @AndroidFindBy(accessibility = "Storage location, On your phone, item 3 of 3")
    private MobileElement storageLocation;

    @AndroidFindBy(id = "org.coursera.android:id/storage_radio_button")
    private List<MobileElement> radioButtons;

    @AndroidFindBy(id = "org.coursera.android:id/storage_positive_button")
    private MobileElement submitButton;

    @AndroidFindBy(accessibility = "Storage location, SD Card, item 3 of 3")
    private MobileElement sdCardLocation;

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))"
            + ".scrollIntoView(new UiSelector().text(\"Terms of Use\"))")
    private MobileElement terms;

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))"
            + ".scrollIntoView(new UiSelector().descriptionStartsWith(\"Logout\"))")
    private MobileElement logout;

    @AndroidFindBy(accessibility = "Privacy Policy, , item 2 of 2")
    private MobileElement privacy;

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))"
            + ".scrollIntoView(new UiSelector().text(\"Learner Help Center\"))")
    private MobileElement helpCenter;

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))"
            + ".scrollIntoView(new UiSelector().text(\"My Subscriptions\"))")
    private MobileElement mySubscriptions;

    @AndroidFindBy(id = "org.coursera.android:id/settings_subtitle")
    private List<MobileElement> settingsSubtitles;

    @AndroidFindBy(id = "org.coursera.android:id/positive_button")
    private MobileElement turnOffButton;

    @AndroidFindBy(className = "android.widget.Button")
    private List<MobileElement> permissionButtons;

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))"
            + ".scrollIntoView(new UiSelector().text(\"Payment Information\"))")
    private MobileElement paymentInformation;

    @AndroidFindBy(id = "android:id/button1")
    private MobileElement confirmLogoutButton;

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))"
            + ".scrollIntoView(new UiSelector().text(\"Send Logs\"))")
    private MobileElement sendLogs;

    @AndroidFindBy(id = "android:id/button1")
    private MobileElement submitLogs;

    @AndroidFindBy(id = "android:id/alertTitle")
    private MobileElement sendLogsAlertTitle;

    @AndroidFindBy(id = "org.coursera.android:id/toolbar_title")
    private MobileElement profileName;

    public void openSettings() {
        getLogger().info("open settings");
        WaitersService.waitForElementToBeClickableAndReturn(getDriver(), settings).click();
    }

    public void useOffline() {
        getLogger().info("turn on use offline mode");
        WaitersService.waitForElementToBeClickableAndReturn(getDriver(), settingsSwitch.get(0)).click();
    }

    public String getOfflineToolbarText() {
        WaitersService.waitForVisibilityOfElement(getDriver(), offlineToolbar);
        String toolbar = offlineToolbar.getText();
        getLogger().info("received message: {}", toolbar);
        return toolbar;
    }

    public void openStorageLocationOption() {
        getLogger().info("open storage location");
        WaitersService.waitForElementToBeClickableAndReturn(getDriver(), storageLocation).click();
    }

    public void clickOnRadioButton(final int index) {
        getLogger().info("click radio button with index: {}", index);
        WaitersService.waitForElementToBeClickableAndReturn(getDriver(), radioButtons.get(index)).click();
    }

    public void submit() {
        getLogger().info("click submit button");
        WaitersService.waitForElementToBeClickableAndReturn(getDriver(), submitButton).click();
    }

    public MobileElement getSdCardLocation() {
        WaitersService.waitForVisibilityOfElement(getDriver(), sdCardLocation);
        return sdCardLocation;
    }

    public void openTerms() {
        getLogger().info("open terms of use page");
        WaitersService.waitForElementToBeClickableAndReturn(getDriver(), terms).click();
    }

    public void openPrivacy() {
        getLogger().info("open privacy policy page");
        WaitersService.waitForElementToBeClickableAndReturn(getDriver(), privacy).click();
    }

    public void openHelpCenter() {
        getLogger().info("open help center");
        WaitersService.waitForElementToBeClickable(getDriver(), helpCenter);
        helpCenter.click();
    }

    public void openMySubscriptions() {
        getLogger().info("open my subscriptions");
        WaitersService.waitForElementToBeClickable(getDriver(), mySubscriptions);
        mySubscriptions.click();
    }

    public void tapSyncSwitch() {
        getLogger().info("tap sync to calendar switch");
        try {
            WaitersService.waitForElementToBeClickable(getDriver(), settingsSwitch.get(1));
        } catch (TimeoutException exception) {
            getLogger().warn("the button wasn't clickable with message : {}", exception.getLocalizedMessage());
        }
        settingsSwitch.get(1).click();
    }

    public String getSyncMessage(final String text) {
        WaitersService.waitForVisibilityOfElement(getDriver(), settingsSwitch.get(1));
        WaitersService.waitUntilTextToBePresentInElement(getDriver(), settingsSwitch.get(1), text);
        return settingsSwitch.get(1).getText();
    }

    public void tapTurnOffButton() {
        getLogger().info("Tap turn off button");
        WaitersService.waitForElementToBeClickable(getDriver(), turnOffButton);
        turnOffButton.click();
    }

    public void tapAllowButton() {
        getLogger().info("tap allow button");
        WaitersService.waitForElementToBeClickable(getDriver(), permissionButtons.get(0));
        permissionButtons.stream().filter(button -> button.getText().equalsIgnoreCase(TEXT_OF_BUTTON))
                .findFirst().get().click();
        if (System.getProperty("env").equals("nexus-7-2012")) {
            tapSyncSwitch();
        }
    }

    public void openPaymentInformationPage() {
        getLogger().info("open payment information page");
        WaitersService.waitForElementToBeClickableAndReturn(getDriver(), paymentInformation).click();
    }

    public void clickLogoutButton() {
        getLogger().info("click logout");
        WaitersService.waitForElementToBeClickableAndReturn(getDriver(), logout).click();
        getLogger().info("confirm logout");
        WaitersService.waitForElementToBeClickableAndReturn(getDriver(), confirmLogoutButton).click();
    }

    public SettingsSection clickSendLogs() {
        getLogger().info("click send logs");
        WaitersService.waitForElementToBeClickableAndReturn(getDriver(), sendLogs).click();
        return this;
    }

    public void clickSubmitLogs() {
        getLogger().info("submit logs");
        WaitersService.waitForElementToBeClickableAndReturn(getDriver(), submitLogs).click();
    }

    public String getAlertTitle() {
        WaitersService.waitForVisibilityOfElement(getDriver(), sendLogsAlertTitle);
        String alertTitle = sendLogsAlertTitle.getText();
        getLogger().info("alert title: {}", alertTitle);
        return alertTitle;
    }

    public String getProfileNameFromSettingsSection() {
        WaitersService.waitForVisibilityOfElement(getDriver(), profileName);
        String profile = profileName.getText();
        getLogger().info("get profile name: {}", profile);
        return profile;
    }
}
