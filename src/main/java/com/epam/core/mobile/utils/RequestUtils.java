package com.epam.core.mobile.utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import static io.restassured.RestAssured.given;
import static java.lang.String.format;

public final class RequestUtils {
    private static final Logger LOGGER = LogManager.getRootLogger();
    public static final String AUTHORIZATION_NAME = "Authorization";
    public static final String AUTHORIZATION_VALUE = "Bearer %s";
    public static final String STATUS_CODE_MESSAGE = "status code is: {}";
    public static final String DEVICE_ENDPOINT = "%s/device/%s";
    public static final String SPACES_ARTIFACTS_ENDPOINT = "%s/v1/spaces/artifacts/%s";
    public static final String STORAGE_INSTALL_ENDPOINT = "%s/storage/install/%s/%s";
    public static final String BID_PARAM_NAME = "bid";
    public static final String SERIAL_PARAM_NAME = "serial";
    public static final String FILE_ID_PARAM_NAME = "fileId";
    public static final String NAME = System.getenv("SAUCE_USERNAME");
    public static final String KEY = System.getenv("SAUCE_ACCESS_KEY");
    public static final String URL_GET = String.format("https://%s:%s@saucelabs.com/rest/v1/storage/%s",
            NAME, KEY, NAME);
    public static final String URL_POST = String.format("https://%s:%s@saucelabs.com/rest/v1/storage/%s/"
            + "org.coursera.android_2021-03-09", NAME, KEY, NAME);
    public static final String FILE_PATH = "src/main/resources/org.coursera.android_2021-03-09.apk";
    public static final String OVERWRITE_PARAM_NAME = "overwrite";

    private RequestUtils() {
    }

    public static void takeDevice(final String url, final String serial, final String key) {
        LOGGER.info("attempt to take a device with serial: {}", serial);
        Response response = given()
                .header(AUTHORIZATION_NAME, format(AUTHORIZATION_VALUE, key))
                .contentType(ContentType.JSON)
                .when()
                .post(format(DEVICE_ENDPOINT, url, serial));
        LOGGER.info(STATUS_CODE_MESSAGE, response.getStatusCode());
        response.getBody().prettyPrint();
    }

    public static String retrieveAllUploadedArtifactsAndReturnFileId(final String url, final String key,
                                                                     final String bid) {
        LOGGER.info("attempt to retrieve all uploaded artifacts");
        Response response = given()
                .header(AUTHORIZATION_NAME, format(AUTHORIZATION_VALUE, key))
                .param(BID_PARAM_NAME, bid)
                .when()
                .get(format(SPACES_ARTIFACTS_ENDPOINT, url, bid));
        LOGGER.info(STATUS_CODE_MESSAGE, response.getStatusCode());
        response.getBody().prettyPrint();
        List<HashMap<String, Object>> elements = response.jsonPath().getList("$");
        return elements.get(0).get("id").toString();
    }

    public static void installApp(final String url, final String serial, final String key, final String fileId) {
        LOGGER.info("attempt to install app on the {} device", serial);
        Response response = given()
                .header(AUTHORIZATION_NAME, format(AUTHORIZATION_VALUE, key))
                .param(SERIAL_PARAM_NAME, serial)
                .param(FILE_ID_PARAM_NAME, fileId)
                .when()
                .get(format(STORAGE_INSTALL_ENDPOINT, url, serial, fileId));
        LOGGER.info(STATUS_CODE_MESSAGE, response.getStatusCode());
        response.getBody().prettyPrint();
    }

    public static void stopUsingDevice(final String url, final String serial, final String key) {
        LOGGER.info("attempt to stop using {} device", serial);
        Response response = given()
                .header(AUTHORIZATION_NAME, format(AUTHORIZATION_VALUE, key))
                .contentType(ContentType.JSON)
                .param(SERIAL_PARAM_NAME, serial)
                .when()
                .delete(format(DEVICE_ENDPOINT, url, serial));
        LOGGER.info(STATUS_CODE_MESSAGE, response.getStatusCode());
        response.getBody().prettyPrint();
    }

    public static String getFileName() {
        setFile();
        LOGGER.info("attempt to get name app for the {} user", NAME);
        Response response = given()
                .when()
                .get(URL_GET);
        LOGGER.info(STATUS_CODE_MESSAGE, response.getStatusCode());
        return response.getBody().as(FileApp.class).getFiles()[0].getName();
    }

    public static void setFile() {
        File appCoursera = new File(FILE_PATH);
        LOGGER.info("attempt to set app for the {} user", NAME);
        Response response = given()
                .contentType(ContentType.BINARY)
                .queryParam(OVERWRITE_PARAM_NAME, true)
                .body(appCoursera)
                .when()
                .post(URL_POST);
        LOGGER.info(STATUS_CODE_MESSAGE, response.getStatusCode());
    }
}
