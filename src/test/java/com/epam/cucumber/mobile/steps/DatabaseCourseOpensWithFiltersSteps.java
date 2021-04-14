package com.epam.cucumber.mobile.steps;

import com.epam.pages.mobile.coursera.DataBaseCoursePage;
import com.epam.pages.mobile.coursera.ExplorePage;
import com.epam.pages.mobile.coursera.SearchResultsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static com.epam.cucumber.mobile.reflection.PageManager.getPage;

public class DatabaseCourseOpensWithFiltersSteps {

    @When("the user searches for {string} courses with advanced level filter")
    public void searchForCoursesWithAdvancedLevelFilter(final String searchTerm) {
        getPage(ExplorePage.class).enterCourseToSearch(searchTerm);
        getPage(SearchResultsPage.class).tapFilterButton();
        getPage(SearchResultsPage.class).tapAdvancedCheckBox();
        getPage(SearchResultsPage.class).getBack();
    }

    @When("the user opens Database Connectivity course")
    public void openDatabaseConnectivityCourse() {
        getPage(SearchResultsPage.class).tapDataBaseCourse();
    }

    @Then("the course page is opened, page text contains {string}")
    public void verifyPageText(final String expectedText) {
        Assert.assertTrue(getPage(DataBaseCoursePage.class).isDatabaseCoursePageOpened(expectedText),
                "The course wasn't opened");
    }
}
