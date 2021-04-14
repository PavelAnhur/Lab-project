package com.epam.pages.coursera;

import com.epam.core.page.BasePage;
import com.epam.core.utilities.service.SelectorService;
import com.epam.core.utilities.service.WaitersService;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CourseraEditorProfilePage extends BasePage {
    private static final String CHANGES_SAVED_RU_MESSAGE = "Изменения сохранены.";
    private static final String CHANGES_SAVED_EN_MESSAGE = "Your changes were successfully saved.";
    private static final int TIMEOUT_FOR_PHOTO = 60;
    private final Logger logger = getLogger();

    @FindBy(xpath = "//button[@data-track-component='edit_profile']")
    private WebElement editMyProfileButton;

    @FindBy(id = "employment_status")
    private WebElement employmentStatusDropdown;

    @FindBy(id = "IndustriesDropdown~currentOccupation")
    private WebElement industryField;

    @FindBy(id = "CompanyDropdown")
    private WebElement employerField;

    @FindBy(id = "OccupationsDropdown")
    private WebElement occupationField;

    @FindBy(id = "current_occupation_level")
    private WebElement experiencedLevel;

    @FindBy(xpath = "//*[@for='work-checkbox']")
    private WebElement currentEmployerCheckbox;

    @FindBy(id = "educational_attainment")
    private WebElement highestDegree;

    @FindBy(id = "university_dropdown")
    private WebElement universityDropdown;

    @FindBy(id = "education_major")
    private WebElement educationMajorDropdown;

    @FindBy(xpath = "//*[@for='education-checkbox']")
    private WebElement studentCheckbox;

    @FindBy(xpath = "//*[@data-track-component='save_profile']")
    private WebElement saveChangesButton;

    @FindBy(xpath = "//*[@class='form-control']/*[@class='caption-text color-secondary-text' and text()]")
    private WebElement changesSavedConfirm;

    @FindBy(className = "bar")
    private WebElement loadBarForProfilePhoto;

    @FindBy(className = "image-selector-error")
    private WebElement imageErrorMessage;

    public CourseraEditorProfilePage clickOnEditProfileButton() {
        WaitersService.waitUntilPageIsCompletelyLoaded(getDriver());
        WaitersService.waitForElementToBeClickable(getDriver(), editMyProfileButton);
        logger.info("click Edit Profile button");
        editMyProfileButton.click();
        WaitersService.waitUntilPageIsCompletelyLoaded(getDriver());
        return this;
    }

    public CourseraEditorProfilePage selectEmployedTimeStatus(final String timeStatusFromDropdown) {
        logger.info("select line number {} in employed time status field", timeStatusFromDropdown);
        SelectorService.selectOptionByIndex(employmentStatusDropdown, Integer.parseInt(timeStatusFromDropdown));
        return this;
    }

    public CourseraEditorProfilePage inputIndustryValue(final String industryValue) {
        logger.info("input {} in Industry field", industryValue);
        industryField.sendKeys(industryValue + Keys.ARROW_DOWN);
        industryField.click();
        return this;
    }

    public CourseraEditorProfilePage inputEmployerValue(final String employerValue) {
        logger.info("input {} in Employer field", employerValue);
        employerField.sendKeys(employerValue + Keys.ENTER);
        return this;
    }

    public CourseraEditorProfilePage inputOccupationValue(final String occupationValue) {
        logger.info("input {} in Occupation field", occupationValue);
        occupationField.sendKeys(occupationValue + Keys.ARROW_DOWN);
        WaitersService.waitForElementToBeClickableAndReturn(getDriver(), occupationField).click();
        return this;
    }

    public CourseraEditorProfilePage selectExperiencedLevel(final String level) {
        logger.info("select line number {} in Experienced level field", level);
        SelectorService.selectOptionByIndex(experiencedLevel, Integer.parseInt(level));
        return this;
    }

    public CourseraEditorProfilePage isItYourCurrentEmployerCheckbox(final String answer) {
        logger.info("click on current employer checkbox");
        if (answer.equalsIgnoreCase("yes") && !currentEmployerCheckbox.isSelected()) {
            currentEmployerCheckbox.click();
        }
        return this;
    }

    public void clickSaveChangesButton() {
        logger.info("Starting wait for photo to upload");
        WebDriverWait wait = new WebDriverWait(getDriver(), TIMEOUT_FOR_PHOTO);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOf(changesSavedConfirm),
                ExpectedConditions.attributeContains(loadBarForProfilePhoto, "style", "100%"),
                ExpectedConditions.visibilityOf(imageErrorMessage)
        ));
        logger.info("saveChangesButton clicking");
        saveChangesButton.click();
    }

    public boolean wereYourChangesSaved() {
        String confirmYourSavedMessage = changesSavedConfirm.getText();
        logger.info("{}", confirmYourSavedMessage);
        return (confirmYourSavedMessage.equals(CHANGES_SAVED_EN_MESSAGE))
                || (confirmYourSavedMessage.equals(CHANGES_SAVED_RU_MESSAGE));
    }

    public CourseraEditorProfilePage selectHighestDegree(final String degreeLevel) {
        logger.info("select degree level in line number {}", degreeLevel);
        SelectorService.selectOptionByIndex(highestDegree, Integer.parseInt(degreeLevel));
        return this;
    }

    public CourseraEditorProfilePage inputUniversityValue(final String universityName) {
        logger.info("type {} in University field", universityName);
        universityDropdown.sendKeys(universityName + Keys.ENTER);
        return this;
    }

    public CourseraEditorProfilePage selectEducationMajor(final String educationMajorLine) {
        logger.info("select {} line in education major field", educationMajorLine);
        SelectorService.selectOptionByIndex(educationMajorDropdown, Integer.parseInt(educationMajorLine));
        return this;
    }

    public CourseraEditorProfilePage areYouCurrentlyStudentCheckbox(final String answer) {
        logger.info("click on student checkbox");
        if (answer.equalsIgnoreCase("no") && studentCheckbox.isSelected()) {
            studentCheckbox.click();
        }
        return this;
    }
}
