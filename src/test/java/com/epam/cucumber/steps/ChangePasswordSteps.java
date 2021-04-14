package com.epam.cucumber.steps;

import com.epam.core.utilities.property.PropertyDataReader;
import com.epam.pages.coursera.CourseraAccountSettingsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.Properties;

public class ChangePasswordSteps {

    private final CourseraAccountSettingsPage accountSettingsPage = new CourseraAccountSettingsPage();
    private final Properties properties = PropertyDataReader.getProperties("tests-data");

    @When("the user changes password {string} to {string}")
    public void changePassword(final String oldPassword, final String newPassword) {
        accountSettingsPage.inputCurrentPassword(oldPassword);
        accountSettingsPage.inputNewPassword(newPassword);
        accountSettingsPage.saveNewPassword();
    }

    @Then("the password is successfully updated")
    public void checkSetPassword() {
        String successChangePassword = properties.getProperty("change.password");
        String actualMessageAboutSave = accountSettingsPage.getMassageAboutSave();
        Assert.assertTrue(actualMessageAboutSave.contains(successChangePassword), "Password didn't change!");
    }
}
