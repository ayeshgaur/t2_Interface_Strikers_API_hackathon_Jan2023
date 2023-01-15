<<<<<<< Updated upstream

Feature: Batch module creation and updation
=======
Feature: Batch module POST,GET and DEl request
>>>>>>> Stashed changes

Scenario Outline: POST/create a batch 
Given A Service with URL (Create Batch)
When POST request is made with parameters at path "<batchName>","<batchDescription>","<batchStatus>","<batchNoOfClasses>","<programId>"
Then validate the status code
And save the batch ID
<<<<<<< Updated upstream

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
=======
Then validate the necessary fields "<batchName>","<batchDescription>","<batchStatus>","<batchNoOfClasses>","<programId>"
Then get the batch details using created batch ID
And validate the necessary fields as "<batchName>","<batchDescription>","<batchStatus>","<batchNoOfClasses>","<programId>"
Then delete the batch Id that is created
And validate the response message


 Examples:
|batchName  |batchDescription|batchStatus|batchNoOfClasses| programId     |               
|Interface Strikers 81  Jan 23| API Testing |Active    | 15|458|
|Interface  Strikers Jan 23|Automation|Active|12|458|
>>>>>>> Stashed changes
