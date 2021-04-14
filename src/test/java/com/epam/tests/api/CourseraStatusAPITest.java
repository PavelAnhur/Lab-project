package com.epam.tests.api;

import com.epam.core.enums.StatusCode;
import com.epam.service.ApiDataManager;
import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class CourseraStatusAPITest {

    @Test
    public void getCourseraStatus() {
        RestAssured.baseURI = ApiDataManager.get().uriStatusCourseraOrg();
        given()
                .when().get(ApiDataManager.get().endpointStatusApi())
                .then().log().ifError()
                .assertThat()
                .statusCode(StatusCode.OK_200.getValue())
                .body("status.size()>0", is(true));
    }
}
