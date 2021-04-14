@critical-path @mobile
Feature: As a user I want to open help center page

  Scenario: Help center page is opened successfully
    Given the user logs in coursera app with "Vlad" account
    When the user opens profile settings
    And the user taps learner help center button
    Then help center page is opened, header is displayed
