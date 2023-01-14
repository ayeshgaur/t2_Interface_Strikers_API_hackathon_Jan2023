
Feature: Batch module creation and updation

Scenario Outline: POST/create a batch 
Given A Service with URL (Create Batch)
When POST request is made with parameters at path "<batchName>","<batchDescription>","<batchStatus>","<batchNoOfClasses>","<programId>"
Then validate the status code
And save the batch ID

 Examples:
|batchName  |batchDescription|batchStatus|batchNoOfClasses| programId     |               
|Interface Striker 0065| API Testing |Active    | 15|458|
|Interface strikeroo 0016|Automation|Active|12|458|

#Scenario: Delete the batch using ID
#Given A Service with URL (Delete Batch)
#And Provide the BatchID to be deleted
#When DELETE request is made
#Then Validate status code

#Scenario: update batcb by ID
#Given 
#When 
#Then 

#Scenario: get batch details using ID
#Given A Service with URL (Get Batch)
#When  GET request is made
#Then Validate status code 