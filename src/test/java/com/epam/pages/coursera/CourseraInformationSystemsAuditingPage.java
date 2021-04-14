package com.epam.pages.coursera;

import com.epam.core.page.BasePage;
import com.epam.core.utilities.service.WaitersService;
import com.epam.core.utilities.service.WebElementsService;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CourseraInformationSystemsAuditingPage extends BasePage {
    private final Logger logger = getLogger();

    @FindBy(xpath = "//*[contains(@aria-label,'Introduction to Information Systems (IS) Auditing')]")
    private WebElement seeAllButton;

    @FindBy(xpath = "//*[contains(@data-track-href,'course-overview')]")
    private WebElement courseOverviewVideoLink;

    public void clickSeeAllButtonInSyllabusSection() {
        logger.info("click on SEE ALL button in Syllabus");
        WaitersService.waitForElementToBeClickable(getDriver(), seeAllButton);
        WebElementsService.clickIgnoringStale(seeAllButton);
    }

    public void clickCourseOverviewVideoLink() {
        logger.info("click on Course Overview link");
        try {
            courseOverviewVideoLink.click();
        } catch (ElementNotInteractableException exception) {
            logger.debug("See all button was not clicked");
            getDriver().navigate().refresh();
            clickSeeAllButtonInSyllabusSection();
            courseOverviewVideoLink.click();
        }
    }
}
