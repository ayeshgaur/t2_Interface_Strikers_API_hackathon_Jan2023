	Feature: POST , GET and DEL request are send

Scenario Outline: Create and Save the batch
Given A Service with URL (Create Batch)
When POST request is made with parameters at path <batchName>,<batchDescription>,<batchStatus>,<batchNoOfClasses>,<programId>
Then save BatchID
And validate the necessary fields <batchDescription>,<batchStatus>
And Validate status code for successful batch creation as 201
#Then get the batch created using the batchID and validate the status code
#And delete the batch created  and validate the status code



 Examples:
|batchName  |batchDescription|batchStatus|batchNoOfClasses| programId     |               
|"Interface Strikers "   | "API Testing" |"Active"    | "15"|"458"|
|"Interface Strikers " |"Automation"|"Active"|"12"|"458"|