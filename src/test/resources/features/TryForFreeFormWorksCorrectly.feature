@critical-path @web
Feature: I want to check if try for free form doesn't send without applied checkbox

  Scenario: Try for free form doesn't send without applied checkbox, alert is displayed
    Given the user opens try for free form page
    When the user fills all of the form fields with data
    And the user clicks submit
    Then the form is not sent, alert is presented
