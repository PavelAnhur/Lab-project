package com.epam.pojo.request;

import lombok.Builder;
import lombok.Getter;

@Getter @Builder
public class Events {
    private final String key;
    private final Value value;
    private final String url;
    private final String guid;
    private final String visitId;
    private final long clientTimestamp;
}
