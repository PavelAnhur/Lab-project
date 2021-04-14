@advanced @mobile
Feature: As a user I want to get ability to cancel some course

  Scenario: The course should be added and canceled
    Given the user logs in coursera app with "Helen" account
    When the user adds a "free course"
    And  the user cancels this free course
    Then the free course is successfully canceled with the message "You haven't enrolled in any courses (yet)"
