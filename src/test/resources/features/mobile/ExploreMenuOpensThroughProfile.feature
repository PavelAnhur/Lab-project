@smoke @mobile
  Feature: As a user I want to get access to explore menu from profile

    Scenario: Explore page is opened, any course is presented on the page
      Given the user logs in coursera app with "Vlad" account
      When the user opens profile page
      And the user taps start learning
      Then explore menu opens, header is "Explore", any course title is displayed