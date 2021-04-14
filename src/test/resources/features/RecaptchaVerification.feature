@critical-path @web
Feature: As a user I want to get the ability to see recaptcha when trying to sign up

  Scenario: Recaptcha verification
    Given the user opens Coursera website
    When the user signs up
    Then recaptcha appears