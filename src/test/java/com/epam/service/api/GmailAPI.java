package com.epam.service.api;

import com.epam.core.utilities.property.PropertyDataReader;
import com.epam.core.utilities.service.LocalDateService;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hamcrest.CoreMatchers;

import static io.restassured.RestAssured.given;
import static java.lang.String.format;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.Matchers.equalTo;

public class GmailAPI {
    private static final Logger LOGGER = LogManager.getRootLogger();
    private static final String OAUTH_KEY = format("Bearer %s",
            PropertyDataReader.getProperties("tests-data").getProperty("oauth.key"));
    private static final String BASE_URI = "https://www.googleapis.com";
    private static final String GMAIL_ENDPOINT = "/gmail/v1/users/qapaveltest@gmail.com/messages";
    private static final String MAIL_RECEIVER = "pavelTest QA <qapaveltest@gmail.com>";
    private static final String HEADER_KEY = "Authorization";
    private static final String PARAM_KEY_FOR_VERIFICATION_REQUEST = "format";
    private static final String PARAM_VALUE_FOR_VERIFICATION_REQUEST = "metadata";
    private static final String PARAM_KEY_FOR_ID_REQUEST = "maxResults";
    private static final int NUMBER_OF_EMAILS = 1;
    private static final String DATA_TIME_PATTERN = "EEE, d MMM yyyy HH:mm";
    private static final String PAYLOAD_HEADERS_VALUE = "payload.headers[%s].value";
    private static final String DEVICE_NAME = "nexus-7-2012";
    private static final int RECEIVER_FIELD_NUMBER = 3;
    private static final String COMMAND_LINE_ARGUMENT = "env";

    public void apiRequestVerification(final String emailContent) {
        RestAssured.baseURI = BASE_URI;
        String dateAndTime = LocalDateService.getCurrentDateAndTime(DATA_TIME_PATTERN);
        given().log().all()
                .param(PARAM_KEY_FOR_VERIFICATION_REQUEST, PARAM_VALUE_FOR_VERIFICATION_REQUEST)
                .header(HEADER_KEY, OAUTH_KEY)
                .accept(ContentType.JSON)
                .when()
                .get(format("%s/%s", GMAIL_ENDPOINT, getMessageId()))
                .prettyPeek()
                .then()
                .log().ifError()
                .assertThat()
                .body("snippet", CoreMatchers.endsWith(emailContent))
                .body(format(PAYLOAD_HEADERS_VALUE, getReceiverFieldNumberFromRequestBody()), equalTo(MAIL_RECEIVER))
                .body(format(PAYLOAD_HEADERS_VALUE, getDateFieldNumberFromRequestBody()), startsWith(dateAndTime));
    }

    private String getMessageId() {
        RestAssured.baseURI = BASE_URI;
        String id = given()
                            .log().all()
                            .param(PARAM_KEY_FOR_ID_REQUEST, NUMBER_OF_EMAILS)
                            .header(HEADER_KEY, OAUTH_KEY)
                            .accept(ContentType.JSON)
                            .when()
                            .get(GMAIL_ENDPOINT)
                            .prettyPeek()
                            .jsonPath()
                            .getMap("messages[0]").get("id").toString();
        LOGGER.info("message id: {}", id);
        return id;
    }

    private int getDateFieldNumberFromRequestBody() {
        final int fieldNumber = 1;
        if (System.getProperty(COMMAND_LINE_ARGUMENT).equals(DEVICE_NAME)) {
            return fieldNumber + 2;
        }
        return fieldNumber;
    }

    private int getReceiverFieldNumberFromRequestBody() {
        final int fieldNumber = 4;
        if (System.getProperty(COMMAND_LINE_ARGUMENT).equals(DEVICE_NAME)) {
            return fieldNumber + RECEIVER_FIELD_NUMBER;
        }
        return fieldNumber;
    }
}
