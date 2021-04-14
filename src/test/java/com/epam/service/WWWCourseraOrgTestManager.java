package com.epam.service;

import com.epam.core.utilities.service.StringService;
import com.epam.pojo.request.RequestBody;

public final class WWWCourseraOrgTestManager {

    private WWWCourseraOrgTestManager() {
    }

    public static final String BASE_URI = ApiDataManager.get().uriCourseraOrg();
    public static final String ACTION_PARAMETER = "action";
    public static final String PRODUCT_ID_PARAMETER = "productId";
    public static final String OPNAME_PARAMETER = "opname";

    public static String getFirstWordInCollectionName(final RequestBody[] requestBody) {
        String firstWordInCollectionName = StringService.getFirstWordFromString(requestBody[0].
                getVariables().getContextId(), "-");
        firstWordInCollectionName = StringService.getCapitalizedWord(firstWordInCollectionName);
        return firstWordInCollectionName;
    }
}
