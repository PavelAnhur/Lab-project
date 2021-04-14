package com.epam.cucumber.mobile.steps;

import com.epam.pages.mobile.coursera.ExplorePage;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import static com.epam.cucumber.mobile.reflection.PageManager.getPage;

public class UserCanUseAppWithoutLoginSteps {

    @Then("explore menu opens, header is {string}")
    public void verifyExploreMenuHeader(final String expectedHeader) {
        Assert.assertEquals(getPage(ExplorePage.class).getHeaderExplorePage(), expectedHeader,
                "Header text is incorrect");
    }
}
