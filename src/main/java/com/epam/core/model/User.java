package com.epam.core.model;

public final class User {
    private String firstName;
    private String middleName;
    private String lastName;
    private String fullName;
    private String email;
    private String password;
    private String employedTimeStatus;
    private String industry;
    private String employer;
    private String occupation;
    private String experiencedLevel;
    private String isItYourCurrentEmployer;
    private String highestDegree;
    private String university;
    private String educationMajor;
    private String areYouCurrentlyStudent;
    private String phoneNumber;
    private String location;
    private String state;
    private String twitterPassword;
    private String twitterUserName;

    public String getExperiencedLevel() {
        return experiencedLevel;
    }

    public String getIsItYourCurrentEmployer() {
        return isItYourCurrentEmployer;
    }

    public String getHighestDegree() {
        return highestDegree;
    }

    public String getUniversity() {
        return university;
    }

    public String getEducationMajor() {
        return educationMajor;
    }

    public String getAreYouCurrentlyStudent() {
        return areYouCurrentlyStudent;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getEmployedTimeStatus() {
        return employedTimeStatus;
    }

    public String getIndustry() {
        return industry;
    }

    public String getEmployer() {
        return employer;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getLocation() {
        return location;
    }

    public String getState() {
        return state;
    }

    public String getTwitterPassword() {
        return twitterPassword;
    }

    public String getTwitterUserName() {
        return twitterUserName;
    }

    public static UserBuilder newBuilder() {
        return new User().new UserBuilder();
    }

    public class UserBuilder {

        public UserBuilder setFirstName(final String firstNameInput) {
            User.this.firstName = firstNameInput;
            return this;
        }

        public UserBuilder setMiddleName(final String middleNameInput) {
            User.this.middleName = middleNameInput;
            return this;
        }

        public UserBuilder setLastName(final String lastNameInput) {
            User.this.lastName = lastNameInput;
            return this;
        }

        public UserBuilder setExperiencedLevel(final String experiencedLevelInput) {
            User.this.experiencedLevel = experiencedLevelInput;
            return this;
        }

        public UserBuilder setIsItYourCurrentEmployer(final String isItYourCurrentEmployerInput) {
            User.this.isItYourCurrentEmployer = isItYourCurrentEmployerInput;
            return this;
        }

        public UserBuilder setHighestDegree(final String highestDegreeInput) {
            User.this.highestDegree = highestDegreeInput;
            return this;
        }

        public UserBuilder setUniversity(final String universityInput) {
            User.this.university = universityInput;
            return this;
        }

        public UserBuilder setEducationMajor(final String educationMajorInput) {
            User.this.educationMajor = educationMajorInput;
            return this;
        }

        public UserBuilder setAreYouCurrentlyStudent(final String areYouCurrentlyStudentInput) {
            User.this.areYouCurrentlyStudent = areYouCurrentlyStudentInput;
            return this;
        }

        public UserBuilder setEmail(final String inputEmail) {
            User.this.email = inputEmail;
            return this;
        }

        public UserBuilder setPassword(final String inputPassword) {
            User.this.password = inputPassword;
            return this;
        }

        public UserBuilder setEmployedTimeStatus(final String employedTimeStatusInput) {
            User.this.employedTimeStatus = employedTimeStatusInput;
            return this;
        }

        public UserBuilder setIndustry(final String industryInput) {
            User.this.industry = industryInput;
            return this;
        }

        public UserBuilder setEmployer(final String employerInput) {
            User.this.employer = employerInput;
            return this;
        }

        public UserBuilder setOccupation(final String occupationInput) {
            User.this.occupation = occupationInput;
            return this;
        }

        public UserBuilder setPhoneNumber(final String phoneNumberInput) {
            User.this.phoneNumber = phoneNumberInput;
            return this;
        }

        public UserBuilder setFullName(final String fullNameInput) {
            User.this.fullName = fullNameInput;
            return this;
        }

        public UserBuilder setLocation(final String locationInput) {
            User.this.location = locationInput;
            return this;
        }

        public UserBuilder setState(final String stateInput) {
            User.this.state = stateInput;
            return this;
        }

        public UserBuilder setTwitterPassword(final String twitterPasswordInput) {
            User.this.twitterPassword = twitterPasswordInput;
            return this;
        }

        public UserBuilder setTwitterUserName(final String twitterUser) {
            User.this.twitterUserName = twitterUser;
            return this;
        }

        public User build() {
            return User.this;
        }
    }
}
