package com.epam.cucumber.mobile.steps;

import com.epam.pages.mobile.coursera.PaymentInformationPage;
import com.epam.pages.mobile.coursera.PriceCoursePage;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import static com.epam.cucumber.mobile.reflection.PageManager.getPage;

public class PaymentSteps {
    private final SoftAssert softAssert = new SoftAssert();

    @Then("the user can see page with the header {string} and message with {string} text")
    public void verifyPaymentInformationPage(final String headerName, final String massageText) {
        softAssert.assertEquals(headerName,
                getPage(PaymentInformationPage.class).getHeaderPaymentInformationPage(),
                "Probably, payment information page didn't open");
        softAssert.assertEquals(massageText,
                getPage(PaymentInformationPage.class).getMessageTextPaymentInformationPage(),
                "Payment information page didn't open!");
        softAssert.assertAll();
    }

    @Then("the user sees information with the price")
    public void subscribeCourse() {
        getPage(PriceCoursePage.class).goToPriceInformation();
        Assert.assertTrue(getPage(PriceCoursePage.class).isPriceInformationTrue(), "Price isn't displayed!");
    }
}

