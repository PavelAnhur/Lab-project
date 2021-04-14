package com.epam.pages.coursera;

import com.epam.core.page.BasePage;
import com.epam.core.utilities.service.TabsSwitcher;
import com.epam.core.utilities.service.WaitersService;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CourseraCourseOverviewPage extends BasePage {
    private final Logger logger = getLogger();

    @FindBy(xpath = "//*[@data-track-component='click_play_video_button']")
    private WebElement playVideoButton;

    @FindBy(id = "vjs_video_3_html5_api")
    private WebElement videoElement;

    public void clickPlayVideo() {
        TabsSwitcher.switchToNewTab(getDriver());
        logger.info("click on video");
        WaitersService.waitForElementToBeClickable(getDriver(), playVideoButton);
        playVideoButton.click();
    }

    public boolean isVideoOpened() {
        logger.info("video is playing");
        WaitersService.waitForElementToBeClickable(getDriver(), videoElement);
        Double videoPlaytimeBeforeStop = Double.parseDouble(videoElement.getAttribute("currentTime"));
        logger.info("video playtime: {}", videoPlaytimeBeforeStop);
        logger.info("video is stopped");
        WaitersService.waitForElementToBeClickable(getDriver(), videoElement);
        getActions().pause(getPauseTime()).moveToElement(videoElement).click().build().perform();
        Double videoPlaytimeAfterStop = Double.parseDouble(videoElement.getAttribute("currentTime"));
        logger.info("video playtime after stop: {}", videoPlaytimeAfterStop);
        return (videoPlaytimeAfterStop - videoPlaytimeBeforeStop) > 0;
    }
}
