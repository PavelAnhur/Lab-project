package com.epam.cucumber.mobile.steps;

import com.epam.pages.mobile.coursera.BottomSection;
import com.epam.pages.mobile.coursera.CoursePage;
import com.epam.pages.mobile.coursera.ExplorePage;
import com.epam.pages.mobile.coursera.SearchResultsPage;
import com.epam.pages.mobile.coursera.PaymentPage;
import com.epam.pages.mobile.coursera.BackgroundInfoPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static com.epam.cucumber.mobile.reflection.PageManager.getPage;

public class RecaptchaStepDefs {

    @When("the user searches for the {string} course")
    public void searchCourse(final String course) {
        getPage(BottomSection.class).navigateToExplore();
        getPage(ExplorePage.class).enterCourseToSearch(course);
        getPage(SearchResultsPage.class).clickOnFirstCourseFromSearchResult();
    }

    @When("the user tries to make an financial aid")
    public void makeFinancialAid() {
        getPage(CoursePage.class).clickFinancialAid();
        getPage(CoursePage.class).confirmApply();
        getPage(PaymentPage.class).selectInfoCheckbox();
        getPage(PaymentPage.class).selectCompletionCheckbox();
        getPage(PaymentPage.class).fillAcceptTermsField();
        getPage(PaymentPage.class).clickContinueButton();
        getPage(BackgroundInfoPage.class).selectRecaptchaCheckbox();
    }

    @Then("recaptcha is displayed")
    public void recaptchaIsDisplayed() {
        Assert.assertTrue(getPage(BackgroundInfoPage.class).isRecaptchaWindowDisplayed(),
                "Recaptcha window didn't appear!");
    }
}
