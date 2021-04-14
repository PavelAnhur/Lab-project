@smoke @mobile
Feature: As a user I want to get the ability to login with google account in coursera app

  Scenario: Login with google account
    When the user logs in coursera app with google account
    And the user opens profile
    Then the user can see "coursera tests" username
