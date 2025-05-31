Feature: Registration process

  Background: 
    Given Launch DemoQA "https://web.archive.org/web/20220126121054/https://demoqa.com/automation-practice-form/"

  Scenario Outline: Test registration process with valid data
    When Fill out the form with valid data as follows
      | First Name   | Last Name   | Email   | Gender   | Mob No   | DOB   | Hobbies   | Address   |
      | <First Name> | <Last Name> | <Email> | <Gender> | <Mob No> | <DOB> | <Hobbies> | <Address> |
    And Click on Submit
    Then Registration success

    Examples: 
      | First Name | Last Name  | Email              | Gender | Mob No     | DOB         | Hobbies | Address   |
      | Simran     | Manjarekar | simran@example.com | Female | 2893299103 | 05 Sep 1997 | Reading | Khar east |
      | Ketan      | Manjarekar | ketan@example.com  | Male   | 2277181901 | 05 Mar 2001 | Sports  | Khar east |
