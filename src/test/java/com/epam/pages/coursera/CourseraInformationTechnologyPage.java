package com.epam.pages.coursera;

import com.epam.core.page.BasePage;
import com.epam.core.utilities.service.WaitersService;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CourseraInformationTechnologyPage extends BasePage {
    private static final String INFORMATION_TECHNOLOGY_PAGE_URL
            = "https://www.coursera.org/browse/information-technology";
    private final Logger logger = getLogger();

    @FindBy(xpath = "//*[contains(@data-track-href,'network')]")
    private WebElement networkingButton;

    public void clickNetworkingButton() {
        WaitersService.waitUntilPageIsCompletelyLoaded(getDriver());
        logger.info("open Networking tab");
        getActions()
                .moveToElement(networkingButton)
                .click()
                .build()
                .perform();
    }

    @Override
    public void openPage() {
        getLogger().info("open information technology page");
        getDriver().get(INFORMATION_TECHNOLOGY_PAGE_URL);
    }
}
