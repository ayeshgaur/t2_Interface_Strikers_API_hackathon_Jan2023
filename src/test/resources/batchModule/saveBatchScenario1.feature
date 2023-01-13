
Feature: Batch 

Scenario: Save Batch
Given A Service with URL (Save Batch)
When "batchName, batchDescription, batchStatus" are created with reference to programId
And "Post" request is made
Then Save "batchId"
And Validate status code
And Validate "batchName, batchDescription, batchStatus, batchNoOfClasses, programId, programName"

Scenario: Validate new batch creation
Given A Service with "URL" (batch by Id)
When "Get" request is made
Then Validate status code
And Validate "batchId, batchName, batchDescription, batchStatus, batchNoOfClasses, programId, programName"