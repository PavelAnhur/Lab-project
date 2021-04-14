package com.epam.pages.coursera;

import com.epam.core.page.BasePage;
import com.epam.core.utilities.service.WebElementsService;
import com.epam.core.utilities.service.LocalDateService;
import com.epam.core.utilities.service.TabsSwitcher;
import com.epam.core.utilities.service.WaitersService;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.time.LocalDate;
import java.util.List;

public class CourseraBlogPage extends BasePage {
    private static final int LATEST_POSTS_NUMBER = 100;
    private final Logger logger = getLogger();

    @FindBy(css = ".tag-posts .date")
    private List<WebElement> latestPosts;

    public List<LocalDate> getDatesOfLatestPostsAsListOfLocalDate() {
        return LocalDateService.getLocalDatesFromStringDates(getDatesOfLatestPostsAsListOfStrings());
    }

    private List<String> getDatesOfLatestPostsAsListOfStrings() {
        logger.info("switch to new tab");
        TabsSwitcher.switchBetweenTabs(1);
        logger.info("receive dates as string and add them to list of string");
        loadAtLeastOneHundredLatestPosts();
        logger.info("parse dates from list of string to list of local date");
        return WebElementsService.getListOfWebElementsText(latestPosts);
    }

    private void loadAtLeastOneHundredLatestPosts() {
        while (latestPosts.size() < LATEST_POSTS_NUMBER) {
            logger.info("waiting while one hundred latest posts will load, now loaded: {}", latestPosts.size());
            WaitersService.waitUntilPageIsCompletelyLoaded(getDriver());
            scrollDownToBottom();
            WaitersService.waitUntilVisibilityOfAllElements(getDriver(), latestPosts);
        }
        logger.info("successfully loaded: {}", latestPosts.size());
    }
}
