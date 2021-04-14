package com.epam.pages.coursera;

import com.epam.core.page.BasePage;
import com.epam.core.utilities.service.TabsSwitcher;
import com.epam.core.utilities.service.WaitersService;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CourseraCourseDescriptionPage extends BasePage {
    private final Logger logger = getLogger();

    @FindBy(css = ".EnrollButton")
    private WebElement enrollButton;

    @FindBy(css = ".subscribe-button")
    private WebElement startFreeTrialButton;

    public void clickEnrollForFreeButton() {
        TabsSwitcher.switchToNewTab(getDriver());
        logger.info("click on enroll for free button");
        WaitersService.waitForElementToBeClickable(getDriver(), enrollButton);
        enrollButton.click();
    }

    public void clickStartFreeTrialButton() {
        logger.info("click on start free trial button");
        startFreeTrialButton.click();
    }
}
