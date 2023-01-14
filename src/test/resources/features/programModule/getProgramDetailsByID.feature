Feature: Program Module

Scenario: Get Program details By Program ID

Given  A Service with URL GET Program by Id
When  GET Request is made
Then Validate the ProgramName, Program Description and Program Status for the given Program ID
And Validate status code after execution