package com.epam.pages.mobile.coursera;

import com.epam.core.mobile.base.page.BaseMobilePage;
import com.epam.core.utilities.service.WaitersService;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class RefundPolicyPage extends BaseMobilePage {

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Refund policies\")")
    private WebElement pageHeader;

    public String getPageHeaderText() {
        WaitersService.waitForVisibilityOfElement(getDriver(), pageHeader);
        String headerText = (pageHeader.getText()).trim();
        getLogger().info("text from the page header: {}", headerText);
        return headerText;
    }
}
