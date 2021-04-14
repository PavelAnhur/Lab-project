package com.epam.tests.api;

import com.epam.core.enums.StatusCode;
import com.epam.service.ApiDataManager;
import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class MasterTrackCertificatesTest {
    public static final String REQUEST_METHOD_HEADER = "Access-Control-Request-Method";
    public static final String REQUEST_HEADER = "Access-Control-Request-Headers";
    public static final String ORIGIN_HEADER = "Origin";
    public static final String ORIGIN_HEADER_VALUE = "https://www.coursera.org";
    public static final String ACCESS_CONTROL_REQUEST_HEADER_VALUE = "content-type";
    public static final String ACCESS_CONTROL_REQUEST_METHOD_HEADER_VALUE = "GET";

    @Test(priority = 1)
    public void courseraMasterTrackCertificatesTest() {
        RestAssured.baseURI = ApiDataManager.get().uriMasterTrackCertificates();

        given()
                .log().all()
                .header(REQUEST_METHOD_HEADER, ACCESS_CONTROL_REQUEST_METHOD_HEADER_VALUE)
                .header(REQUEST_HEADER, ACCESS_CONTROL_REQUEST_HEADER_VALUE)
                .header(ORIGIN_HEADER, ORIGIN_HEADER_VALUE)
                .options()
                .then()
                .log().ifError()
                .assertThat()
                .statusCode(StatusCode.OK_200.getValue())
                .header("Access-Control-Allow-Methods", ACCESS_CONTROL_REQUEST_METHOD_HEADER_VALUE)
                .header("Access-Control-Allow-Credentials", "true");
    }
}
