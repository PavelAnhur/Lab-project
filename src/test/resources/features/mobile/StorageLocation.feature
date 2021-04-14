@critical-path @mobile
Feature: As a user I want to get the ability to choose storage location in coursera app

  Scenario: Storage location
    Given the user logs in coursera app with "Alex" account
    When the user opens profile
    And the user opens settings
    And the user changes storage location
    Then the user can see that storage location changed
