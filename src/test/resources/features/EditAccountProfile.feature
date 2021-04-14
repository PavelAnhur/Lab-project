@critical-path @web
Feature: As a user I want to get ability to edit account profile

  Scenario: the User can edit account profile
    Given the user with "Pavel" google account is logged in
    When the user edits account profile
    And confirms save changes
    Then the user gets a successfully saved changes message
