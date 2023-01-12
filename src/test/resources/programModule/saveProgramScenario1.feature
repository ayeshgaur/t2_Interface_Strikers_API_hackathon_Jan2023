Feature: Program
Scenario: Save Program
Given A Service with URL (Save Program)
And Request body at "path"
When "programName, creationTime, last, ModTime" are modified
And "Post" request is made
Then Save "programId"
And Validate status code
And Validate "programName, programDescription, programStatus"

Scenario: Validate Program addition
Given A Service with "URL" (GET Program by Id)
When "Get" request is made
Then Validate status code
And Validate "programName, programDescription, programStatus"