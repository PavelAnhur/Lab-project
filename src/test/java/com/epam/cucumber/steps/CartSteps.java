package com.epam.cucumber.steps;

import com.epam.core.webdriver.factory.DriverManager;
import com.epam.pages.coursera.CourseraCartPage;
import com.epam.pages.coursera.CourseraHomePage;
import com.epam.pages.coursera.CourseraUserPage;
import com.epam.pages.coursera.CourseraSearchResultsPage;
import com.epam.pages.coursera.CourseraCourseDescriptionPage;
import com.epam.service.UsersManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;

public class CartSteps {
    private static final String URL_FOR_CHECK = "https://www.coursera.org/browse";
    private final CourseraCartPage cartPage = new CourseraCartPage();
    private final CourseraHomePage homePage = new CourseraHomePage();
    private final CourseraUserPage userPage = new CourseraUserPage();
    private final CourseraSearchResultsPage searchResultsPage = new CourseraSearchResultsPage();
    private final CourseraCourseDescriptionPage courseDescriptionPage = new CourseraCourseDescriptionPage();
    private final SoftAssert softAssert = new SoftAssert();

    @When("the user adds course to cart")
    public void addCourseToCart() {
        searchResultsPage.clickOnFirstCourseInSearch();
        courseDescriptionPage.clickEnrollForFreeButton();
        courseDescriptionPage.clickStartFreeTrialButton();
    }

    @Then("the course {string} added to cart")
    public void verifyAddingOperation(final String course) {
        softAssert.assertTrue(cartPage.getItemVerification(course).getText().contains(course));
        softAssert.assertAll();
    }

    @When("the user removes item from cart")
    public void clickRemoveItemFromCart() {
        cartPage.removeItemFromCart();
    }

    @Then("item deleted from cart")
    public void verifyDeletionOperation() {
        softAssert.assertEquals(DriverManager.getDriver().getCurrentUrl(), URL_FOR_CHECK);
        softAssert.assertAll();
    }

    @When("the user enters {string} course to search")
    public void enterCourseToSearch(final String course) {
        softAssert.assertTrue(userPage.getLoggedInUserName().contains(UsersManager.getGoogleUser()
                .getFullName()));
        homePage.enterCourseToSearch(course);
    }
}
