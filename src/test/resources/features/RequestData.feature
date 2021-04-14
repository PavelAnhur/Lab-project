@advanced @web
Feature: As a user I want to get a report of all learner data stored by Coursera about my account on my e-mail

  Scenario: The report with request data should be received to the e-mail address once a day or a message should be
  received that the report has already been sent
    Given the user with "Helen" google account is logged in
    When the user opens account settings
    And the user requests data report
    Then the report received to the e-mail or a message received that the report has already been sent on this day