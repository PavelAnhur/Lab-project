package com.epam.cucumber.steps;

import com.epam.core.utilities.property.PropertyDataReader;
import com.epam.pages.coursera.CourseraCareersPage;
import com.epam.pages.coursera.CourseraDevelopersPage;
import com.epam.pages.coursera.CourseraHomePage;
import com.epam.pages.jobs.JobsLeverCoPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.Properties;

public class JobsFilterStepDefs {

    private final CourseraHomePage homePage = new CourseraHomePage();
    private final CourseraDevelopersPage developersPage = new CourseraDevelopersPage();
    private final CourseraCareersPage careersPage = new CourseraCareersPage();
    private final JobsLeverCoPage jobsPage = new JobsLeverCoPage();
    private final Properties properties = PropertyDataReader.getProperties("tests-data");
    private final String location = properties.getProperty("location");
    private final String team = properties.getProperty("team");

    @When("the user opens jobs page")
    public void openJobsPage() {
        homePage.openPage();
        homePage.clickDevelopersLink();
        developersPage.clickViewOpenPositionsButton();
        careersPage.clickStudentsAndNewGradsButton();
        careersPage.clickSearchOpenRolesLink();
    }

    @When("the user uses filter on the jobs page")
    public void useJobsPageFilter() {
        jobsPage.selectLocation();
        jobsPage.selectTeam();
    }

    @Then("result should contains same values")
    public void doesFilterResultContainLocationAndTeamValues() {
        Assert.assertTrue(jobsPage.doesFilterResultContainLocationAndTeamValues(location, team),
                "Filter result doesn't contain location: " + location + " and team: " + team);
    }
}
