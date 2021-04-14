@advanced @web
Feature: As a user I want to share information about Coursera to the twitter

  Scenario: Information to the twitter is shared, tweet window with appropriate text is displayed
    Given the user opens Coursera for students page
    When the user shares information to the twitter
    Then tweet window with text that contains "Coursera" is displayed