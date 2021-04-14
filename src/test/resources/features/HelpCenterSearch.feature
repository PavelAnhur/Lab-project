@smoke @web
Feature: As a user I want to get correct information by request to help center

  Scenario: Request to help center should equals response by help center
    Given the user with "Helen" google account is logged in
    When the user opens help center page
    And the user inputs data "Reset your Coursera password" for search
    Then the request data "Reset your Coursera password" equals response data