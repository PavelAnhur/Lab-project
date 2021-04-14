package com.epam.pages.coursera;

import com.epam.core.page.BasePage;
import com.epam.core.utilities.service.WaitersService;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CourseraSignupPage extends BasePage {
    private static final String TEXT_PATTERN = "//*[contains(text(),'%s')]";
    private final Logger logger = getLogger();

    @FindBy(name = "name")
    private WebElement usernameInput;

    @FindBy(name = "email")
    private WebElement emailInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(css = "[data-track-component='signup_form_submit_button']")
    private WebElement submitButton;

    @FindBy(css = "div[style^='visibility: visible;']")
    private WebElement recaptchaWindow;

    public WebElement getLink(final String linkText) {
        logger.info("get {} link", linkText);
        return WaitersService.waitUntilPresenceOfElementAndReturn(getDriver(),
                By.xpath(String.format(TEXT_PATTERN, linkText)));
    }

    public void signUp(final String username, final String email, final String password) {
        inputUsername(username);
        inputEmail(email);
        inputPassword(password);
        clickSubmitButton();
    }

    private void inputUsername(final String username) {
        logger.info("enter username: {}", username);
        usernameInput.sendKeys(username);
    }

    private void inputEmail(final String email) {
        logger.info("enter email: {}", email);
        emailInput.sendKeys(email);
    }

    private void inputPassword(final String password) {
        logger.info("enter password: {}", password);
        passwordInput.sendKeys(password);
    }

    private void clickSubmitButton() {
        logger.info("click submit button");
        submitButton.click();
    }

    public WebElement getRecaptchaWindow() {
        logger.info("get recaptcha window");
        return recaptchaWindow;
    }
}
