package com.epam.pojo.request;

import lombok.Builder;
import lombok.Getter;

@Getter @Builder
public class ShortAnswerResponse {
    private final String text;
}
