Feature: get batch 
Scenario: get batch details using ID
Given A Service with URL (Get Batch)
When  GET request is made
Then Validate status code 