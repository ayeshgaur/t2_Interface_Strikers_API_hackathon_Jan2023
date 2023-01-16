Feature: Deletion in Batch module

@tag1
Scenario: Delete Batch by ID
Given A Service with URL (Delete Batch)
When DELETE request is made by passing ID as a parameter
Then the API call got success with status code 200

@tag2
Scenario: Delete Batch by incorrect ID
Given A Service with URL (Delete Batch)
When DELETE request is made by passing ID as a parameter
Then validate the error message
