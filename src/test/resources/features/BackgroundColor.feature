@advanced @web
Feature: As a user I want to get the ability to click on vote-up button and it background color should change

  Scenario: Background color of vote-up button
    Given the user with "Alex" google account is logged in
    When the user goes to help center and opens help article
    And the user clicks on vote-up button
    Then background color of vote-up button changes