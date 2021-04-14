@advanced @mobile
Feature: As a user I want to download video of the course

  Scenario: Video of course has started downloading
    Given the user logs in coursera app with "Vlad" account
    When the user opens course and starts video downloading
    Then the downloading started, course "Основы фотографии" appeared in downloads menu section