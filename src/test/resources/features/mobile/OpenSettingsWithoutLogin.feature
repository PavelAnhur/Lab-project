@critical-path @mobile
Feature: As a user I want not to get the ability to open settings without login in coursera app

  Scenario: Open settings without login
    Given the user opens app without login
    When the user opens profile
    And the user opens settings
    Then the user redirected to the login screen
