@smoke @mobile
Feature: As user I want to be sure, that search field works correctly

  Scenario: Search field works correctly
    Given the user opens app without login
    When the user inputs "Java core" for search
    And the user clicks on the first result
    Then  Header of the page should contain "Java core" words
