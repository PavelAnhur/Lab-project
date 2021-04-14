package com.epam.pojo.response;

import lombok.Getter;

@Getter
public class Definition {
    private boolean inviteToGroup;
    private String[] recommendations;
    private Body body;
    private String title;
    private String value;
    private String dtdId;
}
