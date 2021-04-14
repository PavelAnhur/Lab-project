@critical-path @web
Feature: As a user I want to get ability to choose some section by coursera for business

  Scenario: Course should be found
    Given the user with "Helen" google account is logged in
    When the user goes to coursera for business
    And the user choose "Software Engineering Academy" section
    Then the transition to the section "Software Engineering Academy" is successfully done