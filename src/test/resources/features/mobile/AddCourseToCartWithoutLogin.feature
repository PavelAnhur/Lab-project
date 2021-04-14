@smoke @mobile
Feature: As a user I want not to get the ability to add course to cart without login in coursera app

  Scenario: Add course to cart without login
    Given the user opens app without login
    When the user choose "Java" course to search
    And the user try to add course to cart
    Then the user redirected to the login screen
