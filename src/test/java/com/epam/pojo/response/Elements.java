package com.epam.pojo.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Elements {
    private String customSlug;
    private String id;
    private String targetUrl;
    private String name;
    private String description;
    private Subdomains subdomains;
    private String domainId;
    private String label;
    private String linkedCollectionPageMetadata;
    private String debug;
    private Entries[] entries;
    private Courses courses;
    @JsonProperty("s12ns")
    private Sns sns;
    private String slug;
    private String logo;
    private String[] courseIds;
    private Partners partners;
    private Metadata metadata;
    private String productVariant;
    private String squareLogo;
    private String classLogo;
    private String photoUrl;
    private CourseDerivatives courseDerivatives;
    private Derivative derivative;
}
