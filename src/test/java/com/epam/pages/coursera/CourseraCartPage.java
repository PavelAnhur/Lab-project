package com.epam.pages.coursera;

import com.epam.core.page.BasePage;
import com.epam.core.utilities.service.WaitersService;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CourseraCartPage extends BasePage {
    private static final String TEXT_PATTERN = "%s/*[contains(text(),'%s')]";
    private static final String ITEM_VERIFICATION = "//*[@class='item']";
    private final Logger logger = getLogger();

    @FindBy(css = ".item a.caption-text")
    private WebElement removeFromCartLink;

    public WebElement getItemVerification(final String linkText) {
        logger.info("received item: {}", linkText);
        return WaitersService.waitUntilPresenceOfElementAndReturn(getDriver(),
                By.xpath(String.format(TEXT_PATTERN, ITEM_VERIFICATION, linkText)));
    }

    public void removeItemFromCart() {
        logger.info("click remove from cart link");
        removeFromCartLink.click();
    }
}
