@critical-path @web
Feature: As a user I want ot open subscription plan help center page

  Scenario: Subscription plan page opens, correct header is displayed
    Given the user with "Helen" google account is logged in
    When the user opens help center page
    And the user opens payments and subscriptions help center page
    And the user opens change subscription plan help center page
    Then change subscription plan help center page header is "Change your subscription plan"
