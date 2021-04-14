package com.epam.pages.coursera;

import com.epam.core.page.BasePage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CourseraPrivacyNoticePage extends BasePage {
    private final Logger logger = getLogger();

    @FindBy(css = "#privacy-notice h1")
    private WebElement privacyNoticeTitle;

    public String getPrivacyNoticeTitleAsText() {
        String privacyNoticePageTitle = privacyNoticeTitle.getText();
        logger.info("privacy notice page title: {}", privacyNoticePageTitle);
        return privacyNoticePageTitle;
    }
}
