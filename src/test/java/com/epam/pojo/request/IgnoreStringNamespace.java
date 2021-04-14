package com.epam.pojo.request;

import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class IgnoreStringNamespace {
    @JsonIgnore
    private String namespace;
}
