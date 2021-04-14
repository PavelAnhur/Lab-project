package com.epam.pages.coursera;

import com.epam.core.page.BasePage;
import com.epam.core.utilities.service.TabsSwitcher;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CourseraForCampusPage extends BasePage {
    private static final String PAGE_URL = "https://www.coursera.org/campus";
    private final Logger logger = getLogger();

    @FindBy(xpath = "//a[text()='See how our content maps to your university’s curriculum']")
    private WebElement coursematchButton;

    public void clickCoursematchButton() {
        logger.info("Coursematch page is opened");
        coursematchButton.click();
        TabsSwitcher.switchToNewTab(getDriver());
    }

    @Override
    public void openPage() {
        logger.info("Coursera for campus page is opening");
        getDriver().get(PAGE_URL);
    }
}
