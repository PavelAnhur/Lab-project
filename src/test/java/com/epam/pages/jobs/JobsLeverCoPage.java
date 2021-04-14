package com.epam.pages.jobs;

import com.epam.core.page.BasePage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JobsLeverCoPage extends BasePage {
    private final Logger logger = getLogger();

    @FindBy(xpath = "//*[contains(@class,'icon-caret-down')]")
    private WebElement locationFilterButton;

    @FindBy(xpath = "//*[contains(@href,'United')]")
    private WebElement unitesStatesRemoteDropdownButton;

    @FindBy(xpath = "//*[@class='filter-button' and text()='Team']")
    private WebElement teamFilterButton;

    @FindBy(xpath = "//*[contains(@href,'Customer')]")
    private WebElement customerSuccessDropdownButton;

    @FindBy(xpath = "//*[contains(@class,'sort-by-location')]")
    private WebElement locationSearchResult;

    @FindBy(xpath = "//*[contains(@class,'sort-by-team')]")
    private WebElement teamSearchResult;

    public void selectLocation() {
        logger.info("select \"United States (Remote)\" from Location dropdown");
        getActions()
                .moveToElement(locationFilterButton)
                .click()
                .pause(getPauseTime())
                .build()
                .perform();
        unitesStatesRemoteDropdownButton.click();
    }

    public void selectTeam() {
        logger.info("select \"Customer Success\" from Team dropdown");
        getActions()
                .moveToElement(teamFilterButton)
                .click()
                .pause(getPauseTime())
                .build()
                .perform();
        customerSuccessDropdownButton.click();
    }

    public boolean doesFilterResultContainLocationAndTeamValues(final String location, final String team) {
        String locationFromJobPageFilterResult = locationSearchResult.getText();
        logger.debug("location: {}", locationFromJobPageFilterResult);
        String teamFromJobPageFilterResult = teamSearchResult.getText();
        logger.debug("team: {}", teamFromJobPageFilterResult);
        return locationFromJobPageFilterResult.toLowerCase().contains(location.toLowerCase())
                       && teamFromJobPageFilterResult.toLowerCase().contains(team.toLowerCase());
    }
}
