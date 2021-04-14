@smoke @web
Feature: As a user I want to open Global Master of Public Health course page in dropdown menu

  Scenario: Global Master of Public Health course page is opened, header is correct
    Given the user opens Coursera website
    When the user opens Global Master of Public Health course page
    Then the page is opened, header is "Global Master of Public Health (GMPH)" or "Sorry"
