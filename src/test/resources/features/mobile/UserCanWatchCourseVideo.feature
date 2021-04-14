@critical-path @mobile
Feature: As a user I want to watch course video

  Scenario: Course video is displayed
    Given the user logs in coursera app with "Vlad" account
    When the user opens course and starts watching video
    Then the video is displayed