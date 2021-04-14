@critical-path @mobile
Feature: As user I want to get the ability to view payment information in settings

  Scenario: Payment information opens in settings
    Given the user logs in coursera app with "Helen" account
    When the user opens profile
    And the user opens settings and selects the payment information section
    Then the user can see page with the header "Payment Information" and message with "Default Payment Method" text
