package com.epam.cucumber.mobile.steps;

import com.epam.pages.mobile.coursera.SearchResultsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static com.epam.cucumber.mobile.reflection.PageManager.getPage;

public class CartSteps {

    @When("the user adds this course to cart")
    public void addCourseToCart() {
        getPage(SearchResultsPage.class).clickEnroll();
        getPage(SearchResultsPage.class).subscribe();
    }

    @Then("the user can see {string} screen")
    public void verifyAddingToCart(final String verificationText) {
        Assert.assertEquals(getPage(SearchResultsPage.class).getToolbarTitle(), verificationText);
    }

    @When("the user try to add course to cart")
    public void tryToAddCourseToCart() {
        getPage(SearchResultsPage.class).clickEnroll();
    }
}
