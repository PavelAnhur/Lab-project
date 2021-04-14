package com.epam.pages.mobile.coursera;

import com.epam.core.enums.Context;
import com.epam.core.mobile.base.page.BaseMobilePage;
import com.epam.core.utilities.service.ContextSwitcher;
import com.epam.core.utilities.service.SwipeService;
import com.epam.core.utilities.service.WaitersService;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BackgroundInfoPage extends BaseMobilePage {
    private static final int PRESS_TIME = 300;
    private static final String COMMAND_LINE_ARGUMENT = "env";
    private static final String DEVICE_NAME = "pixel-2-ver10";

    @FindBy(xpath = "//*[text()='Background Information']")
    private WebElement pageHeader;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"I'm not a robot\")")
    private MobileElement recaptchaCheckbox;

    @FindBy(css = "div[style*='visibility: visible;']")
    private WebElement recaptchaWindow;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='recaptcha-verify-button']")
    private MobileElement recaptchaVerifyButton;

    public void selectRecaptchaCheckbox() {
        getLogger().info("select 'I'm not a robot' checkbox");
        SwipeService.swipeToElement(recaptchaCheckbox, PRESS_TIME);
        WaitersService.waitForVisibilityOfElement(getDriver(), recaptchaCheckbox);
        WaitersService.waitForElementToBeClickableAndReturn(getDriver(), recaptchaCheckbox).click();
    }

    public boolean isRecaptchaWindowDisplayed() {
        getLogger().info("get recaptcha window");
        try {
            if (System.getProperty(COMMAND_LINE_ARGUMENT).equals(DEVICE_NAME)) {
                WaitersService.waitForVisibilityOfElement(getDriver(), recaptchaVerifyButton);
            } else {
                ContextSwitcher.switchContext(Context.WEBVIEW.getContextName());
                WaitersService.waitForVisibilityOfElement(getDriver(), recaptchaWindow);
            }
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }
}
