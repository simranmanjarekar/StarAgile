Feature: Validate links on Nykaa

  Background: 
    Given Launch Nykaa "https://www.nykaa.com/"

  @Skin
  Scenario: Test Skin link
    When Click on Skin link
    Then Skin page should display

  @MomBaby
  Scenario: Test Mom & Baby link
    When Click mom and baby link
    Then Mom and baby page should display

  @Men
  Scenario: Test Men link
    When Click on Men link
    Then Men page should display
