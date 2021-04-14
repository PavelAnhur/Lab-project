package com.epam.tests.api;

import com.epam.core.enums.StatusCode;
import com.epam.service.ApiDataManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static com.epam.service.APICourseraOrgTestManager.BASE_URI;
import static com.epam.service.APICourseraOrgTestManager.FIELDS_PARAMETER;
import static com.epam.service.APICourseraOrgTestManager.LIMIT_PARAMETER;
import static com.epam.service.APICourseraOrgTestManager.ELEMENTS_SIZE;
import static com.epam.service.APICourseraOrgTestManager.START_PARAMETER;

public class InstructorsAPITest {
    private static final String END_POINT_INSTRUCTORS_API = ApiDataManager.get().endpointInstructorsApi();
    private static final String FIELDS_BIO = "bio";
    private static final String FIELDS_SHORT_NAME = "shortName";
    private static final String FIELDS_DEPARTMENT = "department";
    private static final int LIMIT_15_VALUE = 15;
    private static final int START_0_VALUE = 0;
    private static final int LIMIT_1_VALUE = 1;

    @Test
    public void canGetInstructorsBio() {
        RestAssured.baseURI = BASE_URI;
        given().param(FIELDS_PARAMETER, FIELDS_BIO)
                .param(LIMIT_PARAMETER, LIMIT_15_VALUE)
                .when().get(END_POINT_INSTRUCTORS_API)
                .then().log().ifError().assertThat().statusCode(StatusCode.OK_200.getValue())
                .body("elements.findAll{it.bio!=null}.size()", equalTo(LIMIT_15_VALUE))
                .body("elements.findAll{it.fullName!=null}.size()", equalTo(LIMIT_15_VALUE))
                .body("elements.findAll{it.id!=null}.size()", equalTo(LIMIT_15_VALUE))
                .body(ELEMENTS_SIZE, is(LIMIT_15_VALUE));
    }

    @Test
    public void canGetInstructorsShortNameAndDepartment() {
        RestAssured.baseURI = BASE_URI;
        given().param(FIELDS_PARAMETER, FIELDS_SHORT_NAME)
                .param(FIELDS_PARAMETER, FIELDS_DEPARTMENT)
                .param(LIMIT_PARAMETER, LIMIT_15_VALUE)
                .when().get(END_POINT_INSTRUCTORS_API)
                .then().log().ifError().assertThat().statusCode(StatusCode.OK_200.getValue())
                .body("elements.findAll{it.department!=null}.size()", equalTo(LIMIT_15_VALUE))
                .body("elements.findAll{it.shortName!=null}.size()", equalTo(LIMIT_15_VALUE))
                .body(ELEMENTS_SIZE, is(LIMIT_15_VALUE));
    }

    @Test
    public void canGetInstructorsPhoto() {
        RestAssured.baseURI = BASE_URI;
        given()
                .param(START_PARAMETER, START_0_VALUE)
                .param(LIMIT_PARAMETER, LIMIT_1_VALUE)
                .param(FIELDS_PARAMETER, "photo")
                .when()
                .get(END_POINT_INSTRUCTORS_API)
                .then().log().ifError()
                .assertThat()
                .statusCode(StatusCode.OK_200.getValue())
                .contentType(ContentType.JSON)
                .body("elements.findAll{it.photo.endsWith('.jpg')}.size()", equalTo(LIMIT_1_VALUE));
    }
}
