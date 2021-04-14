package com.epam.pages.coursera;

import com.epam.core.page.BasePage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CourseraAppStorePage extends BasePage {
    private final Logger logger = getLogger();

    @FindBy(xpath = "//*[contains(@class, 'title__product')]")
    private WebElement titleProduct;

    @FindBy(xpath = "//*[contains(@class,'app-header')]//a")
    private WebElement applicationName;

    public String getTitleName() {
        return titleProduct.getText();
    }

    public String getAppName() {
        return applicationName.getText();
    }

    public boolean isItCourseraInAppStore(final String appStoreName, final String courseraName) {
        logger.info("compare expected and real values");
         return getTitleName().equals(appStoreName) && getAppName().equals(courseraName);
    }
}
