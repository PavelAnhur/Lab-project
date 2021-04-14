package com.epam.tests.api;

import com.epam.core.enums.StatusCode;
import com.epam.service.ApiDataManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static com.epam.service.WWWCourseraOrgTestManager.BASE_URI;

public class CourseScheduleAPITest {

    @Test
    public void getLearnerCourseScheduleNegative() {
        RestAssured.baseURI = BASE_URI;
        given()
                .when().get(ApiDataManager.get().endpointScheduleApi())
                .then().log().ifError()
                .assertThat()
                .statusCode(StatusCode.ERROR_404.getValue())
                .contentType(ContentType.JSON)
                .body("statusCode==404", is(true));
    }
}
