@critical-path @mobile
Feature: As user I want to get the ability to see the most popular courses by the given topic

  Scenario: The most popular courses is opened by the given topic
    Given the user logs in coursera app with "Helen" account
    When the user opens first course in the list topics
    And the user opens the most popular courses
    Then the user sees almost one course witch contains average user rating
