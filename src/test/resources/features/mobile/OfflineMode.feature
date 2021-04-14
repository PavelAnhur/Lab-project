@smoke @mobile
Feature: As a user I want to get the ability to turn on offline mode in coursera app

  Scenario: Offline mode
    Given the user logs in coursera app with "Alex" account
    When the user opens profile
    And the user opens settings and turns on offline mode
    Then the user can see "You're using Coursera offline" message
