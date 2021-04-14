package com.epam.cucumber.mobile.steps;

import com.epam.pages.mobile.coursera.BottomSection;
import com.epam.pages.mobile.coursera.ExplorePage;
import com.epam.pages.mobile.coursera.LoginPage;
import com.epam.pages.mobile.coursera.SearchResultsPage;
import com.epam.pages.mobile.coursera.LoginWithEmailPage;
import com.epam.pages.mobile.coursera.LearnPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static com.epam.cucumber.mobile.reflection.PageManager.getPage;

public class CancelingCourseEnrollmentSteps {
    private static final String USER_HELEN = "Helen";

    @When("the user adds a {string}")
    public void addFreeCourse(final String courseName) {
        getPage(BottomSection.class).navigateToExplore();
        getPage(ExplorePage.class).enterCourseToSearch(courseName);
        getPage(SearchResultsPage.class).clickOnCourse();
        getPage(SearchResultsPage.class).enrollFreeCourse();
    }

    @And("the user cancels this free course")
    public void cancelFreeCourse() {
        getPage(LoginPage.class).goToLoginWithEmailPage();
        getPage(LoginWithEmailPage.class).loginWithEmail(USER_HELEN);
        getPage(LearnPage.class).cancelCourse();
    }

    @Then("the free course is successfully canceled with the message {string}")
    public void isFreeCourseCanceled(final String expendedMessage) {
        Assert.assertEquals(getPage(LearnPage.class).getStateHeader(), expendedMessage,
                "The course didn't cancel!");
    }
}
