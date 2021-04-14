package com.epam.pages.mobile.coursera;

import com.epam.core.mobile.base.page.BaseMobilePage;
import com.epam.core.utilities.service.WaitersService;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PaymentInformationPage extends BaseMobilePage {

    @AndroidFindBy(id = "org.coursera.android:id/toolbar_title")
    private MobileElement headerPaymentInformation;

    @AndroidFindBy(xpath = "//*[@class='android.widget.TextView' and @text = 'Default Payment Method']")
    private MobileElement message;

    public String getHeaderPaymentInformationPage() {
        WaitersService.waitForVisibilityOfElement(getDriver(), headerPaymentInformation);
        String header = headerPaymentInformation.getText();
        getLogger().info("get header name: {}", header);
        return header;
    }

    public String getMessageTextPaymentInformationPage() {
        WaitersService.waitForVisibilityOfElement(getDriver(), headerPaymentInformation);
        String textMessage = message.getText();
        getLogger().info("get message text: {}", textMessage);
        return textMessage;
    }
}
