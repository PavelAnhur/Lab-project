package com.epam.cucumber.steps;

import com.epam.pages.coursera.CourseraHomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class UpdateLearningGoalSteps {
    private final CourseraHomePage homePage = new CourseraHomePage();

    @When("the user updates learning goal with {string} profession and {string} industry")
    public void updateLearningGoal(final String occupation, final String industry) {
        homePage.clickUpdateLearningGoalButton();
        homePage.clickChangeCareerButton();
        homePage.enterToBecomeProfession(occupation);
        homePage.enterIndustry(industry);
        homePage.clickSubmitButton();
        homePage.clickCloseButton();
    }

    @Then("the occupation goal text is {string}")
    public void verifyOccupationGoalText(final String expectedGoal) {
        Assert.assertEquals(homePage.getOccupationGoalText(), expectedGoal, "Learning goal isn't updated");
    }
}
