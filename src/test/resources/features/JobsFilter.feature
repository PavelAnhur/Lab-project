@advanced @web
Feature: Filter on https://jobs.lever.co/ page works correctly

  Scenario: If the user uses filter it should be displayed correctly
    Given the user opens jobs page
    When the user uses filter on the jobs page
    Then result should contains same values
