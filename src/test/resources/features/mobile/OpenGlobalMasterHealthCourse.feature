@smoke @mobile
Feature: As a user I want to open Global Master of Public Health course through topics

  Scenario: Course should be opened
    Given the user logs in coursera app with "Vlad" account
    When the user opens "Health" topic
    And the user opens "Global Master of Public Health" topic course
    Then the page is opened, page header has text "Global Master of Public Health"