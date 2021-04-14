package com.epam.pages.mobile.coursera;

import com.epam.core.enums.Context;
import com.epam.core.mobile.base.page.BaseMobilePage;
import com.epam.core.utilities.service.ContextSwitcher;
import com.epam.core.utilities.service.WaitersService;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FacebookLoginPage extends BaseMobilePage {
    private static final String COMMAND_LINE_ARGUMENT = "env";
    private static final String DEVICE_NAME = "pixel-2-ver10";

    @AndroidFindBy(className = "android.webkit.WebView")
    private MobileElement facebookForm;

    @FindBy(css = "#m_login_email")
    private WebElement webEmailField;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='m_login_email']")
    private MobileElement nativeEmailField;

    @FindBy(css = "#m_login_password")
    private WebElement webPasswordField;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='m_login_password']")
    private MobileElement nativePasswordField;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Log In\")")
    private MobileElement nativeLoginButton;

    @FindBy(xpath = "//*[@name='__CONFIRM__']")
    private WebElement confirmButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@index='0']")
    private MobileElement nativeConfirmButton;

    public void inputEmail(final String email) {
        getLogger().info("input {} in email field", email);
        if (System.getProperty(COMMAND_LINE_ARGUMENT).equals(DEVICE_NAME)) {
            WaitersService.waitForElementToBeClickableAndReturn(getDriver(), nativeEmailField).sendKeys(email);
        } else {
            WaitersService.waitForElementToBeClickableAndReturn(getDriver(), facebookForm).click();
            ContextSwitcher.switchContext(Context.WEBVIEW.getContextName());
            webEmailField.sendKeys(email);
        }
    }

    public void inputPassword(final String password) {
        getLogger().info("input {} in password field", password);
        if (System.getProperty(COMMAND_LINE_ARGUMENT).equals(DEVICE_NAME)) {
            nativePasswordField.sendKeys(password);
            WaitersService.waitForElementToBeClickableAndReturn(getDriver(), nativeLoginButton).click();
        } else {
            webPasswordField.sendKeys(password);
            getDriver().pressKey(new KeyEvent().withKey(AndroidKey.ENTER));
        }
    }

    public void clickConfirmButton() {
        getLogger().info("confirm continue with this account");
        if (System.getProperty(COMMAND_LINE_ARGUMENT).equals("pixel-c")) {
            WaitersService.waitForElementToBeClickableAndReturn(getDriver(), confirmButton).click();
        } else {
            ContextSwitcher.switchContext(Context.NATIVE.getContextName());
            try {
                WaitersService.waitForElementToBeClickableAndReturn(getDriver(), nativeConfirmButton).click();
            } catch (NoSuchElementException | TimeoutException exception) {
                WaitersService.waitForElementToBeClickableAndReturn(getDriver(), facebookForm).click();
            }
        }
    }
}
