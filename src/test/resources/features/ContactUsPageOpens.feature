@smoke @web
Feature: As a user I want to open contact us page

  Scenario: Contact us page opens, page header is correct
    Given the user opens Coursera website
    When the user clicks contact button
    Then contact us page is opened, page header is "Contact Us"