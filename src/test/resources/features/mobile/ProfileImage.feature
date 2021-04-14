@critical-path @mobile
Feature: As a user I want to get the ability to see profile image in coursera app

  Scenario: Profile image
    Given the user logs in coursera app with "Alex" account
    When the user opens profile
    Then the user can see profile image
