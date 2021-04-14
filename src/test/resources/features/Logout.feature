@smoke @web
Feature: As a user I want to get ability to logout

  Scenario: Logout ability is available for the user
    Given the user with "Pavel" google account is logged in
    When the user clicks logout
    Then the user name is not displayed
