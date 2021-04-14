@advanced @web
Feature: Source and Topic type number the same as we selected in checkboxes on the 'Community' page

  Scenario: After selecting all checkboxes the number of topics and source should be equal
    Given the user opens community page
    When the user closes tags filter
    And selects all checkboxes from the left side filter
    Then quantity of topics are equals selected topics