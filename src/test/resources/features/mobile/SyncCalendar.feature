@advanced @mobile
Feature: As a user I want ot sync courses with my calendar

  Scenario: Sync courses with calendar is successful
    Given the user logs in coursera app with google account
    When the user opens profile settings
    And the user taps sync to my calendar switch
    Then the calendar is synced