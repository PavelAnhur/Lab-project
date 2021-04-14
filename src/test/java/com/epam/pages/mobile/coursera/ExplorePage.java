package com.epam.pages.mobile.coursera;

import com.epam.core.mobile.base.page.BaseMobilePage;
import com.epam.core.utilities.service.SwipeService;
import com.epam.core.utilities.service.WaitersService;
import com.epam.core.utilities.service.WebElementsService;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;
import java.util.NoSuchElementException;

public class ExplorePage extends BaseMobilePage {
    private static final int PRESS_TIME = 1000;

    @AndroidFindBy(id = "org.coursera.android:id/search_src_text")
    private MobileElement searchCatalogInput;

    @AndroidFindBy(id = "org.coursera.android:id/header_topics")
    private MobileElement headerTopics;

    @AndroidFindBy(id = "org.coursera.android:id/text")
    private List<MobileElement> actualTopics;

    @AndroidFindBy(id = "org.coursera.android:id/catalog_v3_header_pill_name")
    private List<MobileElement> expectedTopics;

    @AndroidFindBy(id = "org.coursera.android:id/explore_title")
    private MobileElement headerExplore;

    @AndroidFindBy(id = "org.coursera.android:id/card_title")
    private MobileElement anyCourseTitle;

    @AndroidFindBy(xpath = "//*[@content-desc='See All Trending Courses']")
    private MobileElement trendingCourses;

    @AndroidFindBy(id = "org.coursera.android:id/card_secondary_title")
    private List<MobileElement> allTrendCourses;

    @AndroidFindBy(id = "org.coursera.android:id/relativeLayout6")
    private MobileElement popularCourse;

    @AndroidFindBy(id = "org.coursera.android:id/card_logo")
    private MobileElement firstCourseFromExplorePage;

    public void enterCourseToSearch(final String courseName) {
        WaitersService.waitForVisibilityOfElement(getDriver(), searchCatalogInput);
        getLogger().info("enter course: {}", courseName);
        searchCatalogInput.sendKeys(courseName);
        searchCatalogInput.click();
        getDriver().pressKey(new KeyEvent().withKey(AndroidKey.ENTER));
    }

    public void clickFirstCourseFromExplorePage() {
        getLogger().info("click on the first course from the explore page");
        WaitersService.waitForElementToBeClickable(getDriver(), firstCourseFromExplorePage);
        WebElementsService.clickIgnoringStale(firstCourseFromExplorePage);
    }

    public void openTopics() {
        getLogger().info("open topics in header topics section");
        WaitersService.waitForElementToBeClickableAndReturn(getDriver(), headerTopics).click();
    }

    public List<String> getActualTopicsAsListOfString() {
        List<String> stringList = WebElementsService.getListOfWebElementsText(actualTopics);
        getLogger().info("actual topics: {}", stringList.toString());
        return stringList;
    }

    public List<String> getExpectedTopicsAsListOfString() {
        List<String> stringList = WebElementsService.getListOfWebElementsText(expectedTopics);
        getLogger().info("receiving expected topics: {}", stringList.toString());
        return stringList;
    }

    public void chooseTopicByName(final String topicName) {
        WaitersService.waitUntilVisibilityOfAllElements(getDriver(), actualTopics);
        getLogger().info("choose topic by name: {}", topicName);
        WebElementsService.clickToElementFromListByName(actualTopics, topicName);
    }

    public boolean isAnyCourseTitleDisplayed() {
        WaitersService.waitForVisibilityOfElement(getDriver(), anyCourseTitle);
        return anyCourseTitle.isDisplayed();
    }

    public String getHeaderExplorePage() {
        WaitersService.waitForVisibilityOfElement(getDriver(), headerExplore);
        String header = headerExplore.getText();
        getLogger().info("get header name: {}", header);
        return header;
    }

    public void scrollAndOpenFirstTrend() {
        try {
            getLogger().info("open all trend courses");
            WaitersService.waitForElementToBeClickableAndReturn(getDriver(), trendingCourses).click();
        } catch (NoSuchElementException exception) {
            getLogger().info("scroll and open all trend courses");
            SwipeService.swipeToElement(trendingCourses, PRESS_TIME);
            WaitersService.waitForElementToBeClickableAndReturn(getDriver(), trendingCourses).click();
        }
        getLogger().info("open the first trend course");
        allTrendCourses.get(0).click();
    }

    public void openFirstTopic() {
        getLogger().info("open first topic");
        actualTopics.get(0).click();
    }

    public void scrollToMostPopularCoursesAndOpenFirst() {
        WaitersService.waitForVisibilityOfElement(getDriver(), headerExplore);
        getLogger().info("scroll to the most popular courses and open the first");
        SwipeService.swipeToElement(popularCourse, PRESS_TIME);
        WaitersService.waitForElementToBeClickableAndReturn(getDriver(), popularCourse).click();
    }
}
