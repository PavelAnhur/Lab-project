@smoke @web
Feature: As a user I want to get ability to view notifications

  Scenario: Notification should opened and contained some text message
    Given the user with "Alex" google account is logged in
    When the user opens notification
    Then the text message "No notifications" or "Нет уведомлений" in notification is displayed