Feature: Login functionality for multiple users

  Scenario Outline: Test login for multiple users
    Given Expand testing UI should be opened "https://practice.expandtesting.com/login"
    When Enter username as "<username>" and password as "<password>"
    Then Home page should display

    Examples: 
      | username | password             |
      | practice | SuperSecretPassword! |
      | Simran   | Sin1234              |
      | Suraj    | Suraj3343            |
