package com.epam.pages.coursera;

import com.epam.core.page.BasePage;
import com.epam.core.utilities.service.WaitersService;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CourseraBasketCoursesPage extends BasePage {
    private final Logger logger = getLogger();

    @FindBy(xpath = "//*[@data-e2e='dropdown-menu']")
    private WebElement dropDownMenu;

    @FindBy(xpath = "//*[@data-e2e='dropdown-option-uneroll']")
    private WebElement unenrollButton;

    @FindBy(xpath = "//*[@data-e2e='unenroll-button-logged-in-home']")
    private WebElement confirmUnenrollButton;

    @FindBy(xpath = "//*[@class='card-header-text bold-text uppercase-text']")
    private WebElement cardCourse;

    public void unenrollCourse() {
        logger.info("open drop-down menu");
        WaitersService.waitForElementToBeClickable(getDriver(), dropDownMenu);
        dropDownMenu.click();
        logger.info("click the button unenroll");
        unenrollButton.click();
    }

    public void confirmUnenroll() {
        logger.info("click the button unenroll");
        confirmUnenrollButton.click();
        getDriver().navigate().refresh();
    }

    public boolean wasCourseCanceled(final String course) {
        try {
            cardCourse.getText().equals(course);
            return false;
        } catch (Exception ex) {
            return true;
        }
    }
}

