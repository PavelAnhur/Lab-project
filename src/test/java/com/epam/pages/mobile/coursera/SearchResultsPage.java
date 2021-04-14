package com.epam.pages.mobile.coursera;

import com.epam.core.mobile.base.page.BaseMobilePage;
import com.epam.core.mobile.driver.MobileDriverManager;
import com.epam.core.utilities.service.StringService;
import com.epam.core.utilities.service.WaitersService;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

import static io.appium.java_client.touch.offset.ElementOption.element;

public class SearchResultsPage extends BaseMobilePage {

    @AndroidFindBy(id = "org.coursera.android:id/search_name")
    private List<MobileElement> courseLink;

    @AndroidFindBy(id = "org.coursera.android:id/btn_join_course")
    private MobileElement enrollButton;

    @AndroidFindBy(id = "org.coursera.android:id/subscribe_button")
    private MobileElement subscribeButton;

    @AndroidFindBy(id = "org.coursera.android:id/subscription_info")
    private MobileElement subscriptionInfo;

    @AndroidFindBy(id = "org.coursera.android:id/container")
    private MobileElement searchResult;

    @AndroidFindBy(id = "org.coursera.android:id/social_proof")
    private MobileElement courseRatingInfo;

    @AndroidFindBy(id = "org.coursera.android:id/toolbar_title")
    private MobileElement toolbarTitle;

    @AndroidFindBy(id = "org.coursera.android:id/searchFilter")
    private MobileElement filterButton;

    @AndroidFindBy(xpath = "//*[contains(@text, 'Advanced')]/../android.widget.CheckBox")
    private MobileElement advancedCheckBox;

    @AndroidFindBy(xpath = "//*[contains(@text, 'Introduction To Java Database Connectivity - JDBC')]")
    private MobileElement databaseCourse;

    @AndroidFindBy(id = "org.coursera.android:id/enroll_text")
    private MobileElement enrollFree;

    @AndroidFindBy(id = "org.coursera.android:id/enrollment_option_price")
    private List<MobileElement> enrollFreeButton;

    @AndroidFindBy(id = "org.coursera.android:id/enrollment_option_title")
    private MobileElement titleName;

    @AndroidFindBy(id = "org.coursera.android:id/reminder")
    private MobileElement reminderButton;

    public void clickOnCourse() {
        getLogger().info("click on course");
        WaitersService.waitForVisibilityOfElement(getDriver(), courseLink.get(0));
        WaitersService.waitForElementToBeClickableAndReturn(getDriver(), courseLink.get(0)).click();
    }

    public void clickEnroll() {
        getLogger().info("click enroll");
        WaitersService.waitForElementToBeClickableAndReturn(getDriver(), enrollButton).click();
    }

    public void subscribe() {
        getLogger().info("click subscribe button");
        WaitersService.waitForVisibilityOfElement(getDriver(), subscriptionInfo);
        WaitersService.waitForElementToBeClickableAndReturn(getDriver(), subscribeButton).click();
    }

    public String getToolbarTitle() {
        String purchase = "Purchase";
        WaitersService.waitUntilTextToBePresentInElement(getDriver(), toolbarTitle, purchase);
        String toolbar = toolbarTitle.getText();
        getLogger().info("toolbar title is: {}", toolbar);
        return toolbar;
    }

    public void tapFilterButton() {
        getLogger().info("tap filter button");
        WaitersService.waitForElementToBeClickable(getDriver(), filterButton);
        filterButton.click();
    }

    public void tapAdvancedCheckBox() {
        getLogger().info("tap advanced checkbox");
        WaitersService.waitForElementToBeClickable(getDriver(), advancedCheckBox);
        advancedCheckBox.click();
    }

    public void tapDataBaseCourse() {
        getLogger().info("tap database course");
        WaitersService.waitForElementToBeClickable(getDriver(), databaseCourse);
        getTouchAction().tap(element(databaseCourse)).perform();
    }

    public void enrollFreeCourse() {
        getLogger().info("click enroll free");
        WaitersService.waitForElementToBeClickableAndReturn(getDriver(), enrollFree).click();
        WaitersService.waitForVisibilityOfElement(getDriver(), titleName);
        getLogger().info("click enroll free again");
        WaitersService.waitForElementToBeClickableAndReturn(getDriver(), enrollFreeButton.get(1)).click();
        WaitersService.waitForVisibilityOfElement(getDriver(), reminderButton);
        MobileDriverManager.getDriver().resetApp();
    }

    public void clickOnFirstCourseFromSearchResult() {
        getLogger().info("click on first course from the search result");
        WaitersService.waitForVisibilityOfElement(getDriver(), searchResult);
        WaitersService.waitForElementToBeClickableAndReturn(getDriver(), searchResult).click();
    }

    public String getCourseRating() {
        WaitersService.waitForVisibilityOfElement(getDriver(), courseRatingInfo);
        String courseRating = StringService.getFirstWordFromString(courseRatingInfo.getText(), " ");
        getLogger().info("course rating info from the search page: {}", courseRating);
        return courseRating;
    }
}
