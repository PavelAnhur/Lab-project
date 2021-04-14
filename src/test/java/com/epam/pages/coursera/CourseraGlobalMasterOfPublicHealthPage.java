package com.epam.pages.coursera;

import com.epam.core.page.BasePage;
import com.epam.core.utilities.service.WaitersService;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CourseraGlobalMasterOfPublicHealthPage extends BasePage {

    @FindBy(tagName = "h1")
    private WebElement header;

    public String getHeaderText() {
        WaitersService.waitUntilPageIsCompletelyLoaded(getDriver());
        return header.getText();
    }
}
