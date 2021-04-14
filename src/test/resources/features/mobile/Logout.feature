@smoke @mobile
Feature: As a user I want to get ability to logout

  Scenario: Logout ability is available for the user
    Given the user logs in coursera app with "Pavel" account
    When the user tries to logout
    Then login page is displayed
