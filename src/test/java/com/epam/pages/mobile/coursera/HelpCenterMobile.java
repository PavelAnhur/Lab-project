package com.epam.pages.mobile.coursera;

import com.epam.core.mobile.base.page.BaseMobilePage;
import com.epam.core.utilities.service.WaitersService;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HelpCenterMobile extends BaseMobilePage {
    private static final String TEXT_TO_BE_PRESENT = "Coursera Help Center";

    @AndroidFindBy(accessibility = "Coursera | Help Center")
    private MobileElement header;

    @AndroidFindBy(accessibility = "Coursera Help Center")
    private MobileElement webView;

    @AndroidFindBy(className = "android.webkit.WebView")
    private MobileElement webViewClass;


    public boolean isPageHeaderDisplayed() {
        if (System.getProperty("env").equals("nexus-7-2012")) {
            WaitersService.waitForVisibilityOfElement(getDriver(), webView);
            return webView.isDisplayed();
        } else {
            WaitersService.waitForVisibilityOfElement(getDriver(), webViewClass);
            return webViewClass.getText().contains(TEXT_TO_BE_PRESENT);
        }
    }
}
