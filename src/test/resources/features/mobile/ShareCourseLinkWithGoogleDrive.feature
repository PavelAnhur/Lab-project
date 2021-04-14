@advanced @mobile
Feature: As a user I want to get ability to share the course link with google drive

  Scenario: the course link sharing with google drive
    Given the user logs in coursera app with "Helen" account
    When the user opens the first course from the list of most popular through explore page
    And the user saves the course link to drive
    Then the user sees the course shared
