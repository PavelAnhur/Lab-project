package com.epam.cucumber.mobile.steps;

import com.epam.core.utilities.service.MobileElementsService;
import com.epam.pages.mobile.coursera.BottomSection;
import com.epam.pages.mobile.coursera.ExplorePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.epam.cucumber.mobile.reflection.PageManager.getPage;

public class TopicsSteps {
    private static final Logger LOGGER = LogManager.getRootLogger();
    private static final String RESOURCE_ID = "org.coursera.android:id/catalog_v3_header_recycler_view";
    private List<String> actualTopics;
    private Set<String> expectedTopics;

    @When("the user opens topics")
    public void opensTopics() {
        getPage(ExplorePage.class).openTopics();
        actualTopics = getPage(ExplorePage.class).getActualTopicsAsListOfString();
        getPage(ExplorePage.class).getBack();
    }

    @When("the user swipes topics in recycler view")
    public void swipeTopicsInRecyclerView() {
        expectedTopics = new HashSet<>();
        actualTopics.forEach(topicName -> {
            MobileElementsService.horizontalScrollToElementWith(RESOURCE_ID, topicName);
            expectedTopics.addAll(getPage(ExplorePage.class).getExpectedTopicsAsListOfString());
        });
    }

    @Then("the user can see that these topics are equals")
    public void verifyTopics() {
        LOGGER.info(expectedTopics.toString());
        Assert.assertTrue(actualTopics.containsAll(expectedTopics));
    }

    @When("the user opens {string} page through topics menu")
    public void goToSomePageThroughTopicMenu(final String pageName) {
        getPage(BottomSection.class).navigateToExplore();
        getPage(ExplorePage.class).openTopics();
        getPage(ExplorePage.class).chooseTopicByName(pageName);
    }

    @When("the user opens first course in the list topics")
    public void opensFirstCourse() {
        getPage(BottomSection.class).navigateToExplore();
        getPage(ExplorePage.class).openTopics();
        getPage(ExplorePage.class).openFirstTopic();
    }
}
