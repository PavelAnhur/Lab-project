package com.epam.cucumber.steps;

import com.epam.core.utilities.service.TabsSwitcher;
import com.epam.core.webdriver.factory.DriverManager;
import com.epam.pages.coursera.CourseraCourseOverviewPage;
import com.epam.pages.coursera.CourseraHomePage;
import com.epam.pages.coursera.CourseraInformationSystemsAuditingPage;
import com.epam.pages.coursera.CourseraSearchResultsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class OpenVideoStepDefs {

    private final CourseraHomePage homePage = new CourseraHomePage();
    private final CourseraSearchResultsPage searchResultsPage = new CourseraSearchResultsPage();
    private final CourseraInformationSystemsAuditingPage informationSystemsAuditingPage =
            new CourseraInformationSystemsAuditingPage();
    private final CourseraCourseOverviewPage courseOverviewPage = new CourseraCourseOverviewPage();

    @When("the user opens {string} page from search result")
    public void openInformationSystemAuditingPage(final String course) {
        homePage.openPage();
        homePage.enterCourseToSearch(course);
        searchResultsPage.clickOnFirstCourseInSearch();
        TabsSwitcher.switchToNewTab(DriverManager.getDriver());
        informationSystemsAuditingPage.clickSeeAllButtonInSyllabusSection();
    }

    @When("the user clicks Course overview video link")
    public void clickCourseOverviewVideoLink() {
        informationSystemsAuditingPage.clickCourseOverviewVideoLink();
    }

    @When("the user clicks play video")
    public void clickPlayVideo() {
        courseOverviewPage.clickPlayVideo();
    }

    @Then("video is playing and playtime more than zero")
    public void isVideoOpened() {
        Assert.assertTrue(courseOverviewPage.isVideoOpened(), "Video didn't open!");
    }
}
