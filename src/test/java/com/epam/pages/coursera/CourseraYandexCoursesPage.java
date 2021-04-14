package com.epam.pages.coursera;

import com.epam.core.page.BasePage;
import com.epam.core.utilities.service.TabsSwitcher;
import com.epam.core.utilities.service.WaitersService;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CourseraYandexCoursesPage extends BasePage {
    private static final int PIXELS = 500;
    private final Logger logger = getLogger();

    @FindBy(xpath = "//*[contains(@href,'machine-learning-applications-big-data')]")
    private WebElement bigDataApplicationsCourseButton;

    @FindBy(xpath = "//*[@class='PartnerList']//*[contains(@class,'rc-Partner__title')]")
    private WebElement partnerTitle;

    public void selectBigDataApplicationsCourse() {
        logger.info("select 'Big Data Applications:Machine Learning at Scale' course");
        WaitersService.waitForElementToBeClickable(getDriver(), bigDataApplicationsCourseButton);
        pageScrollDown(PIXELS);
        getActions().moveToElement(bigDataApplicationsCourseButton).click().build().perform();
        TabsSwitcher.switchToNewTab(getDriver());
    }

    public String getPartnerTitleValue() {
        String partnerTitleValue;
        try {
            partnerTitleValue = partnerTitle.getText();
        } catch (TimeoutException exception) {
            getLogger().info("Course button wasn't clicked");
            bigDataApplicationsCourseButton.click();
            TabsSwitcher.switchToNewTab(getDriver());
            partnerTitleValue = partnerTitle.getText();
        }
        logger.info("this course offered by {}", partnerTitleValue);
        return partnerTitleValue;
    }
}
