@critical-path @web
Feature: As a user I want to change password in account settings

  Scenario Outline: Password should be changed successfully
    Given the user with "Helen" google account is logged in
    When the user opens account settings
    And the user changes password <oldPassword> to <newPassword>
    Then the password is successfully updated
    Examples:
      | oldPassword   | newPassword   |
      | "AstyEr14571" | "sdcsdfvf234" |
      | "sdcsdfvf234" | "AstyEr14571" |
