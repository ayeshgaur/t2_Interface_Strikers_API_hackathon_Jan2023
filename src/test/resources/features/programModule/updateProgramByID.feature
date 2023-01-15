Feature: Program Module

  Scenario Outline: Update Program By ID  and do the necessary validations
    Given  A Service with URL Update Program
    When PUT request is made after updating any of the fields <programName>, <programDescription>, <programStatus> with programId as a parameter
    Then Validate <programId>, <programName>, <programStatus>
    And Validate status code after update
    Examples:
      | programId | programName                         | programDescription   | programStatus |
      | 458       | "Jan23-InterfaceStrikers-SDET-100" | "API" | "inactive"    |
