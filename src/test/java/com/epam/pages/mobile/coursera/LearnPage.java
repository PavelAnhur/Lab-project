package com.epam.pages.mobile.coursera;

import com.epam.core.mobile.base.page.BaseMobilePage;
import com.epam.core.utilities.service.WaitersService;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LearnPage extends BaseMobilePage {

    @AndroidFindBy(id = "org.coursera.android:id/homepage_course_blue_button")
    private MobileElement homePageCourseButton;

    @AndroidFindBy(id = "org.coursera.android:id/title_collapsing")
    private MobileElement headerLearn;

    @AndroidFindBy(id = "org.coursera.android:id/find_course")
    private MobileElement exploreCoursesButton;

    @AndroidFindBy(id = "org.coursera.android:id/homepage_course_options")
    private MobileElement courseOptions;

    @AndroidFindBy(id = "android:id/text1")
    private MobileElement unEnrollButton;

    @AndroidFindBy(id = "org.coursera.android:id/empty_state_header")
    private MobileElement stateHeader;

    public void openCourseHomePage() {
        getLogger().info("open course home page");
        WaitersService.waitForElementToBeClickable(getDriver(), homePageCourseButton);
        homePageCourseButton.click();
    }

    public String getHeaderLearnPage() {
        WaitersService.waitForVisibilityOfElement(getDriver(), headerLearn);
        String header = headerLearn.getText();
        getLogger().info("get header name: {}", header);
        return header;
    }

    public void goToExploreCourses() {
        getLogger().info("go to explore page");
        WaitersService.waitForElementToBeClickableAndReturn(getDriver(), exploreCoursesButton).click();
    }

    public void cancelCourse() {
        getLogger().info("open course options");
        WaitersService.waitForElementToBeClickableAndReturn(getDriver(), courseOptions).click();
        getLogger().info("click unEnroll button");
        WaitersService.waitForElementToBeClickableAndReturn(getDriver(), unEnrollButton).click();
    }

    public String getStateHeader() {
        getLogger().info("get state header");
        WaitersService.waitForElementToBeClickable(getDriver(), stateHeader);
        String actualHeader = stateHeader.getText();
        getLogger().info("get actual header : {}", actualHeader);
        return actualHeader;
    }
}
