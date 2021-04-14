package com.epam.pages.twitter;

import com.epam.core.page.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TweetPage extends BasePage {

    @FindBy(xpath = "//div[@role='dialog']")
    private WebElement tweetWindow;

    @FindBy(xpath = "//div[@data-testid='tweetTextarea_0']")
    private WebElement tweetText;

    @FindBy(xpath = "//div[@data-testid='tweetButton']")
    private WebElement tweetButton;

    public boolean tweetWindowISDisplayed() {
        return tweetWindow.isDisplayed();
    }

    public String getTweetText() {
        return tweetText.getText();
    }

    public boolean tweetButtonIsClickable() {
        return tweetButton.isEnabled();
    }
}
