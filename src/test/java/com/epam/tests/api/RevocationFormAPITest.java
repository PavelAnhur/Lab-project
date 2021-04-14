package com.epam.tests.api;

import com.epam.core.enums.StatusCode;
import com.epam.pojo.request.RequestBody;
import com.epam.pojo.request.Responses;
import com.epam.pojo.request.FirstName;
import com.epam.pojo.request.LastName;
import com.epam.pojo.request.EmailAddress;
import com.epam.pojo.request.PhoneNumber;
import com.epam.pojo.request.ShortAnswerResponse;
import com.epam.pojo.response.ResponseBody;
import com.epam.service.ApiDataManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static com.epam.service.WWWCourseraOrgTestManager.BASE_URI;
import static com.epam.service.WWWCourseraOrgTestManager.ACTION_PARAMETER;
import static com.epam.service.WWWCourseraOrgTestManager.PRODUCT_ID_PARAMETER;

public class RevocationFormAPITest {
    private static final String FIELDS_ACTION = "createOrUpdate";
    private static final String FIELDS_PRODUCT_ID = "GenericPage~credentialtracks";
    private static final String SECTION_ID_VALUE = "section1";
    private static final String FIRST_NAME_TEXT_VALUE = "dddd";
    private static final String LAST_NAME_TEXT_VALUE = "aaaa";
    private static final String EMAIL_TEXT_VALUE = "elenazayast1993@gmail.com";
    private static final String PHONE_NUMBER_TEXT_VALUE = "wwww";
    private static final String CONTAINS_TEXT_VALUE = "Thank you for requesting information";


    @Test
    public void getFillingRevocationForm() {
        RequestBody requestBody = RequestBody.builder()
                .sectionId(SECTION_ID_VALUE)
                .responses(Responses.builder()
                        .firstName(FirstName.builder()
                                .shortAnswerResponse(ShortAnswerResponse.builder()
                                        .text(FIRST_NAME_TEXT_VALUE)
                                        .build())
                                .build())
                        .lastName(LastName.builder()
                                .shortAnswerResponse(ShortAnswerResponse.builder()
                                        .text(LAST_NAME_TEXT_VALUE)
                                        .build())
                                .build())
                        .emailAddress(EmailAddress.builder()
                                .shortAnswerResponse(ShortAnswerResponse.builder()
                                        .text(EMAIL_TEXT_VALUE)
                                        .build())
                                .build())
                        .phoneNumber(PhoneNumber.builder()
                                .shortAnswerResponse(ShortAnswerResponse.builder()
                                        .text(PHONE_NUMBER_TEXT_VALUE)
                                        .build())
                                .build())
                        .build())
                .build();
        RestAssured.baseURI = BASE_URI;
        Response response = given()
                .urlEncodingEnabled(false)
                .queryParam(ACTION_PARAMETER, FIELDS_ACTION)
                .queryParam(PRODUCT_ID_PARAMETER, FIELDS_PRODUCT_ID)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(ApiDataManager.get().endpointQualification());
        response.then().log().ifError()
                .assertThat()
                .statusCode(StatusCode.OK_200.getValue());
        ResponseBody responseBody = response.getBody().as(ResponseBody.class);
        Assert.assertNotNull(responseBody.getId());
        Assert.assertTrue(responseBody.getSection().getDefinition().getBody().getDefinition().getValue()
                .contains(CONTAINS_TEXT_VALUE));
    }
}
