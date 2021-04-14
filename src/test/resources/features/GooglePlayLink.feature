@critical-path @web
Feature: As a user I want to get the ability to click on Google Play button and see Coursera app

  Scenario: Google Play app
    Given the user opens Coursera website
    When the user opens google play market
    Then "Coursera" app title is visible on google play market