package com.epam.pages.coursera;

import com.epam.core.page.BasePage;
import com.epam.core.utilities.service.TabsSwitcher;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CourseraDevelopersPage extends BasePage {
    private final Logger logger = getLogger();

    @FindBy(xpath = "//*[contains(@class,'c-job-button')]")
    private WebElement viewOpenPositionsButton;

    public void clickViewOpenPositionsButton() {
        logger.info("click 'View Open Positions' button");
        viewOpenPositionsButton.click();
        TabsSwitcher.switchToNewTab(getDriver());
    }
}
