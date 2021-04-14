package com.epam.cucumber.steps;

import com.epam.pages.coursera.CourseraHomePage;
import com.epam.pages.coursera.CourseraUserPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.epam.core.webdriver.factory.DriverManager.getDriver;
import static org.testng.Assert.assertTrue;

public class LogoutStepDefs {

    private final CourseraHomePage homePage = new CourseraHomePage();
    private final CourseraUserPage userPage = new CourseraUserPage();

    @When("the user clicks logout")
    public void clickLogout() {
        userPage.closeOnboardForm();
        userPage.clickOnLoggedInUser();
        userPage.clickLogoutButtonInUserMenu();
    }

    @Then("the user name is not displayed")
    public void userNameIsNotDisplayed() {
        getDriver().navigate().refresh();
        assertTrue(homePage.isJoinForFreeDisplayed(), " Some user still on the site!");
    }
}
