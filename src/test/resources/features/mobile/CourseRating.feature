@critical-path @mobile
Feature: as a user I want to be sure that rating for the course displayed correctly

  Scenario: Rating info displayed correctly for the course
    Given the user opens app without login
    When the user inputs "language course" for search
    Then rating info displayed correctly
