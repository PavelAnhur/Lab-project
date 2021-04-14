@smoke @mobile
Feature: As a user I want to be able login with Facebook account

  Scenario: Login with Facebook account
    Given the user clicks continue with Facebook button
    When the user enters "qapaveltest@gmail.com" in the email input field
    And enters "asdf123456ASDF" in the password input field
    Then user's email is displayed
