package com.epam.pages.coursera;

import com.epam.core.page.BasePage;
import com.epam.core.utilities.service.StringService;
import com.epam.core.utilities.service.TabsSwitcher;
import com.epam.core.utilities.service.WaitersService;
import com.epam.core.utilities.service.WebElementsService;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CourseraCommunityPage extends BasePage {
    private static final By LEADERBOARD_LOCATOR = By.xpath("//*[contains(@href, 'leaderboard')]");
    private final Logger logger = getLogger();

    @FindBy(xpath = "//*[@class='sidebar-link']")
    private WebElement howToUseCommunityButton;

    @FindBy(xpath = "//*[@class='btn js-cookie-accept']")
    private WebElement acceptCookiesButton;

    @FindBy(css = ".instant-search__filter-dismiss")
    private WebElement closeTagsFilterButton;

    @FindBy(css = ".topic-type-checkbox")
    private WebElement communityCheckbox;

    @FindBy(xpath = "//*[text()='Learner Help Center']")
    private WebElement learnerHelpCenterCheckbox;

    @FindBy(xpath = "//*[text()='Question']")
    private WebElement questionCheckbox;

    @FindBy(xpath = "//*[text()='Discussion']")
    private WebElement discussionCheckbox;

    @FindBy(xpath = "//*[text()='Article']")
    private WebElement articleCheckbox;

    @FindBy(xpath = "//*[text()='Idea']")
    private WebElement ideaCheckbox;

    @FindBy(xpath = "//*[text()='Event']")
    private WebElement eventCheckbox;

    @FindBy(xpath = "//*[text()='Question']/../following-sibling::div[@class='instant-search__results-count ']")
    private WebElement questionResultCountElement;

    @FindBy(xpath = "//*[text()='Discussion']/../following-sibling::div[@class='instant-search__results-count ']")
    private WebElement discussionResultCountElement;

    @FindBy(xpath = "//*[text()='Article']/../following-sibling::div[@class='instant-search__results-count ']")
    private WebElement articleResultCountElement;

    @FindBy(xpath = "//*[text()='Idea']/../following-sibling::div[@class='instant-search__results-count ']")
    private WebElement ideaResultCountElement;

    @FindBy(xpath = "//*[text()='Event']/../following-sibling::div[@class='instant-search__results-count ']")
    private WebElement eventResultCountElement;

    @FindBy(css = ".list__items--topic-count")
    private WebElement totalTopicsCountElement;

    public void clickHowToUseCommunityButton() {
        acceptCookiesOnPage();
        logger.info("click 'How to use Community' button");
        WaitersService.waitUntilPresenceOfElementAndReturn(getDriver(), LEADERBOARD_LOCATOR);
        WebElementsService.scrollToElementAndClickToIt(howToUseCommunityButton);
        TabsSwitcher.switchToNewTab(getDriver());
    }

    private void acceptCookiesOnPage() {
        try {
            logger.info("accept cookies on page");
            WaitersService.waitForElementToBeClickableAndReturn(getDriver(), acceptCookiesButton).click();
        } catch (TimeoutException exception) {
            logger.debug("accept cookies form didn't show");
        }
    }

    public CourseraCommunityPage closeTagsFilter() {
        logger.info("close Tags filter");
        WaitersService.waitForElementToBeClickableAndReturn(getDriver(), closeTagsFilterButton).click();
        return this;
    }

    public CourseraCommunityPage selectCommunityCheckbox() {
        logger.info("select Community checkbox");
        WaitersService.waitForElementToBeClickableAndReturn(getDriver(), communityCheckbox).click();
        return this;
    }

    public CourseraCommunityPage selectLearnerHelpCenterCheckbox() {
        logger.info("select Learner Help Center checkbox");
        learnerHelpCenterCheckbox.click();
        return this;
    }

    public CourseraCommunityPage selectQuestionCheckbox() {
        logger.info("select Question checkbox");
        questionCheckbox.click();
        return this;
    }

    public CourseraCommunityPage selectDiscussionCheckbox() {
        logger.info("select Discussion checkbox");
        discussionCheckbox.click();
        return this;
    }

    public CourseraCommunityPage selectArticleCheckbox() {
        logger.info("select Article checkbox");
        articleCheckbox.click();
        return this;
    }

    public CourseraCommunityPage selectIdeaCheckbox() {
        logger.info("select Idea checkbox");
        ideaCheckbox.click();
        return this;
    }

    public void selectEventCheckbox() {
        logger.info("select Event checkbox");
        eventCheckbox.click();
    }

    public int getTotalTopicsNumberFromCheckboxes() {
        int totalTopicsNumber = getQuestionTopicsNumber()
                + getDiscussionTopicsNumber()
                + getArticleTopicsNumber()
                + getIdeaTopicsNumber()
                + getEventTopicsNumber();
        logger.debug("total topics number from checkboxes = {}", totalTopicsNumber);
        return totalTopicsNumber;
    }

    public int getTotalTopicsNumberFromFilterElement() {
        int totalTopicsNumberFromFilter = Integer.parseInt(
                StringService.getFirstWordFromString(totalTopicsCountElement.getText(), " "));
        logger.debug("total topics number from filter = {}", totalTopicsNumberFromFilter);
        return totalTopicsNumberFromFilter;
    }

    private int getQuestionTopicsNumber() {
        int questionTopicsNumber = Integer.parseInt(questionResultCountElement.getText());
        logger.debug("Question topics number = {}", questionTopicsNumber);
        return questionTopicsNumber;
    }

    private int getDiscussionTopicsNumber() {
        int discussionTopicsNumber = Integer.parseInt(discussionResultCountElement.getText());
        logger.debug("Discussion topics number = {}", discussionTopicsNumber);
        return discussionTopicsNumber;
    }

    private int getArticleTopicsNumber() {
        int articleTopicsNumber = Integer.parseInt(articleResultCountElement.getText());
        logger.debug("Article topics number = {}", articleTopicsNumber);
        return articleTopicsNumber;
    }

    private int getIdeaTopicsNumber() {
        int ideaTopicsNumber = Integer.parseInt(ideaResultCountElement.getText());
        logger.debug("Idea topics number = {}", ideaTopicsNumber);
        return ideaTopicsNumber;
    }

    private int getEventTopicsNumber() {
        int eventTopicsNumber = Integer.parseInt(eventResultCountElement.getText());
        logger.debug("Event topics number = {}", eventTopicsNumber);
        return eventTopicsNumber;
    }
}
