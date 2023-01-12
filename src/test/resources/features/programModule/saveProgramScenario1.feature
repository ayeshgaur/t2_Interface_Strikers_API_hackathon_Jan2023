Feature: Program
Scenario Outline: Save Program
Given A Service URL with "URIPath" (Save Program)
And Request body at path
When "programName", "programDescription", "creationTime", "lastModTime" are modified
And "Post" request is made
Then validate programId is present in response
And Validate response status code
And Validate "programName", "programDescription", programStatus

Examples:
|URIPath         | programName                  |programDescription|programStatus| creationTime                      | lastModTime
  |"/savePragram"  | "Jan23-EliteForce-SDET-001"  | ""               | "Active"    | "2023-01-07T04:13:00.000+00:00"  | "2023-01-07T04:13:00.000+00:00"

Scenario: Validate Program addition
Given A Service with "URL" (GET Program by Id)
When "Get" request is made
Then Validate status code
And Validate "programName, programDescription, programStatus"