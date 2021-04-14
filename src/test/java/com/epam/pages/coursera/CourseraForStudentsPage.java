package com.epam.pages.coursera;

import com.epam.core.page.BasePage;
import com.epam.core.utilities.service.TabsSwitcher;
import com.epam.core.utilities.service.WaitersService;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class CourseraForStudentsPage extends BasePage {
    private final Logger logger = getLogger();

    @FindBy(xpath = "//*[@data-track-component='universal_sharing_cta']")
    private WebElement shareButton;

    @FindBy(xpath = "//a[@data-track-component='twitter_share_button']")
    private WebElement twitterButton;

    @FindBy(xpath = "//*[@class='faqList']//li")
    private List<WebElement> listQuestions;

    public void clickShareButton() {
        logger.info("Clicking share to twitter button");
        shareButton.click();
    }

    public void clickTwitterButtonAndSwitchToNewTab() {
        logger.info("Clicking twitter button");
        twitterButton.click();
        TabsSwitcher.switchToNewTab(getDriver());
    }

    public int getQuantityFrequentlyAskedQuestions() {
        WaitersService.waitForListOfWebElementsVisibility(getDriver(), listQuestions);
        return listQuestions.size();
    }

    public boolean isListNotEmpty() {
        logger.info("compare quantity questions with 0");
        return getQuantityFrequentlyAskedQuestions() > 0;
    }
}
