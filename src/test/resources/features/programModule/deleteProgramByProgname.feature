Feature: Deletion in Program module By Name

@tag1
Scenario: Delete Program by Name
Given A Service with URL to Delete Program By Name
When DELETE request is made for Program by passing Program Name as a parameter
Then the API call is successful for program deletion with status code 200

@tag2
Scenario: Delete Program by incorrect Name
Given A Service with URL to Delete Program By Name
When DELETE request is made for Program by passing Program Name as a parameter
Then the API call results in a bad status code. 
