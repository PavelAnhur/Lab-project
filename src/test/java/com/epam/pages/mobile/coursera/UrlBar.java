package com.epam.pages.mobile.coursera;

import com.epam.core.mobile.base.page.BaseMobilePage;
import com.epam.core.utilities.service.WaitersService;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class UrlBar extends BaseMobilePage {

    @AndroidFindBy(className = "android.widget.EditText")
    private MobileElement urlElement;

    public String getUrlBarText() {
        WaitersService.waitForVisibilityOfElement(getDriver(), urlElement);
        String urlBarText = urlElement.getText();
        getLogger().info("url bar text: {}", urlBarText);
        return urlBarText;
    }
}
