package com.epam.pages.mobile.coursera;

import com.epam.core.mobile.base.page.BaseMobilePage;
import com.epam.core.utilities.service.WaitersService;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class DataBaseCoursePage extends BaseMobilePage {

    @AndroidFindBy(className = "android.view.View")
    private List<MobileElement> viewElements;

    @AndroidFindBy(className = "android.webkit.WebView")
    private MobileElement webView;

    @AndroidFindBy(accessibility = "Introduction To Java Database Connectivity - JDBC")
    private MobileElement header;

    public boolean isDatabaseCoursePageOpened(final String courseName) {
        if (System.getProperty("env").equals("nexus-7-2012")) {
            WaitersService.waitForVisibilityOfElement(getDriver(), header);
            return header.isDisplayed();
        } else {
            WaitersService.waitUntilTextToBePresentInElement(getDriver(), webView, courseName);
            return webView.getText().contains(courseName);
        }
    }
}
