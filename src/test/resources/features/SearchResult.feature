@smoke @web
Feature: As a user I want to be sure I get the correct search result

  Scenario: Search with coursera.org search field
    Given the user opens Coursera website
    When the user searches for the "java core"
    And the user clicks on the first search result
    Then the search result should contain "java core"
