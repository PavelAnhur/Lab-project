package com.epam.cucumber.mobile.steps;

import com.epam.pages.mobile.coursera.LearnPage;
import com.epam.pages.mobile.coursera.PhotoCoursePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static com.epam.cucumber.mobile.reflection.PageManager.getPage;

public class UserCanWatchVideoSteps {

    @When("the user opens course and starts watching video")
    public void openCourseAndStartWatchingVideo() {
        getPage(LearnPage.class).openCourseHomePage();
        getPage(PhotoCoursePage.class).tapWatchVideo();
    }

    @Then("the video is displayed")
    public void verifyThatTheVideoIsDisplayed() {
        Assert.assertTrue(getPage(PhotoCoursePage.class).isVideoDisplayed(), "The video wasn't opened");
    }
}
