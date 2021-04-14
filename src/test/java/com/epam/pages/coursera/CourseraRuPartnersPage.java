package com.epam.pages.coursera;

import com.epam.core.page.BasePage;
import com.epam.core.utilities.service.TabsSwitcher;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CourseraRuPartnersPage extends BasePage {
    private final Logger logger = getLogger();

    @FindBy(xpath = "//*[@href='/yandex']")
    private WebElement yandexButton;

    public void clickYandexButton() {
        logger.info("click Yandex button");
        yandexButton.click();
        TabsSwitcher.switchToNewTab(getDriver());
    }
}
