package com.epam.pages.mobile.coursera;

import com.epam.core.mobile.base.page.BaseMobilePage;
import com.epam.core.utilities.service.WaitersService;
import com.epam.core.utilities.service.WebElementsService;
import com.epam.core.utilities.service.SwipeService;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PopularCoursePage extends BaseMobilePage {
    private static final int PRESS_TIME = 1000;

    @AndroidFindBy(id = "org.coursera.android:id/catalog_v3_see_all")
    private MobileElement seeAllCourses;

    @AndroidFindBy(id = "org.coursera.android:id/see_all_header")
    private MobileElement headerName;

    @AndroidFindBy(id = "org.coursera.android:id/card_title")
    private List<MobileElement> mostPopularCourses;

    @AndroidFindBy(id = "org.coursera.android:id/rating_count")
    private List<MobileElement> ratingList;

    @AndroidFindBy(id = "org.coursera.android:id/catalog_v3_toolbar_title")
    private WebElement titleName;

    @AndroidFindBy(id = "org.coursera.android:id/faq_expand_collapse_button")
    private MobileElement answerTheQuestion;

    @AndroidFindBy(xpath = "//*[@class = 'android.widget.TextView' and contains(@text,'?')]")
    private List<MobileElement> listQuestions;

    public void openAllMostPopularCourses() {
        getLogger().info("click see all courses");
        WaitersService.waitForElementToBeClickableAndReturn(getDriver(), seeAllCourses).click();
    }

    public boolean isQuantityCoursesNotEmpty() {
        WaitersService.waitForVisibilityOfElement(getDriver(), headerName);
        getLogger().info("get courses names");
        List<String> namePopularCourses = WebElementsService.getListOfWebElementsText(mostPopularCourses);
        getLogger().info("check quantity of courses isn't empty");
        return namePopularCourses.size() > 0;
    }

    public boolean isListContainsRating() {
        getLogger().info("get list of rating");
        List<String> ratingCourses = WebElementsService.getListOfWebElementsText(ratingList);
        getLogger().info("check list of rating isn't empty");
        return ratingCourses.size() > 0;
    }

    public void openFirstMostPopularCourse() {
        WaitersService.waitForVisibilityOfElement(getDriver(), titleName);
        getLogger().info("click first of the most popular");
        mostPopularCourses.get(0).click();
    }

    public boolean isQuestionsListNotEmpty() {
        getLogger().info("go to frequently asked questions and check an answer");
        SwipeService.swipeToElement(answerTheQuestion, PRESS_TIME);
        getLogger().info("get part of list questions");
        List<String> listOfQuestions = WebElementsService.getListOfWebElementsText(listQuestions);
        getLogger().info("check list of questions isn't empty");
        return listOfQuestions.size() > 0;
    }
}
