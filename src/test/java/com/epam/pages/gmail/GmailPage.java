package com.epam.pages.gmail;

import com.epam.core.page.BasePage;
import com.epam.core.utilities.service.TabsSwitcher;
import com.epam.core.utilities.service.WaitersService;
import com.epam.core.utilities.service.WebElementsService;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class GmailPage extends BasePage {
    private static final String MAIL_PAGE_URL = "https://gmail.com";
    private final Logger logger = getLogger();

    @FindBy(xpath = "//tr[@id and contains(@class, 'zA zE')]//td//span//span[contains(@data-thread-id,'#thread-f')]")
    private List<WebElement> lettersTopics;

    @Override
    protected void openPage() {
        logger.info("open gmail.com");
        getDriver().get(MAIL_PAGE_URL);
    }

    public void goToGmailPage() {
        logger.info("go to new tab");
        TabsSwitcher.createNewTabAndSwitchToIt(getDriver());
        openPage();
    }

    public boolean selectionLetter(final String keywords) {
        try {
            logger.info("the letter is reading");
            WaitersService.threadSleep(getPauseTime());
            getDriver().navigate().refresh();
            WebElementsService.clickToElementFromListByName(lettersTopics, keywords);
            return true;
        } catch (Exception ex) {
            logger.info("the letter have been red early");
            return false;
        }
    }
}
