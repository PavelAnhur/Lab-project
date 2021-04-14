package com.epam.pages.mobile.coursera;

import com.epam.core.enums.Context;
import com.epam.core.mobile.base.page.BaseMobilePage;
import com.epam.core.utilities.service.ContextSwitcher;
import com.epam.core.utilities.service.WaitersService;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends BaseMobilePage {
    private static final String AGREE_TERMS = "I agree to the terms above";
    private static final String COMMAND_LINE_ARGUMENT = "env";
    private static final String DEVICE_NAME = "pixel-2-ver10";

    @FindBy(css = "#info_checkbox")
    private WebElement webInfoCheckbox;

    @AndroidFindBy(xpath = "//android.widget.CheckBox[@resource-id='info_checkbox']")
    private MobileElement nativeInfoCheckbox;

    @FindBy(css = "#completion_checkbox")
    private WebElement webCompletionCheckbox;

    @AndroidFindBy(xpath = "//android.widget.CheckBox[@resource-id='completion_checkbox']")
    private MobileElement nativeCompletionCheckbox;

    @FindBy(css = "#accept-terms-field")
    private WebElement webAcceptTermsField;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='accept-terms-field']")
    private MobileElement nativeAcceptTermsField;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Continue\")")
    private MobileElement continueButton;

    public void selectInfoCheckbox() {
        getLogger().info("select info checkbox");
        if (System.getProperty(COMMAND_LINE_ARGUMENT).equals(DEVICE_NAME)) {
            WaitersService.waitForVisibilityOfElement(getDriver(), nativeInfoCheckbox);
            if (nativeInfoCheckbox.getAttribute("checked").equals("false")) {
                WaitersService.waitForElementToBeClickableAndReturn(getDriver(), nativeInfoCheckbox).click();
            }
        } else {
            ContextSwitcher.switchContext(Context.WEBVIEW.getContextName());
            WaitersService.waitForElementToBeClickableAndReturn(getDriver(), webInfoCheckbox).click();
        }
    }

    public void selectCompletionCheckbox() {
        getLogger().info("select completion checkbox");
        if (System.getProperty(COMMAND_LINE_ARGUMENT).equals(DEVICE_NAME)) {
            if (nativeCompletionCheckbox.getAttribute("checked").equals("false")) {
                nativeCompletionCheckbox.click();
            }
        } else {
            webCompletionCheckbox.click();
        }
    }

    public void fillAcceptTermsField() {
        getLogger().info("enter '{}' in accept terms field", AGREE_TERMS);
        if (System.getProperty(COMMAND_LINE_ARGUMENT).equals(DEVICE_NAME)) {
            nativeAcceptTermsField.sendKeys(AGREE_TERMS);
        } else {
            webAcceptTermsField.sendKeys(AGREE_TERMS);
        }
        getDriver().hideKeyboard();
    }

    public void clickContinueButton() {
        ContextSwitcher.switchContext(Context.NATIVE.getContextName());
        getLogger().info("click continue button");
        try {
            WaitersService.waitForElementToBeClickableAndReturn(getDriver(), continueButton).click();
        } catch (TimeoutException exception) {
            selectInfoCheckbox();
            selectCompletionCheckbox();
            continueButton.click();
        }
    }
}
