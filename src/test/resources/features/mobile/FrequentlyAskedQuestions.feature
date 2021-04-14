@critical-path @mobile
Feature: As user I want to get the ability to see a list of frequently asked questions

  Scenario: The list of frequently asked questions is displayed on the course page
    Given the user logs in coursera app with "Helen" account
    When the user opens first course in the list topics
    And the user opens first of the most popular courses
    Then the user sees not empty list of frequently asked questions
