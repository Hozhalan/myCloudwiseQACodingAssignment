Feature: Verifying the test flow

  Scenario: Verify that the user scenario for second challenge
    Given open cloudwise webpage for second test scenario
    And click on the text search box
    And enter the key value as "bobi"
    Then validate the output
    Then close cloudwise webpage for second test scenario



