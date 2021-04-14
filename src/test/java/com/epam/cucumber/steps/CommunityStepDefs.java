package com.epam.cucumber.steps;

import com.epam.pages.coursera.CourseraCommunityPage;
import com.epam.pages.coursera.CourseraHomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class CommunityStepDefs {

    private final CourseraCommunityPage communityPage = new CourseraCommunityPage();
    private final CourseraHomePage homePage = new CourseraHomePage();

    @When("the user opens community page")
    public void openCommunityPage() {
        homePage.openPage();
        homePage.clickLearnersButton();
        communityPage.clickHowToUseCommunityButton();
    }

    @When("the user closes tags filter")
    public void closeTagsFilter() {
        communityPage.closeTagsFilter();
    }

    @When("selects all checkboxes from the left side filter")
    public void selectAllCheckboxesFromTheLeftSideFilter() {
        communityPage.selectCommunityCheckbox();
        communityPage.selectLearnerHelpCenterCheckbox();
        communityPage.selectQuestionCheckbox();
        communityPage.selectDiscussionCheckbox();
        communityPage.selectArticleCheckbox();
        communityPage.selectIdeaCheckbox();
        communityPage.selectEventCheckbox();
    }

    @Then("quantity of topics are equals selected topics")
    public void compareTotalTopicsNumber() {
        Assert.assertEquals(communityPage.getTotalTopicsNumberFromCheckboxes(),
                communityPage.getTotalTopicsNumberFromFilterElement(),
                "Quantity of topics not equals!");
    }
}
