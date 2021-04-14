@critical-path @web
Feature: As a user, I want to be sure course partners display correctly

  Scenario: Partner courses are offered by particular partner
    Given the user opens partners page
    When the user selects Big data applications course by Yandex
    Then the course is offered by "Yandex"
