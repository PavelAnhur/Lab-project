package com.epam.pojo.request;

import lombok.Builder;
import lombok.Getter;

@Getter @Builder
public class Variables {
    private final boolean liveOnly;
    private final String placement;
    private final int bannerCount;
    private final String[] ids;
    private final boolean skip;
    private final String start;
    private final String contextId;
    private final String contextType;
    private final int numEntriesPerCollection;
    private final int limit;
}
