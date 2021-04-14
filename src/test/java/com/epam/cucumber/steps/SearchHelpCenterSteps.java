package com.epam.cucumber.steps;

import com.epam.pages.coursera.CourseraHelpCenterPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class SearchHelpCenterSteps {
    private final CourseraHelpCenterPage helpCenterPage = new CourseraHelpCenterPage();

    @When("the user inputs data {string} for search")
    public void searchForData(final String inputSearchData) {
        helpCenterPage.fillingOutTheSearchFormWithData(inputSearchData);
        helpCenterPage.searchForData();
    }

    @Then("the request data {string} equals response data")
    public void comparisonRequestAndResponse(final String inputSearchData) {
        String realSearchData = helpCenterPage.getRealSearchData();
        Assert.assertEquals(inputSearchData, realSearchData, "Help Articles on the page didn't matches searching data");
    }
}
