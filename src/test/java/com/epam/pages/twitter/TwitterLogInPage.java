package com.epam.pages.twitter;

import com.epam.core.page.BasePage;
import com.epam.core.utilities.service.WaitersService;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class TwitterLogInPage extends BasePage {
    private final Logger logger = getLogger();

    @FindBy(xpath = "//*[@name='session[username_or_email]']")
    private WebElement loginField;

    @FindBy(xpath = "//input[@name='session[password]']")
    private WebElement passwordField;

    @FindBy(xpath = "//span[text()='Log in']")
    private List<WebElement> logInButtons;

    @FindBy(xpath = "//*[@data-testid='LoginForm_Login_Button']")
    private WebElement logInButton;

    public void enterLoginAndPassword(final String login, final String password) {
        logger.info("Entering valid login and password");
        WaitersService.waitUntilPageIsCompletelyLoaded(getDriver());
        WaitersService.waitForElementToBeClickable(getDriver(), loginField);
        getActions().sendKeys(loginField, login).sendKeys(passwordField, password).build().perform();
    }

    public void clickSignInButton() {
        logger.info("Clicking log in button");
        WaitersService.waitForElementToBeClickable(getDriver(), logInButtons.get(1));
        logInButtons.get(1).click();
    }

    public void clickLogInButton() {
        logger.info("Clicking log in button");
        logInButton.click();
    }
}
