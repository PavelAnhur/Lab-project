package com.epam.pages.coursera;

import com.epam.core.page.BasePage;
import com.epam.core.utilities.service.FrameSwitcher;
import com.epam.core.utilities.service.WaitersService;
import com.epam.core.utilities.service.TabsSwitcher;
import com.epam.core.utilities.service.WebElementsService;
import com.epam.core.utilities.service.ListService;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class CourseraCampusCoursematchPage extends BasePage {
    private final Logger logger = getLogger();

    @FindBy(xpath = "//a[@data-track-action='close']")
    private WebElement closeFormButton;

    @FindBy(xpath = "//button[@lk-track-name='dashboard']")
    private WebElement runButton;

    @FindBy(xpath = "//iframe[@title='Looker Dashboard']")
    private WebElement frame;

    @FindBy(css = ".vis .measure .drillable-item-content")
    private List<WebElement> relevanceScoreColumn;

    @FindBy(xpath = "//*[contains(@href, 'technical-writing')]")
    private WebElement firstResultLink;

    public void closeForm() {
        logger.info("The form is closing");
        WaitersService.waitForElementToBeClickable(getDriver(), closeFormButton);
        closeFormButton.click();
    }

    public String getFirstResultCourseName() {
        WaitersService.threadSleep(getPauseTime());
        FrameSwitcher.switchToFrameWithWait(getDriver(), frame);
        WaitersService.waitForVisibilityOfElement(getDriver(), firstResultLink);
        return firstResultLink.getText();
    }

    public void clickFirstResultAndSwitchToNewTab() {
        logger.info("First result course page is opening");
        firstResultLink.click();
        TabsSwitcher.switchToNewTab(getDriver());
    }

    public boolean areElementsFromRelevantScoreInDescendingOrder() {
        FrameSwitcher.switchToFrameWithWait(getDriver(), frame);
        logger.info("read values from the table");
        WaitersService.threadSleep(getPauseTime());
        List<Double> scoreList = WebElementsService.getListOfDoubleFromElementsText(relevanceScoreColumn);
        logger.info("check the order of elements");
        double maxValue = 1.0;
        boolean result = ListService.isListDoubleInDescendingOrder(scoreList, maxValue);
        logger.info("Values from relevant score column of the table in descending order: {}", result);
        return result;
    }
}
