package com.epam.cucumber.steps;

import com.epam.pages.coursera.CourseraEditorProfilePage;
import com.epam.pages.coursera.CourseraUserPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static com.epam.service.UsersManager.getUserWithProfileProperties;

public class EditAccountStepDefs {

    private final CourseraUserPage userPage = new CourseraUserPage();
    private final CourseraEditorProfilePage editorProfilePage = new CourseraEditorProfilePage();

    @When("the user edits account profile")
    public void editAccountProfile() {
        userPage.clickOnLoggedInUser();
        userPage.clickProfileButton();
        editorProfilePage.clickOnEditProfileButton();
        editorProfilePage.selectEmployedTimeStatus(getUserWithProfileProperties().getEmployedTimeStatus());
        editorProfilePage.inputIndustryValue(getUserWithProfileProperties().getIndustry());
        editorProfilePage.inputEmployerValue(getUserWithProfileProperties().getEmployer());
        editorProfilePage.inputOccupationValue(getUserWithProfileProperties().getOccupation());
        editorProfilePage.selectExperiencedLevel(getUserWithProfileProperties().getExperiencedLevel());
        editorProfilePage.isItYourCurrentEmployerCheckbox(getUserWithProfileProperties().getIsItYourCurrentEmployer());
        editorProfilePage.selectHighestDegree(getUserWithProfileProperties().getHighestDegree());
        editorProfilePage.inputUniversityValue(getUserWithProfileProperties().getUniversity());
        editorProfilePage.selectEducationMajor(getUserWithProfileProperties().getEducationMajor());
        editorProfilePage.areYouCurrentlyStudentCheckbox(getUserWithProfileProperties().getAreYouCurrentlyStudent());
    }

    @When("confirms save changes")
    public void confirmSaveChanges() {
        editorProfilePage.clickSaveChangesButton();
    }

    @Then("the user gets a successfully saved changes message")
    public void wereYourChangesSaved() {
        Assert.assertTrue(editorProfilePage.wereYourChangesSaved(), "Changes were not saved!");
    }
}
