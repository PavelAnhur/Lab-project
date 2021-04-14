package com.epam.cucumber.steps;

import com.epam.core.utilities.property.PropertyDataReader;
import com.epam.pages.coursera.CourseraTryForFreeFormPage;
import com.epam.service.UsersManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.Properties;

public class TryForFreeFormWorksSteps {
    private final CourseraTryForFreeFormPage tryForFreeFormPage = new CourseraTryForFreeFormPage();
    private final Properties properties = PropertyDataReader.getProperties(System.getProperty("tests-data"));

    @When("the user opens try for free form page")
    public void openPage() {
        tryForFreeFormPage.openPage();
    }

    @When("the user fills all of the form fields with data")
    public void fillTheForm() {
        tryForFreeFormPage.enterFirstName(UsersManager.getUserEmailU().getFirstName());
        tryForFreeFormPage.enterLastName(UsersManager.getUserEmailU().getLastName());
        tryForFreeFormPage.selectJobFunction(properties.getProperty("form.jobfunction"));
        tryForFreeFormPage.enterJobTitle(properties.getProperty("form.jobtitle"));
        tryForFreeFormPage.enterJobEmail(UsersManager.getUserEmailU().getEmail());
        tryForFreeFormPage.enterPhoneNumber(UsersManager.getUserEmailU().getPhoneNumber());
        tryForFreeFormPage.enterInstitutionName(properties.getProperty("form.institutionname"));
        tryForFreeFormPage.enterInstitutionURL(properties.getProperty("form.institutionURL"));
        tryForFreeFormPage.selectInstitutionLevel(properties.getProperty("form.institutionlevel"));
        tryForFreeFormPage.enterNumberOfLearners(properties.getProperty("form.numberoflearners"));
        tryForFreeFormPage.selectPrimaryDiscipline(properties.getProperty("form.primarydiscipline"));
        tryForFreeFormPage.selectCountry(UsersManager.getUserEmailU().getLocation());
        tryForFreeFormPage.selectState(UsersManager.getUserEmailU().getState());
    }

    @When("the user clicks submit")
    public void clickSubmit() {
        tryForFreeFormPage.clickSubmitButton();
    }

    @Then("the form is not sent, alert is presented")
    public void verifyThatAlertIsPresented() {
        Assert.assertTrue(tryForFreeFormPage.alertIsPresented(), "Alert is not displayed");
    }
}
