Feature: Program

  Scenario Outline: Create and Save Program
    Given  A Service with URL Save Program
    When  Post request is made with params <programName>, <programDescription>, <programStatus>, creationTime, lastModTime are given
    Then  Save Program ID
    And Validate <programName>, <programDescription>, <programStatus>
    And Validate status code
    Examples:
      | programName                        | programDescription | programStatus |
      | "Jan14-InterfaceStrikers-SDET6090" | "gahdgahghsdsdfS"  | "active"      |


