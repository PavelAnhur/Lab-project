package com.epam.pages.mobile.coursera;

import com.epam.core.mobile.base.page.BaseMobilePage;
import com.epam.core.utilities.service.WaitersService;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class BottomSection extends BaseMobilePage {

    @AndroidFindBy(accessibility = "Explore")
    private MobileElement exploreButton;

    @AndroidFindBy(accessibility = "Profile")
    private MobileElement profileButton;

    @AndroidFindBy(accessibility = "Downloads")
    private MobileElement downloadsButton;

    public void navigateToExplore() {
        getLogger().info("navigate to explore section");
        WaitersService.waitForElementToBeClickableAndReturn(getDriver(), exploreButton).click();
    }

    public void navigateToProfile() {
        getLogger().info("navigate to profile");
        WaitersService.waitForElementToBeClickableAndReturn(getDriver(), profileButton).click();
    }

    public void navigateToDownloads() {
        getLogger().info("navigate to downloads");
        WaitersService.waitForElementToBeClickableAndReturn(getDriver(), downloadsButton).click();
    }
}

