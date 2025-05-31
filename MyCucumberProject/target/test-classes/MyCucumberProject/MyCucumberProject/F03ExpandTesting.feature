Feature: Check login Fucntionality for expand testing

  Background: 
    Given Launch expand testing url "https://practice.expandtesting.com/login"

  @Pass
  Scenario: Check login functionality with valid details
    When Enter valid username "practice"
    When Enter valid password "SuperSecretPassword!"
    When Click on Login
    Then login should Pass and home page should display

  @Fail
  Scenario: Checklogin functionality with invalid details
    When Enter invalid username "simrn"
    When Enter invalid password "SuperSecretP"
    When Click on Login button
    Then login should fail
