package com.epam.service;

import com.epam.core.utilities.property.PropertyDataReader;
import java.util.Properties;

public final class ApiDataManager {
    private static final Properties PROPERTIES = PropertyDataReader.getProperties("api-data");
    private static ApiDataManager instance;

    private ApiDataManager() {
    }

    public static ApiDataManager get() {
        if (instance == null) {
            instance = new ApiDataManager();
        }
        return instance;
    }

    public String uriApiCourseraOrg() {
        return PROPERTIES.getProperty("uri.api.coursera.org");
    }

    public String uriCourseraCommunity() {
        return PROPERTIES.getProperty("uri.coursera.community");
    }

    public String uriLearnerCourseraHelp() {
        return PROPERTIES.getProperty("uri.learner.coursera.help");
    }

    public String uriMasterTrackCertificates() {
        return PROPERTIES.getProperty("uri.master.track.certificates");
    }

    public String uriCourseraOrg() {
        return PROPERTIES.getProperty("uri.coursera.org");
    }

    public String uriAccountsCourseraOrg() {
        return PROPERTIES.getProperty("uri.accounts.coursera.org");
    }

    public String uriStatusCourseraOrg() {
        return PROPERTIES.getProperty("uri.status.coursera.org");
    }

    public String urlTargetCourseraForStudent() {
        return PROPERTIES.getProperty("url.target.coursera.for.student");
    }

    public String urlTargetCustomUrlCreation() {
        return PROPERTIES.getProperty("url.target.custom.url.creation");
    }

    public String queryCatalogDegreesData() {
        return PROPERTIES.getProperty("query.catalog.degrees.data");
    }

    public String queryAllDomains() {
        return PROPERTIES.getProperty("query.all.domains");
    }

    public String queryBannerCampaignsData() {
        return PROPERTIES.getProperty("query.banner.campaigns.data");
    }

    public String queryProfessionalCertificatesData() {
        return PROPERTIES.getProperty("query.professional.certificates.data");
    }

    public String queryMultipleGetPartners() {
        return PROPERTIES.getProperty("query.multiple.get.partners");
    }

    public String queryMegaMenuWithDomain() {
        return PROPERTIES.getProperty("query.mega.menu.with.domain");
    }

    public String queryCollection() {
        return PROPERTIES.getProperty("query.collection");
    }

    public String queryCollectionRecommendations() {
        return PROPERTIES.getProperty("query.collection.recommendations");
    }

    public String parameterPhrases() {
        return PROPERTIES.getProperty("parameter.phrases");
    }

    public String endpointForLearnerHelpTest() {
        return PROPERTIES.getProperty("endpoint.for.learner.help.test");
    }

    public String endpointAuth() {
        return PROPERTIES.getProperty("endpoint.auth");
    }

    public String endpointMaterialsApi() {
        return PROPERTIES.getProperty("endpoint.materials.api");
    }

    public String endpointCourseraForStudent() {
        return PROPERTIES.getProperty("endpoint.coursera.for.student");
    }

    public String endpointStatusApi() {
        return PROPERTIES.getProperty("endpoint.status.api");
    }

    public String endpointCoursesApi() {
        return PROPERTIES.getProperty("endpoint.courses.api");
    }

    public String endpointScheduleApi() {
        return PROPERTIES.getProperty("endpoint.schedule.api");
    }

    public String endpointCustomUrlsApi() {
        return  PROPERTIES.getProperty("endpoint.custom.urls.api");
    }

    public String endpointGraphQl() {
        return PROPERTIES.getProperty("endpoint.graph.ql");
    }

    public String endpointInstructorsApi() {
        return PROPERTIES.getProperty("endpoint.instructors.api");
    }

    public String endpointPartnersApi() {
        return PROPERTIES.getProperty("endpoint.partners.api");
    }

    public String endpointQualification() {
        return PROPERTIES.getProperty("endpoint.qualification");
    }

    public String endpointUserById() {
        return PROPERTIES.getProperty("endpoint.user.by.id");
    }

    public String endpointPhrases() {
        return PROPERTIES.getProperty("endpoint.phrases");
    }

    public String endpointHelpfulness() {
        return PROPERTIES.getProperty("endpoint.helpfulness");
    }

    public String endpointAliceMessagesApi() {
        return PROPERTIES.getProperty("endpoint.alice.messages.api");
    }

    public String endpointEventingInfoBatch() {
        return PROPERTIES.getProperty("endpoint.eventing.info.batch");
    }

    public String endpointUserPreferences() {
        return PROPERTIES.getProperty("endpoint.user.preferences");
    }
}
