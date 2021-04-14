package com.epam.cucumber.steps;

import com.epam.pages.coursera.CourseraHomePage;
import com.epam.pages.googleplay.GooglePlayPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class GooglePlaySteps {
    private final GooglePlayPage googlePlayPage = new GooglePlayPage();
    private final CourseraHomePage homePage = new CourseraHomePage();

    @Then("{string} app title is visible on google play market")
    public void verifyCourseraAppTitle(final String appTitle) {
        Assert.assertEquals(googlePlayPage.getCourseraAppTitle(), appTitle);
    }

    @When("the user opens google play market")
    public void clickGooglePlayButton() {
        homePage.clickGooglePlayButton();
    }
}
