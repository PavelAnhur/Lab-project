@critical-path @web
Feature: As a user I want to use filters for courses searching

  Scenario: Learn to teach Java course page is opened, through search with filters
    Given the user opens Coursera website
    When the user searches for "Java" courses with language filter russian and beginner level filter
    And the user opens "Learn to Teach Java" course
    Then the course page is opened, header text contains "Learn to Teach Java"