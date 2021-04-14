@critical-path @mobile
Feature: As a user I want to use filters for courses searching

  Scenario: Introduction to Java Database Connectivity course is opened through search with filters
    Given the user opens app without login
    When the user searches for "Java" courses with advanced level filter
    And the user opens Database Connectivity course
    Then the course page is opened, page text contains "Introduction To Java Database Connectivity - JDBC"