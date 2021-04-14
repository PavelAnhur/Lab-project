package com.epam.tests.api;

import com.epam.core.enums.StatusCode;
import com.epam.core.utilities.service.JsonService;
import com.epam.pojo.request.RequestBody;
import com.epam.pojo.request.Variables;
import com.epam.service.ApiDataManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import java.io.File;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static com.epam.service.WWWCourseraOrgTestManager.BASE_URI;
import static com.epam.service.WWWCourseraOrgTestManager.OPNAME_PARAMETER;

public class DirectoryDegreesAPITest {
    private static final String OPERATION_NAME_VALUE = "CatalogDegreeData";
    private static final String DATA_CATALOG_RESPONSE_SCHEMA = "schema/response-boby-schema-data-catalog-degrees.json";

    @Test
    public void checkCatalogDegreesData() {
        RequestBody[] requestBody = new RequestBody[]{RequestBody.builder()
                .operationName(OPERATION_NAME_VALUE)
                .variables(Variables.builder().liveOnly(true).build())
                .query(ApiDataManager.get().queryCatalogDegreesData())
                .build()};
        File responseBodySchema = JsonService.getJsonFile(DATA_CATALOG_RESPONSE_SCHEMA);
        RestAssured.baseURI = BASE_URI;
        given()
                .queryParam(OPNAME_PARAMETER, OPERATION_NAME_VALUE)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(ApiDataManager.get().endpointGraphQl())
                .then().log().ifError()
                .statusCode(StatusCode.OK_200.getValue())
                .contentType(ContentType.JSON)
                .body(matchesJsonSchema(responseBodySchema));
    }
}
