package com.epam.cucumber.steps;

import com.epam.pages.coursera.CourseraCampusCoursematchPage;
import com.epam.pages.coursera.CourseraForCampusPage;
import com.epam.pages.coursera.CourseraTechnicalWritingPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class CourseOpensTroughCoursematchSteps {
    private final CourseraForCampusPage forCampusPage = new CourseraForCampusPage();
    private final CourseraCampusCoursematchPage coursematchPage = new CourseraCampusCoursematchPage();
    private final CourseraTechnicalWritingPage technicalWritingPage = new CourseraTechnicalWritingPage();
    private String firstResultLinkText;

    @When("the user opens coursera for campus page")
    public void openCourseraForCampusPage() {
        forCampusPage.openPage();
    }

    @When("the user opens coursera coursematch page")
    public void openCoursematchPage() {
        forCampusPage.clickCoursematchButton();
        coursematchPage.closeForm();
    }

    @When("the user opens first result link page")
    public void openFirstResultLinkPage() {
        firstResultLinkText = coursematchPage.getFirstResultCourseName();
        coursematchPage.clickFirstResultAndSwitchToNewTab();
    }

    @Then("first result course page is opened, header is correct")
    public void headerOfFirstResultPageIsCorrect() {
        Assert.assertEquals(technicalWritingPage.getHeaderText(), firstResultLinkText,
                "Header text is not equal to course name!");
    }
}
