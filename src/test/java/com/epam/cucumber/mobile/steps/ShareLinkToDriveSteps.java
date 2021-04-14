package com.epam.cucumber.mobile.steps;

import com.epam.pages.mobile.coursera.ShareLinkPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static com.epam.cucumber.mobile.reflection.PageManager.getPage;

public class ShareLinkToDriveSteps {

    @When("the user saves the course link to drive")
    public void savesCourseLinkToDrive() {
        getPage(ShareLinkPage.class).clickShareButton();
        getPage(ShareLinkPage.class).clickJustOnceButton();
        getPage(ShareLinkPage.class).saveLinkToDrive();
    }

    @Then("the user sees the course shared")
    public void checkTheCourseShared() {
        getPage(ShareLinkPage.class).goToGoogleDrive();
        Assert.assertTrue(getPage(ShareLinkPage.class).isCourseSharedToDrive(),
                "The course link didn't shared!");
    }
}

