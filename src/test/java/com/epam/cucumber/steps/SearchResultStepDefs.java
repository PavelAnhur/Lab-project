package com.epam.cucumber.steps;

import com.epam.pages.coursera.CourseraHomePage;
import com.epam.pages.coursera.CourseraSearchResultsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class SearchResultStepDefs {

    private final CourseraHomePage homePage = new CourseraHomePage();
    private final CourseraSearchResultsPage searchResultsPage = new CourseraSearchResultsPage();

    @When("the user searches for the {string}")
    public void enterCourseToSearch(final String course) {
        homePage.enterCourseToSearch(course);
    }

    @When("the user clicks on the first search result")
    public void clickFirstSearchedCourse() {
        searchResultsPage.clickOnFirstCourseInSearch();
    }

    @Then("the search result should contain {string}")
    public void theSearchResultShouldContainsParticular(final String course) {
        Assert.assertTrue(searchResultsPage.doesSearchResultContainParticularCourse(course),
                "Search result doesn't contain " + course);
    }
}
