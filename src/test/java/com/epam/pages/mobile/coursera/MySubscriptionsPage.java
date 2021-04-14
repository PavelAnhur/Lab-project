package com.epam.pages.mobile.coursera;

import com.epam.core.mobile.base.page.BaseMobilePage;
import com.epam.core.utilities.service.WaitersService;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MySubscriptionsPage extends BaseMobilePage {

    @AndroidFindBy(id = "org.coursera.android:id/toolbar_title")
    private MobileElement title;

    public String getTitleText() {
        WaitersService.waitForVisibilityOfElement(getDriver(), title);
        return title.getText();
    }
}
