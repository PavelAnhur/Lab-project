@smoke @web
Feature: As a user I want to get the ability to delete course from cart

  Scenario: Delete course from cart
    Given the user with "Alex" google account is logged in
    When the user enters "Java" course to search
    And the user adds course to cart
    And the user removes item from cart
    Then item deleted from cart