@smoke @mobile
Feature: As user I want to get the ability to open explore page through a button on the learn page

  Scenario: Explore menu opens through the button "explore courses" in the learn
    Given the user logs in coursera app with "Helen" account
    When the user goes to explore page
    Then the user can see page with the header "Explore"