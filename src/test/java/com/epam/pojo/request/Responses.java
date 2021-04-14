package com.epam.pojo.request;

import lombok.Builder;
import lombok.Getter;

@Getter @Builder
public class Responses {
    private final FirstName firstName;
    private final LastName lastName;
    private final EmailAddress emailAddress;
    private final PhoneNumber phoneNumber;
}
