package com.epam.pojo.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ResponseBody {
    private Elements[] elements;
    private Paging paging;
    private Linked linked;
    private Section section;
    private String id;
    private String sectionId;
    @JsonProperty("class")
    private String classValue;
    private Data data;
}
