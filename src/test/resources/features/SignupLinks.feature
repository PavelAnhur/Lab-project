@critical-path @web
Feature: As a user I want to get the ability to click on links at signup page and they should work correctly

  Scenario: Links at signup page works correctly
    Given the user opens Coursera website
    When the user opens signup page
    And the user opens "Terms of Use" page
    Then the user redirected to the "Terms of Use" page
    When the user opens "Privacy Notice" page
    Then the user redirected to "Privacy Notice" page