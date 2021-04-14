@advanced @web
Feature: As a user I want to get ability to cancel some course

  Scenario: Course should be added and canceled
    Given the user with "Helen" google account is logged in
    When the user adds some free course
    And the user cancels the free course
    Then the course is successfully canceled