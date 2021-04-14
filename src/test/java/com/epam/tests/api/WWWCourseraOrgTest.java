package com.epam.tests.api;

import com.epam.core.enums.StatusCode;
import com.epam.core.utilities.service.JsonService;
import com.epam.pojo.request.RequestBody;
import com.epam.pojo.request.Events;
import com.epam.pojo.request.Value;
import com.epam.pojo.request.Namespace;
import com.epam.pojo.request.IgnoreObjectNamespace;
import com.epam.pojo.request.IgnoreStringNamespace;
import com.epam.service.APICourseraOrgTestManager;
import com.epam.service.ApiDataManager;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.equalTo;
import static com.epam.service.WWWCourseraOrgTestManager.BASE_URI;
import static com.epam.service.WWWCourseraOrgTestManager.ACTION_PARAMETER;
import static com.epam.service.WWWCourseraOrgTestManager.PRODUCT_ID_PARAMETER;

public class WWWCourseraOrgTest {
    private static final Logger LOGGER = LogManager.getRootLogger();
    public static final String EVENTING_ENDPOINT = ApiDataManager.get().endpointEventingInfoBatch();
    public static final String PRODUCT_ID_VALUE_FOR_SET_OR_UPDATE_TEST = "SPECIALIZATION~M4k2FiN0EeqnFRLwbdubGw";
    public static final String SESSION_ID_VALUE_FOR_SET_OR_UPDATE_TEST = "SESSION~2696558095";
    public static final String ACTION_PARAM_VALUE_FOR_SET_OR_UPDATE_TEST = "setOrUpdateRecentlyViewedXDP";
    public static final String CONTENT_TYPE_PARAM_VALUE_FOR_ALICE_MSG_TEST = "LOGGED_IN_DASHBOARD";
    public static final String EVENT_TYPE_PARAM_FOR_ALICE_MSG_TEST = "PAGEVIEW";
    public static final String Q_PARAM_VALUE_FOR_ALICE_MSG_TEST = "byContextAndEventType";
    public static final String Q_PARAM_VALUE_FOR_SUBSCRIPTION_TEST = "findByUnderlying";
    public static final String ID_PARAM_VALUE_FOR_SUBSCRIPTION_TEST = "CourseraPlusSubscription~";
    public static final String PRODUCT_ID = "Nf1hONLKQjyXSmwOh0KGyQ";
    public static final String ID_PARAM = "id";
    public static final String EVENT_TYPE_PARAM = "eventType";
    public static final String CONTEXT_TYPE_PARAM = "contextType";
    public static final String SUB_TYPE_TEST_ENDPOINT = "/api/productSkus.v1";
    public static final String METRICS_SPEC_TEST_ENDPOINT = "/api/productMetrics.v1/Specialization~";
    public static final String SESSION_ID_PARAMETER = "sessionId";
    public static final String COURSE_ID = "M4k2FiN0EeqnFRLwbdubGw";
    private static final String CLIENT_TYPE_VALUE = "web";
    private static final String APP_VALUE = "phoenix";
    public static final String FIELDS_PARAM_VALUE_FOR_METRICS_SPEC_TEST =
            "id,productPageViewsInLastMonthCount,totalEnrollmentCount";
    public static final long CLIENT_TIMESTAMP_VALUE = 1614341936815L;
    public static final long SECOND_CLIENT_TIMESTAMP_VALUE = 1614592682684L;

    @Test
    public void courseraSubscriptionTypeTest() {
        RestAssured.baseURI = BASE_URI;

        given()
                .log().all()
                .param(APICourseraOrgTestManager.Q_PARAMETER, Q_PARAM_VALUE_FOR_SUBSCRIPTION_TEST)
                .param(ID_PARAM, ID_PARAM_VALUE_FOR_SUBSCRIPTION_TEST + PRODUCT_ID)
                .when()
                .get(SUB_TYPE_TEST_ENDPOINT)
                .then()
                .log().ifError()
                .assertThat()
                .statusCode(StatusCode.OK_200.getValue())
                .contentType(ContentType.JSON)
                .body("elements.findAll{it.underlyingProductId == ('"
                              + ID_PARAM_VALUE_FOR_SUBSCRIPTION_TEST + PRODUCT_ID + "')}.size() > 0",
                        is(true))
                .body("elements.findAll{it.id.contains('"
                              + ID_PARAM_VALUE_FOR_SUBSCRIPTION_TEST + "')}.size() > 0", is(true));
    }

    @Test
    public void courseraMetricsSpecializationTest() {
        RestAssured.baseURI = BASE_URI;

        given()
                .log().all()
                .urlEncodingEnabled(false)
                .param(APICourseraOrgTestManager.FIELDS_PARAMETER, FIELDS_PARAM_VALUE_FOR_METRICS_SPEC_TEST)
                .when()
                .get(METRICS_SPEC_TEST_ENDPOINT + COURSE_ID)
                .then()
                .log().ifError()
                .assertThat()
                .statusCode(StatusCode.OK_200.getValue())
                .contentType(ContentType.JSON)
                .body("elements[0].id", equalTo("Specialization~" + COURSE_ID))
                .body("elements[0].totalEnrollmentCount > 0", is(true));
    }

