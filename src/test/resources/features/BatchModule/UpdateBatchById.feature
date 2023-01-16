Feature: Update Batch
Scenario Outline: Update Batch
Given A Service URL with URI path
When Put request is made as parameters at Path "<batchId>", "<batchName>", "<batchDescription>", "<batchStatus>", "<batchNoOfClasses>","<programId>","<programName>" are modified
Then Validate response status code
And Validate "batchId", "batchName", "batchDescription", "batchStatus", "batchNoOfClasses","programId","programName"

Examples:
  | batchId     | batchName   |batchDescription  |batchStatus | batchNoOfClasses     |  programId  | programName|
  | 788         |Science Class | Science class       | Active     | 11 | 458 |Jan23-InterfaceStrikers-SDET-100|


