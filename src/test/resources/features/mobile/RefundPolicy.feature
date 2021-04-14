@critical-path @mobile
Feature: As a user I want to be sure that the refund policy link works correctly

  Scenario: Refund policy link redirects correctly
    Given the user logs in coursera app with "Pavel" account
    When the user searches for the "Introduce to Java course" course
    And clicks on refund policy link
    Then page's header equals "Refund policies – Coursera Help Center"
