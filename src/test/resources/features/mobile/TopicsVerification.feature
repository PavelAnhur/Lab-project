@advanced @mobile
Feature: As a user I want to get the ability to verify topics at topics screen in coursera app

  Scenario: Topics verification
    Given the user opens app without login
    When the user opens topics
    And the user swipes topics in recycler view
    Then the user can see that these topics are equals
