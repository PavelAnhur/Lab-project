package com.epam.core.enums;

public enum StatusCode {
    OK_200(200),
    OK_201(201),
    ERROR_400(400),
    ERROR_404(404);

    private final int value;

    StatusCode(final int statusCodeValue) {
        this.value = statusCodeValue;
    }

    public int getValue() {
        return value;
    }
}
