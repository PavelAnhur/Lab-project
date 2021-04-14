package com.epam.service;

public final class APICourseraOrgTestManager {

    private APICourseraOrgTestManager() {
    }

    public static final String BASE_URI = ApiDataManager.get().uriApiCourseraOrg();
    public static final String FIELDS_PARAMETER = "fields";
    public static final String START_PARAMETER = "start";
    public static final String LIMIT_PARAMETER = "limit";
    public static final String ELEMENTS_SIZE = "elements.size()";
    public static final String INCLUDES_PARAMETER = "includes";
    public static final String Q_PARAMETER = "q";
}
