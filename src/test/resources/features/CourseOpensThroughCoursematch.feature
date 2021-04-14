@smoke @web
Feature: As a user I want to open first result course at coursematch page

  Scenario: First result course page is opened, header text is correct
    Given the user opens coursera for campus page
    When the user opens coursera coursematch page
    And the user opens first result link page
    Then first result course page is opened, header is correct