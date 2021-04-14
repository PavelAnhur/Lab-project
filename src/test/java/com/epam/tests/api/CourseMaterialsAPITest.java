package com.epam.tests.api;

import com.epam.core.enums.StatusCode;
import com.epam.service.APICourseraOrgTestManager;
import com.epam.service.ApiDataManager;
import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static com.epam.service.WWWCourseraOrgTestManager.BASE_URI;

public class CourseMaterialsAPITest {
    private static final String ID = "JLygJMCgEeWP5g5dlaZx4w";
    private static final String MODULE_IDS = "moduleIds";

    @Test
    public void getCourseMaterialsId() {
        RestAssured.baseURI = BASE_URI;
        given().param(APICourseraOrgTestManager.FIELDS_PARAMETER, MODULE_IDS)
                .when().get(ApiDataManager.get().endpointMaterialsApi() + ID)
                .then().log().ifError()
                .assertThat()
                .statusCode(StatusCode.OK_200.getValue())
                .body("elements.id.get(0)", equalTo(ID))
                .body("elements.moduleIds.size()>0", is(true));
    }
}
