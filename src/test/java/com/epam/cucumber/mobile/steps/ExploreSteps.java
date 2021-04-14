package com.epam.cucumber.mobile.steps;

import com.epam.pages.mobile.coursera.BottomSection;
import com.epam.pages.mobile.coursera.ExplorePage;
import com.epam.pages.mobile.coursera.LearnPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static com.epam.cucumber.mobile.reflection.PageManager.getPage;

public class ExploreSteps {

    @When("the user goes to explore page")
    public void goToExplorePage() {
        getPage(LearnPage.class).goToExploreCourses();
    }

    @Then("the user can see page with the header {string}")
    public void checkHeaderOnExplorePage(final String headerName) {
        Assert.assertEquals(getPage(ExplorePage.class).getHeaderExplorePage(), headerName,
                "Explore menu didn't open!");
    }

    @When("the user goes to explore page through bottom section")
    public void goToExplorePageThroughMenu() {
        getPage(BottomSection.class).navigateToExplore();
    }

    @When("the user selects the first course from the list Trending courses")
    public void goToFirstTrendCourse() {
        getPage(ExplorePage.class).scrollAndOpenFirstTrend();
    }

    @When("the user opens the first course from the list of most popular through explore page")
    public void goToFirstCourseFromPopular() {
        getPage(BottomSection.class).navigateToExplore();
        getPage(ExplorePage.class).scrollToMostPopularCoursesAndOpenFirst();
    }
}
