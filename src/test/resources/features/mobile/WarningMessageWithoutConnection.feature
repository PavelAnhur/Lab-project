@advanced @mobile
Feature: As a user I want to see warning message without connection in coursera app

  Scenario: Warning message without connection
    When the user turns off wifi and mobile data connection
    Then the user can see "Please connect and retry" message about lost connection
