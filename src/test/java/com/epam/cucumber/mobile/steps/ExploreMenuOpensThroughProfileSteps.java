package com.epam.cucumber.mobile.steps;

import com.epam.pages.mobile.coursera.BottomSection;
import com.epam.pages.mobile.coursera.ExplorePage;
import com.epam.pages.mobile.coursera.ProfilePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static com.epam.cucumber.mobile.reflection.PageManager.getPage;

public class ExploreMenuOpensThroughProfileSteps {

    @When("the user opens profile page")
    public void openProfilePage() {
        getPage(BottomSection.class).navigateToProfile();
    }

    @When("the user taps start learning")
    public void tapStartLearning() {
        getPage(ProfilePage.class).clickStartLearningButton();
    }

    @Then("explore menu opens, header is {string}, any course title is displayed")
    public void verifyExploreMenuOpens(final String expectedText) {
        Assert.assertTrue(getPage(ExplorePage.class).getHeaderExplorePage().equals(expectedText)
                 && getPage(ExplorePage.class).isAnyCourseTitleDisplayed(),
                "Explore page doesn't opened");
    }
}
