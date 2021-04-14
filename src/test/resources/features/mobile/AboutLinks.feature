@critical-path @mobile
Feature: As a user I want to get the ability to see terms of use and privacy policy in coursera app

  Scenario: About links
    Given the user logs in coursera app with "Alex" account
    When the user opens profile
    And the user opens settings
    And the user opens terms of use
    Then the user can see "terms" page of "coursera"
    When the user opens privacy policy
    Then the user can see "privacy" page of "coursera"
