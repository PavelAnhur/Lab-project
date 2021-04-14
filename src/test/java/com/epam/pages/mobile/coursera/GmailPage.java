package com.epam.pages.mobile.coursera;

import com.epam.core.mobile.base.page.BaseMobilePage;
import com.epam.core.utilities.service.WaitersService;
import com.epam.core.utilities.service.WebElementsService;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class GmailPage extends BaseMobilePage {

    @AndroidFindBy(id = "com.google.android.gm:id/to")
    private MobileElement toField;

    @AndroidFindBy(id = "com.google.android.gm:id/send")
    private MobileElement sendEmailButton;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.google.android.gm:id/wc_body_layout']//android.widget.EditText")
    private MobileElement emailContent;

    public void inputEmail(final String email) {
        getLogger().info("input {} into the address field", email);
        WebElementsService.closeUpdateForm();
        WaitersService.waitForVisibilityOfElement(getDriver(), toField);
        WaitersService.waitForElementToBeClickableAndReturn(getDriver(), toField).sendKeys(email);
        getDriver().pressKey(new KeyEvent().withKey(AndroidKey.ENTER));
        WebElementsService.closeUpdateForm();
    }

    public String getEmailContent() {
        WaitersService.waitForVisibilityOfElement(getDriver(), emailContent);
        String emailContentText = emailContent.getText().replaceAll("\u00A0", "");
        getLogger().info("email content: {}", emailContentText);
        return emailContentText;
    }

    public void sendEmail() {
        getLogger().info("press send email button");
        WaitersService.waitForElementToBeClickableAndReturn(getDriver(), sendEmailButton).click();
        WebElementsService.closeUpdateForm();
    }
}
