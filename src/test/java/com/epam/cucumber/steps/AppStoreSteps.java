package com.epam.cucumber.steps;

import com.epam.core.utilities.property.PropertyDataReader;
import com.epam.pages.coursera.CourseraAppStorePage;
import com.epam.pages.coursera.CourseraUserPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.Properties;

public class AppStoreSteps {
    private final CourseraUserPage userPage = new CourseraUserPage();
    private final CourseraAppStorePage appStorePage = new CourseraAppStorePage();
    private final Properties properties = PropertyDataReader.getProperties("tests-data");

    @When("the user goes to App Store by the link")
    public void goToAppStore() {
        userPage.clickAppStoreButton();
    }

    @Then("the App Store page with {string} for download is successfully opened")
    public void getAppStorePage(final String appName) {
        String appStoreName = properties.getProperty("appStore");
        Assert.assertTrue(appStorePage.isItCourseraInAppStore(appStoreName, appName),
                "Coursera page application didn't open in App Store!");
    }
}
