package com.epam.service;

import com.epam.core.model.User;
import com.epam.core.utilities.property.PropertyDataReader;

import java.util.Properties;

public final class UsersManager {
    private static final Properties PROPERTIES = PropertyDataReader.getProperties(System.getProperty("tests-data"));

    private UsersManager() {
    }

    public static User getCourseraUser() {
        return CourseraUserHolder.COURSERA_USER;
    }

    public static User getUserWithProfileProperties() {
        return UserWithProfilePropertiesHolder.USER_WITH_PROFILE_PROPERTIES;
    }

    public static User getUserEmailU() {
        return UserEmailUHolder.USER_EMAIL_U;
    }

    public static User getGoogleUser() {
        return GoogleUserHolder.GOOGLE_USER;
    }

    public static User getMobileUserPavel() {
        return MobilePavelUser.MOBILE_PAVEL_USER;
    }

    private static class CourseraUserHolder {
        public static final User COURSERA_USER = User.newBuilder()
                .setEmail(PROPERTIES.getProperty("coursera.email"))
                .setPassword(PROPERTIES.getProperty("coursera.password"))
                .build();
    }

    private static class UserWithProfilePropertiesHolder {
        public static final User USER_WITH_PROFILE_PROPERTIES = User.newBuilder()
                .setEmail(PROPERTIES.getProperty("pavelTests.email"))
                .setPassword(PROPERTIES.getProperty("pavelTests.password"))
                .setEmployedTimeStatus(PROPERTIES.getProperty("employedTimeStatus"))
                .setIndustry(PROPERTIES.getProperty("industry"))
                .setEmployer(PROPERTIES.getProperty("employer"))
                .setOccupation(PROPERTIES.getProperty("occupation"))
                .setExperiencedLevel(PROPERTIES.getProperty("experiencedLevel"))
                .setIsItYourCurrentEmployer(PROPERTIES.getProperty("isItYourCurrentEmployer"))
                .setHighestDegree(PROPERTIES.getProperty("highestDegree"))
                .setUniversity(PROPERTIES.getProperty("university"))
                .setEducationMajor(PROPERTIES.getProperty("educationMajor"))
                .setAreYouCurrentlyStudent(PROPERTIES.getProperty("areYouCurrentlyStudent"))
                .build();
    }

    private static class UserEmailUHolder {
        public static final User USER_EMAIL_U = User.newBuilder()
                .setEmail(PROPERTIES.getProperty("emailU"))
                .setPassword(PROPERTIES.getProperty("passwordU"))
                .setFirstName(PROPERTIES.getProperty("form.firstname"))
                .setLastName(PROPERTIES.getProperty("form.lastname"))
                .setPhoneNumber(PROPERTIES.getProperty("form.phonenumber"))
                .setLocation(PROPERTIES.getProperty("form.country"))
                .setState(PROPERTIES.getProperty("form.state"))
                .setTwitterPassword(PROPERTIES.getProperty("twitter.password"))
                .setTwitterUserName(PROPERTIES.getProperty("twitter.userName"))
                .build();
    }

    private static class GoogleUserHolder {
        public static final User GOOGLE_USER = User.newBuilder()
                .setEmail(PROPERTIES.getProperty("google.email"))
                .setPassword(PROPERTIES.getProperty("google.password"))
                .setFirstName(PROPERTIES.getProperty("confirmation.firstname"))
                .setMiddleName(PROPERTIES.getProperty("confirmation.middlename"))
                .setLastName(PROPERTIES.getProperty("confirmation.lastname"))
                .setFullName(PROPERTIES.getProperty("user.name"))
                .build();
    }

    private static class MobilePavelUser {
        public static final User MOBILE_PAVEL_USER = User.newBuilder()
                .setEmail(PROPERTIES.getProperty("mobile.pavel.email"))
                .setPassword(PROPERTIES.getProperty("mobile.pavel.password"))
                .build();
    }
}


