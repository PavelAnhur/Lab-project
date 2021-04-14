package com.epam.tests.api;

import com.epam.core.enums.StatusCode;
import com.epam.pojo.request.RequestBody;
import com.epam.pojo.response.ResponseBody;
import com.epam.service.ApiDataManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static com.epam.service.WWWCourseraOrgTestManager.BASE_URI;

public class CourseraForStudentAPITest {

    @Test
    public void getCourseraForStudent() {
        RequestBody requestBody = RequestBody.builder()
                .targetUrl(ApiDataManager.get().urlTargetCourseraForStudent())
                .customSlug("").build();
        RestAssured.baseURI = BASE_URI;
        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(ApiDataManager.get().endpointCourseraForStudent());
        response.then().log().ifError()
                .assertThat()
                .statusCode(StatusCode.OK_201.getValue());
        Assert.assertEquals(requestBody.getTargetUrl(),
                response.getBody().as(ResponseBody.class).getElements()[0].getTargetUrl());
    }
}
