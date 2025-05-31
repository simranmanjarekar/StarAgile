Feature: Login functionality for multiple users

  Scenario Outline: Test login for multiple users
    Given Expand testing UI should be opened "https://practice.expandtesting.com/login"
    When Enter username as "Username" and password as "Password"
    Then Home page should display

    Examples: 
      | Username | Password             |
      | practice | SuperSecretPassword! |
      | Simran   | Simran1234           |
      | Suraj    | Suraj3343            |
