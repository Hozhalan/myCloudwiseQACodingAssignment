Feature: Verifying the test flow

  Scenario: Verify that the user scenario for third challenge
    Given open cloudwise webpage for third test scenario
    And click on the battle button
    And get the value from popup
    Then verify the selected element is clickable
    Then close cloudwise webpage for third test scenario

