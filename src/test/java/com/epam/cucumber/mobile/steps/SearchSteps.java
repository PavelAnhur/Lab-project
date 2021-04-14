package com.epam.cucumber.mobile.steps;

import com.epam.pages.mobile.coursera.BottomSection;
import com.epam.pages.mobile.coursera.ExplorePage;
import com.epam.pages.mobile.coursera.SearchResultsPage;
import io.cucumber.java.en.When;

import static com.epam.cucumber.mobile.reflection.PageManager.getPage;

public class SearchSteps {

    @When("the user choose {string} course to search")
    public void enterCourseToSearch(final String courseName) {
        getPage(BottomSection.class).navigateToExplore();
        getPage(ExplorePage.class).enterCourseToSearch(courseName);
        getPage(SearchResultsPage.class).clickOnCourse();
    }
}
