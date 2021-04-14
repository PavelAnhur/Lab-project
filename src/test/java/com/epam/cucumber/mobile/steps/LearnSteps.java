package com.epam.cucumber.mobile.steps;

import com.epam.pages.mobile.coursera.LearnPage;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import static com.epam.cucumber.mobile.reflection.PageManager.getPage;

public class LearnSteps {

    @Then("the user logged in and can see page header {string}")
    public void theUserCanSeePageHeader(final String expectedHeader) {
        Assert.assertEquals(getPage(LearnPage.class).getHeaderLearnPage(), expectedHeader,
                "User didn't login with email!");
    }
}
