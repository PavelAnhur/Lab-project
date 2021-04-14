package com.epam.pages.coursera;

import com.epam.core.model.User;
import com.epam.core.page.BasePage;
import com.epam.core.utilities.service.WaitersService;
import com.epam.core.utilities.service.WindowsService;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.Set;

public class CourseraLoginPage extends BasePage {
    private final Logger logger = getLogger();

    @FindBy(xpath = "//button[contains(@data-track-component,'continue_with_google')]")
    private WebElement googleButton;

    @FindBy(id = "identifierId")
    private WebElement emailInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@id='identifierNext']//button")
    private WebElement loginNextButton;

    @FindBy(xpath = "//*[@id='passwordNext']//button")
    private WebElement passwordNextButton;

    public void loginWithGoogleAccount(final String email, final String password) {
        String originalWindow = getDriver().getWindowHandle();
        Set<String> windowsSet = getDriver().getWindowHandles();
        googleButton.click();
        String newWindow = WindowsService.getNewWindowHandle(getDriver(), windowsSet);
        getDriver().switchTo().window(newWindow);
        logger.info("log in with email: {}, password: {}", email, password);
        WaitersService.waitForElementToBeClickable(getDriver(), emailInput);
        emailInput.sendKeys(email);
        WaitersService.waitForElementToBeClickable(getDriver(), loginNextButton);
        loginNextButton.click();
        WaitersService.waitForElementToBeClickable(getDriver(), passwordInput);
        passwordInput.sendKeys(password);
        WaitersService.waitForElementToBeClickable(getDriver(), passwordNextButton);
        getActions().moveToElement(passwordNextButton).click().build().perform();
        getDriver().switchTo().window(originalWindow);
    }

    public void loginWithGoogleAccount(final User user) {
        loginWithGoogleAccount(user.getEmail(), user.getPassword());
    }
}
