package com.epam.pages.coursera;

import com.epam.core.page.BasePage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CourseraSoftwareTestingPage extends BasePage {
    private final Logger logger = getLogger();

    @FindBy(xpath = "//*[@alt='Coursera']")
    private WebElement courseraMainButton;

    public void clickCourseraMainButton() {
        logger.info("open https://www.coursera.org/ page");
        courseraMainButton.click();
    }
}
