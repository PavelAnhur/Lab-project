package com.epam.cucumber.mobile.steps;

import com.epam.pages.mobile.coursera.CoursePage;
import com.epam.pages.mobile.coursera.SearchResultsPage;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import static com.epam.cucumber.mobile.reflection.PageManager.getPage;

public class CourseRatingStepDefs {

    @Then("rating info displayed correctly")
    public void ratingDisplayedCorrectly() {
        String courseRatingFromSearchPage = getPage(SearchResultsPage.class).getCourseRating();
        getPage(SearchResultsPage.class).clickOnFirstCourseFromSearchResult();
        String courseRatingFromCoursePage = getPage(CoursePage.class).getRatingInfo();
        Assert.assertTrue(courseRatingFromSearchPage.contains(courseRatingFromCoursePage),
                "course ratings are different!");
    }
}
