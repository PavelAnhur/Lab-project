package com.epam.cucumber.steps;

import com.epam.core.utilities.property.PropertyDataReader;
import com.epam.pages.coursera.CourseraBasketCoursesPage;
import com.epam.pages.coursera.CourseraOneFreeCoursePage;
import com.epam.pages.coursera.CourseraSearchResultsPage;
import com.epam.pages.coursera.CourseraUserPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.Properties;

public class CancelingCourseSteps {
    private final CourseraUserPage userPage = new CourseraUserPage();
    private final CourseraSearchResultsPage searchResultsPage = new CourseraSearchResultsPage();
    private final CourseraOneFreeCoursePage oneFreeCoursePage = new CourseraOneFreeCoursePage();
    private final CourseraBasketCoursesPage basketCoursesPage = new CourseraBasketCoursesPage();
    private final Properties properties = PropertyDataReader.getProperties("tests-data");

    @When("the user adds some free course")
    public void addCourse() {
        String dataSearch = properties.getProperty("data.search");
        userPage.inputCourseForSearch(dataSearch);
        searchResultsPage.clickOnFirstCourseInSearch();
        searchResultsPage.goToSearchResult();
        oneFreeCoursePage.enrollForFreeCourse();
        oneFreeCoursePage.goToTheCourseList();
    }

    @When("the user cancels the free course")
    public void cancelCourse() {
        basketCoursesPage.unenrollCourse();
        basketCoursesPage.confirmUnenroll();
    }

    @Then("the course is successfully canceled")
    public void resultCourseCanceled() {
        String courseTitle = properties.getProperty("course.title");
        Assert.assertTrue(basketCoursesPage.wasCourseCanceled(courseTitle),
                "Сourse didn't remove from the list of user courses!");
    }
}
