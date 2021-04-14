package com.epam.pojo.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Data {
    @JsonProperty("PartnersV1Resource")
    private PartnersResource partnersResource;

    @JsonProperty("DomainsV1Resource")
    private DomainsResource domainsResource;

    @JsonProperty("BrowseCollectionsV1Resource")
    private BrowseCollectionsResource browseCollectionsResource;
}
