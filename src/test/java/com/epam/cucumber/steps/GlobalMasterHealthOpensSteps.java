package com.epam.cucumber.steps;

import com.epam.pages.coursera.CourseraGlobalMasterOfPublicHealthPage;
import com.epam.pages.coursera.CourseraHomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class GlobalMasterHealthOpensSteps {
    private final CourseraHomePage homePage = new CourseraHomePage();
    private final CourseraGlobalMasterOfPublicHealthPage publicHealthPage =
            new CourseraGlobalMasterOfPublicHealthPage();

    @When("the user opens Global Master of Public Health course page")
    public void openGlobalMasterOfPublicHealthCoursePage() {
        homePage.clickGlobalMasterButton();
    }

    @Then("the page is opened, header is {string} or {string}")
    public void verifyPageHeader(final String expectedHeader, final String secondExpected) {
        Assert.assertTrue(publicHealthPage.getHeaderText().equals(expectedHeader)
                        || publicHealthPage.getHeaderText().equals(secondExpected),
                "Header text doesn't match. Page doesn't opened");
    }
}
