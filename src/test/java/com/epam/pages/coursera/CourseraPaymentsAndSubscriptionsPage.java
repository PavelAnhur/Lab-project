package com.epam.pages.coursera;

import com.epam.core.page.BasePage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CourseraPaymentsAndSubscriptionsPage extends BasePage {
    private final Logger logger = getLogger();

    @FindBy(xpath = "//a[text()='Change your subscription plan']")
    private WebElement changeSubscriptionButton;

    public void clickChangeSubscriptionPlanButton() {
        logger.info("Click change subscription plan button, new page is opening");
        changeSubscriptionButton.click();
    }
}
