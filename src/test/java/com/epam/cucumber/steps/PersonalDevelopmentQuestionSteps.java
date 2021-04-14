package com.epam.cucumber.steps;

import com.epam.pages.coursera.CourseraPersonalDevelopmentPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class PersonalDevelopmentQuestionSteps {

    private final CourseraPersonalDevelopmentPage personalDevelopmentPage = new CourseraPersonalDevelopmentPage();

    @When("the user opens Coursera Personal development page")
    public void openPersonalDevelopmentPage() {
        personalDevelopmentPage.openPage();
    }

    @When("the user clicks to first question about personal development")
    public void clickFirstQuestionButton() {
        personalDevelopmentPage.clickQuestionButton();
    }

    @Then("answer to question is shown")
    public void answerToQuestionIsShown() {
        Assert.assertTrue(personalDevelopmentPage.answerIsShown(), "Answer to the question is not shown");
    }
}
