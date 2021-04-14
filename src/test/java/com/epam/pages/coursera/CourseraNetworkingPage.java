package com.epam.pages.coursera;

import com.epam.core.page.BasePage;
import com.epam.core.utilities.service.WaitersService;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CourseraNetworkingPage extends BasePage {
    private static final String LOCATOR_TEXT = "//*[@data-track-component='show_more_skills']";
    private static final int PIXELS_NUMBER = 500;
    private final Logger logger = getLogger();

    @FindBy(xpath = LOCATOR_TEXT)
    private WebElement showMoreSkillsButton;

    @FindBy(xpath = "//*[contains(@title,'Software Testing')]")
    private WebElement softwareTestingButton;

    public void clickOnShowMoreButtonTwiceUnderSkillsField() {
        WaitersService.waitForVisibilityOfElement(getDriver(), showMoreSkillsButton);
        logger.info("show more skills");
        WaitersService.waitUntilPresenceOfElementAndReturn(getDriver(), By.xpath(LOCATOR_TEXT));
        WaitersService.waitForElementToBeClickable(getDriver(), showMoreSkillsButton);
        showMoreSkillsButton.click();
        pageScrollDown(PIXELS_NUMBER);
        WaitersService.waitForElementToBeClickable(getDriver(), showMoreSkillsButton);
        showMoreSkillsButton.click();
    }

    public void clickSoftwareTestingInSkills() {
        logger.info("open Software Testing page");
        softwareTestingButton.click();
    }
}
