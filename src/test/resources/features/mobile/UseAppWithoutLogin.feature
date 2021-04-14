@smoke @mobile
Feature: As a user I want to use app without login

  Scenario: Do not login
    Given the user opens app without login
    Then explore menu opens, header is "Explore"