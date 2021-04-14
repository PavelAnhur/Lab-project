@smoke @web
Feature: As a user I want to get ability to delete account

  Scenario: Delete account function is available for User
    Given the user with "Pavel" google account is logged in
    When the user opens account settings
    And clicks on delete account
    Then account should be deleted
