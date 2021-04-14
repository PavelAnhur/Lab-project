package com.epam.pojo.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Entries {
    private String id;
    private String courseId;
    private String onDemandSpecializationId;
    private String resourceName;
    private String score;
    @JsonProperty("isPartOfCourseraPlus")
    private boolean partOfCourseraPlus;
    @JsonProperty("isFreeCertificate")
    private boolean freeCertificate;
}
