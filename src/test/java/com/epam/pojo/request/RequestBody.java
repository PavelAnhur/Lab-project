package com.epam.pojo.request;

import lombok.Builder;
import lombok.Getter;

@Getter @Builder
public class RequestBody {
    private final String targetUrl;
    private final String customSlug;
    private final String operationName;
    private final Variables variables;
    private final String query;
    private final String sectionId;
    private final Responses responses;
    private final int topic;
    private final String vote;
    private final String clientType;
    private final String app;
    private final String clientVersion;
    private final Events[] events;
}
