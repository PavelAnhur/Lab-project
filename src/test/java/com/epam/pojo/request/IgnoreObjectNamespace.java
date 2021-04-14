package com.epam.pojo.request;

import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class IgnoreObjectNamespace {
    @JsonIgnore
    private Namespace namespaceObject;
}
