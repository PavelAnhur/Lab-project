package com.epam.core.enums;

public enum Context {
    WEBVIEW("WEBVIEW_org"),
    NATIVE("NATIVE_APP");

    private final String contextName;

    Context(final String context) {
        this.contextName = context;
    }

    public String getContextName() {
        return contextName;
    }
}
