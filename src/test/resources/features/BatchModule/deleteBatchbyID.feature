Feature: Deletion in Batch module

Scenario: Delete Batch by ID
Given A Service with URL (Delete Batch)
When DELETE request is made by passing ID as a parameter
Then the API call got success with status code 200
