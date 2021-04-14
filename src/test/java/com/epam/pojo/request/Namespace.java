package com.epam.pojo.request;

import lombok.Builder;
import lombok.Getter;

@Getter @Builder
public class Namespace {
    private final String app;
    private final String page;
    private final String action;
    private final String component;
}
