@critical-path @mobile
Feature: As a user I want to be sure that university reference works correctly

  Scenario: University website reference works properly
    Given the user opens app without login
    When the user clicks on the first course from the explore page
    And the user clicks university website link
    Then particular university page is opened
