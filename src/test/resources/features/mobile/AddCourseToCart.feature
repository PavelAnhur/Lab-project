@smoke @mobile
Feature: As a user I want to get the ability to add course to cart in coursera app

  Scenario: Add course to cart
    Given the user logs in coursera app with "Alex" account
    When the user choose "Java" course to search
    And the user adds this course to cart
    Then the user can see "Purchase" screen
