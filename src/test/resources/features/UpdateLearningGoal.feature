@advanced @web
Feature: As a user I want to update my learning goal

  Scenario Outline: Learning goal should be successfully updated
    Given the user with "Vlad" google account is logged in
    When the user updates learning goal with "<Occupation>" profession and "Technology" industry
    Then the occupation goal text is "<Occupation>"
    Examples:
      | Occupation                |
      | Python Developer          |
      | Java Developer / Engineer |
