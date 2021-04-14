package com.epam.pages.coursera;

import com.epam.core.page.BasePage;
import com.epam.core.utilities.service.WaitersService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CourseraTechnicalWritingPage extends BasePage {
    private static final String TEXT_TO_WAIT = "Technical Writing";
    private static final By LOCATOR = By.tagName("h1");

    public String getHeaderText() {
        WaitersService.waitUntilPageIsCompletelyLoaded(getDriver());
        WebElement header = WaitersService.waitUntilPresenceOfElementAndReturn(getDriver(), LOCATOR);
        WaitersService.waitUntilTextToBePresentInElement(getDriver(), header, TEXT_TO_WAIT);
        return header.getText();
    }
}
