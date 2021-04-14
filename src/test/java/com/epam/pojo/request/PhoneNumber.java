package com.epam.pojo.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter @Builder
public class PhoneNumber {
    @JsonProperty("org.coursera.survey.question.ShortAnswerResponse")
    private final ShortAnswerResponse shortAnswerResponse;
}
