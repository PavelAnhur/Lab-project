package com.epam.tests.api;

import com.epam.core.enums.StatusCode;
import com.epam.core.utilities.service.JsonService;
import com.epam.pojo.request.RequestBody;
import com.epam.pojo.response.ResponseBody;
import com.epam.service.ApiDataManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static com.epam.service.WWWCourseraOrgTestManager.BASE_URI;

public class CustomUrlAPITest {
    private static final String CUSTOM_URL_SCHEMA = "schema/custom-url-schema.json";

    @Test
    public void canPostRequestToCreateCustomUrlAndReceiveCorrectStatusCode() {
        RequestBody requestBody = RequestBody.builder()
                .targetUrl(ApiDataManager.get().urlTargetCustomUrlCreation())
                .build();
        RestAssured.baseURI = BASE_URI;
        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(ApiDataManager.get().endpointCustomUrlsApi());
        response.then().log().ifError()
                .assertThat()
                .statusCode(StatusCode.OK_201.getValue())
                .contentType(ContentType.JSON)
                .body(JsonSchemaValidator.matchesJsonSchema(JsonService.getJsonFile(CUSTOM_URL_SCHEMA)));
        Assert.assertEquals(requestBody.getTargetUrl(),
                response.getBody().as(ResponseBody.class).getElements()[0].getTargetUrl());
    }
}
