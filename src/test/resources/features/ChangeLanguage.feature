@smoke @web
Feature: As a user I want to change a language in account settings

  Scenario: Language should be changed successfully
    Given the user with "Helen" google account is logged in
    When the user opens account settings
    And the user changes language
    Then the language is successfully updated
