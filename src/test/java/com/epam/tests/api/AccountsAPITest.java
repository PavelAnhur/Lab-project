package com.epam.tests.api;

import com.epam.core.enums.StatusCode;
import com.epam.service.ApiDataManager;
import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.when;

public class AccountsAPITest {

    @Test(priority = 1)
    public void canNotObtainAnAccessTokenWithoutQueryParams() {
        RestAssured.baseURI = ApiDataManager.get().uriAccountsCourseraOrg();
        when()
                .get(ApiDataManager.get().endpointAuth())
                .then().log().ifError()
                .assertThat()
                .statusCode(StatusCode.ERROR_400.getValue());
    }
}
