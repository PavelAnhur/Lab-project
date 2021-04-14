@smoke @web
Feature: As a user I want to get the ability to confirm real name in account settings

  Scenario: Confirm real name
    Given the user with "Alex" google account is logged in
    When the user opens account settings
    And the user confirms real name
    Then verification message is visible