@critical-path @web
Feature: As a user I want to see the score in the course match table in the right order

  Scenario: Relevant score in campus course match is appeared in the right order
    Given the user opens coursera for campus page
    When the user opens coursera coursematch page
    Then elements form relevant score collum are in descending order
