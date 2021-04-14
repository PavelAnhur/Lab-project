package com.epam.tests.api;

import com.epam.core.enums.StatusCode;
import com.epam.service.ApiDataManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

public class LearnerHelpAPITest {
    public static final String PER_PAGE_PARAMETER = "per_page";
    public static final String PER_PAGE_PARAMETER_VALUE = "10";

    @Test
    public void courseraLearnerHelpAPITest() {
        RestAssured.baseURI = ApiDataManager.get().uriLearnerCourseraHelp();

        given().log().all()
                .param(PER_PAGE_PARAMETER, PER_PAGE_PARAMETER_VALUE)
                .when()
                .get(ApiDataManager.get().endpointForLearnerHelpTest())
                .then()
                .log().ifError()
                .assertThat()
                .statusCode(StatusCode.OK_200.getValue())
                .contentType(ContentType.JSON)
                .body("per_page == " + PER_PAGE_PARAMETER_VALUE, is(true));
    }
}
