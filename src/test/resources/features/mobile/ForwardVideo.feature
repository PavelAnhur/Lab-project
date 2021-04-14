@critical-path @mobile
Feature: As a user I want to forward course video by double tap

  Scenario: Course video is forwarded for 10 seconds
    Given the user logs in coursera app with "Vlad" account
    When the user opens course and starts watching video
    And the user pauses the video and double taps to a right side of player
    Then the video is forwarded successfully