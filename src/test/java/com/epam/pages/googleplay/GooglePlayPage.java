package com.epam.pages.googleplay;

import com.epam.core.page.BasePage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePlayPage extends BasePage {
    private final Logger logger = getLogger();

    @FindBy(css = "h1[itemprop='name'] span")
    private WebElement courseraAppTitle;

    public String getCourseraAppTitle() {
        String courseraAppName = courseraAppTitle.getText();
        logger.info("coursera app title at google play page: {}", courseraAppName);
        return courseraAppName;
    }
}
