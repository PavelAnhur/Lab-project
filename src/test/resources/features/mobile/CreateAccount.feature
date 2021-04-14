@smoke @mobile
Feature: As a user I want be able to create new account

  Scenario: User creates a new account with valid credentials
    Given the user clicks create account button
    When the user enters valid credentials
    Then account is created
