Feature: Verifying the test flow

  Background: Begin by contacting the services

  Scenario: Verify that the user mentioned emails in the comment section are in the proper format
    Given open cloudwise webpage
    And go to 'This is cloudwise'
    And go to 'All cloudwisers'
    And go into all the departments
    And get all the user details

