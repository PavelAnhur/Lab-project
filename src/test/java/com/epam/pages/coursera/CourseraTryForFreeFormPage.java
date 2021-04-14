package com.epam.pages.coursera;

import com.epam.core.page.BasePage;
import com.epam.core.utilities.service.SelectorService;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CourseraTryForFreeFormPage extends BasePage {
    private static final String PAGE_URL = "https://www.coursera.org/campus/try-for-free";
    private final Logger logger = getLogger();

    @FindBy(id = "FirstName")
    private WebElement firstNameField;

    @FindBy(id = "LastName")
    private WebElement lastNameField;

    @FindBy(id = "C4C_Job_Title__c")
    private WebElement jobFunction;

    @FindBy(id = "Title")
    private WebElement jobTitle;

    @FindBy(id = "Email")
    private WebElement jobEmail;

    @FindBy(id = "Phone")
    private WebElement phoneNumberField;

    @FindBy(id = "Company")
    private WebElement institutionNameField;

    @FindBy(id = "Institution_URL__c")
    private WebElement institutionURLField;

    @FindBy(id = "Institution_Level__c")
    private WebElement institutionLevel;

    @FindBy(id = "Coronavirus_No_of_Learners__c")
    private WebElement numberOfLearnersField;

    @FindBy(id = "Primary_Discipline__c")
    private WebElement primaryDiscipline;

    @FindBy(id = "Country")
    private WebElement country;

    @FindBy(id = "State")
    private WebElement state;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    @FindBy(id = "ValidMsgAccept_Terms__c")
    private WebElement alert;

    @Override
    public void openPage() {
        logger.info("Opening try for free form page");
        getDriver().get(PAGE_URL);
    }

    public void enterFirstName(final String firstName) {
        logger.info("Entering first name");
        firstNameField.sendKeys(firstName);
    }

    public void enterLastName(final String lastName) {
        logger.info("Entering last name");
        lastNameField.sendKeys(lastName);
    }

    public void selectJobFunction(final String value) {
        logger.info("Selecting job function");
        SelectorService.selectOptionByValue(jobFunction, value);
    }

    public void enterJobTitle(final String title) {
        logger.info("Entering job title");
        jobTitle.sendKeys(title);
    }

    public void enterJobEmail(final String email) {
        logger.info("Entering job email");
        jobEmail.sendKeys(email);
    }

    public void enterPhoneNumber(final String phoneNumber) {
        logger.info("Entering job phone number");
        phoneNumberField.sendKeys(phoneNumber);
    }

    public void enterInstitutionName(final String institutionName) {
        logger.info("Entering Institution Name");
        institutionNameField.sendKeys(institutionName);
    }

    public void enterInstitutionURL(final String institutionURL) {
        logger.info("Entering Institution URL");
        institutionURLField.sendKeys(institutionURL);
    }

    public void selectInstitutionLevel(final String value) {
        logger.info("Selecting institution level");
        SelectorService.selectOptionByValue(institutionLevel, value);
    }

    public void enterNumberOfLearners(final String numberOfLearners) {
        logger.info("Entering number of learners");
        numberOfLearnersField.sendKeys(numberOfLearners);
    }

    public void selectPrimaryDiscipline(final String value) {
        logger.info("Selecting primary discipline");
        SelectorService.selectOptionByValue(primaryDiscipline, value);
    }

    public void selectCountry(final String value) {
        logger.info("Selecting country");
        SelectorService.selectOptionByValue(country, value);
    }

    public void selectState(final String value) {
        logger.info("Selecting country");
        SelectorService.selectOptionByValue(state, value);
    }

    public void clickSubmitButton() {
        logger.info("Click submit button");
        submitButton.click();
    }

    public boolean alertIsPresented() {
        return alert.isDisplayed();
    }
}
