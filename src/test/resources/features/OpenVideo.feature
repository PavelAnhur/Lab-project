@critical-path @web
Feature: Course Overview video can be opened

  Scenario: User available to watch the video
    Given the user opens "Information System Auditing" page from search result
    When the user clicks Course overview video link
    And the user clicks play video
    Then video is playing and playtime more than zero
