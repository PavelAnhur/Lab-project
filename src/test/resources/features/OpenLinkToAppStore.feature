@critical-path @web
Feature: As a user I want to get ability to go to App Store from Coursera for application download

  Scenario: The link to App Store works correctly after login
    Given the user with "Helen" google account is logged in
    When the user goes to App Store by the link
    Then the App Store page with "Coursera" for download is successfully opened