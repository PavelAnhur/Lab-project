package com.epam.cucumber.mobile.steps;

import com.epam.pages.mobile.coursera.CoursePage;
import com.epam.pages.mobile.coursera.ExplorePage;
import com.epam.pages.mobile.coursera.SearchResultsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static com.epam.cucumber.mobile.reflection.PageManager.getPage;

public class SearchStepDefs {

    @When("the user inputs {string} for search")
    public void inputForSearch(final String course) {
        getPage(ExplorePage.class).enterCourseToSearch(course);
    }

    @When("the user clicks on the first result")
    public void clickFirstResult() {
        getPage(SearchResultsPage.class).clickOnFirstCourseFromSearchResult();
    }

    @Then("Header of the page should contain {string} words")
    public void doesHeaderContainWords(final String course) {
        Assert.assertTrue(getPage(CoursePage.class).doesSearchResultContainParticularCourse(course),
                "Search result doesn't contain " + course);
    }
}
