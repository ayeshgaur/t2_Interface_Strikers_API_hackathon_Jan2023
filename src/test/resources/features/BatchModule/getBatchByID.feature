Feature: get batch 

@tag1
Scenario: To Get All Batches
Given A Service with URL (Get Batch)
When  GET request is made all the batch details will be displayed
Then Validate status code as 200

@tag2
Scenario: To Get Batches by Id
Given A Service with URL (Get Batch)
When  GET request is made with valid batch ID
Then Validate status code as 200 

@tag3
Scenario: To Get Batches by using invalid Id
Given A Service with URL (Get Batch)
When  GET request is made with invalid ID
Then Validate status code and error message

@tag4
Scenario: To Get Batches by Batch Name
Given A Service with URL (Get Batch)
When  GET request is made with Batch Name
Then Validate status code as 200

@tag5
Scenario: To Get Batches by Program Id
Given A Service with URL (Get Batch)
When  GET request is made with Program Id
Then Validate status code as 200