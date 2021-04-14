@advanced @web
Feature: As a user I want to get the ability to click on coursera blog link
  and verify that one hundred latest posts are in descending order

  Scenario: Blog latest posts
    Given the user opens Coursera website
    When the user goes to coursera blog
    Then one hundred latest posts are in descending order