    @Test
    public void courseraAliceMessageTest() {
        RestAssured.baseURI = BASE_URI;

        given()
                .log().all()
                .param(APICourseraOrgTestManager.Q_PARAMETER, Q_PARAM_VALUE_FOR_ALICE_MSG_TEST)
                .param(EVENT_TYPE_PARAM, EVENT_TYPE_PARAM_FOR_ALICE_MSG_TEST)
                .param(CONTEXT_TYPE_PARAM, CONTENT_TYPE_PARAM_VALUE_FOR_ALICE_MSG_TEST)
                .when()
                .get(ApiDataManager.get().endpointAliceMessagesApi())
                .then()
                .log().ifError()
                .assertThat()
                .statusCode(StatusCode.OK_200.getValue())
                .contentType(ContentType.JSON)
                .body("$", notNullValue());
    }

    @Test
    public void courseraCourseMatchTest() {
        RequestBody requestBody = RequestBody.builder()
                .clientType(CLIENT_TYPE_VALUE)
                .app(APP_VALUE)
                .clientVersion("60c52322ad4dee373a458a99ce740969796a2c90")
                .events(new Events[]{Events.builder()
                        .key("epic.experiment.show")
                        .url("https://www.coursera.org/campus-coursematch")
                        .guid("eb46171b-ea1f-4641-e676-7c6f73a0801f")
                        .visitId("34920d65-b23c-422a-bf48-66b6ca7ae0e9")
                        .clientTimestamp(CLIENT_TIMESTAMP_VALUE)
                        .value(Value.builder()
                                .namespace("Enterprise")
                                .idForAllocation("2696558095-1612936397381")
                                .experimentId("ezCygGDdEeuOBZtBEeSBFQ")
                                .variantId("A_f98NnkSN-8JJscG5jS7g")
                                .parameterName("enableGlobalNavEnterpriseDropdown")
                                .version(1)
                                .value(true)
                                .status("RUNNING")
                                .build())
                        .build()})
                .build();
        ObjectMapper mapper = new ObjectMapper();
        mapper.addMixIn(Value.class, IgnoreObjectNamespace.class);
        RestAssured.baseURI = BASE_URI;
        Response response = null;
        try {
            response = given()
                    .log().all()
                    .contentType(ContentType.JSON)
                    .body(mapper.writeValueAsString(requestBody))
                    .post(EVENTING_ENDPOINT);
        } catch (JsonProcessingException e) {
            LOGGER.error(e.getMessage());
        }
        Assert.assertNotNull(response);
        response.then()
                .log().ifValidationFails()
                .assertThat()
                .statusCode(StatusCode.OK_200.getValue())
                .contentType(ContentType.TEXT)
                .body(containsString("{\"200\":[\"Success\"]}"));
    }

    @Test
    public void setOrUpdateUserPreferencesTest() {
        File requestBody = JsonService.getJsonFile("body/request-body-user-preferences.xml");
        RestAssured.baseURI = BASE_URI;

        given()
                .log().all()
                .queryParam(ACTION_PARAMETER, ACTION_PARAM_VALUE_FOR_SET_OR_UPDATE_TEST)
                .queryParam(SESSION_ID_PARAMETER, SESSION_ID_VALUE_FOR_SET_OR_UPDATE_TEST)
                .queryParam(PRODUCT_ID_PARAMETER, PRODUCT_ID_VALUE_FOR_SET_OR_UPDATE_TEST)
                .body(requestBody)
                .post(ApiDataManager.get().endpointUserPreferences())
                .then()
                .log().ifValidationFails()
                .assertThat()
                .statusCode(StatusCode.OK_200.getValue())
                .contentType(ContentType.JSON)
                .body(equalTo("{}"));
    }

    @Test
    public void courseraBannerClosingTest() {
        RequestBody requestBody = RequestBody.builder()
                .clientType(CLIENT_TYPE_VALUE)
                .app(APP_VALUE)
                .clientVersion("75b637bab0ce8f1f4689598632e3277b59430477")
                .events(new Events[]{Events.builder()
                        .key("front_page.front_page_story.click.c4c_banner_close")
                        .url("https://www.coursera.org/")
                        .guid("717d0d6e-168a-4402-e389-6a01488f2064")
                        .visitId("974129c6-d4b3-4aa4-924a-2aac8f0b715d")
                        .clientTimestamp(SECOND_CLIENT_TIMESTAMP_VALUE)
                        .value(Value.builder()
                                .schemaType("FRONTEND")
                                .namespaceObject(Namespace.builder()
                                        .app("front_page")
                                        .page("front_page_story")
                                        .action("click")
                                        .component("c4c_banner_close")
                                        .build())
                                .build())
                        .build()})
                .build();
        ObjectMapper mapper = new ObjectMapper();
        mapper.addMixIn(Value.class, IgnoreStringNamespace.class);
        RestAssured.baseURI = BASE_URI;
        Response response = null;
        try {
            response = given()
                    .log().all()
                    .contentType(ContentType.JSON)
                    .body(mapper.writeValueAsString(requestBody))
                    .post(EVENTING_ENDPOINT);
        } catch (JsonProcessingException e) {
            LOGGER.error(e.getMessage());
        }
        Assert.assertNotNull(response);
        response.then()
                .log().ifValidationFails()
                .assertThat()
                .statusCode(StatusCode.OK_200.getValue())
                .contentType(ContentType.TEXT)
                .body(containsString("{\"200\":[\"Success\"]}"));
    }
}
