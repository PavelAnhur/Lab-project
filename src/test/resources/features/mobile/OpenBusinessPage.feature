@smoke @mobile
Feature: As user I want to get the ability to open business page through topics menu

  Scenario: Business page opens through topics menu
    Given the user logs in coursera app with "Helen" account
    When the user opens "Business" page through topics menu
    Then the user can see page with the header and list of topics
      | Finance                   |
      | Business Strategy         |
      | Leadership and Management |
      | Marketing                 |
      | Entrepreneurship          |
      | Business Essentials       |