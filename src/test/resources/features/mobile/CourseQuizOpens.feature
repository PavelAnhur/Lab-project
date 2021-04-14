@critical-path @mobile
Feature: As a user I want to open course quiz

  Scenario: Course quiz is opened
    Given the user logs in coursera app with "Vlad" account
    When the user opens course quiz
    Then the quiz is opened, title with text "Question 1/15" is presented