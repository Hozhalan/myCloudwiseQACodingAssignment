Feature: Verifying the test flow

  Scenario: Verify that the user scenario for third challenge
    Given open gatekeeper webpage for third test scenario
    And click on the battle button
    And get the value from popup
    Then verify the selected element is clickable
    Then close gatekeeper webpage for third test scenario

