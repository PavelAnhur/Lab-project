package com.epam.cucumber.steps;

import com.epam.pages.coursera.CourseraForBusinessPage;
import com.epam.pages.coursera.CourseraUserPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ChooseSectionViaCourseraForBusinessSteps {
    private final CourseraUserPage userPage = new CourseraUserPage();
    private final CourseraForBusinessPage courseraForBusinessPage = new CourseraForBusinessPage();

    @When("the user goes to coursera for business")
    public void goToCourseraForBusiness() {
        userPage.goToCourseraForBusiness();
    }

    @When("the user choose {string} section")
    public void goToSection(final String setContent) {
        courseraForBusinessPage.selectionOfSomeContent(setContent);
    }

    @Then("the transition to the section {string} is successfully done")
    public void actualContentResult(final String setContent) {
        String actualContentResult = courseraForBusinessPage.getActualResult();
        Assert.assertTrue(actualContentResult.contains(setContent),
                "Coursera Software Engineering Academy page didn't open correct");
    }
}
