@smoke @mobile
Feature: As user I want to get the ability to open profile page after login

  Scenario: Profile page opens after log in
    Given the user logs in coursera app with "Helen" account
    When the user opens profile
    Then the user can see page with the header "Profile" and "Elena Kem" username
