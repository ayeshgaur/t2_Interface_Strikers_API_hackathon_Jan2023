Feature: Program Module

  Scenario Outline: Get Program details By Program ID

    Given  A Service with URL GET Program by Id
    When  GET Request is made with programID
    And Validate fields <programName>, <programDescription>, <programStatus>
    And Validate status code after execution
    Examples:
      | programName                         | programDescription   | programStatus |
      | "Jan2873-InterfaceStrikers-SDAT500" | "Learn PostgreSql14" | "active"      |