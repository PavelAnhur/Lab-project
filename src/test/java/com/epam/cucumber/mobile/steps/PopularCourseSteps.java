package com.epam.cucumber.mobile.steps;

import com.epam.pages.mobile.coursera.PopularCoursePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import static com.epam.cucumber.mobile.reflection.PageManager.getPage;

public class PopularCourseSteps {
    private final SoftAssert softAssert = new SoftAssert();

    @When("the user opens the most popular courses")
    public void openMostPopularCourses() {
        getPage(PopularCoursePage.class).openAllMostPopularCourses();
    }

    @When("the user sees almost one course witch contains average user rating")
    public void checkOpenCourses() {
        softAssert.assertTrue(getPage(PopularCoursePage.class).isQuantityCoursesNotEmpty(),
                "Quantity courses is empty!");
        softAssert.assertTrue(getPage(PopularCoursePage.class).isListContainsRating(),
                "The list doesn't contain rating!");
        softAssert.assertAll();
    }

    @When("the user opens first of the most popular courses")
    public void openMostPopularCourse() {
        getPage(PopularCoursePage.class).openFirstMostPopularCourse();
    }

    @Then("the user sees not empty list of frequently asked questions")
    public void checkQuestionsInTheList() {
        Assert.assertTrue(getPage(PopularCoursePage.class).isQuestionsListNotEmpty(),
                "Questions list is empty!");
    }
}
