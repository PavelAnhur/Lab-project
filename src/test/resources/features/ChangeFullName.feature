@smoke @web
Feature: As a user I want to change full name in account settings

  Scenario: Full name should be change successfully
    Given the user with "Vlad" google account is logged in
    When the user opens account settings
    And the user changes full name
    Then status message with "Update successful!" text is displayed