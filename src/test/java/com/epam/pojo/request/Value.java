package com.epam.pojo.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter @Builder
public class Value {
    private final String namespace;
    private final String idForAllocation;
    private final String experimentId;
    private final String variantId;
    private final String parameterName;
    private final int version;
    private final boolean value;
    private final String status;
    @JsonProperty("namespace")
    private final Namespace namespaceObject;
    @JsonProperty("schema_type")
    private final String schemaType;
}
