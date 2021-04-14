package com.epam.cucumber.steps;

import com.epam.core.utilities.property.PropertyDataReader;
import com.epam.pages.coursera.CourseraAccountSettingsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import java.util.Properties;

public class UpdateLanguageSteps {

    private final CourseraAccountSettingsPage accountSettingsPage = new CourseraAccountSettingsPage();
    private final Properties properties = PropertyDataReader.getProperties("tests-data");
    private String inputLanguage;
    private String realSetLanguage;

    @When("the user changes language")
    public void changeLanguage() {
        String languageRussian = properties.getProperty("language.russian");
        String languageEnglish = properties.getProperty("language.english");
        inputLanguage = accountSettingsPage.changeLanguage(languageEnglish, languageRussian);
        accountSettingsPage.clickButtonSave();
        accountSettingsPage.refresh();
        realSetLanguage = accountSettingsPage.getRealLanguage();
    }

    @Then("the language is successfully updated")
    public void checkSetLanguage() {
        Assert.assertEquals(inputLanguage, realSetLanguage, "Language didn't change in the profile!");
    }
}
