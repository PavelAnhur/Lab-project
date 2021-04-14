@smoke @web
Feature: Coursera element at the left-top corner redirects correctly

  Scenario: Coursera home page should be opened after click on main element
    Given the user opens software testing page
    When the user clicks on the main Coursera element at the top-left corner
    Then Coursera home page should be opened
