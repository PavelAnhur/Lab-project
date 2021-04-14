package com.epam.tests.api;

import com.epam.core.enums.StatusCode;
import com.epam.pojo.request.RequestBody;
import com.epam.pojo.response.ResponseBody;
import com.epam.service.ApiDataManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.equalTo;

public class UserCommunityAPITest {
    public static final String BASE_URI = ApiDataManager.get().uriCourseraCommunity();
    public static final String PHRASES_PARAMETER = ApiDataManager.get().parameterPhrases();
    public static final String USER_ID_PARAMETER = "ids%5B%5D";
    private static final String PHRASES = "phrases";
    private static final String LANGUAGE = "Language";
    private static final String FORMATTING_STYLES = "Formatting Styles";
    private static final int USER_ID = 39;
    private static final int TOPIC_VALUE = 45;
    private static final String VOTE_VALUE = "topichelpful";

    @Test
    public void getUserById() {
        RestAssured.baseURI = BASE_URI;
        given()
                .urlEncodingEnabled(false)
                .param(USER_ID_PARAMETER, USER_ID)
                .when()
                .get(ApiDataManager.get().endpointUserById())
                .then().log().ifError()
                .assertThat()
                .statusCode(StatusCode.OK_200.getValue())
                .body("39.id", equalTo(USER_ID));
    }

    @Test
    public void getFormForWritingNewPost() {
        RestAssured.baseURI = BASE_URI;
        given()
                .urlEncodingEnabled(false)
                .param(PHRASES, PHRASES_PARAMETER)
                .when()
                .get(ApiDataManager.get().endpointPhrases())
                .then().log().ifError()
                .assertThat()
                .statusCode(StatusCode.OK_200.getValue())
                .body("Forum != null", is(true))
                .body("Common.'editor.code.language'", equalTo(LANGUAGE))
                .body("Common.'editor.formatting.styles'", equalTo(FORMATTING_STYLES));
    }

    @Test
    public void votingTheTopicAsHelpful() {
        RequestBody requestBody = RequestBody.builder()
                .topic(TOPIC_VALUE)
                .vote(VOTE_VALUE)
                .build();
        RestAssured.baseURI = BASE_URI;
        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(ApiDataManager.get().endpointHelpfulness());
        response.then().log().ifError()
                .assertThat().statusCode(StatusCode.OK_200.getValue());
        Assert.assertNull(response.getBody().as(ResponseBody.class).getClassValue());
    }
}

