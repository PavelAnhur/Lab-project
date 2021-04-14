@smoke @mobile
Feature: As a user I want to get ability login with valid credentials

  Scenario Outline: Login with valid credentials
    Given the user enters "<account>" credentials at the login page
    Then user's email is displayed
    Examples:
      | account |
      | Pavel   |
      | Vlad    |
      | Alex    |
      | Helen   |
