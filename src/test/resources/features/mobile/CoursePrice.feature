@critical-path @mobile
Feature: As user I want to get ability to see course price

  Scenario: The course price is displayed
    Given the user logs in coursera app with "Helen" account
    When the user goes to explore page through bottom section
    And the user selects the first course from the list Trending courses
    Then the user sees information with the price
