@smoke @web
Feature: As a user I want to get the ability to add course to cart

  Scenario Outline: Add course to cart
    Given the user with "Alex" google account is logged in
    When the user enters "<Course>" course to search
    And the user adds course to cart
    Then the course "<Course>" added to cart
    Examples:
      | Course |
      | Java   |
      | Python |