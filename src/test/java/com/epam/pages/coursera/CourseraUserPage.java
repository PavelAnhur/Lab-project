package com.epam.pages.coursera;

import com.epam.core.page.BasePage;
import com.epam.core.utilities.service.TabsSwitcher;
import com.epam.core.utilities.service.WaitersService;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CourseraUserPage extends BasePage {
    private final Logger logger = getLogger();

    @FindBy(css = "span[class$='username']")
    private WebElement loggedInUser;

    @FindBy(css = "ul[id$='dropdown'] #account-settings-link")
    private WebElement settingsButton;

    @FindBy(xpath = "//*[contains(@class,'btn isLohpRebrand')]//a[contains(@to, 'https://learner.coursera.help')]")
    private WebElement helpCenterButton;

    @FindBy(xpath = "//div[@class='rc-NotificationCenter']")
    private WebElement bellButton;

    @FindBy(xpath = "//*[@class='rc-NotificationListEmpty']//h2")
    private WebElement noteContent;

    @FindBy(xpath = "//button[@id='logout-btn' and @tabindex]")
    private WebElement logoutButton;

    @FindBy(xpath = "//*[@id = 'profile-link' and @tabindex]")
    private WebElement profileButton;

    @FindBy(css = "a[data-click-key$='link_help']")
    private WebElement helpCenterLink;

    @FindBy(xpath = "//ul[@role='menu']//*[@data-e2e='item-coursera-for-business']")
    private WebElement courseraForBusinessButton;

    @FindBy(xpath = "//*[contains(@class, 'c-navbar-item bt3-nav bt3-navbar-nav')]")
    private List<WebElement> listForEnterprise;

    @FindBy(xpath = "//*[@class='c-ph-enterprise__svg']")
    private WebElement listDown;

    @FindBy(css = "a[data-click-key$='ios'] img")
    private WebElement appStoreButton;

    @FindBy(xpath = "//*[@aria-autocomplete='list' and @role='textbox']")
    private WebElement fieldForSearch;

    @FindBy(xpath = "//*[@data-track-component='onboarding_skip_button']")
    private WebElement onboardSkipButton;

    public void closeOnboardForm() {
        try {
            logger.info("close onboard form");
            onboardSkipButton.click();
        } catch (NoSuchElementException | TimeoutException exception) {
            logger.debug("onboard form doesn't appear!");
        }
    }

    public void clickLogoutButtonInUserMenu() {
        getActions().moveToElement(logoutButton)
                .pause(getPauseTime())
                .click()
                .build()
                .perform();
        logger.info("Log out button is selected");
        getDriver().manage().deleteAllCookies();
        logger.info("Cookies are deleted");
    }

    public String getLoggedInUserName() {
        WaitersService.waitForVisibilityOfElement(getDriver(), loggedInUser);
        String loggedInUsername = loggedInUser.getText();
        logger.info("logged in with username: {}", loggedInUsername);
        return loggedInUsername;
    }

    public void clickOnLoggedInUser() {
        logger.info("click on the logged in username");
        WaitersService.waitForElementToBeClickableAndReturn(getDriver(), loggedInUser).click();
    }

    public void clickSettingsButton() {
        logger.info("click on settings button");
        settingsButton.click();
    }

    public void goToHelpCenter() {
        logger.info("click on the logged in username");
        loggedInUser.click();
        logger.info("click on the help center button");
        helpCenterButton.click();
        logger.info("switch to another tab");
        TabsSwitcher.switchToNewTab(getDriver());
    }

    public void clickTheBellButton() {
        logger.info("click on the bell button");
        bellButton.click();
    }

    public String getNotificationContent() {
        WaitersService.waitForVisibilityOfElement(getDriver(), noteContent);
        return noteContent.getText();
    }

    public void clickProfileButton() {
        profileButton.click();
        WaitersService.waitUntilPageIsCompletelyLoaded(getDriver());
    }

    public void clickHelpCenterLink() {
        logger.info("click on help center link");
        WaitersService.waitForElementToBeClickableAndReturn(getDriver(), helpCenterLink).click();
    }

    public void waitUntilUserIsLoggedIn() {
        WaitersService.waitForVisibilityOfElement(getDriver(), loggedInUser);
    }

    public void goToCourseraForBusiness() {
        logger.info("choose coursera for enterprise or coursera for business");
        WaitersService.waitForListOfWebElementsVisibility(getDriver(), listForEnterprise);
        listForEnterprise.get(0).click();
        try {
            logger.info("choose coursera for business");
            courseraForBusinessButton.click();
            logger.info("switch to another tab");
            TabsSwitcher.switchToNewTab(getDriver());
        } catch (Exception e) {
            logger.info("chose coursera for business without down list");
        }
    }

    public void clickAppStoreButton() {
        logger.info("click on app store button");
        WaitersService.waitForElementToBeClickable(getDriver(), appStoreButton);
        appStoreButton.click();
    }

    public void inputCourseForSearch(final String courseName) {
        waitUntilUserIsLoggedIn();
        logger.info("input data in the search field");
        fieldForSearch.sendKeys(courseName + Keys.ENTER);
    }

    public void goToCourseraForStudent() {
        logger.info("click on the button coursera for student");
        WaitersService.waitForListOfWebElementsVisibility(getDriver(), listForEnterprise);
        WaitersService.waitForElementToBeClickableAndReturn(getDriver(), listForEnterprise.get(1)).click();
    }
}
