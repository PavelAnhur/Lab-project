package com.epam.cucumber.steps;

import com.epam.pages.coursera.CourseraHelpCenterPage;
import com.epam.pages.coursera.CourseraUserPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class HelpCenterSteps {
    private static final String COLOR_TO_CHECK = "rgba(0, 0, 0, 0)";
    private final CourseraHelpCenterPage helpCenterPage = new CourseraHelpCenterPage();
    private final CourseraUserPage userPage = new CourseraUserPage();

    @When("the user clicks on vote-up button")
    public void clickOnVoteUpButton() {
        helpCenterPage.clickVoteUpButton();
    }

    @Then("background color of vote-up button changes")
    public void verifyBackgroundColor() {
        String votedColor = helpCenterPage.getVotedColor();
        helpCenterPage.clickVoted();
        Assert.assertNotEquals(votedColor, COLOR_TO_CHECK);
    }

    @When("the user goes to help center and opens help article")
    public void clickOnHelpCenterLink() {
        userPage.clickHelpCenterLink();
        helpCenterPage.chooseHelpTopic();
        helpCenterPage.chooseHelpArticle();
    }
}
