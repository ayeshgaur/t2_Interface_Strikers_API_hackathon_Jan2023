Feature: Program Module

  Scenario Outline: Update Program By programName  and do the necessary validations
    Given  A Service with Url Update Program
    When PUT request is made after updating any of the fields <programName>, <programDescription>, <programStatus> with programName as a parameter
    Then Validate <programName>, <programStatus>
    And Validate status code after update by programName
    Examples:
      | programName                            | programDescription | programStatus |
      | "Jan190545-InterfaceStrikers-SDAT6090" | "API"              | "inactive"    |