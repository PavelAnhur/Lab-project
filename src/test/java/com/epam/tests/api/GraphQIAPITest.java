package com.epam.tests.api;

import com.epam.core.enums.StatusCode;
import com.epam.core.utilities.service.JsonService;
import com.epam.pojo.request.RequestBody;
import com.epam.pojo.request.Variables;
import com.epam.pojo.response.Elements;
import com.epam.pojo.response.ResponseBody;
import com.epam.pojo.response.Subdomains;
import com.epam.service.ApiDataManager;
import com.epam.service.WWWCourseraOrgTestManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.epam.core.utilities.service.JsonService.getJsonFile;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static com.epam.service.WWWCourseraOrgTestManager.BASE_URI;
import static com.epam.service.WWWCourseraOrgTestManager.OPNAME_PARAMETER;

public class GraphQIAPITest {
    private static final String GRAPHQL_ENDPOINT = ApiDataManager.get().endpointGraphQl();
    public static final int NUM_ENTRIES_PER_COLLECTION_VALUE = 10;
    private static final String BANNER_SCHEMA = "schema/banner-graph-schema.json";
    private static final String DOMAINS_SCHEMA = "schema/domains-graph-schema.json";
    private static final String CERTIFICATES_SCHEMA = "schema/certificates-graph-schema.json";
    private static final String MULTIPLE_GET_PARTNERS_SCHEMA = "schema/multiple-get-partners-schema.json";
    private static final String MEGA_MENU_QUERY_SCHEMA = "schema/mega-menu-query-schema.json";
    public static final String COLLECTION_QUERY_SCHEMA = "schema/collection-query-schema.json";
    public static final String COLLECTION_RECOMMENDATIONS_QUERY_SCHEMA =
            "schema/collection-recommendations-query-schema.json";

    @Test
    public void canReceiveAllDomains() {
        RequestBody[] requestBody = new RequestBody[]{RequestBody.builder()
                .operationName("DomainGetAllQuery")
                .variables(Variables.builder()
                        .build())
                .query(ApiDataManager.get().queryAllDomains())
                .build()};
        RestAssured.baseURI = BASE_URI;
        given().body(requestBody)
                .contentType(ContentType.JSON)
                .when().post(GRAPHQL_ENDPOINT)
                .then().log().ifError().assertThat().statusCode(StatusCode.OK_200.getValue())
                .contentType(ContentType.JSON)
                .body(matchesJsonSchema(getJsonFile(DOMAINS_SCHEMA)));
    }

    @Test
    public void canReceiveBannerAdCampaignsData() {
        RequestBody[] requestBody = new RequestBody[]{RequestBody.builder()
                .operationName("BannerAdCampaignsV1Query")
                .variables(Variables.builder()
                        .placement("MEGAMENU")
                        .bannerCount(2)
                        .build())
                .query(ApiDataManager.get().queryBannerCampaignsData())
                .build()};
        RestAssured.baseURI = BASE_URI;
        given().body(requestBody)
                .contentType(ContentType.JSON)
                .when().post(GRAPHQL_ENDPOINT)
                .then().log().ifError().assertThat().statusCode(StatusCode.OK_200.getValue())
                .contentType(ContentType.JSON)
                .body(matchesJsonSchema(getJsonFile(BANNER_SCHEMA)));
    }

    @Test
    public void canReceiveProfessionalCertificatesData() {
        RequestBody[] requestBody = new RequestBody[]{RequestBody.builder()
                .operationName("ProfessionalCertificatesData")
                .variables(Variables.builder()
                        .build())
                .query(ApiDataManager.get().queryProfessionalCertificatesData())
                .build()};
        RestAssured.baseURI = BASE_URI;
        given().body(requestBody)
                .contentType(ContentType.JSON)
                .when().post(GRAPHQL_ENDPOINT)
                .then().log().ifError().assertThat().statusCode(StatusCode.OK_200.getValue())
                .contentType(ContentType.JSON)
                .body(matchesJsonSchema(getJsonFile(CERTIFICATES_SCHEMA)));
    }

    @Test
    public void canPostRequestWithMultipleGetPartnersIdsAndReceiveTheirNames() {
        RequestBody[] requestBody = new RequestBody[]{RequestBody.builder()
                .variables(Variables.builder()
                        .ids(new String[]{"1", "2", "3", "4", "6", "7", "8", "9", "10", "11"})
                        .build())
                .query(ApiDataManager.get().queryMultipleGetPartners())
                .build()};
        RestAssured.baseURI = BASE_URI;
        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(GRAPHQL_ENDPOINT);
        response.then().log().ifError()
                .assertThat()
                .statusCode(StatusCode.OK_200.getValue())
                .contentType(ContentType.JSON)
                .body(JsonSchemaValidator.matchesJsonSchema(JsonService.getJsonFile(MULTIPLE_GET_PARTNERS_SCHEMA)));
        int countOfElementsInResponse = response.getBody().as(ResponseBody[].class)[0].getData()
                .getPartnersResource().getMultiGet().getElements().length;
        int countOfRequestedElements = requestBody[0].getVariables().getIds().length;
        Assert.assertEquals(countOfRequestedElements, countOfElementsInResponse);
    }

