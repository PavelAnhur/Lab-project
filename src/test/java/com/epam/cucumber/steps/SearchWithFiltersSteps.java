package com.epam.cucumber.steps;

import com.epam.pages.coursera.CourseraHomePage;
import com.epam.pages.coursera.CourseraLearnToTeachJavaPage;
import com.epam.pages.coursera.CourseraSearchResultsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class SearchWithFiltersSteps {
    private final CourseraHomePage homePage = new CourseraHomePage();
    private final CourseraSearchResultsPage resultsPage = new CourseraSearchResultsPage();
    private final CourseraLearnToTeachJavaPage learnToTeachJavaPage = new CourseraLearnToTeachJavaPage();

    @When("the user searches for {string} courses with language filter russian and beginner level filter")
    public void searchForCoursesWithFilters(final String searchTerm) {
        homePage.enterCourseToSearch(searchTerm);
        resultsPage.chooseRussianFilter();
        resultsPage.chooseLevelFilter();
    }

    @When("the user opens {string} course")
    public void openCourse(final String courseName) {
        resultsPage.clickNeededCourse(courseName);
    }

    @Then("the course page is opened, header text contains {string}")
    public void verifyPageHeader(final String courseName) {
        Assert.assertTrue(learnToTeachJavaPage.getHeaderText().contains(courseName),
                "Header text is incorrect");
    }
}
