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
import static com.epam.service.APICourseraOrgTestManager.START_PARAMETER;
import static com.epam.service.APICourseraOrgTestManager.LIMIT_PARAMETER;
import static com.epam.service.APICourseraOrgTestManager.ELEMENTS_SIZE;
import static com.epam.service.APICourseraOrgTestManager.INCLUDES_PARAMETER;
import static com.epam.service.APICourseraOrgTestManager.Q_PARAMETER;

public class CoursesAPITest {
    private static final String END_POINT_COURSES_API = ApiDataManager.get().endpointCoursesApi();
    private static final String FIELDS_WORKLOAD = "workload";
    private static final String FIELDS_START_DATE = "startDate";
    private static final String INCLUDES_PARTNERS_ID = "partnerIds";
    private static final String QUERY_PARAMETER = "query";
    private static final int START_15_VALUE = 15;
    private static final int LIMIT_5_VALUE = 5;
    private static final int LIMIT_7_VALUE = 7;
    private static final int START_0_VALUE = 0;
    private static final int LIMIT_10_VALUE = 10;

    @Test
    public void canGetFiveCoursesWithWorkload() {
        RestAssured.baseURI = BASE_URI;
        given().param(FIELDS_PARAMETER, FIELDS_WORKLOAD)
                .param(START_PARAMETER, START_15_VALUE)
                .param(LIMIT_PARAMETER, LIMIT_5_VALUE)
                .when().get(END_POINT_COURSES_API)
                .then().log().ifError().assertThat().statusCode(StatusCode.OK_200.getValue())
                .body("elements.findAll{it.workload!=null}.size()", equalTo(LIMIT_5_VALUE))
                .body(ELEMENTS_SIZE, is(LIMIT_5_VALUE));
    }

    @Test
    public void canGetCoursesWithStartDateAndPartnersID() {
        RestAssured.baseURI = BASE_URI;
        given().param(FIELDS_PARAMETER, FIELDS_START_DATE)
                .param(INCLUDES_PARAMETER, INCLUDES_PARTNERS_ID)
                .param(LIMIT_PARAMETER, LIMIT_7_VALUE)
                .when().get(END_POINT_COURSES_API)
                .then().log().ifError().assertThat().statusCode(StatusCode.OK_200.getValue())
                .body("elements.findAll{it.startDate!=null}.size()", equalTo(LIMIT_7_VALUE))
                .body("linked.'partners.v1'.name!=null", is(true))
                .body("linked.'partners.v1'.id!=null", is(true))
                .body("linked.'partners.v1'.shortName!=null", is(true))
                .body(ELEMENTS_SIZE, is(LIMIT_7_VALUE));
    }

    @Test
    public void canGetFirstTenCourses() {
        RestAssured.baseURI = BASE_URI;
        given()
                .param(START_PARAMETER, START_0_VALUE)
                .param(LIMIT_PARAMETER, LIMIT_10_VALUE)
                .when()
                .get(END_POINT_COURSES_API)
                .then().log().ifError()
                .assertThat()
                .statusCode(StatusCode.OK_200.getValue())
                .contentType(ContentType.JSON)
                .body("paging.next=='10'", is(true))
                .body("elements.size()", equalTo(LIMIT_10_VALUE));
    }

    @Test
    public void canGetCorrectlyResultsWithQueryParameter() {
        RestAssured.baseURI = BASE_URI;
        given()
                .param(START_PARAMETER, START_0_VALUE)
                .param(LIMIT_PARAMETER, LIMIT_10_VALUE)
                .param(Q_PARAMETER, "search")
                .param(QUERY_PARAMETER, "API")
                .when()
                .get(END_POINT_COURSES_API)
                .then().log().ifError()
                .assertThat()
                .statusCode(StatusCode.OK_200.getValue())
                .contentType(ContentType.JSON)
                .body("elements.findAll{it.name.contains('API')}.size()<=" + LIMIT_10_VALUE, is(true));
    }

    @Test
    public void canAddAdditionalFieldsWithQueryParameter() {
        RestAssured.baseURI = BASE_URI;
        given()
                .param(START_PARAMETER, START_0_VALUE)
                .param(LIMIT_PARAMETER, LIMIT_10_VALUE)
                .param(FIELDS_PARAMETER, "certificates")
                .param(FIELDS_PARAMETER, "description")
                .when()
                .get(END_POINT_COURSES_API)
                .then().log().ifError()
                .assertThat()
                .statusCode(StatusCode.OK_200.getValue())
                .contentType(ContentType.JSON)
                .body("elements.findAll{it.description!=null}.size()", equalTo(LIMIT_10_VALUE))
                .body("elements.findAll{it.certificates!=null}.size()", equalTo(LIMIT_10_VALUE))
                .body("elements.size()", equalTo(LIMIT_10_VALUE));
    }

    @Test
    public void canGetCourseAndReceiveItsInstructors() {
        String courseId = "/NFiJtRnpEeW9dA4X94-nLQ";
        RestAssured.baseURI = BASE_URI;
        given()
                .param(INCLUDES_PARAMETER, "instructorIds")
                .param(FIELDS_PARAMETER, "instructors.v1(firstName,lastName,fullName)")
                .when()
                .get(END_POINT_COURSES_API + courseId)
                .then().log().ifError()
                .assertThat()
                .statusCode(StatusCode.OK_200.getValue())
                .contentType(ContentType.JSON)
                .body("elements[0].id", equalTo(courseId.substring(1)))
                .body("linked.'instructors.v1'.size()>0", is(true))
                .body("linked.'instructors.v1'.firstName.size()>0", is(true))
                .body("linked.'instructors.v1'.lastName.size()>0", is(true))
                .body("linked.'instructors.v1'.fullName.size()>0", is(true));
    }
}
