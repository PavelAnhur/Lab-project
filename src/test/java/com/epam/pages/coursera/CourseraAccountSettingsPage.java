package com.epam.pages.coursera;

import com.epam.core.page.BasePage;
import com.epam.core.utilities.service.WaitersService;
import com.epam.core.utilities.service.WebElementsService;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CourseraAccountSettingsPage extends BasePage {
    private final Logger logger = getLogger();

    @FindBy(css = "a[href='/user-verification']")
    private WebElement userVerificationButton;

    @FindBy(css = ".rc-JumioVerificationSettings span")
    private WebElement verificationMessage;

    @FindBy(id = "settings-basic-full-name")
    private WebElement fullNameField;

    @FindBy(xpath = "//button[text()='Save']")
    private WebElement saveButton;

    @FindBy(xpath = "//span[@class='rc-StatusMessage success']")
    private WebElement statusMessage;

    @FindBy(name = "timezone")
    private WebElement timezoneField;

    @FindBy(xpath = "//*[@name='timezone']//option")
    private List<WebElement> listTimezone;

    @FindBy(xpath = "//button[contains(@class, 'rc-SaveButton') and @type='submit']")
    private WebElement buttonSave;

    @FindBy(xpath = "//*[@name='timezone']//option[@selected]")
    private WebElement realTimezone;

    @FindBy(name = "locale")
    private WebElement languageField;

    @FindBy(xpath = "//*[@name='locale']//option[contains(@value, 'ru')]")
    private WebElement languageRussian;

    @FindBy(xpath = "//*[@name='locale']//option[contains(@value, 'en')]")
    private WebElement languageEnglish;

    @FindBy(xpath = "//*[@name='locale']//option[@selected]")
    private WebElement realLanguage;

    @FindBy(xpath = "//button[@class='secondary cozy settings-primary-action']")
    private WebElement deleteAccountButton;

    @FindBy(xpath = "//button[@data-track-component='delink_google']")
    private WebElement detachMyGoogleAccountButton;

    @FindBy(id = "password")
    private WebElement passwordFieldUpToDelinkGoogleAccountButton;

    @FindBy(xpath = "//*[contains(@class,'StatusMessage error')]")
    private WebElement statusMessageErrorElement;

    @FindBy(id = "deletion-disclaimer-login")
    private WebElement deletionDisclaimerLoginCheckbox;

    @FindBy(id = "deletion-disclaimer-anonymized")
    private WebElement deletionDisclaimerAnonymizedCheckbox;

    @FindBy(id = "deletion-disclaimer-certificates")
    private WebElement deletionDisclaimerCertificatesCheckbox;

    @FindBy(xpath = "//*[@class='c-modal-content']//input[@class='account-password-input']")
    private WebElement passwordFieldInDeletingYourAccountForm;

    @FindBy(xpath = "//*[@class='c-modal-content']//button[@class='primary delete-action']")
    private WebElement confirmDeleteYourAccountButton;

    @FindBy(id = "settings-password-current")
    private WebElement currentPassword;

    @FindBy(id = "settings-password-new")
    private WebElement newPassword;

    @FindBy(id = "settings-password-new-confirm")
    private WebElement confirmNewPassword;

    @FindBy(xpath = "//*[@type='button' and contains(@class, 'rc-SaveButton')]")
    private WebElement savePasswordButton;

    @FindBy(xpath = "//*[@class='rc-StatusMessage success']")
    private WebElement successSave;

    @FindBy(xpath = "//*[contains(@class, 'send-report')]")
    private WebElement sendReportButton;

    @FindBy(xpath = "//*[contains(@class, 'send-data-report')]")
    private WebElement confirmationSendReport;

    @FindBy(xpath = "//*[@data-e2e='close-modal-button']")
    private WebElement closeDataReport;

    public void clickUserVerificationButton() {
        logger.info("click user verification button");
        userVerificationButton.click();
    }

    public String getVerificationMessage() {
        WaitersService.waitForVisibilityOfElement(getDriver(), verificationMessage);
        String verificationString = verificationMessage.getText();
        logger.info("received verification message: {}", verificationString);
        return verificationString;
    }

    public void erasePreviousFullName() {
        fullNameField.click();
        logger.info("previous name is erased");
        fullNameField.clear();
    }

    public void enterNewFullNameAndSave(final String newFullName) {
        logger.info("new full name is entered");
        getActions().sendKeys(fullNameField, newFullName).click(saveButton).build().perform();
    }

    public String getStatusMessage() {
        return statusMessage.getText();
    }

    public void clickTimezoneField() {
        logger.info("click the field timezone");
        timezoneField.click();
    }

    public void setTimezone(final String timezoneName) {
        WaitersService.waitForListOfWebElementsVisibility(getDriver(), listTimezone);
        WebElementsService.clickToElementFromListByName(listTimezone, timezoneName);
    }

    public void clickButtonSave() {
        logger.info("click the button save");
        buttonSave.click();
    }

    public void refresh() {
        logger.info("refresh the page");
        getDriver().navigate().refresh();
    }

    public String getRealTimezone() {
        return realTimezone.getText();
    }

    public String changeTimezone(final String minsk, final String kiev) {
        if (realTimezone.getText().contains(minsk)) {
            clickTimezoneField();
            setTimezone(kiev);
            return kiev;
        } else {
            clickTimezoneField();
            setTimezone(minsk);
            return minsk;
        }
    }

    public void clickLanguageField() {
        logger.info("click the field language");
        languageField.click();
    }

    public String getRealLanguage() {
        return realLanguage.getAttribute("value");
    }

    public String changeLanguage(final String english, final String russian) {
        clickLanguageField();
        if (realLanguage.getAttribute("value").contains(english)) {
            languageRussian.click();
            return russian;
        } else {
            languageEnglish.click();
            return english;
        }
    }

    public void clickDeleteAccountButton(final String password) {
        logger.info("click on delete account button");
        clickDeleteButton();
        if (statusMessageErrorElement.isDisplayed()) {
            detachGoogleAccount(password);
        }
    }

    public void clickDeleteButton() {
        WebElementsService.scrollToElementAndClickToIt(deleteAccountButton);
    }

    private void detachGoogleAccount(final String password) {
        logger.info("Detach Google account");
        detachMyGoogleAccountButton.click();
        try {
            logger.info("Enter password: {}", password);
            WaitersService.waitForElementToBeClickableAndReturn(getDriver(), passwordFieldUpToDelinkGoogleAccountButton)
                    .sendKeys(password + Keys.ENTER);
        } catch (NoSuchElementException | TimeoutException exception) {
            logger.debug("password field didn't appear");
        }
        getDriver().navigate().refresh();
        logger.info("Click on delete account button");
        deleteAccountButton.click();
    }

    public void selectAllCheckboxesInDeletingYourAccountWindow() {
        logger.info("Select all checkboxes");
        WaitersService.waitUntilPageIsCompletelyLoaded(getDriver());
        WaitersService.waitForElementToBeClickableAndReturn(getDriver(), deletionDisclaimerLoginCheckbox).click();
        deletionDisclaimerAnonymizedCheckbox.click();
        deletionDisclaimerCertificatesCheckbox.click();
    }

    public void enterPasswordInDeletingYourAccountWindow(final String password) {
        logger.info("Confirm password: {}", password);
        passwordFieldInDeletingYourAccountForm.sendKeys(password);
    }

    public void confirmDeleteYourAccount() {
        logger.info("Confirm delete account");
        confirmDeleteYourAccountButton.click();
        logger.info("Delete all cookies");
        getDriver().manage().deleteAllCookies();
    }

    public void inputCurrentPassword(final String password) {
        logger.info("set the field current password");
        currentPassword.sendKeys(password);
    }

    public void inputNewPassword(final String password) {
        logger.info("set the field new password");
        newPassword.sendKeys(password);
        logger.info("confirm new password");
        confirmNewPassword.sendKeys(password);
    }

    public void saveNewPassword() {
        logger.info("click the button save");
        WaitersService.waitForElementToBeClickableAndReturn(getDriver(), savePasswordButton).click();
    }

    public String getMassageAboutSave() {
        return successSave.getAttribute("class");
    }

    public void clickSendReportButton() {
        logger.info("click the button send report");
        sendReportButton.click();
    }

    public boolean confirmSendDataReport() {
        logger.info("click confirmation the report send");
        confirmationSendReport.click();
        try {
            logger.info("the report has already been sent");
            closeDataReport.click();
            return false;
        } catch (Exception ex) {
            logger.info("the report sent");
            return true;
        }
    }
}
