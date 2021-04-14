@critical-path @mobile
Feature: As a user I want to get ability to send logs

  Scenario: User has ability to send logs
    Given the user logs in coursera app with "Pavel" account
    When the user tries to send logs
    Then successful status message is displayed
