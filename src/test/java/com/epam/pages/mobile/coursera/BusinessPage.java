package com.epam.pages.mobile.coursera;

import com.epam.core.mobile.base.page.BaseMobilePage;
import com.epam.core.utilities.service.MobileElementsService;
import com.epam.core.utilities.service.WaitersService;
import com.epam.core.utilities.service.WebElementsService;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import java.util.List;

public class BusinessPage extends BaseMobilePage {
    private static final String RESOURCE_ID = "org.coursera.android:id/catalog_v3_header_recycler_view";
    private static final String TEXT_CONTAINS = "Business Strategy";

    @AndroidFindBy(id = "org.coursera.android:id/catalog_v3_header")
    private MobileElement headerBusiness;

    @AndroidFindBy(id = "org.coursera.android:id/catalog_v3_header_recycler_view")
    private MobileElement businessSections;

    @AndroidFindBy(id = "org.coursera.android:id/catalog_v3_header_pill_name")
    private List<MobileElement> listBusinessSections;

    public String getHeaderBusinessPage() {
        WaitersService.waitForVisibilityOfElement(getDriver(), headerBusiness);
        String header = headerBusiness.getText();
        getLogger().info("get header name: {}", header);
        return header;
    }

    public List<String> getListBusinessSections() {
        WaitersService.waitForVisibilityOfElement(getDriver(), businessSections);
        List<String> nameBusinessSections = WebElementsService.getListOfWebElementsText(listBusinessSections);
        MobileElementsService.horizontalScrollToElementWith(RESOURCE_ID, TEXT_CONTAINS);
        listBusinessSections.forEach(nameSection -> nameBusinessSections.add(nameSection.getText()));
        getLogger().info("get list actual topics");
        return nameBusinessSections;
    }

    public boolean isBusinessSectionIncludesTopics(final List<String> actualTopics) {
        List<String> realTopics = getListBusinessSections();
        getLogger().info("comparing real topics with actual topics");
        return actualTopics.containsAll(realTopics);
    }
}
