package com.epam.pages.coursera;

import com.epam.core.page.BasePage;
import com.epam.core.utilities.service.TabsSwitcher;
import com.epam.core.utilities.service.WaitersService;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class CourseraHelpCenterPage extends BasePage {
    private final Logger logger = getLogger();

    @FindBy(xpath = "//*[@class='input-group input-group-lg']//*[@class='form-control']")
    private WebElement searchField;

    @FindBy(xpath = "//*[@class='input-group input-group-lg']//*[@class='input-group-btn']")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@class='search-result-link']")
    private List<WebElement> searchResults;

    @FindBy(css = ".category h3")
    private List<WebElement> helpTopics;

    @FindBy(css = ".article-list li")
    private List<WebElement> helpArticles;

    @FindBy(css = "a[title='Yes']")
    private WebElement voteUpButton;

    @FindBy(css = ".article-voted")
    private WebElement voted;

    @FindBy(xpath = "//*[contains(@class, 'shopping-cart')]")
    private WebElement paymentsButton;

    public void fillingOutTheSearchFormWithData(final String data) {
        logger.info("entering data in the search field");
        searchField.sendKeys(data);
    }

    public void searchForData() {
        logger.info("click on the search button");
        searchButton.click();
    }

    public String getRealSearchData() {
        logger.info("get real search data");
        WaitersService.waitForListOfWebElementsVisibility(getDriver(), searchResults);
        return searchResults.get(0).getText();
    }

    public void chooseHelpTopic() {
        logger.info("choose help topic");
        WaitersService.waitForListOfWebElementsVisibility(getDriver(), helpTopics);
        helpTopics.get(0).click();
    }

    public void chooseHelpArticle() {
        logger.info("choose help article");
        WaitersService.waitForListOfWebElementsVisibility(getDriver(), helpArticles);
        helpArticles.get(0).click();
    }

    public void clickVoteUpButton() {
        logger.info("click vote up button");
        voteUpButton.click();
    }

    public String getVotedColor() {
        String votedColor = voted.getCssValue("background-color");
        logger.info("voted color: {}", votedColor);
        return votedColor;
    }

    public void clickVoted() {
        logger.info("click voted button");
        voted.click();
    }

    public void clickPaymentsButtonAndSwitchToNewTab() {
        WaitersService.waitForVisibilityOfElement(getDriver(), paymentsButton);
        getActions().moveToElement(paymentsButton).pause(getPauseTime()).click().build().perform();
        logger.info("Payments button is clicked, new tab is opening");
        TabsSwitcher.switchToNewTab(getDriver());
    }
}
