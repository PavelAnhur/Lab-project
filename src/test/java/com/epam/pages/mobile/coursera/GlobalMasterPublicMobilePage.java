package com.epam.pages.mobile.coursera;

import com.epam.core.mobile.base.page.BaseMobilePage;
import com.epam.core.utilities.service.WaitersService;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class GlobalMasterPublicMobilePage extends BaseMobilePage {

    @AndroidFindBy(className = "android.view.View")
    private List<MobileElement> viewElements;

    public boolean isGlobalMasterCoursePageOpened(final String courseName) {
        WaitersService.waitUntilVisibilityOfAllElements(getDriver(), viewElements);
        return viewElements.stream().anyMatch(mobileElement -> mobileElement.getText().contains(courseName));
    }
}
