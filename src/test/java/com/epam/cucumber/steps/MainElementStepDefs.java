package com.epam.cucumber.steps;

import com.epam.pages.coursera.CourseraHomePage;
import com.epam.pages.coursera.CourseraInformationTechnologyPage;
import com.epam.pages.coursera.CourseraNetworkingPage;
import com.epam.pages.coursera.CourseraSoftwareTestingPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static com.epam.core.webdriver.factory.DriverManager.getDriver;

public class MainElementStepDefs {

    private final CourseraInformationTechnologyPage informationTechnologyPage = new CourseraInformationTechnologyPage();
    private final CourseraNetworkingPage networkingPage = new CourseraNetworkingPage();
    private final CourseraSoftwareTestingPage softwareTestingPage = new CourseraSoftwareTestingPage();

    @When("the user opens software testing page")
    public void openSoftwareTestingPage() {
        informationTechnologyPage.openPage();
        informationTechnologyPage.clickNetworkingButton();
        networkingPage.clickOnShowMoreButtonTwiceUnderSkillsField();
        networkingPage.clickSoftwareTestingInSkills();
    }

    @When("the user clicks on the main Coursera element at the top-left corner")
    public void clickCourseraMainButton() {
        softwareTestingPage.clickCourseraMainButton();
    }

    @Then("Coursera home page should be opened")
    public void comparePageUrls() {
        Assert.assertEquals(CourseraHomePage.getHomePageUrl(), getDriver().getCurrentUrl());
    }
}
