Feature: Search functionality on google

  Scenario: To validate search functionality on Google
    Given I will Launch Google
    When Enter text into search box
    When Hit enter
    Then Expected search result should display
