package com.epam.pages.coursera;

import com.epam.core.page.BasePage;
import com.epam.core.utilities.service.WaitersService;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CourseraPersonalDevelopmentPage extends BasePage {
    private static final String PAGE_URL = "https://www.coursera.org/browse/personal-development";
    private final Logger logger = getLogger();

    @FindBy(xpath = "//button[@class='question']")
    private WebElement question;

    @FindBy(xpath = "//*[contains(@class, 'answer')]")
    private WebElement answerToQuestion;

    @Override
    public void openPage() {
        logger.info("Opening personal development page");
        getDriver().get(PAGE_URL);
    }

    public void clickQuestionButton() {
        logger.info("Clicking first question");
        question.click();
    }

    public boolean answerIsShown() {
        WaitersService.waitForVisibilityOfElement(getDriver(), answerToQuestion);
        return answerToQuestion.isDisplayed();
    }
}
