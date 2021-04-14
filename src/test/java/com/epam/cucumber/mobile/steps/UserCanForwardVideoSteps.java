package com.epam.cucumber.mobile.steps;

import com.epam.core.mobile.base.page.BaseMobilePage;
import com.epam.pages.mobile.coursera.PhotoCoursePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import static com.epam.cucumber.mobile.reflection.PageManager.getPage;

public class UserCanForwardVideoSteps extends BaseMobilePage {
    private static final int FORWARD_TIME = 10;

    @And("the user pauses the video and double taps to a right side of player")
    public void pauseTheVideoAndDoubleTapToRightSideOfPlayer() {
        getPage(PhotoCoursePage.class).isVideoDisplayed();
        getPage(PhotoCoursePage.class).pauseVideo();
        getPage(PhotoCoursePage.class).forwardVideo();
    }

    @Then("the video is forwarded successfully")
    public void theVideoIsForwarded() {
        Assert.assertTrue(getPage(PhotoCoursePage.class).getPlayTime() >= FORWARD_TIME,
                "The video wasn't forwarded");
    }
}
