Feature: Verifying the test flow

  Scenario: Verify that the user scenario for fourth challenge
    Given open cloudwise webpage for fourth test scenario
    And switch to iFrame
    And scroll down to bottom of the page
    And get the address field value
    Then verify retrieved address is equal to "Vefabey Sokak, No:16 D:11, 34349, Gayrettepe/Istanbul/Turkey"
    Then close cloudwise webpage for fourth test scenario

