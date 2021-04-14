@advanced @mobile
Feature: as a user I want be able to share the course with Gmail

  Scenario: User can share the course with Gmail
    Given the user logs in coursera app with "Pavel" account
    When the user shares the course with Gmail "qapaveltest@gmail.com"
    Then mail is received