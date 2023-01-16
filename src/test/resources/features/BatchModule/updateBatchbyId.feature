Feature: Batch Module

Scenario Outline: Update Batch By ID  and do the necessary validations
Given  A Service with URL Update Batch
When Put request is made as parameters at Path <batchId>, <batchName>, <batchDescription>, <batchStatus>, <batchNoOfClasses>,<programId>,<programName> are modified
Then Validate status code after update

Examples:
| batchId     | batchName   |batchDescription  |batchStatus | batchNoOfClasses     |  programId  | programName|
| "788"         |"Interface strikeroo 109" | "Automation"       | "Active"     | "12" | "458" |"Jan23-InterfaceStrikers-SDET-100"|