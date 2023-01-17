Feature: Deletion in Program module 

@tag1
Scenario: Delete Program by Name
Given A Service with URL to Delete Program By Name
When DELETE request is made for Program by passing Program Name as a parameter
Then the API call is successful for program deletion with status code 200

@tag2
Scenario: Delete Program by incorrect Name
Given A Service with URL to Delete Program By Name
When DELETE request is made for Program by passing Program Name as a parameter
Then the API call results in a bad status code 

@tag3
Scenario: Delete Program by ID
Given A Service with URL (Delete Program)
When DELETE request is made for Program by passing Program ID as a parameter
Then the API call got success for program deletion with status code 200

@tag4
Scenario: Delete Program by passing incorrect ID
Given A Service with URL (Delete Program)
When DELETE request is made for Program by passing Program ID as a parameter
Then the API call gives an error message