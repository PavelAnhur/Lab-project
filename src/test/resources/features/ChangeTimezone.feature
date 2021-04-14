@smoke @web
Feature: As a user I want to change a timezone in account settings

  Scenario Outline: Timezone should be changed successfully
    Given the user with "Helen" google account is logged in
    When the user opens account settings
    And the user changes <timezoneOne> to <timezoneTwo>
    Then the timezone is successfully updated
    Examples:
      | timezoneOne | timezoneTwo |
      | "Minsk"     | "Kyiv"      |
      | "Kyiv"      | "Minsk"     |