    @Test
    public void canPostMegaMenuQueryRequestWithDomainIdAndGetSubdomainElements() {
        RequestBody[] requestBody = new RequestBody[]{RequestBody.builder()
                .operationName("MegaMenuQuery")
                .variables(Variables.builder()
                        .ids(new String[]{"computer-science"})
                        .build())
                .query(ApiDataManager.get().queryMegaMenuWithDomain())
                .build()};
        RestAssured.baseURI = BASE_URI;
        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(GRAPHQL_ENDPOINT);
        response.then().log().ifError()
                .assertThat()
                .statusCode(StatusCode.OK_200.getValue())
                .contentType(ContentType.JSON)
                .body(JsonSchemaValidator.matchesJsonSchema(JsonService.getJsonFile(MEGA_MENU_QUERY_SCHEMA)));
        Elements element = response.getBody().as(ResponseBody[].class)[0].getData()
                .getDomainsResource().getDomains().getElements()[0];
        String idFromResponse = element.getId();
        String requestedId = requestBody[0].getVariables().getIds()[0];
        Subdomains subdomains = element.getSubdomains();
        Assert.assertEquals(requestedId, idFromResponse);
        Assert.assertEquals(subdomains.getPaging().getTotal(), subdomains.getElements().length);
    }

    @Test
    public void collectionQueryTest() {
        RequestBody[] requestBody = new RequestBody[]{RequestBody.builder()
                .operationName("CollectionQuery")
                .variables(Variables.builder()
                        .skip(false)
                        .start("0")
                        .contextId("data-analysis")
                        .contextType("SUBCATEGORY")
                        .numEntriesPerCollection(1)
                        .limit(1)
                        .build())
                .query(ApiDataManager.get().queryCollection())
                .build()};
        RestAssured.baseURI = BASE_URI;
        String firstWordInCollectionName = WWWCourseraOrgTestManager.getFirstWordInCollectionName(requestBody);
        Response response = given()
                .log().all()
                .queryParam(OPNAME_PARAMETER, "CollectionQuery")
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(GRAPHQL_ENDPOINT);
        response.then()
                .log().ifError()
                .assertThat()
                .statusCode(StatusCode.OK_200.getValue())
                .contentType(ContentType.JSON)
                .body(JsonSchemaValidator.matchesJsonSchema(
                        JsonService.getJsonFile(COLLECTION_QUERY_SCHEMA)));
        Assert.assertTrue(response.getBody().as(ResponseBody[].class)[0].getData()
                .getBrowseCollectionsResource().getByCollections().getElements()[0]
                .getSns().getElements()[0].getName().contains(firstWordInCollectionName));
    }

    @Test
    public void collectionRecommendationsQueryTest() {
        String operationName = "CollectionRecommendationsQuery";
        RequestBody[] requestBody = new RequestBody[]{RequestBody.builder()
                .operationName(operationName)
                .variables(Variables.builder()
                        .contextType("PAGE")
                        .contextId("search-zero-state")
                        .numEntriesPerCollection(NUM_ENTRIES_PER_COLLECTION_VALUE)
                        .build())
                .query(ApiDataManager.get().queryCollectionRecommendations())
                .build()};
        RestAssured.baseURI = BASE_URI;
        Response response = given()
                .log().all()
                .queryParam(OPNAME_PARAMETER, operationName)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(GRAPHQL_ENDPOINT);
        response.then()
                .log().ifError()
                .assertThat()
                .statusCode(StatusCode.OK_200.getValue())
                .contentType(ContentType.JSON)
                .body(JsonSchemaValidator.matchesJsonSchema(
                        JsonService.getJsonFile(COLLECTION_RECOMMENDATIONS_QUERY_SCHEMA)));
        int numberOfEntriesFromResponse = response.getBody().as(ResponseBody[].class)[0].getData()
                .getBrowseCollectionsResource().getByCollections().getElements()[0].getEntries().length;
        int requestedNumberOfEntries = requestBody[0].getVariables().getNumEntriesPerCollection();
        Assert.assertEquals(requestedNumberOfEntries, numberOfEntriesFromResponse);
    }
}
