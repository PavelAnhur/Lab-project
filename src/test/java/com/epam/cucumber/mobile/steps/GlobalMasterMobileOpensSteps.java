package com.epam.cucumber.mobile.steps;

import com.epam.pages.mobile.coursera.BottomSection;
import com.epam.pages.mobile.coursera.ExplorePage;
import com.epam.pages.mobile.coursera.GlobalMasterPublicMobilePage;
import com.epam.pages.mobile.coursera.HealthTopicPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.epam.cucumber.mobile.reflection.PageManager.getPage;

public class GlobalMasterMobileOpensSteps {

    @When("the user opens {string} topic")
    public void openTopic(final String topicName) {
        getPage(BottomSection.class).navigateToExplore();
        getPage(ExplorePage.class).openTopics();
        getPage(ExplorePage.class).chooseTopicByName(topicName);
    }

    @When("the user opens {string} topic course")
    public void openGlobalMasterOfPublicHealthCourse(final String titleName) {
        getPage(HealthTopicPage.class).tapSeeAllButton();
        getPage(HealthTopicPage.class).tapDegreeTitleByName(titleName);
    }

    @Then("the page is opened, page header has text {string}")
    public boolean verifyPageHeaderHasText(final String expectedText) {
        return getPage(GlobalMasterPublicMobilePage.class).isGlobalMasterCoursePageOpened(expectedText);
    }
}
