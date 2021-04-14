@critical-path @web
Feature: As a user I want to get a list of frequently asked questions

  Scenario:  A list of frequently asked questions should displayed on the page Coursera for student
    Given the user with "Helen" google account is logged in
    When the user goes to coursera for student
    Then the list of frequently asked questions is displayed on the page Coursera for student