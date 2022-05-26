Feature: Verifying the test flow

  Scenario: Verify that the user scenario for first challenge
    Given open cloudwise webpage for first test scenario
    And enter the first value as "2"
    And enter the second value as "2"
    Then verify the total value
    Then close cloudwise webpage for first test scenario




