@advanced @mobile
Feature: When I try to approve financial aid the recaptcha displayed

  Scenario: Recaptcha displayed when trying to approve financial aid
    Given the user logs in coursera app with "Pavel" account
    When the user searches for the "Introduce to Java course" course
    And the user clicks on the first result
    And the user tries to make an financial aid
    Then recaptcha is displayed