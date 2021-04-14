package com.epam.pages.coursera;

import com.epam.core.page.BasePage;
import com.epam.core.utilities.service.WebElementsService;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CourseraUserVerificationPage extends BasePage {
    private final Logger logger = getLogger();

    @FindBy(id = "first-name-input")
    private WebElement firstNameInput;

    @FindBy(id = "middle-name-input")
    private WebElement middleNameInput;

    @FindBy(id = "last-name-input")
    private WebElement lastNameInput;

    @FindBy(css = "button[style='float:right']")
    private WebElement submitButton;

    public void enterFirstName(final String firstName) {
        logger.info("enter first name: {}", firstName);
        WebElementsService.clearInputFieldAndSendNewValue(firstNameInput, firstName);
    }

    public void enterMiddleName(final String middleName) {
        logger.info("enter middle name: {}", middleName);
        WebElementsService.clearInputFieldAndSendNewValue(middleNameInput, middleName);
    }

    public void enterLastName(final String lastName) {
        logger.info("enter last name: {}", lastName);
        WebElementsService.clearInputFieldAndSendNewValue(lastNameInput, lastName);
    }

    public void clickSubmitButton() {
        logger.info("click submit button");
        submitButton.click();
    }
}
