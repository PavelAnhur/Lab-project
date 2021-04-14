@smoke @mobile
Feature: As a user I want to open my subscriptions page

  Scenario: My subscriptions page is opened successfully
    Given the user logs in coursera app with "Vlad" account
    When the user opens profile settings
    And the user opens my subscriptions page
    Then my subscription page is opened, title name is "My Subscriptions"