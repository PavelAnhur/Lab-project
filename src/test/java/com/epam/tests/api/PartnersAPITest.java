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
import static com.epam.service.APICourseraOrgTestManager.INCLUDES_PARAMETER;

public class PartnersAPITest {
    private static final String END_POINT_PARTNERS_API = ApiDataManager.get().endpointPartnersApi();
    private static final String FIELDS_LINKS = "links";
    private static final String FIELDS_LOCATIONS = "location";
    private static final int LIMIT_15_VALUE = 15;
    private static final int START_13_VALUE = 13;
    private static final int LIMIT_1_VALUE = 1;
    private static final int START_5_VALUE = 5;
    private static final int LIMIT_2_VALUE = 2;
    private static final String INSTRUCTOR_IDS = "instructorIds";


    @Test
    public void canGetPartnersLinks() {
        RestAssured.baseURI = BASE_URI;
        given().param(FIELDS_PARAMETER, FIELDS_LINKS)
                .param(LIMIT_PARAMETER, LIMIT_15_VALUE)
                .when().get(END_POINT_PARTNERS_API)
                .then().log().ifError().assertThat().statusCode(StatusCode.OK_200.getValue())
                .body("elements.findAll{it.links!=null}.size()", equalTo(LIMIT_15_VALUE))
                .body(ELEMENTS_SIZE, is(LIMIT_15_VALUE));
    }

    @Test
    public void canGetPartnersLocations() {
        RestAssured.baseURI = BASE_URI;
        given().param(FIELDS_PARAMETER, FIELDS_LOCATIONS)
                .param(LIMIT_PARAMETER, LIMIT_15_VALUE)
                .when().get(END_POINT_PARTNERS_API)
                .then().log().ifError().assertThat().statusCode(StatusCode.OK_200.getValue())
                .body("elements.findAll{it.location!=null}.size()", equalTo(LIMIT_15_VALUE))
                .body(ELEMENTS_SIZE, is(LIMIT_15_VALUE));
    }

    @Test
    public void canGetPartnerAndReceiveItsCourses() {
        RestAssured.baseURI = BASE_URI;
        given()
                .param(START_PARAMETER, START_13_VALUE)
                .param(LIMIT_PARAMETER, LIMIT_1_VALUE)
                .param(INCLUDES_PARAMETER, "courseIds")
                .when()
                .get(END_POINT_PARTNERS_API)
                .then().log().ifError()
                .assertThat()
                .statusCode(StatusCode.OK_200.getValue())
                .contentType(ContentType.JSON)
                .body("linked.'courses.v1'.size()>0", is(true));
    }

    @Test
    public void getPartnersInstructors() {
        RestAssured.baseURI = BASE_URI;
        given()
                .param(START_PARAMETER, START_5_VALUE)
                .param(LIMIT_PARAMETER, LIMIT_2_VALUE)
                .param(INCLUDES_PARAMETER, INSTRUCTOR_IDS)
                .when()
                .get(END_POINT_PARTNERS_API)
                .then().log().ifError()
                .assertThat()
                .statusCode(StatusCode.OK_200.getValue())
                .body("elements.name.size() == 2", is(true))
                .body("elements.instructors.v1.fullName != null", is(true))
                .body("elements.instructors.v1.id != null", is(true));
    }
}
