package com.epam.pages.coursera;

import com.epam.core.page.BasePage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CourseraTermsOfUsePage extends BasePage {
    private final Logger logger = getLogger();

    @FindBy(css = "#terms-of-use h1")
    private WebElement termsOfUseTitle;

    public String getTermsOfUseTitleAsText() {
        String termsOfUsePageTitle = termsOfUseTitle.getText();
        logger.info("terms of use page title: {}", termsOfUsePageTitle);
        return termsOfUsePageTitle;
    }
}
