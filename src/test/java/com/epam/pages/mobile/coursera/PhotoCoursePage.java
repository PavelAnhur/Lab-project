package com.epam.pages.mobile.coursera;

import com.epam.core.enums.EnvironmentType;
import com.epam.core.mobile.base.page.BaseMobilePage;
import com.epam.core.utilities.property.PropertyDataReader;
import com.epam.core.utilities.service.SwipeService;
import com.epam.core.utilities.service.WaitersService;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.TimeoutException;

import java.time.Duration;
import java.util.Properties;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;


public class PhotoCoursePage extends BaseMobilePage {
    private static final Properties PROPERTIES = PropertyDataReader.getProperties(System.getProperty("env"));
    private static final EnvironmentType ENVIRONMENT_TYPE = EnvironmentType.valueOf(
            PROPERTIES.getProperty("env.type").toUpperCase());
    private static final int SPECIFIC_PAUSE = 5000;
    private static final int PAUSE_SECONDS = 5;
    private static final int PAUSE_VIDEO_WAIT = 1;
    private static final String TEXT_TO_BE_PRESENTED = "5 типичных ошибок начинающего фотографа. Промо курса";
    public static final int TAP_WAIT = 10;
    private static final int PRESS_TIME = 900;

    @AndroidFindBy(id = "org.coursera.android:id/download_week_button")
    private MobileElement downloadButton;

    @AndroidFindBy(id = "org.coursera.android:id/element_name")
    private MobileElement videoDescription;

    @AndroidFindBy(id = "org.coursera.android:id/toolbar_title")
    private MobileElement videoTitle;

    @AndroidFindBy(id = "org.coursera.android:id/preview_image_container")
    private MobileElement videoContainer;

    @AndroidFindBy(id = "org.coursera.android:id/resume_button")
    private MobileElement resumeButton;

    @AndroidFindBy(id = "org.coursera.android:id/lottie_forward_overlay")
    private MobileElement forwardOverlay;

    @AndroidFindBy(id = "org.coursera.android:id/time_text")
    private MobileElement timeText;

    @AndroidFindBy(id = "org.coursera.android:id/positive_button")
    private MobileElement positiveDownload;

    @AndroidFindBy(id = "android:id/button1")
    private MobileElement externalStorage;

    @AndroidFindBy(accessibility = "Week 4, Unselected")
    private MobileElement weekFour;


    public void tapDownloadButton() {
        getLogger().info("tap download button");
        WaitersService.waitForVisibilityOfElement(getDriver(), downloadButton);
        getTouchAction().tap(element(downloadButton)).waitAction(waitOptions(ofSeconds(PAUSE_SECONDS))).perform();
        try {
            tapPositiveDownload();
            WaitersService.waitForElementToBeClickable(getDriver(), externalStorage);
            externalStorage.click();
            WaitersService.waitForVisibilityOfElement(getDriver(), weekFour);
            getBack();
            new LearnPage().openCourseHomePage();
            WaitersService.waitForVisibilityOfElement(getDriver(), downloadButton);
            getTouchAction().tap(element(downloadButton)).waitAction(waitOptions(ofSeconds(PAUSE_SECONDS))).perform();
            tapPositiveDownload();
            WaitersService.waitForVisibilityOfElement(getDriver(), weekFour);
        } catch (TimeoutException exception) {
            getLogger().warn("alert wasn't displayed");
        }
    }

    private void tapPositiveDownload() {
        if (System.getProperty("env").equals("nexus-7-2012")) {
            WaitersService.waitForElementToBeClickable(getDriver(), positiveDownload);
            positiveDownload.click();
        }
    }

    public void tapWatchVideo() {
        getLogger().info("resume watching video");
        SwipeService.swipeToElement(videoDescription, PRESS_TIME);
        WaitersService.waitForVisibilityOfElement(getDriver(), videoDescription);
        getTouchAction().tap(element(videoDescription)).perform();
    }

    public boolean isVideoDisplayed() {
        WaitersService.waitUntilTextToBePresentInElement(getDriver(), videoTitle, TEXT_TO_BE_PRESENTED);
        WaitersService.waitForVisibilityOfElement(getDriver(), videoContainer);
        return videoContainer.isDisplayed();
    }

    public void openQuiz() {
        getLogger().info("open quiz");
        SwipeService.swipeToElement(resumeButton, PRESS_TIME);
        resumeButton.click();
    }

    public void pauseVideo() {
        getLogger().info("pause video");
        if (ENVIRONMENT_TYPE.equals(EnvironmentType.LOCAL)) {
            getActions().moveToElement(videoContainer).pause(SPECIFIC_PAUSE).click().moveToElement(videoContainer)
                    .click().build().perform();
        } else {
           getTouchAction().waitAction(waitOptions(Duration.ofSeconds(PAUSE_SECONDS)))
                    .tap(element(videoContainer)).waitAction(waitOptions(ofMillis(PAUSE_VIDEO_WAIT)))
                    .tap(element(videoContainer)).perform();
        }
    }

    public void forwardVideo() {
        getLogger().info("forward video");
        getTouchAction().tap(element(forwardOverlay))
                .waitAction(waitOptions(ofMillis(TAP_WAIT))).tap(element(forwardOverlay)).perform();
    }

    public int getPlayTime() {
        WaitersService.waitForVisibilityOfElement(getDriver(), timeText);
        String[] timeAsStringList = timeText.getText().split(":");
        int timeSeconds = Integer.parseInt(timeAsStringList[1]);
        getLogger().info("received time: {}", timeSeconds);
        return Integer.parseInt(timeAsStringList[1]);
    }
}
